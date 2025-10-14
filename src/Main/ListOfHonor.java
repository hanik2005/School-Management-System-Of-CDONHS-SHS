package Main;

import db.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ListOfHonor {

    Connection con = MyConnection.getConnection();
    PreparedStatement ps;

    public DefaultTableModel getStudentGrades(
            int gradeLevel, int strandId, int sectionId, int subjectId, String quarterSelection, String schoolYear) {

        DefaultTableModel model = new DefaultTableModel(
                null,
                new Object[]{"LRN", "Student Name", "Average"}
        );

        StringBuilder sql = new StringBuilder(
                "SELECT s.student_id, s.LRN, "
                + "CONCAT(s.last_name, ', ', s.first_name, ' ', COALESCE(s.middle_name, '')) AS student_name, "
        );

        if ("General Average".equalsIgnoreCase(quarterSelection)) {
            sql.append("AVG(g.grade) AS average_grade ");
        } else {
            sql.append("AVG(CASE WHEN g.quarter = ? THEN g.grade END) AS average_grade ");
        }

        sql.append("FROM student s ")
                .append("INNER JOIN student_subjects ssj ON ssj.student_id = s.student_id ")
                .append("INNER JOIN subject subj ON subj.subject_id = ssj.subject_id ")
                .append("INNER JOIN student_strand ss ON ss.student_id = s.student_id ") // join for section_id
                .append("LEFT JOIN grade_entry g ON g.student_id = s.student_id AND g.subject_id = ssj.subject_id ");

        if (subjectId > 0) {
            sql.append("AND g.subject_id = ? ");
        }

        sql.append("WHERE subj.grade_level = ? ") // filter by subject table
                .append("AND subj.strand_id = ? ") // filter by subject table
                .append("AND ss.section_id = ? ") // filter by section from student_strand
                .append("AND ssj.school_year = ? ")
                .append("AND ssj.status = 'Enrolled' ")
                .append("GROUP BY s.student_id, s.LRN, s.last_name, s.first_name, s.middle_name ")
                .append("ORDER BY s.last_name");

        try (Connection conn = MyConnection.getConnection(); PreparedStatement pst = conn.prepareStatement(sql.toString())) {
            int idx = 1;

            if (!"General Average".equalsIgnoreCase(quarterSelection)) {
                pst.setInt(idx++, Integer.parseInt(quarterSelection)); // quarter
            }
            if (subjectId > 0) {
                pst.setInt(idx++, subjectId);
            }

            pst.setInt(idx++, gradeLevel);
            pst.setInt(idx++, strandId);
            pst.setInt(idx++, sectionId);
            pst.setString(idx++, schoolYear);

            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    String lrn = rs.getString("LRN");
                    String studentName = rs.getString("student_name");

                    java.math.BigDecimal avgObj = rs.getBigDecimal("average_grade");
                    double avgVal = (avgObj != null) ? avgObj.doubleValue() : 0.0;

                    // Only add if average is >= 90
                    if (avgVal >= 90) {
                        String avgStr = String.format("%.2f", avgVal);
                        model.addRow(new Object[]{lrn, studentName, avgStr});
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return model;
    }

}
