-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 17, 2024 at 01:11 AM
-- Server version: 10.4.25-MariaDB
-- PHP Version: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pfe_2024`
--

-- --------------------------------------------------------

--
-- Table structure for table `absenceetudiant`
--

CREATE TABLE `absenceetudiant` (
  `ID` int(11) NOT NULL,
  `id_etudiant` int(11) NOT NULL,
  `id_seance` int(11) NOT NULL,
  `Justification` tinyint(1) DEFAULT NULL,
  `Motif` varchar(255) DEFAULT NULL,
  `DocJustifAbsEtudiantID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `absenceetudiant`
--

INSERT INTO `absenceetudiant` (`ID`, `id_etudiant`, `id_seance`, `Justification`, `Motif`, `DocJustifAbsEtudiantID`) VALUES
(1, 1, 3, 0, '', 2),
(2, 142, 4, 0, '', NULL),
(3, 148, 4, 0, '', NULL),
(4, 151, 3, 0, '', NULL),
(5, 154, 3, 0, '', NULL),
(6, 154, 3, 0, '', NULL),
(7, 142, 3, 0, '', NULL),
(8, 145, 3, 0, '', NULL),
(9, 148, 3, 0, '', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `authentification`
--

CREATE TABLE `authentification` (
  `login` varchar(255) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `id_user` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `authentification`
--

INSERT INTO `authentification` (`login`, `password`, `id_user`) VALUES
('@oussamaelbakri', 'oussama', 1),
('@hassandriouch', 'hassan', 3),
('@medbouh', 'med', 4);

-- --------------------------------------------------------

--
-- Table structure for table `classe`
--

CREATE TABLE `classe` (
  `id_classe` int(11) NOT NULL,
  `id_classegenerique` int(11) NOT NULL,
  `annee_scolaire` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `classe`
--

INSERT INTO `classe` (`id_classe`, `id_classegenerique`, `annee_scolaire`) VALUES
(1, 1, '2023-2024'),
(2, 2, '2023-2024'),
(3, 3, '2023-2024'),
(4, 4, '2023-2024'),
(5, 5, '2023-2024'),
(6, 6, '2023-2024');

-- --------------------------------------------------------

--
-- Table structure for table `classegenerique`
--

CREATE TABLE `classegenerique` (
  `id_classegenerique` int(11) NOT NULL,
  `id_niveau` int(11) NOT NULL,
  `id_filiere` int(11) NOT NULL,
  `id_cycle` int(11) NOT NULL,
  `discription` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `classegenerique`
--

INSERT INTO `classegenerique` (`id_classegenerique`, `id_niveau`, `id_filiere`, `id_cycle`, `discription`) VALUES
(1, 1, 1, 1, 'Primaire - Informatique'),
(2, 2, 1, 1, 'Primaire - Sciences'),
(3, 2, 2, 2, 'Collège - Mathématiques'),
(4, 2, 2, 3, 'Collège - Français'),
(5, 3, 3, 2, 'Secondaire - Physique'),
(6, 3, 3, 3, 'Secondaire - Chimie');

-- --------------------------------------------------------

--
-- Table structure for table `controle`
--

CREATE TABLE `controle` (
  `ID_controle` int(11) NOT NULL,
  `Nom` varchar(255) NOT NULL,
  `id_module` int(11) NOT NULL,
  `id_matiere` int(11) NOT NULL,
  `Duree` int(11) NOT NULL,
  `id_classe` int(11) NOT NULL,
  `id_enseignant` int(11) NOT NULL,
  `etat` text NOT NULL,
  `observation` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `controle`
--

INSERT INTO `controle` (`ID_controle`, `Nom`, `id_module`, `id_matiere`, `Duree`, `id_classe`, `id_enseignant`, `etat`, `observation`) VALUES
(1, 'Exam Math Algebre', 1, 1, 120, 1, 1, 'En cours', 'observation1');

-- --------------------------------------------------------

--
-- Table structure for table `cycle`
--

CREATE TABLE `cycle` (
  `id_cycle` int(11) NOT NULL,
  `code` varchar(50) NOT NULL,
  `nom` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `cycle`
--

INSERT INTO `cycle` (`id_cycle`, `code`, `nom`) VALUES
(1, 'PRI', 'Primaire'),
(2, 'COL', 'Collège'),
(3, 'SEC', 'Secondaire');

-- --------------------------------------------------------

--
-- Table structure for table `docjustifabsetudiant`
--

CREATE TABLE `docjustifabsetudiant` (
  `ID` int(11) NOT NULL,
  `Nom` varchar(255) DEFAULT NULL,
  `DateDepot` date DEFAULT NULL,
  `DateDebut` date DEFAULT NULL,
  `DateFin` date DEFAULT NULL,
  `Emplacement` text DEFAULT NULL,
  `Type` varchar(255) DEFAULT NULL,
  `DateUpload` date DEFAULT NULL,
  `Observation` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `docjustifabsetudiant`
--

INSERT INTO `docjustifabsetudiant` (`ID`, `Nom`, `DateDepot`, `DateDebut`, `DateFin`, `Emplacement`, `Type`, `DateUpload`, `Observation`) VALUES
(1, 'oussama', '2024-04-03', '2024-04-03', '2024-04-09', 'C:\\Users\\oussa\\OneDrive\\Documents\\Rapport de stage copref.pdf', 'Attestation de décès', '2024-04-28', 'andka'),
(2, 'joda', '2024-04-02', '2024-04-17', '2024-04-09', 'C:\\Users\\oussa\\OneDrive\\Images\\annee2.jpeg', 'Certificat médical', '2024-04-28', 'djaoi');

-- --------------------------------------------------------

--
-- Table structure for table `enseignant`
--

CREATE TABLE `enseignant` (
  `id_enseignant` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `id_cycle` int(11) NOT NULL,
  `id_specialite` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `enseignant`
--

INSERT INTO `enseignant` (`id_enseignant`, `id_user`, `id_cycle`, `id_specialite`) VALUES
(1, 3, 3, 1);

-- --------------------------------------------------------

--
-- Table structure for table `etudiant`
--

CREATE TABLE `etudiant` (
  `id_etudiant` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `id_classe` int(11) NOT NULL,
  `id_filiere` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `etudiant`
--

INSERT INTO `etudiant` (`id_etudiant`, `id_user`, `id_classe`, `id_filiere`) VALUES
(1, 1, 1, 1),
(142, 151, 1, 1),
(143, 152, 4, 2),
(144, 153, 5, 3),
(145, 154, 1, 1),
(146, 155, 4, 2),
(147, 156, 5, 3),
(148, 157, 1, 1),
(149, 158, 4, 2),
(150, 159, 5, 3),
(151, 160, 1, 1),
(152, 161, 4, 2),
(153, 162, 5, 3),
(154, 163, 1, 1),
(155, 164, 4, 2),
(156, 165, 5, 3),
(159, 169, 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `filiere`
--

CREATE TABLE `filiere` (
  `id_filiere` int(11) NOT NULL,
  `code` varchar(50) NOT NULL,
  `nom` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `filiere`
--

INSERT INTO `filiere` (`id_filiere`, `code`, `nom`) VALUES
(1, 'SM', 'Science Math'),
(2, 'SPC', 'Science Physique et Chimie'),
(3, 'STE', 'Science de Technologie Electrique'),
(4, 'STM', 'Science de Technologie Mecanique');

-- --------------------------------------------------------

--
-- Table structure for table `matiere`
--

CREATE TABLE `matiere` (
  `id_matiere` int(11) NOT NULL,
  `id_module` int(11) NOT NULL,
  `Nom` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `matiere`
--

INSERT INTO `matiere` (`id_matiere`, `id_module`, `Nom`) VALUES
(1, 1, 'Algèbre'),
(2, 1, 'Géométrie'),
(3, 2, 'Grammaire'),
(4, 2, 'Littérature'),
(5, 3, 'Histoire ancienne'),
(6, 3, 'Géographie moderne'),
(7, 4, 'Biologie'),
(8, 4, 'Physique'),
(9, 5, 'Anglais'),
(10, 5, 'Espagnol'),
(11, 6, 'Dessin'),
(12, 6, 'Peinture');

-- --------------------------------------------------------

--
-- Table structure for table `module`
--

CREATE TABLE `module` (
  `id_module` int(11) NOT NULL,
  `Nom` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `module`
--

INSERT INTO `module` (`id_module`, `Nom`) VALUES
(1, 'Mathématiques'),
(2, 'Français'),
(3, 'Histoire-Géographie'),
(4, 'Sciences'),
(5, 'Langues étrangères'),
(6, 'Arts plastiques');

-- --------------------------------------------------------

--
-- Table structure for table `niveau`
--

CREATE TABLE `niveau` (
  `id_niveau` int(11) NOT NULL,
  `code` varchar(255) NOT NULL,
  `nom` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `niveau`
--

INSERT INTO `niveau` (`id_niveau`, `code`, `nom`) VALUES
(1, '1ère', '1ère Année'),
(2, '2ème', '2ème Année'),
(3, '3ème', '3ème Année');

-- --------------------------------------------------------

--
-- Table structure for table `notes`
--

CREATE TABLE `notes` (
  `id_note` int(11) NOT NULL,
  `id_etudiant` int(11) NOT NULL,
  `id_controle` int(11) NOT NULL,
  `Note CC` float NOT NULL,
  `Note TP` float NOT NULL,
  `Note Examen` float NOT NULL,
  `date` date NOT NULL DEFAULT current_timestamp(),
  `etat` varchar(255) DEFAULT NULL,
  `obesrvation` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `notes`
--

INSERT INTO `notes` (`id_note`, `id_etudiant`, `id_controle`, `Note CC`, `Note TP`, `Note Examen`, `date`, `etat`, `obesrvation`) VALUES
(1, 1, 1, 15, 9, 5, '2024-05-13', NULL, NULL),
(2, 142, 1, 15, 17, 19, '2024-05-13', NULL, NULL),
(3, 145, 1, 10, 10, 10, '2024-05-13', NULL, NULL),
(4, 148, 1, 19, 19, 19, '2024-05-13', NULL, NULL),
(5, 151, 1, 13, 14, 13, '2024-05-13', NULL, NULL),
(6, 154, 1, 13, 2, 1, '2024-05-16', NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `seance`
--

CREATE TABLE `seance` (
  `id_seance` int(11) NOT NULL,
  `id_seancegenerique` int(11) DEFAULT NULL,
  `date` date NOT NULL,
  `etat` varchar(255) NOT NULL,
  `observation` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `seance`
--

INSERT INTO `seance` (`id_seance`, `id_seancegenerique`, `date`, `etat`, `observation`) VALUES
(3, 1, '2023-04-10', 'Active', 'Observation 1'),
(4, 2, '2023-05-11', 'Active', 'Observation 2');

-- --------------------------------------------------------

--
-- Table structure for table `seancegenerique`
--

CREATE TABLE `seancegenerique` (
  `id_seancegenerique` int(11) NOT NULL,
  `id_module` int(11) NOT NULL,
  `id_matiere` int(11) NOT NULL,
  `id_enseignant` int(11) NOT NULL,
  `id_classe` int(11) NOT NULL,
  `jour` varchar(10) DEFAULT NULL,
  `heuredeb` varchar(20) NOT NULL,
  `heurefin` varchar(20) DEFAULT NULL,
  `observation` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `seancegenerique`
--

INSERT INTO `seancegenerique` (`id_seancegenerique`, `id_module`, `id_matiere`, `id_enseignant`, `id_classe`, `jour`, `heuredeb`, `heurefin`, `observation`) VALUES
(1, 1, 1, 1, 1, 'Lundi', '08:00', '10:00', 'Observation 1'),
(2, 2, 2, 1, 2, 'Mardi', '10:00', '12:00', 'Observation 2');

-- --------------------------------------------------------

--
-- Table structure for table `specialite`
--

CREATE TABLE `specialite` (
  `id_specialite` int(11) NOT NULL,
  `nom` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `specialite`
--

INSERT INTO `specialite` (`id_specialite`, `nom`) VALUES
(1, 'Informatique'),
(2, 'Électronique'),
(3, 'Mécanique'),
(4, 'Génie civil'),
(5, 'Biologie'),
(6, 'Langues étrangères'),
(7, 'Histoire-Géographie'),
(8, 'Arts plastiques');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id_user` int(11) NOT NULL,
  `nom` varchar(255) NOT NULL,
  `prenom` varchar(255) NOT NULL,
  `email` text NOT NULL,
  `role` varchar(255) NOT NULL,
  `datenais` varchar(255) NOT NULL,
  `lieunais` varchar(255) NOT NULL,
  `Telephone` varchar(50) DEFAULT NULL,
  `sexe` varchar(50) DEFAULT NULL,
  `photo` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id_user`, `nom`, `prenom`, `email`, `role`, `datenais`, `lieunais`, `Telephone`, `sexe`, `photo`) VALUES
(1, 'oussama', 'el bakri', 'oussamaelbakri92@gmail.com', 'student', '30/08/2002', 'arbaoua', '0617057583', 'M', NULL),
(3, 'driouch', 'hassan', 'hassandriouch@gmail.com', 'teacher', '11/11/2002', 'sale', '0700000000', 'M', NULL),
(4, 'bouhaddou', 'mouhamed', 'mouhamedbouh@gmail.com', 'admin', '17/01/2003', 'kenitra', '0705060303', 'M', NULL),
(151, 'Youssef', 'Ahmed', '05/05/2000', 'student', 'Marrakech', 'youssef.ahmed@example.com', '123456789', 'M', NULL),
(152, 'Sara', 'Ali', '10/10/2001', 'student', 'Agadir', 'sara.ali@example.com', '987654321', 'F', NULL),
(153, 'Ahmed', 'Omar', '15/03/2002', 'student', 'Tangier', 'ahmed.omar@example.com', '456789123', 'M', NULL),
(154, 'Hajar', 'Nabil', '20/08/2003', 'student', 'Fes', 'hajar.nabil@example.com', '987123456', 'F', NULL),
(155, 'Omar', 'Hassan', '25/12/2004', 'student', 'Rabat', 'omar.hassan@example.com', '654789123', 'M', NULL),
(156, 'Nadia', 'Khalid', '30/06/2005', 'student', 'Casablanca', 'nadia.khalid@example.com', '789456123', 'F', NULL),
(157, 'Yasmine', 'Sami', '03/04/2006', 'student', 'Meknes', 'yasmine.sami@example.com', '369852147', 'F', NULL),
(158, 'Ali', 'Laila', '08/09/2007', 'student', 'Oujda', 'ali.laila@example.com', '258741369', 'M', NULL),
(159, 'Amina', 'Khalid', '12/11/2008', 'student', 'Tetouan', 'amina.khalid@example.com', '147852369', 'F', NULL),
(160, 'Hassan', 'Fatima', '17/02/2009', 'student', 'Essaouira', 'hassan.fatima@example.com', '987654321', 'M', NULL),
(161, 'Khalid', 'Yasmina', '22/05/2010', 'student', 'Chefchaouen', 'khalid.yasmina@example.com', '369258147', 'M', NULL),
(162, 'Saida', 'Hamza', '27/08/2011', 'student', 'Ouarzazate', 'saida.hamza@example.com', '789456123', 'F', NULL),
(163, 'Samir', 'Rachida', '01/12/2012', 'student', 'Taza', 'samir.rachida@example.com', '321654987', 'M', NULL),
(164, 'Lina', 'Omar', '06/03/2013', 'student', 'Beni Mellal', 'lina.omar@example.com', '963258741', 'F', NULL),
(165, 'Abdel', 'Salma', '11/07/2014', 'student', 'Dakhla', 'abdel.salma@example.com', '852741963', 'M', NULL),
(169, 'ouchen', 'souhail', 'joidasjds', 'student', '2024-05-09', 'sale', '06177171', 'M', 'C:\\Users\\oussa\\OneDrive\\Images\\bacc.jpeg');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `absenceetudiant`
--
ALTER TABLE `absenceetudiant`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `fk_absenceetd_etudiant_fk` (`id_etudiant`),
  ADD KEY `fk_absenceetd_seance_fk` (`id_seance`),
  ADD KEY `fk_absenceetd_doc_fk` (`DocJustifAbsEtudiantID`);

--
-- Indexes for table `authentification`
--
ALTER TABLE `authentification`
  ADD KEY `fk_auth_user` (`id_user`);

--
-- Indexes for table `classe`
--
ALTER TABLE `classe`
  ADD PRIMARY KEY (`id_classe`),
  ADD KEY `fk_classe_classegenerique` (`id_classegenerique`);

--
-- Indexes for table `classegenerique`
--
ALTER TABLE `classegenerique`
  ADD PRIMARY KEY (`id_classegenerique`),
  ADD KEY `fk_classegenerique_niveau` (`id_niveau`),
  ADD KEY `fk_classegenerique_cycle` (`id_cycle`),
  ADD KEY `fk_classegenerique_filiere` (`id_filiere`);

--
-- Indexes for table `controle`
--
ALTER TABLE `controle`
  ADD PRIMARY KEY (`ID_controle`),
  ADD KEY `fk_controle_module` (`id_module`),
  ADD KEY `fk_controle_matiere` (`id_matiere`),
  ADD KEY `fk_controle_classe` (`id_classe`),
  ADD KEY `fk_controle_enseignant` (`id_enseignant`);

--
-- Indexes for table `cycle`
--
ALTER TABLE `cycle`
  ADD PRIMARY KEY (`id_cycle`);

--
-- Indexes for table `docjustifabsetudiant`
--
ALTER TABLE `docjustifabsetudiant`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `enseignant`
--
ALTER TABLE `enseignant`
  ADD PRIMARY KEY (`id_enseignant`),
  ADD KEY `fk_enseignant_cycle` (`id_cycle`),
  ADD KEY `fk_enseignant_specialite` (`id_specialite`),
  ADD KEY `fk_enseignant_user` (`id_user`);

--
-- Indexes for table `etudiant`
--
ALTER TABLE `etudiant`
  ADD PRIMARY KEY (`id_etudiant`),
  ADD KEY `fk_etudiant_filiere` (`id_filiere`),
  ADD KEY `fk_etudiant_classe` (`id_classe`),
  ADD KEY `fk_etudiant_user` (`id_user`);

--
-- Indexes for table `filiere`
--
ALTER TABLE `filiere`
  ADD PRIMARY KEY (`id_filiere`);

--
-- Indexes for table `matiere`
--
ALTER TABLE `matiere`
  ADD PRIMARY KEY (`id_matiere`),
  ADD KEY `fk_matiere_module` (`id_module`);

--
-- Indexes for table `module`
--
ALTER TABLE `module`
  ADD PRIMARY KEY (`id_module`);

--
-- Indexes for table `niveau`
--
ALTER TABLE `niveau`
  ADD PRIMARY KEY (`id_niveau`);

--
-- Indexes for table `notes`
--
ALTER TABLE `notes`
  ADD PRIMARY KEY (`id_note`),
  ADD KEY `fk_note_controle` (`id_controle`),
  ADD KEY `fk_note_etudiant` (`id_etudiant`);

--
-- Indexes for table `seance`
--
ALTER TABLE `seance`
  ADD PRIMARY KEY (`id_seance`),
  ADD KEY `fk_seance_seancegenerique` (`id_seancegenerique`);

--
-- Indexes for table `seancegenerique`
--
ALTER TABLE `seancegenerique`
  ADD PRIMARY KEY (`id_seancegenerique`),
  ADD KEY `fk_seancegenerique_enseignant` (`id_enseignant`),
  ADD KEY `fk_seancegenerique_matiere` (`id_matiere`),
  ADD KEY `fk_seancegenerique_module` (`id_module`),
  ADD KEY `fk_seancegenerique_classe` (`id_classe`);

--
-- Indexes for table `specialite`
--
ALTER TABLE `specialite`
  ADD PRIMARY KEY (`id_specialite`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id_user`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `absenceetudiant`
--
ALTER TABLE `absenceetudiant`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `classe`
--
ALTER TABLE `classe`
  MODIFY `id_classe` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `classegenerique`
--
ALTER TABLE `classegenerique`
  MODIFY `id_classegenerique` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `controle`
--
ALTER TABLE `controle`
  MODIFY `ID_controle` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `cycle`
--
ALTER TABLE `cycle`
  MODIFY `id_cycle` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `docjustifabsetudiant`
--
ALTER TABLE `docjustifabsetudiant`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `enseignant`
--
ALTER TABLE `enseignant`
  MODIFY `id_enseignant` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `etudiant`
--
ALTER TABLE `etudiant`
  MODIFY `id_etudiant` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=160;

--
-- AUTO_INCREMENT for table `filiere`
--
ALTER TABLE `filiere`
  MODIFY `id_filiere` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `matiere`
--
ALTER TABLE `matiere`
  MODIFY `id_matiere` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `module`
--
ALTER TABLE `module`
  MODIFY `id_module` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `niveau`
--
ALTER TABLE `niveau`
  MODIFY `id_niveau` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `notes`
--
ALTER TABLE `notes`
  MODIFY `id_note` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `seance`
--
ALTER TABLE `seance`
  MODIFY `id_seance` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `seancegenerique`
--
ALTER TABLE `seancegenerique`
  MODIFY `id_seancegenerique` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `specialite`
--
ALTER TABLE `specialite`
  MODIFY `id_specialite` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id_user` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=170;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `absenceetudiant`
--
ALTER TABLE `absenceetudiant`
  ADD CONSTRAINT `fk_absenceetd_doc_fk` FOREIGN KEY (`DocJustifAbsEtudiantID`) REFERENCES `docjustifabsetudiant` (`ID`),
  ADD CONSTRAINT `fk_absenceetd_etudiant_fk` FOREIGN KEY (`id_etudiant`) REFERENCES `etudiant` (`id_etudiant`) ON DELETE CASCADE,
  ADD CONSTRAINT `fk_absenceetd_seance_fk` FOREIGN KEY (`id_seance`) REFERENCES `seance` (`id_seance`) ON DELETE CASCADE;

--
-- Constraints for table `authentification`
--
ALTER TABLE `authentification`
  ADD CONSTRAINT `fk_auth_user` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`);

--
-- Constraints for table `classe`
--
ALTER TABLE `classe`
  ADD CONSTRAINT `fk_classe_classegenerique` FOREIGN KEY (`id_classegenerique`) REFERENCES `classegenerique` (`id_classegenerique`);

--
-- Constraints for table `classegenerique`
--
ALTER TABLE `classegenerique`
  ADD CONSTRAINT `fk_classegenerique_cycle` FOREIGN KEY (`id_cycle`) REFERENCES `cycle` (`id_cycle`),
  ADD CONSTRAINT `fk_classegenerique_filiere` FOREIGN KEY (`id_filiere`) REFERENCES `filiere` (`id_filiere`),
  ADD CONSTRAINT `fk_classegenerique_niveau` FOREIGN KEY (`id_niveau`) REFERENCES `niveau` (`id_niveau`);

--
-- Constraints for table `controle`
--
ALTER TABLE `controle`
  ADD CONSTRAINT `fk_controle_classe` FOREIGN KEY (`id_classe`) REFERENCES `classe` (`id_classe`) ON DELETE CASCADE,
  ADD CONSTRAINT `fk_controle_enseignant` FOREIGN KEY (`id_enseignant`) REFERENCES `enseignant` (`id_enseignant`),
  ADD CONSTRAINT `fk_controle_matiere` FOREIGN KEY (`id_matiere`) REFERENCES `matiere` (`id_matiere`) ON DELETE CASCADE,
  ADD CONSTRAINT `fk_controle_module` FOREIGN KEY (`id_module`) REFERENCES `module` (`id_module`) ON DELETE CASCADE;

--
-- Constraints for table `enseignant`
--
ALTER TABLE `enseignant`
  ADD CONSTRAINT `fk_enseignant_cycle` FOREIGN KEY (`id_cycle`) REFERENCES `cycle` (`id_cycle`),
  ADD CONSTRAINT `fk_enseignant_specialite` FOREIGN KEY (`id_specialite`) REFERENCES `specialite` (`id_specialite`),
  ADD CONSTRAINT `fk_enseignant_user` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `etudiant`
--
ALTER TABLE `etudiant`
  ADD CONSTRAINT `fk_etudiant_classe` FOREIGN KEY (`id_classe`) REFERENCES `classe` (`id_classe`),
  ADD CONSTRAINT `fk_etudiant_filiere` FOREIGN KEY (`id_filiere`) REFERENCES `filiere` (`id_filiere`),
  ADD CONSTRAINT `fk_etudiant_user` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`) ON DELETE CASCADE;

--
-- Constraints for table `matiere`
--
ALTER TABLE `matiere`
  ADD CONSTRAINT `fk_matiere_module` FOREIGN KEY (`id_module`) REFERENCES `module` (`id_module`);

--
-- Constraints for table `notes`
--
ALTER TABLE `notes`
  ADD CONSTRAINT `fk_note_controle` FOREIGN KEY (`id_controle`) REFERENCES `controle` (`ID_controle`) ON DELETE CASCADE,
  ADD CONSTRAINT `fk_note_etudiant` FOREIGN KEY (`id_etudiant`) REFERENCES `etudiant` (`id_etudiant`) ON DELETE CASCADE;

--
-- Constraints for table `seance`
--
ALTER TABLE `seance`
  ADD CONSTRAINT `fk_seance_seancegenerique` FOREIGN KEY (`id_seancegenerique`) REFERENCES `seancegenerique` (`id_seancegenerique`);

--
-- Constraints for table `seancegenerique`
--
ALTER TABLE `seancegenerique`
  ADD CONSTRAINT `fk_seancegenerique_classe` FOREIGN KEY (`id_classe`) REFERENCES `classe` (`id_classe`),
  ADD CONSTRAINT `fk_seancegenerique_enseignant` FOREIGN KEY (`id_enseignant`) REFERENCES `enseignant` (`id_enseignant`),
  ADD CONSTRAINT `fk_seancegenerique_matiere` FOREIGN KEY (`id_matiere`) REFERENCES `matiere` (`id_matiere`),
  ADD CONSTRAINT `fk_seancegenerique_module` FOREIGN KEY (`id_module`) REFERENCES `module` (`id_module`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
