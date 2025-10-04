-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 04, 2025 at 06:10 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `cdonhs_shs_database_new`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `admin_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `first_name` varchar(50) NOT NULL,
  `middle_name` varchar(50) DEFAULT NULL,
  `last_name` varchar(50) NOT NULL,
  `gender` enum('Male','Female') NOT NULL,
  `email` varchar(50) DEFAULT NULL,
  `phone_number` varchar(20) DEFAULT NULL,
  `address1` varchar(100) NOT NULL,
  `address2` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `grade_entry`
--

CREATE TABLE `grade_entry` (
  `entry_id` int(11) NOT NULL,
  `student_id` int(11) NOT NULL,
  `subject_id` int(11) NOT NULL,
  `section_id` int(11) NOT NULL,
  `quarter` int(11) NOT NULL,
  `grade` decimal(5,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `grade_entry`
--

INSERT INTO `grade_entry` (`entry_id`, `student_id`, `subject_id`, `section_id`, `quarter`, `grade`) VALUES
(80, 1, 36, 33, 1, 91.90),
(81, 1, 37, 33, 1, 90.00),
(82, 1, 38, 33, 1, 90.00),
(83, 1, 39, 33, 1, 85.00),
(84, 1, 40, 33, 1, 86.00),
(85, 1, 36, 33, 2, 90.00),
(86, 1, 36, 33, 3, 90.00),
(87, 1, 36, 33, 4, 98.00),
(88, 1, 38, 33, 2, 90.00),
(89, 1, 38, 33, 3, 90.00),
(90, 1, 38, 33, 4, 60.00),
(91, 1, 39, 33, 2, 60.00),
(92, 1, 39, 33, 3, 90.00),
(93, 1, 39, 33, 4, 90.00),
(94, 1, 40, 33, 2, 60.00),
(95, 1, 40, 33, 3, 90.00),
(96, 1, 40, 33, 4, 60.00),
(97, 1, 37, 33, 2, 90.00),
(98, 1, 37, 33, 3, 80.00),
(99, 1, 37, 33, 4, 90.00),
(100, 2, 1, 1, 1, 90.00),
(101, 2, 2, 1, 1, 99.00),
(102, 2, 2, 1, 3, 90.00),
(103, 2, 3, 1, 3, 90.00),
(104, 2, 4, 1, 3, 90.00),
(105, 2, 3, 1, 1, 90.00),
(106, 2, 4, 1, 1, 90.00),
(107, 2, 5, 1, 1, 90.00),
(108, 2, 6, 1, 1, 90.00),
(109, 2, 7, 1, 1, 90.00),
(110, 2, 8, 1, 1, 90.00),
(111, 4, 1, 2, 1, 90.00),
(112, 4, 2, 2, 1, 80.00),
(113, 4, 3, 2, 1, 76.00),
(114, 4, 4, 2, 1, 90.00),
(115, 4, 5, 2, 1, 80.00),
(116, 4, 6, 2, 1, 70.00),
(117, 4, 7, 2, 1, 90.00),
(118, 4, 8, 2, 1, 100.00);

-- --------------------------------------------------------

--
-- Table structure for table `section`
--

CREATE TABLE `section` (
  `section_id` int(11) NOT NULL,
  `section_name` varchar(30) NOT NULL,
  `grade_level` int(2) NOT NULL,
  `strand_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `section`
--

INSERT INTO `section` (`section_id`, `section_name`, `grade_level`, `strand_id`) VALUES
(1, 'A', 11, 1),
(2, 'B', 11, 1),
(3, 'C', 11, 1),
(4, 'D', 11, 1),
(5, 'A', 12, 1),
(6, 'B', 12, 1),
(7, 'C', 12, 1),
(8, 'D', 12, 1),
(9, 'A', 11, 2),
(10, 'B', 11, 2),
(11, 'C', 11, 2),
(12, 'D', 11, 2),
(13, 'A', 12, 2),
(14, 'B', 12, 2),
(15, 'C', 12, 2),
(16, 'D', 12, 2),
(17, 'A', 11, 3),
(18, 'B', 11, 3),
(19, 'C', 11, 3),
(20, 'D', 11, 3),
(21, 'A', 12, 3),
(22, 'B', 12, 3),
(23, 'C', 12, 3),
(24, 'D', 12, 3),
(25, 'A', 11, 4),
(26, 'B', 11, 4),
(27, 'C', 11, 4),
(28, 'D', 11, 4),
(29, 'A', 12, 4),
(30, 'B', 12, 4),
(31, 'C', 12, 4),
(32, 'D', 12, 4),
(33, 'A', 11, 5),
(34, 'B', 11, 5),
(35, 'C', 11, 5),
(36, 'D', 11, 5),
(37, 'A', 12, 5),
(38, 'B', 12, 5),
(39, 'C', 12, 5),
(40, 'D', 12, 5),
(41, 'A', 11, 6),
(42, 'B', 11, 6),
(43, 'C', 11, 6),
(44, 'D', 11, 6),
(45, 'A', 12, 6),
(46, 'B', 12, 6),
(47, 'C', 12, 6),
(48, 'D', 12, 6),
(49, 'A', 11, 7),
(50, 'B', 11, 7),
(51, 'C', 11, 7),
(52, 'D', 11, 7),
(53, 'A', 12, 7),
(54, 'B', 12, 7),
(55, 'C', 12, 7),
(56, 'D', 12, 7);

-- --------------------------------------------------------

--
-- Table structure for table `strands`
--

CREATE TABLE `strands` (
  `strand_id` int(11) NOT NULL,
  `strand_name` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `strands`
--

INSERT INTO `strands` (`strand_id`, `strand_name`) VALUES
(1, 'STEM'),
(2, 'ABM'),
(3, 'HUMSS'),
(4, 'GAS'),
(5, 'TVL-ICT'),
(6, 'TVL-EIM'),
(7, 'TVL-HE');

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `student_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `first_name` varchar(50) NOT NULL,
  `middle_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `date_of_birth` date NOT NULL,
  `gender` enum('Male','Female') NOT NULL,
  `email` varchar(50) NOT NULL,
  `phone_number` varchar(20) NOT NULL,
  `mother_name` varchar(50) NOT NULL,
  `father_name` varchar(50) NOT NULL,
  `address1` varchar(50) NOT NULL,
  `address2` varchar(50) DEFAULT NULL,
  `birth_certificate` varchar(100) DEFAULT NULL,
  `form_137` varchar(100) DEFAULT NULL,
  `image_path` varchar(100) DEFAULT NULL,
  `LRN` varchar(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`student_id`, `user_id`, `first_name`, `middle_name`, `last_name`, `date_of_birth`, `gender`, `email`, `phone_number`, `mother_name`, `father_name`, `address1`, `address2`, `birth_certificate`, `form_137`, `image_path`, `LRN`) VALUES
(1, 1, 'Nick', 'hfhfdhd', 'hdfhhdfhh', '2025-09-04', 'Male', 'asdaf@gmail.ocm', '09976866868', 'fafasfa', 'fasfaf', 'fasfaf', 'fafafa', 'fafsaf', 'fasfaf', 'D:\\PICTURES\\boy_pick_left_1.png', '74769648759'),
(2, 2, 'Harvey ', 'D.', 'Clarito', '2025-09-04', 'Male', 'dasdsda@gmail.com', '09329239232', 'papa', 'mama', 'dadasda', 'dada', 'dad', 'dasda', 'D:\\PICTURES\\boy_pick_left_2.png', '67439284'),
(3, 3, 'Andrea', 'Dominican', 'Bagtong', '2007-09-07', 'Female', 'dodo@gmail.com', '09933742', 'mama', 'papa', 'dasdsadsa', 'dadasd', 'dasdda', 'dadasd', 'D:\\PICTURES\\anime-moon-landscape.jpg', '6832924829'),
(4, 4, 'Niño Christian', 'Palaman', 'Balaba', '2005-08-20', 'Female', 'Balaba@gmail.com', '09944719', 'papa', 'mama', 'sdadd', 'dsdadada', 'num_1.pdf', 'FELISILDA_&_CLARITO.pdf', 'D:\\PICTURES\\anime-moon-landscape.jpg', '4053333424'),
(5, 5, 'Randy', 'Abecia', 'Clarito', '1988-09-15', 'Male', 'papa@gmail.com', '0965747', 'czcz', 'czczxc', 'czcczc', 'czczc', 'CLARITO, NICK CHARLES D..pdf', 'CLARITO, NICK CHARLES D. – 2003–Present.pdf', 'D:\\PICTURES\\boy_pick_left_2.png', '40998922892'),
(6, 8, 'Maria Cristina', 'Durangparang', 'Clarito', '1996-09-07', 'Female', 'Maria@gmail.com', '09262360968', 'papa', 'Dominador', 'dadsa', 'dadda', 'Form137_4.pdf', 'ClassList_11_STEM_A.pdf', 'D:\\PICTURES\\agile.png', '156456864214'),
(7, 10, 'Micah', 'Bilagbog', 'Micah', '2003-10-10', 'Male', 'baal@gmail.com', '09977564276', 'dasdsad', 'dasdad', 'dadsad', 'dasdasd', 'ClassList_G11_TVL-ICT_SecA.pdf', 'Form137_4.pdf', 'D:\\PICTURES\\agile_model.png', '105220150089'),
(8, 11, 'Ras', 'Pinignit', 'Lawren', '2006-10-13', 'Male', 'Lawren@gmail.com', '09977718534', 'dsadad', 'dasdsad', 'dasdadadadad', '', '', '', NULL, '404551221678'),
(9, 12, 'Dominic', 'Dolos', 'Reyes', '2001-06-02', 'Male', 'reyes@gmail.com', '09988716521', 'dadasda', 'dasdd', 'dasdasd', '', '', '', NULL, '109660713467');

-- --------------------------------------------------------

--
-- Table structure for table `student_strand`
--

CREATE TABLE `student_strand` (
  `student_strand_id` int(11) NOT NULL,
  `student_id` int(10) NOT NULL,
  `strand_id` int(11) NOT NULL,
  `grade_level` int(2) NOT NULL,
  `section_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `student_strand`
--

INSERT INTO `student_strand` (`student_strand_id`, `student_id`, `strand_id`, `grade_level`, `section_id`) VALUES
(6, 4, 1, 11, 2),
(8, 2, 1, 11, 1),
(9, 3, 7, 11, 49),
(12, 1, 5, 11, 33),
(13, 1, 5, 12, 37),
(14, 5, 5, 11, 33),
(16, 6, 1, 11, 1),
(17, 6, 1, 12, 5),
(18, 7, 5, 11, 33),
(19, 9, 3, 11, 17);

-- --------------------------------------------------------

--
-- Table structure for table `student_subjects`
--

CREATE TABLE `student_subjects` (
  `enrollment_id` int(11) NOT NULL,
  `student_id` int(11) NOT NULL,
  `subject_id` int(11) NOT NULL,
  `status` enum('Enrolled','Dropped') DEFAULT 'Enrolled',
  `school_year` varchar(9) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `student_subjects`
--

INSERT INTO `student_subjects` (`enrollment_id`, `student_id`, `subject_id`, `status`, `school_year`) VALUES
(65, 1, 33, 'Enrolled', '2025-2026'),
(66, 1, 34, 'Enrolled', '2025-2026'),
(67, 1, 35, 'Enrolled', '2025-2026'),
(68, 1, 36, 'Enrolled', '2025-2026'),
(69, 1, 37, 'Enrolled', '2025-2026'),
(70, 1, 38, 'Enrolled', '2025-2026'),
(71, 1, 39, 'Enrolled', '2025-2026'),
(72, 1, 40, 'Enrolled', '2025-2026'),
(81, 1, 89, 'Enrolled', '2025-2026'),
(82, 1, 90, 'Enrolled', '2025-2026'),
(83, 1, 91, 'Enrolled', '2025-2026'),
(84, 1, 92, 'Enrolled', '2025-2026'),
(85, 1, 93, 'Enrolled', '2025-2026'),
(86, 1, 94, 'Enrolled', '2025-2026'),
(87, 1, 95, 'Enrolled', '2025-2026'),
(88, 1, 96, 'Enrolled', '2025-2026'),
(97, 2, 1, 'Enrolled', '2025-2026'),
(98, 2, 2, 'Enrolled', '2025-2026'),
(99, 2, 3, 'Enrolled', '2025-2026'),
(100, 2, 4, 'Enrolled', '2025-2026'),
(101, 2, 5, 'Enrolled', '2025-2026'),
(102, 2, 6, 'Enrolled', '2025-2026'),
(103, 2, 7, 'Enrolled', '2025-2026'),
(104, 2, 8, 'Enrolled', '2025-2026'),
(129, 4, 1, 'Enrolled', '2025-2026'),
(130, 4, 2, 'Enrolled', '2025-2026'),
(131, 4, 3, 'Enrolled', '2025-2026'),
(132, 4, 4, 'Enrolled', '2025-2026'),
(133, 4, 5, 'Enrolled', '2025-2026'),
(134, 4, 6, 'Enrolled', '2025-2026'),
(135, 4, 7, 'Enrolled', '2025-2026'),
(136, 4, 8, 'Enrolled', '2025-2026'),
(137, 7, 33, 'Enrolled', '2025-2026'),
(138, 7, 34, 'Enrolled', '2025-2026'),
(139, 7, 35, 'Enrolled', '2025-2026'),
(140, 7, 36, 'Enrolled', '2025-2026'),
(141, 7, 37, 'Enrolled', '2025-2026'),
(142, 7, 38, 'Enrolled', '2025-2026'),
(143, 7, 39, 'Enrolled', '2025-2026'),
(144, 7, 40, 'Enrolled', '2025-2026');

-- --------------------------------------------------------

--
-- Table structure for table `subject`
--

CREATE TABLE `subject` (
  `subject_id` int(11) NOT NULL,
  `subject_name` varchar(100) NOT NULL,
  `grade_level` int(2) NOT NULL,
  `strand_id` int(11) NOT NULL,
  `subject_order` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `subject`
--

INSERT INTO `subject` (`subject_id`, `subject_name`, `grade_level`, `strand_id`, `subject_order`) VALUES
(1, 'Oral Communication', 11, 1, 1),
(2, 'Komunikasyon at Pananaliksik', 11, 1, 2),
(3, 'General Mathematics', 11, 1, 3),
(4, 'Earth and Life Science', 11, 1, 4),
(5, 'Understanding Culture, Society and Politics', 11, 1, 5),
(6, 'Pre-Calculus', 11, 1, 6),
(7, 'Basic Calculus', 11, 1, 7),
(8, 'Chemistry 1', 11, 1, 8),
(9, 'Oral Communication', 11, 2, 1),
(10, 'Komunikasyon at Pananaliksik', 11, 2, 2),
(11, 'General Mathematics', 11, 2, 3),
(12, 'Statistics and Probability', 11, 2, 4),
(13, 'Understanding Culture, Society and Politics', 11, 2, 5),
(14, 'Business Math', 11, 2, 6),
(15, 'Fundamentals of Accountancy 1', 11, 2, 7),
(16, 'Organization and Management', 11, 2, 8),
(17, 'Oral Communication', 11, 3, 1),
(18, 'Komunikasyon at Pananaliksik', 11, 3, 2),
(19, 'General Mathematics', 11, 3, 3),
(20, 'Statistics and Probability', 11, 3, 4),
(21, 'Understanding Culture, Society and Politics', 11, 3, 5),
(22, 'Creative Writing', 11, 3, 6),
(23, 'Disciplines and Ideas in Social Sciences', 11, 3, 7),
(24, 'Introduction to Philosophy', 11, 3, 8),
(25, 'Oral Communication', 11, 4, 1),
(26, 'Komunikasyon at Pananaliksik', 11, 4, 2),
(27, 'General Mathematics', 11, 4, 3),
(28, 'Statistics and Probability', 11, 4, 4),
(29, 'Understanding Culture, Society and Politics', 11, 4, 5),
(30, 'Humanities 1', 11, 4, 6),
(31, 'Applied Economics', 11, 4, 7),
(32, 'Organization and Management', 11, 4, 8),
(33, 'Oral Communication', 11, 5, 1),
(34, 'Komunikasyon at Pananaliksik', 11, 5, 2),
(35, 'General Mathematics', 11, 5, 3),
(36, 'Statistics and Probability', 11, 5, 4),
(37, 'Understanding Culture, Society and Politics', 11, 5, 5),
(38, 'Computer Systems Servicing 1', 11, 5, 6),
(39, 'Computer Systems Servicing 2', 11, 5, 7),
(40, 'Computer Systems Servicing 3', 11, 5, 8),
(41, 'Oral Communication', 11, 6, 1),
(42, 'Komunikasyon at Pananaliksik', 11, 6, 2),
(43, 'General Mathematics', 11, 6, 3),
(44, 'Statistics and Probability', 11, 6, 4),
(45, 'Understanding Culture, Society and Politics', 11, 6, 5),
(46, 'Electrical Installation 1', 11, 6, 6),
(47, 'Electrical Installation 2', 11, 6, 7),
(48, 'Electrical Installation 3', 11, 6, 8),
(49, 'Oral Communication', 11, 7, 1),
(50, 'Komunikasyon at Pananaliksik', 11, 7, 2),
(51, 'General Mathematics', 11, 7, 3),
(52, 'Statistics and Probability', 11, 7, 4),
(53, 'Understanding Culture, Society and Politics', 11, 7, 5),
(54, 'Cookery 1', 11, 7, 6),
(55, 'Cookery 2', 11, 7, 7),
(56, 'Bread and Pastry Production', 11, 7, 8),
(57, 'Reading and Writing', 12, 1, 1),
(58, '21st Century Literature', 12, 1, 2),
(59, 'Contemporary Philippine Arts', 12, 1, 3),
(60, 'Media and Information Literacy', 12, 1, 4),
(61, 'Physical Science', 12, 1, 5),
(62, 'Physics 2', 12, 1, 6),
(63, 'Biology 1', 12, 1, 7),
(64, 'Chemistry 2', 12, 1, 8),
(65, 'Reading and Writing', 12, 2, 1),
(66, '21st Century Literature', 12, 2, 2),
(67, 'Contemporary Philippine Arts', 12, 2, 3),
(68, 'Media and Information Literacy', 12, 2, 4),
(69, 'Business Ethics', 12, 2, 5),
(70, 'Fundamentals of Accountancy 2', 12, 2, 6),
(71, 'Applied Economics', 12, 2, 7),
(72, 'Business Finance', 12, 2, 8),
(73, 'Reading and Writing', 12, 3, 1),
(74, '21st Century Literature', 12, 3, 2),
(75, 'Contemporary Philippine Arts', 12, 3, 3),
(76, 'Media and Information Literacy', 12, 3, 4),
(77, 'Creative Nonfiction', 12, 3, 5),
(78, 'Philippine Politics', 12, 3, 6),
(79, 'Trends and Networks', 12, 3, 7),
(80, 'Disciplines in Social Science', 12, 3, 8),
(81, 'Reading and Writing', 12, 4, 1),
(82, '21st Century Literature', 12, 4, 2),
(83, 'Contemporary Philippine Arts', 12, 4, 3),
(84, 'Media and Information Literacy', 12, 4, 4),
(85, 'Creative Writing', 12, 4, 5),
(86, 'Humanities 2', 12, 4, 6),
(87, 'Disaster Readiness', 12, 4, 7),
(88, 'Applied Economics', 12, 4, 8),
(89, 'Reading and Writing', 12, 5, 1),
(90, '21st Century Literature', 12, 5, 2),
(91, 'Contemporary Philippine Arts', 12, 5, 3),
(92, 'Media and Information Literacy', 12, 5, 4),
(93, 'Computer Systems Servicing 4', 12, 5, 5),
(94, 'CSS Project', 12, 5, 6),
(95, 'Practical Research 1', 12, 5, 7),
(96, 'Empowerment Technologies', 12, 5, 8),
(97, 'Reading and Writing', 12, 6, 1),
(98, '21st Century Literature', 12, 6, 2),
(99, 'Contemporary Philippine Arts', 12, 6, 3),
(100, 'Media and Information Literacy', 12, 6, 4),
(101, 'Electrical Installation 4', 12, 6, 5),
(102, 'EIM Project', 12, 6, 6),
(103, 'Practical Research 1', 12, 6, 7),
(104, 'Empowerment Technologies', 12, 6, 8),
(105, 'Reading and Writing', 12, 7, 1),
(106, '21st Century Literature', 12, 7, 2),
(107, 'Contemporary Philippine Arts', 12, 7, 3),
(108, 'Media and Information Literacy', 12, 7, 4),
(109, 'Cookery 3', 12, 7, 5),
(110, 'Food and Beverage Services', 12, 7, 6),
(111, 'Practical Research 1', 12, 7, 7),
(112, 'Empowerment Technologies', 12, 7, 8);

-- --------------------------------------------------------

--
-- Table structure for table `teacher`
--

CREATE TABLE `teacher` (
  `teacher_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `first_name` varchar(50) NOT NULL,
  `middle_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `date_of_birth` date NOT NULL,
  `gender` enum('Male','Female') NOT NULL,
  `email` varchar(50) NOT NULL,
  `phone_number` varchar(20) NOT NULL,
  `address1` varchar(100) NOT NULL,
  `address2` varchar(100) NOT NULL,
  `strand_id` int(11) NOT NULL,
  `hire_date` date NOT NULL,
  `image_path` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `teacher`
--

INSERT INTO `teacher` (`teacher_id`, `user_id`, `first_name`, `middle_name`, `last_name`, `date_of_birth`, `gender`, `email`, `phone_number`, `address1`, `address2`, `strand_id`, `hire_date`, `image_path`) VALUES
(1, 6, 'Bern', 'Bastion', 'Balay', '2006-09-16', 'Male', 'Balay@gmail.com', '09243422442', 'dasda', 'dadasd', 1, '2025-09-15', 'D:\\PICTURES\\boy_pick_left_1.png'),
(2, 7, 'Sheenna', 'Abecia', 'Clarito', '2005-09-05', 'Male', 'Sheena@gmail.com', '0896979', 'Buena Oro', 'Macasandig', 5, '2025-09-15', 'D:\\PICTURES\\boy_pick_left_2.png'),
(3, 9, 'Villy', 'Vastinberg', 'Vilofol', '1999-09-18', 'Male', 'bol@gmail.com', '09988771651', 'djaskdja', 'dasda', 1, '2025-09-24', 'D:\\PICTURES\\boy_pick_down_2.png');

-- --------------------------------------------------------

--
-- Table structure for table `type`
--

CREATE TABLE `type` (
  `type_id` int(11) NOT NULL,
  `type_name` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `type`
--

INSERT INTO `type` (`type_id`, `type_name`) VALUES
(1, 'Admin'),
(2, 'Student'),
(3, 'Teacher');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `user_id` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(255) NOT NULL,
  `type_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`user_id`, `username`, `password`, `type_id`) VALUES
(1, 'hdfhhdfhh', 'hdfhhdfhh20250904', 2),
(2, '\"2\"', 'clarito20250904', 2),
(3, '3', 'bagtong20070907', 2),
(4, '4', 'balaba20050820', 2),
(5, '5', 'clarito19880915', 2),
(6, '1', 'balay20060916', 3),
(7, '2', 'clarito20050905', 3),
(8, '6', 'clarito19960907', 2),
(9, '02-3', 'vilofol19990918', 3),
(10, '105220150089', 'micah20031010', 2),
(11, '404551221678', 'lawren20061013', 2),
(12, '109660713467', 'reyes20010602', 2);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`admin_id`),
  ADD UNIQUE KEY `email` (`email`),
  ADD KEY `user_id` (`user_id`);

--
-- Indexes for table `grade_entry`
--
ALTER TABLE `grade_entry`
  ADD PRIMARY KEY (`entry_id`),
  ADD KEY `student_id` (`student_id`),
  ADD KEY `subject_id` (`subject_id`),
  ADD KEY `section_id` (`section_id`);

--
-- Indexes for table `section`
--
ALTER TABLE `section`
  ADD PRIMARY KEY (`section_id`),
  ADD KEY `strand_id` (`strand_id`);

--
-- Indexes for table `strands`
--
ALTER TABLE `strands`
  ADD PRIMARY KEY (`strand_id`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`student_id`),
  ADD UNIQUE KEY `LRN` (`LRN`),
  ADD KEY `user_id` (`user_id`);

--
-- Indexes for table `student_strand`
--
ALTER TABLE `student_strand`
  ADD PRIMARY KEY (`student_strand_id`),
  ADD UNIQUE KEY `unique_student_strand_grade` (`student_id`,`strand_id`,`grade_level`),
  ADD KEY `student_id` (`student_id`),
  ADD KEY `fk_student_strand_strand` (`strand_id`),
  ADD KEY `section_id` (`section_id`);

--
-- Indexes for table `student_subjects`
--
ALTER TABLE `student_subjects`
  ADD PRIMARY KEY (`enrollment_id`),
  ADD UNIQUE KEY `uq_student_subject` (`student_id`,`subject_id`,`school_year`),
  ADD KEY `fk_subject` (`subject_id`);

--
-- Indexes for table `subject`
--
ALTER TABLE `subject`
  ADD PRIMARY KEY (`subject_id`),
  ADD KEY `strand_id` (`strand_id`);

--
-- Indexes for table `teacher`
--
ALTER TABLE `teacher`
  ADD PRIMARY KEY (`teacher_id`),
  ADD UNIQUE KEY `email` (`email`),
  ADD KEY `user_id` (`user_id`),
  ADD KEY `strand_id` (`strand_id`);

--
-- Indexes for table `type`
--
ALTER TABLE `type`
  ADD PRIMARY KEY (`type_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_id`),
  ADD UNIQUE KEY `username` (`username`),
  ADD KEY `type_id` (`type_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `admin_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `grade_entry`
--
ALTER TABLE `grade_entry`
  MODIFY `entry_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=119;

--
-- AUTO_INCREMENT for table `section`
--
ALTER TABLE `section`
  MODIFY `section_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=57;

--
-- AUTO_INCREMENT for table `strands`
--
ALTER TABLE `strands`
  MODIFY `strand_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `student`
--
ALTER TABLE `student`
  MODIFY `student_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `student_strand`
--
ALTER TABLE `student_strand`
  MODIFY `student_strand_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT for table `student_subjects`
--
ALTER TABLE `student_subjects`
  MODIFY `enrollment_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=145;

--
-- AUTO_INCREMENT for table `subject`
--
ALTER TABLE `subject`
  MODIFY `subject_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=120;

--
-- AUTO_INCREMENT for table `teacher`
--
ALTER TABLE `teacher`
  MODIFY `teacher_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `type`
--
ALTER TABLE `type`
  MODIFY `type_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `admin`
--
ALTER TABLE `admin`
  ADD CONSTRAINT `admin_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`);

--
-- Constraints for table `grade_entry`
--
ALTER TABLE `grade_entry`
  ADD CONSTRAINT `grade_entry_ibfk_1` FOREIGN KEY (`student_id`) REFERENCES `student` (`student_id`),
  ADD CONSTRAINT `grade_entry_ibfk_2` FOREIGN KEY (`subject_id`) REFERENCES `subject` (`subject_id`),
  ADD CONSTRAINT `grade_entry_ibfk_3` FOREIGN KEY (`section_id`) REFERENCES `section` (`section_id`);

--
-- Constraints for table `section`
--
ALTER TABLE `section`
  ADD CONSTRAINT `section_ibfk_1` FOREIGN KEY (`strand_id`) REFERENCES `strands` (`strand_id`);

--
-- Constraints for table `student`
--
ALTER TABLE `student`
  ADD CONSTRAINT `student_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`);

--
-- Constraints for table `student_strand`
--
ALTER TABLE `student_strand`
  ADD CONSTRAINT `student_strand_ibfk_1` FOREIGN KEY (`student_id`) REFERENCES `student` (`student_id`),
  ADD CONSTRAINT `student_strand_ibfk_2` FOREIGN KEY (`strand_id`) REFERENCES `strands` (`strand_id`),
  ADD CONSTRAINT `student_strand_ibfk_3` FOREIGN KEY (`section_id`) REFERENCES `section` (`section_id`);

--
-- Constraints for table `student_subjects`
--
ALTER TABLE `student_subjects`
  ADD CONSTRAINT `fk_student` FOREIGN KEY (`student_id`) REFERENCES `student` (`student_id`),
  ADD CONSTRAINT `fk_subject` FOREIGN KEY (`subject_id`) REFERENCES `subject` (`subject_id`);

--
-- Constraints for table `subject`
--
ALTER TABLE `subject`
  ADD CONSTRAINT `subject_ibfk_1` FOREIGN KEY (`strand_id`) REFERENCES `strands` (`strand_id`);

--
-- Constraints for table `teacher`
--
ALTER TABLE `teacher`
  ADD CONSTRAINT `teacher_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  ADD CONSTRAINT `teacher_ibfk_2` FOREIGN KEY (`strand_id`) REFERENCES `strands` (`strand_id`);

--
-- Constraints for table `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `user_ibfk_1` FOREIGN KEY (`type_id`) REFERENCES `type` (`type_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
