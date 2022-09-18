-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Sep 16, 2022 at 05:38 PM
-- Server version: 5.7.36
-- PHP Version: 7.4.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pharmacy`
--
CREATE DATABASE IF NOT EXISTS `pharmacy` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `pharmacy`;

-- --------------------------------------------------------

--
-- Table structure for table `cart`
--

DROP TABLE IF EXISTS `cart`;
CREATE TABLE IF NOT EXISTS `cart` (
  `pno` int(5) NOT NULL,
  `name` varchar(15) NOT NULL,
  `unit_quantity` int(5) NOT NULL,
  `tot_price` int(5) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
CREATE TABLE IF NOT EXISTS `employee` (
  `eid` int(5) NOT NULL AUTO_INCREMENT COMMENT 'Employee ID',
  `first_name` varchar(15) NOT NULL COMMENT 'Employee first name',
  `last_name` varchar(15) NOT NULL COMMENT 'Employee last name',
  `gender` varchar(7) NOT NULL COMMENT 'Employee gender\r\n',
  `home-no` varchar(5) NOT NULL COMMENT 'Home number',
  `street` varchar(50) NOT NULL COMMENT 'Street name',
  `city` varchar(20) NOT NULL COMMENT 'City name',
  `district` varchar(20) NOT NULL COMMENT 'District name',
  `province` varchar(20) NOT NULL COMMENT 'Province name',
  `tp` varchar(10) NOT NULL COMMENT 'Telephone number',
  `email` varchar(254) NOT NULL COMMENT 'Employee email address',
  `dob` date NOT NULL COMMENT 'Employee date of birth',
  PRIMARY KEY (`eid`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`eid`, `first_name`, `last_name`, `gender`, `home-no`, `street`, `city`, `district`, `province`, `tp`, `email`, `dob`) VALUES
(1, 'Shahein', 'Ockersz', '', '72/1', 'St. Peter and Paul lane', 'Ragama', 'Gampaha', 'Western', '0765410491', 'shaheinockersz1234@gmail.com', '2001-06-30');

-- --------------------------------------------------------

--
-- Table structure for table `employee_login_credentials`
--

DROP TABLE IF EXISTS `employee_login_credentials`;
CREATE TABLE IF NOT EXISTS `employee_login_credentials` (
  `username` varchar(16) NOT NULL COMMENT 'Employee login username',
  `password` varchar(16) NOT NULL COMMENT 'Employee login password',
  `eno` int(5) NOT NULL COMMENT 'Employee ID number',
  PRIMARY KEY (`username`,`password`),
  KEY `eno` (`eno`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employee_login_credentials`
--

INSERT INTO `employee_login_credentials` (`username`, `password`, `eno`) VALUES
('ockersz', '2001', 1);

-- --------------------------------------------------------

--
-- Table structure for table `employee_login_history`
--

DROP TABLE IF EXISTS `employee_login_history`;
CREATE TABLE IF NOT EXISTS `employee_login_history` (
  `login_id` int(5) NOT NULL AUTO_INCREMENT COMMENT 'Login ID number',
  `time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Login Time',
  `eno` int(5) NOT NULL COMMENT 'Employee ID number',
  PRIMARY KEY (`login_id`),
  KEY `eno` (`eno`)
) ENGINE=MyISAM AUTO_INCREMENT=44 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employee_login_history`
--

INSERT INTO `employee_login_history` (`login_id`, `time`, `eno`) VALUES
(1, '2022-08-16 08:40:45', 1),
(2, '2022-08-17 17:06:25', 1),
(3, '2022-08-17 17:12:49', 1),
(4, '2022-08-18 19:44:34', 4),
(5, '2022-08-18 19:44:42', 1),
(6, '2022-08-18 19:44:48', 1),
(7, '2022-08-18 19:54:06', 4),
(8, '2022-08-18 19:54:37', 4),
(9, '2022-08-31 16:29:57', 1),
(10, '2022-09-01 14:35:32', 1),
(11, '2022-09-02 18:38:47', 1),
(12, '2022-09-04 13:31:23', 1),
(13, '2022-09-04 13:36:13', 1),
(14, '2022-09-04 13:42:02', 1),
(15, '2022-09-04 13:44:24', 1),
(16, '2022-09-04 13:45:05', 1),
(17, '2022-09-04 14:08:11', 1),
(18, '2022-09-04 14:09:23', 1),
(19, '2022-09-04 14:32:27', 1),
(20, '2022-09-04 14:34:13', 1),
(21, '2022-09-04 14:37:20', 1),
(22, '2022-09-04 14:58:56', 1),
(23, '2022-09-04 16:23:44', 1),
(24, '2022-09-04 20:48:08', 1),
(25, '2022-09-04 21:01:23', 1),
(26, '2022-09-04 21:02:55', 1),
(27, '2022-09-04 21:03:25', 1),
(28, '2022-09-04 21:05:00', 1),
(29, '2022-09-04 21:07:00', 1),
(30, '2022-09-04 21:24:34', 1),
(31, '2022-09-04 21:26:56', 1),
(32, '2022-09-04 21:28:41', 1),
(33, '2022-09-04 21:28:58', 1),
(34, '2022-09-06 10:34:42', 1),
(35, '2022-09-06 18:41:11', 1),
(36, '2022-09-08 10:15:48', 1),
(37, '2022-09-08 13:53:54', 1),
(38, '2022-09-09 22:12:42', 1),
(39, '2022-09-11 19:28:54', 1),
(40, '2022-09-12 15:45:38', 1),
(41, '2022-09-14 21:26:41', 1),
(42, '2022-09-16 23:01:56', 1),
(43, '2022-09-16 23:04:15', 1);

-- --------------------------------------------------------

--
-- Table structure for table `employee_manage_product`
--

DROP TABLE IF EXISTS `employee_manage_product`;
CREATE TABLE IF NOT EXISTS `employee_manage_product` (
  `eno` int(5) NOT NULL,
  `pno` int(5) NOT NULL,
  `time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  KEY `eno` (`eno`),
  KEY `pno` (`pno`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employee_manage_product`
--

INSERT INTO `employee_manage_product` (`eno`, `pno`, `time`) VALUES
(45, 0, '2022-09-16 22:55:54'),
(300, 0, '2022-09-16 22:56:03');

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
CREATE TABLE IF NOT EXISTS `orders` (
  `oid` int(5) NOT NULL AUTO_INCREMENT COMMENT 'Order ID number',
  `order_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Order date',
  `price` int(6) NOT NULL COMMENT 'Order total price',
  `eno` int(5) NOT NULL COMMENT 'Employee ID number',
  PRIMARY KEY (`oid`),
  KEY `eno` (`eno`)
) ENGINE=MyISAM AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `orders`
--

INSERT INTO `orders` (`oid`, `order_date`, `price`, `eno`) VALUES
(1, '2022-09-04 13:46:33', 85, 1),
(2, '2022-09-04 14:08:45', 815, 1),
(3, '2022-09-04 14:09:45', 460, 1),
(4, '2022-09-04 14:32:40', 60, 1),
(5, '2022-09-04 14:34:22', 60, 1),
(6, '2022-09-04 14:35:14', 220, 1),
(7, '2022-09-04 20:49:25', 1260, 1),
(8, '2022-09-04 21:29:12', 535, 1),
(9, '2022-09-06 10:35:37', 1545, 1),
(10, '2022-09-09 22:14:38', 60, 1),
(11, '2022-09-16 22:37:21', 150, 0),
(12, '2022-09-16 22:38:09', 665, 0),
(13, '2022-09-16 22:39:29', 275, 0);

-- --------------------------------------------------------

--
-- Table structure for table `orders_has_products`
--

DROP TABLE IF EXISTS `orders_has_products`;
CREATE TABLE IF NOT EXISTS `orders_has_products` (
  `ono` int(5) NOT NULL COMMENT 'Order ID number',
  `pno` int(5) NOT NULL COMMENT 'Product ID number',
  `unit_quantity` int(5) NOT NULL COMMENT 'Ordered product quantity',
  KEY `ono` (`ono`),
  KEY `pno` (`pno`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `orders_has_products`
--

INSERT INTO `orders_has_products` (`ono`, `pno`, `unit_quantity`) VALUES
(1, 2, 1),
(1, 9, 2),
(2, 2, 1),
(2, 9, 2),
(2, 14, 3),
(2, 18, 2),
(3, 9, 3),
(3, 4, 2),
(4, 1, 1),
(5, 1, 1),
(6, 15, 2),
(6, 17, 4),
(8, 2, 3),
(7, 6, 2),
(7, 1, 1),
(8, 4, 2),
(9, 3, 5),
(9, 17, 1),
(10, 1, 1),
(11, 2, 2),
(11, 15, 3),
(12, 6, 1),
(12, 13, 1),
(13, 13, 2),
(13, 15, 1),
(13, 12, 1);

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
CREATE TABLE IF NOT EXISTS `product` (
  `pid` int(5) NOT NULL AUTO_INCREMENT,
  `p_name` varchar(15) NOT NULL,
  `brand` varchar(15) NOT NULL,
  `avail_quantity` int(5) NOT NULL,
  `manu_date` date NOT NULL,
  `expire_date` date NOT NULL,
  `unit_price` int(6) NOT NULL,
  `image` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`pid`)
) ENGINE=MyISAM AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`pid`, `p_name`, `brand`, `avail_quantity`, `manu_date`, `expire_date`, `unit_price`, `image`) VALUES
(1, 'Antihistamines', 'Pfizer', 147, '2022-08-01', '2022-09-30', 60, 'C:\\Images\\Antihistamines.jpg'),
(2, 'Atorvastatin', 'Roche', 245, '2022-08-01', '2022-10-09', 45, 'C:\\Images\\atorvastatin.jpg'),
(3, 'Brufen', 'Novartis', 94, '2022-08-01', '2022-09-30', 300, 'C:\\Images\\brufen.jpg'),
(4, 'Calcium', 'Merck', 498, '2022-08-01', '2022-09-30', 200, 'C:\\Images\\Calcium.jpg'),
(5, 'Citrizine', 'Sanofi', 47, '2022-08-01', '2022-09-30', 120, 'C:\\Images\\citrizine.jpg'),
(6, 'Gastrodin', 'Citrizet', 17, '2022-08-01', '2022-09-30', 600, 'C:\\Images\\Gastrodin.jpg'),
(7, 'Gliclazide', 'AbbVie', 45, '2022-08-01', '2022-09-30', 300, 'C:\\Images\\gliclazide.jpg'),
(8, 'Levothyroxine', 'Takeda', 25, '2022-08-01', '2022-09-30', 800, 'C:\\Images\\Levothyroxine.jpg'),
(9, 'Losartan', 'Shanghai', 600, '2022-08-01', '2022-09-30', 20, 'C:\\Images\\Losartan1.jpg'),
(10, 'losartan', 'Pfizer ', 100, '2022-08-01', '2022-09-30', 65, 'C:\\Images\\losartan.jpg'),
(11, 'Omeprazole', 'Novartis', 20, '2022-08-01', '2022-09-30', 350, 'C:\\Images\\Omeprazole.jpg'),
(12, 'Paracetamol', 'Panadol', 499, '2022-08-01', '2022-09-30', 125, 'C:\\Images\\Panadol.jpg'),
(13, 'Piriton', ' Roche ', 147, '2022-08-01', '2022-09-30', 65, 'C:\\Images\\piriton.jpg'),
(14, 'Thyroxine', ' AbbVie ', 180, '2022-08-01', '2022-09-30', 200, 'C:\\Images\\thyroxine.jpg'),
(15, 'Vitamin A', ' Takeda ', 194, '2022-08-01', '2022-09-30', 20, 'C:\\Images\\vitaminA.jpg'),
(16, 'VitaminB', ' Takeda ', 200, '2022-08-01', '2022-09-30', 15, 'C:\\Images\\vitaminB.jpg'),
(17, 'VitaminC', ' Takeda ', 145, '2022-08-01', '2022-09-30', 45, 'C:\\Images\\vitaminC.jpg'),
(18, 'VitaminD', ' Takeda ', 175, '2022-08-01', '2022-09-30', 65, 'C:\\Images\\vitaminD.jpg'),
(19, 'VitaminE', ' Takeda ', 180, '2022-08-01', '2022-09-30', 97, 'C:\\Images\\vitaminE.jpg'),
(20, 'Zart', ' AbbVie ', 330, '2022-08-01', '2022-09-30', 230, 'C:\\Images\\Zart.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_lists`
--

DROP TABLE IF EXISTS `tbl_lists`;
CREATE TABLE IF NOT EXISTS `tbl_lists` (
  `list_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `list_name` varchar(50) NOT NULL,
  `list_description` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`list_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbl_lists`
--

INSERT INTO `tbl_lists` (`list_id`, `list_name`, `list_description`) VALUES
(1, 'To Do', '                         All the tasks that must be done soon.                     '),
(2, 'Doing', '                            All the Tasks that are currently being done.                      '),
(3, 'Done', 'All the Tasks that are completed                       '),
(7, 'Shopping', 'Tasks for Shopping');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_tasks`
--

DROP TABLE IF EXISTS `tbl_tasks`;
CREATE TABLE IF NOT EXISTS `tbl_tasks` (
  `task_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `task_name` varchar(150) NOT NULL,
  `task_description` text NOT NULL,
  `list_id` int(11) NOT NULL,
  `priority` varchar(10) NOT NULL,
  `deadline` date NOT NULL,
  PRIMARY KEY (`task_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbl_tasks`
--

INSERT INTO `tbl_tasks` (`task_id`, `task_name`, `task_description`, `list_id`, `priority`, `deadline`) VALUES
(2, 'icon Design', '                        This is urgent                         ', 1, 'High', '2020-06-03'),
(3, 'Buy Things', 'Okay Buy                      ', 3, 'Medium', '2020-06-12'),
(4, 'Web Page Design', 'All the Tasks for Web Page Design', 1, 'Medium', '2020-06-11'),
(5, 'Application Development', 'All the tasks', 1, 'Low', '2020-07-03'),
(6, 'SEO', 'Search Engine Optimization', 2, 'Medium', '2020-06-19'),
(7, 'Desktop Application Development', 'This is Important', 3, 'Low', '2020-06-26'),
(8, '4K Monitor', 'For Video Editing', 1, 'Medium', '2020-06-18');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
