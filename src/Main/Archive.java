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
import javax.swing.JOptionPane;

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

//     private void stuSaveBtActionPerformed(java.awt.event.ActionEvent evt) {                                          
//        if (stuStrandId.getText().isEmpty()) {
//            JOptionPane.showMessageDialog(this, "Student ID is missing");
//            return;
//        }
//
//        try {
//            int studentId = Integer.parseInt(stuStrandId.getText());
//            int gradeLevel = Integer.parseInt(stuGradeLevel.getSelectedItem().toString());
//            String strandName = stuStrand.getSelectedItem().toString();
//            String sectionSelect = stuSection.getSelectedItem().toString();
//
//            int strandId = strand.convertStrandNameToId(strandName);
//            if (strandId == -1) {
//                JOptionPane.showMessageDialog(this, "Invalid strand selected");
//                return;
//            }
//
//            // ✅ Check if student exists
//            if (!strand.studentExists(studentId)) {
//                JOptionPane.showMessageDialog(this, "Student with ID " + studentId + " does not exist");
//                return;
//            }
//
//            // ✅ 1. Check if student already enrolled in same strand + grade level
//            if (strand.isStudentEnrolledInStrandAndGrade(studentId, strandId, gradeLevel)) {
//                Object[] currentEnrollment = strand.getCurrentEnrollment(studentId);
//                String currentStrand = (String) currentEnrollment[1];
//                String currentSection = (String) currentEnrollment[2];
//
//                JOptionPane.showMessageDialog(this,
//                        "Student is already enrolled in " + currentStrand
//                        + " Grade " + gradeLevel
//                        + " Section " + currentSection);
//                return;
//            }
//
//            // ✅ 2. Check if student is already enrolled in any strand
//            if (strand.isStudentEnrolledInAnyStrand(studentId)) {
//                Object[] currentEnrollment = strand.getCurrentEnrollment(studentId);
//                int currentGradeLevel = (int) currentEnrollment[0];
//                String currentStrand = (String) currentEnrollment[1];
//                String currentSection = (String) currentEnrollment[2];
//                int currentStrandId = strand.convertStrandNameToId(currentStrand);
//
//                // ✅ Promotion (same strand, higher grade)
//                if (currentStrand.equals(strandName)) {
//                    if (gradeLevel > currentGradeLevel) {
//                        boolean hasPassed = progress.hasStudentPassed(studentId, currentStrandId, currentGradeLevel);
//                        if (!hasPassed) {
//                            JOptionPane.showMessageDialog(this,
//                                    "This student has not yet passed all required subjects.\n"
//                                    + "Promotion cannot proceed until requirements are met.",
//                                    "Promotion Blocked",
//                                    JOptionPane.WARNING_MESSAGE);
//                            return;
//                        }
//
//                        int response = JOptionPane.showConfirmDialog(
//                                this,
//                                "Student Promotion:\n\n"
//                                + "Current: " + currentStrand + " - Grade " + currentGradeLevel + " - Section " + currentSection
//                                + "\nNew: " + strandName + " - Grade " + gradeLevel + " - Section " + sectionSelect
//                                + "\n\nConfirm promotion?",
//                                "Confirm Student Promotion",
//                                JOptionPane.YES_NO_OPTION,
//                                JOptionPane.QUESTION_MESSAGE
//                        );
//
//                        if (response == JOptionPane.YES_OPTION) {
//                            int newSectionId = strand.getAvailableSection(gradeLevel, strandId);
//                            if (newSectionId == -1) {
//                                JOptionPane.showMessageDialog(this, "No available sections for Grade " + gradeLevel + " in " + strandName);
//                                return;
//                            }
//                            boolean archived = archive.archiveStudentStrand(studentId, currentStrandId, strandId, currentGradeLevel, gradeLevel);
//                            if (!archived) {
//                                JOptionPane.showMessageDialog(this, "❌ Failed to archive existing record. Promotion cancelled.");
//                                return;
//                            }
//
//                            boolean success = archive.updateStudentGradeLevel(studentId, gradeLevel, newSectionId);
//                            JOptionPane.showMessageDialog(this, success
//                                    ? "✅ Student promoted successfully to Grade " + gradeLevel
//                                    : "❌ Failed to promote student");
//                        }
//
//                    } else {
//                        JOptionPane.showMessageDialog(this,
//                                "Invalid promotion: New grade level must be higher than current grade.");
//                    }
//
//                } else {
//                    // ✅ Transfer to different strand
//                    int response = JOptionPane.showConfirmDialog(
//                            this,
//                            "Student Strand Transfer:\n\n"
//                            + "Student ID: " + studentId
//                            + "\nCurrent: " + currentStrand + " - Grade " + currentGradeLevel + " - Section " + currentSection
//                            + "\nNew: " + strandName + " - Grade " + gradeLevel + " - Section " + sectionSelect
//                            + "\n\nConfirm transfer?",
//                            "Confirm Strand Transfer",
//                            JOptionPane.YES_NO_OPTION,
//                            JOptionPane.WARNING_MESSAGE
//                    );
//
//                    if (response == JOptionPane.YES_OPTION) {
//                        boolean archived = archive.archiveStudentStrand(studentId, currentStrandId, strandId, currentGradeLevel, gradeLevel);
//                        if (archived) {
//                            boolean success = strand.insertStudentStrand(studentId, strandId, gradeLevel, sectionSelect);
//                            JOptionPane.showMessageDialog(this, success
//                                    ? "✅ Student transferred successfully to " + strandName
//                                    : "❌ Failed to insert new enrollment after transfer");
//                        } else {
//                            JOptionPane.showMessageDialog(this, "❌ Failed to archive existing record. Transfer cancelled.");
//                        }
//                    }
//                }
//
//            } else {
//                // ✅ 3. New enrollment
//                int response = JOptionPane.showConfirmDialog(
//                        this,
//                        "New Student Enrollment:\n\n"
//                        + "Student ID: " + studentId
//                        + "\nStrand: " + strandName
//                        + "\nGrade Level: " + gradeLevel
//                        + "\nSection: " + sectionSelect
//                        + "\n\nConfirm enrollment?",
//                        "Confirm New Enrollment",
//                        JOptionPane.YES_NO_OPTION,
//                        JOptionPane.QUESTION_MESSAGE
//                );
//
//                if (response == JOptionPane.YES_OPTION) {
//                    boolean success = strand.insertStudentStrand(studentId, strandId, gradeLevel, sectionSelect);
//
//                    String schoolYear = getCurrentSchoolYear();
//                    String status = "Incomplete";
//                    progress.insert(studentId, schoolYear, status);
//                    JOptionPane.showMessageDialog(this, success
//                            ? "✅ Student enrolled successfully in " + strandName
//                            : "❌ Failed to enroll student");
//                }
//            }
//
//            // ✅ Refresh table
//            StudentTrackTable.setModel(new DefaultTableModel(
//                    null,
//                    new Object[]{"Student_ID", "Grade_Level", "Strand", "Section"}
//            ));
//            strand.loadStudentStrandsTable(StudentTrackTable, "");
//            clearStrand();
//
//        } catch (NumberFormatException ex) {
//            JOptionPane.showMessageDialog(this, "Please enter a valid numeric Student ID");
//        } catch (Exception ex) {
//            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
//            ex.printStackTrace();
//        }
//    }                  
}
