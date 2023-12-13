-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 25, 2021 at 08:06 PM
-- Server version: 10.4.17-MariaDB
-- PHP Version: 8.0.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `hotel_system`
--

-- --------------------------------------------------------

--
-- Table structure for table `assistante_details`
--

CREATE TABLE `assistante_details` (
  `id` int(5) NOT NULL,
  `hotel_id` varchar(20) NOT NULL,
  `name` varchar(60) NOT NULL,
  `contact` varchar(15) NOT NULL,
  `mail` varchar(30) NOT NULL,
  `officer_id` varchar(25) NOT NULL,
  `image` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `assistante_details`
--

INSERT INTO `assistante_details` (`id`, `hotel_id`, `name`, `contact`, `mail`, `officer_id`, `image`) VALUES
(6, 'j', 'j', 'j', 'j', '', 'C:\\Users\\user\\Documents\\dumidu\\13_-_1_-_Call.jpg'),
(7, 'e', 'e', 'e', 'e', '', 'C:\\Users\\user\\Documents\\dumidu\\13_-_1_-_Call.jpg'),
(9, 'i', 'i', 'i', 'i', 'i', 'C:\\Users\\user\\Documents\\dumidu\\13_-_1_-_Call.jpg'),
(10, 'g', 'g', 'g', 'g', 'l', 'C:\\Users\\user\\Documents\\dumidu\\concrete-blocks-aug232019-min.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `assistante_password`
--

CREATE TABLE `assistante_password` (
  `id` int(6) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `assistante_password`
--

INSERT INTO `assistante_password` (`id`, `username`, `password`) VALUES
(1, 'h', 'h1');

-- --------------------------------------------------------

--
-- Table structure for table `clients`
--

CREATE TABLE `clients` (
  `id` int(8) NOT NULL,
  `room_no` int(5) NOT NULL,
  `name` varchar(100) NOT NULL,
  `contact` varchar(18) NOT NULL,
  `mail` varchar(60) NOT NULL,
  `members` int(6) NOT NULL,
  `address` varchar(200) NOT NULL,
  `package` varchar(25) NOT NULL,
  `payment` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `clients`
--

INSERT INTO `clients` (`id`, `room_no`, `name`, `contact`, `mail`, `members`, `address`, `package`, `payment`) VALUES
(2, 2, 'Ravina', '0784564615', 'sdcsd', 3, 'scascas\nscdasdc\nsdcas', 'Full Board', 100000),
(3, 3, 'kjkbk', '65465', 'khonk', 4, 'fvefv', 'Full Board', 45451.5),
(4, 2, 'sdv', '546', 'ljlnol', 55, 'bsg', 'Full Board', 555),
(5, 4, 'lkl', '65464', 'ljpm', 4, 'lnjlkm', 'Full Board', 5000),
(6, 1, 'hhh', '555', 'kkk', 4, 'hbkj', 'Full Board', 5000),
(7, 3, 'h', '8', 'jjj', 4, 'sdcs', 'Full Board', 23),
(8, 5, 'hhh', '0232561', 'hghvubk', 50, 'fcghghhc', 'Half Board', 4502130),
(9, 6, 'r', 'r', 'r', 5, 'sdsdfv\ndfvsdfv\ndfvsdfv', 'Full Board', 5000),
(10, 4, 't', 't', 't', 4, 't,\nt,\nt\nt', 'Full Board', 6000);

-- --------------------------------------------------------

--
-- Table structure for table `officer_details`
--

CREATE TABLE `officer_details` (
  `id` int(8) NOT NULL,
  `hotel_id` varchar(30) NOT NULL,
  `name` varchar(60) NOT NULL,
  `contact` varchar(16) NOT NULL,
  `mail` varchar(50) NOT NULL,
  `image` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `officer_details`
--

INSERT INTO `officer_details` (`id`, `hotel_id`, `name`, `contact`, `mail`, `image`) VALUES
(1, 'h1', 'h1', 'h1', 'h1', ''),
(2, 'l', 'l', 'l', 'l', 'C:\\Users\\user\\Documents\\dumidu\\13_-_1_-_Call.jpg'),
(3, 'k', 'k', 'k', 'k', 'C:\\Users\\user\\Documents\\dumidu\\13_-_1_-_Call.jpg'),
(4, 'f', 'd', 'd', 'd', 'C:\\Users\\user\\Documents\\dumidu\\13_-_1_-_Call.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `officer_password`
--

CREATE TABLE `officer_password` (
  `id` int(3) NOT NULL,
  `username` varchar(15) NOT NULL,
  `password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `officer_password`
--

INSERT INTO `officer_password` (`id`, `username`, `password`) VALUES
(1, 'h', 'h2');

-- --------------------------------------------------------

--
-- Table structure for table `reservation`
--

CREATE TABLE `reservation` (
  `id` int(8) NOT NULL,
  `name` varchar(60) NOT NULL,
  `room_no` int(8) NOT NULL,
  `date_in` varchar(25) NOT NULL,
  `date_out` varchar(25) NOT NULL,
  `package` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `reservation`
--

INSERT INTO `reservation` (`id`, `name`, `room_no`, `date_in`, `date_out`, `package`) VALUES
(1, 'hhs', 2, '2021/5/4', '2021/5/5', 'Half Board'),
(3, 't', 4, '2021/5/4', 't', 'Full Board');

-- --------------------------------------------------------

--
-- Table structure for table `rooms`
--

CREATE TABLE `rooms` (
  `id` int(8) NOT NULL,
  `room_no` int(8) NOT NULL,
  `type` varchar(20) NOT NULL,
  `received` varchar(10) NOT NULL,
  `ac` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `rooms`
--

INSERT INTO `rooms` (`id`, `room_no`, `type`, `received`, `ac`) VALUES
(2, 2, 'Single Room', 'No', 'AC'),
(4, 4, 'Family Room', 'Yes', 'AC'),
(5, 5, 'Triple Room', 'No', 'Non AC'),
(6, 6, 'Triple Room', 'No', 'Non AC'),
(7, 7, 'Triple Room', 'No', 'Non AC');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `assistante_details`
--
ALTER TABLE `assistante_details`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `assistante_password`
--
ALTER TABLE `assistante_password`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `clients`
--
ALTER TABLE `clients`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `officer_details`
--
ALTER TABLE `officer_details`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `officer_password`
--
ALTER TABLE `officer_password`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `reservation`
--
ALTER TABLE `reservation`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `rooms`
--
ALTER TABLE `rooms`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `assistante_details`
--
ALTER TABLE `assistante_details`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `assistante_password`
--
ALTER TABLE `assistante_password`
  MODIFY `id` int(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `clients`
--
ALTER TABLE `clients`
  MODIFY `id` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `officer_details`
--
ALTER TABLE `officer_details`
  MODIFY `id` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `officer_password`
--
ALTER TABLE `officer_password`
  MODIFY `id` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `reservation`
--
ALTER TABLE `reservation`
  MODIFY `id` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `rooms`
--
ALTER TABLE `rooms`
  MODIFY `id` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
