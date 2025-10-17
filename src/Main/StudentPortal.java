/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Main;

import model.SubjectGrade;
import db.MyConnection;
import design.BackgroundPanel;
import design.ThemeColors;
import java.awt.BorderLayout;
import java.awt.Color;
import java.text.SimpleDateFormat;
import java.awt.Desktop;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import model.ComboItem;
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;

/**
 *
 * @author ADMIN
 */
public class StudentPortal extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(StudentPortal.class.getName());
    private int studentId;
    Strand strand = new Strand();
    int xx, xy;
    Connection con = MyConnection.getConnection();
    PreparedStatement ps;
    ResultSet rs;
    private int rowIndex;
    private boolean passwordVisible = false;
    private String imagePath;
    Student student = new Student();
    private DefaultTableModel model;
    //Home home = new Home();
    Grade grade = new Grade();
    String imagePathDB;
    String birthCertPathDB;
    String form137PathDB;

    /**
     * Creates new form StudentPortal
     *
     * @param studentId
     */
    public StudentPortal(int studentId) {
        this.studentId = studentId;
        initComponents();
        init();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    public void init() {
        //setBackgroundPanel();
        setTime();
        setDate();
        tableStudentGradeView();
        setEditInformation();
        setEditPasswordInfo();
        setInformationStudentsDatabase();
        setInformationStrandDatabase();
    }

    public void setEditPasswordInfo() {
        try {
            String sql = "SELECT u.password FROM user u JOIN student s ON u.user_id = s.user_id WHERE s.student_id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, studentId);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String password = rs.getString("password");
                stuUserPassword.setText(password);
            }

        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error" + ex);
        }

    }

    public void setEditInformation() {
        try {
            ps = con.prepareStatement("SELECT * FROM student WHERE student_id = ?");
            ps.setInt(1, studentId);
            rs = ps.executeQuery();

            if (rs.next()) {
                stuFname.setText(rs.getString("first_name"));
                stuMiddleName.setText(rs.getString("middle_name"));
                stuLastName.setText(rs.getString("last_name"));
                stuBirth.setDate(rs.getDate("date_of_birth"));
                stuGender.setSelectedItem(rs.getString("gender"));
                stuEmail.setText(rs.getString("email"));
                stuPhone.setText(rs.getString("phone_number"));
                stuMotherName.setText(rs.getString("mother_name"));
                stuFatherName.setText(rs.getString("father_name"));
                stuAddress1.setText(rs.getString("address1"));
                stuAddress2.setText(rs.getString("address2"));
                stuLRN.setText(rs.getString("lrn"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error" + ex);
        }
    }

    public void tableStudentGradeView() {
        model = (DefaultTableModel) GradeViewTable.getModel();
        GradeViewTable.setRowHeight(30);
        GradeViewTable.setShowGrid(true);
        GradeViewTable.setGridColor(Color.black);
        GradeViewTable.setBackground(Color.white);

    }

    public void clearStudent() {
        stuFname.setText(null);
        stuMiddleName.setText(null);
        stuLastName.setText(null);
        stuBirth.setDate(null);
        stuGender.setSelectedIndex(0);
        stuEmail.setText(null);
        stuPhone.setText(null);
        stuFatherName.setText(null);
        stuMotherName.setText(null);
        stuAddress1.setText(null);
        stuAddress2.setText(null);
        stuLRN.setText(null);

    }

    public boolean isEmptyStudent() {
        // First Name
        if (stuFname.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Student First Name is missing");
            return false;
        }
        if (stuFname.getText().length() > 50) {
            JOptionPane.showMessageDialog(this, "First name must not exceed 50 characters");
            return false;
        }

        // Middle Name
        if (stuMiddleName.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Student Middle Name is missing");
            return false;
        }
        if (stuMiddleName.getText().length() > 50) {
            JOptionPane.showMessageDialog(this, "Middle name must not exceed 50 characters");
            return false;
        }

        // Last Name
        if (stuLastName.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Student Last Name is missing");
            return false;
        }
        if (stuLastName.getText().length() > 50) {
            JOptionPane.showMessageDialog(this, "Last name must not exceed 50 characters");
            return false;
        }

        // Date of Birth
        if (stuBirth.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Student date of birth is missing");
            return false;
        }
        if (stuBirth.getDate().compareTo(new Date()) > 0) {
            JOptionPane.showMessageDialog(this, "No Student from the future are allowed");
            return false;
        }

        // Email
        if (stuEmail.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Student email is missing");
            return false;
        }
        if (!stuEmail.getText().matches("^.+@.+\\..+$")) {
            JOptionPane.showMessageDialog(this, "Invalid Email Address");
            return false;
        }
        if (stuEmail.getText().length() > 50) {
            JOptionPane.showMessageDialog(this, "Email must not exceed 50 characters");
            return false;
        }

        // Phone
        if (stuPhone.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Student phone number is missing");
            return false;
        }
        if (!stuPhone.getText().matches("\\d{11}")) {
            JOptionPane.showMessageDialog(this, "Phone number must be exactly 11 digits");
            return false;
        }

        // Mother Name
        if (stuMotherName.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Student Mother Name is missing");
            return false;
        }
        if (stuMotherName.getText().length() > 50) {
            JOptionPane.showMessageDialog(this, "Mother name must not exceed 50 characters");
            return false;
        }

        // Father Name
        if (stuFatherName.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Student Father Name is missing");
            return false;
        }
        if (stuFatherName.getText().length() > 50) {
            JOptionPane.showMessageDialog(this, "Father name must not exceed 50 characters");
            return false;
        }

        // Address1
        if (stuAddress1.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Address Line 1 is missing");
            return false;
        }
        if (stuAddress1.getText().length() > 50) {
            JOptionPane.showMessageDialog(this, "Address Line 1 must not exceed 50 characters");
            return false;
        }

        // Address2
//        if (stuAddress2.getText().isEmpty()) {
//            JOptionPane.showMessageDialog(this, "Address Line 2 is missing");
//            return false;
//        }
//        if (stuAddress2.getText().length() > 50) {
//            JOptionPane.showMessageDialog(this, "Address Line 2 must not exceed 50 characters");
//            return false;
//        }
        // Birth Certificate
//        if (stuBirthCer.getText().isEmpty()) {
//            JOptionPane.showMessageDialog(this, "Birth Certificate path is missing");
//            return false;
//        }
//
//        // Form 137
//        if (stuForm137.getText().isEmpty()) {
//            JOptionPane.showMessageDialog(this, "Form 137 path is missing");
//            return false;
//        }
        // LRN
        if (stuLRN.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "LRN is missing");
            return false;
        }
        if (!stuLRN.getText().matches("\\d{12}")) {
            JOptionPane.showMessageDialog(this, "LRN must be exactly 12 digits");
            return false;
        }

        // Image
//        if (imagePath == null) {
//            JOptionPane.showMessageDialog(this, "Please add your image");
//            return false;
//        }
        return true;
    }

    public boolean check() {
        int id = studentId; // current student ID
        String newEmail = stuEmail.getText().trim();
        String newPhone = stuPhone.getText().trim();

        String oldEmail = "";
        String oldPhone = "";

        try {
            // 🔹 Get existing student info directly from database
            String sql = "SELECT email, phone_number FROM student WHERE student_id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                oldEmail = rs.getString("email");
                oldPhone = rs.getString("phone_number");
            }

            rs.close();
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Database error while checking student info: " + ex.getMessage());
            return true; // stop update if DB error occurs
        }

        // 🔹 Compare with the new input
        if (newEmail.equals(oldEmail) && newPhone.equals(oldPhone)) {
            return false; // nothing changed
        } else {
            if (!newEmail.equals(oldEmail)) {
                boolean emailExists = student.isEmailExist(newEmail, id);
                if (emailExists) {
                    JOptionPane.showMessageDialog(this, "The email already exists.");
                }
                return emailExists;
            }

            if (!newPhone.equals(oldPhone)) {
                boolean phoneExists = student.isPhoneExist(newPhone, id);
                if (phoneExists) {
                    JOptionPane.showMessageDialog(this, "The phone number already exists.");
                }
                return phoneExists;
            }
        }

        return false;
    }

    public void setInformationStrandDatabase() {
        try {
            String sql = "SELECT s.strand_name "
                    + "FROM student_strand ss "
                    + "JOIN strands s ON ss.strand_id = s.strand_id "
                    + "WHERE ss.student_id = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, studentId);
            rs = ps.executeQuery();

            String strandName = null;
            if (rs.next()) {
                strandName = rs.getString("strand_name");
            }

            // Always check if strandTxt is available
            if (strandTxt != null) {
                if (strandName != null && !strandName.isEmpty()) {
                    strandTxt.setText(strandName);
                } else {
                    strandTxt.setText("NULL"); // no record found or empty strand
                }
            }

        } catch (SQLException ex) {
            System.getLogger(StudentPortal.class.getName())
                    .log(System.Logger.Level.ERROR, "Database error in setInformationStrandDatabase", ex);
        }
    }

    public void setInformationStudentsDatabase() {
        try {
            ps = con.prepareStatement("SELECT * FROM student WHERE student_id = ?");
            ps.setInt(1, studentId);
            rs = ps.executeQuery();

            if (rs.next()) {

                IdTxt.setText(rs.getString("student_id"));

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
                motherTxt.setText(rs.getString("mother_name"));
                fatherTxt.setText(rs.getString("father_name"));
                address1Txt.setText(rs.getString("address1"));

                String address2 = rs.getString("address2");
                address2Txt.setText(address2 != null && !address2.isEmpty() ? address2 : "NULL");

                stuLrn.setText(rs.getString("LRN"));

                imagePathDB = rs.getString("image_path");
                birthCertPathDB = rs.getString("birth_certificate");
                form137PathDB = rs.getString("form_137");
                String defaultImagePath = getClass().getResource("/assets/default.png").getPath();
                String existPdfImage = getClass().getResource("/assets/pdf.png").getPath();

                // Profile Image
                if (imagePathDB != null) {
                    File imgFile = new File(imagePathDB);
                    if (imgFile.exists() && !imgFile.isDirectory()) {
                        imagePanel.setIcon(imageAdjust(imagePathDB, null, imagePanel));
                    } else {
                        imagePanel.setIcon(imageAdjust(defaultImagePath, null, imagePanel));
                    }
                } else {
                    imagePanel.setIcon(imageAdjust(defaultImagePath, null, imagePanel));
                }

                // Birth Certificate
                if (birthCertPathDB != null && birthCertPathDB.toLowerCase().endsWith(".pdf")) {
                    imagePanel1.setIcon(imageAdjust(existPdfImage, null, imagePanel1));
                } else {
                    imagePanel1.setIcon(imageAdjust(defaultImagePath, null, imagePanel1));
                }

                // Form 137
                if (form137PathDB != null && form137PathDB.toLowerCase().endsWith(".pdf")) {
                    imagePanel2.setIcon(imageAdjust(existPdfImage, null, imagePanel2));
                } else {
                    imagePanel2.setIcon(imageAdjust(defaultImagePath, null, imagePanel2));
                }

            }

        } catch (SQLException ex) {
            System.getLogger(StudentPortal.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }

    public void displayStudentGrades(int studentId, int quarter, int gradeLevel) {

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtTime = new javax.swing.JLabel();
        txtDate = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        logStuBt = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        IdTxt = new javax.swing.JTextField();
        nameTxt = new javax.swing.JTextField();
        dateTxt = new javax.swing.JTextField();
        genderTxt = new javax.swing.JTextField();
        emailTxt = new javax.swing.JTextField();
        phoneTxt = new javax.swing.JTextField();
        fatherTxt = new javax.swing.JTextField();
        motherTxt = new javax.swing.JTextField();
        address1Txt = new javax.swing.JTextField();
        address2Txt = new javax.swing.JTextField();
        strandTxt = new javax.swing.JTextField();
        stuLrn = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        birthPanel = new javax.swing.JPanel();
        imagePanel1 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        formPanel = new javax.swing.JPanel();
        imagePanel2 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        imagePanel = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        stuFname = new javax.swing.JTextField();
        stuMotherName = new javax.swing.JTextField();
        stuAddress1 = new javax.swing.JTextField();
        stuAddress2 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        stuBirth = new com.toedter.calendar.JDateChooser();
        jLabel62 = new javax.swing.JLabel();
        stuGender = new javax.swing.JComboBox<>();
        jLabel63 = new javax.swing.JLabel();
        stuEmail = new javax.swing.JTextField();
        jLabel64 = new javax.swing.JLabel();
        stuPhone = new javax.swing.JTextField();
        jLabel65 = new javax.swing.JLabel();
        stuFatherName = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        stuMiddleName = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        stuLastName = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        stuLRN = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        stuUserPassword = new javax.swing.JPasswordField();
        eyeImageBt = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        updateBt = new javax.swing.JButton();
        Clear = new javax.swing.JButton();
        jPanel25 = new javax.swing.JPanel();
        jPanel24 = new javax.swing.JPanel();
        jPanel29 = new javax.swing.JPanel();
        jPanel43 = new javax.swing.JPanel();
        stuGradeStudentSearchBt = new javax.swing.JButton();
        jLabel75 = new javax.swing.JLabel();
        gradeLevelStudentBox = new javax.swing.JComboBox<>();
        quarterStudentBox = new javax.swing.JComboBox<>();
        jLabel77 = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        strandStudentBox = new javax.swing.JComboBox<>();
        jPanel45 = new javax.swing.JPanel();
        gradeStudentLogout = new javax.swing.JButton();
        gradeStudentClear = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        GradeViewTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(243, 244, 246));

        jPanel3.setBackground(new java.awt.Color(30, 58, 138));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel3MouseDragged(evt);
            }
        });
        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel3MousePressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 43)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("STUDENT PORTAL");

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/logo_resized_50x50.jpg"))); // NOI18N

        txtTime.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        txtTime.setForeground(new java.awt.Color(255, 255, 255));

        txtDate.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        txtDate.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 793, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtDate, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE))
                .addGap(54, 54, 54)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(96, 96, 96))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel17)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtTime, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setForeground(new java.awt.Color(0, 0, 0));
        jTabbedPane1.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jTabbedPane1.setPreferredSize(new java.awt.Dimension(1380, 652));

        jPanel2.setBackground(new java.awt.Color(30, 58, 138));

        jPanel4.setBackground(new java.awt.Color(243, 244, 246));
        jPanel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(55, 65, 81), 4, true));
        jPanel4.setForeground(new java.awt.Color(0, 0, 0));

        logStuBt.setBackground(new java.awt.Color(251, 191, 36));
        logStuBt.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        logStuBt.setForeground(new java.awt.Color(0, 0, 0));
        logStuBt.setText("Logout");
        logStuBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logStuBtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(526, 526, 526)
                .addComponent(logStuBt, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(logStuBt, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(243, 244, 246));
        jPanel7.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(55, 65, 81), 4, true));
        jPanel7.setForeground(new java.awt.Color(0, 0, 0));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("ID:");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Name:");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Gender:");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Email:");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Mother Name:");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Phone Number:");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Father Name:");

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Address Line 1: ");

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Address Line 2: ");

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("Strand:");

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Date of Birth:");

        IdTxt.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        IdTxt.setEnabled(false);

        nameTxt.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        nameTxt.setEnabled(false);

        dateTxt.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        dateTxt.setEnabled(false);

        genderTxt.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        genderTxt.setEnabled(false);

        emailTxt.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        emailTxt.setEnabled(false);

        phoneTxt.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        phoneTxt.setEnabled(false);

        fatherTxt.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        fatherTxt.setEnabled(false);

        motherTxt.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        motherTxt.setEnabled(false);

        address1Txt.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        address1Txt.setEnabled(false);

        address2Txt.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        address2Txt.setEnabled(false);

        strandTxt.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        strandTxt.setEnabled(false);

        stuLrn.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        stuLrn.setEnabled(false);

        jLabel19.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 0, 0));
        jLabel19.setText("LRN:");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(address1Txt))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(motherTxt))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fatherTxt))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(phoneTxt))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(emailTxt))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(genderTxt))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(IdTxt))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dateTxt))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(address2Txt))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel19))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(stuLrn)
                            .addComponent(strandTxt))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(IdTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(nameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(dateTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(genderTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(emailTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(phoneTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addComponent(fatherTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(motherTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(address1Txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(address2Txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(strandTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(stuLrn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(70, Short.MAX_VALUE))
        );

        jPanel14.setBackground(new java.awt.Color(243, 244, 246));
        jPanel14.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(55, 65, 81), 4, true));
        jPanel14.setForeground(new java.awt.Color(0, 0, 0));

        birthPanel.setBackground(new java.awt.Color(204, 204, 204));
        birthPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(55, 65, 81), 2, true));

        imagePanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imagePanel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout birthPanelLayout = new javax.swing.GroupLayout(birthPanel);
        birthPanel.setLayout(birthPanelLayout);
        birthPanelLayout.setHorizontalGroup(
            birthPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, birthPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(imagePanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        birthPanelLayout.setVerticalGroup(
            birthPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imagePanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setText("Birth Certificate");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
                .addComponent(birthPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(birthPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel16.setBackground(new java.awt.Color(243, 244, 246));
        jPanel16.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(55, 65, 81), 4, true));
        jPanel16.setForeground(new java.awt.Color(0, 0, 0));

        formPanel.setBackground(new java.awt.Color(204, 204, 204));
        formPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(55, 65, 81), 2, true));

        imagePanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imagePanel2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout formPanelLayout = new javax.swing.GroupLayout(formPanel);
        formPanel.setLayout(formPanelLayout);
        formPanelLayout.setHorizontalGroup(
            formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imagePanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        formPanelLayout.setVerticalGroup(
            formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imagePanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE)
        );

        jLabel16.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setText("Form 137");

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(formPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addGap(0, 212, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(formPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel18.setBackground(new java.awt.Color(243, 244, 246));
        jPanel18.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(55, 65, 81), 4, true));
        jPanel18.setForeground(new java.awt.Color(0, 0, 0));

        jPanel19.setBackground(new java.awt.Color(204, 204, 204));
        jPanel19.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(55, 65, 81), 2, true));

        imagePanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imagePanelMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                imagePanelMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(imagePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imagePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
        );

        jLabel18.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 0, 0));
        jLabel18.setText("Profile Image");

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Student Information", jPanel2);

        jPanel5.setBackground(new java.awt.Color(30, 58, 138));

        jPanel6.setBackground(new java.awt.Color(243, 244, 246));
        jPanel6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(55, 65, 81), 4, true));
        jPanel6.setForeground(new java.awt.Color(0, 0, 0));

        stuFname.setBackground(java.awt.Color.white);
        stuFname.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        stuFname.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(30, 58, 138)));

        stuMotherName.setBackground(java.awt.Color.white);
        stuMotherName.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        stuMotherName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(30, 58, 138)));
        stuMotherName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stuMotherNameActionPerformed(evt);
            }
        });

        stuAddress1.setBackground(java.awt.Color.white);
        stuAddress1.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        stuAddress1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(30, 58, 138)));

        stuAddress2.setBackground(java.awt.Color.white);
        stuAddress2.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        stuAddress2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(30, 58, 138)));
        stuAddress2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stuAddress2ActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(17, 24, 39));
        jLabel14.setText("First Name");

        jLabel20.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(17, 24, 39));
        jLabel20.setText("Mother's Name");

        jLabel21.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(17, 24, 39));
        jLabel21.setText("Address Line 1");

        jLabel22.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(17, 24, 39));
        jLabel22.setText("Address Line 2");

        jLabel61.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel61.setForeground(new java.awt.Color(17, 24, 39));
        jLabel61.setText("Date Of Birth");

        stuBirth.setBackground(java.awt.Color.white);
        stuBirth.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(30, 58, 138)));
        stuBirth.setDateFormatString("yyyy-MM-dd");

        jLabel62.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel62.setForeground(new java.awt.Color(17, 24, 39));
        jLabel62.setText("Gender");

        stuGender.setBackground(new java.awt.Color(204, 204, 204));
        stuGender.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        stuGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));
        stuGender.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(30, 58, 138)));
        stuGender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stuGenderActionPerformed(evt);
            }
        });

        jLabel63.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel63.setForeground(new java.awt.Color(17, 24, 39));
        jLabel63.setText("Email");

        stuEmail.setBackground(java.awt.Color.white);
        stuEmail.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        stuEmail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(30, 58, 138)));

        jLabel64.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel64.setForeground(new java.awt.Color(17, 24, 39));
        jLabel64.setText("Phone Number");

        stuPhone.setBackground(java.awt.Color.white);
        stuPhone.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        stuPhone.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(30, 58, 138)));
        stuPhone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                stuPhoneKeyTyped(evt);
            }
        });

        jLabel65.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel65.setForeground(new java.awt.Color(17, 24, 39));
        jLabel65.setText("Father's Name");

        stuFatherName.setBackground(java.awt.Color.white);
        stuFatherName.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        stuFatherName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(30, 58, 138)));
        stuFatherName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stuFatherNameActionPerformed(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(17, 24, 39));
        jLabel25.setText("Middle Name");

        stuMiddleName.setBackground(java.awt.Color.white);
        stuMiddleName.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        stuMiddleName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(30, 58, 138)));

        jLabel26.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(17, 24, 39));
        jLabel26.setText("Last Name");

        stuLastName.setBackground(java.awt.Color.white);
        stuLastName.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        stuLastName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(30, 58, 138)));

        jLabel28.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(17, 24, 39));
        jLabel28.setText("LRN");

        stuLRN.setBackground(java.awt.Color.white);
        stuLRN.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        stuLRN.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(30, 58, 138)));
        stuLRN.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                stuLRNKeyTyped(evt);
            }
        });

        jLabel29.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(17, 24, 39));
        jLabel29.setText("User Password");

        stuUserPassword.setBackground(new java.awt.Color(255, 255, 255));
        stuUserPassword.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        stuUserPassword.setForeground(new java.awt.Color(0, 0, 0));

        eyeImageBt.setForeground(new java.awt.Color(0, 0, 0));
        eyeImageBt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/NotVisible (2).png"))); // NOI18N
        eyeImageBt.setText("jLabel6");
        eyeImageBt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                eyeImageBtMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                eyeImageBtMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(stuMotherName, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(stuAddress1, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel63)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(stuEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel64, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(stuPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel65, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(stuFatherName, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(stuAddress2, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(31, 31, 31)))
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(stuFname, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(stuMiddleName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(stuLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel28)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(stuLRN, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel61)
                            .addComponent(jLabel62, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(stuGender, 0, 133, Short.MAX_VALUE)
                            .addComponent(stuBirth, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(stuUserPassword)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(eyeImageBt, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(stuFname)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(stuMiddleName)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(stuLastName)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel61)
                    .addComponent(stuBirth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel62, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stuGender, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel63)
                    .addComponent(stuEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel64)
                    .addComponent(stuPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel65)
                    .addComponent(stuFatherName, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20)
                    .addComponent(stuMotherName, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21)
                    .addComponent(stuAddress1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22)
                    .addComponent(stuAddress2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel28)
                    .addComponent(stuLRN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(eyeImageBt)
                    .addComponent(stuUserPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel8.setBackground(new java.awt.Color(243, 244, 246));
        jPanel8.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(55, 65, 81), 4, true));

        jButton1.setBackground(new java.awt.Color(251, 191, 36));
        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setText("Logout");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton1MouseExited(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        updateBt.setBackground(new java.awt.Color(251, 191, 36));
        updateBt.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        updateBt.setForeground(new java.awt.Color(0, 0, 0));
        updateBt.setText("Update");
        updateBt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                updateBtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                updateBtMouseExited(evt);
            }
        });
        updateBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtActionPerformed(evt);
            }
        });

        Clear.setBackground(new java.awt.Color(251, 191, 36));
        Clear.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        Clear.setForeground(new java.awt.Color(0, 0, 0));
        Clear.setText("Clear");
        Clear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ClearMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ClearMouseExited(evt);
            }
        });
        Clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addComponent(updateBt, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(Clear, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(137, 137, 137))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Clear, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(updateBt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(42, 42, 42))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(443, 443, 443)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(53, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Edit Information", jPanel5);

        jPanel24.setBackground(new java.awt.Color(243, 244, 246));

        jPanel29.setBackground(new java.awt.Color(243, 244, 246));
        jPanel29.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(55, 65, 81), 4, true));
        jPanel29.setForeground(new java.awt.Color(0, 0, 0));

        jPanel43.setBackground(new java.awt.Color(243, 244, 246));
        jPanel43.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(55, 65, 81), 4, true));
        jPanel43.setForeground(new java.awt.Color(0, 0, 0));

        stuGradeStudentSearchBt.setBackground(new java.awt.Color(251, 191, 36));
        stuGradeStudentSearchBt.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        stuGradeStudentSearchBt.setForeground(new java.awt.Color(0, 0, 0));
        stuGradeStudentSearchBt.setText("Search");
        stuGradeStudentSearchBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stuGradeStudentSearchBtActionPerformed(evt);
            }
        });

        jLabel75.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel75.setForeground(new java.awt.Color(0, 0, 0));
        jLabel75.setText("Grade Level");

        gradeLevelStudentBox.setBackground(new java.awt.Color(255, 255, 255));
        gradeLevelStudentBox.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        gradeLevelStudentBox.setForeground(new java.awt.Color(0, 0, 0));
        gradeLevelStudentBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "11", "12" }));
        gradeLevelStudentBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gradeLevelStudentBoxActionPerformed(evt);
            }
        });

        quarterStudentBox.setBackground(new java.awt.Color(255, 255, 255));
        quarterStudentBox.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        quarterStudentBox.setForeground(new java.awt.Color(0, 0, 0));
        quarterStudentBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quarterStudentBoxActionPerformed(evt);
            }
        });

        jLabel77.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel77.setForeground(new java.awt.Color(0, 0, 0));
        jLabel77.setText("Quarter");

        jLabel81.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel81.setForeground(new java.awt.Color(17, 24, 39));
        jLabel81.setText("Strand");

        strandStudentBox.setBackground(new java.awt.Color(255, 255, 255));
        strandStudentBox.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        strandStudentBox.setForeground(new java.awt.Color(0, 0, 0));
        strandStudentBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                strandStudentBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel43Layout = new javax.swing.GroupLayout(jPanel43);
        jPanel43.setLayout(jPanel43Layout);
        jPanel43Layout.setHorizontalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel43Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel75)
                    .addComponent(gradeLevelStudentBox, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(strandStudentBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel43Layout.createSequentialGroup()
                        .addComponent(jLabel81)
                        .addGap(190, 190, 190)))
                .addGap(30, 30, 30)
                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(quarterStudentBox, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel77, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(73, 73, 73)
                .addComponent(stuGradeStudentSearchBt, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel43Layout.setVerticalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel43Layout.createSequentialGroup()
                .addComponent(stuGradeStudentSearchBt, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel43Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel43Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel81)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(strandStudentBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel43Layout.createSequentialGroup()
                        .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel75)
                            .addComponent(jLabel77))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(gradeLevelStudentBox)
                            .addComponent(quarterStudentBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        jPanel45.setBackground(new java.awt.Color(243, 244, 246));
        jPanel45.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(55, 65, 81), 4, true));

        gradeStudentLogout.setBackground(new java.awt.Color(251, 191, 36));
        gradeStudentLogout.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        gradeStudentLogout.setForeground(new java.awt.Color(0, 0, 0));
        gradeStudentLogout.setText("Logout");
        gradeStudentLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gradeStudentLogoutActionPerformed(evt);
            }
        });

        gradeStudentClear.setBackground(new java.awt.Color(251, 191, 36));
        gradeStudentClear.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        gradeStudentClear.setForeground(new java.awt.Color(0, 0, 0));
        gradeStudentClear.setText("Clear");
        gradeStudentClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gradeStudentClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel45Layout = new javax.swing.GroupLayout(jPanel45);
        jPanel45.setLayout(jPanel45Layout);
        jPanel45Layout.setHorizontalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel45Layout.createSequentialGroup()
                .addContainerGap(445, Short.MAX_VALUE)
                .addComponent(gradeStudentClear, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(gradeStudentLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(536, 536, 536))
        );
        jPanel45Layout.setVerticalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel45Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(gradeStudentLogout, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                    .addComponent(gradeStudentClear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        GradeViewTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Subjects", "Grade"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(GradeViewTable);

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel29Layout.createSequentialGroup()
                        .addComponent(jPanel45, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel29Layout.createSequentialGroup()
                        .addComponent(jScrollPane5)
                        .addGap(7, 7, 7))
                    .addGroup(jPanel29Layout.createSequentialGroup()
                        .addComponent(jPanel43, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel43, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 392, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel45, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1384, Short.MAX_VALUE)
            .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel25Layout.createSequentialGroup()
                    .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 617, Short.MAX_VALUE)
            .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Grade Viewer", jPanel25);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1384, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel3MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xx, y - xy);
    }//GEN-LAST:event_jPanel3MouseDragged

    private void jPanel3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MousePressed
        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_jPanel3MousePressed

    private void logStuBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logStuBtActionPerformed
        //qrScanTimer.stop();

        int a = JOptionPane.showConfirmDialog(this, "Do you want to Logout now?", "Select", JOptionPane.YES_NO_OPTION);
        if (a == 0) {
            this.dispose();
            LoginFrame frame = new LoginFrame();
            frame.setVisible(true);
            frame.setLocationRelativeTo(null);
        }

    }//GEN-LAST:event_logStuBtActionPerformed

    private void imagePanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imagePanelMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_imagePanelMousePressed

    private void imagePanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imagePanelMouseClicked

    }//GEN-LAST:event_imagePanelMouseClicked

    private void imagePanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imagePanel1MouseClicked
        openPdfFile(birthCertPathDB);
    }//GEN-LAST:event_imagePanel1MouseClicked

    private void imagePanel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imagePanel2MouseClicked
        openPdfFile(form137PathDB);
    }//GEN-LAST:event_imagePanel2MouseClicked

    private void stuGradeStudentSearchBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stuGradeStudentSearchBtActionPerformed
        try {
            String gradeLevelStr = gradeLevelStudentBox.getSelectedItem().toString();
            int gradeLevel = Integer.parseInt(gradeLevelStr.split(" - ")[0]);

            int studentId = this.studentId;
            int quarter = Integer.parseInt(quarterStudentBox.getSelectedItem().toString());
            int strandId = getSelectedStudentStrandId(); // ✅ make sure this gets the numeric strand_id

            // ✅ Fetch both current + archived subjects and grades
            DefaultTableModel model = student.getStudentSubjectGrades(studentId, strandId, gradeLevel, quarter);

            GradeViewTable.setModel(model);

            if (model.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "No grades found for this strand or quarter.");
            } else {
                JOptionPane.showMessageDialog(this, "✅ Grade list generated successfully!");
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error fetching student grades: " + e.getMessage());
        }
    }//GEN-LAST:event_stuGradeStudentSearchBtActionPerformed

    private void gradeLevelStudentBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gradeLevelStudentBoxActionPerformed
        try {
            int gradeLevel = Integer.parseInt(gradeLevelStudentBox.getSelectedItem().toString());

            loadQuarters(quarterStudentBox);

            strand.loadStrands(strandStudentBox, gradeLevel);

            if (strandStudentBox.getItemCount() > 0) {
                int strandId = getSelectedStudentStrandId();

            }

        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error loading strands/sections/subjects.");
        }


    }//GEN-LAST:event_gradeLevelStudentBoxActionPerformed

    private void quarterStudentBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quarterStudentBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_quarterStudentBoxActionPerformed

    private void gradeStudentLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gradeStudentLogoutActionPerformed
        //LOGOUT
        int a = JOptionPane.showConfirmDialog(this, "Do you want to Logout now?", "Select", JOptionPane.YES_NO_OPTION);
        if (a == 0) {
            this.dispose();
            LoginFrame frame = new LoginFrame();
            frame.setVisible(true);
            frame.setLocationRelativeTo(null);
        }
    }//GEN-LAST:event_gradeStudentLogoutActionPerformed

    private void gradeStudentClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gradeStudentClearActionPerformed
        //clearListGrade();
    }//GEN-LAST:event_gradeStudentClearActionPerformed

    private void strandStudentBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_strandStudentBoxActionPerformed


    }//GEN-LAST:event_strandStudentBoxActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        for (double i = 0.1; i <= 1.0; i += 0.1) {
            String s = i + "";
            float f = Float.valueOf(s);
            this.setOpacity(f);
            try {
                Thread.sleep(40);
            } catch (InterruptedException ex) {
                System.getLogger(Home.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            }
        }
    }//GEN-LAST:event_formWindowOpened

    private void stuMotherNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stuMotherNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_stuMotherNameActionPerformed

    private void stuAddress2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stuAddress2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_stuAddress2ActionPerformed

    private void stuGenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stuGenderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_stuGenderActionPerformed

    private void stuPhoneKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_stuPhoneKeyTyped
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_stuPhoneKeyTyped

    private void stuFatherNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stuFatherNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_stuFatherNameActionPerformed

    private void stuLRNKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_stuLRNKeyTyped
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_stuLRNKeyTyped

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked

    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseEntered

        jButton1.setBackground(ThemeColors.DEEP_ORANGE);
    }//GEN-LAST:event_jButton1MouseEntered

    private void jButton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseExited
        // TODO add your handling code here:
        jButton1.setBackground(ThemeColors.GOLDEN_YELLOW);
    }//GEN-LAST:event_jButton1MouseExited

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //qrScanTimer.stop();

        int a = JOptionPane.showConfirmDialog(this, "Do you want to Logout now?", "Select", JOptionPane.YES_NO_OPTION);
        if (a == 0) {
            this.dispose();
            LoginFrame frame = new LoginFrame();
            frame.setVisible(true);
            frame.setLocationRelativeTo(null);
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void updateBtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateBtMouseEntered
        updateBt.setBackground(ThemeColors.DEEP_ORANGE);
    }//GEN-LAST:event_updateBtMouseEntered

    private void updateBtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateBtMouseExited
        updateBt.setBackground(ThemeColors.GOLDEN_YELLOW);
    }//GEN-LAST:event_updateBtMouseExited

    private void updateBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtActionPerformed
        if (isEmptyStudent()) {
            int id = studentId;
            if (student.isidExist(id)) {
                if (!check()) {
                    String sfname = stuFname.getText();
                    String sMidName = stuMiddleName.getText();
                    String sLastName = stuLastName.getText();
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    String date = dateFormat.format(stuBirth.getDate());
                    String gender = stuGender.getSelectedItem().toString();
                    String email = stuEmail.getText();
                    String phone = stuPhone.getText();
                    String motherName = stuMotherName.getText();
                    String fatherName = stuFatherName.getText();
                    String addressLine1 = stuAddress1.getText();
                    String addressLine2 = stuAddress2.getText();
                    String stuLrn = stuLRN.getText();
                    String password = new String(stuUserPassword.getPassword());
                    student.updateOnlyStudent(id, sfname, sMidName, sLastName, date, gender, email, phone,
                            motherName, fatherName, addressLine1, addressLine2, stuLrn);
                    User user = new User();
                    user.updatePasswordOfStudent(studentId, password);


                }

            } else {
                JOptionPane.showMessageDialog(this, "student id doesn't exist");

            }

        }
    }//GEN-LAST:event_updateBtActionPerformed

    private void ClearMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ClearMouseEntered
        Clear.setBackground(ThemeColors.DEEP_ORANGE);
    }//GEN-LAST:event_ClearMouseEntered

    private void ClearMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ClearMouseExited
        Clear.setBackground(ThemeColors.GOLDEN_YELLOW);
    }//GEN-LAST:event_ClearMouseExited

    private void ClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearActionPerformed
        clearStudent();
    }//GEN-LAST:event_ClearActionPerformed

    private void eyeImageBtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eyeImageBtMouseClicked
        if (passwordVisible) {
            // Hide password again
            stuUserPassword.setEchoChar('•'); // bullet char
            eyeImageBt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/NotVisible (2).png")));
            passwordVisible = false;
        } else {
            // Show password
            stuUserPassword.setEchoChar((char) 0); // 0 means no masking
            eyeImageBt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/visible-eye-svgrepo-com.png")));
            passwordVisible = true;
        }
    }//GEN-LAST:event_eyeImageBtMouseClicked

    private void eyeImageBtMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eyeImageBtMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_eyeImageBtMousePressed

    public int getSelectedStudentStrandId() {
        ComboItem selectedItem = (ComboItem) strandStudentBox.getSelectedItem();
        if (selectedItem != null) {
            return selectedItem.getId(); // assuming ComboItem has getId()
        }
        return -1; // or handle appropriately if nothing is selected
    }

    private void openPdfFile(String fileName) {
        try {
            if (fileName != null) {
                // Always prepend DOCUMENTATION folder
                String baseDir = "D:\\DOCUMENTATION\\";
                File pdfFile = new File(baseDir + fileName);

                if (pdfFile.exists() && pdfFile.isFile() && fileName.toLowerCase().endsWith(".pdf")) {
                    Desktop.getDesktop().open(pdfFile); // opens in default PDF reader
                } else {
                    JOptionPane.showMessageDialog(null,
                            "PDF file not found in D:\\DOCUMENTATION\\");
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Unable to open file: " + e.getMessage());
        }
    }

    public void setTime() {
        javax.swing.Timer timer = new javax.swing.Timer(1000, e -> {
            java.util.Date date = new java.util.Date();
            java.text.SimpleDateFormat tf = new java.text.SimpleDateFormat("hh:mm:ss a");
            txtTime.setText(tf.format(date));
        });
        timer.start();
    }

    public void setDate() {
        java.util.Date date = new java.util.Date();
        // EEEE = full day name (e.g., Thursday)
        java.text.SimpleDateFormat df = new java.text.SimpleDateFormat("EEEE, MMMM dd, yyyy");
        txtDate.setText(df.format(date));
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

    public void loadQuarters(JComboBox<String> quarterBox) {
        quarterBox.removeAllItems();
        quarterBox.addItem("1");
        quarterBox.addItem("2");
        quarterBox.addItem("3");
        quarterBox.addItem("4");
    }

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Clear;
    private javax.swing.JTable GradeViewTable;
    private javax.swing.JTextField IdTxt;
    private javax.swing.JTextField address1Txt;
    private javax.swing.JTextField address2Txt;
    private javax.swing.JPanel birthPanel;
    private javax.swing.JTextField dateTxt;
    private javax.swing.JTextField emailTxt;
    private javax.swing.JLabel eyeImageBt;
    private javax.swing.JTextField fatherTxt;
    private javax.swing.JPanel formPanel;
    private javax.swing.JTextField genderTxt;
    private javax.swing.JComboBox<String> gradeLevelStudentBox;
    private javax.swing.JButton gradeStudentClear;
    private javax.swing.JButton gradeStudentLogout;
    private javax.swing.JLabel imagePanel;
    private javax.swing.JLabel imagePanel1;
    private javax.swing.JLabel imagePanel2;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel43;
    private javax.swing.JPanel jPanel45;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton logStuBt;
    private javax.swing.JTextField motherTxt;
    private javax.swing.JTextField nameTxt;
    private javax.swing.JTextField phoneTxt;
    private javax.swing.JComboBox<String> quarterStudentBox;
    private javax.swing.JComboBox<String> strandStudentBox;
    private javax.swing.JTextField strandTxt;
    private javax.swing.JTextField stuAddress1;
    private javax.swing.JTextField stuAddress2;
    private com.toedter.calendar.JDateChooser stuBirth;
    private javax.swing.JTextField stuEmail;
    private javax.swing.JTextField stuFatherName;
    private javax.swing.JTextField stuFname;
    private javax.swing.JComboBox<String> stuGender;
    private javax.swing.JButton stuGradeStudentSearchBt;
    private javax.swing.JTextField stuLRN;
    private javax.swing.JTextField stuLastName;
    private javax.swing.JTextField stuLrn;
    private javax.swing.JTextField stuMiddleName;
    private javax.swing.JTextField stuMotherName;
    private javax.swing.JTextField stuPhone;
    private javax.swing.JPasswordField stuUserPassword;
    private javax.swing.JLabel txtDate;
    private javax.swing.JLabel txtTime;
    private javax.swing.JButton updateBt;
    // End of variables declaration//GEN-END:variables
}
