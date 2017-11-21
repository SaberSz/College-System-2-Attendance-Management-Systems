-- phpMyAdmin SQL Dump
-- version 4.7.3
-- https://www.phpmyadmin.net/
--
-- Host: localhost:8889
-- Generation Time: Nov 20, 2017 at 06:14 AM
-- Server version: 5.6.35
-- PHP Version: 7.0.22

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `Attendance_Mgmt_System`
--
CREATE DATABASE IF NOT EXISTS `Attendance_Mgmt_System` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `Attendance_Mgmt_System`;

-- --------------------------------------------------------

--
-- Table structure for table `Class`
--

DROP TABLE IF EXISTS `Class`;
CREATE TABLE `Class` (
  `Semester` int(1) NOT NULL,
  `Section` varchar(1) NOT NULL,
  `Department` varchar(3) NOT NULL,
  `CTID` varchar(10) NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Class`
--

INSERT INTO `Class` (`Semester`, `Section`, `Department`, `CTID`) VALUES
(2, 'A', 'BT', 'FID15BT005'),
(2, 'B', 'BT', 'FID15BT004'),
(4, 'A', 'BT', 'FID15BT001'),
(4, 'A', 'CSE', 'FID15CS001'),
(4, 'B', 'BT', 'FID15BT002');

-- --------------------------------------------------------

--
-- Table structure for table `department`
--

DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `FID` varchar(10) NOT NULL,
  `Name` varchar(30) NOT NULL,
  `DOB` date NOT NULL,
  `Branch` varchar(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

--
-- Dumping data for table `department`
--

INSERT INTO `department` (`FID`, `Name`, `DOB`, `Branch`) VALUES
('FID15BT020', 'Monica Geller Bing', '1980-04-08', 'BT'),
('FID15CS002', 'Chandler Bing', '1970-04-12', 'CSE'),
('FID15EC001', 'John Wick', '2017-05-01', 'EC'),
('FID15EE001', 'Indiana Jones', '2017-05-02', 'EE'),
('FID15ME001', 'Raon Lee', '2017-05-04', 'ME');

-- --------------------------------------------------------

--
-- Table structure for table `faculty`
--

DROP TABLE IF EXISTS `faculty`;
CREATE TABLE `faculty` (
  `FID` varchar(10) NOT NULL,
  `Name` varchar(30) NOT NULL,
  `DOB` date DEFAULT NULL,
  `Section` varchar(1) NOT NULL,
  `Subject Code` varchar(6) NOT NULL,
  `SEM` varchar(1) NOT NULL,
  `Dep` varchar(3) NOT NULL,
  `Hours Taken` int(11) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

--
-- Dumping data for table `faculty`
--

INSERT INTO `faculty` (`FID`, `Name`, `DOB`, `Section`, `Subject Code`, `SEM`, `Dep`, `Hours Taken`) VALUES
('FID15BT001', 'Kanye West', '1970-12-23', 'A', '15BT44', '4', 'BT', 28),
('FID15BT001', 'Kanye West', '1970-12-23', 'B', '15BT25', '2', 'BT', 25),
('FID15BT002', 'Elvis Presley', '1970-11-23', 'A', '15BT24', '2', 'BT', 25),
('FID15BT002', 'Elvis Presley', '1970-11-23', 'A', '15BT46', '4', 'BT', 25),
('FID15BT002', 'Elvis Presley', '1970-11-23', 'B', '15BT41', '4', 'BT', 25),
('FID15BT004', 'Neymar ', '1986-03-05', 'A', '15BT45', '4', 'BT', 25),
('FID15BT004', 'Neymar', '1986-03-05', 'B', '15BT23', '2', 'BT', 25),
('FID15BT005', 'James West', '1970-11-24', 'A', '15BT22', '2', 'BT', 25),
('FID15BT006', 'James East', '1970-11-25', 'A', '15BT25', '2', 'BT', 25),
('FID15BT007', 'John Rambo', '1970-11-26', 'A', '15BT21', '2', 'BT', 25),
('FID15BT007', 'John Rambo', '1970-11-25', 'A', '15BT23', '2', 'BT', 25),
('FID15BT008', 'Smith Jones', '2017-05-06', 'A', '15BT41', '4', 'BT', 25),
('FID15BT009', 'Miller Davis', '2017-05-17', 'A', '15BT43', '4', 'BT', 28),
('FID15BT010', 'Hall Lopez ', '2017-05-25', 'A', '15BT42', '4', 'BT', 25),
('FID15BT011', 'Milnes Davos', '2017-06-17', 'B', '15BT43', '4', 'BT', 25),
('FID15BT012', 'Halls Lee ', '2016-05-25', 'B', '15BT42', '4', 'BT', 25),
('FID15BT013', 'Jerry Tom', '2017-05-22', 'B', '15BT45', '4', 'BT', 25),
('FID15BT014', 'Dan Brown', '2017-04-04', 'B', '15BT46', '4', 'BT', 25),
('FID15BT015', 'Taylor Swift', '2017-05-31', 'B', '15BT44', '4', 'BT', 25),
('FID15BT016', 'Harris Will', '1970-11-23', 'B', '15BT24', '2', 'BT', 25),
('FID15BT017', 'Scott Free', '2017-05-19', 'B', '15BT22', '2', 'BT', 25),
('FID15BT018', 'Paul Walker', '1980-12-04', 'B', '15BT21', '2', 'BT', 25),
('FID15CS001', 'Jon Snow', '1978-11-08', 'A', '15CS41', '4', 'CSE', 25);

-- --------------------------------------------------------

--
-- Table structure for table `MessageImages`
--

DROP TABLE IF EXISTS `MessageImages`;
CREATE TABLE `MessageImages` (
  `MsgID` int(11) NOT NULL DEFAULT '0',
  `Images` mediumblob NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `Messages`
--

DROP TABLE IF EXISTS `Messages`;
CREATE TABLE `Messages` (
  `MsgID` int(11) NOT NULL DEFAULT '0',
  `ToID` varchar(10) NOT NULL,
  `FromID` varchar(10) NOT NULL,
  `Content` varchar(10000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Messages`
--

INSERT INTO `Messages` (`MsgID`, `ToID`, `FromID`, `Content`) VALUES
(1, 'FID15BT001', '1KS15BT001', 'Hello!!!!!!! '),
(2, 'Admin', '1KS15BT001', 'Hello from 1ks15bt001. Testing the usage of messages with Admin Inbox. Have you received the entire message???????'),
(3, '1ks15BT001', 'Admin', 'Hello from the admin.\nI didn\'t get your message.'),
(4, '1KS15BT001', 'Admin', 'Hey!! 1ks15BT001\nI\'m the Admin.  You can call me the \"Master\".\nDo you understand?'),
(5, 'FID15BT001', 'Admin', 'Admin \nHey!! 1ks15BT001\nI\'m the Admin.  You can call me the \"Master\".\nDo you understand?\n1KS15BT001\nHello from 1ks15bt001. Testing the usage of messages with Admin Inbox. Have you received the entire message???????'),
(6, '1KS15BT001', 'Admin', 'Hey!! 1ks15BT001\nI\'m the Admin.  You can call me the \"Master\".\nDo you understand?'),
(7, '1KS15BT001', '1KS15BT001', 'My message box isn\'t working. Can I get some help here?'),
(8, 'FID15BT001', '1KS15BT001', 'Request for leave\n2017-11-11----------18:05\n1KS15BT001\n Leave Date : 2017-11-07\n Number of Days : 5\n Request :\nCasual Leave.'),
(9, 'FID15BT001', '1KS15BT001', 'Incorrect Attendance\n2017-11-11------------------18:10\n1KS15BT001English	0'),
(10, 'Admin', '1KS15BT001', 'Oh dear me!'),
(11, 'FID15BT001', '1KS15BT001', '1KS15BT001\nYes Master\nAdmin\nHey!! 1ks15BT001\nI\'m the Admin.  You can call me the \"Master\".\nDo you understand?'),
(12, 'Admin', '1KS15BT001', 'Yes Master'),
(13, 'Admin', '1KS15BT001', 'Yes Master'),
(14, '1KS15BT001', '1KS15BT001', 'Well it\'s working now.'),
(15, 'Admin', '1KS15BT001', 'My scroll bar isn\'t working'),
(16, 'FID15BT001', '1KS15BT001', ' Submission of Medical Certificate\n2017-11-11	18:43'),
(17, 'FID15BT001', 'Admin', 'helosdfuafkafluksdgfluasdlifalsdfla'),
(18, 'Admin', 'FID15BT001', 'Hello'),
(19, '1KS15BT001', 'FID15BT001', 'HAHAHHAHA'),
(20, 'Admin', 'FID15BT001', '2017-11-11------------------23:31\nFID15BT001\nhey I need some changes \n\n-------------------------------------------------------------------\n\n'),
(21, 'FID15BT001', '1KS15BT001', ' Submission of Medical Certificate\n2017-11-11	23:38'),
(22, '1KS15BT001', 'Admin', 'You were absent today for Microbiology Class.'),
(23, 'Admin', '1KS15BT001', 'No! I wasn\'t.\nActually I was. Please don\'t tell a soul. Promise?'),
(24, 'FID15BT001', '1KS15BT001', 'Incorrect Attendance\n2017-11-18------------------21:05\n1KS15BT001organic chemistry	0'),
(25, 'FID15BT001', '1KS15BT001', 'Request for leave\n2017-11-18----------21:07\n1KS15BT001\n Leave Date : 2017-11-01\n Number of Days : 5\n Request :\nlgkhlkcyyix'),
(26, '1KS15BT001', 'Admin', 'You were absent today for Microbiology Class.'),
(27, '1KS15BT001', 'FID15BT001', 'NO');

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `USN` varchar(10) NOT NULL,
  `DOB` date DEFAULT NULL,
  `Class` varchar(1) NOT NULL,
  `SEM` int(1) NOT NULL,
  `Dep` varchar(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`USN`, `DOB`, `Class`, `SEM`, `Dep`) VALUES
('1KS15BT001', '1996-12-29', 'A', 4, 'BT'),
('1KS15BT002', '1996-01-01', 'A', 4, 'BT'),
('1KS15BT003', '1996-02-02', 'B', 4, 'BT'),
('1KS15CS001', '1996-01-01', 'A', 4, 'CSE'),
('1KS15CS002', '1996-12-23', 'A', 4, 'CSE'),
('1KS15CS003', '1996-02-29', 'A', 4, 'CSE'),
('1KS15CS004', '1996-04-23', 'A', 4, 'CSE'),
('1KS15CS005', '1996-04-13', 'A', 4, 'CSE'),
('1KS15CS006', '1996-01-03', 'A', 4, 'CSE'),
('1KS15CS007', '1996-01-09', 'A', 4, 'CSE'),
('1KS15CS008', '1996-10-30', 'A', 4, 'CSE'),
('1KS15CS009', '1996-11-03', 'A', 4, 'CSE'),
('1KS15CS010', '1996-05-16', 'A', 4, 'CSE'),
('1KS15CS011', '1996-06-13', 'A', 4, 'CSE'),
('1KS15CS012', '1996-03-03', 'A', 4, 'CSE'),
('1KS15CS013', '1996-01-15', 'A', 4, 'CSE'),
('1KS16BT001', '1996-01-01', 'A', 2, 'BT'),
('1KS16BT002', '1996-01-02', 'A', 2, 'BT'),
('1KS16BT003', '1996-01-01', 'B', 2, 'BT');

-- --------------------------------------------------------

--
-- Table structure for table `Student Attendance`
--

DROP TABLE IF EXISTS `Student Attendance`;
CREATE TABLE `Student Attendance` (
  `USN` varchar(10) NOT NULL,
  `Subject Code` varchar(6) NOT NULL,
  `Attendance` int(11) NOT NULL DEFAULT '0',
  `Absent Days` varchar(100) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Student Attendance`
--

INSERT INTO `Student Attendance` (`USN`, `Subject Code`, `Attendance`, `Absent Days`) VALUES
('1KS15BT001', '15BT41', 24, '2017-10-23'),
('1KS15BT001', '15BT42', 23, '2017-09-10 2017-11-05'),
('1KS15BT001', '15BT43', 25, '2017-10-23 2017-11-01 2017-11-02 2017-11-02 2017-11-16'),
('1KS15BT001', '15BT44', 28, ''),
('1KS15BT001', '15BT45', 24, '2017-10-23'),
('1KS15BT001', '15BT46', 22, '2017-09-10 2017-11-05 2017-07-22'),
('1KS15BT002', '15BT41', 24, '2017-10-23'),
('1KS15BT002', '15BT42', 23, '2017-09-10 2017-11-05'),
('1KS15BT002', '15BT43', 25, '2017-10-23'),
('1KS15BT002', '15BT44', 25, '2017-10-23'),
('1KS15BT002', '15BT45', 24, '2017-10-23'),
('1KS15BT002', '15BT46', 22, '2017-09-10 2017-11-05 2017-07-22'),
('1KS15BT003', '15BT41', 24, '2017-10-23'),
('1KS15BT003', '15BT42', 23, '2017-09-10 2017-11-05'),
('1KS15BT003', '15BT43', 24, '2017-10-23'),
('1KS15BT003', '15BT44', 24, '2017-10-23'),
('1KS15BT003', '15BT45', 24, '2017-10-23'),
('1KS15BT003', '15BT46', 22, '2017-09-10 2017-11-05 2017-07-22'),
('1KS16BT001', '15BT21', 20, '2017-19-23  2017-43-12  324-234-234'),
('1KS16BT001', '15BT22', 23, '2017-09-10 2017-11-05'),
('1KS16BT001', '15BT23', 24, '2017-10-23'),
('1KS16BT001', '15BT24', 24, '2017-10-23'),
('1KS16BT001', '15BT25', 24, '2017-10-23'),
('1KS16BT002', '15BT21', 24, '2017-10-23'),
('1KS16BT002', '15BT22', 23, '2017-09-10 2017-11-05'),
('1KS16BT002', '15BT23', 24, '2017-10-23'),
('1KS16BT002', '15BT24', 24, '2017-10-23'),
('1KS16BT002', '15BT25', 24, '2017-10-23'),
('1KS16BT003', '15BT21', 24, '2017-10-23'),
('1KS16BT003', '15BT22', 23, '2017-09-10 2017-11-05'),
('1KS16BT003', '15BT23', 24, '2017-10-23'),
('1KS16BT003', '15BT24', 24, '2017-10-23'),
('1KS16BT003', '15BT25', 24, '2017-10-23');

--
-- Triggers `Student Attendance`
--
DROP TRIGGER IF EXISTS `HoursCheckonInsert`;
DELIMITER $$
CREATE TRIGGER `HoursCheckonInsert` BEFORE INSERT ON `Student Attendance` FOR EACH ROW SET NEW.Attendance = IF(
    NOT EXISTS(
      SELECT *
      FROM Faculty AS f
      JOIN `Student Attendance` AS s ON s.`Subject Code` = f.`Subject Code`
      JOIN Student AS k ON k.SEM = f.Sem AND k.Class=f.Section AND k.uSN = s.USN 
      WHERE  NEW.Attendance > f.`Hours Taken`),
    NEW.Attendance,
    NULL)
$$
DELIMITER ;
DROP TRIGGER IF EXISTS `HoursCheckonUpdate`;
DELIMITER $$
CREATE TRIGGER `HoursCheckonUpdate` BEFORE UPDATE ON `Student Attendance` FOR EACH ROW SET NEW.Attendance = IF(
    NOT EXISTS(
     SELECT *
      FROM Faculty AS f
      JOIN `Student Attendance` AS s ON s.`Subject Code` = f.`Subject Code`
      JOIN Student AS k ON k.SEM = f.Sem AND k.Class=f.Section AND k.uSN = s.USN 
      WHERE  NEW.Attendance > f.`Hours Taken` AND k.USN=NEW.USN AND s.`Subject Code`= NEW.`Subject Code`),
    NEW.Attendance,
    NULL)
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `Subjects`
--

DROP TABLE IF EXISTS `Subjects`;
CREATE TABLE `Subjects` (
  `Subject` varchar(40) NOT NULL,
  `Subject Code` varchar(6) NOT NULL,
  `Dep` varchar(3) NOT NULL,
  `Sem` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Subjects`
--

INSERT INTO `Subjects` (`Subject`, `Subject Code`, `Dep`, `Sem`) VALUES
('CAED', '15BT21', 'BT', 2),
('Chemistry', '15BT22', 'BT', 2),
('Environmental Studies', '15BT23', 'BT', 2),
('Mathematics 2', '15BT24', 'BT', 2),
('Programming in C', '15BT25', 'BT', 2),
('English', '15BT41', 'BT', 4),
('Environmental Biotechnology', '15BT42', 'BT', 4),
('Microbial Diversity', '15BT43', 'BT', 4),
('Microbiology', '15BT44', 'BT', 4),
('Organic Chemistry', '15BT45', 'BT', 4),
('Mathematics 4', '15BT46', 'BT', 4),
('Data Structures', '15CS41', 'CSE', 4);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Class`
--
ALTER TABLE `Class`
  ADD PRIMARY KEY (`Semester`,`Section`,`Department`),
  ADD KEY `Department` (`Department`);

--
-- Indexes for table `department`
--
ALTER TABLE `department`
  ADD PRIMARY KEY (`Branch`) USING BTREE;

--
-- Indexes for table `faculty`
--
ALTER TABLE `faculty`
  ADD PRIMARY KEY (`FID`,`Section`,`Subject Code`,`SEM`,`Dep`),
  ADD KEY `Subject Code` (`Subject Code`),
  ADD KEY `Dep` (`Dep`);

--
-- Indexes for table `MessageImages`
--
ALTER TABLE `MessageImages`
  ADD PRIMARY KEY (`MsgID`);

--
-- Indexes for table `Messages`
--
ALTER TABLE `Messages`
  ADD PRIMARY KEY (`MsgID`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`USN`),
  ADD KEY `SEM` (`SEM`,`Class`,`Dep`);

--
-- Indexes for table `Student Attendance`
--
ALTER TABLE `Student Attendance`
  ADD PRIMARY KEY (`USN`,`Subject Code`),
  ADD KEY `Subject Code` (`Subject Code`),
  ADD KEY `USN` (`USN`);

--
-- Indexes for table `Subjects`
--
ALTER TABLE `Subjects`
  ADD PRIMARY KEY (`Subject Code`),
  ADD KEY `Semester` (`Sem`),
  ADD KEY `Department` (`Dep`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `Class`
--
ALTER TABLE `Class`
  ADD CONSTRAINT `class_ibfk_1` FOREIGN KEY (`Department`) REFERENCES `department` (`Branch`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `faculty`
--
ALTER TABLE `faculty`
  ADD CONSTRAINT `faculty_ibfk_1` FOREIGN KEY (`Subject Code`) REFERENCES `Subjects` (`Subject Code`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `faculty_ibfk_2` FOREIGN KEY (`Dep`) REFERENCES `department` (`Branch`);

--
-- Constraints for table `MessageImages`
--
ALTER TABLE `MessageImages`
  ADD CONSTRAINT `messageimages_ibfk_1` FOREIGN KEY (`MsgID`) REFERENCES `Messages` (`MsgID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `student`
--
ALTER TABLE `student`
  ADD CONSTRAINT `student_ibfk_1` FOREIGN KEY (`SEM`,`Class`,`Dep`) REFERENCES `Class` (`Semester`, `Section`, `Department`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `Student Attendance`
--
ALTER TABLE `Student Attendance`
  ADD CONSTRAINT `dfgdfg` FOREIGN KEY (`USN`) REFERENCES `student` (`USN`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `student attendance_ibfk_1` FOREIGN KEY (`Subject Code`) REFERENCES `Subjects` (`Subject Code`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `Subjects`
--
ALTER TABLE `Subjects`
  ADD CONSTRAINT `ASDAD` FOREIGN KEY (`Sem`) REFERENCES `Class` (`Semester`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `subjects_ibfk_1` FOREIGN KEY (`Dep`) REFERENCES `department` (`Branch`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
