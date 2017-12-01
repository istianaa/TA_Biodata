-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1:3307
-- Generation Time: 01 Des 2017 pada 11.44
-- Versi Server: 10.1.13-MariaDB
-- PHP Version: 5.5.35

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `biodata`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `inputan`
--

CREATE TABLE `inputan` (
  `Tnomor` varchar(10) NOT NULL,
  `Tnama` varchar(30) NOT NULL,
  `Tjeniskelamin` varchar(15) NOT NULL,
  `Tkelas` varchar(15) NOT NULL,
  `Ttanggallahir` date NOT NULL,
  `Talamat` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `inputan`
--

INSERT INTO `inputan` (`Tnomor`, `Tnama`, `Tjeniskelamin`, `Tkelas`, `Ttanggallahir`, `Talamat`) VALUES
('002', 'Ahmad fiqi', 'Laki-Laki', 'XI RPL 5', '2017-11-03', 'Pasuruan'),
('003', 'Yasinta Amalia', 'Perempuan', 'XI RPL 6', '2000-08-08', 'Tulungangung'),
('006', 'rumana', 'Perempuan', 'X TKJ 1', '2017-11-02', 'sumedang'),
('007', 'angga yusuf', 'Laki-Laki', 'X RPL 5', '2000-11-11', 'ijen'),
('008', 'apin', 'Laki-Laki', 'X RPL 5', '2017-11-08', 'Makasar'),
('009', 'risa', 'Perempuan', 'X RPL 5', '2017-11-04', 'surabaya');

-- --------------------------------------------------------

--
-- Struktur dari tabel `login`
--

CREATE TABLE `login` (
  `Tusername` varchar(20) NOT NULL,
  `Tpassword` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `login`
--

INSERT INTO `login` (`Tusername`, `Tpassword`) VALUES
('admin', '12345'),
('anggi', 'a123');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `inputan`
--
ALTER TABLE `inputan`
  ADD PRIMARY KEY (`Tnomor`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
