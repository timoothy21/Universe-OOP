-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3307
-- Generation Time: Jan 22, 2023 at 10:44 AM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `universe`
--

-- --------------------------------------------------------

--
-- Table structure for table `account`
--

CREATE TABLE `account` (
  `id_account` int(11) NOT NULL,
  `fullname` varchar(100) DEFAULT NULL,
  `username` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `role` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `account`
--

INSERT INTO `account` (`id_account`, `fullname`, `username`, `email`, `password`, `role`) VALUES
(1, 'Novelita', 'novel', 'novel@gmail.com', 'novel123', 'User'),
(2, 'Timothy', 'timy', 'timothy21@gmail.com', 'timy123', 'Admin'),
(3, 'Universitas Bina Nusantara', 'binus', 'binus@gmail.com', 'binus123', 'Organizer'),
(4, 'Muhammad Syauqi', 'syauqi', 'msyauqi@gmail.com', 'syauqi123', 'Admin'),
(5, 'Bank Indonesia', 'bi', 'bi@gmail.com', 'bi123', 'Organizer'),
(6, 'Institut Teknologi Bandung', 'itb', 'itb@gmail.com', 'itb123', 'Organizer'),
(7, 'Universitas Internasional Batam', 'uib', 'uib@gmail.com', 'uib123', 'Organizer'),
(8, 'Temasek Polytechnic', 'tp', 'tp@gmail.com', 'tp123', 'Organizer'),
(9, 'Universitas Padjajaran', 'up', 'up@gmail.com', 'up123', 'Organizer'),
(10, 'Dimas Dani', 'dimas', 'dimas@gmail.com', 'dimas123', 'User'),
(11, 'Matthew Alex', 'matthew', 'matthew@gmail.com', 'matthew123', 'User');

-- --------------------------------------------------------

--
-- Table structure for table `enrolledevent`
--

CREATE TABLE `enrolledevent` (
  `id_enrolled` int(11) NOT NULL,
  `id_account` int(11) NOT NULL,
  `id_event` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `event`
--

CREATE TABLE `event` (
  `id_account` int(11) NOT NULL,
  `id_event` int(11) NOT NULL,
  `organizerName` varchar(100) DEFAULT NULL,
  `eventCategory` varchar(100) DEFAULT NULL,
  `quota` int(11) DEFAULT NULL,
  `Capacity` int(11) DEFAULT NULL,
  `fee` varchar(100) DEFAULT NULL,
  `steps` varchar(1000) DEFAULT NULL,
  `eventTitle` varchar(100) DEFAULT NULL,
  `eventDesc` varchar(1000) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `event`
--

INSERT INTO `event` (`id_account`, `id_event`, `organizerName`, `eventCategory`, `quota`, `Capacity`, `fee`, `steps`, `eventTitle`, `eventDesc`) VALUES
(3, 1, 'Universitas Bina Nusantara', 'Education', 0, 100, 'Free', '1. Enroll this event\n2. Join the group for more information!', 'Cyber Security Crime Attack in Real World', 'This webinar is held online via the zoom platform. This webinar will discuss how cybercrimes occur and what roles we can take to reduce the risk of these incidents occurring. This webinar is free and open to 100 participants. The webinar will be held January 27, 2023.'),
(6, 2, 'Institut Teknologi Bandung', 'Education', 0, 350, 'Rp 75.0000,-', '1. Enrolle this event.\r\n2. Join the group for more information!', 'Mental Health as A Student Awareness', 'This webinar is held online via the zoom platform. This webinar will discuss the role of students in maintaining mental health during college. This webinar is paid and open to 300 participants. The webinar will be held January 28, 2023.'),
(9, 3, 'Universitas Padjajaran', 'Finance', 0, 100, 'Rp. 10.000,-', '1. Enroll this event\n2. Join the group for more information!', 'Investasi itu sejak dini', 'Investasi terbaik sepanjang masa adalah investasi pada diri sendiri'),
(8, 4, 'Temasek Polytechnic', 'Technology', 0, 31, 'Rp. 450.000,-', '1. Enroll this event\n2. Join the group for more information!', 'World Youth Skills Day (Asia-Pacific) 2022', 'Organized by Temasek Polytechnic (TP), together with UNEVOC Centres, local and regional partners, the World Youth Skills Day (Asia-Pacific) 2022 initiative will bring out the voice of youths so that various stakeholders in TVET can better understand the attitudes of youths when it comes to skills needed for the future. '),
(7, 5, 'Universitas Internasional Batam', 'Social', 0, 1000, 'Rp. 12.000,-', '1. Enroll this event\n2. Join the group for more information!', 'Webinar “What Can You Do?”', 'Topik yang dibawakan oleh pembicara adalah “How to Incorporate Social Media Management to Private and Professional Account”. Dimana topik ini akan membahas tips ataupun cara-cara yang dapat digunakan dalam mengurus sosial media secara professional (akun bisnis) dan secara pribadi (akun pribadi).'),
(5, 6, 'Bank Indonesia', 'Finance', 0, 10, 'Rp. 75.000,-', '1. Enroll this event\n2. Join the group for more information!', 'Lomba Karya Ilmiah Stabilitas Sistem Keuangan Tahun 2021', 'Bank Indonesia menyelenggarakan Lomba Karya Ilmiah Stabilitas Sistem Keuangan (LKISSK) tahun 2021 dengan tema “Inovasi Asesmen dan Kebijakan Dalam Rangka Mendorong Intermediasi Sektor Keuangan Guna Mengakselerasi Pemulihan Ekonomi\".'),
(3, 7, 'Universitas Bina Nusantara', 'Technology', 0, 75, 'Free', '1. Enroll this event\n2. Join the group for more information!', 'TECHNO 2022', 'TECHNO merupakan kegiatan tahunan yang diselenggarakan oleh HIMTI BINUS dalam rangka menyambut mahasiswa - mahasiswi baru School of Computer Science dan Faculty of Computing and Media.'),
(3, 8, 'Universitas Bina Nusantara', 'Social', 0, 1000, 'Free', '1. Enroll this event\n2. Join the group for more information!', 'BNEC Social Event', 'To increase awareness about literacy, The 2020 BNEC Social Event took advantage of existing social media to increase awareness about reading.'),
(9, 9, 'Universitas Padjajaran', 'Economy', 0, 120, 'Rp. 250.000', '1. Enroll this event\n2. Join the group for more information!', 'Bootcamp Data Structure', 'Membuka pelatihan intensif selama 3 bulan bagi para freshmen jurusan Computer Science');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`id_account`);

--
-- Indexes for table `enrolledevent`
--
ALTER TABLE `enrolledevent`
  ADD PRIMARY KEY (`id_enrolled`),
  ADD KEY `id_account` (`id_account`),
  ADD KEY `id_event` (`id_event`);

--
-- Indexes for table `event`
--
ALTER TABLE `event`
  ADD PRIMARY KEY (`id_event`),
  ADD KEY `id_account` (`id_account`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `account`
--
ALTER TABLE `account`
  MODIFY `id_account` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `enrolledevent`
--
ALTER TABLE `enrolledevent`
  MODIFY `id_enrolled` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `event`
--
ALTER TABLE `event`
  MODIFY `id_event` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `enrolledevent`
--
ALTER TABLE `enrolledevent`
  ADD CONSTRAINT `id_account` FOREIGN KEY (`id_account`) REFERENCES `account` (`id_account`),
  ADD CONSTRAINT `id_event` FOREIGN KEY (`id_event`) REFERENCES `event` (`id_event`);

--
-- Constraints for table `event`
--
ALTER TABLE `event`
  ADD CONSTRAINT `event_ibfk_1` FOREIGN KEY (`id_account`) REFERENCES `account` (`id_account`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
