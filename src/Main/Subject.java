/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import db.MyConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author ADMIN
 */
public class Subject {

    Connection conn = MyConnection.getConnection();

    // Get all subjects for grade + strand
    public ResultSet getSubjectsForStudent(int studentId, int gradeLevel) throws SQLException {
        String sql = """
            SELECT DISTINCT sub.subject_id, sub.subject_name, sub.grade_level
            FROM subject sub
            INNER JOIN student_strand ss 
                ON sub.strand_id = ss.strand_id
            WHERE ss.student_id = ?
              AND sub.grade_level = ?
        """;

        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setInt(1, studentId);   // student id
        pst.setInt(2, gradeLevel);  // grade level chosen by user

        // Debug: print query parameters
        System.out.println("Fetching subjects for Student ID: " + studentId + ", Grade Level: " + gradeLevel);

        return pst.executeQuery();

    }

    // Get already enrolled subjects for student
    public ResultSet getEnrolledSubjects(int studentId, String schoolYear) throws SQLException {
        String sql = """
            SELECT subject_id FROM student_subjects 
            WHERE student_id = ? AND school_year = ?
        """;
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setInt(1, studentId);
        pst.setString(2, schoolYear);
        return pst.executeQuery();
    }

//    public void saveStudentSubjects(String studentId, javax.swing.JTable table, String schoolYear) {
//        String sql = "INSERT INTO student_subjects (student_id, subject_id, status, school_year) "
//                + "VALUES (?, ?, ?, ?) "
//                + "ON DUPLICATE KEY UPDATE status = VALUES(status), school_year = VALUES(school_year)";
//
//        try (PreparedStatement pst = conn.prepareStatement(sql)) {
//            for (int i = 0; i < table.getRowCount(); i++) {
//                String subjectId = table.getValueAt(i, 0).toString();
//                Boolean isEnrolled = (Boolean) table.getValueAt(i, 2); // checkbox column
//
//                String status = (isEnrolled != null && isEnrolled) ? "Enrolled" : "Dropped";
//
//                pst.setString(1, studentId);
//                pst.setString(2, subjectId);
//                pst.setString(3, status);
//                pst.setString(4, schoolYear);
//
//                pst.addBatch();
//            }
//            pst.executeBatch();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
    public void saveStudentSubjects(String studentId, javax.swing.JTable table, String schoolYear) {
        String sql = """
        INSERT INTO student_subjects (student_id, subject_id, status, school_year)
        VALUES (?, ?, ?, ?)
        ON DUPLICATE KEY UPDATE 
            status = VALUES(status),
            school_year = VALUES(school_year)
    """;

        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            for (int i = 0; i < table.getRowCount(); i++) {
                String subjectId = table.getValueAt(i, 0).toString();
                Boolean isEnrolled = (Boolean) table.getValueAt(i, 2); // checkbox column

                String status = (isEnrolled != null && isEnrolled) ? "Enrolled" : "Dropped";

                pst.setString(1, studentId);
                pst.setString(2, subjectId);
                pst.setString(3, status);
                pst.setString(4, schoolYear);

                pst.addBatch();
            }
            pst.executeBatch();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isStudentEnrolledInGradeLevel(int studentId, int gradeLevel) throws SQLException {
        String sql = """
        SELECT COUNT(*) AS cnt
        FROM student_strand
        WHERE student_id = ? AND grade_level = ?
    """;

        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setInt(1, studentId);
            pst.setInt(2, gradeLevel);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return rs.getInt("cnt") > 0;
            }
        }
        return false;
    }

    // (optional) close connection when done
    public void close() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
