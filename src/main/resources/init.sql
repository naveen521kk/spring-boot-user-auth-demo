-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Jul 01, 2024 at 12:48 PM
-- Server version: 8.0.27
-- PHP Version: 7.4.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `users_test`
--

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `user_id` bigint NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) DEFAULT NULL,
  `enabled` bit(1) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role` varchar(255) NOT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `username` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`user_id`, `created_at`, `enabled`, `password`, `role`, `updated_at`, `username`, `email`, `name`) VALUES
(4, '2024-07-01 14:08:08.860515', b'1', '$2a$10$MSyL3ucQgixqymzL0EEjQOMfqnjYfX55Ge4rEEaqs1t/LRdEXoVtS', 'ROLE_USER', '2024-07-01 14:08:08.860515', 'abc', '', 'abc it\'s me'),
(5, '2024-07-01 15:08:38.204074', b'1', '$2a$10$NQ1V9oZ5oQl2KZyeck1lFO/TpB4v75klrO9mvQoOhda/UOgwckkk6', 'ROLE_USER', '2024-07-01 15:08:38.204074', 'naveen', 'naveen521kk@gmail.com', 'Naveen M K'),
(6, '2024-07-01 15:20:14.719502', b'1', '$2a$10$m0dD6llfEMFDOdjdE7auTOESygi9RKAKxYgv4ZIIgN2pcuXQ5uUTG', 'ROLE_USER', '2024-07-01 15:20:14.719502', 'me', 'def@a.com', 'abc');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
