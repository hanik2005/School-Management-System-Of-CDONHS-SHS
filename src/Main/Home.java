/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Main;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.itextpdf.text.FontFactory;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
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
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.Calculator;
import model.ComboItem;
import model.PageNumberEvent;
import org.apache.commons.io.IOUtils;
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;

/**
 *
 * @author ADMIN
 */
public class Home extends javax.swing.JFrame {

    Student student = new Student();
    Strand strand = new Strand();
    Grade grade = new Grade();
    User user = new User();
    Archive archive = new Archive();
    ListOfHonor listOfHonor = new ListOfHonor();
    StudentProgress progress = new StudentProgress();
    Connection con = MyConnection.getConnection();
    DefaultTableModel subjectModel;

    int xx, xy;
    private DefaultTableModel model;
    private String imagePath;
    private int rowIndex;
    NumberFormat nf = NumberFormat.getInstance();

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Home.class.getName());
    private String birthCertificatePath;
    private String form137Path;
    private int teacherId;

    public Home(int teacherId) {

        this.teacherId = teacherId;
        this.setUndecorated(true);

        initComponents();
        init();

        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

    }

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
        jLabel23 = new javax.swing.JLabel();
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
        jPanel30 = new javax.swing.JPanel();
        jPanel31 = new javax.swing.JPanel();
        jPanel32 = new javax.swing.JPanel();
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
        jLabel43 = new javax.swing.JLabel();
        stuFullNameSub = new javax.swing.JTextField();
        jPanel48 = new javax.swing.JPanel();
        clearSubjectManageBt = new javax.swing.JButton();
        logoutFormGradeBt1 = new javax.swing.JButton();
        stuSubjectSaveBt = new javax.swing.JButton();
        jPanel23 = new javax.swing.JPanel();
        jPanel33 = new javax.swing.JPanel();
        jPanel38 = new javax.swing.JPanel();
        classListSearchBt = new javax.swing.JButton();
        jLabel69 = new javax.swing.JLabel();
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
        jPanel21 = new javax.swing.JPanel();
        jPanel22 = new javax.swing.JPanel();
        jPanel37 = new javax.swing.JPanel();
        stuGradeManageSearchButton = new javax.swing.JButton();
        jLabel68 = new javax.swing.JLabel();
        gradeLevelBox = new javax.swing.JComboBox<>();
        subjectBox = new javax.swing.JComboBox<>();
        jLabel71 = new javax.swing.JLabel();
        quarterBox = new javax.swing.JComboBox<>();
        jLabel72 = new javax.swing.JLabel();
        strandBox = new javax.swing.JComboBox<>();
        jLabel73 = new javax.swing.JLabel();
        sectionBox = new javax.swing.JComboBox<>();
        jLabel74 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        GradeSectioningManageTable = new javax.swing.JTable();
        jPanel44 = new javax.swing.JPanel();
        gradeSaveBt = new javax.swing.JButton();
        gradeLogout = new javax.swing.JButton();
        gradeClear = new javax.swing.JButton();
        gradeSort = new javax.swing.JButton();
        gradeSectioningPrint = new javax.swing.JButton();
        calculatorBt = new javax.swing.JButton();
        jPanel28 = new javax.swing.JPanel();
        jPanel26 = new javax.swing.JPanel();
        jPanel27 = new javax.swing.JPanel();
        jPanel40 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        formTable = new javax.swing.JTable();
        jPanel41 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        stuGradeIDManage = new javax.swing.JTextField();
        stuGradeFormSearch = new javax.swing.JButton();
        jLabel36 = new javax.swing.JLabel();
        gradeLevelStudentBox = new javax.swing.JComboBox<>();
        stuGradeManageRefreshTable = new javax.swing.JButton();
        jLabel38 = new javax.swing.JLabel();
        strandStudentBox = new javax.swing.JComboBox<>();
        jLabel44 = new javax.swing.JLabel();
        stuFullNameFormGrade = new javax.swing.JTextField();
        jPanel42 = new javax.swing.JPanel();
        clearFormBt = new javax.swing.JButton();
        stuFormGradePrint = new javax.swing.JButton();
        logoutFormGradeBt = new javax.swing.JButton();
        jPanel25 = new javax.swing.JPanel();
        jPanel24 = new javax.swing.JPanel();
        jPanel29 = new javax.swing.JPanel();
        jPanel43 = new javax.swing.JPanel();
        stuGradeHonorSearchBt = new javax.swing.JButton();
        jLabel75 = new javax.swing.JLabel();
        gradeLevelHonorBox = new javax.swing.JComboBox<>();
        quarterHonorBox = new javax.swing.JComboBox<>();
        jLabel77 = new javax.swing.JLabel();
        strandHonorBox = new javax.swing.JComboBox<>();
        jLabel78 = new javax.swing.JLabel();
        sectionHonorBox = new javax.swing.JComboBox<>();
        jLabel79 = new javax.swing.JLabel();
        jPanel45 = new javax.swing.JPanel();
        gradeHonorLogout = new javax.swing.JButton();
        gradeHonorClear = new javax.swing.JButton();
        gradeHonorSectioningPrint = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        ListHonorTable = new javax.swing.JTable();
        jPanel51 = new javax.swing.JPanel();
        jPanel52 = new javax.swing.JPanel();
        jPanel55 = new javax.swing.JPanel();
        jPanel56 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        ProgressTable = new javax.swing.JTable();
        jPanel57 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        stuStudentProgressSearchBox = new javax.swing.JButton();
        gradeLevelStudentProgressBox = new javax.swing.JComboBox<>();
        stuStudentProgressRefresh = new javax.swing.JButton();
        strandGradeProgressBox = new javax.swing.JComboBox<>();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        sectionStudentProgressBox = new javax.swing.JComboBox<>();
        jPanel58 = new javax.swing.JPanel();
        clearStudentProgressBt = new javax.swing.JButton();
        logoutStudentProgressBt = new javax.swing.JButton();
        printStudentProgressBt = new javax.swing.JButton();
        finalizeBt = new javax.swing.JButton();
        jPanel19 = new javax.swing.JPanel();
        jPanel34 = new javax.swing.JPanel();
        logStuBt = new javax.swing.JButton();
        jPanel50 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        IdTxt = new javax.swing.JTextField();
        nameTxt = new javax.swing.JTextField();
        dateTxt = new javax.swing.JTextField();
        genderTxt = new javax.swing.JTextField();
        emailTxt = new javax.swing.JTextField();
        phoneTxt = new javax.swing.JTextField();
        address1Txt = new javax.swing.JTextField();
        address2Txt = new javax.swing.JTextField();
        strandTxt = new javax.swing.JTextField();
        stuLrn = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        jPanel53 = new javax.swing.JPanel();
        jPanel54 = new javax.swing.JPanel();
        imagePanel3 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
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
        jLabel1.setText("TEACHER PANEL");

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
        jTabbedPane1.setForeground(new java.awt.Color(17, 24, 39));
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
                .addContainerGap(368, Short.MAX_VALUE)
                .addComponent(stuPrint_1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(stuInfoCurrentOrArchived, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(delBt, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(293, 293, 293))
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

        jLabel23.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(17, 24, 39));
        jLabel23.setText("Full Name");

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
                            .addComponent(jLabel23))
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
                    .addComponent(jLabel23)
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

        jPanel30.setBackground(new java.awt.Color(30, 58, 138));

        jPanel31.setBackground(new java.awt.Color(243, 244, 246));
        jPanel31.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(55, 65, 81), 4, true));

        jPanel32.setBackground(new java.awt.Color(243, 244, 246));
        jPanel32.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(55, 65, 81), 4, true));
        jPanel32.setPreferredSize(new java.awt.Dimension(1380, 620));

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
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE)
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
        jLabel39.setForeground(new java.awt.Color(17, 24, 39));
        jLabel39.setText("Student ID");

        jLabel40.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(17, 24, 39));
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

        jLabel43.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(17, 24, 39));
        jLabel43.setText("Full Name");

        stuFullNameSub.setEditable(false);
        stuFullNameSub.setBackground(new java.awt.Color(204, 204, 204));
        stuFullNameSub.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(30, 58, 138)));
        stuFullNameSub.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                stuFullNameSubKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel47Layout = new javax.swing.GroupLayout(jPanel47);
        jPanel47.setLayout(jPanel47Layout);
        jPanel47Layout.setHorizontalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel47Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel39)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(stuSubjectIDManage, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel43)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(stuFullNameSub, javax.swing.GroupLayout.DEFAULT_SIZE, 366, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel40)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(gradeLevelSubjectBox, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(stuSubjectSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(stuGradeManageRefreshTable1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

        javax.swing.GroupLayout jPanel32Layout = new javax.swing.GroupLayout(jPanel32);
        jPanel32.setLayout(jPanel32Layout);
        jPanel32Layout.setHorizontalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel47, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel46, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel48, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel32Layout.setVerticalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel47, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel46, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel48, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel32, javax.swing.GroupLayout.DEFAULT_SIZE, 1348, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel32, javax.swing.GroupLayout.DEFAULT_SIZE, 634, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addComponent(jPanel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Subjects", jPanel30);

        jPanel23.setBackground(new java.awt.Color(30, 58, 138));

        jPanel33.setBackground(new java.awt.Color(243, 244, 246));
        jPanel33.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(55, 65, 81), 4, true));
        jPanel33.setForeground(new java.awt.Color(0, 0, 0));

        jPanel38.setBackground(new java.awt.Color(243, 244, 246));
        jPanel38.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(55, 65, 81), 4, true));
        jPanel38.setForeground(new java.awt.Color(0, 0, 0));

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

        jLabel69.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel69.setForeground(new java.awt.Color(17, 24, 39));
        jLabel69.setText("Grade Level");

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

        javax.swing.GroupLayout jPanel38Layout = new javax.swing.GroupLayout(jPanel38);
        jPanel38.setLayout(jPanel38Layout);
        jPanel38Layout.setHorizontalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(gradeLevelClassBox, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel69))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel38Layout.createSequentialGroup()
                        .addComponent(strandClassBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18))
                    .addGroup(jPanel38Layout.createSequentialGroup()
                        .addComponent(jLabel81)
                        .addGap(208, 208, 208)))
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel82)
                    .addComponent(sectionClassBox, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(classListSearchBt, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(559, 559, 559))
        );
        jPanel38Layout.setVerticalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel69)
                    .addComponent(jLabel81)
                    .addComponent(jLabel82))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gradeLevelClassBox)
                    .addComponent(strandClassBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sectionClassBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel38Layout.createSequentialGroup()
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

        javax.swing.GroupLayout jPanel33Layout = new javax.swing.GroupLayout(jPanel33);
        jPanel33.setLayout(jPanel33Layout);
        jPanel33Layout.setHorizontalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane7)
                    .addComponent(jPanel49, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel33Layout.setVerticalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel49, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Class List", jPanel23);

        jPanel21.setBackground(new java.awt.Color(30, 58, 138));

        jPanel22.setBackground(new java.awt.Color(243, 244, 246));
        jPanel22.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(55, 65, 81), 4, true));
        jPanel22.setForeground(new java.awt.Color(0, 0, 0));

        jPanel37.setBackground(new java.awt.Color(243, 244, 246));
        jPanel37.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(55, 65, 81), 4, true));
        jPanel37.setForeground(new java.awt.Color(0, 0, 0));

        stuGradeManageSearchButton.setBackground(new java.awt.Color(251, 191, 36));
        stuGradeManageSearchButton.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        stuGradeManageSearchButton.setForeground(new java.awt.Color(0, 0, 0));
        stuGradeManageSearchButton.setText("Search");
        stuGradeManageSearchButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                stuGradeManageSearchButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                stuGradeManageSearchButtonMouseExited(evt);
            }
        });
        stuGradeManageSearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stuGradeManageSearchButtonActionPerformed(evt);
            }
        });

        jLabel68.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel68.setForeground(new java.awt.Color(17, 24, 39));
        jLabel68.setText("Grade Level");

        gradeLevelBox.setBackground(new java.awt.Color(255, 255, 255));
        gradeLevelBox.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        gradeLevelBox.setForeground(new java.awt.Color(0, 0, 0));
        gradeLevelBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "11", "12" }));
        gradeLevelBox.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(30, 58, 138)));
        gradeLevelBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gradeLevelBoxActionPerformed(evt);
            }
        });

        subjectBox.setBackground(new java.awt.Color(255, 255, 255));
        subjectBox.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        subjectBox.setForeground(new java.awt.Color(0, 0, 0));
        subjectBox.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(30, 58, 138)));
        subjectBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subjectBoxActionPerformed(evt);
            }
        });

        jLabel71.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel71.setForeground(new java.awt.Color(17, 24, 39));
        jLabel71.setText("Subject");

        quarterBox.setBackground(new java.awt.Color(255, 255, 255));
        quarterBox.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        quarterBox.setForeground(new java.awt.Color(0, 0, 0));
        quarterBox.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(30, 58, 138)));
        quarterBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quarterBoxActionPerformed(evt);
            }
        });

        jLabel72.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel72.setForeground(new java.awt.Color(17, 24, 39));
        jLabel72.setText("Quarter");

        strandBox.setBackground(new java.awt.Color(255, 255, 255));
        strandBox.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        strandBox.setForeground(new java.awt.Color(0, 0, 0));
        strandBox.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(30, 58, 138)));
        strandBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                strandBoxActionPerformed(evt);
            }
        });

        jLabel73.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel73.setForeground(new java.awt.Color(17, 24, 39));
        jLabel73.setText("Strand");

        sectionBox.setBackground(new java.awt.Color(255, 255, 255));
        sectionBox.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        sectionBox.setForeground(new java.awt.Color(0, 0, 0));
        sectionBox.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(30, 58, 138)));
        sectionBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sectionBoxActionPerformed(evt);
            }
        });

        jLabel74.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel74.setForeground(new java.awt.Color(17, 24, 39));
        jLabel74.setText("Section");

        javax.swing.GroupLayout jPanel37Layout = new javax.swing.GroupLayout(jPanel37);
        jPanel37.setLayout(jPanel37Layout);
        jPanel37Layout.setHorizontalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel37Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(gradeLevelBox, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel68))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel37Layout.createSequentialGroup()
                        .addComponent(strandBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18))
                    .addGroup(jPanel37Layout.createSequentialGroup()
                        .addComponent(jLabel73)
                        .addGap(208, 208, 208)))
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel74)
                    .addComponent(sectionBox, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel71)
                    .addComponent(subjectBox, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(quarterBox, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel72, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(stuGradeManageSearchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel37Layout.setVerticalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel37Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel68)
                    .addComponent(jLabel71)
                    .addComponent(jLabel72)
                    .addComponent(jLabel73)
                    .addComponent(jLabel74))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(quarterBox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(gradeLevelBox)
                        .addComponent(strandBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(subjectBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(sectionBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(jPanel37Layout.createSequentialGroup()
                .addComponent(stuGradeManageSearchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        GradeSectioningManageTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "LRN", "Student Name", "Grade"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(GradeSectioningManageTable);

        jPanel44.setBackground(new java.awt.Color(243, 244, 246));
        jPanel44.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(55, 65, 81), 4, true));

        gradeSaveBt.setBackground(new java.awt.Color(251, 191, 36));
        gradeSaveBt.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        gradeSaveBt.setForeground(new java.awt.Color(0, 0, 0));
        gradeSaveBt.setText("Save");
        gradeSaveBt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                gradeSaveBtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                gradeSaveBtMouseExited(evt);
            }
        });
        gradeSaveBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gradeSaveBtActionPerformed(evt);
            }
        });

        gradeLogout.setBackground(new java.awt.Color(251, 191, 36));
        gradeLogout.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        gradeLogout.setForeground(new java.awt.Color(0, 0, 0));
        gradeLogout.setText("Logout");
        gradeLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                gradeLogoutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                gradeLogoutMouseExited(evt);
            }
        });
        gradeLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gradeLogoutActionPerformed(evt);
            }
        });

        gradeClear.setBackground(new java.awt.Color(251, 191, 36));
        gradeClear.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        gradeClear.setForeground(new java.awt.Color(0, 0, 0));
        gradeClear.setText("Clear");
        gradeClear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                gradeClearMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                gradeClearMouseExited(evt);
            }
        });
        gradeClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gradeClearActionPerformed(evt);
            }
        });

        gradeSort.setBackground(new java.awt.Color(251, 191, 36));
        gradeSort.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        gradeSort.setForeground(new java.awt.Color(0, 0, 0));
        gradeSort.setText("Sort");
        gradeSort.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                gradeSortMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                gradeSortMouseExited(evt);
            }
        });
        gradeSort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gradeSortActionPerformed(evt);
            }
        });

        gradeSectioningPrint.setBackground(new java.awt.Color(251, 191, 36));
        gradeSectioningPrint.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        gradeSectioningPrint.setForeground(new java.awt.Color(0, 0, 0));
        gradeSectioningPrint.setText("Print");
        gradeSectioningPrint.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                gradeSectioningPrintMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                gradeSectioningPrintMouseExited(evt);
            }
        });
        gradeSectioningPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gradeSectioningPrintActionPerformed(evt);
            }
        });

        calculatorBt.setBackground(new java.awt.Color(251, 191, 36));
        calculatorBt.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        calculatorBt.setForeground(new java.awt.Color(0, 0, 0));
        calculatorBt.setText("Calculator");
        calculatorBt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                calculatorBtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                calculatorBtMouseExited(evt);
            }
        });
        calculatorBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calculatorBtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel44Layout = new javax.swing.GroupLayout(jPanel44);
        jPanel44.setLayout(jPanel44Layout);
        jPanel44Layout.setHorizontalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel44Layout.createSequentialGroup()
                .addGap(134, 134, 134)
                .addComponent(gradeSaveBt, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(gradeSectioningPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(gradeClear, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(gradeSort, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(calculatorBt, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(gradeLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(237, 237, 237))
        );
        jPanel44Layout.setVerticalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel44Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(gradeLogout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(gradeSaveBt, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                        .addComponent(gradeClear, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                        .addComponent(gradeSort, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                        .addComponent(gradeSectioningPrint, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                        .addComponent(calculatorBt, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3)
                    .addComponent(jPanel44, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel44, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Grade Sectioning Management", jPanel21);

        jPanel28.setBackground(new java.awt.Color(30, 58, 138));

        jPanel26.setBackground(new java.awt.Color(243, 244, 246));
        jPanel26.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(55, 65, 81), 4, true));

        jPanel27.setBackground(new java.awt.Color(243, 244, 246));
        jPanel27.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(55, 65, 81), 4, true));
        jPanel27.setPreferredSize(new java.awt.Dimension(1380, 620));

        jPanel40.setBackground(new java.awt.Color(243, 244, 246));
        jPanel40.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(55, 65, 81), 4, true));

        formTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Subjects", "First Quarter", "Second Quarter", "Third Quarter", "Fourth Quarter", "Final Rating", "Remarks"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(formTable);
        if (formTable.getColumnModel().getColumnCount() > 0) {
            formTable.getColumnModel().getColumn(4).setHeaderValue("Fourth Quarter");
            formTable.getColumnModel().getColumn(5).setHeaderValue("Final Rating");
            formTable.getColumnModel().getColumn(6).setHeaderValue("Remarks");
        }

        javax.swing.GroupLayout jPanel40Layout = new javax.swing.GroupLayout(jPanel40);
        jPanel40.setLayout(jPanel40Layout);
        jPanel40Layout.setHorizontalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel40Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4)
                .addContainerGap())
        );
        jPanel40Layout.setVerticalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel40Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel41.setBackground(new java.awt.Color(243, 244, 246));
        jPanel41.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(55, 65, 81), 4, true));

        jLabel35.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(17, 24, 39));
        jLabel35.setText("Grade Level");

        stuGradeIDManage.setBackground(new java.awt.Color(255, 255, 255));
        stuGradeIDManage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(30, 58, 138)));
        stuGradeIDManage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stuGradeIDManageActionPerformed(evt);
            }
        });
        stuGradeIDManage.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                stuGradeIDManageKeyTyped(evt);
            }
        });

        stuGradeFormSearch.setBackground(new java.awt.Color(251, 191, 36));
        stuGradeFormSearch.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        stuGradeFormSearch.setForeground(new java.awt.Color(0, 0, 0));
        stuGradeFormSearch.setText("Search");
        stuGradeFormSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                stuGradeFormSearchMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                stuGradeFormSearchMouseExited(evt);
            }
        });
        stuGradeFormSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stuGradeFormSearchActionPerformed(evt);
            }
        });

        jLabel36.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(17, 24, 39));
        jLabel36.setText("Student ID");

        gradeLevelStudentBox.setBackground(new java.awt.Color(255, 255, 255));
        gradeLevelStudentBox.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        gradeLevelStudentBox.setForeground(new java.awt.Color(0, 0, 0));
        gradeLevelStudentBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "11", "12" }));
        gradeLevelStudentBox.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(30, 58, 138)));
        gradeLevelStudentBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gradeLevelStudentBoxActionPerformed(evt);
            }
        });

        stuGradeManageRefreshTable.setBackground(new java.awt.Color(251, 191, 36));
        stuGradeManageRefreshTable.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        stuGradeManageRefreshTable.setForeground(new java.awt.Color(0, 0, 0));
        stuGradeManageRefreshTable.setText("Refresh");
        stuGradeManageRefreshTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                stuGradeManageRefreshTableMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                stuGradeManageRefreshTableMouseExited(evt);
            }
        });
        stuGradeManageRefreshTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stuGradeManageRefreshTableActionPerformed(evt);
            }
        });

        jLabel38.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(17, 24, 39));
        jLabel38.setText("Strand");

        strandStudentBox.setBackground(new java.awt.Color(255, 255, 255));
        strandStudentBox.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        strandStudentBox.setForeground(new java.awt.Color(0, 0, 0));
        strandStudentBox.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(30, 58, 138)));
        strandStudentBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                strandStudentBoxActionPerformed(evt);
            }
        });

        jLabel44.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(17, 24, 39));
        jLabel44.setText("Full Name");

        stuFullNameFormGrade.setEditable(false);
        stuFullNameFormGrade.setBackground(new java.awt.Color(204, 204, 204));
        stuFullNameFormGrade.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(30, 58, 138)));
        stuFullNameFormGrade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stuFullNameFormGradeActionPerformed(evt);
            }
        });
        stuFullNameFormGrade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                stuFullNameFormGradeKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel41Layout = new javax.swing.GroupLayout(jPanel41);
        jPanel41.setLayout(jPanel41Layout);
        jPanel41Layout.setHorizontalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel41Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel36)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(stuGradeIDManage, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel44)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(stuFullNameFormGrade)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel35)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(gradeLevelStudentBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel38)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(strandStudentBox, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(stuGradeFormSearch)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(stuGradeManageRefreshTable)
                .addContainerGap())
        );
        jPanel41Layout.setVerticalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel41Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(stuGradeFormSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(stuGradeIDManage, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stuGradeManageRefreshTable)
                    .addComponent(jLabel36)
                    .addComponent(gradeLevelStudentBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel38)
                    .addComponent(strandStudentBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel44)
                    .addComponent(stuFullNameFormGrade, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel42.setBackground(new java.awt.Color(243, 244, 246));
        jPanel42.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(55, 65, 81), 4, true));

        clearFormBt.setBackground(new java.awt.Color(251, 191, 36));
        clearFormBt.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        clearFormBt.setForeground(new java.awt.Color(0, 0, 0));
        clearFormBt.setText("Clear");
        clearFormBt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                clearFormBtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                clearFormBtMouseExited(evt);
            }
        });
        clearFormBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearFormBtActionPerformed(evt);
            }
        });

        stuFormGradePrint.setBackground(new java.awt.Color(251, 191, 36));
        stuFormGradePrint.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        stuFormGradePrint.setForeground(new java.awt.Color(0, 0, 0));
        stuFormGradePrint.setText("Print");
        stuFormGradePrint.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                stuFormGradePrintMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                stuFormGradePrintMouseExited(evt);
            }
        });
        stuFormGradePrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stuFormGradePrintActionPerformed(evt);
            }
        });

        logoutFormGradeBt.setBackground(new java.awt.Color(251, 191, 36));
        logoutFormGradeBt.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        logoutFormGradeBt.setForeground(new java.awt.Color(0, 0, 0));
        logoutFormGradeBt.setText("Logout");
        logoutFormGradeBt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                logoutFormGradeBtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                logoutFormGradeBtMouseExited(evt);
            }
        });
        logoutFormGradeBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutFormGradeBtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel42Layout = new javax.swing.GroupLayout(jPanel42);
        jPanel42.setLayout(jPanel42Layout);
        jPanel42Layout.setHorizontalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel42Layout.createSequentialGroup()
                .addContainerGap(438, Short.MAX_VALUE)
                .addComponent(stuFormGradePrint, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(clearFormBt, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(548, 548, 548))
            .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel42Layout.createSequentialGroup()
                    .addContainerGap(778, Short.MAX_VALUE)
                    .addComponent(logoutFormGradeBt, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(377, 377, 377)))
        );
        jPanel42Layout.setVerticalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel42Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(stuFormGradePrint, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                    .addComponent(clearFormBt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel42Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(logoutFormGradeBt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel41, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel42, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel27, javax.swing.GroupLayout.DEFAULT_SIZE, 1348, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel27, javax.swing.GroupLayout.DEFAULT_SIZE, 634, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addComponent(jPanel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Grade Form Table", jPanel28);

        jPanel25.setBackground(new java.awt.Color(30, 58, 138));

        jPanel24.setBackground(new java.awt.Color(243, 244, 246));

        jPanel29.setBackground(new java.awt.Color(243, 244, 246));
        jPanel29.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(55, 65, 81), 4, true));
        jPanel29.setForeground(new java.awt.Color(0, 0, 0));

        jPanel43.setBackground(new java.awt.Color(243, 244, 246));
        jPanel43.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(55, 65, 81), 4, true));
        jPanel43.setForeground(new java.awt.Color(0, 0, 0));

        stuGradeHonorSearchBt.setBackground(new java.awt.Color(251, 191, 36));
        stuGradeHonorSearchBt.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        stuGradeHonorSearchBt.setForeground(new java.awt.Color(0, 0, 0));
        stuGradeHonorSearchBt.setText("Search");
        stuGradeHonorSearchBt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                stuGradeHonorSearchBtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                stuGradeHonorSearchBtMouseExited(evt);
            }
        });
        stuGradeHonorSearchBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stuGradeHonorSearchBtActionPerformed(evt);
            }
        });

        jLabel75.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel75.setForeground(new java.awt.Color(17, 24, 39));
        jLabel75.setText("Grade Level");

        gradeLevelHonorBox.setBackground(new java.awt.Color(255, 255, 255));
        gradeLevelHonorBox.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        gradeLevelHonorBox.setForeground(new java.awt.Color(0, 0, 0));
        gradeLevelHonorBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "11", "12" }));
        gradeLevelHonorBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gradeLevelHonorBoxActionPerformed(evt);
            }
        });

        quarterHonorBox.setBackground(new java.awt.Color(255, 255, 255));
        quarterHonorBox.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        quarterHonorBox.setForeground(new java.awt.Color(0, 0, 0));
        quarterHonorBox.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(30, 58, 138)));
        quarterHonorBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quarterHonorBoxActionPerformed(evt);
            }
        });

        jLabel77.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel77.setForeground(new java.awt.Color(17, 24, 39));
        jLabel77.setText("Quarter");

        strandHonorBox.setBackground(new java.awt.Color(255, 255, 255));
        strandHonorBox.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        strandHonorBox.setForeground(new java.awt.Color(0, 0, 0));
        strandHonorBox.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(30, 58, 138)));
        strandHonorBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                strandHonorBoxActionPerformed(evt);
            }
        });

        jLabel78.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel78.setForeground(new java.awt.Color(17, 24, 39));
        jLabel78.setText("Strand");

        sectionHonorBox.setBackground(new java.awt.Color(255, 255, 255));
        sectionHonorBox.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        sectionHonorBox.setForeground(new java.awt.Color(0, 0, 0));
        sectionHonorBox.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(30, 58, 138)));
        sectionHonorBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sectionHonorBoxActionPerformed(evt);
            }
        });

        jLabel79.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel79.setForeground(new java.awt.Color(17, 24, 39));
        jLabel79.setText("Section");

        javax.swing.GroupLayout jPanel43Layout = new javax.swing.GroupLayout(jPanel43);
        jPanel43.setLayout(jPanel43Layout);
        jPanel43Layout.setHorizontalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel43Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(gradeLevelHonorBox, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel75))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel43Layout.createSequentialGroup()
                        .addComponent(strandHonorBox, 0, 410, Short.MAX_VALUE)
                        .addGap(18, 18, 18))
                    .addGroup(jPanel43Layout.createSequentialGroup()
                        .addComponent(jLabel78)
                        .addGap(208, 208, 208)))
                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sectionHonorBox, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel79))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel77, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(quarterHonorBox, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(stuGradeHonorSearchBt, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(228, 228, 228))
        );
        jPanel43Layout.setVerticalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel43Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel43Layout.createSequentialGroup()
                        .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel75)
                            .addComponent(jLabel77)
                            .addComponent(jLabel78)
                            .addComponent(jLabel79))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(gradeLevelHonorBox)
                            .addComponent(strandHonorBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sectionHonorBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(quarterHonorBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(stuGradeHonorSearchBt, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel45.setBackground(new java.awt.Color(243, 244, 246));
        jPanel45.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(55, 65, 81), 4, true));

        gradeHonorLogout.setBackground(new java.awt.Color(251, 191, 36));
        gradeHonorLogout.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        gradeHonorLogout.setForeground(new java.awt.Color(0, 0, 0));
        gradeHonorLogout.setText("Logout");
        gradeHonorLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                gradeHonorLogoutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                gradeHonorLogoutMouseExited(evt);
            }
        });
        gradeHonorLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gradeHonorLogoutActionPerformed(evt);
            }
        });

        gradeHonorClear.setBackground(new java.awt.Color(251, 191, 36));
        gradeHonorClear.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        gradeHonorClear.setForeground(new java.awt.Color(0, 0, 0));
        gradeHonorClear.setText("Clear");
        gradeHonorClear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                gradeHonorClearMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                gradeHonorClearMouseExited(evt);
            }
        });
        gradeHonorClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gradeHonorClearActionPerformed(evt);
            }
        });

        gradeHonorSectioningPrint.setBackground(new java.awt.Color(251, 191, 36));
        gradeHonorSectioningPrint.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        gradeHonorSectioningPrint.setForeground(new java.awt.Color(0, 0, 0));
        gradeHonorSectioningPrint.setText("Print");
        gradeHonorSectioningPrint.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                gradeHonorSectioningPrintMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                gradeHonorSectioningPrintMouseExited(evt);
            }
        });
        gradeHonorSectioningPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gradeHonorSectioningPrintActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel45Layout = new javax.swing.GroupLayout(jPanel45);
        jPanel45.setLayout(jPanel45Layout);
        jPanel45Layout.setHorizontalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel45Layout.createSequentialGroup()
                .addGap(431, 431, 431)
                .addComponent(gradeHonorSectioningPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(gradeHonorClear, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(gradeHonorLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(364, 364, 364))
        );
        jPanel45Layout.setVerticalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel45Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gradeHonorLogout, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                    .addComponent(gradeHonorClear, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                    .addComponent(gradeHonorSectioningPrint, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE))
                .addContainerGap())
        );

        ListHonorTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "LRN", "Student Name", "Average"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(ListHonorTable);

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
                        .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel43, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(7, 7, 7))))
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel43, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE)
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
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1378, Short.MAX_VALUE)
            .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel25Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 660, Short.MAX_VALUE)
            .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel25Layout.createSequentialGroup()
                    .addGap(0, 4, Short.MAX_VALUE)
                    .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 3, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("List of Honors", jPanel25);

        jPanel51.setBackground(new java.awt.Color(30, 58, 138));

        jPanel52.setBackground(new java.awt.Color(243, 244, 246));
        jPanel52.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(55, 65, 81), 4, true));

        jPanel55.setBackground(new java.awt.Color(243, 244, 246));
        jPanel55.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(55, 65, 81), 4, true));
        jPanel55.setPreferredSize(new java.awt.Dimension(1380, 620));

        jPanel56.setBackground(new java.awt.Color(243, 244, 246));
        jPanel56.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(55, 65, 81), 4, true));

        ProgressTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "LRN", "Student_Name", "School_Year", "Final_Average", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane8.setViewportView(ProgressTable);

        javax.swing.GroupLayout jPanel56Layout = new javax.swing.GroupLayout(jPanel56);
        jPanel56.setLayout(jPanel56Layout);
        jPanel56Layout.setHorizontalGroup(
            jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel56Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane8)
                .addContainerGap())
        );
        jPanel56Layout.setVerticalGroup(
            jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel56Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel57.setBackground(new java.awt.Color(243, 244, 246));
        jPanel57.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(55, 65, 81), 4, true));

        jLabel37.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(17, 24, 39));
        jLabel37.setText("Grade Level");

        stuStudentProgressSearchBox.setBackground(new java.awt.Color(251, 191, 36));
        stuStudentProgressSearchBox.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        stuStudentProgressSearchBox.setForeground(new java.awt.Color(0, 0, 0));
        stuStudentProgressSearchBox.setText("Search");
        stuStudentProgressSearchBox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                stuStudentProgressSearchBoxMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                stuStudentProgressSearchBoxMouseExited(evt);
            }
        });
        stuStudentProgressSearchBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stuStudentProgressSearchBoxActionPerformed(evt);
            }
        });

        gradeLevelStudentProgressBox.setBackground(new java.awt.Color(255, 255, 255));
        gradeLevelStudentProgressBox.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        gradeLevelStudentProgressBox.setForeground(new java.awt.Color(0, 0, 0));
        gradeLevelStudentProgressBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "11", "12" }));
        gradeLevelStudentProgressBox.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(30, 58, 138)));
        gradeLevelStudentProgressBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gradeLevelStudentProgressBoxActionPerformed(evt);
            }
        });

        stuStudentProgressRefresh.setBackground(new java.awt.Color(251, 191, 36));
        stuStudentProgressRefresh.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        stuStudentProgressRefresh.setForeground(new java.awt.Color(0, 0, 0));
        stuStudentProgressRefresh.setText("Refresh");
        stuStudentProgressRefresh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                stuStudentProgressRefreshMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                stuStudentProgressRefreshMouseExited(evt);
            }
        });
        stuStudentProgressRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stuStudentProgressRefreshActionPerformed(evt);
            }
        });

        strandGradeProgressBox.setBackground(new java.awt.Color(255, 255, 255));
        strandGradeProgressBox.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        strandGradeProgressBox.setForeground(new java.awt.Color(0, 0, 0));
        strandGradeProgressBox.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(30, 58, 138)));
        strandGradeProgressBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                strandGradeProgressBoxActionPerformed(evt);
            }
        });

        jLabel41.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(17, 24, 39));
        jLabel41.setText("Strand");

        jLabel42.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(17, 24, 39));
        jLabel42.setText("Section");

        sectionStudentProgressBox.setBackground(new java.awt.Color(255, 255, 255));
        sectionStudentProgressBox.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        sectionStudentProgressBox.setForeground(new java.awt.Color(0, 0, 0));
        sectionStudentProgressBox.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(30, 58, 138)));
        sectionStudentProgressBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sectionStudentProgressBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel57Layout = new javax.swing.GroupLayout(jPanel57);
        jPanel57.setLayout(jPanel57Layout);
        jPanel57Layout.setHorizontalGroup(
            jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel57Layout.createSequentialGroup()
                .addComponent(jLabel37)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(gradeLevelStudentProgressBox, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel41)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(strandGradeProgressBox, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel42)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sectionStudentProgressBox, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(stuStudentProgressSearchBox, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(stuStudentProgressRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(266, Short.MAX_VALUE))
        );
        jPanel57Layout.setVerticalGroup(
            jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel57Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(stuStudentProgressSearchBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(stuStudentProgressRefresh)
                        .addComponent(gradeLevelStudentProgressBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(strandGradeProgressBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(sectionStudentProgressBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel57Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel42)
                            .addComponent(jLabel41)
                            .addComponent(jLabel37))))
                .addContainerGap())
        );

        jPanel58.setBackground(new java.awt.Color(243, 244, 246));
        jPanel58.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(55, 65, 81), 4, true));

        clearStudentProgressBt.setBackground(new java.awt.Color(251, 191, 36));
        clearStudentProgressBt.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        clearStudentProgressBt.setForeground(new java.awt.Color(0, 0, 0));
        clearStudentProgressBt.setText("Clear");
        clearStudentProgressBt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                clearStudentProgressBtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                clearStudentProgressBtMouseExited(evt);
            }
        });
        clearStudentProgressBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearStudentProgressBtActionPerformed(evt);
            }
        });

        logoutStudentProgressBt.setBackground(new java.awt.Color(251, 191, 36));
        logoutStudentProgressBt.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        logoutStudentProgressBt.setForeground(new java.awt.Color(0, 0, 0));
        logoutStudentProgressBt.setText("Logout");
        logoutStudentProgressBt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                logoutStudentProgressBtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                logoutStudentProgressBtMouseExited(evt);
            }
        });
        logoutStudentProgressBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutStudentProgressBtActionPerformed(evt);
            }
        });

        printStudentProgressBt.setBackground(new java.awt.Color(251, 191, 36));
        printStudentProgressBt.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        printStudentProgressBt.setForeground(new java.awt.Color(0, 0, 0));
        printStudentProgressBt.setText("Print");
        printStudentProgressBt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                printStudentProgressBtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                printStudentProgressBtMouseExited(evt);
            }
        });
        printStudentProgressBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printStudentProgressBtActionPerformed(evt);
            }
        });

        finalizeBt.setBackground(new java.awt.Color(251, 191, 36));
        finalizeBt.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        finalizeBt.setForeground(new java.awt.Color(0, 0, 0));
        finalizeBt.setText("Finalize Status");
        finalizeBt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                finalizeBtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                finalizeBtMouseExited(evt);
            }
        });
        finalizeBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finalizeBtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel58Layout = new javax.swing.GroupLayout(jPanel58);
        jPanel58.setLayout(jPanel58Layout);
        jPanel58Layout.setHorizontalGroup(
            jPanel58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel58Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(finalizeBt, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(clearStudentProgressBt, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(printStudentProgressBt, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(logoutStudentProgressBt, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(288, 288, 288))
        );
        jPanel58Layout.setVerticalGroup(
            jPanel58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel58Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(logoutStudentProgressBt, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                    .addComponent(clearStudentProgressBt, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                    .addComponent(printStudentProgressBt, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                    .addComponent(finalizeBt, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel55Layout = new javax.swing.GroupLayout(jPanel55);
        jPanel55.setLayout(jPanel55Layout);
        jPanel55Layout.setHorizontalGroup(
            jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel55Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel57, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel56, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel58, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel55Layout.setVerticalGroup(
            jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel55Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel57, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel56, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel58, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel52Layout = new javax.swing.GroupLayout(jPanel52);
        jPanel52.setLayout(jPanel52Layout);
        jPanel52Layout.setHorizontalGroup(
            jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel52Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel55, javax.swing.GroupLayout.DEFAULT_SIZE, 1348, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel52Layout.setVerticalGroup(
            jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel52Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel55, javax.swing.GroupLayout.DEFAULT_SIZE, 634, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel51Layout = new javax.swing.GroupLayout(jPanel51);
        jPanel51.setLayout(jPanel51Layout);
        jPanel51Layout.setHorizontalGroup(
            jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel52, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel51Layout.setVerticalGroup(
            jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel51Layout.createSequentialGroup()
                .addComponent(jPanel52, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Student Progress", jPanel51);

        jPanel19.setBackground(new java.awt.Color(30, 58, 138));

        jPanel34.setBackground(new java.awt.Color(243, 244, 246));
        jPanel34.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(55, 65, 81), 4, true));
        jPanel34.setForeground(new java.awt.Color(0, 0, 0));

        logStuBt.setBackground(new java.awt.Color(251, 191, 36));
        logStuBt.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        logStuBt.setForeground(new java.awt.Color(0, 0, 0));
        logStuBt.setText("Logout");
        logStuBt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                logStuBtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                logStuBtMouseExited(evt);
            }
        });
        logStuBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logStuBtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel34Layout = new javax.swing.GroupLayout(jPanel34);
        jPanel34.setLayout(jPanel34Layout);
        jPanel34Layout.setHorizontalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addGap(517, 517, 517)
                .addComponent(logStuBt, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(608, Short.MAX_VALUE))
        );
        jPanel34Layout.setVerticalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel34Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(logStuBt, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        jPanel50.setBackground(new java.awt.Color(243, 244, 246));
        jPanel50.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(55, 65, 81), 4, true));
        jPanel50.setForeground(new java.awt.Color(0, 0, 0));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(17, 24, 39));
        jLabel6.setText("ID:");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(17, 24, 39));
        jLabel7.setText("Name:");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(17, 24, 39));
        jLabel8.setText("Gender:");

        jLabel18.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(17, 24, 39));
        jLabel18.setText("Email:");

        jLabel24.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(17, 24, 39));
        jLabel24.setText("Phone Number:");

        jLabel27.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(17, 24, 39));
        jLabel27.setText("Address Line 1: ");

        jLabel28.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(17, 24, 39));
        jLabel28.setText("Address Line 2: ");

        jLabel29.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(17, 24, 39));
        jLabel29.setText("Strand Assigned:");

        jLabel30.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(17, 24, 39));
        jLabel30.setText("Date of Birth:");

        IdTxt.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        IdTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(30, 58, 138)));
        IdTxt.setEnabled(false);

        nameTxt.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        nameTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(30, 58, 138)));
        nameTxt.setEnabled(false);

        dateTxt.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        dateTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(30, 58, 138)));
        dateTxt.setEnabled(false);

        genderTxt.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        genderTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(30, 58, 138)));
        genderTxt.setEnabled(false);

        emailTxt.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        emailTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(30, 58, 138)));
        emailTxt.setEnabled(false);

        phoneTxt.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        phoneTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(30, 58, 138)));
        phoneTxt.setEnabled(false);

        address1Txt.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        address1Txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(30, 58, 138)));
        address1Txt.setEnabled(false);

        address2Txt.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        address2Txt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(30, 58, 138)));
        address2Txt.setEnabled(false);

        strandTxt.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        strandTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(30, 58, 138)));
        strandTxt.setEnabled(false);

        stuLrn.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        stuLrn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(30, 58, 138)));
        stuLrn.setEnabled(false);

        jLabel31.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(17, 24, 39));
        jLabel31.setText("Hire Date:");

        javax.swing.GroupLayout jPanel50Layout = new javax.swing.GroupLayout(jPanel50);
        jPanel50.setLayout(jPanel50Layout);
        jPanel50Layout.setHorizontalGroup(
            jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel50Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel50Layout.createSequentialGroup()
                        .addComponent(jLabel27)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(address1Txt))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel50Layout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(phoneTxt))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel50Layout.createSequentialGroup()
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(emailTxt))
                    .addGroup(jPanel50Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(genderTxt))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel50Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(IdTxt))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel50Layout.createSequentialGroup()
                        .addComponent(jLabel30)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dateTxt))
                    .addGroup(jPanel50Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel50Layout.createSequentialGroup()
                        .addComponent(jLabel28)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(address2Txt))
                    .addGroup(jPanel50Layout.createSequentialGroup()
                        .addGroup(jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel29)
                            .addComponent(jLabel31))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(stuLrn)
                            .addComponent(strandTxt))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel50Layout.setVerticalGroup(
            jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel50Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(IdTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(nameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(dateTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(genderTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel18)
                    .addComponent(emailTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(phoneTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(address1Txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(address2Txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(strandTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(stuLrn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        jPanel53.setBackground(new java.awt.Color(243, 244, 246));
        jPanel53.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(55, 65, 81), 4, true));
        jPanel53.setForeground(new java.awt.Color(0, 0, 0));

        jPanel54.setBackground(new java.awt.Color(204, 204, 204));
        jPanel54.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(55, 65, 81), 2, true));

        imagePanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imagePanel3MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                imagePanel3MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel54Layout = new javax.swing.GroupLayout(jPanel54);
        jPanel54.setLayout(jPanel54Layout);
        jPanel54Layout.setHorizontalGroup(
            jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel54Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(imagePanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel54Layout.setVerticalGroup(
            jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imagePanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
        );

        jLabel34.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(17, 24, 39));
        jLabel34.setText("Profile Image");

        javax.swing.GroupLayout jPanel53Layout = new javax.swing.GroupLayout(jPanel53);
        jPanel53.setLayout(jPanel53Layout);
        jPanel53Layout.setHorizontalGroup(
            jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel53Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel34)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
                .addComponent(jPanel54, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel53Layout.setVerticalGroup(
            jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel53Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel54, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel34))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel50, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(141, 141, 141)
                .addComponent(jPanel53, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(192, Short.MAX_VALUE))
            .addComponent(jPanel34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(jPanel53, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel50, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 185, Short.MAX_VALUE)
                .addComponent(jPanel34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Account", jPanel19);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1368, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 695, Short.MAX_VALUE)
                .addContainerGap())
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
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void init() {

        setBackgroundPanel();
        setInformation();
        setStrandInformation();
        setTime();
        setDate();
        // modelSubjects();
        tableViewStudent();
        tableViewSubject();
        tableViewStrand();
        tableViewClassList();
        tableViewSectioningGrade();
        tableViewStudentProgress();
        tableViewFormGrade();
        tableViewHonorTable();
        stuID.setText(String.valueOf(student.getMax()));
        //strandId.setText(String.valueOf(strand.getMax()));
        //idGradeManage.setText(String.valueOf(grade.getMax()));
    }

    public void setStrandInformation() {
        Teacher teacher = new Teacher();
        teacher.setInformationStrandDatabase(teacherId, strandTxt);
    }

    public void setInformation() {
        Teacher teacher = new Teacher();
        teacher.loadStudentInformation(
                teacherId, IdTxt, nameTxt, genderTxt, dateTxt,
                emailTxt, phoneTxt,
                address1Txt, address2Txt, stuLrn,
                imagePanel3
        );

    }

    public void tableViewStudent() {
        student.getStudentValue(StudentTable, "");
        model = (DefaultTableModel) StudentTable.getModel();
        StudentTable.setRowHeight(30);
        StudentTable.setShowGrid(true);
        StudentTable.setGridColor(Color.black);
        StudentTable.setBackground(Color.white);
    }

    public void tableViewStudentProgress() {
        model = (DefaultTableModel) ProgressTable.getModel();
        ProgressTable.setRowHeight(30);
        ProgressTable.setShowGrid(true);
        ProgressTable.setGridColor(Color.black);
        ProgressTable.setBackground(Color.white);
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

    public void tableViewClassList() {
        model = (DefaultTableModel) ClassListTable.getModel();
        ClassListTable.setRowHeight(30);
        ClassListTable.setShowGrid(true);
        ClassListTable.setGridColor(Color.black);
        ClassListTable.setBackground(Color.white);

    }

    public void tableViewHonorTable() {
        model = (DefaultTableModel) ListHonorTable.getModel();
        ListHonorTable.setRowHeight(30);
        ListHonorTable.setShowGrid(true);
        ListHonorTable.setGridColor(Color.black);
        ListHonorTable.setBackground(Color.white);
    }

    private void tableViewStrand() {
        strand.loadStudentStrandsTable(StudentTrackTable, "");
        model = (DefaultTableModel) StudentTrackTable.getModel();
        StudentTrackTable.setRowHeight(30);
        StudentTrackTable.setShowGrid(true);
        StudentTrackTable.setGridColor(Color.black);
        StudentTrackTable.setBackground(Color.white);
    }

    private void tableViewSectioningGrade() {
        model = (DefaultTableModel) GradeSectioningManageTable.getModel();
        GradeSectioningManageTable.setRowHeight(30);
        GradeSectioningManageTable.setShowGrid(true);
        GradeSectioningManageTable.setGridColor(Color.black);
        GradeSectioningManageTable.setBackground(Color.white);
    }

    public void tableViewFormGrade() {
        model = (DefaultTableModel) formTable.getModel();
        formTable.setRowHeight(30);
        formTable.setShowGrid(true);
        formTable.setGridColor(Color.black);
        formTable.setBackground(Color.white);
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

    public void clearStudentProgress() {
        sectionStudentProgressBox.removeAllItems();
        strandGradeProgressBox.removeAllItems();
        ProgressTable.clearSelection();
        ProgressTable.setModel(new DefaultTableModel(null, new Object[]{"LRN", "Student_Name", "School_Year",
            "Final_Average", "Status"}));
    }

    public void clearListGrade() {
        gradeLevelHonorBox.setSelectedIndex(0);
        strandHonorBox.removeAllItems();
        sectionHonorBox.removeAllItems();
        quarterHonorBox.removeAllItems();
        ListHonorTable.setModel(new DefaultTableModel(null, new Object[]{"LRN", "Student_Name", "Grade"}));
    }

    private void clearGradeManage() {
        gradeLevelBox.setSelectedIndex(0);
        strandBox.removeAllItems();
        sectionBox.removeAllItems();
        subjectBox.removeAllItems();
        quarterBox.removeAllItems();

        DefaultTableModel model = (DefaultTableModel) GradeSectioningManageTable.getModel();
        model.setRowCount(0); // ✅ clears rows without breaking references

    }

    private void clearformGradeManage() {
        stuGradeIDManage.setText(null);
        gradeLevelStudentBox.setSelectedIndex(0);
        DefaultTableModel model = (DefaultTableModel) formTable.getModel();
        model.setRowCount(0); // ✅ clears rows without breaking references
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

    public void setBackgroundPanel() {
        // Create background panel with image
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
        jPanel21.setLayout(new BorderLayout());
        jPanel21.add(bgPanel5, BorderLayout.CENTER);
        jPanel21.revalidate();
        jPanel21.repaint();

        BackgroundPanel bgPanel6 = new BackgroundPanel("/assets/background.jpg");
        bgPanel6.setLayout(new BorderLayout());
        jPanel26.setLayout(new BorderLayout());
        jPanel26.add(bgPanel6, BorderLayout.CENTER);
        jPanel26.revalidate();
        jPanel26.repaint();

        BackgroundPanel bgPanel7 = new BackgroundPanel("/assets/background.jpg");
        bgPanel7.setLayout(new BorderLayout());
        jPanel25.setLayout(new BorderLayout());
        jPanel25.add(bgPanel7, BorderLayout.CENTER);
        jPanel25.revalidate();
        jPanel25.repaint();

        BackgroundPanel bgPanel8 = new BackgroundPanel("/assets/background.jpg");
        bgPanel8.setLayout(new BorderLayout());
        jPanel31.setLayout(new BorderLayout());
        jPanel31.add(bgPanel8, BorderLayout.CENTER);
        jPanel31.revalidate();
        jPanel31.repaint();

        BackgroundPanel bgPanel9 = new BackgroundPanel("/assets/background.jpg");
        bgPanel9.setLayout(new BorderLayout());
        jPanel23.setLayout(new BorderLayout());
        jPanel23.add(bgPanel9, BorderLayout.CENTER);
        jPanel23.revalidate();
        jPanel23.repaint();

        BackgroundPanel bgPanel10 = new BackgroundPanel("/assets/background.jpg");
        bgPanel10.setLayout(new BorderLayout());
        jPanel19.setLayout(new BorderLayout());
        jPanel19.add(bgPanel10, BorderLayout.CENTER);
        jPanel19.revalidate();
        jPanel19.repaint();

    }

    public boolean isCheckStudent(int studentId) {
        // First Name
        System.out.println(studentId);
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

        if (student.isNameExist(studentId, firstName, middleName, lastName)) {
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
        if (student.isLRNExist(studentId, stuLRN.getText())) {
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

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int a = JOptionPane.showConfirmDialog(this, "Do you want to Logout now?", "Select", JOptionPane.YES_NO_OPTION);
        if (a == 0) {
            this.dispose();
            LoginFrame frame = new LoginFrame();
            frame.setVisible(true);
            frame.setLocationRelativeTo(null);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

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

    private void addNewBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNewBtActionPerformed
        int id = student.getMax();
        String username = stuLRN.getText();
        int userId = user.getMax();
        if (isCheckStudent(id)) {
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

    private void stuFatherNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stuFatherNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_stuFatherNameActionPerformed

    private void stuAddress2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stuAddress2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_stuAddress2ActionPerformed

    private void stuMotherNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stuMotherNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_stuMotherNameActionPerformed

    private void clearFormBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearFormBtActionPerformed
        clearformGradeManage();
    }//GEN-LAST:event_clearFormBtActionPerformed

    private void stuFormGradePrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stuFormGradePrintActionPerformed
        String studentId = stuGradeIDManage.getText().trim();

        if (studentId.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter/select a student first.", "No Student", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            // === Let user pick save location ===
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Save Form 137 PDF");
            fileChooser.setSelectedFile(new File("Form137_" + studentId + ".pdf"));

            int userSelection = fileChooser.showSaveDialog(this);
            if (userSelection != JFileChooser.APPROVE_OPTION) {
                return; // cancelled
            }

            File fileToSave = fileChooser.getSelectedFile();
            String fileName = fileToSave.getAbsolutePath();

            // === Create PDF ===
            Document document = new Document();
            PdfWriter.getInstance(document, new java.io.FileOutputStream(fileName));
            document.open();

            // === Add Logo ===
            InputStream is = getClass().getResourceAsStream("/assets/logo_remBac.png");
            if (is != null) {
                com.itextpdf.text.Image logo = com.itextpdf.text.Image.getInstance(IOUtils.toByteArray(is));
                logo.scaleAbsolute(80, 80);
                logo.setAlignment(com.itextpdf.text.Image.ALIGN_CENTER);
                document.add(logo);
            } else {
                System.out.println("Logo not found!");
            }

            // === Title ===
            document.add(new Paragraph("FORM 137 - CDONHS-SHS"));
            document.add(new Paragraph("Student ID: " + studentId));
            document.add(new Paragraph(" ")); // empty line

            // === Create table with same columns as JTable ===
            PdfPTable pdfTable = new PdfPTable(formTable.getColumnCount());
            pdfTable.setWidthPercentage(100);

            // Add column headers
            for (int i = 0; i < formTable.getColumnCount(); i++) {
                pdfTable.addCell(new PdfPCell(new Paragraph(formTable.getColumnName(i))));
            }

            // Add row data
            for (int row = 0; row < formTable.getRowCount(); row++) {
                for (int col = 0; col < formTable.getColumnCount(); col++) {
                    Object value = formTable.getValueAt(row, col);
                    pdfTable.addCell(new PdfPCell(new Paragraph(value != null ? value.toString() : "")));
                }
            }

            document.add(pdfTable);
            document.close();

            JOptionPane.showMessageDialog(this, "Form 137 saved at: " + fileName);

        } catch (DocumentException | java.io.IOException e) {
            JOptionPane.showMessageDialog(this, "Error generating PDF: " + e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_stuFormGradePrintActionPerformed

    public static boolean isNumeric(String str) {
        if (str == null || str.trim().isEmpty()) {
            return false; // null or empty is not numeric
        }
        try {
            Double.parseDouble(str.trim()); // works for both int and double
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    private void jPanel3MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xx, y - xy);
    }//GEN-LAST:event_jPanel3MouseDragged

    private void jPanel3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MousePressed
        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_jPanel3MousePressed

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

    private void ClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearActionPerformed
        clearStudent();
    }//GEN-LAST:event_ClearActionPerformed

    private void stuPhoneKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_stuPhoneKeyTyped
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_stuPhoneKeyTyped

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

    private void updateBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtActionPerformed
        int id = Integer.parseInt(stuID.getText());
        if (isCheckStudent(id)) {
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

    public void updateSection() {
        Object gradeLevelObj = stuGradeLevel.getSelectedItem();
        Object strandObjItem = stuStrand.getSelectedItem();

        if (gradeLevelObj != null && strandObjItem != null) {
            try {
                String gradeLevelStr;
                if (gradeLevelObj instanceof ComboItem) {
                    gradeLevelStr = ((ComboItem) gradeLevelObj).toString();
                } else {
                    gradeLevelStr = gradeLevelObj.toString();
                }
                String strandName;
                if (strandObjItem instanceof ComboItem) {
                    strandName = ((ComboItem) strandObjItem).toString();
                } else {
                    strandName = strandObjItem.toString();
                }

                int gradeLevel = Integer.parseInt(gradeLevelStr);
                Strand strandObj = new Strand();
                String sectionName = strandObj.getNextSection(gradeLevel, strandName);

                stuSection.removeAllItems();
                if (sectionName != null && !sectionName.isEmpty()) {
                    stuSection.addItem(sectionName);
                    stuSection.setSelectedItem(sectionName);
                } else {
                    JOptionPane.showMessageDialog(null,
                            "No section found for Grade " + gradeLevel + " - " + strandName);
                }

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Invalid grade level format.");
                ex.printStackTrace();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error updating section: " + ex.getMessage());
                ex.printStackTrace();
            }
        } else {
            //JOptionPane.showMessageDialog(null, "Please select both Grade Level and Strand first.");
        }
    }
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

    private void stuGenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stuGenderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_stuGenderActionPerformed

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

    private void stuPrint_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stuPrint_1ActionPerformed
        try {
            MessageFormat header = new MessageFormat("Students Information");
            MessageFormat footer = new MessageFormat("Page{0,number,integer}");
            StudentTable.print(JTable.PrintMode.FIT_WIDTH, header, footer);
        } catch (PrinterException ex) {
            System.getLogger(Home.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }//GEN-LAST:event_stuPrint_1ActionPerformed

    private void stuStrandClearBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stuStrandClearBtActionPerformed
        clearStrand();
    }//GEN-LAST:event_stuStrandClearBtActionPerformed

    private void stuStrandSearchFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_stuStrandSearchFieldKeyTyped
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_stuStrandSearchFieldKeyTyped

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
    private int getColumnIndex(DefaultTableModel model, String columnName) {
        for (int i = 0; i < model.getColumnCount(); i++) {
            if (model.getColumnName(i).equalsIgnoreCase(columnName)) {
                return i;
            }
        }
        throw new IllegalArgumentException("Column '" + columnName + "' not found in table model.");
    }

    private void stuStrandSearchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stuStrandSearchFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_stuStrandSearchFieldActionPerformed


    private void stuGradeFormSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stuGradeFormSearchActionPerformed
        String studentIdStr = stuFullNameFormGrade.getText().trim();

//        if (studentIdStr.isEmpty()) {
//            JOptionPane.showMessageDialog(this, "Please enter Student ID.");
//            return;
//        }
        if (strandStudentBox.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(this, "Select GradeLevel to Activate the Strand");
            return;
        }

        try {
            int studentId = Integer.parseInt(stuGradeIDManage.getText().trim());
            String fullName = strand.getStudentNameById(studentId);
            stuFullNameFormGrade.setText(fullName);

            String gradeLevelStr = gradeLevelStudentBox.getSelectedItem().toString();
            int gradeLevel = Integer.parseInt(gradeLevelStr.split(" - ")[0]);

            int strandId = getSelectedFormStrandId();

            System.out.println("HERE MISTAKE" + strandId);

            DefaultTableModel model = grade.getStudentFormGrades(studentId, gradeLevel, strandId);

            formTable.setModel(model);

            if (model.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "No grades found for this student.");
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error fetching student grades: " + e.getMessage());
        }

    }//GEN-LAST:event_stuGradeFormSearchActionPerformed

    private void stuGradeManageRefreshTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stuGradeManageRefreshTableActionPerformed
        try {
            // Get the selected student ID and grade level from your UI components
            int studentId = Integer.parseInt(stuGradeIDManage.getText().trim());
            int gradeLevel = Integer.parseInt(gradeLevelStudentBox.getSelectedItem().toString());

            // Call your method to get the updated table model
            //DefaultTableModel model = grade.getStudentFormGrades(studentId, gradeLevel);
            // Set the new model to your table (formTable)
            formTable.setModel(model);

            // Optional: Resize columns for better display
            formTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Failed to refresh table. Please check inputs.");
        }
    }//GEN-LAST:event_stuGradeManageRefreshTableActionPerformed

    private void stuBirthCerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stuBirthCerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_stuBirthCerActionPerformed

    private void stuSort_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stuSort_1ActionPerformed
        DefaultTableModel model = (DefaultTableModel) StudentTable.getModel();

        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        StudentTable.setRowSorter(sorter);

        List<RowSorter.SortKey> sortKeys = new ArrayList<>();

        int studentLastNameCol = 4; 

        sortKeys.add(new RowSorter.SortKey(studentLastNameCol, SortOrder.ASCENDING));

        sorter.setSortKeys(sortKeys);
        sorter.sort();
    }//GEN-LAST:event_stuSort_1ActionPerformed

    private void stuSort_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stuSort_2ActionPerformed
        DefaultTableModel model = (DefaultTableModel) StudentTrackTable.getModel();

 
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        StudentTrackTable.setRowSorter(sorter);

        List<RowSorter.SortKey> sortKeys = new ArrayList<>();

        int studentNameCol = 1; // Student Name is column 1


        sortKeys.add(new RowSorter.SortKey(studentNameCol, SortOrder.ASCENDING));

        sorter.setSortKeys(sortKeys);
        sorter.sort();
    }//GEN-LAST:event_stuSort_2ActionPerformed

    private void stuLRNKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_stuLRNKeyTyped
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_stuLRNKeyTyped

    private void stuStrandIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stuStrandIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_stuStrandIdActionPerformed

    private void stuGradeManageSearchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stuGradeManageSearchButtonActionPerformed
        try {
            if (strandBox.getSelectedItem() == null && sectionBox.getSelectedItem() == null
                    && subjectBox.getSelectedItem() == null && quarterBox.getSelectedItem() == null) {
                JOptionPane.showMessageDialog(this, "Select GradeLevel to Activate the Strand, section, subject, and quarter");
                return;
            }

            // Get grade level safely
            String gradeLevelStr = gradeLevelBox.getSelectedItem().toString();
            int gradeLevel = Integer.parseInt(gradeLevelStr.split(" - ")[0]);

            // Get strand id
            int strandId = getSelectedStrandId();

            // Get section id
            int sectionId = grade.getSelectedSectionId(sectionBox);

            int subjectId = grade.getSelectedSubjectId(subjectBox);

            String quarterStr = quarterBox.getSelectedItem().toString();
            int quarter = Integer.parseInt(quarterStr.split(" - ")[0]);

            System.out.println(gradeLevel);
            System.out.println(strandId);
            System.out.println(sectionId);

            // Call the query
            DefaultTableModel model = grade.getStudentGrades(
                    gradeLevel, strandId, sectionId, subjectId, quarter
            );

            // Apply to JTable
            GradeSectioningManageTable.setModel(model);

            // If no rows were returned
            if (model.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "No results found.");
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error fetching grades: " + e.getMessage());
        }
    }//GEN-LAST:event_stuGradeManageSearchButtonActionPerformed

    private void gradeSaveBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gradeSaveBtActionPerformed
        // checking if they already selected
        if (subjectBox.getSelectedIndex() == -1 && sectionBox.getSelectedIndex() == -1 && strandBox.getSelectedIndex() == -1
                && quarterBox.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(this, "Please select a grade level once to show subject, section, and strand \n before saving.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int subjectId = grade.getSelectedSubjectId(subjectBox);   // pass the subject JComboBox
        int sectionId = grade.getSelectedSectionId(sectionBox);   // pass the section JComboBox
        int strandId = getSelectedStrandId();              // uses strandBox internally
        int quarter = Integer.parseInt(quarterBox.getSelectedItem().toString()); // assuming quarterBox has quarter numbers
        DefaultTableModel model = (DefaultTableModel) GradeSectioningManageTable.getModel(); // your JTable containing the grades

        grade.saveStudentGrades(subjectId, sectionId, quarter, model);
    }//GEN-LAST:event_gradeSaveBtActionPerformed

    private void gradeLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gradeLogoutActionPerformed
        int a = JOptionPane.showConfirmDialog(this, "Do you want to Logout now?", "Select", JOptionPane.YES_NO_OPTION);
        if (a == 0) {
            this.dispose();
            LoginFrame frame = new LoginFrame();
            frame.setVisible(true);
            frame.setLocationRelativeTo(null);
        }
    }//GEN-LAST:event_gradeLogoutActionPerformed

    private void strandBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_strandBoxActionPerformed
        // When strand changes, update sections, subjects, and quarters
        try {
            int gradeLevel = Integer.parseInt(gradeLevelBox.getSelectedItem().toString());
            int strandId = getSelectedStrandId(); // helper to parse "1 - STEM"

            // Update dependent dropdowns
            grade.loadSections(sectionBox, strandId, gradeLevel);
            grade.loadSubjects(subjectBox, strandId, gradeLevel);
            loadQuarters(quarterBox);

        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error loading sections/subjects.");
        }
    }//GEN-LAST:event_strandBoxActionPerformed

    public int getSelectedStudentProgressStrandId() {
        ComboItem selectedItem = (ComboItem) strandGradeProgressBox.getSelectedItem();
        if (selectedItem != null) {
            return selectedItem.getId(); // assuming ComboItem has getId()
        }
        return -1; // or handle appropriately if nothing is selected
    }

    public int getSelectedClassStrandId() {
        ComboItem selectedItem = (ComboItem) strandClassBox.getSelectedItem();
        if (selectedItem != null) {
            return selectedItem.getId(); // assuming ComboItem has getId()
        }
        return -1; // or handle appropriately if nothing is selected
    }

    public int getSelectedStrandId() {
        ComboItem selectedItem = (ComboItem) strandBox.getSelectedItem();
        if (selectedItem != null) {
            return selectedItem.getId(); // assuming ComboItem has getId()
        }
        return -1; // or handle appropriately if nothing is selected
    }

    public int getSelectedFormStrandId() {
        ComboItem selectedItem = (ComboItem) strandStudentBox.getSelectedItem();
        if (selectedItem != null) {
            return selectedItem.getId(); // assuming ComboItem has getId()
        }
        return -1; // or handle appropriately if nothing is selected
    }

    public int getSelectedStudentStrandId() {
        ComboItem selectedItem = (ComboItem) stuStrand.getSelectedItem();
        if (selectedItem != null) {
            return selectedItem.getId(); // assuming ComboItem has getId()
        }
        return -1; // or handle appropriately if nothing is selected
    }

    public int getSelectedHonorStrandId() {
        ComboItem selectedItem = (ComboItem) strandHonorBox.getSelectedItem();
        if (selectedItem != null) {
            return selectedItem.getId(); // assuming ComboItem has getId()
        }
        return -1; // or handle appropriately if nothing is selected
    }

    public void loadQuarters(JComboBox<String> quarterBox) {
        quarterBox.removeAllItems();
        quarterBox.addItem("1");
        quarterBox.addItem("2");
        quarterBox.addItem("3");
        quarterBox.addItem("4");
    }

    private void loadHonorQuarters(JComboBox<String> quarterBox) {
        quarterBox.removeAllItems();
        quarterBox.addItem("1");
        quarterBox.addItem("2");
        quarterBox.addItem("3");
        quarterBox.addItem("4");
        quarterBox.addItem("General Average");
    }

    private void gradeLevelBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gradeLevelBoxActionPerformed
        try {
            int gradeLevel = Integer.parseInt(gradeLevelBox.getSelectedItem().toString());

            // 1. Load strands available for that grade level
            grade.loadStrands(strandBox, gradeLevel);

            if (strandBox.getItemCount() > 0) {
                int strandId = getSelectedStrandId();

                grade.loadSections(sectionBox, strandId, gradeLevel);
                grade.loadSubjects(subjectBox, strandId, gradeLevel);
                loadQuarters(quarterBox);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error loading strands/sections/subjects.");
        }
    }//GEN-LAST:event_gradeLevelBoxActionPerformed

    private void gradeClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gradeClearActionPerformed
        clearGradeManage();
    }//GEN-LAST:event_gradeClearActionPerformed

    private void gradeSortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gradeSortActionPerformed
        DefaultTableModel model = (DefaultTableModel) GradeSectioningManageTable.getModel();

        // Create a TableRowSorter for your model
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        GradeSectioningManageTable.setRowSorter(sorter);

        // Specify sort key: Student Name column (1), ascending
        List<RowSorter.SortKey> sortKeys = new ArrayList<>();
        sortKeys.add(new RowSorter.SortKey(1, SortOrder.ASCENDING));

        sorter.setSortKeys(sortKeys);
        sorter.sort();
    }//GEN-LAST:event_gradeSortActionPerformed

    private void gradeLevelStudentBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gradeLevelStudentBoxActionPerformed
        String idText = stuGradeIDManage.getText().trim();
        if (idText.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter a Student ID.");
            return;
        }

        try {
            int studentId = Integer.parseInt(idText);

            // Clear previous items
            strandStudentBox.removeAllItems();

            // Load strands using the new method
            grade.getloadStudentStrands(strandStudentBox, studentId);

            if (strandBox.getItemCount() > 0) {
                int strandId = getSelectedFormStrandId();

            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid Student ID.");
        }
    }//GEN-LAST:event_gradeLevelStudentBoxActionPerformed

    private void subjectBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subjectBoxActionPerformed
        //updatesComboBox();
    }//GEN-LAST:event_subjectBoxActionPerformed

    private void sectionBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sectionBoxActionPerformed

    }//GEN-LAST:event_sectionBoxActionPerformed

    private void quarterBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quarterBoxActionPerformed
        //updatesComboBox();
    }//GEN-LAST:event_quarterBoxActionPerformed

    private void logoutFormGradeBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutFormGradeBtActionPerformed
        //LOGOUT
        int a = JOptionPane.showConfirmDialog(this, "Do you want to Logout now?", "Select", JOptionPane.YES_NO_OPTION);
        if (a == 0) {
            this.dispose();
            LoginFrame frame = new LoginFrame();
            frame.setVisible(true);
            frame.setLocationRelativeTo(null);
        }
    }//GEN-LAST:event_logoutFormGradeBtActionPerformed

    private void gradeSectioningPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gradeSectioningPrintActionPerformed
        try {
            // ✅ Check if table exists
            if (GradeSectioningManageTable == null) {
                JOptionPane.showMessageDialog(this,
                        "The Grade Sectioning table is missing or not initialized!",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            // ✅ Check if table has data
            DefaultTableModel model = (DefaultTableModel) GradeSectioningManageTable.getModel();
            if (model.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this,
                        "No data to print in Grade Sectioning table!",
                        "Empty Table",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }

            // === Get selections safely ===
            Integer subjectId = null;
            Integer sectionId = null;
            Integer strandId = null;
            Integer quarter = null;

            try {
                subjectId = grade.getSelectedSubjectId(subjectBox);
                sectionId = grade.getSelectedSectionId(sectionBox);
                strandId = getSelectedStrandId();
                quarter = Integer.parseInt(quarterBox.getSelectedItem().toString());
            } catch (NullPointerException | NumberFormatException ex) {
                JOptionPane.showMessageDialog(this,
                        "Please select all required fields (Subject, Section, Strand, Quarter).",
                        "Missing Fields",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }

            // === Ask user where to save the PDF ===
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Save Grade Sectioning PDF");
            fileChooser.setSelectedFile(new File("GradeSectioning.pdf"));
            int userSelection = fileChooser.showSaveDialog(this);
            if (userSelection != JFileChooser.APPROVE_OPTION) {
                return;
            }

            File pdfFile = fileChooser.getSelectedFile();

            // === Create PDF document ===
            Document document = new Document(PageSize.A4);
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(pdfFile));

            writer.setPageEvent(new PageNumberEvent());

            document.open();

            // === Add Logo ===
            InputStream is = getClass().getResourceAsStream("/assets/logo_remBac.png");
            if (is != null) {
                com.itextpdf.text.Image logo = com.itextpdf.text.Image.getInstance(IOUtils.toByteArray(is));
                logo.scaleAbsolute(80, 80);
                logo.setAlignment(com.itextpdf.text.Image.ALIGN_CENTER);
                document.add(logo);
            } else {
                System.out.println("Logo not found!");
            }

            // === Add Header ===
            Paragraph title = new Paragraph("Grade Sectioning",
                    FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18));
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);

            String headerText = String.format(
                    "Strand: %s | Grade Level: %s | Section: %s | Subject: %s | Quarter: %d",
                    getSelectedStrandName(), // your method
                    getSelectedGradeLevel(), // your method
                    getSelectedSectionName(), // your method
                    getSelectedSubjectName(), // your method
                    quarter
            );
            Paragraph sub = new Paragraph(headerText,
                    FontFactory.getFont(FontFactory.HELVETICA, 12));
            sub.setAlignment(Element.ALIGN_CENTER);
            sub.setSpacingAfter(20);
            document.add(sub);

            // === Create table with 3 columns: Student ID, Full Name, Grade ===
            PdfPTable pdfTable = new PdfPTable(3);
            pdfTable.setWidthPercentage(100);

            // Headers
            pdfTable.addCell(new PdfPCell(new Phrase("LRN"))); // changed Student ID → LRN if needed
            pdfTable.addCell(new PdfPCell(new Phrase("Full Name")));
            pdfTable.addCell(new PdfPCell(new Phrase("Grade")));

            // Rows
            for (int i = 0; i < model.getRowCount(); i++) {
                pdfTable.addCell(model.getValueAt(i, 0).toString());
                pdfTable.addCell(model.getValueAt(i, 1).toString());
                pdfTable.addCell(model.getValueAt(i, 2).toString());
            }

            document.add(pdfTable);
            document.close();

            JOptionPane.showMessageDialog(this,
                    "PDF Generated Successfully: " + pdfFile.getAbsolutePath());

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this,
                    "Error generating PDF: " + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_gradeSectioningPrintActionPerformed

    private void stuGradeHonorSearchBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stuGradeHonorSearchBtActionPerformed
        try {
            if (strandHonorBox.getSelectedItem() == null && sectionHonorBox.getSelectedItem() == null
                    && quarterHonorBox.getSelectedItem() == null) {
                JOptionPane.showMessageDialog(this, "Select GradeLevel to Activate the Strand, section, and quarter");
                return;
            }
            String gradeLevelStr = gradeLevelHonorBox.getSelectedItem().toString();
            int gradeLevel = Integer.parseInt(gradeLevelStr.split(" - ")[0]);
            int strandId = getSelectedHonorStrandId();

            // 3. Get Section Id
            int sectionId = grade.getSelectedSectionId(sectionHonorBox);

            // 4. Get Quarter selection (string)
            String quarterSelection = "General Average"; // default
            if (quarterHonorBox.getSelectedItem() != null) {
                quarterSelection = quarterHonorBox.getSelectedItem().toString();
            }
            String schoolYear = getCurrentSchoolYear();

            // 5. Call the averages query
            // Pass subjectId = 0 to compute across all subjects
            DefaultTableModel model = listOfHonor.getStudentGrades(
                    gradeLevel, strandId, sectionId, 0, quarterSelection, schoolYear
            );

            // 6. Apply results to the ListHonorTable
            ListHonorTable.setModel(model);

            // 7. Handle empty case
            if (model.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "No honor list results found.");
            } else {
                JOptionPane.showMessageDialog(this, "Honor list generated successfully!");
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error fetching honor list: " + e.getMessage());
        }
    }//GEN-LAST:event_stuGradeHonorSearchBtActionPerformed

    private void gradeLevelHonorBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gradeLevelHonorBoxActionPerformed
        try {
            int gradeLevel = Integer.parseInt(gradeLevelHonorBox.getSelectedItem().toString());

            // 1. Load strands available for that grade level
            grade.loadStrands(strandHonorBox, gradeLevel);

            if (strandHonorBox.getItemCount() > 0) {
                int strandId = getSelectedHonorStrandId();

                grade.loadSections(sectionHonorBox, strandId, gradeLevel);
                loadHonorQuarters(quarterHonorBox);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error loading strands/sections/subjects.");
        }
    }//GEN-LAST:event_gradeLevelHonorBoxActionPerformed

    private void quarterHonorBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quarterHonorBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_quarterHonorBoxActionPerformed

    private void strandHonorBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_strandHonorBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_strandHonorBoxActionPerformed

    private void sectionHonorBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sectionHonorBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sectionHonorBoxActionPerformed

    private void gradeHonorLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gradeHonorLogoutActionPerformed
        //LOGOUT
        int a = JOptionPane.showConfirmDialog(this, "Do you want to Logout now?", "Select", JOptionPane.YES_NO_OPTION);
        if (a == 0) {
            this.dispose();
            LoginFrame frame = new LoginFrame();
            frame.setVisible(true);
            frame.setLocationRelativeTo(null);
        }
    }//GEN-LAST:event_gradeHonorLogoutActionPerformed

    private void gradeHonorClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gradeHonorClearActionPerformed
        clearListGrade();
    }//GEN-LAST:event_gradeHonorClearActionPerformed

    private void gradeHonorSectioningPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gradeHonorSectioningPrintActionPerformed
        try {
            // === Check if table has data ===
            if (ListHonorTable.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this,
                        "No data available in the Honor Sectioning table.",
                        "Empty Table",
                        JOptionPane.WARNING_MESSAGE);
                return; // stop execution
            }
            String section, gradeLevel, strand, quarter;

            try {
                // === Section Information (from comboboxes) ===
                section = sectionHonorBox.getSelectedItem() != null ? sectionHonorBox.getSelectedItem().toString() : "N/A";
                gradeLevel = gradeLevelHonorBox.getSelectedItem() != null ? gradeLevelHonorBox.getSelectedItem().toString() : "N/A";
                strand = strandHonorBox.getSelectedItem() != null ? strandHonorBox.getSelectedItem().toString() : "N/A";
                quarter = quarterHonorBox.getSelectedItem().toString();

            } catch (NullPointerException | NumberFormatException ex) {
                JOptionPane.showMessageDialog(this,
                        "Please select all required fields (Grade Level, Section, Strand).",
                        "Missing Fields",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }

            // === Let user pick save location ===
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Save Honor Sectioning PDF");
            fileChooser.setSelectedFile(new File("HonorSectioning" + gradeLevel + "_"
                    + strand + "_Sec" + section + ".pdf"));

            int userSelection = fileChooser.showSaveDialog(this);
            if (userSelection != JFileChooser.APPROVE_OPTION) {
                return; // cancelled
            }

            File fileToSave = fileChooser.getSelectedFile();
            String fileName = fileToSave.getAbsolutePath();

            // === Create PDF ===
            Document document = new Document();
            PdfWriter writer = PdfWriter.getInstance(document, new java.io.FileOutputStream(fileName));

            // ✅ Attach page event for numbering
            writer.setPageEvent(new PageNumberEvent());

            document.open();

            // === Add Logo ===
            InputStream is = getClass().getResourceAsStream("/assets/logo_remBac.png");
            if (is != null) {
                com.itextpdf.text.Image logo = com.itextpdf.text.Image.getInstance(IOUtils.toByteArray(is));
                logo.scaleAbsolute(80, 80);
                logo.setAlignment(com.itextpdf.text.Image.ALIGN_CENTER);
                document.add(logo);
            } else {
                System.out.println("Logo not found!");
            }

            // === Title ===
            Paragraph title = new Paragraph("HONOR LIST",
                    FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14));
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);
            document.add(new Paragraph(" ")); // empty line

            Paragraph sub = new Paragraph(
                    "Grade " + gradeLevel
                    + " | Strand: " + strand
                    + " | Section: " + section + " | quarter: " + quarter,
                    FontFactory.getFont(FontFactory.HELVETICA, 12)
            );
            sub.setAlignment(Element.ALIGN_CENTER);
            sub.setSpacingAfter(20);
            document.add(sub);

            // === Create table with same columns as JTable ===
            PdfPTable pdfTable = new PdfPTable(ListHonorTable.getColumnCount());
            pdfTable.setWidthPercentage(100);

            // Add column headers
            for (int i = 0; i < ListHonorTable.getColumnCount(); i++) {
                pdfTable.addCell(new PdfPCell(new Paragraph(ListHonorTable.getColumnName(i))));
            }

            // Add row data
            for (int row = 0; row < ListHonorTable.getRowCount(); row++) {
                for (int col = 0; col < ListHonorTable.getColumnCount(); col++) {
                    Object value = ListHonorTable.getValueAt(row, col);
                    pdfTable.addCell(new PdfPCell(new Paragraph(value != null ? value.toString() : "")));
                }
            }

            document.add(pdfTable);
            document.close();

            JOptionPane.showMessageDialog(this, "Honor Sectioning saved at: " + fileName);

        } catch (DocumentException | java.io.IOException e) {
            JOptionPane.showMessageDialog(this, "Error generating PDF: " + e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_gradeHonorSectioningPrintActionPerformed

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

            // ✅ Get Grade Level from ComboBox
            String gradeLevelStr = gradeLevelSubjectBox.getSelectedItem().toString();
            int gradeLevel = Integer.parseInt(gradeLevelStr.split(" - ")[0]);

            // ✅ Clear previous data
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

    private void gradeLevelSubjectBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gradeLevelSubjectBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_gradeLevelSubjectBoxActionPerformed

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

            System.out.println("****************");
            System.out.println("HERE MISTAKE");
            System.out.println(gradeLevel);
            System.out.println(strandId);
            System.out.println(sectionId);
            System.out.println("****************");

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
            int gradeLevel = Integer.parseInt(gradeLevelBox.getSelectedItem().toString());
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

    private void classListClearBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_classListClearBtActionPerformed
        clearClassListManage();
    }//GEN-LAST:event_classListClearBtActionPerformed

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

    private void stuSubjectIDManageKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_stuSubjectIDManageKeyTyped
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_stuSubjectIDManageKeyTyped

    private void stuGradeIDManageKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_stuGradeIDManageKeyTyped
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_stuGradeIDManageKeyTyped

    private void stuGradeIDManageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stuGradeIDManageActionPerformed
        String idText = stuGradeIDManage.getText().trim();
        if (idText.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter a Student ID.");
            return;
        }

        try {
            int studentId = Integer.parseInt(idText);

            // Clear previous items
            strandStudentBox.removeAllItems();

            // Load strands using the new method
            grade.getloadStudentStrands(strandStudentBox, studentId);

            if (strandBox.getItemCount() > 0) {
                int strandId = getSelectedFormStrandId();

            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid Student ID.");
        }
    }//GEN-LAST:event_stuGradeIDManageActionPerformed

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

    private void imagePanel3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imagePanel3MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_imagePanel3MousePressed

    private void imagePanel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imagePanel3MouseClicked

    }//GEN-LAST:event_imagePanel3MouseClicked

    private void addNewBtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addNewBtMouseEntered

        addNewBt.setBackground(ThemeColors.DEEP_ORANGE);
    }//GEN-LAST:event_addNewBtMouseEntered

    private void addNewBtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addNewBtMouseExited
        addNewBt.setBackground(ThemeColors.GOLDEN_YELLOW);
    }//GEN-LAST:event_addNewBtMouseExited

    private void updateBtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateBtMouseEntered
        updateBt.setBackground(ThemeColors.DEEP_ORANGE);
    }//GEN-LAST:event_updateBtMouseEntered

    private void updateBtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateBtMouseExited
        updateBt.setBackground(ThemeColors.GOLDEN_YELLOW);
    }//GEN-LAST:event_updateBtMouseExited

    private void ClearMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ClearMouseEntered
        Clear.setBackground(ThemeColors.DEEP_ORANGE);
    }//GEN-LAST:event_ClearMouseEntered

    private void ClearMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ClearMouseExited
        Clear.setBackground(ThemeColors.GOLDEN_YELLOW);
    }//GEN-LAST:event_ClearMouseExited

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked

    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseEntered

        jButton1.setBackground(ThemeColors.DEEP_ORANGE);
    }//GEN-LAST:event_jButton1MouseEntered

    private void jButton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseExited
        // TODO add your handling code here:
        jButton1.setBackground(ThemeColors.GOLDEN_YELLOW);
    }//GEN-LAST:event_jButton1MouseExited

    private void stuPrint_1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stuPrint_1MouseEntered
        stuPrint_1.setBackground(ThemeColors.DEEP_ORANGE);
    }//GEN-LAST:event_stuPrint_1MouseEntered

    private void stuPrint_1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stuPrint_1MouseExited
        stuPrint_1.setBackground(ThemeColors.GOLDEN_YELLOW);
    }//GEN-LAST:event_stuPrint_1MouseExited

    private void delBtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_delBtMouseEntered
        delBt.setBackground(ThemeColors.DEEP_ORANGE);
    }//GEN-LAST:event_delBtMouseEntered

    private void delBtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_delBtMouseExited
        delBt.setBackground(ThemeColors.GOLDEN_YELLOW);
    }//GEN-LAST:event_delBtMouseExited

    private void searchBt_1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchBt_1MouseEntered
        searchBt_1.setBackground(ThemeColors.DEEP_ORANGE);
    }//GEN-LAST:event_searchBt_1MouseEntered

    private void searchBt_1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchBt_1MouseExited
        searchBt_1.setBackground(ThemeColors.GOLDEN_YELLOW);
    }//GEN-LAST:event_searchBt_1MouseExited

    private void stuRefresh_1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stuRefresh_1MouseEntered
        stuRefresh_1.setBackground(ThemeColors.DEEP_ORANGE);
    }//GEN-LAST:event_stuRefresh_1MouseEntered

    private void stuRefresh_1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stuRefresh_1MouseExited
        stuRefresh_1.setBackground(ThemeColors.GOLDEN_YELLOW);
    }//GEN-LAST:event_stuRefresh_1MouseExited

    private void stuSort_1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stuSort_1MouseEntered
        stuSort_1.setBackground(ThemeColors.DEEP_ORANGE);
    }//GEN-LAST:event_stuSort_1MouseEntered

    private void stuSort_1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stuSort_1MouseExited
        stuSort_1.setBackground(ThemeColors.GOLDEN_YELLOW);
    }//GEN-LAST:event_stuSort_1MouseExited

    private void stuStrandSearchBtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stuStrandSearchBtMouseEntered
        stuStrandSearchBt.setBackground(ThemeColors.DEEP_ORANGE);
    }//GEN-LAST:event_stuStrandSearchBtMouseEntered

    private void calculatorBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calculatorBtActionPerformed
        Calculator calculator = new Calculator();
        calculator.setVisible(true);
        calculator.setLocationRelativeTo(this);
    }//GEN-LAST:event_calculatorBtActionPerformed

    private void stuStudentProgressSearchBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stuStudentProgressSearchBoxActionPerformed
        if (strandGradeProgressBox.getSelectedItem() == null
                && sectionStudentProgressBox.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(this, "Select GradeLevel to Activate the Strand, and section");
            return;
        }

        String gradeLevelStr = gradeLevelStudentProgressBox.getSelectedItem().toString();
        int gradeLevel = Integer.parseInt(gradeLevelStr.split(" - ")[0]);

        // Get strand id
        int strandId = getSelectedStudentProgressStrandId();

        // Get section id
        int sectionId = grade.getSelectedSectionId(sectionStudentProgressBox);

        progress.displayStudentProgress(ProgressTable, gradeLevel, strandId, sectionId);
    }//GEN-LAST:event_stuStudentProgressSearchBoxActionPerformed

    private void gradeLevelStudentProgressBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gradeLevelStudentProgressBoxActionPerformed
        try {
            int gradeLevel = Integer.parseInt(gradeLevelStudentProgressBox.getSelectedItem().toString());

            // 1. Load strands available for that grade level
            strand.loadStrands(strandGradeProgressBox, gradeLevel);

            if (strandGradeProgressBox.getItemCount() > 0) {
                int strandId = getSelectedStudentProgressStrandId();

                strand.loadSections(sectionStudentProgressBox, strandId, gradeLevel);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error loading strands/sections/subjects.");
        }
    }//GEN-LAST:event_gradeLevelStudentProgressBoxActionPerformed

    private void stuStudentProgressRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stuStudentProgressRefreshActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_stuStudentProgressRefreshActionPerformed

    private void clearStudentProgressBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearStudentProgressBtActionPerformed
        clearStudentProgress();
    }//GEN-LAST:event_clearStudentProgressBtActionPerformed

    private void logoutStudentProgressBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutStudentProgressBtActionPerformed
        //LOGOUT
        int a = JOptionPane.showConfirmDialog(this, "Do you want to Logout now?", "Select", JOptionPane.YES_NO_OPTION);
        if (a == 0) {
            this.dispose();
            LoginFrame frame = new LoginFrame();
            frame.setVisible(true);
            frame.setLocationRelativeTo(null);
        }
    }//GEN-LAST:event_logoutStudentProgressBtActionPerformed

    private void strandGradeProgressBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_strandGradeProgressBoxActionPerformed
        try {
            int gradeLevel = Integer.parseInt(gradeLevelStudentProgressBox.getSelectedItem().toString());
            int strandId = getSelectedStudentProgressStrandId(); // helper to parse "1 - STEM"

            // Update dependent dropdowns
            strand.loadSections(sectionStudentProgressBox, strandId, gradeLevel);

        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error loading sections/subjects.");
        }
    }//GEN-LAST:event_strandGradeProgressBoxActionPerformed

    private void sectionStudentProgressBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sectionStudentProgressBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sectionStudentProgressBoxActionPerformed

    private void printStudentProgressBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printStudentProgressBtActionPerformed
        try {
            if (strandGradeProgressBox.getSelectedItem() == null || sectionStudentProgressBox.getSelectedItem() == null) {
                JOptionPane.showMessageDialog(this,
                        "Please select a Grade Level, Strand, and Section.",
                        "Missing Field",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }

            // ✅ Get values safely
            String gradeLevelStr = gradeLevelStudentProgressBox.getSelectedItem().toString();
            int gradeLevel = Integer.parseInt(gradeLevelStr.split(" - ")[0]);
            int sectionId = strand.getSelectedSectionId(sectionStudentProgressBox);
            int strandId = getSelectedStudentProgressStrandId();

            // ✅ Fetch strand + section names using helper
            String[] names = strand.getStrandAndSectionName(con, sectionId);
            String strandName = names[0];
            String sectionName = names[1];

            // ✅ Debug check
            System.out.println("DEBUG: grade=" + gradeLevel
                    + ", strandId=" + strandId + " (" + strandName + ")"
                    + ", sectionId=" + sectionId + " (" + sectionName + ")");

            // ✅ Generate the class list with names
            progress.generateProgressList(ProgressTable, gradeLevel, strandId, sectionId, strandName, sectionName);

            //JOptionPane.showMessageDialog(this, "Class List PDF Generated Successfully!");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,
                    "An error occurred: " + ex.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }//GEN-LAST:event_printStudentProgressBtActionPerformed

    private void finalizeBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finalizeBtActionPerformed
        DefaultTableModel model = (DefaultTableModel) ProgressTable.getModel();

        if (model.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null,
                    "No student progress data found. Please generate or view the data first.",
                    "No Data", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // ✅ Proceed to confirm updates
        progress.confirmStudentProgress(ProgressTable);
    }//GEN-LAST:event_finalizeBtActionPerformed

    private void strandStudentBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_strandStudentBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_strandStudentBoxActionPerformed

    private void stuRestoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stuRestoreActionPerformed
        try {
            int studentId = Integer.parseInt(stuStrandId.getText());
            int gradeLevel = Integer.parseInt(stuGradeLevel.getSelectedItem().toString());
            String strandName = stuStrand.getSelectedItem().toString();
            String sectionSelect = stuSection.getSelectedItem().toString();

            int strandId = strand.getStrandIdByName(strandName);
            int sectionId = strand.getSectionIdByName(sectionSelect, gradeLevel, strandId);

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

    private void stuFullNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stuFullNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_stuFullNameActionPerformed

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

    private void stuFullNameSubKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_stuFullNameSubKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_stuFullNameSubKeyTyped

    private void stuFullNameFormGradeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stuFullNameFormGradeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_stuFullNameFormGradeActionPerformed

    private void stuFullNameFormGradeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_stuFullNameFormGradeKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_stuFullNameFormGradeKeyTyped

    private void stuStrandSearchBtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stuStrandSearchBtMouseExited
        stuStrandSearchBt.setBackground(ThemeColors.GOLDEN_YELLOW);
    }//GEN-LAST:event_stuStrandSearchBtMouseExited

    private void stuSearchBt_2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stuSearchBt_2MouseEntered
        stuSearchBt_2.setBackground(ThemeColors.DEEP_ORANGE);
    }//GEN-LAST:event_stuSearchBt_2MouseEntered

    private void stuSearchBt_2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stuSearchBt_2MouseExited
        stuSearchBt_2.setBackground(ThemeColors.GOLDEN_YELLOW);
    }//GEN-LAST:event_stuSearchBt_2MouseExited

    private void stuSort_2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stuSort_2MouseEntered
        stuSort_2.setBackground(ThemeColors.DEEP_ORANGE);
    }//GEN-LAST:event_stuSort_2MouseEntered

    private void stuSort_2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stuSort_2MouseExited
        stuSort_2.setBackground(ThemeColors.GOLDEN_YELLOW);
    }//GEN-LAST:event_stuSort_2MouseExited

    private void stuRefresh_2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stuRefresh_2MouseEntered
        stuRefresh_2.setBackground(ThemeColors.DEEP_ORANGE);
    }//GEN-LAST:event_stuRefresh_2MouseEntered

    private void stuRefresh_2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stuRefresh_2MouseExited
        stuRefresh_2.setBackground(ThemeColors.GOLDEN_YELLOW);
    }//GEN-LAST:event_stuRefresh_2MouseExited

    private void stuSaveBtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stuSaveBtMouseEntered
        stuSaveBt.setBackground(ThemeColors.DEEP_ORANGE);
    }//GEN-LAST:event_stuSaveBtMouseEntered

    private void stuSaveBtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stuSaveBtMouseExited
        stuSaveBt.setBackground(ThemeColors.GOLDEN_YELLOW);
    }//GEN-LAST:event_stuSaveBtMouseExited

    private void stuRestoreMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stuRestoreMouseEntered
        stuRestore.setBackground(ThemeColors.DEEP_ORANGE);
    }//GEN-LAST:event_stuRestoreMouseEntered

    private void stuRestoreMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stuRestoreMouseExited
        stuRestore.setBackground(ThemeColors.GOLDEN_YELLOW);
    }//GEN-LAST:event_stuRestoreMouseExited

    private void stuCurrentOrArchiveMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stuCurrentOrArchiveMouseEntered
        stuCurrentOrArchive.setBackground(ThemeColors.DEEP_ORANGE);
    }//GEN-LAST:event_stuCurrentOrArchiveMouseEntered

    private void stuCurrentOrArchiveMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stuCurrentOrArchiveMouseExited
        stuCurrentOrArchive.setBackground(ThemeColors.GOLDEN_YELLOW);
    }//GEN-LAST:event_stuCurrentOrArchiveMouseExited

    private void stuStrandClearBtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stuStrandClearBtMouseEntered
        stuStrandClearBt.setBackground(ThemeColors.DEEP_ORANGE);
    }//GEN-LAST:event_stuStrandClearBtMouseEntered

    private void stuStrandClearBtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stuStrandClearBtMouseExited
        stuStrandClearBt.setBackground(ThemeColors.GOLDEN_YELLOW);
    }//GEN-LAST:event_stuStrandClearBtMouseExited

    private void jButton2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseEntered
        jButton2.setBackground(ThemeColors.DEEP_ORANGE);
    }//GEN-LAST:event_jButton2MouseEntered

    private void jButton2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseExited
        jButton2.setBackground(ThemeColors.GOLDEN_YELLOW);
    }//GEN-LAST:event_jButton2MouseExited

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

    private void classListSearchBtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_classListSearchBtMouseEntered
        classListSearchBt.setBackground(ThemeColors.DEEP_ORANGE);
    }//GEN-LAST:event_classListSearchBtMouseEntered

    private void classListSearchBtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_classListSearchBtMouseExited
        classListSearchBt.setBackground(ThemeColors.GOLDEN_YELLOW);
    }//GEN-LAST:event_classListSearchBtMouseExited

    private void classListPrintBtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_classListPrintBtMouseEntered
        classListPrintBt.setBackground(ThemeColors.DEEP_ORANGE);
    }//GEN-LAST:event_classListPrintBtMouseEntered

    private void classListPrintBtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_classListPrintBtMouseExited
        classListPrintBt.setBackground(ThemeColors.GOLDEN_YELLOW);
    }//GEN-LAST:event_classListPrintBtMouseExited

    private void classListClearBtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_classListClearBtMouseEntered
        classListClearBt.setBackground(ThemeColors.DEEP_ORANGE);
    }//GEN-LAST:event_classListClearBtMouseEntered

    private void classListClearBtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_classListClearBtMouseExited
        classListClearBt.setBackground(ThemeColors.GOLDEN_YELLOW);
    }//GEN-LAST:event_classListClearBtMouseExited

    private void classListLogoutBtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_classListLogoutBtMouseEntered
        classListLogoutBt.setBackground(ThemeColors.DEEP_ORANGE);
    }//GEN-LAST:event_classListLogoutBtMouseEntered

    private void classListLogoutBtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_classListLogoutBtMouseExited
        classListLogoutBt.setBackground(ThemeColors.GOLDEN_YELLOW);
    }//GEN-LAST:event_classListLogoutBtMouseExited

    private void stuGradeManageSearchButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stuGradeManageSearchButtonMouseEntered
        stuGradeManageSearchButton.setBackground(ThemeColors.DEEP_ORANGE);
    }//GEN-LAST:event_stuGradeManageSearchButtonMouseEntered

    private void stuGradeManageSearchButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stuGradeManageSearchButtonMouseExited
        stuGradeManageSearchButton.setBackground(ThemeColors.GOLDEN_YELLOW);
    }//GEN-LAST:event_stuGradeManageSearchButtonMouseExited

    private void gradeSaveBtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gradeSaveBtMouseEntered
        gradeSaveBt.setBackground(ThemeColors.DEEP_ORANGE);
    }//GEN-LAST:event_gradeSaveBtMouseEntered

    private void gradeSaveBtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gradeSaveBtMouseExited
        gradeSaveBt.setBackground(ThemeColors.GOLDEN_YELLOW);
    }//GEN-LAST:event_gradeSaveBtMouseExited

    private void gradeSectioningPrintMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gradeSectioningPrintMouseEntered
        gradeSectioningPrint.setBackground(ThemeColors.DEEP_ORANGE);
    }//GEN-LAST:event_gradeSectioningPrintMouseEntered

    private void gradeSectioningPrintMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gradeSectioningPrintMouseExited
        gradeSectioningPrint.setBackground(ThemeColors.GOLDEN_YELLOW);
    }//GEN-LAST:event_gradeSectioningPrintMouseExited

    private void gradeClearMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gradeClearMouseEntered
        gradeClear.setBackground(ThemeColors.DEEP_ORANGE);
    }//GEN-LAST:event_gradeClearMouseEntered

    private void gradeClearMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gradeClearMouseExited
        gradeClear.setBackground(ThemeColors.GOLDEN_YELLOW);
    }//GEN-LAST:event_gradeClearMouseExited

    private void gradeSortMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gradeSortMouseEntered
        gradeSort.setBackground(ThemeColors.DEEP_ORANGE);
    }//GEN-LAST:event_gradeSortMouseEntered

    private void gradeSortMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gradeSortMouseExited
        gradeSort.setBackground(ThemeColors.GOLDEN_YELLOW);
    }//GEN-LAST:event_gradeSortMouseExited

    private void calculatorBtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_calculatorBtMouseEntered
        calculatorBt.setBackground(ThemeColors.DEEP_ORANGE);
    }//GEN-LAST:event_calculatorBtMouseEntered

    private void calculatorBtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_calculatorBtMouseExited
        calculatorBt.setBackground(ThemeColors.GOLDEN_YELLOW);
    }//GEN-LAST:event_calculatorBtMouseExited

    private void gradeLogoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gradeLogoutMouseEntered
        gradeLogout.setBackground(ThemeColors.DEEP_ORANGE);
    }//GEN-LAST:event_gradeLogoutMouseEntered

    private void gradeLogoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gradeLogoutMouseExited
        gradeLogout.setBackground(ThemeColors.GOLDEN_YELLOW);
    }//GEN-LAST:event_gradeLogoutMouseExited

    private void stuGradeFormSearchMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stuGradeFormSearchMouseEntered
        stuGradeFormSearch.setBackground(ThemeColors.DEEP_ORANGE);
    }//GEN-LAST:event_stuGradeFormSearchMouseEntered

    private void stuGradeFormSearchMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stuGradeFormSearchMouseExited
        stuGradeFormSearch.setBackground(ThemeColors.GOLDEN_YELLOW);
    }//GEN-LAST:event_stuGradeFormSearchMouseExited

    private void stuGradeManageRefreshTableMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stuGradeManageRefreshTableMouseEntered
        stuGradeManageRefreshTable.setBackground(ThemeColors.DEEP_ORANGE);
    }//GEN-LAST:event_stuGradeManageRefreshTableMouseEntered

    private void stuGradeManageRefreshTableMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stuGradeManageRefreshTableMouseExited
        stuGradeManageRefreshTable.setBackground(ThemeColors.GOLDEN_YELLOW);
    }//GEN-LAST:event_stuGradeManageRefreshTableMouseExited

    private void stuFormGradePrintMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stuFormGradePrintMouseEntered
        stuFormGradePrint.setBackground(ThemeColors.DEEP_ORANGE);
    }//GEN-LAST:event_stuFormGradePrintMouseEntered

    private void stuFormGradePrintMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stuFormGradePrintMouseExited
        stuFormGradePrint.setBackground(ThemeColors.GOLDEN_YELLOW);
    }//GEN-LAST:event_stuFormGradePrintMouseExited

    private void clearFormBtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearFormBtMouseEntered
        clearFormBt.setBackground(ThemeColors.DEEP_ORANGE);
    }//GEN-LAST:event_clearFormBtMouseEntered

    private void clearFormBtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearFormBtMouseExited
        clearFormBt.setBackground(ThemeColors.GOLDEN_YELLOW);
    }//GEN-LAST:event_clearFormBtMouseExited

    private void logoutFormGradeBtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutFormGradeBtMouseEntered
        logoutFormGradeBt.setBackground(ThemeColors.DEEP_ORANGE);
    }//GEN-LAST:event_logoutFormGradeBtMouseEntered

    private void logoutFormGradeBtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutFormGradeBtMouseExited
        logoutFormGradeBt.setBackground(ThemeColors.GOLDEN_YELLOW);
    }//GEN-LAST:event_logoutFormGradeBtMouseExited

    private void stuGradeHonorSearchBtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stuGradeHonorSearchBtMouseEntered
        stuGradeHonorSearchBt.setBackground(ThemeColors.DEEP_ORANGE);
    }//GEN-LAST:event_stuGradeHonorSearchBtMouseEntered

    private void stuGradeHonorSearchBtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stuGradeHonorSearchBtMouseExited
        stuGradeHonorSearchBt.setBackground(ThemeColors.GOLDEN_YELLOW);
    }//GEN-LAST:event_stuGradeHonorSearchBtMouseExited

    private void gradeHonorSectioningPrintMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gradeHonorSectioningPrintMouseEntered
        gradeHonorSectioningPrint.setBackground(ThemeColors.DEEP_ORANGE);
    }//GEN-LAST:event_gradeHonorSectioningPrintMouseEntered

    private void gradeHonorSectioningPrintMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gradeHonorSectioningPrintMouseExited
        gradeHonorSectioningPrint.setBackground(ThemeColors.GOLDEN_YELLOW);
    }//GEN-LAST:event_gradeHonorSectioningPrintMouseExited

    private void gradeHonorClearMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gradeHonorClearMouseEntered
        gradeHonorClear.setBackground(ThemeColors.DEEP_ORANGE);
    }//GEN-LAST:event_gradeHonorClearMouseEntered

    private void gradeHonorClearMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gradeHonorClearMouseExited
        gradeHonorClear.setBackground(ThemeColors.GOLDEN_YELLOW);
    }//GEN-LAST:event_gradeHonorClearMouseExited

    private void gradeHonorLogoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gradeHonorLogoutMouseEntered
        gradeHonorLogout.setBackground(ThemeColors.DEEP_ORANGE);
    }//GEN-LAST:event_gradeHonorLogoutMouseEntered

    private void gradeHonorLogoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gradeHonorLogoutMouseExited
        gradeHonorLogout.setBackground(ThemeColors.GOLDEN_YELLOW);
    }//GEN-LAST:event_gradeHonorLogoutMouseExited

    private void stuStudentProgressSearchBoxMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stuStudentProgressSearchBoxMouseEntered
        stuStudentProgressSearchBox.setBackground(ThemeColors.DEEP_ORANGE);
    }//GEN-LAST:event_stuStudentProgressSearchBoxMouseEntered

    private void stuStudentProgressSearchBoxMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stuStudentProgressSearchBoxMouseExited
        stuStudentProgressSearchBox.setBackground(ThemeColors.GOLDEN_YELLOW);
    }//GEN-LAST:event_stuStudentProgressSearchBoxMouseExited

    private void stuStudentProgressRefreshMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stuStudentProgressRefreshMouseEntered
        stuStudentProgressRefresh.setBackground(ThemeColors.DEEP_ORANGE);
    }//GEN-LAST:event_stuStudentProgressRefreshMouseEntered

    private void stuStudentProgressRefreshMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stuStudentProgressRefreshMouseExited
        stuStudentProgressRefresh.setBackground(ThemeColors.GOLDEN_YELLOW);
    }//GEN-LAST:event_stuStudentProgressRefreshMouseExited

    private void finalizeBtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_finalizeBtMouseEntered
        finalizeBt.setBackground(ThemeColors.DEEP_ORANGE);
    }//GEN-LAST:event_finalizeBtMouseEntered

    private void finalizeBtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_finalizeBtMouseExited
        finalizeBt.setBackground(ThemeColors.GOLDEN_YELLOW);
    }//GEN-LAST:event_finalizeBtMouseExited

    private void clearStudentProgressBtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearStudentProgressBtMouseEntered
        clearStudentProgressBt.setBackground(ThemeColors.DEEP_ORANGE);
    }//GEN-LAST:event_clearStudentProgressBtMouseEntered

    private void clearStudentProgressBtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearStudentProgressBtMouseExited
        clearStudentProgressBt.setBackground(ThemeColors.GOLDEN_YELLOW);
    }//GEN-LAST:event_clearStudentProgressBtMouseExited

    private void printStudentProgressBtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_printStudentProgressBtMouseEntered
        printStudentProgressBt.setBackground(ThemeColors.DEEP_ORANGE);
    }//GEN-LAST:event_printStudentProgressBtMouseEntered

    private void printStudentProgressBtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_printStudentProgressBtMouseExited
        printStudentProgressBt.setBackground(ThemeColors.GOLDEN_YELLOW);
    }//GEN-LAST:event_printStudentProgressBtMouseExited

    private void logoutStudentProgressBtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutStudentProgressBtMouseEntered
        logoutStudentProgressBt.setBackground(ThemeColors.DEEP_ORANGE);
    }//GEN-LAST:event_logoutStudentProgressBtMouseEntered

    private void logoutStudentProgressBtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutStudentProgressBtMouseExited
        logoutStudentProgressBt.setBackground(ThemeColors.GOLDEN_YELLOW);
    }//GEN-LAST:event_logoutStudentProgressBtMouseExited

    private void logStuBtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logStuBtMouseEntered
        logStuBt.setBackground(ThemeColors.DEEP_ORANGE);
    }//GEN-LAST:event_logStuBtMouseEntered

    private void logStuBtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logStuBtMouseExited
        logStuBt.setBackground(ThemeColors.GOLDEN_YELLOW);
    }//GEN-LAST:event_logStuBtMouseExited

    private void browseImgMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_browseImgMouseEntered
        browseImg.setBackground(ThemeColors.DEEP_ORANGE);
    }//GEN-LAST:event_browseImgMouseEntered

    private void browseImgMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_browseImgMouseExited
        browseImg.setBackground(ThemeColors.GOLDEN_YELLOW);
    }//GEN-LAST:event_browseImgMouseExited

    private void stuFnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stuFnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_stuFnameActionPerformed

    private void stuFnameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_stuFnameFocusLost
         jFocusLost(stuFname);
    }//GEN-LAST:event_stuFnameFocusLost

    private void stuFnameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_stuFnameFocusGained
        stuFname.setBackground(new java.awt.Color(255, 255, 204)); // light yellow highlight
        stuFname.setText(stuFname.getText().trim());
    }//GEN-LAST:event_stuFnameFocusGained

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

    private void stuFatherNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_stuFatherNameFocusGained
        stuFatherName.setBackground(new java.awt.Color(255, 255, 204)); // light yellow highlight
        stuFatherName.setText(stuFatherName.getText().trim());
    }//GEN-LAST:event_stuFatherNameFocusGained

    private void stuFatherNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_stuFatherNameFocusLost
         jFocusLost(stuFatherName);
    }//GEN-LAST:event_stuFatherNameFocusLost

    private void stuMotherNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_stuMotherNameFocusGained
        stuMotherName.setBackground(new java.awt.Color(255, 255, 204)); // light yellow highlight
        stuMotherName.setText(stuMotherName.getText().trim());
    }//GEN-LAST:event_stuMotherNameFocusGained

    private void stuMotherNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_stuMotherNameFocusLost
         jFocusLost(stuMotherName);
    }//GEN-LAST:event_stuMotherNameFocusLost

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

    public void jFocusLost(JTextField field){
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
    private String getSelectedStrandName() {
        String name = "";
        try {
            int strandId = getSelectedStrandId(); // your existing method
            String sql = "SELECT strand_name FROM strands WHERE strand_id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, strandId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                name = rs.getString("strand_name");
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return name;
    }

// Get Section name by sectionId
    private String getSelectedSectionName() {
        String name = "";
        try {
            int sectionId = grade.getSelectedSectionId(sectionBox); // your existing method
            String sql = "SELECT section_name FROM section WHERE section_id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, sectionId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                name = rs.getString("section_name");
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return name;
    }

// Get Subject name by subjectId
    private String getSelectedSubjectName() {
        String name = "";
        try {
            int subjectId = grade.getSelectedSubjectId(subjectBox); // your existing method
            String sql = "SELECT subject_name FROM subject WHERE subject_id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, subjectId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                name = rs.getString("subject_name");
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return name;
    }

// Get Grade Level (you may get it from the selected section or strand combo)
    private String getSelectedGradeLevel() {
        String gradeLevel = "";
        try {
            int sectionId = grade.getSelectedSectionId(sectionBox);
            String sql = "SELECT grade_level FROM student_strand WHERE section_id = ? LIMIT 1";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, sectionId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                gradeLevel = rs.getString("grade_level");
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return gradeLevel;
    }

    public void updatesComboBox() {
        try {
            // Make sure subject is selected
            if (subjectBox.getSelectedItem() == null) {
                System.out.println("⚠ No subject selected yet.");
                return; // stop here to avoid NPE
            }

            // Get grade level safely
            if (gradeLevelBox.getSelectedItem() == null) {
                JOptionPane.showMessageDialog(this, "Please select a grade level first.");
                return;
            }
            String gradeLevelStr = gradeLevelBox.getSelectedItem().toString();
            int gradeLevel = Integer.parseInt(gradeLevelStr.split(" - ")[0]);

            // Get strand id
            int strandId = getSelectedStrandId();

            // Get section id
            int sectionId = grade.getSelectedSectionId(sectionBox);

            // Get subject id
            int subjectId = grade.getSelectedSubjectId(subjectBox);

            // Get quarter safely
            if (quarterBox.getSelectedItem() == null) {
                JOptionPane.showMessageDialog(this, "Please select a quarter first.");
                return;
            }
            String quarterStr = quarterBox.getSelectedItem().toString();
            int quarter = Integer.parseInt(quarterStr.split(" - ")[0]);

            // Call the query
            DefaultTableModel model = grade.getStudentGrades(
                    gradeLevel, strandId, sectionId, subjectId, quarter
            );

            // Apply to JTable
            GradeSectioningManageTable.setModel(model);

            // If no rows were returned
            if (model.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "No results found. Check DB values.");
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error fetching grades: " + e.getMessage());
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

//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
//            logger.log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(() -> new Home().setVisible(true));
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable ClassListTable;
    private javax.swing.JButton Clear;
    private javax.swing.JTable GradeSectioningManageTable;
    private javax.swing.JTextField IdTxt;
    private javax.swing.JTable ListHonorTable;
    private javax.swing.JTable ProgressTable;
    private javax.swing.JTable StudentTable;
    private javax.swing.JTable StudentTrackTable;
    private javax.swing.JTable SubjectTable;
    private javax.swing.JButton addNewBt;
    private javax.swing.JTextField address1Txt;
    private javax.swing.JTextField address2Txt;
    private javax.swing.JButton browseBirthCertificate;
    private javax.swing.JButton browseForm137;
    private javax.swing.JButton browseImg;
    private javax.swing.JButton calculatorBt;
    private javax.swing.JButton classListClearBt;
    private javax.swing.JButton classListLogoutBt;
    private javax.swing.JButton classListPrintBt;
    private javax.swing.JButton classListSearchBt;
    private javax.swing.JButton clearFormBt;
    private javax.swing.JButton clearStudentProgressBt;
    private javax.swing.JButton clearSubjectManageBt;
    private javax.swing.JTextField dateTxt;
    private javax.swing.JButton delBt;
    private javax.swing.JTextField emailTxt;
    private javax.swing.JButton finalizeBt;
    private javax.swing.JTable formTable;
    private javax.swing.JTextField genderTxt;
    private javax.swing.JButton gradeClear;
    private javax.swing.JButton gradeHonorClear;
    private javax.swing.JButton gradeHonorLogout;
    private javax.swing.JButton gradeHonorSectioningPrint;
    private javax.swing.JComboBox<String> gradeLevelBox;
    private javax.swing.JComboBox<String> gradeLevelClassBox;
    private javax.swing.JComboBox<String> gradeLevelHonorBox;
    private javax.swing.JComboBox<String> gradeLevelStudentBox;
    private javax.swing.JComboBox<String> gradeLevelStudentProgressBox;
    private javax.swing.JComboBox<String> gradeLevelSubjectBox;
    private javax.swing.JButton gradeLogout;
    private javax.swing.JButton gradeSaveBt;
    private javax.swing.JButton gradeSectioningPrint;
    private javax.swing.JButton gradeSort;
    private javax.swing.JLabel imagePanel;
    private javax.swing.JLabel imagePanel3;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
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
    private javax.swing.JPanel jPanel41;
    private javax.swing.JPanel jPanel42;
    private javax.swing.JPanel jPanel43;
    private javax.swing.JPanel jPanel44;
    private javax.swing.JPanel jPanel45;
    private javax.swing.JPanel jPanel46;
    private javax.swing.JPanel jPanel47;
    private javax.swing.JPanel jPanel48;
    private javax.swing.JPanel jPanel49;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel50;
    private javax.swing.JPanel jPanel51;
    private javax.swing.JPanel jPanel52;
    private javax.swing.JPanel jPanel53;
    private javax.swing.JPanel jPanel54;
    private javax.swing.JPanel jPanel55;
    private javax.swing.JPanel jPanel56;
    private javax.swing.JPanel jPanel57;
    private javax.swing.JPanel jPanel58;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton logStuBt;
    private javax.swing.JButton logoutFormGradeBt;
    private javax.swing.JButton logoutFormGradeBt1;
    private javax.swing.JButton logoutStudentProgressBt;
    private javax.swing.JTextField nameTxt;
    private javax.swing.JTextField phoneTxt;
    private javax.swing.JButton printStudentProgressBt;
    private javax.swing.JComboBox<String> quarterBox;
    private javax.swing.JComboBox<String> quarterHonorBox;
    private javax.swing.JButton searchBt_1;
    public static javax.swing.JComboBox<String> sectionBox;
    public static javax.swing.JComboBox<String> sectionClassBox;
    public static javax.swing.JComboBox<String> sectionHonorBox;
    private javax.swing.JComboBox<String> sectionStudentProgressBox;
    private javax.swing.JComboBox<String> strandBox;
    private javax.swing.JComboBox<String> strandClassBox;
    private javax.swing.JComboBox<String> strandGradeProgressBox;
    private javax.swing.JComboBox<String> strandHonorBox;
    private javax.swing.JComboBox<String> strandStudentBox;
    private javax.swing.JTextField strandTxt;
    private javax.swing.JTextField stuAddress1;
    private javax.swing.JTextField stuAddress2;
    private com.toedter.calendar.JDateChooser stuBirth;
    private javax.swing.JTextField stuBirthCer;
    private javax.swing.JButton stuCurrentOrArchive;
    private javax.swing.JTextField stuEmail;
    private javax.swing.JTextField stuFatherName;
    private javax.swing.JTextField stuFname;
    private javax.swing.JTextField stuForm137;
    private javax.swing.JButton stuFormGradePrint;
    public static javax.swing.JTextField stuFullName;
    private javax.swing.JTextField stuFullNameFormGrade;
    private javax.swing.JTextField stuFullNameSub;
    private javax.swing.JComboBox<String> stuGender;
    private javax.swing.JButton stuGradeFormSearch;
    private javax.swing.JButton stuGradeHonorSearchBt;
    private javax.swing.JTextField stuGradeIDManage;
    private javax.swing.JComboBox<String> stuGradeLevel;
    private javax.swing.JButton stuGradeManageRefreshTable;
    private javax.swing.JButton stuGradeManageRefreshTable1;
    private javax.swing.JButton stuGradeManageSearchButton;
    private javax.swing.JTextField stuID;
    private javax.swing.JButton stuInfoCurrentOrArchived;
    private javax.swing.JTextField stuLRN;
    private javax.swing.JTextField stuLastName;
    private javax.swing.JTextField stuLrn;
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
    private javax.swing.JButton stuStudentProgressRefresh;
    private javax.swing.JButton stuStudentProgressSearchBox;
    private javax.swing.JTextField stuSubjectIDManage;
    private javax.swing.JButton stuSubjectSaveBt;
    private javax.swing.JButton stuSubjectSearch;
    public static javax.swing.JComboBox<String> subjectBox;
    private javax.swing.JLabel txtDate;
    private javax.swing.JLabel txtTime;
    private javax.swing.JButton updateBt;
    // End of variables declaration//GEN-END:variables
}
