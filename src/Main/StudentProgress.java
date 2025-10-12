/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import db.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

/**
 *
 * @author ADMIN
 */
public class StudentProgress {

    Connection con = MyConnection.getConnection();
    PreparedStatement ps;
    ResultSet rs;

    public boolean hasStudentPassed(int studentId, int strandId, int gradeLevel) {
    String sql = """
        SELECT sp.status
        FROM student_progress sp
        JOIN student_strand ss ON sp.student_id = ss.student_id
        WHERE sp.student_id = ?
          AND ss.strand_id = ?
          AND ss.grade_level = ?
    """;

    try (PreparedStatement ps = con.prepareStatement(sql)) {
        ps.setInt(1, studentId);
        ps.setInt(2, strandId);
        ps.setInt(3, gradeLevel);

        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                String status = rs.getString("status");
                return status != null && status.equalsIgnoreCase("Passed");
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return false;
}


    public void insert(int student_id, String school_year, String status) {
        String sql = "insert into student_progress (student_id, school_year, status) values(?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, student_id);
            ps.setString(2, school_year);
            ps.setString(3, status);

            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "New Student Progress added successfully");

            }
        } catch (SQLException ex) {
            System.getLogger(StudentProgress.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }

    }

    public void displayStudentProgress(JTable table, int gradeLevel, int strandId, int sectionId) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0); // clear existing rows

        String sql = """
        SELECT s.student_id,
               CONCAT(s.first_name, ' ', s.last_name) AS student_name,
               sp.school_year,
               ROUND(AVG(g.grade), 2) AS final_average,
               CASE 
                   WHEN AVG(g.grade) >= 75 THEN 'Passed'
                   ELSE 'Failed'
               END AS status
        FROM student s
        JOIN student_strand ss ON s.student_id = ss.student_id
        JOIN grade_entry g ON s.student_id = g.student_id
        JOIN student_progress sp ON s.student_id = sp.student_id
        WHERE ss.grade_level = ? 
          AND ss.strand_id = ? 
          AND ss.section_id = ?
        GROUP BY s.student_id, student_name, sp.school_year
        ORDER BY s.student_id;
    """;

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, gradeLevel);
            ps.setInt(2, strandId);
            ps.setInt(3, sectionId);

            try (ResultSet rs = ps.executeQuery()) {
                boolean hasData = false;
                while (rs.next()) {
                    hasData = true;
                    model.addRow(new Object[]{
                        rs.getInt("student_id"),
                        rs.getString("student_name"),
                        rs.getString("school_year"),
                        rs.getDouble("final_average"),
                        rs.getString("status")
                    });
                }

                if (!hasData) {
                    JOptionPane.showMessageDialog(null, "No student progress found for the selected section.");
                }
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error displaying student progress: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void confirmStudentProgress(JTable table) {
        String updateSql = "UPDATE student_progress SET status = ? WHERE student_id = ? AND school_year = ?";

        try {
            int updatedCount = 0;

            for (int i = 0; i < table.getRowCount(); i++) {
                int studentId = Integer.parseInt(table.getValueAt(i, 0).toString());
                String schoolYear = table.getValueAt(i, 2).toString();
                String status = table.getValueAt(i, 4).toString();

                try (PreparedStatement ps = con.prepareStatement(updateSql)) {
                    ps.setString(1, status);
                    ps.setInt(2, studentId);
                    ps.setString(3, schoolYear);

                    int rows = ps.executeUpdate();
                    if (rows > 0) {
                        updatedCount++;
                    }
                }
            }

            if (updatedCount > 0) {
                JOptionPane.showMessageDialog(null, "Student status successfully updated!");
            } else {
                JOptionPane.showMessageDialog(null, "No student statuses were updated. Please check the table data.");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error updating student status: " + e.getMessage());
            e.printStackTrace();
        }
    }

}
