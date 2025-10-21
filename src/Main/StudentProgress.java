/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import db.MyConnection;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import javax.swing.JFileChooser;
import model.PageNumberEvent;

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

//        String sql = """
//        SELECT 
//            s.lrn,
//            CONCAT(s.first_name, ' ', s.last_name) AS student_name,
//            sp.school_year,
//            ROUND(AVG(g.grade), 2) AS final_average,
//            CASE 
//                WHEN ? = 12 AND AVG(g.grade) >= 75 THEN 'Ready to Graduate'
//                WHEN AVG(g.grade) >= 75 THEN 'Passed'
//                ELSE 'Failed'
//            END AS status
//        FROM student s
//        JOIN student_strand ss ON s.student_id = ss.student_id
//        JOIN grade_entry g ON s.student_id = g.student_id
//        JOIN student_progress sp ON s.student_id = sp.student_id
//        WHERE ss.grade_level = ? 
//          AND ss.strand_id = ? 
//          AND ss.section_id = ?
//        GROUP BY s.lrn, student_name, sp.school_year
//        ORDER BY s.lrn;
//    """;
//        String sql = """
//        SELECT 
//            s.lrn,
//            CONCAT(s.first_name, ' ', s.last_name) AS student_name,
//            sp.school_year,
//            ROUND(AVG(g.grade), 2) AS final_average,
//            CASE 
//                WHEN ? = 12 AND AVG(g.grade) >= 75 THEN 'Ready to Graduate'
//                WHEN AVG(g.grade) >= 75 THEN 'Passed'
//                ELSE 'Failed'
//            END AS status
//        FROM student s
//        JOIN student_strand ss ON s.student_id = ss.student_id
//        JOIN grade_entry g ON s.student_id = g.student_id
//        JOIN subject subj ON g.subject_id = subj.subject_id
//        JOIN student_progress sp ON s.student_id = sp.student_id
//        WHERE ss.grade_level = ? 
//          AND ss.strand_id = ? 
//          AND ss.section_id = ?
//          AND subj.strand_id = ss.strand_id   -- ✅ only include students whose subjects match their strand
//        GROUP BY s.student_id, s.lrn, student_name, sp.school_year
//        ORDER BY s.lrn;
//    """;
        String sql = """
        SELECT 
            s.lrn,
            CONCAT(s.first_name, ' ', s.last_name) AS student_name,
            sp.school_year,
            ROUND(AVG(g.grade), 2) AS final_average,
            CASE 
                WHEN ? = 12 AND AVG(g.grade) >= 75 THEN 'Ready to Graduate'
                WHEN AVG(g.grade) >= 75 THEN 'Passed'
                ELSE 'Failed'
            END AS status
        FROM student s
        JOIN student_strand ss 
            ON s.student_id = ss.student_id
        JOIN student_subjects stu_sub
            ON s.student_id = stu_sub.student_id
        JOIN subject subj
            ON stu_sub.subject_id = subj.subject_id
            AND subj.strand_id = ss.strand_id
            AND subj.grade_level = ss.grade_level
        JOIN grade_entry g 
            ON s.student_id = g.student_id 
            AND subj.subject_id = g.subject_id
        JOIN student_progress sp 
            ON s.student_id = sp.student_id
        WHERE ss.grade_level = ? 
          AND ss.strand_id = ? 
          AND ss.section_id = ?
          AND stu_sub.status = 'Enrolled'
        GROUP BY s.student_id, s.lrn, student_name, sp.school_year
        HAVING 
            COUNT(DISTINCT CASE WHEN g.quarter BETWEEN 1 AND 4 THEN CONCAT(g.subject_id, '-', g.quarter) END)
            = (
                SELECT COUNT(*) * 4
                FROM student_subjects ss2
                JOIN subject sub2 
                  ON ss2.subject_id = sub2.subject_id
                JOIN student_strand ss3 
                  ON ss3.student_id = ss2.student_id
                WHERE ss2.student_id = s.student_id
                  AND sub2.strand_id = ss3.strand_id
                  AND sub2.grade_level = ss3.grade_level
                  AND ss2.status = 'Enrolled'
              )
        ORDER BY s.lrn;
    """;

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            // We pass gradeLevel twice: once for CASE, once for WHERE
            ps.setInt(1, gradeLevel);
            ps.setInt(2, gradeLevel);
            ps.setInt(3, strandId);
            ps.setInt(4, sectionId);

            try (ResultSet rs = ps.executeQuery()) {
                boolean hasData = false;

                while (rs.next()) {
                    hasData = true;
                    model.addRow(new Object[]{
                        rs.getString("lrn"),
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
        String updateSql = """
        UPDATE student_progress sp
        JOIN student s ON sp.student_id = s.student_id
        SET sp.status = ?
        WHERE s.LRN = ? AND sp.school_year = ?
    """;

        try {
            int updatedCount = 0;

            for (int i = 0; i < table.getRowCount(); i++) {
                Object lrnObj = table.getValueAt(i, 0);  // assuming column 0 = LRN
                Object schoolYearObj = table.getValueAt(i, 2); // column 2 = school_year
                Object statusObj = table.getValueAt(i, 4); // column 4 = status

                if (lrnObj == null || schoolYearObj == null || statusObj == null) {
                    continue;
                }

                String lrn = lrnObj.toString().trim();
                String schoolYear = schoolYearObj.toString().trim();
                String status = statusObj.toString().trim();

                if (lrn.isEmpty() || schoolYear.isEmpty() || status.isEmpty()) {
                    continue;
                }

                try (PreparedStatement ps = con.prepareStatement(updateSql)) {
                    ps.setString(1, status);
                    ps.setString(2, lrn);
                    ps.setString(3, schoolYear);

                    int rows = ps.executeUpdate();
                    if (rows > 0) {
                        updatedCount++;
                    }
                }
            }

            if (updatedCount > 0) {
                JOptionPane.showMessageDialog(null, "✅ Student status successfully updated!");
            } else {
                JOptionPane.showMessageDialog(null, "⚠️ No student statuses were updated. Please check the table data.");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "❌ Error updating student status: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void generateProgressList(JTable table, int gradeLevel, int strandId, int sectionId,
            String strandName, String sectionName) {
        try {
            // Let user choose where to save file
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Save Class List PDF");
            fileChooser.setSelectedFile(new File("ProgressList_G" + gradeLevel + "_"
                    + strandName + "_Sec" + sectionName + ".pdf"));

            int userSelection = fileChooser.showSaveDialog(null);
            if (userSelection != JFileChooser.APPROVE_OPTION) {
                JOptionPane.showMessageDialog(null, "Save command canceled.");
                System.out.println("Save command canceled.");
                return;
            }

            File fileToSave = fileChooser.getSelectedFile();
            Document document = new Document(PageSize.A4);
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(fileToSave));

            // ✅ Attach page event for numbering
            writer.setPageEvent(new PageNumberEvent());

            document.open();

            // 🔹 Add Logo
            try (InputStream is = getClass().getResourceAsStream("/assets/logo_remBac.png")) {
                if (is != null) {
                    byte[] bytes = is.readAllBytes();
                    Image logo = Image.getInstance(bytes);
                    logo.scaleAbsolute(80, 80);
                    logo.setAlignment(Element.ALIGN_CENTER);
                    document.add(logo);
                } else {
                    System.out.println("Logo not found in resources.");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            // 🔹 Title
            Paragraph title = new Paragraph("Progress List",
                    FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18));
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);

            // 🔹 Sub info with proper names
            Paragraph sub = new Paragraph(
                    "Grade " + gradeLevel
                    + " | Strand: " + strandName
                    + " | Section: " + sectionName,
                    FontFactory.getFont(FontFactory.HELVETICA, 12)
            );
            sub.setAlignment(Element.ALIGN_CENTER);
            sub.setSpacingAfter(20);
            document.add(sub);

            // 🔹 Table (2 columns: ID, Full Name)
            PdfPTable pdfTable = new PdfPTable(5);
            pdfTable.setWidthPercentage(100);

            // ✅ Allow multi-page
            pdfTable.setSplitLate(false);
            pdfTable.setHeaderRows(1);

            // Headers
            PdfPCell header1 = new PdfPCell(new Phrase("LRN"));
            PdfPCell header2 = new PdfPCell(new Phrase("Full Name"));
            PdfPCell header3 = new PdfPCell(new Phrase("School Year"));
            PdfPCell header4 = new PdfPCell(new Phrase("Final Average"));
            PdfPCell header5 = new PdfPCell(new Phrase("Status"));

            header1.setHorizontalAlignment(Element.ALIGN_CENTER);
            header2.setHorizontalAlignment(Element.ALIGN_CENTER);
            pdfTable.addCell(header1);
            pdfTable.addCell(header2);
            pdfTable.addCell(header3);
            pdfTable.addCell(header4);
            pdfTable.addCell(header5);

            // Fill rows from JTable
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            for (int i = 0; i < model.getRowCount(); i++) {
                pdfTable.addCell(model.getValueAt(i, 0).toString()); // LRN
                pdfTable.addCell(model.getValueAt(i, 1).toString()); // Name
                pdfTable.addCell(model.getValueAt(i, 2).toString());
                pdfTable.addCell(model.getValueAt(i, 3).toString());
                pdfTable.addCell(model.getValueAt(i, 4).toString());
            }

            // 🔹 Add table (will auto break pages)
            document.add(pdfTable);
            document.close();

            System.out.println("PDF Created: " + fileToSave.getAbsolutePath());
            JOptionPane.showMessageDialog(null, "PDF Created: " + fileToSave.getAbsolutePath());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
