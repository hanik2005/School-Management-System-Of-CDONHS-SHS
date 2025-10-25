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
import com.mysql.cj.xdevapi.Table;
import java.sql.Connection;
import db.MyConnection;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.ComboItem;
import model.PageNumberEvent;

public class Strand {

    Connection con = MyConnection.getConnection();
    PreparedStatement ps;

    // Get next available ID
    public boolean getId(int id) {
        try {
            ps = con.prepareStatement("select * from student where student_id= ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Home.stuStrandId.setText(String.valueOf(rs.getInt(1)));
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Student Id doesnt exist");

            }
        } catch (SQLException ex) {
            System.getLogger(Strand.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }

        return false;
    }
     public boolean getIdInAdmin(int id) {
        try {
            ps = con.prepareStatement("select * from student where student_id= ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                AdminFrame.stuStrandId.setText(String.valueOf(rs.getInt(1)));
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Student Id doesnt exist");

            }
        } catch (SQLException ex) {
            System.getLogger(Strand.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }

        return false;
    }

    public int getSectionIdByName(String sectionName, int gradeLevel, int strandId) {
        String sql = "SELECT section_id FROM section WHERE section_name = ? AND grade_level = ? AND strand_id = ?";
        try (PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, sectionName);
            pst.setInt(2, gradeLevel);
            pst.setInt(3, strandId);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return rs.getInt("section_id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1; // Return -1 if not found
    }

    public boolean getIdFromAdmin(int id) {
        try {
            ps = con.prepareStatement("select * from student where student_id= ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                AdminFrame.stuStrandId.setText(String.valueOf(rs.getInt(1)));
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Student Id doesnt exist");

            }
        } catch (SQLException ex) {
            System.getLogger(Strand.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }

        return false;
    }

    public Object[] getCurrentEnrollment(int studentId) {
        String sql = """
            SELECT ss.grade_level, 
           s.strand_name, 
           sec.section_name
           FROM student_strand ss
            JOIN strands s ON ss.strand_id = s.strand_id
            JOIN section sec ON ss.section_id = sec.section_id
            WHERE ss.student_id = ?
            """;

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, studentId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Object[]{
                    rs.getInt("grade_level"), // index 0: grade level
                    rs.getString("strand_name"), // index 1: strand name
                    rs.getString("section_name") // index 2: section name
                };
            }
        } catch (SQLException ex) {
            System.getLogger(Strand.class.getName()).log(System.Logger.Level.ERROR, "Error getting current enrollment", ex);
        }

        return new Object[]{0, "Not Enrolled", "N/A"};
    }

    public boolean deleteStudentStrandAndGrades(int studentId, int strandId, int gradeLevel) {
        String deleteGradesSQL = """
        DELETE g FROM grade_entry g
        INNER JOIN subject s ON g.subject_id = s.subject_id
        WHERE g.student_id = ? AND s.grade_level IN (11, 12)
    """;

        String deleteStrandSQL = """
        DELETE FROM student_strand
        WHERE student_id = ? AND grade_level IN (11, 12)
    """;

        try (Connection conn = MyConnection.getConnection()) {
            conn.setAutoCommit(false);

            // 1. Delete grades
            try (PreparedStatement ps1 = conn.prepareStatement(deleteGradesSQL)) {
                ps1.setInt(1, studentId);
                int gradesDeleted = ps1.executeUpdate();
                System.out.println("Deleted " + gradesDeleted + " grades for student_id=" + studentId);
            }

            // 2. Delete strand enrollments
            try (PreparedStatement ps2 = conn.prepareStatement(deleteStrandSQL)) {
                ps2.setInt(1, studentId);
                int strandsDeleted = ps2.executeUpdate();
                System.out.println("Deleted " + strandsDeleted + " strand records for student_id=" + studentId);
            }

            conn.commit();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public int getAvailableSection(int gradeLevel, int strandId) {
        try {
            ResultSet rs = con.createStatement().executeQuery(
                    "SELECT section_id FROM section "
                    + "WHERE grade_level = " + gradeLevel + " AND strand_id = " + strandId
            );

            List<Integer> sections = new ArrayList<>();
            while (rs.next()) {
                sections.add(rs.getInt("section_id"));
            }

            ResultSet rs2 = con.createStatement().executeQuery(
                    "SELECT section_id FROM student_strand "
                    + "WHERE grade_level = " + gradeLevel + " AND strand_id = " + strandId
            );

            Set<Integer> takenSections = new HashSet<>();
            while (rs2.next()) {
                takenSections.add(rs2.getInt("section_id"));
            }

            for (Integer secId : sections) {
                if (!takenSections.contains(secId)) {
                    return secId;
                }
            }

            // 4️⃣ No available section
            return -1;

        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

//    public int getNextSectionId(int gradeLevel, int strandId) {
//        int sectionId = -1; // default if none found
//
//        try {
//            // 1️⃣ Get all sections for this grade + strand
//            String sectionSql = "SELECT section_id, section_name FROM section "
//                    + "WHERE grade_level = ? AND strand_id = ? ORDER BY section_id";
//            PreparedStatement psSection = con.prepareStatement(sectionSql);
//            psSection.setInt(1, gradeLevel);
//            psSection.setInt(2, strandId);
//            ResultSet rsSections = psSection.executeQuery();
//
//            // 2️⃣ Find a section that has less than 50 students
//            while (rsSections.next()) {
//                int currentSectionId = rsSections.getInt("section_id");
//
//                String countSql = "SELECT COUNT(*) FROM student_strand WHERE section_id = ?";
//                PreparedStatement psCount = con.prepareStatement(countSql);
//                psCount.setInt(1, currentSectionId);
//                ResultSet rsCount = psCount.executeQuery();
//
//                if (rsCount.next()) {
//                    int studentCount = rsCount.getInt(1);
//                    if (studentCount < 50) {
//                        sectionId = currentSectionId;
//                        break;
//                    }
//                }
//            }
//
//            // 3️⃣ If all sections are full (optional fallback)
//            if (sectionId == -1) {
//                JOptionPane.showMessageDialog(null,
//                        "All sections for Grade " + gradeLevel + " (Strand ID: " + strandId + ") are full!");
//            }
//
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//
//        return sectionId;
//    }
    public String getNextSection(int gradeLevel, String strandName) {
        String nextSectionName = "A"; // default section name

        try {
            int strandId = getStrandIdByName(strandName);
            if (strandId == -1) {
                System.out.println("Invalid strand name: " + strandName);
                return nextSectionName;
            }

            // 🔹 Step 1: Get all sections for this grade and strand
            String sectionSql = """
            SELECT section_id, section_name
            FROM section
            WHERE grade_level = ? AND strand_id = ?
            ORDER BY section_name ASC
        """;

            try (PreparedStatement psSection = con.prepareStatement(sectionSql)) {
                psSection.setInt(1, gradeLevel);
                psSection.setInt(2, strandId);
                try (ResultSet rsSections = psSection.executeQuery()) {

                    // 🔹 Step 2: Check existing sections for available space (< 50 students)
                    while (rsSections.next()) {
                        int sectionId = rsSections.getInt("section_id");
                        String sectionName = rsSections.getString("section_name");

                        String countSql = "SELECT COUNT(*) FROM student_strand WHERE section_id = ?";
                        try (PreparedStatement psCount = con.prepareStatement(countSql)) {
                            psCount.setInt(1, sectionId);
                            try (ResultSet rsCount = psCount.executeQuery()) {
                                if (rsCount.next() && rsCount.getInt(1) < 50) {
                                    // Found a section that still has space
                                    return sectionName;
                                }
                            }
                        }
                    }
                }
            }

            // 🔹 Step 3: If all sections are full, find the last section name
            String lastSectionSql = """
            SELECT section_name
            FROM section
            WHERE grade_level = ? AND strand_id = ?
            ORDER BY section_name DESC
            LIMIT 1
        """;

            String lastName = null;
            try (PreparedStatement psLast = con.prepareStatement(lastSectionSql)) {
                psLast.setInt(1, gradeLevel);
                psLast.setInt(2, strandId);
                try (ResultSet rsLast = psLast.executeQuery()) {
                    if (rsLast.next()) {
                        lastName = rsLast.getString("section_name");
                    }
                }
            }

            // 🔹 Step 4: Generate next section name (A → B → C → ...)
            if (lastName != null) {
                nextSectionName = generateNextSectionName(lastName);
            } else {
                nextSectionName = "A"; // If no section exists yet
            }

            // 🔹 Step 5: Insert new section into the database
            String insertSql = """
            INSERT INTO section (section_name, grade_level, strand_id)
            VALUES (?, ?, ?)
        """;
            try (PreparedStatement psInsert = con.prepareStatement(insertSql)) {
                psInsert.setString(1, nextSectionName);
                psInsert.setInt(2, gradeLevel);
                psInsert.setInt(3, strandId);
                psInsert.executeUpdate();
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return nextSectionName;
    }

    private String generateNextSectionName(String lastSection) {
        char lastChar = lastSection.charAt(0);
        char nextChar = (char) (lastChar + 1);
        return String.valueOf(nextChar);
    }

    public int getStrandIdByName(String strandName) {
        String sql = "SELECT strand_id FROM strands WHERE strand_name = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, strandName);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("strand_id");
            }
        } catch (SQLException ex) {
            System.getLogger(Strand.class.getName()).log(System.Logger.Level.ERROR, "Error getting strand ID", ex);
        }
        return -1;
    }

// Helper method to convert index to section name (A, B, C, ..., Z, AA, AB, etc.)
    private String convertIndexToSectionName(int index) {
        if (index < 0) {
            return "A";
        }

        StringBuilder sb = new StringBuilder();
        while (index >= 0) {
            sb.insert(0, (char) ('A' + (index % 26)));
            index = (index / 26) - 1;
        }
        return sb.toString();
    }

    public int convertStrandNameToId(String strandName) {
        String sql = "SELECT strand_id FROM strands WHERE strand_name = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, strandName);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("strand_id");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return -1;
    }

    //* Check if student exists in student table
    public boolean studentExists(int studentId) {
        String sql = "SELECT COUNT(*) FROM student WHERE student_id = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, studentId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    //* Check if student is already enrolled in the same grade level and strand
    public boolean isStudentAlreadyEnrolled(int studentId, int gradeLevel, int strandId) {
        String sql = "SELECT COUNT(*) FROM student_strand WHERE student_id = ? AND grade_level = ? AND strand_id = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, studentId);
            ps.setInt(2, gradeLevel);
            ps.setInt(3, strandId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    /**
     * Check if student is enrolled in any strand
     */
    public boolean isStudentEnrolledInAnyStrand(int studentId) {
        String sql = "SELECT COUNT(*) FROM student_strand WHERE student_id = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, studentId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    /**
     * Insert into student_strand table
     */
    public boolean insertStudentStrand(int studentId, int strandId, int gradeLevel, String sectionName) {
        // Validate inputs
        if (gradeLevel < 11 || gradeLevel > 12) {
            System.out.println("Invalid grade level: " + gradeLevel);
            return false;
        }

        if (sectionName == null || sectionName.trim().isEmpty()) {
            System.out.println("Section cannot be empty");
            return false;
        }

        try {
            // Get section_id from section table
            String sectionSql = "SELECT section_id FROM section WHERE grade_level = ? AND strand_id = ? AND section_name = ?";
            PreparedStatement psSection = con.prepareStatement(sectionSql);
            psSection.setInt(1, gradeLevel);
            psSection.setInt(2, strandId);
            psSection.setString(3, sectionName.trim());
            ResultSet rs = psSection.executeQuery();

            if (!rs.next()) {
                System.out.println("Section not found: " + sectionName);
                return false;
            }

            int sectionId = rs.getInt("section_id");

            // Insert into student_strand
            String sql = "INSERT INTO student_strand (strand_id, student_id, grade_level, section_id) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, strandId);
            ps.setInt(2, studentId);
            ps.setInt(3, gradeLevel);
            ps.setInt(4, sectionId);

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Successfully enrolled Student " + studentId
                        + " in Strand " + strandId
                        + " Grade " + gradeLevel
                        + " Section " + sectionName);
                return true;
            }

        } catch (SQLException ex) {
            if (ex.getErrorCode() == 1062 || ex.getMessage().contains("Duplicate entry")) {
                System.out.println("Duplicate enrollment: Student " + studentId
                        + " is already enrolled in Strand " + strandId
                        + " Grade " + gradeLevel);
            } else if (ex.getErrorCode() == 1452) {
                System.out.println("Foreign key violation: Invalid student_id, strand_id, or section_id");
            } else {
                ex.printStackTrace();
            }
        }

        return false;
    }

    public boolean updateStudentStrand(int studentId, int strandId, int gradeLevel, String section) {
        String sql = "UPDATE student_strand SET grade_level = ?, section_name = ? WHERE student_id = ? AND strand_id = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, gradeLevel);
            ps.setString(2, section);
            ps.setInt(3, studentId);
            ps.setInt(4, strandId);

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0; // Returns true if update was successful
        } catch (SQLException ex) {
            System.getLogger(Strand.class.getName()).log(System.Logger.Level.ERROR, "Error updating student strand", ex);
            return false;
        }
    }

    public boolean isStudentEnrolledInStrandAndGrade(int studentId, int strandId, int gradeLevel) {
        String sql = "SELECT COUNT(*) FROM student_strand WHERE student_id = ? AND strand_id = ? AND grade_level = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, studentId);
            ps.setInt(2, strandId);
            ps.setInt(3, gradeLevel);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException ex) {
            System.getLogger(Strand.class.getName()).log(System.Logger.Level.ERROR, "Error checking strand and grade enrollment", ex);
        }
        return false;
    }

    /**
     * Load student strands table (replace your strand.getStrandValue method)
     */
    public void loadStudentStrandsTable(JTable table, String search) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0); // Clear existing data

        String sql = """
            SELECT 
                ss.student_id,
                CONCAT(s.last_name, ', ', s.first_name, ' ', COALESCE(s.middle_name, '')) AS student_name,
                ss.grade_level,
                st.strand_name,
                sec.section_name
            FROM student_strand ss
            JOIN student s ON ss.student_id = s.student_id
            JOIN strands st ON ss.strand_id = st.strand_id
            JOIN section sec ON ss.section_id = sec.section_id
            WHERE s.last_name LIKE ?
               OR s.first_name LIKE ?
               OR s.middle_name LIKE ?
               OR st.strand_name LIKE ?
               OR sec.section_name LIKE ?
               OR CAST(ss.student_id AS CHAR) LIKE ?
            ORDER BY ss.student_id
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
                    rs.getString("section_name")
                });
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public String getStudentNameById(int studentId) {
        String sql = """
        SELECT CONCAT(s.last_name, ', ', s.first_name, ' ', COALESCE(s.middle_name, '')) AS student_name
        FROM student s
        WHERE s.student_id = ?
    """;

        try (PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setInt(1, studentId);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                return rs.getString("student_name");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return "Unknown Student"; // Default if no record found
    }

    public String[] getStrandAndSectionName(Connection con, int sectionId) {
        String[] names = new String[2]; // [0] = strandName, [1] = sectionName
        String sql = "SELECT st.strand_name, sec.section_name "
                + "FROM section sec "
                + "JOIN strands st ON sec.strand_id = st.strand_id "
                + "WHERE sec.section_id = ?";

        try (PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setInt(1, sectionId);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                names[0] = rs.getString("strand_name");
                names[1] = rs.getString("section_name");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return names;
    }

//    public void generateClassList(JTable table, int gradeLevel, int strandId, int sectionId,
//            String strandName, String sectionName) {
//        try {
//            // Let user choose where to save file
//            JFileChooser fileChooser = new JFileChooser();
//            fileChooser.setDialogTitle("Save Class List PDF");
//            fileChooser.setSelectedFile(new File("ClassList_G" + gradeLevel + "_"
//                    + strandName + "_Sec" + sectionName + ".pdf"));
//
//            int userSelection = fileChooser.showSaveDialog(null);
//            if (userSelection != JFileChooser.APPROVE_OPTION) {
//                JOptionPane.showMessageDialog(null, "Save command canceled.");
//                return;
//            }
//
//            File fileToSave = fileChooser.getSelectedFile();
//
//            // 🔹 Prepare data from JTable
//            List<Map<String, Object>> dataList = new ArrayList<>();
//            DefaultTableModel model = (DefaultTableModel) table.getModel();
//            for (int i = 0; i < model.getRowCount(); i++) {
//                Map<String, Object> row = new HashMap<>();
//                row.put("lrn", model.getValueAt(i, 0).toString());
//                row.put("fullName", model.getValueAt(i, 1).toString());
//                dataList.add(row);
//            }
//
//            JRDataSource dataSource = new JRBeanCollectionDataSource(dataList);
//
//            String reportPath = "D:/PROJECTS/Student_Management_System_CDONHS_SHS/src/reports/class_list_fixed.jrxml";
//            JasperReport jasperReport = JasperCompileManager.compileReport(reportPath);
//
//            // 🔹 Parameters
//            Map<String, Object> params = new HashMap<>();
//            params.put("GradeLevel", gradeLevel);
//            params.put("StrandName", strandName);
//            params.put("SectionName", sectionName);
//
//            // 🔹 Fill report
//            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, dataSource);
//
//            // 🔹 Export to PDF
//            JasperExportManager.exportReportToPdfFile(jasperPrint, fileToSave.getAbsolutePath());
//
//            JOptionPane.showMessageDialog(null, "PDF Created: " + fileToSave.getAbsolutePath());
//        } catch (Exception e) {
//            e.printStackTrace();
//            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
//        }
//    }
    public void generateClassList(JTable table, int gradeLevel, int strandId, int sectionId,
            String strandName, String sectionName) {
        try {
            // Let user choose where to save file
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Save Class List PDF");
            fileChooser.setSelectedFile(new File("ClassList_G" + gradeLevel + "_"
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
            Paragraph title = new Paragraph("Class List",
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
            PdfPTable pdfTable = new PdfPTable(2);
            pdfTable.setWidthPercentage(100);

            // ✅ Allow multi-page
            pdfTable.setSplitLate(false);
            pdfTable.setHeaderRows(1);

            // Headers
            PdfPCell header1 = new PdfPCell(new Phrase("LRN"));
            PdfPCell header2 = new PdfPCell(new Phrase("Full Name"));
            header1.setHorizontalAlignment(Element.ALIGN_CENTER);
            header2.setHorizontalAlignment(Element.ALIGN_CENTER);
            pdfTable.addCell(header1);
            pdfTable.addCell(header2);

            // Fill rows from JTable
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            for (int i = 0; i < model.getRowCount(); i++) {
                pdfTable.addCell(model.getValueAt(i, 0).toString()); // LRN
                pdfTable.addCell(model.getValueAt(i, 1).toString()); // Name
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

    public int getSelectedSectionId(JComboBox sectionBox) {
        ComboItem item = (ComboItem) sectionBox.getSelectedItem();
        return item != null ? item.getId() : -1;
    }

//    public DefaultTableModel getStudentClassList(int gradeLevel, int strandId, int sectionId) {
//        DefaultTableModel model = new DefaultTableModel(
//                null,
//                new Object[]{"LRN", "Student Name"}
//        );
//
//        try (Connection conn = MyConnection.getConnection()) {
//            String sql = "SELECT s.LRN, "
//                    + "CONCAT(s.last_name, ', ', s.first_name, ' ', COALESCE(s.middle_name, '')) AS full_name, "
//                    + "sec.section_name, "
//                    + "ss.grade_level, "
//                    + "st.strand_name "
//                    + "FROM student s "
//                    + "INNER JOIN student_strand ss ON s.student_id = ss.student_id "
//                    + "INNER JOIN section sec ON ss.section_id = sec.section_id "
//                    + "INNER JOIN strands st ON ss.strand_id = st.strand_id "
//                    + "WHERE ss.grade_level = ? "
//                    + "AND ss.strand_id = ? "
//                    + "AND ss.section_id = ? "
//                    + "ORDER BY s.last_name;";
//
//            PreparedStatement pst = conn.prepareStatement(sql);
//            pst.setInt(1, gradeLevel);
//            pst.setInt(2, strandId);
//            pst.setInt(3, sectionId);
//
//            ResultSet rs = pst.executeQuery();
//
//            while (rs.next()) {
//                String lrn = rs.getString("LRN");
//                String studentName = rs.getString("full_name"); // ✅ fixed
//                model.addRow(new Object[]{lrn, studentName});
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return model;
//    }
    public DefaultTableModel getStudentClassList(int gradeLevel, int strandId, int sectionId) {
        DefaultTableModel model = new DefaultTableModel(
                null,
                new Object[]{"LRN", "Student Name"}
        );

        String sql = """
            SELECT s.LRN,
                   CONCAT(s.last_name, ', ', s.first_name, ' ', COALESCE(s.middle_name, '')) AS full_name
            FROM student s
            INNER JOIN student_strand ss ON s.student_id = ss.student_id
            INNER JOIN section sec ON ss.section_id = sec.section_id
            WHERE sec.grade_level = ?
              AND sec.strand_id = ?
              AND ss.section_id = ?
            ORDER BY s.last_name;
        """;

        try (Connection conn = MyConnection.getConnection(); PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setInt(1, gradeLevel);
            pst.setInt(2, strandId);
            pst.setInt(3, sectionId);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                String lrn = rs.getString("LRN");
                String studentName = rs.getString("full_name");
                model.addRow(new Object[]{lrn, studentName});
            }

            if (model.getRowCount() == 0) {
                JOptionPane.showMessageDialog(null,
                        "No students found for this grade level, strand, and section.",
                        "Information",
                        JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error loading student class list: " + e.getMessage());
        }

        return model;
    }

    public void loadStrands(JComboBox strandBox, int gradeLevel) {
        strandBox.removeAllItems();
        try (PreparedStatement pst = con.prepareStatement(
                "SELECT strand_id, strand_name FROM strands WHERE strand_id IN "
                + "(SELECT DISTINCT strand_id FROM section WHERE grade_level = ?)")) {

            pst.setInt(1, gradeLevel);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                strandBox.addItem(new ComboItem(rs.getInt("strand_id"), rs.getString("strand_name")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void loadSections(JComboBox sectionBox, int strandId, int gradeLevel) {
        System.out.println("it reads");
        sectionBox.removeAllItems();
        try (PreparedStatement pst = con.prepareStatement(
                "SELECT section_id, section_name FROM section WHERE strand_id = ? AND grade_level = ?")) {
            pst.setInt(1, strandId);
            pst.setInt(2, gradeLevel);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                sectionBox.addItem(new ComboItem(rs.getInt("section_id"), rs.getString("section_name")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
