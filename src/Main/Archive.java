/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import db.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.*;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ADMIN
 */
public class Archive {

    Connection con = MyConnection.getConnection();
    PreparedStatement ps;

    public boolean archiveStudentStrand(int studentId, int currentStrandId, int newStrandId, int currentGradeLevel, int newGradeLevel) {
        String reason = (currentStrandId != newStrandId) ? "TRANSFER" : "PROMOTION";

        String sqlInsert = "INSERT INTO archived_student_strand (student_id, strand_id, grade_level, section_id, reason, date_archived) "
                + "SELECT student_id, strand_id, grade_level, section_id, ?, NOW() "
                + "FROM student_strand WHERE student_id = ? AND strand_id = ? AND grade_level = ?";

        try (PreparedStatement psInsert = con.prepareStatement(sqlInsert)) {
            psInsert.setString(1, reason);
            psInsert.setInt(2, studentId);
            psInsert.setInt(3, currentStrandId);
            psInsert.setInt(4, currentGradeLevel);
            int inserted = psInsert.executeUpdate();

            if (inserted > 0) {
                if (reason.equals("TRANSFER")) {
                    // For transfer, delete the old strand record
                    String sqlDelete = "DELETE FROM student_strand WHERE student_id = ? AND strand_id = ? AND grade_level = ?";
                    try (PreparedStatement psDelete = con.prepareStatement(sqlDelete)) {
                        psDelete.setInt(1, studentId);
                        psDelete.setInt(2, currentStrandId);
                        psDelete.setInt(3, currentGradeLevel);
                        psDelete.executeUpdate();
                    }
                }
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateStudentGradeLevel(int studentId, int newGradeLevel, int sectionId) {
        // No need to convert section name to ID since we already have sectionId
        String sql = "UPDATE student_strand SET grade_level = ?, section_id = ? WHERE student_id = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, newGradeLevel);
            ps.setInt(2, sectionId); // directly use the provided sectionId
            ps.setInt(3, studentId);

            int rows = ps.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private int getSectionIdByName(String sectionName) {
        String sql = "SELECT section_id FROM section WHERE section_name = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, sectionName);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("section_id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1; // not found
    }

    public boolean isArchivedEnrollmentExists(int studentId, int gradeLevel, int strandId) {
        String sql = """
        SELECT COUNT(*) AS count
        FROM archived_student_strand
        WHERE student_id = ?
          AND grade_level = ?
          AND strand_id = ?
    """;

        try (PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setInt(1, studentId);
            pst.setInt(2, gradeLevel);
            pst.setInt(3, strandId);

            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("count") > 0;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void loadArchivedStudentStrandsTable(JTable table, String search) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0); // Clear existing data

        String sql = """
            SELECT 
                ass.student_id,
                CONCAT(s.last_name, ', ', s.first_name, ' ', COALESCE(s.middle_name, '')) AS student_name,
                ass.grade_level,
                st.strand_name,
                sec.section_name,
                ass.date_archived,
                ass.reason
            FROM archived_student_strand ass
            JOIN student s ON ass.student_id = s.student_id
            JOIN strands st ON ass.strand_id = st.strand_id
            JOIN section sec ON ass.section_id = sec.section_id
            WHERE s.last_name LIKE ?
               OR s.first_name LIKE ?
               OR s.middle_name LIKE ?
               OR st.strand_name LIKE ?
               OR sec.section_name LIKE ?
               OR CAST(ass.student_id AS CHAR) LIKE ?
            ORDER BY ass.date_archived DESC
        """;

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            for (int i = 1; i <= 6; i++) {
                ps.setString(i, "%" + search + "%");
            }

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("student_id"),
                    rs.getString("student_name"),
                    rs.getInt("grade_level"),
                    rs.getString("strand_name"),
                    rs.getString("section_name"),
                    rs.getString("date_archived"),
                    rs.getString("reason")
                });
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public boolean existsInStudentStrand(int studentId, int gradeLevel, int strandId, int sectionId) throws SQLException {
        String sql = "SELECT COUNT(*) FROM student_strand WHERE student_id = ? AND grade_level = ? AND strand_id = ? AND section_id = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, studentId);
            ps.setInt(2, gradeLevel);
            ps.setInt(3, strandId);
            ps.setInt(4, sectionId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        }
        return false;
    }

    public boolean isAlreadyInStudentStrand(int studentId, int gradeLevel, int strandId, int sectionId) throws SQLException {
        String query = "SELECT COUNT(*) FROM archived_student_strand WHERE student_id = ? AND grade_level = ? AND strand_id = ? AND section_id = ?";
        try (PreparedStatement pst = con.prepareStatement(query)) {
            pst.setInt(1, studentId);
            pst.setInt(2, gradeLevel);
            pst.setInt(3, strandId);
            pst.setInt(4, sectionId);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0; // true if record exists in archive
            }
        }
        return false;
    }

    // 🔹 Restore record: move from archived_student_strand → student_strand, then delete from archived
    public void restoreStudentRecord(int studentId, int gradeLevel, int strandId, int sectionId) throws SQLException {
        // 🔹 1. Archive the current active record before restoring
        String archiveCurrentSql = """
            INSERT INTO archived_student_strand (student_id, grade_level, strand_id, section_id, date_archived, reason)
            SELECT student_id, grade_level, strand_id, section_id, NOW(), 'Restored previous record'
            FROM student_strand
            WHERE student_id = ?
        """;
        try (PreparedStatement ps = con.prepareStatement(archiveCurrentSql)) {
            ps.setInt(1, studentId);
            ps.executeUpdate();
        }

        // 🔹 2. Update student_strand with data from archived_student_strand (restore)
        String updateSql = """
            UPDATE student_strand
            SET grade_level = ?, strand_id = ?, section_id = ?
            WHERE student_id = ?
        """;
        try (PreparedStatement ps = con.prepareStatement(updateSql)) {
            ps.setInt(1, gradeLevel);
            ps.setInt(2, strandId);
            ps.setInt(3, sectionId);
            ps.setInt(4, studentId);
            ps.executeUpdate();
        }

        // 🔹 3. Delete the restored record from archived_student_strand
        String deleteSql = """
            DELETE FROM archived_student_strand
            WHERE student_id = ? AND grade_level = ? AND strand_id = ? AND section_id = ?
        """;
        try (PreparedStatement ps = con.prepareStatement(deleteSql)) {
            ps.setInt(1, studentId);
            ps.setInt(2, gradeLevel);
            ps.setInt(3, strandId);
            ps.setInt(4, sectionId);
            ps.executeUpdate();
        }
    }

    public void getArchivedStudentValue(JTable table, String searchValue) {
        String sql = "SELECT student_id, user_id, first_name, middle_name, last_name, "
                + "date_of_birth, gender, email, phone_number, mother_name, father_name, "
                + "address1, address2, LRN, date_archived, reason "
                + "FROM archived_student "
                + "WHERE CONCAT(first_name, middle_name, last_name, email, phone_number, reason) LIKE ? "
                + "ORDER BY student_id DESC";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + searchValue + "%");
            ResultSet rs = ps.executeQuery();

            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0); // ✅ Clear previous results

            Object[] row;
            while (rs.next()) {
                row = new Object[16];
                row[0] = rs.getInt("student_id");
                row[1] = rs.getInt("user_id");
                row[2] = rs.getString("first_name");
                row[3] = rs.getString("middle_name");
                row[4] = rs.getString("last_name");
                row[5] = rs.getDate("date_of_birth");
                row[6] = rs.getString("gender");
                row[7] = rs.getString("email");
                row[8] = rs.getString("phone_number");
                row[9] = rs.getString("mother_name");
                row[10] = rs.getString("father_name");
                row[11] = rs.getString("address1");
                row[12] = rs.getString("address2");
                row[13] = rs.getString("LRN");
                row[14] = rs.getTimestamp("date_archived");
                row[15] = rs.getString("reason");
                model.addRow(row);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void archiveStudent(int studentId, String reason) {
        String insertSql = """
        INSERT INTO archived_student (
            student_id, user_id, first_name, middle_name, last_name,
            date_of_birth, gender, email, phone_number, father_name,
            mother_name, address1, address2, LRN, image_path,
            form_137, birth_certificate, date_archived, reason
        )
        SELECT 
            student_id, user_id, first_name, middle_name, last_name,
            date_of_birth, gender, email, phone_number, father_name,
            mother_name, address1, address2, LRN, image_path,
            form_137, birth_certificate, NOW(), ?
        FROM student
        WHERE student_id = ?
    """;

        String getUserId = "SELECT user_id FROM student WHERE student_id = ?";
        String deleteUser = "DELETE FROM user WHERE user_id = ?";
        String deleteStudent = "DELETE FROM student WHERE student_id = ?";

        try (
                Statement st = con.createStatement(); PreparedStatement psInsert = con.prepareStatement(insertSql); PreparedStatement psGetUser = con.prepareStatement(getUserId); PreparedStatement psDeleteUser = con.prepareStatement(deleteUser); PreparedStatement psDeleteStudent = con.prepareStatement(deleteStudent)) {
            // Start transaction
            con.setAutoCommit(false);

            // ✅ Disable foreign key checks
            st.execute("SET FOREIGN_KEY_CHECKS = 0");

            // ✅ Archive student first
            psInsert.setString(1, reason);
            psInsert.setInt(2, studentId);
            psInsert.executeUpdate();

            // ✅ Get user_id before deleting student
            psGetUser.setInt(1, studentId);
            ResultSet rs = psGetUser.executeQuery();
            int userId = 0;
            if (rs.next()) {
                userId = rs.getInt("user_id");
            }

            // ✅ Delete student
            psDeleteStudent.setInt(1, studentId);
            psDeleteStudent.executeUpdate();

            // ✅ Delete user (after student is gone)
            if (userId > 0) {
                psDeleteUser.setInt(1, userId);
                psDeleteUser.executeUpdate();
            }

            // ✅ Re-enable FK checks
            st.execute("SET FOREIGN_KEY_CHECKS = 1");

            // ✅ Commit everything
            con.commit();

            System.out.println("✅ Student archived and user deleted successfully.");
        } catch (SQLException e) {
            try {
                con.rollback();
                System.err.println("❌ Transaction rolled back due to error: " + e.getMessage());
            } catch (SQLException rollbackEx) {
                rollbackEx.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                con.setAutoCommit(true);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    // Check if archived ID exists

    public boolean isidExist(int id) {
        boolean exist = false;
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM archived_student WHERE student_id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            exist = rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exist;
    }

    // Restore student
    public void restoreStudent(int studentId) {
        String selectQuery = "SELECT * FROM archived_student WHERE student_id = ?";
        String insertUserQuery = "INSERT INTO user (user_id, username, password, type_id) VALUES (?, ?, ?, ?)";
        String insertStudentQuery = "INSERT INTO student (student_id, user_id, first_name, middle_name, last_name, date_of_birth, gender, email, phone_number, father_name, mother_name, address1, address2, LRN) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        String deleteArchiveQuery = "DELETE FROM archived_student WHERE student_id = ?";

        try {
            PreparedStatement psSelect = con.prepareStatement(selectQuery);
            psSelect.setInt(1, studentId);
            ResultSet rs = psSelect.executeQuery();

            if (rs.next()) {
                int userId = rs.getInt("user_id");
                String lrn = rs.getString("LRN");
                String lastName = rs.getString("last_name");
                Date dob = rs.getDate("date_of_birth");

                // ✅ Generate password: lastname + birthForPass (e.g., 2005-03-04 → 030405)
                String birthForPass = new SimpleDateFormat("MMddyy").format(dob);
                String password = lastName.toLowerCase() + birthForPass;
                int type_id = 2; // Student type

                // ✅ Create user record (recreate user)
                PreparedStatement psInsertUser = con.prepareStatement(insertUserQuery);
                psInsertUser.setInt(1, userId);
                psInsertUser.setString(2, lrn);        // username = LRN
                psInsertUser.setString(3, password);   // password = lastname + birth
                psInsertUser.setInt(4, type_id);       // type = 2 (student)
                psInsertUser.executeUpdate();

                // ✅ Restore student record
                PreparedStatement psInsertStudent = con.prepareStatement(insertStudentQuery);
                psInsertStudent.setInt(1, rs.getInt("student_id"));
                psInsertStudent.setInt(2, userId);
                psInsertStudent.setString(3, rs.getString("first_name"));
                psInsertStudent.setString(4, rs.getString("middle_name"));
                psInsertStudent.setString(5, lastName);
                psInsertStudent.setDate(6, (java.sql.Date) dob);
                psInsertStudent.setString(7, rs.getString("gender"));
                psInsertStudent.setString(8, rs.getString("email"));
                psInsertStudent.setString(9, rs.getString("phone_number"));
                psInsertStudent.setString(10, rs.getString("father_name"));
                psInsertStudent.setString(11, rs.getString("mother_name"));
                psInsertStudent.setString(12, rs.getString("address1"));
                psInsertStudent.setString(13, rs.getString("address2"));
                psInsertStudent.setString(14, lrn);
                psInsertStudent.executeUpdate();

                // ✅ Finally remove from archived table
                PreparedStatement psDelete = con.prepareStatement(deleteArchiveQuery);
                psDelete.setInt(1, studentId);
                psDelete.executeUpdate();

                JOptionPane.showMessageDialog(null, "Student successfully restored to current records.");
            } else {
                JOptionPane.showMessageDialog(null, "Archived student record not found.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error restoring student: " + e.getMessage());
        }
    }

}
