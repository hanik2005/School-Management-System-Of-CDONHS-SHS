/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import db.MyConnection;
import java.awt.Image;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ADMIN
 */
public class Teacher {

    Connection con = MyConnection.getConnection();
    PreparedStatement ps;
    ResultSet rs;

    public int getMax() {
        int id = 0;
        Statement st;

        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery("select max(teacher_id) from teacher");
            while (rs.next()) {
                id = rs.getInt(1);

            }
        } catch (SQLException ex) {
            System.getLogger(Teacher.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        return id + 1;

    }

    public String getUsername() {
        int id = 0;
        String sql = "SELECT MAX(teacher_id) FROM teacher";

        try (Statement st = con.createStatement(); ResultSet rs = st.executeQuery(sql)) {

            if (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (SQLException ex) {
            System.getLogger(Teacher.class.getName())
                    .log(System.Logger.Level.ERROR, "Error getting max teacher_id", ex);
        }

        // Format: 02-id+1
        return "02-" + (id + 1);
    }

    public boolean isidExist(int id) {
        try {
            ps = con.prepareStatement("select * from teacher where teacher_id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;

            }
        } catch (SQLException ex) {
            System.getLogger(Student.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        return false;

    }

    public boolean isEmailExist(String email, int excludeId) {
        try {
            ps = con.prepareStatement("SELECT * FROM teacher WHERE email = ? AND teacher_id <> ?");
            ps.setString(1, email);
            ps.setInt(2, excludeId);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException ex) {
            System.getLogger(Student.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        return false;
    }

    public boolean isPhoneExist(String phone, int excludeId) {
        try {
            ps = con.prepareStatement("SELECT * FROM teacher WHERE phone_number = ? AND teacher_id <> ?");
            ps.setString(1, phone);
            ps.setInt(2, excludeId);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException ex) {
            System.getLogger(Student.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        return false;
    }

    public void insert(int teacher_id, int user_id, String fname, String midName, String lastName, String date_birth, String gender, String email, String phone, String addressLine1,
            String addressLine2, String imagePath, int strand, String hireDate) {

        String sql = "insert into teacher values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, teacher_id);
            ps.setInt(2, user_id);
            ps.setString(3, fname);
            ps.setString(4, midName);
            ps.setString(5, lastName);
            ps.setString(6, date_birth);
            ps.setString(7, gender);
            ps.setString(8, email);
            ps.setString(9, phone);
            ps.setString(10, addressLine1);
            ps.setString(11, addressLine2);
            ps.setInt(12, strand);
            ps.setString(13, hireDate);
            ps.setString(14, imagePath);

            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "New Teacher added successfully");

            }
        } catch (SQLException ex) {
            System.getLogger(Teacher.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }

    }

    public void update(int teacher_id, String fname, String midName, String lastName, String date_birth, String gender, String email, String phone, String addressLine1,
            String addressLine2, String imagePath, int strand) {
        String sql = "update teacher set first_name=?,middle_name=?,last_name=?,date_of_birth=?,gender=?,email=?,phone_number=?"
                + ",address1=?,address2=?,strand_id=?,image_path=? where teacher_id=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, fname);
            ps.setString(2, midName);
            ps.setString(3, lastName);
            ps.setString(4, date_birth);
            ps.setString(5, gender);
            ps.setString(6, email);
            ps.setString(7, phone);
            ps.setString(8, addressLine1);
            ps.setString(9, addressLine2);
            ps.setInt(10, strand);
            ps.setString(11, imagePath);
            ps.setInt(12, teacher_id);

            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Teacher data updated successfully ");

            }
        } catch (SQLException ex) {
            System.getLogger(Teacher.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }

    }

    public void getTeacherValue(JTable table, String searchValue) {
        String sql = "SELECT t.teacher_id, t.user_id, t.first_name, t.middle_name, t.last_name, "
                + "t.date_of_birth, t.gender, t.email, t.phone_number, t.address1, t.address2, "
                + "s.strand_name, t.hire_date "
                + "FROM teacher t "
                + "LEFT JOIN strands s ON t.strand_id = s.strand_id "
                + "WHERE CONCAT(t.first_name, t.middle_name, t.last_name, t.email, t.phone_number) "
                + "LIKE ? ORDER BY t.teacher_id DESC";

        try (PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, "%" + searchValue + "%");
            ResultSet rs = ps.executeQuery();

            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0); // Clear existing data

            while (rs.next()) {
                Object[] row = new Object[13];
                row[0] = rs.getInt("teacher_id");
                row[1] = rs.getInt("user_id");
                row[2] = rs.getString("first_name");
                row[3] = rs.getString("middle_name");
                row[4] = rs.getString("last_name");
                row[5] = rs.getDate("date_of_birth");
                row[6] = rs.getString("gender");
                row[7] = rs.getString("email");
                row[8] = rs.getString("phone_number");
                row[9] = rs.getString("address1");
                row[10] = rs.getString("address2");
                row[11] = rs.getString("strand_name");
                row[12] = rs.getDate("hire_date");

                model.addRow(row);
            }

        } catch (SQLException ex) {
            System.getLogger(Teacher.class.getName()).log(System.Logger.Level.ERROR, "Error getting teacher data", ex);
        }
    }

    public void delete(int id) {
        int yesOrNo = JOptionPane.showConfirmDialog(null, "teacher records will also be deleted",
                "Student Delete", JOptionPane.OK_CANCEL_OPTION, 0);
        if (yesOrNo == JOptionPane.OK_OPTION) {
            try {
                ps = con.prepareStatement("delete from teacher where teacher_id = ?");
                ps.setInt(1, id);
                if (ps.executeUpdate() > 0) {
                    JOptionPane.showMessageDialog(null, "Teacher data deleted successfully ");

                }
            } catch (SQLException ex) {
                System.getLogger(Teacher.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            }

        }

    }
    public void setInformationStrandDatabase(int teacherId, JTextField strandTxt) {
        try {
            String sql = "SELECT s.strand_name "
                    + "FROM teacher t "
                    + "JOIN strands s ON t.strand_id = s.strand_id "
                    + "WHERE t.teacher_id = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, teacherId);
            rs = ps.executeQuery();

            if (rs.next()) {
                String strandName = rs.getString("strand_name");

                if (strandTxt != null) {
                    strandTxt.setText(strandName);
                }
            }
        } catch (SQLException ex) {
            System.getLogger(Teacher.class.getName())
                    .log(System.Logger.Level.ERROR, "Database error in setInformationStrandDatabase", ex);
        }
    }

    public void loadStudentInformation(int teacherId,
            JTextField idTxt, JTextField nameTxt, JTextField genderTxt, JTextField dateTxt,
            JTextField emailTxt, JTextField phoneTxt,
            JTextField address1Txt, JTextField address2Txt, JTextField hireDate,
            JLabel imagePanel3) {

        String sql = "SELECT * FROM teacher WHERE teacher_id = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, teacherId);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    // Student basic info
                    idTxt.setText(rs.getString("teacher_id"));

                    String middleName = rs.getString("middle_name");
                    String middleInitial = (middleName != null && !middleName.isEmpty())
                            ? middleName.charAt(0) + "."
                            : "";

                    String fullName = rs.getString("first_name") + " "
                            + middleInitial + " "
                            + rs.getString("last_name");
                    nameTxt.setText(fullName.trim());

                    genderTxt.setText(rs.getString("gender"));
                    dateTxt.setText(rs.getString("date_of_birth"));
                    emailTxt.setText(rs.getString("email"));
                    phoneTxt.setText(rs.getString("phone_number"));
                    address1Txt.setText(rs.getString("address1"));

                    String address2 = rs.getString("address2");
                    address2Txt.setText(
                            address2 != null && !address2.isEmpty() ? address2 : "NULL"
                    );
                    hireDate.setText(rs.getString("hire_date"));
                    

                    // File paths
                    String imagePathDB = rs.getString("image_path");

                    // Default assets
                    String defaultImagePath = getClass().getResource("/assets/default.png").getPath();

                    // Profile Image
                    if (imagePathDB != null) {
                        File imgFile = new File(imagePathDB);
                        if (imgFile.exists() && !imgFile.isDirectory()) {
                            imagePanel3.setIcon(imageAdjust(imagePathDB, null, imagePanel3));
                        } else {
                            imagePanel3.setIcon(imageAdjust(defaultImagePath, null, imagePanel3));
                        }
                    } else {
                        imagePanel3.setIcon(imageAdjust(defaultImagePath, null, imagePanel3));
                    }

                 
                }
            }
        } catch (SQLException ex) {
            System.getLogger(Teacher.class.getName()).log(System.Logger.Level.ERROR, "Error loading student information", ex);
        }
    }
    public ImageIcon imageAdjust(String path, byte[] pic, JLabel targetLabel) {
        ImageIcon myImage = null;

        if (path != null) {
            myImage = new ImageIcon(path);
        } else {
            myImage = new ImageIcon(pic);
        }

        Image img = myImage.getImage();
        Image newImage = img.getScaledInstance(
                targetLabel.getWidth(),
                targetLabel.getHeight(),
                Image.SCALE_SMOOTH
        );

        return new ImageIcon(newImage);
    }
}
