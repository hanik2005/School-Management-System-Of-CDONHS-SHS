/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Main;

import static Main.Home.sectionClassBox;
import static Main.Home.stuStrandId;
import db.MyConnection;
import design.BackgroundPanel;
import design.ThemeColors;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.print.PrinterException;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import javax.naming.spi.DirStateFactory.Result;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.Information;
import java.sql.*;
import javax.swing.JTextField;
import model.ComboItem;
import model.SensitiveInformation;

/**
 *
 * @author ADMIN
 */
public class AdminFrame extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(AdminFrame.class.getName());

    Student student = new Student();
    StudentProgress progress = new StudentProgress();
    private static int adminId;
    DefaultTableModel subjectModel;
    Strand strand = new Strand();
    Grade grade = new Grade();
    User user = new User();
    Archive archive = new Archive();
    //Home home = new Home();
    Teacher teacher = new Teacher();
    ListOfHonor marksSheet = new ListOfHonor();
    Connection con = MyConnection.getConnection();

    int xx, xy;
    private DefaultTableModel model;
    private String imagePath;
    private int rowIndex;
    NumberFormat nf = NumberFormat.getInstance();
    private String birthCertificatePath;
    private String form137Path;

    /**
     * Creates new form AdminFrame
     */
    public AdminFrame(int adminId) {
        this.adminId = adminId;
        initComponents();
        init();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    public void init() {

        setBackgroundPanel();
        setTime();
        setDate();
        tableViewStudent();
        tableViewTeacher();
        tableViewStrand();
        tableViewSubject();
        tableViewClassList();
//        tableViewGrades();
//        tableViewFinalGrade();
        stuID.setText(String.valueOf(student.getMax()));
        teacherID.setText(String.valueOf(teacher.getMax()));
        //strandId.setText(String.valueOf(strand.getMax()));
        //idGradeManage.setText(String.valueOf(grade.getMax()));
    }

    public void setBackgroundPanel() {
        BackgroundPanel bgPanel2 = new BackgroundPanel("/assets/background.jpg");
        bgPanel2.setLayout(new BorderLayout());
        jPanel2.setLayout(new BorderLayout());
        jPanel2.add(bgPanel2, BorderLayout.CENTER);
        jPanel2.revalidate();
        jPanel2.repaint();

        BackgroundPanel bgPanel3 = new BackgroundPanel("/assets/background.jpg");
        bgPanel3.setLayout(new BorderLayout());
        jPanel10.setLayout(new BorderLayout());
        jPanel10.add(bgPanel3, BorderLayout.CENTER);
        jPanel10.revalidate();
        jPanel10.repaint();

        BackgroundPanel bgPanel4 = new BackgroundPanel("/assets/background.jpg");
        bgPanel4.setLayout(new BorderLayout());
        jPanel6.setLayout(new BorderLayout());
        jPanel6.add(bgPanel4, BorderLayout.CENTER);
        jPanel6.revalidate();
        jPanel6.repaint();

        BackgroundPanel bgPanel5 = new BackgroundPanel("/assets/background.jpg");
        bgPanel5.setLayout(new BorderLayout());
        jPanel19.setLayout(new BorderLayout());
        jPanel19.add(bgPanel5, BorderLayout.CENTER);
        jPanel19.revalidate();
        jPanel19.repaint();

        BackgroundPanel bgPanel6 = new BackgroundPanel("/assets/background.jpg");
        bgPanel6.setLayout(new BorderLayout());
        jPanel27.setLayout(new BorderLayout());
        jPanel27.add(bgPanel6, BorderLayout.CENTER);
        jPanel27.revalidate();
        jPanel27.repaint();

        BackgroundPanel bgPanel7 = new BackgroundPanel("/assets/background.jpg");
        bgPanel7.setLayout(new BorderLayout());
        jPanel38.setLayout(new BorderLayout());
        jPanel38.add(bgPanel7, BorderLayout.CENTER);
        jPanel38.revalidate();
        jPanel38.repaint();

        BackgroundPanel bgPanel8 = new BackgroundPanel("/assets/background.jpg");
        bgPanel8.setLayout(new BorderLayout());
        jPanel44.setLayout(new BorderLayout());
        jPanel44.add(bgPanel8, BorderLayout.CENTER);
        jPanel44.revalidate();
        jPanel44.repaint();

        BackgroundPanel bgPanel9 = new BackgroundPanel("/assets/background.jpg");
        bgPanel9.setLayout(new BorderLayout());
        jPanel31.setLayout(new BorderLayout());
        jPanel31.add(bgPanel9, BorderLayout.CENTER);
        jPanel31.revalidate();
        jPanel31.repaint();
    }

    public void tableViewStudent() {
        student.getStudentValue(StudentTable, "");
        model = (DefaultTableModel) StudentTable.getModel();
        StudentTable.setRowHeight(30);
        StudentTable.setShowGrid(true);
        StudentTable.setGridColor(Color.black);
        StudentTable.setBackground(Color.white);
    }

    public void tableViewSubject() {
        model = (DefaultTableModel) SubjectTable.getModel();
        SubjectTable.setRowHeight(30);
        SubjectTable.setShowGrid(true);
        SubjectTable.setGridColor(Color.black);
        SubjectTable.setBackground(Color.white);

        subjectModel = new DefaultTableModel(
                new Object[]{"Subject_ID", "Subject_Name", "Status"}, 0
        ) {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                if (columnIndex == 2) { // Status column
                    return Boolean.class; // Checkbox
                }
                return String.class;
            }

            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 2;
            }
        };
        SubjectTable.setModel(subjectModel); // attach to JTable
    }

    private void tableViewStrand() {
        strand.loadStudentStrandsTable(StudentTrackTable, "");
        model = (DefaultTableModel) StudentTrackTable.getModel();
        StudentTrackTable.setRowHeight(30);
        StudentTrackTable.setShowGrid(true);
        StudentTrackTable.setGridColor(Color.black);
        StudentTrackTable.setBackground(Color.white);
    }

    public void tableViewClassList() {
        model = (DefaultTableModel) ClassListTable.getModel();
        ClassListTable.setRowHeight(30);
        ClassListTable.setShowGrid(true);
        ClassListTable.setGridColor(Color.black);
        ClassListTable.setBackground(Color.white);

    }

    private void tableViewTeacher() {
        teacher.getTeacherValue(TeacherTable, "");
        model = (DefaultTableModel) TeacherTable.getModel();
        TeacherTable.setRowHeight(30);
        TeacherTable.setShowGrid(true);
        TeacherTable.setGridColor(Color.black);
        TeacherTable.setBackground(Color.white);
    }

    private void clearTeacher() {
        teacherID.setText(String.valueOf(teacher.getMax()));
        teacherFirstName.setText(null);
        teacherMidName.setText(null);
        teacherLastName.setText(null);
        teacherBirth.setDate(null);
        teacherGender.setSelectedIndex(0);
        teacherEmail.setText(null);
        teacherPhone.setText(null);
        teacherAddress1.setText(null);
        teacherAddress2.setText(null);
        teacherImagePanel.setIcon(null);
        teacherStrand.setSelectedIndex(0);
        TeacherTable.clearSelection();
        imagePath = null;

    }

    public void clearStudent() {
        stuID.setText(String.valueOf(student.getMax()));
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
        stuBirthCer.setText(null);
        stuForm137.setText(null);
        imagePanel.setIcon(null);
        StudentTable.clearSelection();
        imagePath = null;
        stuLRN.setText(null);

    }

    public void clearSubjectManage() {
        stuSubjectIDManage.setText(null);
        gradeLevelSubjectBox.setSelectedIndex(0);
        DefaultTableModel model = (DefaultTableModel) SubjectTable.getModel();
        model.setRowCount(0); // ✅ clears rows without breaking references

    }

    public void clearClassListManage() {
        gradeLevelClassBox.setSelectedIndex(0);
        strandClassBox.removeAllItems();
        sectionClassBox.removeAllItems();
        ClassListTable.setModel(new DefaultTableModel(null, new Object[]{"LRN", "Student_Name"}));
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
        String firstName = stuFname.getText();
        String middleName = stuMiddleName.getText();
        String lastName = stuLastName.getText();

        if (student.isNameExist(firstName, middleName, lastName)) {
            JOptionPane.showMessageDialog(this, "this name already exist");
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
        if (stuAddress2.getText().length() > 50) {
            JOptionPane.showMessageDialog(this, "Address Line 2 must not exceed 50 characters");
            return false;
        }
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
        if (student.isLRNExist(stuLRN.getText())) {
            JOptionPane.showMessageDialog(this, "This LRN already Exist");
            return false;

        }

        // Image
//        if (imagePath == null) {
//            JOptionPane.showMessageDialog(this, "Please add your image");
//            return false;
//        }
        return true;
    }

    public boolean isEmptyTeacher() {
        if (teacherFirstName.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Teacher first name is missing");
            return false;
        }
        if (teacherFirstName.getText().length() > 50) {
            JOptionPane.showMessageDialog(this, "Teacher first name must not exceed 50 characters");
            return false;
        }

        if (teacherMidName.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Teacher middle name is missing");
            return false;
        }
        if (teacherMidName.getText().length() > 50) {
            JOptionPane.showMessageDialog(this, "Teacher middle name must not exceed 50 characters");
            return false;
        }

        if (teacherLastName.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Teacher last name is missing");
            return false;
        }
        if (teacherLastName.getText().length() > 50) {
            JOptionPane.showMessageDialog(this, "Teacher last name must not exceed 50 characters");
            return false;
        }
        String firstName = teacherFirstName.getText();
        String middleName = teacherMidName.getText();
        String lastName = teacherLastName.getText();

        if (teacher.isNameExist(firstName, middleName, lastName)) {
            JOptionPane.showMessageDialog(this, "this name already exist");
            return false;
        }

        if (teacherBirth.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Teacher date of birth is missing");
            return false;
        }
        if (teacherBirth.getDate().compareTo(new Date()) > 0) {
            JOptionPane.showMessageDialog(this, "No Teacher from the future is allowed");
            return false;
        }

        if (teacherEmail.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Teacher email is missing");
            return false;
        }
        if (!teacherEmail.getText().matches("^.+@.+\\..+$")) {
            JOptionPane.showMessageDialog(this, "Invalid Email Address");
            return false;
        }
        if (teacherEmail.getText().length() > 50) {
            JOptionPane.showMessageDialog(this, "Teacher email must not exceed 50 characters");
            return false;
        }

        if (teacherPhone.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Teacher phone number is missing");
            return false;
        }
        if (teacherPhone.getText().length() != 11) {
            JOptionPane.showMessageDialog(this, "Phone number must be exactly 11 digits");
            return false;
        }

        if (teacherAddress1.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Address Line 1 is missing");
            return false;
        }
        if (teacherAddress1.getText().length() > 50) {
            JOptionPane.showMessageDialog(this, "Address Line 1 must not exceed 50 characters");
            return false;
        }

        if (teacherAddress2.getText().length() > 50) {
            JOptionPane.showMessageDialog(this, "Address Line 2 must not exceed 50 characters");
            return false;
        }

        return true;
    }

    public void clearStrand() {
        //strandId.setText(String.valueOf(strand.getMax()));
        stuStrandId.setText(null);
        stuFullName.setText(null);
        stuGradeLevel.setSelectedIndex(0);
        stuStrand.removeAllItems();
        stuSection.removeAllItems();
        StudentTrackTable.clearSelection();
        stuStrandSearchField.setText(null);

    }

    public boolean check() {
        int id = Integer.parseInt(stuID.getText()); // current student ID
        String newEmail = stuEmail.getText();
        String newPhone = stuPhone.getText();
        String oldEmail = model.getValueAt(rowIndex, 4).toString();
        String oldPhone = model.getValueAt(rowIndex, 5).toString();
        if (newEmail.equals(oldEmail) && newPhone.equals(oldPhone)) {
            return false;

        } else {
            if (!newEmail.equals(oldEmail)) {
                boolean x = student.isEmailExist(newEmail, id);
                if (x) {
                    JOptionPane.showMessageDialog(this, "the email already exist");

                }
                return x;
            }
            if (!newPhone.equals(oldPhone)) {
                boolean x = student.isPhoneExist(newPhone, id);
                if (x) {
                    JOptionPane.showMessageDialog(this, "the phone number already exist");

                }
                return x;
            }
//         
        }
        return false;

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
        stuID = new javax.swing.JTextField();
        stuFname = new javax.swing.JTextField();
        stuMotherName = new javax.swing.JTextField();
        stuAddress1 = new javax.swing.JTextField();
        stuAddress2 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
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
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        browseBirthCertificate = new javax.swing.JButton();
        browseForm137 = new javax.swing.JButton();
        stuBirthCer = new javax.swing.JTextField();
        stuForm137 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        stuMiddleName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        stuLastName = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        imagePanel = new javax.swing.JLabel();
        browseImg = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jPanel39 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        stuLRN = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        updateBt = new javax.swing.JButton();
        addNewBt = new javax.swing.JButton();
        Clear = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        stuSearchField_1 = new javax.swing.JTextField();
        searchBt_1 = new javax.swing.JButton();
        stuRefresh_1 = new javax.swing.JButton();
        stuSort_1 = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        StudentTable = new javax.swing.JTable();
        jPanel13 = new javax.swing.JPanel();
        delBt = new javax.swing.JButton();
        stuPrint_1 = new javax.swing.JButton();
        stuInfoCurrentOrArchived = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel36 = new javax.swing.JPanel();
        jLabel66 = new javax.swing.JLabel();
        stuStrandSearchField = new javax.swing.JTextField();
        stuStrandSearchBt = new javax.swing.JButton();
        stuStrandId = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        stuGradeLevel = new javax.swing.JComboBox<>();
        stuStrand = new javax.swing.JComboBox<>();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        stuSection = new javax.swing.JComboBox<>();
        jLabel27 = new javax.swing.JLabel();
        stuFullName = new javax.swing.JTextField();
        jPanel16 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jPanel35 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        stuSearchField_2 = new javax.swing.JTextField();
        stuSearchBt_2 = new javax.swing.JButton();
        stuRefresh_2 = new javax.swing.JButton();
        stuSort_2 = new javax.swing.JButton();
        jPanel18 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        StudentTrackTable = new javax.swing.JTable();
        jPanel20 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        stuStrandClearBt = new javax.swing.JButton();
        stuSaveBt = new javax.swing.JButton();
        stuRestore = new javax.swing.JButton();
        stuCurrentOrArchive = new javax.swing.JButton();
        jPanel37 = new javax.swing.JPanel();
        jPanel38 = new javax.swing.JPanel();
        jPanel40 = new javax.swing.JPanel();
        jPanel46 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        SubjectTable = new javax.swing.JTable();
        jPanel47 = new javax.swing.JPanel();
        stuSubjectIDManage = new javax.swing.JTextField();
        stuSubjectSearch = new javax.swing.JButton();
        stuGradeManageRefreshTable1 = new javax.swing.JButton();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        gradeLevelSubjectBox = new javax.swing.JComboBox<>();
        stuFullNameSub = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        jPanel48 = new javax.swing.JPanel();
        clearSubjectManageBt = new javax.swing.JButton();
        logoutFormGradeBt1 = new javax.swing.JButton();
        stuSubjectSaveBt = new javax.swing.JButton();
        jPanel44 = new javax.swing.JPanel();
        jPanel45 = new javax.swing.JPanel();
        jPanel50 = new javax.swing.JPanel();
        classListSearchBt = new javax.swing.JButton();
        jLabel72 = new javax.swing.JLabel();
        gradeLevelClassBox = new javax.swing.JComboBox<>();
        strandClassBox = new javax.swing.JComboBox<>();
        jLabel81 = new javax.swing.JLabel();
        sectionClassBox = new javax.swing.JComboBox<>();
        jLabel82 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        ClassListTable = new javax.swing.JTable();
        jPanel49 = new javax.swing.JPanel();
        classListLogoutBt = new javax.swing.JButton();
        classListClearBt = new javax.swing.JButton();
        classListPrintBt = new javax.swing.JButton();
        jPanel19 = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        teacherID = new javax.swing.JTextField();
        teacherFirstName = new javax.swing.JTextField();
        teacherAddress1 = new javax.swing.JTextField();
        teacherAddress2 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        teacherBirth = new com.toedter.calendar.JDateChooser();
        jLabel68 = new javax.swing.JLabel();
        teacherGender = new javax.swing.JComboBox<>();
        jLabel69 = new javax.swing.JLabel();
        teacherEmail = new javax.swing.JTextField();
        jLabel70 = new javax.swing.JLabel();
        teacherPhone = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        teacherMidName = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        teacherLastName = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        teacherStrand = new javax.swing.JComboBox<>();
        jPanel22 = new javax.swing.JPanel();
        jPanel23 = new javax.swing.JPanel();
        jPanel24 = new javax.swing.JPanel();
        jPanel25 = new javax.swing.JPanel();
        teacherImagePanel = new javax.swing.JLabel();
        teacherBrowseImg = new javax.swing.JButton();
        jLabel29 = new javax.swing.JLabel();
        jPanel26 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        updateBt1 = new javax.swing.JButton();
        teacherAddNewBt = new javax.swing.JButton();
        teacherClear = new javax.swing.JButton();
        jPanel27 = new javax.swing.JPanel();
        jPanel28 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        teacherSearchField_3 = new javax.swing.JTextField();
        teacherSearchBt_2 = new javax.swing.JButton();
        teacherRefresh_3 = new javax.swing.JButton();
        teacherSort_3 = new javax.swing.JButton();
        jPanel29 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TeacherTable = new javax.swing.JTable();
        jPanel30 = new javax.swing.JPanel();
        teacherPrint_3 = new javax.swing.JButton();
        jPanel31 = new javax.swing.JPanel();
        jPanel32 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        searchSensitive = new javax.swing.JTextField();
        sensitiveSearch = new javax.swing.JButton();
        jPanel33 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        SensitiveTable = new javax.swing.JTable();
        jPanel34 = new javax.swing.JPanel();
        teacherSensitiveLogout = new javax.swing.JButton();

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
        jLabel1.setText("ADMIN PANEL");

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
                .addGap(144, 144, 144)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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

        jPanel2.setBackground(new java.awt.Color(30, 58, 138));

        jPanel4.setBackground(new java.awt.Color(243, 244, 246));
        jPanel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(55, 65, 81), 4, true));
        jPanel4.setForeground(new java.awt.Color(0, 0, 0));

        stuID.setEditable(false);
        stuID.setBackground(new java.awt.Color(204, 204, 204));
        stuID.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        stuID.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(30, 58, 138)));

        stuFname.setBackground(java.awt.Color.white);
        stuFname.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        stuFname.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(30, 58, 138)));
        stuFname.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                stuFnameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                stuFnameFocusLost(evt);
            }
        });
        stuFname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stuFnameActionPerformed(evt);
            }
        });

        stuMotherName.setBackground(java.awt.Color.white);
        stuMotherName.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        stuMotherName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(30, 58, 138)));
        stuMotherName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                stuMotherNameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                stuMotherNameFocusLost(evt);
            }
        });
        stuMotherName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stuMotherNameActionPerformed(evt);
            }
        });

        stuAddress1.setBackground(java.awt.Color.white);
        stuAddress1.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        stuAddress1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(30, 58, 138)));
        stuAddress1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                stuAddress1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                stuAddress1FocusLost(evt);
            }
        });

        stuAddress2.setBackground(java.awt.Color.white);
        stuAddress2.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        stuAddress2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(30, 58, 138)));
        stuAddress2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                stuAddress2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                stuAddress2FocusLost(evt);
            }
        });
        stuAddress2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stuAddress2ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(17, 24, 39));
        jLabel2.setText("Student's ID");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(17, 24, 39));
        jLabel3.setText("First Name");

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(17, 24, 39));
        jLabel9.setText("Mother's Name");

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(17, 24, 39));
        jLabel10.setText("Address Line 1");

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(17, 24, 39));
        jLabel11.setText("Address Line 2");

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
        stuFatherName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                stuFatherNameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                stuFatherNameFocusLost(evt);
            }
        });
        stuFatherName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stuFatherNameActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(17, 24, 39));
        jLabel13.setText("Birth Certificate");

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(17, 24, 39));
        jLabel14.setText("Form 137");

        browseBirthCertificate.setBackground(new java.awt.Color(251, 191, 36));
        browseBirthCertificate.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        browseBirthCertificate.setForeground(new java.awt.Color(0, 0, 0));
        browseBirthCertificate.setText("Browse");
        browseBirthCertificate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseBirthCertificateActionPerformed(evt);
            }
        });

        browseForm137.setBackground(new java.awt.Color(251, 191, 36));
        browseForm137.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        browseForm137.setForeground(new java.awt.Color(0, 0, 0));
        browseForm137.setText("Browse");
        browseForm137.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseForm137ActionPerformed(evt);
            }
        });

        stuBirthCer.setEditable(false);
        stuBirthCer.setBackground(new java.awt.Color(204, 204, 204));
        stuBirthCer.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(30, 58, 138)));
        stuBirthCer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stuBirthCerActionPerformed(evt);
            }
        });

        stuForm137.setEditable(false);
        stuForm137.setBackground(new java.awt.Color(204, 204, 204));
        stuForm137.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(30, 58, 138)));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(17, 24, 39));
        jLabel4.setText("Middle Name");

        stuMiddleName.setBackground(java.awt.Color.white);
        stuMiddleName.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        stuMiddleName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(30, 58, 138)));
        stuMiddleName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                stuMiddleNameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                stuMiddleNameFocusLost(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(17, 24, 39));
        jLabel5.setText("Last Name");

        stuLastName.setBackground(java.awt.Color.white);
        stuLastName.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        stuLastName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(30, 58, 138)));
        stuLastName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                stuLastNameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                stuLastNameFocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(stuID, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(stuMotherName, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(stuAddress1, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel61)
                            .addComponent(jLabel62, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(stuGender, 0, 133, Short.MAX_VALUE)
                            .addComponent(stuBirth, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel63)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(stuEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel64, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(stuPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel65, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(stuFatherName, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel14)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(browseBirthCertificate)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(stuBirthCer))
                            .addComponent(stuAddress2, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(browseForm137)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(stuForm137))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(31, 31, 31)))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(stuFname, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(stuMiddleName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(stuLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(stuID, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(stuFname, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(stuMiddleName, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(stuLastName, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(16, 16, 16)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel61)
                    .addComponent(stuBirth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel62, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stuGender, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel63)
                    .addComponent(stuEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel64)
                    .addComponent(stuPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel65)
                    .addComponent(stuFatherName, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(stuMotherName, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(stuAddress1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(stuAddress2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(stuBirthCer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13)
                        .addComponent(browseBirthCertificate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(12, 12, 12)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(stuForm137, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(browseForm137)
                        .addComponent(jLabel14)))
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(243, 244, 246));
        jPanel5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(55, 65, 81), 4, true));

        jPanel9.setBackground(new java.awt.Color(243, 244, 246));
        jPanel9.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(55, 65, 81), 4, true));

        jPanel14.setBackground(new java.awt.Color(243, 244, 246));
        jPanel14.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(55, 65, 81), 4, true));
        jPanel14.setForeground(new java.awt.Color(0, 0, 0));

        jPanel15.setBackground(new java.awt.Color(204, 204, 204));
        jPanel15.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(55, 65, 81), 2, true));

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(imagePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imagePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
        );

        browseImg.setBackground(new java.awt.Color(251, 191, 36));
        browseImg.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        browseImg.setForeground(new java.awt.Color(0, 0, 0));
        browseImg.setText("Browse");
        browseImg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                browseImgMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                browseImgMouseExited(evt);
            }
        });
        browseImg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseImgActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Image");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel12))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(browseImg)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(56, 56, 56)
                        .addComponent(browseImg, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(221, Short.MAX_VALUE))
        );

        jPanel39.setBackground(new java.awt.Color(243, 244, 246));
        jPanel39.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(55, 65, 81), 4, true));
        jPanel39.setForeground(new java.awt.Color(0, 0, 0));

        jLabel16.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(17, 24, 39));
        jLabel16.setText("LRN");

        stuLRN.setBackground(java.awt.Color.white);
        stuLRN.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        stuLRN.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(30, 58, 138)));
        stuLRN.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                stuLRNKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel39Layout = new javax.swing.GroupLayout(jPanel39);
        jPanel39.setLayout(jPanel39Layout);
        jPanel39Layout.setHorizontalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel39Layout.createSequentialGroup()
                .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel39Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel16))
                    .addGroup(jPanel39Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(stuLRN, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        jPanel39Layout.setVerticalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel39Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(stuLRN)
                .addGap(62, 62, 62))
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel39, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jPanel39, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
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

        addNewBt.setBackground(new java.awt.Color(251, 191, 36));
        addNewBt.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        addNewBt.setForeground(new java.awt.Color(0, 0, 0));
        addNewBt.setText("Add New");
        addNewBt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                addNewBtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                addNewBtMouseExited(evt);
            }
        });
        addNewBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNewBtActionPerformed(evt);
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
                .addContainerGap()
                .addComponent(addNewBt, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(updateBt, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(Clear, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Clear, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                    .addComponent(updateBt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addNewBt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 449, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(66, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Student", jPanel2);

        jPanel10.setBackground(new java.awt.Color(30, 58, 138));

        jPanel11.setBackground(new java.awt.Color(243, 244, 246));
        jPanel11.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(55, 65, 81), 4, true));

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setText("Search Student");

        stuSearchField_1.setBackground(new java.awt.Color(255, 255, 255));
        stuSearchField_1.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        stuSearchField_1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(30, 58, 138)));

        searchBt_1.setBackground(new java.awt.Color(251, 191, 36));
        searchBt_1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        searchBt_1.setForeground(new java.awt.Color(0, 0, 0));
        searchBt_1.setText("Search");
        searchBt_1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                searchBt_1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                searchBt_1MouseExited(evt);
            }
        });
        searchBt_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBt_1ActionPerformed(evt);
            }
        });

        stuRefresh_1.setBackground(new java.awt.Color(251, 191, 36));
        stuRefresh_1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        stuRefresh_1.setForeground(new java.awt.Color(0, 0, 0));
        stuRefresh_1.setText("Refresh");
        stuRefresh_1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                stuRefresh_1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                stuRefresh_1MouseExited(evt);
            }
        });
        stuRefresh_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stuRefresh_1ActionPerformed(evt);
            }
        });

        stuSort_1.setBackground(new java.awt.Color(251, 191, 36));
        stuSort_1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        stuSort_1.setForeground(new java.awt.Color(0, 0, 0));
        stuSort_1.setText("Sort");
        stuSort_1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                stuSort_1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                stuSort_1MouseExited(evt);
            }
        });
        stuSort_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stuSort_1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(stuSearchField_1, javax.swing.GroupLayout.PREFERRED_SIZE, 687, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(searchBt_1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(stuRefresh_1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(stuSort_1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                    .addComponent(stuSearchField_1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchBt_1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stuRefresh_1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stuSort_1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel12.setBackground(new java.awt.Color(243, 244, 246));

        StudentTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student_ID", "User_ID", "First_Name", "Middle_Name", "Last_Name", "Date Of Birth", "Gender", "Email", "Phone Number", "Father's Name", "Mother's Name", "Address Line 1", "Address Line 2", "LRN"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        StudentTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                StudentTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(StudentTable);

        jPanel13.setBackground(new java.awt.Color(243, 244, 246));
        jPanel13.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(55, 65, 81), 4, true));

        delBt.setBackground(new java.awt.Color(251, 191, 36));
        delBt.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        delBt.setForeground(new java.awt.Color(0, 0, 0));
        delBt.setText("Delete");
        delBt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                delBtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                delBtMouseExited(evt);
            }
        });
        delBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delBtActionPerformed(evt);
            }
        });

        stuPrint_1.setBackground(new java.awt.Color(251, 191, 36));
        stuPrint_1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        stuPrint_1.setForeground(new java.awt.Color(0, 0, 0));
        stuPrint_1.setText("Print");
        stuPrint_1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                stuPrint_1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                stuPrint_1MouseExited(evt);
            }
        });
        stuPrint_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stuPrint_1ActionPerformed(evt);
            }
        });

        stuInfoCurrentOrArchived.setBackground(new java.awt.Color(251, 191, 36));
        stuInfoCurrentOrArchived.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        stuInfoCurrentOrArchived.setForeground(new java.awt.Color(0, 0, 0));
        stuInfoCurrentOrArchived.setText("Current");
        stuInfoCurrentOrArchived.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                stuInfoCurrentOrArchivedMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                stuInfoCurrentOrArchivedMouseExited(evt);
            }
        });
        stuInfoCurrentOrArchived.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stuInfoCurrentOrArchivedActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap(274, Short.MAX_VALUE)
                .addComponent(stuPrint_1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(stuInfoCurrentOrArchived, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(delBt, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(393, 393, 393))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(delBt, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stuPrint_1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stuInfoCurrentOrArchived, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1344, Short.MAX_VALUE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 421, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Student Table", jPanel10);

        jPanel6.setBackground(new java.awt.Color(30, 58, 138));

        jPanel7.setBackground(new java.awt.Color(243, 244, 246));
        jPanel7.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(55, 65, 81), 4, true));
        jPanel7.setForeground(new java.awt.Color(0, 0, 0));

        jPanel36.setBackground(new java.awt.Color(243, 244, 246));
        jPanel36.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(55, 65, 81), 4, true));
        jPanel36.setForeground(new java.awt.Color(0, 0, 0));

        jLabel66.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel66.setForeground(new java.awt.Color(17, 24, 39));
        jLabel66.setText("Student's ID");

        stuStrandSearchField.setBackground(new java.awt.Color(255, 255, 255));
        stuStrandSearchField.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        stuStrandSearchField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(30, 58, 138)));
        stuStrandSearchField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stuStrandSearchFieldActionPerformed(evt);
            }
        });
        stuStrandSearchField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                stuStrandSearchFieldKeyTyped(evt);
            }
        });

        stuStrandSearchBt.setBackground(new java.awt.Color(251, 191, 36));
        stuStrandSearchBt.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        stuStrandSearchBt.setForeground(new java.awt.Color(0, 0, 0));
        stuStrandSearchBt.setText("Search");
        stuStrandSearchBt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                stuStrandSearchBtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                stuStrandSearchBtMouseExited(evt);
            }
        });
        stuStrandSearchBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stuStrandSearchBtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel36Layout = new javax.swing.GroupLayout(jPanel36);
        jPanel36.setLayout(jPanel36Layout);
        jPanel36Layout.setHorizontalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel36Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel36Layout.createSequentialGroup()
                        .addComponent(jLabel66)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel36Layout.createSequentialGroup()
                        .addComponent(stuStrandSearchField, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(stuStrandSearchBt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel36Layout.setVerticalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel36Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel66)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(stuStrandSearchBt, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(stuStrandSearchField))
                .addContainerGap())
        );

        stuStrandId.setEditable(false);
        stuStrandId.setBackground(new java.awt.Color(204, 204, 204));
        stuStrandId.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        stuStrandId.setForeground(new java.awt.Color(0, 0, 0));
        stuStrandId.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(30, 58, 138)));
        stuStrandId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stuStrandIdActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(17, 24, 39));
        jLabel19.setText("Student's ID");

        stuGradeLevel.setBackground(new java.awt.Color(255, 255, 255));
        stuGradeLevel.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        stuGradeLevel.setForeground(new java.awt.Color(0, 0, 0));
        stuGradeLevel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "11", "12" }));
        stuGradeLevel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stuGradeLevelActionPerformed(evt);
            }
        });

        stuStrand.setBackground(new java.awt.Color(255, 255, 255));
        stuStrand.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        stuStrand.setForeground(new java.awt.Color(0, 0, 0));
        stuStrand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stuStrandActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(17, 24, 39));
        jLabel20.setText("Grade Level");

        jLabel21.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(17, 24, 39));
        jLabel21.setText("Strand");

        jLabel25.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(17, 24, 39));
        jLabel25.setText("Section");

        stuSection.setBackground(new java.awt.Color(255, 255, 255));
        stuSection.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        stuSection.setForeground(new java.awt.Color(0, 0, 0));
        stuSection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stuSectionActionPerformed(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(17, 24, 39));
        jLabel27.setText("Full Name");

        stuFullName.setEditable(false);
        stuFullName.setBackground(new java.awt.Color(204, 204, 204));
        stuFullName.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        stuFullName.setForeground(new java.awt.Color(0, 0, 0));
        stuFullName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(30, 58, 138)));
        stuFullName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stuFullNameActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
                            .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(stuGradeLevel, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(stuStrand, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(stuSection, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jPanel36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel27))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(stuStrandId)
                            .addComponent(stuFullName))))
                .addGap(12, 12, 12))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(stuStrandId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(stuFullName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(stuGradeLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(stuStrand, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stuSection, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        jPanel16.setBackground(new java.awt.Color(243, 244, 246));
        jPanel16.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(55, 65, 81), 4, true));

        jPanel17.setBackground(new java.awt.Color(243, 244, 246));
        jPanel17.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(55, 65, 81), 4, true));

        jPanel35.setBackground(new java.awt.Color(243, 244, 246));
        jPanel35.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(55, 65, 81), 4, true));

        jLabel22.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(17, 24, 39));
        jLabel22.setText("Search Student");

        stuSearchField_2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(30, 58, 138)));

        stuSearchBt_2.setBackground(new java.awt.Color(251, 191, 36));
        stuSearchBt_2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        stuSearchBt_2.setForeground(new java.awt.Color(0, 0, 0));
        stuSearchBt_2.setText("Search");
        stuSearchBt_2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                stuSearchBt_2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                stuSearchBt_2MouseExited(evt);
            }
        });
        stuSearchBt_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stuSearchBt_2ActionPerformed(evt);
            }
        });

        stuRefresh_2.setBackground(new java.awt.Color(251, 191, 36));
        stuRefresh_2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        stuRefresh_2.setForeground(new java.awt.Color(0, 0, 0));
        stuRefresh_2.setText("Refresh");
        stuRefresh_2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                stuRefresh_2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                stuRefresh_2MouseExited(evt);
            }
        });
        stuRefresh_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stuRefresh_2ActionPerformed(evt);
            }
        });

        stuSort_2.setBackground(new java.awt.Color(251, 191, 36));
        stuSort_2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        stuSort_2.setForeground(new java.awt.Color(0, 0, 0));
        stuSort_2.setText("Sort");
        stuSort_2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                stuSort_2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                stuSort_2MouseExited(evt);
            }
        });
        stuSort_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stuSort_2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel35Layout = new javax.swing.GroupLayout(jPanel35);
        jPanel35.setLayout(jPanel35Layout);
        jPanel35Layout.setHorizontalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel35Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(stuSearchField_2, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(stuSearchBt_2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(stuSort_2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(stuRefresh_2)
                .addContainerGap())
        );
        jPanel35Layout.setVerticalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel35Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(stuSearchField_2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(stuSearchBt_2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stuRefresh_2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stuSort_2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );

        jPanel18.setBackground(new java.awt.Color(243, 244, 246));
        jPanel18.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(55, 65, 81), 4, true));

        StudentTrackTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student_ID", "Student Name", "Grade Level", "Strand", "Section"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(StudentTrackTable);

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel18Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane2)
                    .addContainerGap()))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 432, Short.MAX_VALUE)
            .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel18Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel35, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel20.setBackground(new java.awt.Color(243, 244, 246));
        jPanel20.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(55, 65, 81), 4, true));

        jButton2.setBackground(new java.awt.Color(251, 191, 36));
        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 0, 0));
        jButton2.setText("Logout");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton2MouseExited(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        stuStrandClearBt.setBackground(new java.awt.Color(251, 191, 36));
        stuStrandClearBt.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        stuStrandClearBt.setForeground(new java.awt.Color(0, 0, 0));
        stuStrandClearBt.setText("Clear");
        stuStrandClearBt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                stuStrandClearBtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                stuStrandClearBtMouseExited(evt);
            }
        });
        stuStrandClearBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stuStrandClearBtActionPerformed(evt);
            }
        });

        stuSaveBt.setBackground(new java.awt.Color(251, 191, 36));
        stuSaveBt.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        stuSaveBt.setForeground(new java.awt.Color(0, 0, 0));
        stuSaveBt.setText("Confirm");
        stuSaveBt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                stuSaveBtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                stuSaveBtMouseExited(evt);
            }
        });
        stuSaveBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stuSaveBtActionPerformed(evt);
            }
        });

        stuRestore.setBackground(new java.awt.Color(251, 191, 36));
        stuRestore.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        stuRestore.setForeground(new java.awt.Color(0, 0, 0));
        stuRestore.setText("Restore");
        stuRestore.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                stuRestoreMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                stuRestoreMouseExited(evt);
            }
        });
        stuRestore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stuRestoreActionPerformed(evt);
            }
        });

        stuCurrentOrArchive.setBackground(new java.awt.Color(251, 191, 36));
        stuCurrentOrArchive.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        stuCurrentOrArchive.setForeground(new java.awt.Color(0, 0, 0));
        stuCurrentOrArchive.setText("Current");
        stuCurrentOrArchive.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                stuCurrentOrArchiveMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                stuCurrentOrArchiveMouseExited(evt);
            }
        });
        stuCurrentOrArchive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stuCurrentOrArchiveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(stuSaveBt, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(stuRestore, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(stuCurrentOrArchive, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(stuStrandClearBt, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stuSaveBt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(stuCurrentOrArchive, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(stuRestore, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(stuStrandClearBt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 446, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Student Strand", jPanel6);

        jPanel37.setBackground(new java.awt.Color(30, 58, 138));

        jPanel38.setBackground(new java.awt.Color(243, 244, 246));
        jPanel38.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(55, 65, 81), 4, true));

        jPanel40.setBackground(new java.awt.Color(243, 244, 246));
        jPanel40.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(55, 65, 81), 4, true));
        jPanel40.setPreferredSize(new java.awt.Dimension(1380, 620));

        jPanel46.setBackground(new java.awt.Color(243, 244, 246));
        jPanel46.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(55, 65, 81), 4, true));

        SubjectTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Subject_ID", "Subject_Name", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane6.setViewportView(SubjectTable);

        javax.swing.GroupLayout jPanel46Layout = new javax.swing.GroupLayout(jPanel46);
        jPanel46.setLayout(jPanel46Layout);
        jPanel46Layout.setHorizontalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel46Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6)
                .addContainerGap())
        );
        jPanel46Layout.setVerticalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel46Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 452, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel47.setBackground(new java.awt.Color(243, 244, 246));
        jPanel47.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(55, 65, 81), 4, true));

        stuSubjectIDManage.setBackground(new java.awt.Color(255, 255, 255));
        stuSubjectIDManage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(30, 58, 138)));
        stuSubjectIDManage.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                stuSubjectIDManageKeyTyped(evt);
            }
        });

        stuSubjectSearch.setBackground(new java.awt.Color(251, 191, 36));
        stuSubjectSearch.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        stuSubjectSearch.setForeground(new java.awt.Color(0, 0, 0));
        stuSubjectSearch.setText("Search");
        stuSubjectSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                stuSubjectSearchMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                stuSubjectSearchMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                stuSubjectSearchMouseExited(evt);
            }
        });
        stuSubjectSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stuSubjectSearchActionPerformed(evt);
            }
        });

        stuGradeManageRefreshTable1.setBackground(new java.awt.Color(251, 191, 36));
        stuGradeManageRefreshTable1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        stuGradeManageRefreshTable1.setForeground(new java.awt.Color(0, 0, 0));
        stuGradeManageRefreshTable1.setText("Refresh");
        stuGradeManageRefreshTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                stuGradeManageRefreshTable1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                stuGradeManageRefreshTable1MouseExited(evt);
            }
        });
        stuGradeManageRefreshTable1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stuGradeManageRefreshTable1ActionPerformed(evt);
            }
        });

        jLabel39.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(0, 0, 0));
        jLabel39.setText("Student ID");

        jLabel40.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(0, 0, 0));
        jLabel40.setText("Grade Level");

        gradeLevelSubjectBox.setBackground(new java.awt.Color(255, 255, 255));
        gradeLevelSubjectBox.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        gradeLevelSubjectBox.setForeground(new java.awt.Color(0, 0, 0));
        gradeLevelSubjectBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "11", "12" }));
        gradeLevelSubjectBox.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(30, 58, 138)));
        gradeLevelSubjectBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gradeLevelSubjectBoxActionPerformed(evt);
            }
        });

        stuFullNameSub.setEditable(false);
        stuFullNameSub.setBackground(new java.awt.Color(204, 204, 204));
        stuFullNameSub.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(30, 58, 138)));
        stuFullNameSub.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                stuFullNameSubKeyTyped(evt);
            }
        });

        jLabel43.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(17, 24, 39));
        jLabel43.setText("Full Name");

        javax.swing.GroupLayout jPanel47Layout = new javax.swing.GroupLayout(jPanel47);
        jPanel47.setLayout(jPanel47Layout);
        jPanel47Layout.setHorizontalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel47Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel39)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(stuSubjectIDManage, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel43)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(stuFullNameSub, javax.swing.GroupLayout.DEFAULT_SIZE, 366, Short.MAX_VALUE)
                .addGap(43, 43, 43)
                .addComponent(jLabel40)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(gradeLevelSubjectBox, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(stuSubjectSearch)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(stuGradeManageRefreshTable1)
                .addContainerGap())
        );
        jPanel47Layout.setVerticalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel47Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(stuFullNameSub, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel43, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(stuSubjectIDManage, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(stuSubjectSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(stuGradeManageRefreshTable1)
                        .addComponent(jLabel40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(gradeLevelSubjectBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addComponent(jLabel39, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel48.setBackground(new java.awt.Color(243, 244, 246));
        jPanel48.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(55, 65, 81), 4, true));

        clearSubjectManageBt.setBackground(new java.awt.Color(251, 191, 36));
        clearSubjectManageBt.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        clearSubjectManageBt.setForeground(new java.awt.Color(0, 0, 0));
        clearSubjectManageBt.setText("Clear");
        clearSubjectManageBt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                clearSubjectManageBtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                clearSubjectManageBtMouseExited(evt);
            }
        });
        clearSubjectManageBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearSubjectManageBtActionPerformed(evt);
            }
        });

        logoutFormGradeBt1.setBackground(new java.awt.Color(251, 191, 36));
        logoutFormGradeBt1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        logoutFormGradeBt1.setForeground(new java.awt.Color(0, 0, 0));
        logoutFormGradeBt1.setText("Logout");
        logoutFormGradeBt1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                logoutFormGradeBt1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                logoutFormGradeBt1MouseExited(evt);
            }
        });
        logoutFormGradeBt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutFormGradeBt1ActionPerformed(evt);
            }
        });

        stuSubjectSaveBt.setBackground(new java.awt.Color(251, 191, 36));
        stuSubjectSaveBt.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        stuSubjectSaveBt.setForeground(new java.awt.Color(0, 0, 0));
        stuSubjectSaveBt.setText("Save");
        stuSubjectSaveBt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                stuSubjectSaveBtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                stuSubjectSaveBtMouseExited(evt);
            }
        });
        stuSubjectSaveBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stuSubjectSaveBtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel48Layout = new javax.swing.GroupLayout(jPanel48);
        jPanel48.setLayout(jPanel48Layout);
        jPanel48Layout.setHorizontalGroup(
            jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel48Layout.createSequentialGroup()
                .addContainerGap(426, Short.MAX_VALUE)
                .addComponent(stuSubjectSaveBt, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(clearSubjectManageBt, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(554, 554, 554))
            .addGroup(jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel48Layout.createSequentialGroup()
                    .addContainerGap(778, Short.MAX_VALUE)
                    .addComponent(logoutFormGradeBt1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(377, 377, 377)))
        );
        jPanel48Layout.setVerticalGroup(
            jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel48Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(stuSubjectSaveBt, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clearSubjectManageBt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel48Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(logoutFormGradeBt1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        javax.swing.GroupLayout jPanel40Layout = new javax.swing.GroupLayout(jPanel40);
        jPanel40.setLayout(jPanel40Layout);
        jPanel40Layout.setHorizontalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel40Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel47, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel46, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel48, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel40Layout.setVerticalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel40Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel47, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel46, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel48, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel38Layout = new javax.swing.GroupLayout(jPanel38);
        jPanel38.setLayout(jPanel38Layout);
        jPanel38Layout.setHorizontalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel40, javax.swing.GroupLayout.DEFAULT_SIZE, 1336, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel38Layout.setVerticalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel40, javax.swing.GroupLayout.DEFAULT_SIZE, 628, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel37Layout = new javax.swing.GroupLayout(jPanel37);
        jPanel37.setLayout(jPanel37Layout);
        jPanel37Layout.setHorizontalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel37Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel37Layout.setVerticalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel37Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Student Subjects", jPanel37);

        jPanel44.setBackground(new java.awt.Color(30, 58, 138));

        jPanel45.setBackground(new java.awt.Color(243, 244, 246));
        jPanel45.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(55, 65, 81), 4, true));
        jPanel45.setForeground(new java.awt.Color(0, 0, 0));

        jPanel50.setBackground(new java.awt.Color(243, 244, 246));
        jPanel50.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(55, 65, 81), 4, true));
        jPanel50.setForeground(new java.awt.Color(0, 0, 0));

        classListSearchBt.setBackground(new java.awt.Color(251, 191, 36));
        classListSearchBt.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        classListSearchBt.setForeground(new java.awt.Color(0, 0, 0));
        classListSearchBt.setText("Search");
        classListSearchBt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                classListSearchBtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                classListSearchBtMouseExited(evt);
            }
        });
        classListSearchBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                classListSearchBtActionPerformed(evt);
            }
        });

        jLabel72.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel72.setForeground(new java.awt.Color(17, 24, 39));
        jLabel72.setText("Grade Level");

        gradeLevelClassBox.setBackground(new java.awt.Color(255, 255, 255));
        gradeLevelClassBox.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        gradeLevelClassBox.setForeground(new java.awt.Color(0, 0, 0));
        gradeLevelClassBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "11", "12" }));
        gradeLevelClassBox.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(30, 58, 138)));
        gradeLevelClassBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gradeLevelClassBoxActionPerformed(evt);
            }
        });

        strandClassBox.setBackground(new java.awt.Color(255, 255, 255));
        strandClassBox.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        strandClassBox.setForeground(new java.awt.Color(0, 0, 0));
        strandClassBox.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(30, 58, 138)));
        strandClassBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                strandClassBoxActionPerformed(evt);
            }
        });

        jLabel81.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel81.setForeground(new java.awt.Color(17, 24, 39));
        jLabel81.setText("Strand");

        sectionClassBox.setBackground(new java.awt.Color(255, 255, 255));
        sectionClassBox.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        sectionClassBox.setForeground(new java.awt.Color(0, 0, 0));
        sectionClassBox.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(30, 58, 138)));
        sectionClassBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sectionClassBoxActionPerformed(evt);
            }
        });

        jLabel82.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel82.setForeground(new java.awt.Color(17, 24, 39));
        jLabel82.setText("Section");

        javax.swing.GroupLayout jPanel50Layout = new javax.swing.GroupLayout(jPanel50);
        jPanel50.setLayout(jPanel50Layout);
        jPanel50Layout.setHorizontalGroup(
            jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel50Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(gradeLevelClassBox, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel72))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel50Layout.createSequentialGroup()
                        .addComponent(strandClassBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18))
                    .addGroup(jPanel50Layout.createSequentialGroup()
                        .addComponent(jLabel81)
                        .addGap(208, 208, 208)))
                .addGroup(jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel82)
                    .addComponent(sectionClassBox, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(classListSearchBt, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(559, 559, 559))
        );
        jPanel50Layout.setVerticalGroup(
            jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel50Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel72)
                    .addComponent(jLabel81)
                    .addComponent(jLabel82))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gradeLevelClassBox)
                    .addComponent(strandClassBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sectionClassBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel50Layout.createSequentialGroup()
                .addComponent(classListSearchBt, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        ClassListTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "LRN", "Student Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane7.setViewportView(ClassListTable);

        jPanel49.setBackground(new java.awt.Color(243, 244, 246));
        jPanel49.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(55, 65, 81), 4, true));

        classListLogoutBt.setBackground(new java.awt.Color(251, 191, 36));
        classListLogoutBt.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        classListLogoutBt.setForeground(new java.awt.Color(0, 0, 0));
        classListLogoutBt.setText("Logout");
        classListLogoutBt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                classListLogoutBtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                classListLogoutBtMouseExited(evt);
            }
        });
        classListLogoutBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                classListLogoutBtActionPerformed(evt);
            }
        });

        classListClearBt.setBackground(new java.awt.Color(251, 191, 36));
        classListClearBt.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        classListClearBt.setForeground(new java.awt.Color(0, 0, 0));
        classListClearBt.setText("Clear");
        classListClearBt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                classListClearBtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                classListClearBtMouseExited(evt);
            }
        });
        classListClearBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                classListClearBtActionPerformed(evt);
            }
        });

        classListPrintBt.setBackground(new java.awt.Color(251, 191, 36));
        classListPrintBt.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        classListPrintBt.setForeground(new java.awt.Color(0, 0, 0));
        classListPrintBt.setText("Print");
        classListPrintBt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                classListPrintBtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                classListPrintBtMouseExited(evt);
            }
        });
        classListPrintBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                classListPrintBtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel49Layout = new javax.swing.GroupLayout(jPanel49);
        jPanel49.setLayout(jPanel49Layout);
        jPanel49Layout.setHorizontalGroup(
            jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel49Layout.createSequentialGroup()
                .addGap(378, 378, 378)
                .addComponent(classListPrintBt, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(classListClearBt, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(classListLogoutBt, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(423, 423, 423))
        );
        jPanel49Layout.setVerticalGroup(
            jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel49Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(classListLogoutBt, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                    .addComponent(classListClearBt, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                    .addComponent(classListPrintBt, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel45Layout = new javax.swing.GroupLayout(jPanel45);
        jPanel45.setLayout(jPanel45Layout);
        jPanel45Layout.setHorizontalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel45Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel50, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane7)
                    .addComponent(jPanel49, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel45Layout.setVerticalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel45Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel50, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel49, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel44Layout = new javax.swing.GroupLayout(jPanel44);
        jPanel44.setLayout(jPanel44Layout);
        jPanel44Layout.setHorizontalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel44Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel45, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel44Layout.setVerticalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel44Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel45, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Class List", jPanel44);

        jPanel19.setBackground(new java.awt.Color(30, 58, 138));

        jPanel21.setBackground(new java.awt.Color(243, 244, 246));
        jPanel21.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(55, 65, 81), 4, true));
        jPanel21.setForeground(new java.awt.Color(0, 0, 0));

        teacherID.setEditable(false);
        teacherID.setBackground(new java.awt.Color(204, 204, 204));
        teacherID.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        teacherID.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(30, 58, 138)));

        teacherFirstName.setBackground(java.awt.Color.white);
        teacherFirstName.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        teacherFirstName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(30, 58, 138)));
        teacherFirstName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                teacherFirstNameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                teacherFirstNameFocusLost(evt);
            }
        });

        teacherAddress1.setBackground(java.awt.Color.white);
        teacherAddress1.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        teacherAddress1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(30, 58, 138)));
        teacherAddress1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                teacherAddress1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                teacherAddress1FocusLost(evt);
            }
        });

        teacherAddress2.setBackground(java.awt.Color.white);
        teacherAddress2.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        teacherAddress2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(30, 58, 138)));
        teacherAddress2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                teacherAddress2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                teacherAddress2FocusLost(evt);
            }
        });
        teacherAddress2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                teacherAddress2ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Teacher's ID");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("First Name");

        jLabel23.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(0, 0, 0));
        jLabel23.setText("Address Line 1");

        jLabel24.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(0, 0, 0));
        jLabel24.setText("Address Line 2");

        jLabel67.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel67.setForeground(new java.awt.Color(0, 0, 0));
        jLabel67.setText("Date Of Birth");

        teacherBirth.setBackground(java.awt.Color.white);
        teacherBirth.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(30, 58, 138)));
        teacherBirth.setDateFormatString("yyyy-MM-dd");

        jLabel68.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel68.setForeground(new java.awt.Color(0, 0, 0));
        jLabel68.setText("Gender");

        teacherGender.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        teacherGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));
        teacherGender.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(30, 58, 138)));
        teacherGender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                teacherGenderActionPerformed(evt);
            }
        });

        jLabel69.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel69.setForeground(new java.awt.Color(0, 0, 0));
        jLabel69.setText("Email");

        teacherEmail.setBackground(java.awt.Color.white);
        teacherEmail.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        teacherEmail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(30, 58, 138)));

        jLabel70.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel70.setForeground(new java.awt.Color(0, 0, 0));
        jLabel70.setText("Phone Number");

        teacherPhone.setBackground(java.awt.Color.white);
        teacherPhone.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        teacherPhone.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(30, 58, 138)));
        teacherPhone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                teacherPhoneKeyTyped(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Middle Name");

        teacherMidName.setBackground(java.awt.Color.white);
        teacherMidName.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        teacherMidName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(30, 58, 138)));
        teacherMidName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                teacherMidNameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                teacherMidNameFocusLost(evt);
            }
        });

        jLabel28.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(0, 0, 0));
        jLabel28.setText("Last Name");

        teacherLastName.setBackground(java.awt.Color.white);
        teacherLastName.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        teacherLastName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(30, 58, 138)));
        teacherLastName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                teacherLastNameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                teacherLastNameFocusLost(evt);
            }
        });

        jLabel32.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(0, 0, 0));
        jLabel32.setText("Strand");

        teacherStrand.setBackground(new java.awt.Color(255, 255, 255));
        teacherStrand.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        teacherStrand.setForeground(new java.awt.Color(0, 0, 0));
        teacherStrand.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "STEM", "ABM", "HUMSS", "GAS", "TVL-ICT", "TVL-EIM", "TVL-HE" }));
        teacherStrand.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(30, 58, 138)));
        teacherStrand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                teacherStrandActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(teacherID, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addComponent(jLabel23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(teacherAddress1, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addComponent(jLabel69)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(teacherEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addComponent(jLabel70, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(teacherPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                        .addComponent(teacherAddress2, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel21Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(jPanel21Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(31, 31, 31)))
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(teacherFirstName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(teacherMidName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(teacherLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel21Layout.createSequentialGroup()
                                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel67)
                                    .addComponent(jLabel68, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(23, 23, 23)
                                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(teacherGender, 0, 133, Short.MAX_VALUE)
                                    .addComponent(teacherBirth, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel21Layout.createSequentialGroup()
                                .addComponent(jLabel32)
                                .addGap(68, 68, 68)
                                .addComponent(teacherStrand, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(teacherID, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(teacherFirstName, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(teacherMidName, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(teacherLastName, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                    .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(16, 16, 16)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel67)
                    .addComponent(teacherBirth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel68, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(teacherGender, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel69)
                    .addComponent(teacherEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel70)
                    .addComponent(teacherPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(teacherAddress1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(teacherAddress2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(teacherStrand, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(71, Short.MAX_VALUE))
        );

        jPanel22.setBackground(new java.awt.Color(243, 244, 246));
        jPanel22.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(55, 65, 81), 4, true));

        jPanel23.setBackground(new java.awt.Color(243, 244, 246));
        jPanel23.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(55, 65, 81), 4, true));

        jPanel24.setBackground(new java.awt.Color(243, 244, 246));
        jPanel24.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(55, 65, 81), 4, true));
        jPanel24.setForeground(new java.awt.Color(0, 0, 0));

        jPanel25.setBackground(new java.awt.Color(204, 204, 204));
        jPanel25.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(55, 65, 81), 2, true));

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel25Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(teacherImagePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(teacherImagePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
        );

        teacherBrowseImg.setBackground(new java.awt.Color(251, 191, 36));
        teacherBrowseImg.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        teacherBrowseImg.setForeground(new java.awt.Color(0, 0, 0));
        teacherBrowseImg.setText("Browse");
        teacherBrowseImg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                teacherBrowseImgMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                teacherBrowseImgMouseExited(evt);
            }
        });
        teacherBrowseImg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                teacherBrowseImgActionPerformed(evt);
            }
        });

        jLabel29.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(0, 0, 0));
        jLabel29.setText("Image");

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel29))
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(teacherBrowseImg)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addComponent(jLabel29)
                        .addGap(56, 56, 56)
                        .addComponent(teacherBrowseImg, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(221, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel26.setBackground(new java.awt.Color(243, 244, 246));
        jPanel26.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(55, 65, 81), 4, true));

        jButton3.setBackground(new java.awt.Color(251, 191, 36));
        jButton3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(0, 0, 0));
        jButton3.setText("Logout");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton3MouseExited(evt);
            }
        });
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        updateBt1.setBackground(new java.awt.Color(251, 191, 36));
        updateBt1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        updateBt1.setForeground(new java.awt.Color(0, 0, 0));
        updateBt1.setText("Update");
        updateBt1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                updateBt1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                updateBt1MouseExited(evt);
            }
        });
        updateBt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBt1ActionPerformed(evt);
            }
        });

        teacherAddNewBt.setBackground(new java.awt.Color(251, 191, 36));
        teacherAddNewBt.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        teacherAddNewBt.setForeground(new java.awt.Color(0, 0, 0));
        teacherAddNewBt.setText("Add New");
        teacherAddNewBt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                teacherAddNewBtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                teacherAddNewBtMouseExited(evt);
            }
        });
        teacherAddNewBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                teacherAddNewBtActionPerformed(evt);
            }
        });

        teacherClear.setBackground(new java.awt.Color(251, 191, 36));
        teacherClear.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        teacherClear.setForeground(new java.awt.Color(0, 0, 0));
        teacherClear.setText("Clear");
        teacherClear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                teacherClearMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                teacherClearMouseExited(evt);
            }
        });
        teacherClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                teacherClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(teacherAddNewBt, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(updateBt1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(teacherClear, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(teacherAddNewBt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(teacherClear, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updateBt1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(66, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Teacher", jPanel19);

        jPanel27.setBackground(new java.awt.Color(30, 58, 138));

        jPanel28.setBackground(new java.awt.Color(243, 244, 246));
        jPanel28.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(55, 65, 81), 4, true));

        jLabel31.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(0, 0, 0));
        jLabel31.setText("Search Teacher");

        teacherSearchField_3.setBackground(new java.awt.Color(255, 255, 255));
        teacherSearchField_3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(30, 58, 138)));

        teacherSearchBt_2.setBackground(new java.awt.Color(251, 191, 36));
        teacherSearchBt_2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        teacherSearchBt_2.setForeground(new java.awt.Color(0, 0, 0));
        teacherSearchBt_2.setText("Search");
        teacherSearchBt_2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                teacherSearchBt_2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                teacherSearchBt_2MouseExited(evt);
            }
        });
        teacherSearchBt_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                teacherSearchBt_2ActionPerformed(evt);
            }
        });

        teacherRefresh_3.setBackground(new java.awt.Color(251, 191, 36));
        teacherRefresh_3.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        teacherRefresh_3.setForeground(new java.awt.Color(0, 0, 0));
        teacherRefresh_3.setText("Refresh");
        teacherRefresh_3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                teacherRefresh_3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                teacherRefresh_3MouseExited(evt);
            }
        });
        teacherRefresh_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                teacherRefresh_3ActionPerformed(evt);
            }
        });

        teacherSort_3.setBackground(new java.awt.Color(251, 191, 36));
        teacherSort_3.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        teacherSort_3.setForeground(new java.awt.Color(0, 0, 0));
        teacherSort_3.setText("Sort");
        teacherSort_3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                teacherSort_3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                teacherSort_3MouseExited(evt);
            }
        });
        teacherSort_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                teacherSort_3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(teacherSearchField_3, javax.swing.GroupLayout.PREFERRED_SIZE, 687, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(teacherSearchBt_2, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(teacherRefresh_3, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(teacherSort_3, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4))
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                    .addComponent(teacherSearchField_3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(teacherSearchBt_2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(teacherRefresh_3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(teacherSort_3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel29.setBackground(new java.awt.Color(243, 244, 246));

        TeacherTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Teacher_ID", "User_ID", "First_Name", "Middle_Name", "Last_Name", "Date Of Birth", "Gender", "Email", "Phone Number", "Address Line 1", "Address Line 2", "Strand_name", "hire_date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TeacherTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TeacherTableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(TeacherTable);

        jPanel30.setBackground(new java.awt.Color(243, 244, 246));
        jPanel30.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(55, 65, 81), 4, true));

        teacherPrint_3.setBackground(new java.awt.Color(251, 191, 36));
        teacherPrint_3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        teacherPrint_3.setForeground(new java.awt.Color(0, 0, 0));
        teacherPrint_3.setText("Print");
        teacherPrint_3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                teacherPrint_3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                teacherPrint_3MouseExited(evt);
            }
        });
        teacherPrint_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                teacherPrint_3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel30Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(teacherPrint_3, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(480, 480, 480))
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel30Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(teacherPrint_3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1344, Short.MAX_VALUE)
                    .addComponent(jPanel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 421, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Teacher Table", jPanel27);

        jPanel31.setBackground(new java.awt.Color(30, 58, 138));

        jPanel32.setBackground(new java.awt.Color(243, 244, 246));
        jPanel32.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(55, 65, 81), 4, true));

        jLabel33.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(0, 0, 0));
        jLabel33.setText("Search Name");

        searchSensitive.setBackground(new java.awt.Color(255, 255, 255));
        searchSensitive.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(30, 58, 138)));

        sensitiveSearch.setBackground(new java.awt.Color(251, 191, 36));
        sensitiveSearch.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        sensitiveSearch.setForeground(new java.awt.Color(0, 0, 0));
        sensitiveSearch.setText("Search");
        sensitiveSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                sensitiveSearchMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                sensitiveSearchMouseExited(evt);
            }
        });
        sensitiveSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sensitiveSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel32Layout = new javax.swing.GroupLayout(jPanel32);
        jPanel32.setLayout(jPanel32Layout);
        jPanel32Layout.setHorizontalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchSensitive, javax.swing.GroupLayout.PREFERRED_SIZE, 687, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(sensitiveSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel32Layout.setVerticalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel33, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                        .addComponent(searchSensitive, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel32Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(sensitiveSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanel33.setBackground(new java.awt.Color(243, 244, 246));

        SensitiveTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "User_ID", "Username", "Password", "Type"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        SensitiveTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SensitiveTableMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(SensitiveTable);

        jPanel34.setBackground(new java.awt.Color(243, 244, 246));
        jPanel34.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(55, 65, 81), 4, true));

        teacherSensitiveLogout.setBackground(new java.awt.Color(251, 191, 36));
        teacherSensitiveLogout.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        teacherSensitiveLogout.setForeground(new java.awt.Color(0, 0, 0));
        teacherSensitiveLogout.setText("Logout");
        teacherSensitiveLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                teacherSensitiveLogoutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                teacherSensitiveLogoutMouseExited(evt);
            }
        });
        teacherSensitiveLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                teacherSensitiveLogoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel34Layout = new javax.swing.GroupLayout(jPanel34);
        jPanel34.setLayout(jPanel34Layout);
        jPanel34Layout.setHorizontalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel34Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(teacherSensitiveLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(524, 524, 524))
        );
        jPanel34Layout.setVerticalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel34Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(teacherSensitiveLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel33Layout = new javax.swing.GroupLayout(jPanel33);
        jPanel33.setLayout(jPanel33Layout);
        jPanel33Layout.setHorizontalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 1344, Short.MAX_VALUE)
                    .addComponent(jPanel34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel33Layout.setVerticalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel31Layout.createSequentialGroup()
                        .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Sensitive Information", jPanel31);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTabbedPane1))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 695, Short.MAX_VALUE))
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

    public void updateSection() {
        String gradeLevelStr = (String) stuGradeLevel.getSelectedItem();
        String strand = (String) stuStrand.getSelectedItem();

        if (gradeLevelStr != null && strand != null) {
            try {
                int gradeLevel = Integer.parseInt(gradeLevelStr); // Convert to int
                Strand strandObj = new Strand();
                String section = strandObj.getNextSection(gradeLevel, strand);

                stuSection.removeAllItems(); // Clear old items
                stuSection.addItem(section);  // Add the new section

            } catch (NumberFormatException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Invalid grade level selected.");
            }
        }
    }
    private void teacherAddress2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_teacherAddress2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_teacherAddress2ActionPerformed

    private void teacherGenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_teacherGenderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_teacherGenderActionPerformed

    private void teacherPhoneKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_teacherPhoneKeyTyped
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_teacherPhoneKeyTyped

    private void teacherBrowseImgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_teacherBrowseImgActionPerformed
        JFileChooser file = new JFileChooser();
        file.setCurrentDirectory(new File(System.getProperty("user.home")));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("* image", "jpg", "gif", "png");
        file.addChoosableFileFilter(filter);
        int output = file.showSaveDialog(file);
        if (output == JFileChooser.APPROVE_OPTION) {
            File selectFile = file.getSelectedFile();
            String path = selectFile.getAbsolutePath();
            teacherImagePanel.setIcon(imageAdjust(path, null, teacherImagePanel));
            imagePath = path;

        } else {
            JOptionPane.showMessageDialog(this, "No image selected");

        }
    }//GEN-LAST:event_teacherBrowseImgActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int a = JOptionPane.showConfirmDialog(this, "Do you want to Logout now?", "Select", JOptionPane.YES_NO_OPTION);
        if (a == 0) {
            this.dispose();
            LoginFrame frame = new LoginFrame();
            frame.setVisible(true);
            frame.setLocationRelativeTo(null);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void updateBt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBt1ActionPerformed
        if (isEmptyTeacher()) {
            int id = Integer.parseInt(teacherID.getText());
            if (teacher.isidExist(id)) {
                if (!check()) {
                    String tfname = teacherFirstName.getText();
                    String tMidName = teacherMidName.getText();
                    String tLastName = teacherLastName.getText();
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    String date = dateFormat.format(teacherBirth.getDate());
                    String gender = teacherGender.getSelectedItem().toString();
                    String email = teacherEmail.getText();
                    String phone = teacherPhone.getText();
                    String addressLine1 = teacherAddress1.getText();
                    String addressLine2 = teacherAddress2.getText();
                    String teacherStrandOption = teacherStrand.getSelectedItem().toString();
                    int strandId = strand.convertStrandNameToId(teacherStrandOption);

                    teacher.update(id, tfname, tMidName, tLastName, date, gender, email, phone, addressLine1, addressLine2, imagePath, strandId);

                    TeacherTable.setModel(new DefaultTableModel(null, new Object[]{"Teacher ID", "User_ID", "First Name", "Middle Name", "Last Name", "Date of Birth", "Gender", "Email", "Phone Number",
                        "Address Line 1", "Address Line 2", "Strand Name", "hire_date"}));
                    teacher.getTeacherValue(TeacherTable, "");
                    clearTeacher();

                }

            } else {
                JOptionPane.showMessageDialog(this, "teacher id doesn't exist");

            }

        }
    }//GEN-LAST:event_updateBt1ActionPerformed

    private void teacherAddNewBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_teacherAddNewBtActionPerformed
        int id = teacher.getMax();
        String username = teacher.getUsername();
        int userId = user.getMax();
        if (isEmptyTeacher()) {
            if (!teacher.isEmailExist(teacherEmail.getText(), id)) {
                if (!student.isPhoneExist(teacherPhone.getText(), id)) {

                    String tFname = teacherFirstName.getText();
                    String tMiddleName = teacherMidName.getText();
                    String tLastName = teacherLastName.getText();
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    String date = dateFormat.format(teacherBirth.getDate());
                    String gender = teacherGender.getSelectedItem().toString();
                    String email = teacherEmail.getText();
                    String phone = teacherPhone.getText();
                    String addressLine1 = teacherAddress1.getText();
                    String addressLine2 = teacherAddress2.getText();
                    String teacherStrandOption = teacherStrand.getSelectedItem().toString();
                    int strandId = strand.convertStrandNameToId(teacherStrandOption);
                    LocalDate hire_date = LocalDate.now();
                    String hire_date_String = hire_date.toString();

                    SimpleDateFormat passFormat = new SimpleDateFormat("yyyyMMdd");
                    String birthForPass = passFormat.format(teacherBirth.getDate());
                    String password = tLastName.toLowerCase() + birthForPass;
                    int type_id = 3; // student

                    user.insert(userId, username, password, type_id);

                    teacher.insert(id, userId, tFname, tMiddleName, tLastName, date, gender, email, phone,
                            addressLine1, addressLine2, imagePath, strandId, hire_date_String);

//                    String qrContent = "ID: " + id
//                            + "\nName: " + sname
//                            + "\nBirthdate: " + date
//                            + "\nGender: " + gender
//                            + "\nEmail: " + email
//                            + "\nPhone: " + phone
//                            + "\nMother: " + motherName
//                            + "\nFather: " + fatherName
//                            + "\nAddress 1: " + addressLine1
//                            + "\nAddress 2: " + addressLine2
//                            + "\nBirth Certificate: " + birthCer
//                            + "\nForm 137: " + form137
//                            + "\nImage: " + imagePath;
//
//                    // ✅ Generate QR code with all details
//                    generateQRCode(id, sname, qrContent);
                    TeacherTable.setModel(new DefaultTableModel(null, new Object[]{"Teacher ID", "User_ID", "First Name", "Middle Name", "Last Name", "Date of Birth", "Gender", "Email", "Phone Number",
                        "Address Line 1", "Address Line 2", "Strand Name", "hire_date"}));
                    teacher.getTeacherValue(TeacherTable, "");
                    clearTeacher();
                } else {
                    JOptionPane.showMessageDialog(this, "This phone number already exist");

                }

            } else {
                JOptionPane.showMessageDialog(this, "This email already exist");
            }

        }
    }//GEN-LAST:event_teacherAddNewBtActionPerformed

    private void teacherClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_teacherClearActionPerformed
        clearTeacher();
    }//GEN-LAST:event_teacherClearActionPerformed

    private void teacherSearchBt_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_teacherSearchBt_2ActionPerformed
        if (teacherSearchField_3.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Search field is empty");

        } else {
            TeacherTable.setModel(new DefaultTableModel(null, new Object[]{"Teacher ID", "User_ID", "First Name", "Middle Name", "Last Name", "Date of Birth", "Gender", "Email", "Phone Number",
                "Address Line 1", "Address Line 2", "Strand Name", "hire_date"}));
            teacher.getTeacherValue(TeacherTable, teacherSearchField_3.getText());
        }
    }//GEN-LAST:event_teacherSearchBt_2ActionPerformed

    private void teacherRefresh_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_teacherRefresh_3ActionPerformed
        TeacherTable.setModel(new DefaultTableModel(null, new Object[]{"Teacher ID", "User_ID", "First Name", "Middle Name", "Last Name", "Date of Birth", "Gender", "Email", "Phone Number",
            "Address Line 1", "Address Line 2", "Strand Name", "hire_date"}));
        teacher.getTeacherValue(TeacherTable, "");
        teacherSearchField_3.setText(null);
    }//GEN-LAST:event_teacherRefresh_3ActionPerformed

    private void teacherSort_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_teacherSort_3ActionPerformed
        DefaultTableModel model = (DefaultTableModel) StudentTable.getModel();

        // Attach TableRowSorter to your table
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        TeacherTable.setRowSorter(sorter);

        // Example: Sort by Student ID (numerically) and then by Student Name (alphabetically)
        List<RowSorter.SortKey> sortKeys = new ArrayList<>();

        int teacherIdCol = 0;  // Student ID is column 0
        int teacherNameCol = 2; // Student Name is column 1

        // First sort by ID (ascending)
        sortKeys.add(new RowSorter.SortKey(teacherIdCol, SortOrder.ASCENDING));

        // Then sort by Name (ascending)
        sortKeys.add(new RowSorter.SortKey(teacherNameCol, SortOrder.ASCENDING));

        sorter.setSortKeys(sortKeys);
        sorter.sort();
    }//GEN-LAST:event_teacherSort_3ActionPerformed

    private void TeacherTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TeacherTableMouseClicked
        model = (DefaultTableModel) TeacherTable.getModel();
        rowIndex = TeacherTable.getSelectedRow();
        teacherID.setText(model.getValueAt(rowIndex, 0).toString());
        teacherFirstName.setText(model.getValueAt(rowIndex, 2).toString());
        teacherMidName.setText(model.getValueAt(rowIndex, 3).toString());
        teacherLastName.setText(model.getValueAt(rowIndex, 4).toString());

        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(model.getValueAt(rowIndex, 5).toString());
            teacherBirth.setDate(date);
        } catch (ParseException ex) {
            System.getLogger(Home.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }

        String gender = model.getValueAt(rowIndex, 6).toString();
        if (gender.equals("Male")) {
            teacherGender.setSelectedIndex(0);

        } else {
            teacherGender.setSelectedIndex(1);

        }
        teacherEmail.setText(model.getValueAt(rowIndex, 7).toString());
        teacherPhone.setText(model.getValueAt(rowIndex, 8).toString());
        teacherAddress1.setText(model.getValueAt(rowIndex, 9).toString());
        teacherAddress2.setText(model.getValueAt(rowIndex, 10).toString());
        String strandSelect = model.getValueAt(rowIndex, 11).toString();

        //STEM, ABM, HUMSS, GAS, TVL-ICT, TVL-EIM, TVL-HE
        if (strandSelect.equals("STEM")) {
            teacherStrand.setSelectedIndex(0);
        }
        if (strandSelect.equals("ABM")) {
            teacherStrand.setSelectedIndex(1);
        }
        if (strandSelect.equals("HUMSS")) {
            teacherStrand.setSelectedIndex(2);
        }
        if (strandSelect.equals("GAS")) {
            teacherStrand.setSelectedIndex(3);
        }
        if (strandSelect.equals("TVL-ICT")) {
            teacherStrand.setSelectedIndex(4);
        }
        if (strandSelect.equals("TVL-EIM")) {
            teacherStrand.setSelectedIndex(5);
        }
        if (strandSelect.equals("TVL-HE")) {
            teacherStrand.setSelectedIndex(6);
        }

        String path = model.getValueAt(rowIndex, 13).toString();
        imagePath = path;
        teacherImagePanel.setIcon(imageAdjust(path, null, teacherImagePanel));//get image path and called image adjust method path to image
    }//GEN-LAST:event_TeacherTableMouseClicked

    private void teacherPrint_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_teacherPrint_3ActionPerformed
        try {
            MessageFormat header = new MessageFormat("Teachers Information");
            MessageFormat footer = new MessageFormat("Page{0,number,integer}");
            TeacherTable.print(JTable.PrintMode.FIT_WIDTH, header, footer);
        } catch (PrinterException ex) {
            System.getLogger(Home.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }//GEN-LAST:event_teacherPrint_3ActionPerformed

    private void teacherStrandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_teacherStrandActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_teacherStrandActionPerformed

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

    private void sensitiveSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sensitiveSearchActionPerformed
        String searchName = searchSensitive.getText().trim();

        try {
            Information info = new SensitiveInformation();
            DefaultTableModel model = info.searchByName(searchName);
            SensitiveTable.setModel(model);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_sensitiveSearchActionPerformed

    private void SensitiveTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SensitiveTableMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_SensitiveTableMouseClicked

    private void teacherSensitiveLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_teacherSensitiveLogoutActionPerformed
        int a = JOptionPane.showConfirmDialog(this, "Do you want to Logout now?", "Select", JOptionPane.YES_NO_OPTION);
        if (a == 0) {
            this.dispose();
            LoginFrame frame = new LoginFrame();
            frame.setVisible(true);
            frame.setLocationRelativeTo(null);
        }
    }//GEN-LAST:event_teacherSensitiveLogoutActionPerformed

    private void stuSubjectIDManageKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_stuSubjectIDManageKeyTyped
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_stuSubjectIDManageKeyTyped

    private void stuSubjectSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stuSubjectSearchActionPerformed
        String studentIdStr = stuSubjectIDManage.getText().trim();

        if (studentIdStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter Student ID.");
            return;
        }

        try {
            int studentId = Integer.parseInt(studentIdStr);
            String fullName = strand.getStudentNameById(studentId);
            stuFullNameSub.setText(fullName);

            String gradeLevelStr = gradeLevelSubjectBox.getSelectedItem().toString();
            int gradeLevel = Integer.parseInt(gradeLevelStr.split(" - ")[0]);

            subjectModel.setRowCount(0);

            Subject subjectDAO = new Subject();

            // 🔎 Check if student is already enrolled in this grade level
            if (!subjectDAO.isStudentEnrolledInGradeLevel(studentId, gradeLevel)) {
                JOptionPane.showMessageDialog(this,
                        "Student is not enrolled in Grade " + gradeLevel,
                        "Enrollment Check",
                        JOptionPane.WARNING_MESSAGE);
                subjectDAO.close();
                return; // stop here
            }

            // 🔹 Get all subjects for this student based on strand + grade level
            ResultSet rs = subjectDAO.getSubjectsForStudent(studentId, gradeLevel);

            // 🔹 Already enrolled subjects
            ResultSet rsEnrolled = subjectDAO.getEnrolledSubjects(
                    studentId,
                    getCurrentSchoolYear() // ✅ dynamic school year (see Step 3)
            );

            HashSet<Integer> enrolledSubjects = new HashSet<>();
            while (rsEnrolled.next()) {
                enrolledSubjects.add(rsEnrolled.getInt("subject_id"));
            }

            // 🔹 Add to JTable
            while (rs.next()) {
                int subjId = rs.getInt("subject_id");
                String subjName = rs.getString("subject_name");
                boolean enrolled = enrolledSubjects.contains(subjId);

                subjectModel.addRow(new Object[]{subjId, subjName, enrolled});
            }

            subjectDAO.close();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error loading subjects: " + e.getMessage());
        }
    }//GEN-LAST:event_stuSubjectSearchActionPerformed

    public String getCurrentSchoolYear() {
        java.time.LocalDate today = java.time.LocalDate.now();
        int year = today.getYear();

        // Assuming school year starts in June
        if (today.getMonthValue() < 6) {
            year = year - 1;
        }
        return year + "-" + (year + 1);
    }
    private void stuGradeManageRefreshTable1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stuGradeManageRefreshTable1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_stuGradeManageRefreshTable1ActionPerformed

    private void gradeLevelSubjectBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gradeLevelSubjectBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_gradeLevelSubjectBoxActionPerformed

    private void clearSubjectManageBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearSubjectManageBtActionPerformed
        clearSubjectManage();
    }//GEN-LAST:event_clearSubjectManageBtActionPerformed

    private void logoutFormGradeBt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutFormGradeBt1ActionPerformed
        //LOGOUT
        int a = JOptionPane.showConfirmDialog(this, "Do you want to Logout now?", "Select", JOptionPane.YES_NO_OPTION);
        if (a == 0) {
            this.dispose();
            LoginFrame frame = new LoginFrame();
            frame.setVisible(true);
            frame.setLocationRelativeTo(null);
        }
    }//GEN-LAST:event_logoutFormGradeBt1ActionPerformed

    private void stuSubjectSaveBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stuSubjectSaveBtActionPerformed
        try {
            String studentIdStr = stuSubjectIDManage.getText().trim();
            if (studentIdStr.isEmpty() || SubjectTable.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "Please enter Student ID and make sure the table is not empty.");
                return;
            }
            String studentId = stuSubjectIDManage.getText().trim();

            String schoolYear = getCurrentSchoolYear();

            Subject subjectHelper = new Subject();
            subjectHelper.saveStudentSubjects(studentId, SubjectTable, schoolYear);

            JOptionPane.showMessageDialog(this, "Subjects successfully saved!");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error saving subjects: " + e.getMessage());
        }
    }//GEN-LAST:event_stuSubjectSaveBtActionPerformed

    public int getSelectedClassStrandId() {
        ComboItem selectedItem = (ComboItem) strandClassBox.getSelectedItem();
        if (selectedItem != null) {
            return selectedItem.getId(); // assuming ComboItem has getId()
        }
        return -1; // or handle appropriately if nothing is selected
    }
    private void searchBt_1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchBt_1MouseEntered
        searchBt_1.setBackground(ThemeColors.DEEP_ORANGE);
    }//GEN-LAST:event_searchBt_1MouseEntered

    private void searchBt_1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchBt_1MouseExited
        searchBt_1.setBackground(ThemeColors.GOLDEN_YELLOW);
    }//GEN-LAST:event_searchBt_1MouseExited

    private void searchBt_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBt_1ActionPerformed
        if (stuSearchField_1.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Search field is empty");

        } else {
            String currentText = stuInfoCurrentOrArchived.getText();
            if (currentText.equalsIgnoreCase("Current")) {
                StudentTable.setModel(new DefaultTableModel(null, new Object[]{"Student ID", "User_ID", "First Name", "Middle Name", "Last Name", "Date of Birth", "Gender", "Email", "Phone Number", "Father's Name",
                    "Mother's Name", "Address Line 1", "Address Line 2", "LRN"}));
                student.getStudentValue(StudentTable, stuSearchField_1.getText());
            } else if (currentText.equalsIgnoreCase("Archived")) {
                StudentTable.setModel(new DefaultTableModel(null, new Object[]{"Student ID", "User_ID", "First Name", "Middle Name", "Last Name", "Date of Birth", "Gender", "Email", "Phone Number", "Father's Name",
                    "Mother's Name", "Address Line 1", "Address Line 2", "LRN", "Date Archived", "Reason"}));
                archive.getArchivedStudentValue(StudentTable, "");
            }

        }
    }//GEN-LAST:event_searchBt_1ActionPerformed

    private void stuRefresh_1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stuRefresh_1MouseEntered
        stuRefresh_1.setBackground(ThemeColors.DEEP_ORANGE);
    }//GEN-LAST:event_stuRefresh_1MouseEntered

    private void stuRefresh_1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stuRefresh_1MouseExited
        stuRefresh_1.setBackground(ThemeColors.GOLDEN_YELLOW);
    }//GEN-LAST:event_stuRefresh_1MouseExited

    private void stuRefresh_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stuRefresh_1ActionPerformed
        String currentText = stuInfoCurrentOrArchived.getText();
        if (currentText.equalsIgnoreCase("Current")) {
            StudentTable.setModel(new DefaultTableModel(null, new Object[]{"Student ID", "User_ID", "First Name", "Middle Name", "Last Name", "Date of Birth", "Gender", "Email", "Phone Number", "Father's Name",
                "Mother's Name", "Address Line 1", "Address Line 2", "LRN"}));
            student.getStudentValue(StudentTable, "");
            stuSearchField_1.setText(null);
        } else if (currentText.equalsIgnoreCase("Archived")) {
            StudentTable.setModel(new DefaultTableModel(null, new Object[]{"Student ID", "User_ID", "First Name", "Middle Name", "Last Name", "Date of Birth", "Gender", "Email", "Phone Number", "Father's Name",
                "Mother's Name", "Address Line 1", "Address Line 2", "LRN", "Date Archived", "Reason"}));
            archive.getArchivedStudentValue(StudentTable, "");
            stuSearchField_1.setText(null);
        }
    }//GEN-LAST:event_stuRefresh_1ActionPerformed

    private void stuSort_1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stuSort_1MouseEntered
        stuSort_1.setBackground(ThemeColors.DEEP_ORANGE);
    }//GEN-LAST:event_stuSort_1MouseEntered

    private void stuSort_1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stuSort_1MouseExited
        stuSort_1.setBackground(ThemeColors.GOLDEN_YELLOW);
    }//GEN-LAST:event_stuSort_1MouseExited

    private void stuSort_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stuSort_1ActionPerformed
        DefaultTableModel model = (DefaultTableModel) StudentTable.getModel();

        // Attach TableRowSorter to your table
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        StudentTable.setRowSorter(sorter);

        // Example: Sort by Student ID (numerically) and then by Student Name (alphabetically)
        List<RowSorter.SortKey> sortKeys = new ArrayList<>();

        int studentIdCol = 0;  // Student ID is column 0
        int studentNameCol = 1; // Student Name is column 1

        // First sort by ID (ascending)
        sortKeys.add(new RowSorter.SortKey(studentIdCol, SortOrder.ASCENDING));

        // Then sort by Name (ascending)
        sortKeys.add(new RowSorter.SortKey(studentNameCol, SortOrder.ASCENDING));

        sorter.setSortKeys(sortKeys);
        sorter.sort();
    }//GEN-LAST:event_stuSort_1ActionPerformed

    private void StudentTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_StudentTableMouseClicked
        model = (DefaultTableModel) StudentTable.getModel();
        rowIndex = StudentTable.getSelectedRow();

        // Basic fields from the JTable
        stuID.setText(model.getValueAt(rowIndex, 0).toString());
        stuFname.setText(model.getValueAt(rowIndex, 2).toString());
        stuMiddleName.setText(model.getValueAt(rowIndex, 3).toString());
        stuLastName.setText(model.getValueAt(rowIndex, 4).toString());

        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(model.getValueAt(rowIndex, 5).toString());
            stuBirth.setDate(date);
        } catch (ParseException ex) {
            System.getLogger(Home.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }

        String gender = model.getValueAt(rowIndex, 6).toString();
        if (gender.equalsIgnoreCase("Male")) {
            stuGender.setSelectedIndex(0);
        } else {
            stuGender.setSelectedIndex(1);
        }

        stuEmail.setText(model.getValueAt(rowIndex, 7).toString());
        stuPhone.setText(model.getValueAt(rowIndex, 8).toString());
        stuFatherName.setText(model.getValueAt(rowIndex, 9).toString());
        stuMotherName.setText(model.getValueAt(rowIndex, 10).toString());
        stuAddress1.setText(model.getValueAt(rowIndex, 11).toString());
        stuAddress2.setText(model.getValueAt(rowIndex, 12).toString());
        stuLRN.setText(model.getValueAt(rowIndex, 13).toString());

        int studentId = Integer.parseInt(model.getValueAt(rowIndex, 0).toString());
        String sql = "SELECT birth_certificate, form_137, image_path FROM student WHERE student_id = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, studentId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                stuBirthCer.setText(rs.getString("birth_certificate"));
                stuForm137.setText(rs.getString("form_137"));
                String path = rs.getString("image_path");
                imagePath = path;
                if (path != null && !path.isEmpty()) {
                    imagePanel.setIcon(imageAdjust(path, null, imagePanel));
                } else {
                    imagePanel.setIcon(null); // clear if no image
                }
            }
        } catch (SQLException ex) {
            System.getLogger(Home.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }//GEN-LAST:event_StudentTableMouseClicked

    private void delBtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_delBtMouseEntered
        delBt.setBackground(ThemeColors.DEEP_ORANGE);
    }//GEN-LAST:event_delBtMouseEntered

    private void delBtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_delBtMouseExited
        delBt.setBackground(ThemeColors.GOLDEN_YELLOW);
    }//GEN-LAST:event_delBtMouseExited

    private void delBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delBtActionPerformed
        int id = Integer.parseInt(stuID.getText());
        String currentText = stuInfoCurrentOrArchived.getText();
        //String anoCurText = delBt.getText();

        if (currentText.equalsIgnoreCase("Current")) {
            //delBt.setText("Delete");
            // 🔹 ARCHIVE student logic
            if (student.isidExist(id)) {
                // Ask for reason
                String reason = JOptionPane.showInputDialog(this, "Enter reason for archiving this student:", "Archive Reason", JOptionPane.PLAIN_MESSAGE);
                if (reason == null || reason.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Archiving cancelled. Reason is required.");
                    return;
                }

                // Archive student
                archive.archiveStudent(id, reason);

                String lrn = student.getLRNById(id);
                // Delete related user record
                user.delete(lrn);

                // Refresh Current Table
                StudentTable.setModel(new DefaultTableModel(null, new Object[]{
                    "Student ID", "User_ID", "First Name", "Middle Name", "Last Name",
                    "Date of Birth", "Gender", "Email", "Phone Number", "Father's Name",
                    "Mother's Name", "Address Line 1", "Address Line 2", "LRN"
                }));
                student.getStudentValue(StudentTable, "");

                clearStudent();
                JOptionPane.showMessageDialog(this, "Student successfully archived.");
            } else {
                JOptionPane.showMessageDialog(this, "The student doesn't exist.");
            }
        } // 🔹 RESTORE student logic if viewing Archived
        else if (currentText.equalsIgnoreCase("Archived")) {
            //delBt.setText("Restore");
            if (archive.isidExist(id)) {
                int confirm = JOptionPane.showConfirmDialog(this, "Do you want to restore this student?", "Confirm Restore", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    // Restore student
                    archive.restoreStudent(id);

                    // Refresh Archived Table
                    StudentTable.setModel(new DefaultTableModel(null, new Object[]{
                        "Student ID", "User_ID", "First Name", "Middle Name", "Last Name",
                        "Date of Birth", "Gender", "Email", "Phone Number", "Father's Name",
                        "Mother's Name", "Address Line 1", "Address Line 2", "LRN",
                        "Date Archived", "Reason"
                    }));
                    archive.getArchivedStudentValue(StudentTable, "");

                    clearStudent();
                    JOptionPane.showMessageDialog(this, "Student successfully restored.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "The archived student doesn't exist.");
            }
        }
    }//GEN-LAST:event_delBtActionPerformed

    private void stuPrint_1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stuPrint_1MouseEntered
        stuPrint_1.setBackground(ThemeColors.DEEP_ORANGE);
    }//GEN-LAST:event_stuPrint_1MouseEntered

    private void stuPrint_1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stuPrint_1MouseExited
        stuPrint_1.setBackground(ThemeColors.GOLDEN_YELLOW);
    }//GEN-LAST:event_stuPrint_1MouseExited

    private void stuPrint_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stuPrint_1ActionPerformed
        try {
            MessageFormat header = new MessageFormat("Students Information");
            MessageFormat footer = new MessageFormat("Page{0,number,integer}");
            StudentTable.print(JTable.PrintMode.FIT_WIDTH, header, footer);
        } catch (PrinterException ex) {
            System.getLogger(Home.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }//GEN-LAST:event_stuPrint_1ActionPerformed

    private void stuInfoCurrentOrArchivedMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stuInfoCurrentOrArchivedMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_stuInfoCurrentOrArchivedMouseEntered

    private void stuInfoCurrentOrArchivedMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stuInfoCurrentOrArchivedMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_stuInfoCurrentOrArchivedMouseExited

    private void stuInfoCurrentOrArchivedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stuInfoCurrentOrArchivedActionPerformed
        String currentText = stuInfoCurrentOrArchived.getText();

        if (currentText.equalsIgnoreCase("Archived")) {
            StudentTable.setModel(new DefaultTableModel(null, new Object[]{"Student ID", "User_ID", "First Name", "Middle Name", "Last Name", "Date of Birth", "Gender", "Email", "Phone Number", "Father's Name",
                "Mother's Name", "Address Line 1", "Address Line 2", "LRN"}));
            student.getStudentValue(StudentTable, "");
            stuInfoCurrentOrArchived.setText("Current");
            delBt.setText("Delete");
        } else if (currentText.equalsIgnoreCase("Current")) {
            StudentTable.setModel(new DefaultTableModel(null, new Object[]{"Student ID", "User_ID", "First Name", "Middle Name", "Last Name", "Date of Birth", "Gender", "Email", "Phone Number", "Father's Name",
                "Mother's Name", "Address Line 1", "Address Line 2", "LRN", "Date Archived", "Reason"}));
            archive.getArchivedStudentValue(StudentTable, "");
            stuInfoCurrentOrArchived.setText("Archived");
            delBt.setText("Restore");

//StudentTrackTable.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
        }
    }//GEN-LAST:event_stuInfoCurrentOrArchivedActionPerformed
    public int getSelectedStudentStrandId() {
        ComboItem selectedItem = (ComboItem) stuStrand.getSelectedItem();
        if (selectedItem != null) {
            return selectedItem.getId(); // assuming ComboItem has getId()
        }
        return -1; // or handle appropriately if nothing is selected
    }
    private void stuFullNameSubKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_stuFullNameSubKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_stuFullNameSubKeyTyped

    private void stuSubjectSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stuSubjectSearchMouseClicked
        //stuSubjectSearch.setBackground(ThemeColors.GOLDEN_YELLOW);
    }//GEN-LAST:event_stuSubjectSearchMouseClicked

    private void stuSubjectSearchMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stuSubjectSearchMouseEntered
        stuSubjectSearch.setBackground(ThemeColors.DEEP_ORANGE);
    }//GEN-LAST:event_stuSubjectSearchMouseEntered

    private void stuSubjectSearchMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stuSubjectSearchMouseExited
        stuSubjectSearch.setBackground(ThemeColors.GOLDEN_YELLOW);
    }//GEN-LAST:event_stuSubjectSearchMouseExited

    private void stuGradeManageRefreshTable1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stuGradeManageRefreshTable1MouseEntered
        stuGradeManageRefreshTable1.setBackground(ThemeColors.DEEP_ORANGE);
    }//GEN-LAST:event_stuGradeManageRefreshTable1MouseEntered

    private void stuGradeManageRefreshTable1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stuGradeManageRefreshTable1MouseExited
        stuGradeManageRefreshTable1.setBackground(ThemeColors.GOLDEN_YELLOW);
    }//GEN-LAST:event_stuGradeManageRefreshTable1MouseExited

    private void stuSubjectSaveBtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stuSubjectSaveBtMouseEntered
        stuSubjectSaveBt.setBackground(ThemeColors.DEEP_ORANGE);
    }//GEN-LAST:event_stuSubjectSaveBtMouseEntered

    private void stuSubjectSaveBtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stuSubjectSaveBtMouseExited
        stuSubjectSaveBt.setBackground(ThemeColors.GOLDEN_YELLOW);
    }//GEN-LAST:event_stuSubjectSaveBtMouseExited

    private void clearSubjectManageBtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearSubjectManageBtMouseEntered
        clearSubjectManageBt.setBackground(ThemeColors.DEEP_ORANGE);
    }//GEN-LAST:event_clearSubjectManageBtMouseEntered

    private void clearSubjectManageBtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearSubjectManageBtMouseExited
        clearSubjectManageBt.setBackground(ThemeColors.GOLDEN_YELLOW);
    }//GEN-LAST:event_clearSubjectManageBtMouseExited

    private void logoutFormGradeBt1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutFormGradeBt1MouseEntered
        logoutFormGradeBt1.setBackground(ThemeColors.DEEP_ORANGE);
    }//GEN-LAST:event_logoutFormGradeBt1MouseEntered

    private void logoutFormGradeBt1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutFormGradeBt1MouseExited
        logoutFormGradeBt1.setBackground(ThemeColors.GOLDEN_YELLOW);
    }//GEN-LAST:event_logoutFormGradeBt1MouseExited

    private void stuFnameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_stuFnameFocusGained
        stuFname.setBackground(new java.awt.Color(255, 255, 204)); // light yellow highlight
        stuFname.setText(stuFname.getText().trim());
    }//GEN-LAST:event_stuFnameFocusGained

    private void stuFnameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_stuFnameFocusLost
        jFocusLost(stuFname);
    }//GEN-LAST:event_stuFnameFocusLost

    private void stuFnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stuFnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_stuFnameActionPerformed

    private void stuMotherNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_stuMotherNameFocusGained
        stuMotherName.setBackground(new java.awt.Color(255, 255, 204)); // light yellow highlight
        stuMotherName.setText(stuMotherName.getText().trim());
    }//GEN-LAST:event_stuMotherNameFocusGained

    private void stuMotherNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_stuMotherNameFocusLost
        jFocusLost(stuMotherName);
    }//GEN-LAST:event_stuMotherNameFocusLost

    private void stuMotherNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stuMotherNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_stuMotherNameActionPerformed

    private void stuAddress1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_stuAddress1FocusGained
        stuAddress1.setBackground(new java.awt.Color(255, 255, 204)); // light yellow highlight
        stuAddress1.setText(stuAddress1.getText().trim());
    }//GEN-LAST:event_stuAddress1FocusGained

    private void stuAddress1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_stuAddress1FocusLost
        jFocusLost(stuAddress1);
    }//GEN-LAST:event_stuAddress1FocusLost

    private void stuAddress2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_stuAddress2FocusGained
        stuAddress2.setBackground(new java.awt.Color(255, 255, 204)); // light yellow highlight
        stuAddress2.setText(stuAddress2.getText().trim());
    }//GEN-LAST:event_stuAddress2FocusGained

    private void stuAddress2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_stuAddress2FocusLost
        jFocusLost(stuAddress2);
    }//GEN-LAST:event_stuAddress2FocusLost

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

    private void stuFatherNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_stuFatherNameFocusGained
        stuFatherName.setBackground(new java.awt.Color(255, 255, 204)); // light yellow highlight
        stuFatherName.setText(stuFatherName.getText().trim());
    }//GEN-LAST:event_stuFatherNameFocusGained

    private void stuFatherNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_stuFatherNameFocusLost
        jFocusLost(stuFatherName);
    }//GEN-LAST:event_stuFatherNameFocusLost

    private void stuFatherNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stuFatherNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_stuFatherNameActionPerformed

    public void jFocusLost(JTextField field) {
        String text = field.getText().trim();
        if (!text.isEmpty()) {
            // Split into words
            String[] words = text.split("\\s+");
            StringBuilder formattedText = new StringBuilder();

            for (String word : words) {
                if (!word.isEmpty()) {
                    formattedText.append(
                            word.substring(0, 1).toUpperCase()
                    ).append(
                            word.substring(1).toLowerCase()
                    ).append(" ");
                }
            }

            // Set formatted text back (trim to remove extra space at the end)
            field.setText(formattedText.toString().trim());
        }

        field.setBackground(java.awt.Color.WHITE);

    }
    private void browseBirthCertificateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseBirthCertificateActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));

        // PDF filter only
        FileNameExtensionFilter pdfFilter = new FileNameExtensionFilter("PDF Documents", "pdf");
        fileChooser.setFileFilter(pdfFilter);

        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            birthCertificatePath = selectedFile.getAbsolutePath(); // keep full path
            String pdfName = selectedFile.getName(); // only filename

            // show only file name in textfield
            stuBirthCer.setText(pdfName);

            // make it look clickable
            stuBirthCer.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

            // add mouse click event to open PDF
            stuBirthCer.addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    try {
                        if (Desktop.isDesktopSupported() && birthCertificatePath != null) {
                            Desktop.getDesktop().open(new File(birthCertificatePath));
                        } else {
                            JOptionPane.showMessageDialog(null, "Desktop not supported or path is null.");
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Unable to open PDF: " + e.getMessage());
                    }
                }
            });
        } else {
            JOptionPane.showMessageDialog(this, "No PDF selected");
        }
    }//GEN-LAST:event_browseBirthCertificateActionPerformed

    private void browseForm137ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseForm137ActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));

        // PDF filter only
        FileNameExtensionFilter pdfFilter = new FileNameExtensionFilter("PDF Documents", "pdf");
        fileChooser.setFileFilter(pdfFilter);

        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            form137Path = selectedFile.getAbsolutePath(); // keep full path
            String pdfName = selectedFile.getName(); // only filename

            // show only file name in textfield
            stuForm137.setText(pdfName);

            // make it look clickable
            stuForm137.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

            // add mouse click event to open PDF
            stuForm137.addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    try {
                        if (Desktop.isDesktopSupported() && form137Path != null) {
                            Desktop.getDesktop().open(new File(form137Path));
                        } else {
                            JOptionPane.showMessageDialog(null, "Desktop not supported or path is null.");
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Unable to open PDF: " + e.getMessage());
                    }
                }
            });
        } else {
            JOptionPane.showMessageDialog(this, "No PDF selected");
        }
    }//GEN-LAST:event_browseForm137ActionPerformed

    private void stuBirthCerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stuBirthCerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_stuBirthCerActionPerformed

    private void stuMiddleNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_stuMiddleNameFocusGained
        stuMiddleName.setBackground(new java.awt.Color(255, 255, 204)); // light yellow highlight
        stuMiddleName.setText(stuMiddleName.getText().trim());
    }//GEN-LAST:event_stuMiddleNameFocusGained

    private void stuMiddleNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_stuMiddleNameFocusLost
        jFocusLost(stuMiddleName);
    }//GEN-LAST:event_stuMiddleNameFocusLost

    private void stuLastNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_stuLastNameFocusGained
        stuLastName.setBackground(new java.awt.Color(255, 255, 204)); // light yellow highlight
        stuLastName.setText(stuLastName.getText().trim());
    }//GEN-LAST:event_stuLastNameFocusGained

    private void stuLastNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_stuLastNameFocusLost
        jFocusLost(stuLastName);
    }//GEN-LAST:event_stuLastNameFocusLost

    private void browseImgMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_browseImgMouseEntered
        browseImg.setBackground(ThemeColors.DEEP_ORANGE);
    }//GEN-LAST:event_browseImgMouseEntered

    private void browseImgMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_browseImgMouseExited
        browseImg.setBackground(ThemeColors.GOLDEN_YELLOW);
    }//GEN-LAST:event_browseImgMouseExited

    private void browseImgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseImgActionPerformed
        JFileChooser file = new JFileChooser();
        file.setCurrentDirectory(new File(System.getProperty("user.home")));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("* image", "jpg", "gif", "png");
        file.addChoosableFileFilter(filter);
        int output = file.showSaveDialog(file);
        if (output == JFileChooser.APPROVE_OPTION) {
            File selectFile = file.getSelectedFile();
            String path = selectFile.getAbsolutePath();
            imagePanel.setIcon(imageAdjust(path, null, imagePanel));
            imagePath = path;

        } else {
            JOptionPane.showMessageDialog(this, "No image selected");

        }
    }//GEN-LAST:event_browseImgActionPerformed

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
            int id = Integer.parseInt(stuID.getText());
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
                    String birthCer = stuBirthCer.getText();
                    String form137 = stuForm137.getText();
                    String stuLrn = stuLRN.getText();
                    student.update(id, sfname, sMidName, sLastName, date, gender, email, phone,
                            motherName, fatherName, addressLine1, addressLine2, birthCer, form137, imagePath, stuLrn);

                    //                    String qrContent = "ID: " + id
                    //                            + "\nName: " + sname
                    //                            + "\nBirthdate: " + date
                    //                            + "\nGender: " + gender
                    //                            + "\nEmail: " + email
                    //                            + "\nPhone: " + phone
                    //                            + "\nMother: " + motherName
                    //                            + "\nFather: " + fatherName
                    //                            + "\nAddress 1: " + addressLine1
                    //                            + "\nAddress 2: " + addressLine2
                    //                            + "\nBirth Certificate: " + birthCer
                    //                            + "\nForm 137: " + form137
                    //                            + "\nImage: " + imagePath;
                    //
                    //                    // ✅ Generate QR code with all details
                    //                    generateQRCode(id, sname, qrContent);
                    StudentTable.setModel(new DefaultTableModel(null, new Object[]{"Student ID", "User_ID", "First Name", "Middle Name", "Last Name", "Date of Birth", "Gender", "Email", "Phone Number", "Father's Name",
                        "Mother's Name", "Address Line 1", "Address Line 2", "LRN"}));
                    student.getStudentValue(StudentTable, "");
                    clearStudent();

                }

            } else {
                JOptionPane.showMessageDialog(this, "student id doesn't exist");

            }

        }
    }//GEN-LAST:event_updateBtActionPerformed

    private void addNewBtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addNewBtMouseEntered

        addNewBt.setBackground(ThemeColors.DEEP_ORANGE);
    }//GEN-LAST:event_addNewBtMouseEntered

    private void addNewBtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addNewBtMouseExited
        addNewBt.setBackground(ThemeColors.GOLDEN_YELLOW);
    }//GEN-LAST:event_addNewBtMouseExited

    private void addNewBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNewBtActionPerformed
        int id = student.getMax();
        String username = stuLRN.getText();
        int userId = user.getMax();
        if (isEmptyStudent()) {
            if (!student.isEmailExist(stuEmail.getText(), id)) {
                if (!student.isPhoneExist(stuPhone.getText(), id)) {

                    String sFname = stuFname.getText();
                    String sMiddleName = stuMiddleName.getText();
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
                    String birthCer = stuBirthCer.getText();
                    String form137 = stuForm137.getText();
                    String stuLrn = stuLRN.getText();

                    SimpleDateFormat passFormat = new SimpleDateFormat("yyyyMMdd");
                    String birthForPass = passFormat.format(stuBirth.getDate());
                    String password = sLastName.toLowerCase() + birthForPass;
                    int type_id = 2; // student

                    user.insert(userId, username, password, type_id);

                    student.insert(id, userId, sFname, sMiddleName, sLastName, date, gender, email, phone,
                            motherName, fatherName, addressLine1, addressLine2, birthCer, form137, imagePath, stuLrn);

                    StudentTable.setModel(new DefaultTableModel(null, new Object[]{"Student ID", "User_ID", "First Name", "Middle Name", "Last Name", "Date of Birth", "Gender", "Email", "Phone Number", "Father's Name",
                        "Mother's Name", "Address Line 1", "Address Line 2", "LRN"}));
                    student.getStudentValue(StudentTable, "");
                    clearStudent();
                } else {
                    JOptionPane.showMessageDialog(this, "This phone number already exist");

                }

            } else {
                JOptionPane.showMessageDialog(this, "This email already exist");
            }

        }
    }//GEN-LAST:event_addNewBtActionPerformed

    private void ClearMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ClearMouseEntered
        Clear.setBackground(ThemeColors.DEEP_ORANGE);
    }//GEN-LAST:event_ClearMouseEntered

    private void ClearMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ClearMouseExited
        Clear.setBackground(ThemeColors.GOLDEN_YELLOW);
    }//GEN-LAST:event_ClearMouseExited

    private void ClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearActionPerformed
        clearStudent();
    }//GEN-LAST:event_ClearActionPerformed

    private void stuStrandSearchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stuStrandSearchFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_stuStrandSearchFieldActionPerformed

    private void stuStrandSearchFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_stuStrandSearchFieldKeyTyped
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_stuStrandSearchFieldKeyTyped

    private void stuStrandSearchBtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stuStrandSearchBtMouseEntered
        stuStrandSearchBt.setBackground(ThemeColors.DEEP_ORANGE);
    }//GEN-LAST:event_stuStrandSearchBtMouseEntered

    private void stuStrandSearchBtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stuStrandSearchBtMouseExited
        stuStrandSearchBt.setBackground(ThemeColors.GOLDEN_YELLOW);
    }//GEN-LAST:event_stuStrandSearchBtMouseExited

    private void stuStrandSearchBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stuStrandSearchBtActionPerformed
        if (stuStrandSearchField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a student id");

        } else {
            int id = Integer.parseInt(stuStrandSearchField.getText());
            strand.getId(id);
            String fullName = strand.getStudentNameById(id);
            stuFullName.setText(fullName);
            //stuGradeLevel.setSelectedIndex(0);
            try {
                int gradeLevel = Integer.parseInt(stuGradeLevel.getSelectedItem().toString());

                // 1. Load strands available for that grade level
                grade.loadStrands(stuStrand, gradeLevel);

                if (stuStrand.getItemCount() > 0) {
                    int strandId = getSelectedStudentStrandId();

                    //updateSection();
                    //grade.loadSections(stuSection, strandId, gradeLevel);
                }

            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error loading strands/sections/subjects.");
            }

        }
    }//GEN-LAST:event_stuStrandSearchBtActionPerformed

    private void stuStrandIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stuStrandIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_stuStrandIdActionPerformed

    private void stuGradeLevelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stuGradeLevelActionPerformed
        updateSection();

        //stuStrand.addItem("TVL-ICT"); //how to add item inside combo box
    }//GEN-LAST:event_stuGradeLevelActionPerformed

    private void stuStrandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stuStrandActionPerformed
        updateSection();
    }//GEN-LAST:event_stuStrandActionPerformed

    private void stuSectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stuSectionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_stuSectionActionPerformed

    private void stuFullNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stuFullNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_stuFullNameActionPerformed

    private void stuSearchBt_2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stuSearchBt_2MouseEntered
        stuSearchBt_2.setBackground(ThemeColors.DEEP_ORANGE);
    }//GEN-LAST:event_stuSearchBt_2MouseEntered

    private void stuSearchBt_2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stuSearchBt_2MouseExited
        stuSearchBt_2.setBackground(ThemeColors.GOLDEN_YELLOW);
    }//GEN-LAST:event_stuSearchBt_2MouseExited

    private void stuSearchBt_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stuSearchBt_2ActionPerformed
        if (stuSearchField_2.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Search field is empty");

        } else {
            String currentText = stuInfoCurrentOrArchived.getText();
            if (currentText.equalsIgnoreCase("Current")) {
                StudentTrackTable.setModel(new DefaultTableModel(null, new Object[]{"Student_ID", "Student Name", "Grade_Level", "Strand", "Section"}));
                strand.loadStudentStrandsTable(StudentTrackTable, stuSearchField_2.getText());
            } else if (currentText.equalsIgnoreCase("Current")) {
                StudentTrackTable.setModel(new DefaultTableModel(null, new Object[]{"Student_ID", "Student Name", "Grade_Level", "Strand", "Section", "date_archived", "reason"}));
                archive.loadArchivedStudentStrandsTable(StudentTrackTable, "");

                //StudentTrackTable.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
            }

        }
    }//GEN-LAST:event_stuSearchBt_2ActionPerformed

    private void stuRefresh_2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stuRefresh_2MouseEntered
        stuRefresh_2.setBackground(ThemeColors.DEEP_ORANGE);
    }//GEN-LAST:event_stuRefresh_2MouseEntered

    private void stuRefresh_2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stuRefresh_2MouseExited
        stuRefresh_2.setBackground(ThemeColors.GOLDEN_YELLOW);
    }//GEN-LAST:event_stuRefresh_2MouseExited

    private void stuRefresh_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stuRefresh_2ActionPerformed
        String currentText = stuInfoCurrentOrArchived.getText();
        if (currentText.equalsIgnoreCase("Current")) {
            StudentTrackTable.setModel(new DefaultTableModel(null, new Object[]{"Student_ID", "Student Name", "Grade_Level", "Strand", "Section"}));
            strand.loadStudentStrandsTable(StudentTrackTable, "");
            stuSearchField_2.setText(null);
        } else if (currentText.equalsIgnoreCase("Current")) {
            StudentTrackTable.setModel(new DefaultTableModel(null, new Object[]{"Student_ID", "Student Name", "Grade_Level", "Strand", "Section", "date_archived", "reason"}));
            archive.loadArchivedStudentStrandsTable(StudentTrackTable, "");
            stuSearchField_2.setText(null);
            //StudentTrackTable.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
        }
    }//GEN-LAST:event_stuRefresh_2ActionPerformed

    private void stuSort_2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stuSort_2MouseEntered
        stuSort_2.setBackground(ThemeColors.DEEP_ORANGE);
    }//GEN-LAST:event_stuSort_2MouseEntered

    private void stuSort_2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stuSort_2MouseExited
        stuSort_2.setBackground(ThemeColors.GOLDEN_YELLOW);
    }//GEN-LAST:event_stuSort_2MouseExited

    private void stuSort_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stuSort_2ActionPerformed
        DefaultTableModel model = (DefaultTableModel) StudentTrackTable.getModel();

        // Attach TableRowSorter to your table
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        StudentTrackTable.setRowSorter(sorter);

        // Example: Sort by Student ID (numerically) and then by Student Name (alphabetically)
        List<RowSorter.SortKey> sortKeys = new ArrayList<>();

        int IdCol = 0;  // Student ID is column 0
        int studentStrandIdCol = 1; // Student Name is column 1

        // First sort by ID (ascending)
        sortKeys.add(new RowSorter.SortKey(IdCol, SortOrder.ASCENDING));

        // Then sort by Name (ascending)
        sortKeys.add(new RowSorter.SortKey(studentStrandIdCol, SortOrder.ASCENDING));

        sorter.setSortKeys(sortKeys);
        sorter.sort();
    }//GEN-LAST:event_stuSort_2ActionPerformed

    private void jButton2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseEntered
        jButton2.setBackground(ThemeColors.DEEP_ORANGE);
    }//GEN-LAST:event_jButton2MouseEntered

    private void jButton2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseExited
        jButton2.setBackground(ThemeColors.GOLDEN_YELLOW);
    }//GEN-LAST:event_jButton2MouseExited

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int a = JOptionPane.showConfirmDialog(this, "Do you want to Logout now?", "Select", JOptionPane.YES_NO_OPTION);
        if (a == 0) {
            this.dispose();
            LoginFrame frame = new LoginFrame();
            frame.setVisible(true);
            frame.setLocationRelativeTo(null);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void stuStrandClearBtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stuStrandClearBtMouseEntered
        stuStrandClearBt.setBackground(ThemeColors.DEEP_ORANGE);
    }//GEN-LAST:event_stuStrandClearBtMouseEntered

    private void stuStrandClearBtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stuStrandClearBtMouseExited
        stuStrandClearBt.setBackground(ThemeColors.GOLDEN_YELLOW);
    }//GEN-LAST:event_stuStrandClearBtMouseExited

    private void stuStrandClearBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stuStrandClearBtActionPerformed
        clearStrand();
    }//GEN-LAST:event_stuStrandClearBtActionPerformed

    private void stuSaveBtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stuSaveBtMouseEntered
        stuSaveBt.setBackground(ThemeColors.DEEP_ORANGE);
    }//GEN-LAST:event_stuSaveBtMouseEntered

    private void stuSaveBtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stuSaveBtMouseExited
        stuSaveBt.setBackground(ThemeColors.GOLDEN_YELLOW);
    }//GEN-LAST:event_stuSaveBtMouseExited

    private void stuSaveBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stuSaveBtActionPerformed
        if (stuStrandId.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Student ID is missing");
            return;
        }

        try {
            int studentId = Integer.parseInt(stuStrandId.getText());
            int gradeLevel = Integer.parseInt(stuGradeLevel.getSelectedItem().toString());
            String strandName = stuStrand.getSelectedItem().toString();
            String sectionSelect = stuSection.getSelectedItem().toString();

            int strandId = strand.convertStrandNameToId(strandName);
            if (strandId == -1) {
                JOptionPane.showMessageDialog(this, "Invalid strand selected");
                return;
            }

            // ✅ Check if student exists
            if (!strand.studentExists(studentId)) {
                JOptionPane.showMessageDialog(this, "Student with ID " + studentId + " does not exist");
                return;
            }
            System.out.println("StudentId:" + studentId);
            System.out.println("gradeLevel:" + gradeLevel);
            System.out.println("strandId:" + strandId);

            // ✅ Check archived enrollment first
            if (archive.isArchivedEnrollmentExists(studentId, gradeLevel, strandId)) {

                JOptionPane.showMessageDialog(this,
                        "⚠ You cannot enroll or transfer to the same Grade Level + Strand that already exists in the archive.\n"
                        + "Use the Restore button if you want to restore this previous enrollment.",
                        "Archived Enrollment Exists",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }

            // ✅ 1. Check if student already enrolled in same strand + grade level
            if (strand.isStudentEnrolledInStrandAndGrade(studentId, strandId, gradeLevel)) {
                Object[] currentEnrollment = strand.getCurrentEnrollment(studentId);
                String currentStrand = (String) currentEnrollment[1];
                String currentSection = (String) currentEnrollment[2];

                JOptionPane.showMessageDialog(this,
                        "Student is already enrolled in " + currentStrand
                        + " Grade " + gradeLevel
                        + " Section " + currentSection);
                return;
            }

            // ✅ 2. Check if student is already enrolled in any strand
            if (strand.isStudentEnrolledInAnyStrand(studentId)) {
                Object[] currentEnrollment = strand.getCurrentEnrollment(studentId);
                int currentGradeLevel = (int) currentEnrollment[0];
                String currentStrand = (String) currentEnrollment[1];
                String currentSection = (String) currentEnrollment[2];
                int currentStrandId = strand.convertStrandNameToId(currentStrand);

                // ✅ Promotion (same strand, higher grade)
                if (currentStrand.equals(strandName)) {
                    if (gradeLevel > currentGradeLevel) {
                        boolean hasPassed = progress.hasStudentPassed(studentId, currentStrandId, currentGradeLevel);
                        if (!hasPassed) {
                            JOptionPane.showMessageDialog(this,
                                    "This student has not yet passed all required subjects.\n"
                                    + "Promotion cannot proceed until requirements are met.",
                                    "Promotion Blocked",
                                    JOptionPane.WARNING_MESSAGE);
                            return;
                        }

                        int response = JOptionPane.showConfirmDialog(
                                this,
                                "Student Promotion:\n\n"
                                + "Current: " + currentStrand + " - Grade " + currentGradeLevel + " - Section " + currentSection
                                + "\nNew: " + strandName + " - Grade " + gradeLevel + " - Section " + sectionSelect
                                + "\n\nConfirm promotion?",
                                "Confirm Student Promotion",
                                JOptionPane.YES_NO_OPTION,
                                JOptionPane.QUESTION_MESSAGE
                        );

                        if (response == JOptionPane.YES_OPTION) {
                            int newSectionId = strand.getAvailableSection(gradeLevel, strandId);
                            if (newSectionId == -1) {
                                JOptionPane.showMessageDialog(this, "No available sections for Grade " + gradeLevel + " in " + strandName);
                                return;
                            }
                            boolean archived = archive.archiveStudentStrand(studentId, currentStrandId, strandId, currentGradeLevel, gradeLevel);
                            if (!archived) {
                                JOptionPane.showMessageDialog(this, "❌ Failed to archive existing record. Promotion cancelled.");
                                return;
                            }

                            boolean success = archive.updateStudentGradeLevel(studentId, gradeLevel, newSectionId);
                            JOptionPane.showMessageDialog(this, success
                                    ? "✅ Student promoted successfully to Grade " + gradeLevel
                                    : "❌ Failed to promote student");
                        }

                    } else {
                        JOptionPane.showMessageDialog(this,
                                "Invalid promotion: New grade level must be higher than current grade.");
                    }

                } else {
                    // ✅ Transfer to different strand
                    int response = JOptionPane.showConfirmDialog(
                            this,
                            "Student Strand Transfer:\n\n"
                            + "Student ID: " + studentId
                            + "\nCurrent: " + currentStrand + " - Grade " + currentGradeLevel + " - Section " + currentSection
                            + "\nNew: " + strandName + " - Grade " + gradeLevel + " - Section " + sectionSelect
                            + "\n\nConfirm transfer?",
                            "Confirm Strand Transfer",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.WARNING_MESSAGE
                    );

                    if (response == JOptionPane.YES_OPTION) {
                        boolean archived = archive.archiveStudentStrand(studentId, currentStrandId, strandId, currentGradeLevel, gradeLevel);
                        if (archived) {
                            boolean success = strand.insertStudentStrand(studentId, strandId, gradeLevel, sectionSelect);
                            JOptionPane.showMessageDialog(this, success
                                    ? "✅ Student transferred successfully to " + strandName
                                    : "❌ Failed to insert new enrollment after transfer");
                        } else {
                            JOptionPane.showMessageDialog(this, "❌ Failed to archive existing record. Transfer cancelled.");
                        }
                    }
                }

            } else {
                // ✅ 3. New enrollment
                int response = JOptionPane.showConfirmDialog(
                        this,
                        "New Student Enrollment:\n\n"
                        + "Student ID: " + studentId
                        + "\nStrand: " + strandName
                        + "\nGrade Level: " + gradeLevel
                        + "\nSection: " + sectionSelect
                        + "\n\nConfirm enrollment?",
                        "Confirm New Enrollment",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE
                );

                if (response == JOptionPane.YES_OPTION) {
                    boolean success = strand.insertStudentStrand(studentId, strandId, gradeLevel, sectionSelect);

                    String schoolYear = getCurrentSchoolYear();
                    String status = "Incomplete";
                    progress.insert(studentId, schoolYear, status);
                    JOptionPane.showMessageDialog(this, success
                            ? "✅ Student enrolled successfully in " + strandName
                            : "❌ Failed to enroll student");
                }
            }

            // ✅ Refresh table
            StudentTrackTable.setModel(new DefaultTableModel(
                    null,
                    new Object[]{"Student_ID", "Student Name", "Grade_Level", "Strand", "Section"}
            ));
            strand.loadStudentStrandsTable(StudentTrackTable, "");
            clearStrand();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid numeric Student ID");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
            ex.printStackTrace();
        }
    }//GEN-LAST:event_stuSaveBtActionPerformed

    private void stuRestoreMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stuRestoreMouseEntered
        stuRestore.setBackground(ThemeColors.DEEP_ORANGE);
    }//GEN-LAST:event_stuRestoreMouseEntered

    private void stuRestoreMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stuRestoreMouseExited
        stuRestore.setBackground(ThemeColors.GOLDEN_YELLOW);
    }//GEN-LAST:event_stuRestoreMouseExited

    private void stuRestoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stuRestoreActionPerformed
        try {
            int studentId = Integer.parseInt(stuStrandId.getText());
            int gradeLevel = Integer.parseInt(stuGradeLevel.getSelectedItem().toString());
            String strandName = stuStrand.getSelectedItem().toString();
            String sectionSelect = stuSection.getSelectedItem().toString();

            int strandId = strand.getStrandIdByName(strandName);
            int sectionId = strand.getSectionIdByName(sectionSelect);

            // ✅ 1. Check if the record exists in the archive table
            if (!archive.isAlreadyInStudentStrand(studentId, gradeLevel, strandId, sectionId)) {
                JOptionPane.showMessageDialog(null,
                        "This record does not exist in the archive. Nothing to restore.");
                return;
            }

            // ✅ 2. Check if the record already exists in the student_strand table
            if (archive.existsInStudentStrand(studentId, gradeLevel, strandId, sectionId)) {
                JOptionPane.showMessageDialog(null,
                        "This record already exists in the student_strand table.");
                return;
            }

            // ✅ 3. Restore record (move from archived → student_strand)
            archive.restoreStudentRecord(studentId, gradeLevel, strandId, sectionId);

            JOptionPane.showMessageDialog(null, "Student successfully restored!");
            archive.loadArchivedStudentStrandsTable(StudentTrackTable, "");

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Invalid student ID or grade level format.");
            ex.printStackTrace();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error while restoring: " + ex.getMessage());
            ex.printStackTrace();
        }
    }//GEN-LAST:event_stuRestoreActionPerformed

    private void stuCurrentOrArchiveMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stuCurrentOrArchiveMouseEntered
        stuCurrentOrArchive.setBackground(ThemeColors.DEEP_ORANGE);
    }//GEN-LAST:event_stuCurrentOrArchiveMouseEntered

    private void stuCurrentOrArchiveMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stuCurrentOrArchiveMouseExited
        stuCurrentOrArchive.setBackground(ThemeColors.GOLDEN_YELLOW);
    }//GEN-LAST:event_stuCurrentOrArchiveMouseExited

    private void stuCurrentOrArchiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stuCurrentOrArchiveActionPerformed
        String currentText = stuCurrentOrArchive.getText();

        if (currentText.equalsIgnoreCase("Archived")) {
            StudentTrackTable.setModel(new DefaultTableModel(null, new Object[]{"Student_ID", "Student Name", "Grade_Level", "Strand", "Section"}));
            strand.loadStudentStrandsTable(StudentTrackTable, "");
            stuCurrentOrArchive.setText("Current");
        } else if (currentText.equalsIgnoreCase("Current")) {
            StudentTrackTable.setModel(new DefaultTableModel(null, new Object[]{"Student_ID", "Student Name", "Grade_Level", "Strand", "Section", "date_archived", "reason"}));
            archive.loadArchivedStudentStrandsTable(StudentTrackTable, "");
            stuCurrentOrArchive.setText("Archived");

            //StudentTrackTable.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
        }
    }//GEN-LAST:event_stuCurrentOrArchiveActionPerformed

    private void classListSearchBtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_classListSearchBtMouseEntered
        classListSearchBt.setBackground(ThemeColors.DEEP_ORANGE);
    }//GEN-LAST:event_classListSearchBtMouseEntered

    private void classListSearchBtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_classListSearchBtMouseExited
        classListSearchBt.setBackground(ThemeColors.GOLDEN_YELLOW);
    }//GEN-LAST:event_classListSearchBtMouseExited

    private void classListSearchBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_classListSearchBtActionPerformed
        try {
            if (strandClassBox.getSelectedItem() == null && sectionClassBox.getSelectedItem() == null) {
                JOptionPane.showMessageDialog(this, "Select GradeLevel to Activate the Strand, and section");
                return;
            }
            String gradeLevelStr = gradeLevelClassBox.getSelectedItem().toString();
            int gradeLevel = Integer.parseInt(gradeLevelStr.split(" - ")[0]);

            // Get strand id
            int strandId = getSelectedClassStrandId();

            // Get section id
            int sectionId = strand.getSelectedSectionId(sectionClassBox);

            DefaultTableModel model = strand.getStudentClassList(gradeLevel, strandId, sectionId);

            // 6. Apply results to the ListHonorTable
            ClassListTable.setModel(model);

            // 7. Handle empty case
            if (model.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "No class list results found.");
            } else {
                JOptionPane.showMessageDialog(this, "Class list generated successfully!");
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error fetching honor list: " + e.getMessage());
        }
    }//GEN-LAST:event_classListSearchBtActionPerformed

    private void gradeLevelClassBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gradeLevelClassBoxActionPerformed
        try {
            int gradeLevel = Integer.parseInt(gradeLevelClassBox.getSelectedItem().toString());

            // 1. Load strands available for that grade level
            strand.loadStrands(strandClassBox, gradeLevel);

            if (strandClassBox.getItemCount() > 0) {
                int strandId = getSelectedClassStrandId();

                strand.loadSections(sectionClassBox, strandId, gradeLevel);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error loading strands/sections/subjects.");
        }
    }//GEN-LAST:event_gradeLevelClassBoxActionPerformed

    private void strandClassBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_strandClassBoxActionPerformed

        try {
            int gradeLevel = Integer.parseInt(gradeLevelClassBox.getSelectedItem().toString());
            int strandId = getSelectedClassStrandId(); // helper to parse "1 - STEM"

            // Update dependent dropdowns
            strand.loadSections(sectionClassBox, strandId, gradeLevel);

        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error loading sections/subjects.");
        }
    }//GEN-LAST:event_strandClassBoxActionPerformed

    private void sectionClassBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sectionClassBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sectionClassBoxActionPerformed

    private void classListLogoutBtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_classListLogoutBtMouseEntered
        classListLogoutBt.setBackground(ThemeColors.DEEP_ORANGE);
    }//GEN-LAST:event_classListLogoutBtMouseEntered

    private void classListLogoutBtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_classListLogoutBtMouseExited
        classListLogoutBt.setBackground(ThemeColors.GOLDEN_YELLOW);
    }//GEN-LAST:event_classListLogoutBtMouseExited

    private void classListLogoutBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_classListLogoutBtActionPerformed
        //LOGOUT
        int a = JOptionPane.showConfirmDialog(this, "Do you want to Logout now?", "Select", JOptionPane.YES_NO_OPTION);
        if (a == 0) {
            this.dispose();
            LoginFrame frame = new LoginFrame();
            frame.setVisible(true);
            frame.setLocationRelativeTo(null);
        }
    }//GEN-LAST:event_classListLogoutBtActionPerformed

    private void classListClearBtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_classListClearBtMouseEntered
        classListClearBt.setBackground(ThemeColors.DEEP_ORANGE);
    }//GEN-LAST:event_classListClearBtMouseEntered

    private void classListClearBtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_classListClearBtMouseExited
        classListClearBt.setBackground(ThemeColors.GOLDEN_YELLOW);
    }//GEN-LAST:event_classListClearBtMouseExited

    private void classListClearBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_classListClearBtActionPerformed
        clearClassListManage();
    }//GEN-LAST:event_classListClearBtActionPerformed

    private void classListPrintBtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_classListPrintBtMouseEntered
        classListPrintBt.setBackground(ThemeColors.DEEP_ORANGE);
    }//GEN-LAST:event_classListPrintBtMouseEntered

    private void classListPrintBtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_classListPrintBtMouseExited
        classListPrintBt.setBackground(ThemeColors.GOLDEN_YELLOW);
    }//GEN-LAST:event_classListPrintBtMouseExited

    private void classListPrintBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_classListPrintBtActionPerformed
        try {
            if (strandClassBox.getSelectedItem() == null || sectionClassBox.getSelectedItem() == null) {
                JOptionPane.showMessageDialog(this,
                        "Please select a Grade Level, Strand, and Section.",
                        "Missing Field",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }

            // ✅ Get values safely
            String gradeLevelStr = gradeLevelClassBox.getSelectedItem().toString();
            int gradeLevel = Integer.parseInt(gradeLevelStr.split(" - ")[0]);
            int sectionId = strand.getSelectedSectionId(sectionClassBox);
            int strandId = getSelectedClassStrandId();

            // ✅ Fetch strand + section names using helper
            String[] names = strand.getStrandAndSectionName(con, sectionId);
            String strandName = names[0];
            String sectionName = names[1];

            // ✅ Debug check
            System.out.println("DEBUG: grade=" + gradeLevel
                    + ", strandId=" + strandId + " (" + strandName + ")"
                    + ", sectionId=" + sectionId + " (" + sectionName + ")");

            // ✅ Generate the class list with names
            strand.generateClassList(ClassListTable, gradeLevel, strandId, sectionId, strandName, sectionName);

            //JOptionPane.showMessageDialog(this, "Class List PDF Generated Successfully!");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,
                    "An error occurred: " + ex.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }//GEN-LAST:event_classListPrintBtActionPerformed

    private void teacherFirstNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_teacherFirstNameFocusGained
        teacherFirstName.setBackground(new java.awt.Color(255, 255, 204)); // light yellow highlight
        teacherFirstName.setText(teacherFirstName.getText().trim());
    }//GEN-LAST:event_teacherFirstNameFocusGained

    private void teacherFirstNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_teacherFirstNameFocusLost
        jFocusLost(teacherFirstName);
    }//GEN-LAST:event_teacherFirstNameFocusLost

    private void teacherMidNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_teacherMidNameFocusGained
        teacherMidName.setBackground(new java.awt.Color(255, 255, 204)); // light yellow highlight
        teacherMidName.setText(teacherMidName.getText().trim());
    }//GEN-LAST:event_teacherMidNameFocusGained

    private void teacherMidNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_teacherMidNameFocusLost
        jFocusLost(teacherMidName);
    }//GEN-LAST:event_teacherMidNameFocusLost

    private void teacherLastNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_teacherLastNameFocusGained
        teacherLastName.setBackground(new java.awt.Color(255, 255, 204)); // light yellow highlight
        teacherLastName.setText(teacherLastName.getText().trim());
    }//GEN-LAST:event_teacherLastNameFocusGained

    private void teacherLastNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_teacherLastNameFocusLost
        jFocusLost(teacherLastName);
    }//GEN-LAST:event_teacherLastNameFocusLost

    private void teacherAddress1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_teacherAddress1FocusGained
        teacherAddress1.setBackground(new java.awt.Color(255, 255, 204)); // light yellow highlight
        teacherAddress1.setText(teacherAddress1.getText().trim());
    }//GEN-LAST:event_teacherAddress1FocusGained

    private void teacherAddress1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_teacherAddress1FocusLost
        jFocusLost(teacherAddress1);
    }//GEN-LAST:event_teacherAddress1FocusLost

    private void teacherAddress2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_teacherAddress2FocusGained
        teacherAddress2.setBackground(new java.awt.Color(255, 255, 204)); // light yellow highlight
        teacherAddress2.setText(teacherAddress2.getText().trim());
    }//GEN-LAST:event_teacherAddress2FocusGained

    private void teacherAddress2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_teacherAddress2FocusLost
        jFocusLost(teacherAddress2);
    }//GEN-LAST:event_teacherAddress2FocusLost

    private void teacherBrowseImgMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_teacherBrowseImgMouseEntered
        teacherBrowseImg.setBackground(ThemeColors.DEEP_ORANGE);
    }//GEN-LAST:event_teacherBrowseImgMouseEntered

    private void teacherBrowseImgMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_teacherBrowseImgMouseExited
        teacherBrowseImg.setBackground(ThemeColors.GOLDEN_YELLOW);
    }//GEN-LAST:event_teacherBrowseImgMouseExited

    private void teacherAddNewBtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_teacherAddNewBtMouseEntered
        teacherAddNewBt.setBackground(ThemeColors.DEEP_ORANGE);
    }//GEN-LAST:event_teacherAddNewBtMouseEntered

    private void teacherAddNewBtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_teacherAddNewBtMouseExited
        teacherAddNewBt.setBackground(ThemeColors.GOLDEN_YELLOW);
    }//GEN-LAST:event_teacherAddNewBtMouseExited

    private void updateBt1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateBt1MouseEntered
        updateBt1.setBackground(ThemeColors.DEEP_ORANGE);
    }//GEN-LAST:event_updateBt1MouseEntered

    private void updateBt1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateBt1MouseExited
        updateBt1.setBackground(ThemeColors.GOLDEN_YELLOW);
    }//GEN-LAST:event_updateBt1MouseExited

    private void teacherClearMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_teacherClearMouseEntered
        teacherClear.setBackground(ThemeColors.DEEP_ORANGE);
    }//GEN-LAST:event_teacherClearMouseEntered

    private void teacherClearMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_teacherClearMouseExited
        teacherClear.setBackground(ThemeColors.GOLDEN_YELLOW);
    }//GEN-LAST:event_teacherClearMouseExited

    private void jButton3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseEntered
        jButton3.setBackground(ThemeColors.DEEP_ORANGE);
    }//GEN-LAST:event_jButton3MouseEntered

    private void jButton3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseExited
        jButton3.setBackground(ThemeColors.GOLDEN_YELLOW);
    }//GEN-LAST:event_jButton3MouseExited

    private void teacherSearchBt_2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_teacherSearchBt_2MouseEntered
        teacherSearchBt_2.setBackground(ThemeColors.DEEP_ORANGE);
    }//GEN-LAST:event_teacherSearchBt_2MouseEntered

    private void teacherSearchBt_2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_teacherSearchBt_2MouseExited
        teacherSearchBt_2.setBackground(ThemeColors.GOLDEN_YELLOW);
    }//GEN-LAST:event_teacherSearchBt_2MouseExited

    private void teacherRefresh_3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_teacherRefresh_3MouseEntered
        teacherRefresh_3.setBackground(ThemeColors.DEEP_ORANGE);
    }//GEN-LAST:event_teacherRefresh_3MouseEntered

    private void teacherRefresh_3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_teacherRefresh_3MouseExited
        teacherRefresh_3.setBackground(ThemeColors.GOLDEN_YELLOW);
    }//GEN-LAST:event_teacherRefresh_3MouseExited

    private void teacherSort_3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_teacherSort_3MouseEntered
        teacherSort_3.setBackground(ThemeColors.DEEP_ORANGE);
    }//GEN-LAST:event_teacherSort_3MouseEntered

    private void teacherSort_3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_teacherSort_3MouseExited
        teacherSort_3.setBackground(ThemeColors.GOLDEN_YELLOW);
    }//GEN-LAST:event_teacherSort_3MouseExited

    private void teacherPrint_3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_teacherPrint_3MouseEntered
        teacherPrint_3.setBackground(ThemeColors.DEEP_ORANGE);
    }//GEN-LAST:event_teacherPrint_3MouseEntered

    private void teacherPrint_3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_teacherPrint_3MouseExited
        teacherPrint_3.setBackground(ThemeColors.GOLDEN_YELLOW);
    }//GEN-LAST:event_teacherPrint_3MouseExited

    private void sensitiveSearchMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sensitiveSearchMouseEntered
        sensitiveSearch.setBackground(ThemeColors.DEEP_ORANGE);
    }//GEN-LAST:event_sensitiveSearchMouseEntered

    private void sensitiveSearchMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sensitiveSearchMouseExited
        sensitiveSearch.setBackground(ThemeColors.GOLDEN_YELLOW);
    }//GEN-LAST:event_sensitiveSearchMouseExited

    private void teacherSensitiveLogoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_teacherSensitiveLogoutMouseEntered
        teacherSensitiveLogout.setBackground(ThemeColors.DEEP_ORANGE);
    }//GEN-LAST:event_teacherSensitiveLogoutMouseEntered

    private void teacherSensitiveLogoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_teacherSensitiveLogoutMouseExited
        teacherSensitiveLogout.setBackground(ThemeColors.GOLDEN_YELLOW);
    }//GEN-LAST:event_teacherSensitiveLogoutMouseExited

    private ImageIcon imageAdjust(String path, byte[] pic) {
        ImageIcon myImage = null;
        if (path != null) {
            myImage = new ImageIcon(path);
        } else {
            myImage = new ImageIcon(pic);

        }
        Image img = myImage.getImage();
        Image newImage = img.getScaledInstance(imagePanel.getWidth(), imagePanel.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon(newImage);
        return icon;

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

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new AdminFrame(adminId).setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable ClassListTable;
    private javax.swing.JButton Clear;
    private javax.swing.JTable SensitiveTable;
    private javax.swing.JTable StudentTable;
    private javax.swing.JTable StudentTrackTable;
    private javax.swing.JTable SubjectTable;
    private javax.swing.JTable TeacherTable;
    private javax.swing.JButton addNewBt;
    private javax.swing.JButton browseBirthCertificate;
    private javax.swing.JButton browseForm137;
    private javax.swing.JButton browseImg;
    private javax.swing.JButton classListClearBt;
    private javax.swing.JButton classListLogoutBt;
    private javax.swing.JButton classListPrintBt;
    private javax.swing.JButton classListSearchBt;
    private javax.swing.JButton clearSubjectManageBt;
    private javax.swing.JButton delBt;
    private javax.swing.JComboBox<String> gradeLevelClassBox;
    private javax.swing.JComboBox<String> gradeLevelSubjectBox;
    private javax.swing.JLabel imagePanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel44;
    private javax.swing.JPanel jPanel45;
    private javax.swing.JPanel jPanel46;
    private javax.swing.JPanel jPanel47;
    private javax.swing.JPanel jPanel48;
    private javax.swing.JPanel jPanel49;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel50;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton logoutFormGradeBt1;
    private javax.swing.JButton searchBt_1;
    private javax.swing.JTextField searchSensitive;
    public static javax.swing.JComboBox<String> sectionClassBox;
    private javax.swing.JButton sensitiveSearch;
    private javax.swing.JComboBox<String> strandClassBox;
    private javax.swing.JTextField stuAddress1;
    private javax.swing.JTextField stuAddress2;
    private com.toedter.calendar.JDateChooser stuBirth;
    private javax.swing.JTextField stuBirthCer;
    private javax.swing.JButton stuCurrentOrArchive;
    private javax.swing.JTextField stuEmail;
    private javax.swing.JTextField stuFatherName;
    private javax.swing.JTextField stuFname;
    private javax.swing.JTextField stuForm137;
    public static javax.swing.JTextField stuFullName;
    private javax.swing.JTextField stuFullNameSub;
    private javax.swing.JComboBox<String> stuGender;
    private javax.swing.JComboBox<String> stuGradeLevel;
    private javax.swing.JButton stuGradeManageRefreshTable1;
    private javax.swing.JTextField stuID;
    private javax.swing.JButton stuInfoCurrentOrArchived;
    private javax.swing.JTextField stuLRN;
    private javax.swing.JTextField stuLastName;
    private javax.swing.JTextField stuMiddleName;
    private javax.swing.JTextField stuMotherName;
    private javax.swing.JTextField stuPhone;
    private javax.swing.JButton stuPrint_1;
    private javax.swing.JButton stuRefresh_1;
    private javax.swing.JButton stuRefresh_2;
    private javax.swing.JButton stuRestore;
    private javax.swing.JButton stuSaveBt;
    private javax.swing.JButton stuSearchBt_2;
    private javax.swing.JTextField stuSearchField_1;
    private javax.swing.JTextField stuSearchField_2;
    private javax.swing.JComboBox<String> stuSection;
    private javax.swing.JButton stuSort_1;
    private javax.swing.JButton stuSort_2;
    private javax.swing.JComboBox<String> stuStrand;
    private javax.swing.JButton stuStrandClearBt;
    public static javax.swing.JTextField stuStrandId;
    private javax.swing.JButton stuStrandSearchBt;
    private javax.swing.JTextField stuStrandSearchField;
    private javax.swing.JTextField stuSubjectIDManage;
    private javax.swing.JButton stuSubjectSaveBt;
    private javax.swing.JButton stuSubjectSearch;
    private javax.swing.JButton teacherAddNewBt;
    private javax.swing.JTextField teacherAddress1;
    private javax.swing.JTextField teacherAddress2;
    private com.toedter.calendar.JDateChooser teacherBirth;
    private javax.swing.JButton teacherBrowseImg;
    private javax.swing.JButton teacherClear;
    private javax.swing.JTextField teacherEmail;
    private javax.swing.JTextField teacherFirstName;
    private javax.swing.JComboBox<String> teacherGender;
    private javax.swing.JTextField teacherID;
    private javax.swing.JLabel teacherImagePanel;
    private javax.swing.JTextField teacherLastName;
    private javax.swing.JTextField teacherMidName;
    private javax.swing.JTextField teacherPhone;
    private javax.swing.JButton teacherPrint_3;
    private javax.swing.JButton teacherRefresh_3;
    private javax.swing.JButton teacherSearchBt_2;
    private javax.swing.JTextField teacherSearchField_3;
    private javax.swing.JButton teacherSensitiveLogout;
    private javax.swing.JButton teacherSort_3;
    private javax.swing.JComboBox<String> teacherStrand;
    private javax.swing.JLabel txtDate;
    private javax.swing.JLabel txtTime;
    private javax.swing.JButton updateBt;
    private javax.swing.JButton updateBt1;
    // End of variables declaration//GEN-END:variables
}
