-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Client :  127.0.0.1
-- Généré le :  Mar 30 Mai 2017 à 15:27
-- Version du serveur :  5.7.14
-- Version de PHP :  5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `coursenligne`
--

-- --------------------------------------------------------

--
-- Structure de la table `anneeauthorisee`
--

CREATE TABLE `anneeauthorisee` (
  `_id` int(11) NOT NULL,
  `Intitule_id` varchar(50) DEFAULT NULL,
  `Annee` text NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `anneeauthorisee`
--

INSERT INTO `anneeauthorisee` (`_id`, `Intitule_id`, `Annee`) VALUES
(70, 'HMMA202', 'M2'),
(69, 'HMMA201', 'M2'),
(68, 'HMMA102', 'M1'),
(67, 'HMMA101', 'M1'),
(66, 'HLMA302', 'L3'),
(65, 'HLMA301', 'L3'),
(64, 'HLMA202', 'L2'),
(63, 'HLMA201', 'L2'),
(62, 'HLMA102', 'L1'),
(61, 'HLMA101', 'L1'),
(60, 'HBI2', 'None'),
(59, 'HBI1', 'None'),
(58, 'HMBI202', 'M2'),
(57, 'HMBI201', 'M2'),
(56, 'HMBI102', 'M1'),
(55, 'HMBI101', 'M1'),
(54, 'HLBI302', 'L3'),
(53, 'HLBI301', 'L3'),
(52, 'HLBI202', 'L2'),
(51, 'HLBI201', 'L2'),
(50, 'HLBI102', 'L1'),
(49, 'HLBI101', 'L1'),
(48, 'HIN2', 'None'),
(47, 'HIN1', 'None'),
(46, 'HMIN202', 'M2'),
(45, 'HMIN201', 'M2'),
(44, 'HMIN102', 'M1'),
(43, 'HMIN101', 'M1'),
(42, 'HLIN302', 'L3'),
(41, 'HLIN301', 'L3'),
(40, 'HLIN202', 'L2'),
(39, 'HLIN201', 'L2'),
(38, 'HLIN102', 'L1'),
(37, 'HLIN101', 'L1'),
(71, 'HMA1', 'None'),
(72, 'HMA2', 'None');

-- --------------------------------------------------------

--
-- Structure de la table `cours`
--

CREATE TABLE `cours` (
  `_id` int(11) NOT NULL,
  `Intitule_id` varchar(25) DEFAULT NULL,
  `Nom` text NOT NULL,
  `Format` text NOT NULL,
  `Path` text NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `cours`
--

INSERT INTO `cours` (`_id`, `Intitule_id`, `Nom`, `Format`, `Path`) VALUES
(163, 'HLIN202', 'Cours 2 L2 info', 'pdf', 'http://www.fsr.ac.ma/cours/informatique/elbenani/Partie1.pdf'),
(162, 'HLIN201', 'Cours 1 L2 info', 'pdf', 'https://www.nimes.fr/fileadmin/directions/bibliotheques/informations_pratiques/Diaporama_initiation_informatique_nimes.pdf'),
(161, 'HLIN102', 'Cours 2 L1 info', 'pdf', 'https://www.lri.fr/~antoine/Courses/AGRO/TC/Cours-1A_SIx2.pdf'),
(160, 'HLIN101', 'Cours 1 L1 info', 'pdf', 'https://lipn.univ-paris13.fr/~dubacq/pdf/m1101/sys.pdf'),
(159, 'HMA2', 'Conférence vidéo math', 'video', 'fFXSUpW50a0'),
(158, 'HMA1', 'Cours vidéo math', 'video', '_AS7bwOsxd4'),
(157, 'HMMA202', 'Conférence vidéo M2 math', 'video', 'I1xM1bicp4U'),
(136, 'HLBI101', 'Cours vidéo L1 bio', 'video', 'Kx7x3XCJWwE'),
(137, 'HLBI102', 'Conférence vidéo L1 bio', 'video', 'UrdPaxfrbqs'),
(138, 'HLBI201', 'Cours vidéo L2 bio', 'video', 'muLu_W6ghh0'),
(139, 'HLBI202', 'Conférence vidéo L2 bio', 'video', '05UL3HuGoyQ'),
(140, 'HLBI301', 'Cours vidéo L3 bio', 'video', 'yIQ9oKZ7VxI'),
(141, 'HLBI302', 'Conférence vidéo L3 bio', 'video', 'eR1-K9Zx7Tk'),
(142, 'HMBI101', 'Cours vidéo M1 bio', 'video', 'BxZSeWZyt4k'),
(143, 'HMBI102', 'Conférence vidéo M1 bio', 'video', '1Tnq6CJM7ME'),
(144, 'HMBI201', 'Cours vidéo M2 bio', 'video', 'k3lvSCZ98uk'),
(145, 'HMBI202', 'Conférence vidéo M2 bio', 'video', '2_ebwFs'),
(146, 'HBI1', 'Cours vidéo bio', 'video', '9nMI1z6qun0'),
(147, 'HBI2', 'Conférence vidéo bio', 'video', 'S7ACIF34yQY'),
(148, 'HLMA101', 'Cours vidéo L1 math', 'video', 'vOLZ8wLWIbY'),
(149, 'HLMA102', 'Conférence vidéo L1 math', 'video', 'rLFUnCUyPko'),
(150, 'HLMA201', 'Cours vidéo L2 math', 'video', 'ur9smWN2HFg'),
(151, 'HLMA202', 'Conférence vidéo L2 math', 'video', 'qrpp1Mh8EDo'),
(152, 'HLMA301', 'Cours vidéo L3 math', 'video', 'TVW8UBTmT58'),
(153, 'HLMA302', 'Conférence vidéo L3 math', 'video', 'PKMVD7bD4cE'),
(154, 'HMMA101', 'Cours vidéo M1 math', 'video', 'vlFWMeBUTXo'),
(155, 'HMMA102', 'Conférence vidéo M1 math', 'video', 'dLwi_opxLxs'),
(156, 'HMMA201', 'Cours vidéo M2 math', 'video', 'gFpLfhXjLSY'),
(135, 'HIN2', 'Conférence vidéo info', 'video', 'oW6JxkAYhYc'),
(134, 'HIN1', 'Cours vidéo info', 'video', 'bGeZS7OwqYk'),
(124, 'HLIN101', 'Cours vidéo L1 info', 'video', '9qY-UYjvP0s'),
(125, 'HLIN102', 'Conférence vidéo L1 info', 'video', 'vzh7DLWJGa8'),
(126, 'HLIN201', 'Cours vidéo L2 info', 'video', '_UM3I4lY448'),
(127, 'HLIN202', 'Conférence vidéo L2 info', 'video', 'g9ePHxNq0Sg'),
(128, 'HLIN301', 'Cours vidéo L3 info', 'video', '6et7DkVUrSU'),
(129, 'HLIN302', 'Conférence vidéo L3 info', 'video', 'bQzpJnm9M4s'),
(130, 'HMIN101', 'Cours vidéo M1 info', 'video', 'Xsn-VBJqUM4'),
(131, 'HMIN102', 'Conférence vidéo M1 info', 'video', '706tS6pW0BA'),
(132, 'HMIN201', 'Cours vidéo M2 info', 'video', 'h2YpG4CF860'),
(133, 'HMIN202', 'Conférence vidéo M2 info', 'video', 'dZc8ZW9dJpk'),
(164, 'HLIN301', 'Cours 1 L3 info', 'pdf', 'http://www.fsr.ac.ma/cours/informatique/rziza/cours/Introduction_Reseau.pdf'),
(165, 'HLIN302', 'Cours 2 L3 info', 'pdf', 'https://www.enseignement.polytechnique.fr/profs/informatique/Francois.Morain/TC/X2003/Poly/polyX2003.pdf'),
(166, 'HMIN101', 'Cours 1 M1 info', 'pdf', 'http://www.bdaa.ca/biblio/apprenti/formatn/guidform.pdf'),
(167, 'HMIN102', 'Cours 2 M1 info', 'pdf', 'https://www.ibisc.univ-evry.fr/~hutzler/Cours/I11_InfoGene/Cours/CM1_HistoireInformatique.pdf'),
(168, 'HMIN201', 'Cours 1 M2 info', 'pdf', 'http://www.pqs.ulg.ac.be/attachments/divers/Intro_info.pdf'),
(169, 'HMIN202', 'Cours 2 M2 info', 'pdf', 'http://www.ensiie.fr/~guillaume.burel/download/compil.pdf'),
(170, 'HIN1', 'Cours 1 info', 'pdf', 'http://www.ai.univ-paris8.fr/~jm/compil.pdf'),
(171, 'HIN2', 'Cours 2 info', 'pdf', 'http://www-igm.univ-mlv.fr/~forax/ens/java-avance/cours/pdf/old/I-%20Le%20langage%20Java.pdf'),
(172, 'HLBI101', 'Cours 1 L1 bio', 'pdf', 'http://www.fsr.ac.ma/cours/biologie/triqui/M%20TRIQUI%20COURS%20DE%20BIOLOGIE%20CELLULAIRE%202016-2017%20.pdf'),
(173, 'HLBI102', 'Cours 2 L1 bio', 'pdf', 'http://www.fsr.ac.ma/cours/biologie/sbabou/Cours%20transcription%20S5.pdf'),
(174, 'HLBI201', 'Cours 1 L2 bio', 'pdf', 'http://www.remede.org/librairie-medicale/pdf/s9782100564255.pdf'),
(175, 'HLBI202', 'Cours 2 L2 bio', 'pdf', 'http://neurocomp.univ-lille1.fr/Cours%202011-2012/cours%20%20bio%20cell%202011-Etudiants.pdf'),
(176, 'HLBI301', 'Cours 1 L3 bio', 'pdf', 'http://fac.umc.edu.dz/snv/faculte/tc/16.pdf'),
(177, 'HLBI302', 'Cours 2 L3 bio', 'pdf', 'http://blog.univ-angers.fr/sante/files/2013/05/medecine_anatomie_et_physiologie.pdf'),
(178, 'HMBI101', 'Cours 1 M1 bio', 'pdf', 'https://www.biotechno.fr/IMG/pdf/5_recommandations_nationales_pedagogiques_BEP_CSS.pdf'),
(179, 'HMBI102', 'Cours 2 M1 bio', 'pdf', 'http://metagraphies.org/Sir-Patrick-Geddes/P-G_scots-college.pdf'),
(180, 'HMBI201', 'Cours 1 M2 bio', 'pdf', 'http://nadcou.cegep-rdl.qc.ca/mipec/document/planbio.pdf'),
(181, 'HMBI202', 'Cours 2 M2 bio', 'pdf', 'http://www.fsr.ac.ma/cours/biologie/Fouzia/CoursSVT2-2013.pdf'),
(182, 'HBI1', 'Cours 1 bio', 'pdf', 'https://www.zoology-uclouvain.be/docs/cours-en-auditoire/SBIOB106_van_doninck.pdf'),
(183, 'HBI2', 'Cours 2 bio', 'pdf', 'https://www.devoir.tn/superieur/Doc/Licence/Universite-de-manouba/Institut-superieur-de-biotechnologie-de-sidi-thabet/Licence-Fondamentale/Semestre-1/cour-biologie-animale-complet(tarek-hajji)[isbst].pdf'),
(184, 'HLMA101', 'Cours 1 L1 math', 'pdf', 'http://exo7.emath.fr/cours/cours-exo7.pdf'),
(185, 'HLMA102', 'Cours 2 L1 math', 'pdf', 'https://webusers.imj-prg.fr/~marc.hindry/Cours-L1.pdf'),
(186, 'HLMA201', 'Cours 1 L2 math', 'pdf', 'http://les.mathematiques.free.fr/pdf/livre.pdf'),
(187, 'HLMA202', 'Cours 2 L2 math', 'pdf', 'http://www.math.sciences.univ-nantes.fr/~robert/Master_Math_robert.pdf'),
(188, 'HLMA301', 'Cours 1 L3 math', 'pdf', 'http://www.math.sciences.univ-nantes.fr/~carron/UVPL/coursgeodif.pdf'),
(189, 'HLMA302', 'Cours 2 L3 math', 'pdf', 'https://www.math.univ-toulouse.fr/~jbhu/Nombres-Complexes-L1-def.pdf'),
(190, 'HMMA101', 'Cours 1 M1 math', 'pdf', 'http://math.unice.fr/~frapetti/analyse/analyse1_math_2011.pdf'),
(191, 'HMMA102', 'Cours 2 M1 math', 'pdf', 'http://math.unice.fr/~pauly/ca1.pdf'),
(192, 'HMMA201', 'Cours 1 M2 math', 'pdf', 'http://math.univ-lille1.fr/~suquet/ens/ICP/Cmd060902.pdf'),
(193, 'HMMA202', 'Cours 2 M2 math', 'pdf', 'https://www.math.u-bordeaux.fr/~creder/Enseignement/Miage02ProbasStats.pdf'),
(194, 'HMA1', 'Cours 1 math', 'pdf', 'http://math.unice.fr/~delarue/Teaching/CoursL2.pdf'),
(195, 'HMA2', 'Cours 2 math', 'pdf', 'http://iml.univ-mrs.fr/~reboul/cours3.pdf');

-- --------------------------------------------------------

--
-- Structure de la table `intitule`
--

CREATE TABLE `intitule` (
  `Matiere` text NOT NULL,
  `Nom` varchar(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `intitule`
--

INSERT INTO `intitule` (`Matiere`, `Nom`) VALUES
('Mathematiques', 'HMMA102'),
('Mathematiques', 'HMMA101'),
('Mathematiques', 'HLMA302'),
('Mathematiques', 'HLMA301'),
('Mathematiques', 'HLMA202'),
('Mathematiques', 'HLMA201'),
('Mathematiques', 'HLMA102'),
('Mathematiques', 'HLMA101'),
('Biologie', 'HBI2'),
('Biologie', 'HBI1'),
('Biologie', 'HMBI202'),
('Biologie', 'HMBI201'),
('Biologie', 'HMBI102'),
('Biologie', 'HMBI101'),
('Biologie', 'HLBI302'),
('Biologie', 'HLBI301'),
('Biologie', 'HLBI202'),
('Biologie', 'HLBI201'),
('Biologie', 'HLBI102'),
('Biologie', 'HLBI101'),
('Informatique', 'HIN2'),
('Informatique', 'HIN1'),
('Informatique', 'HMIN202'),
('Informatique', 'HMIN201'),
('Informatique', 'HMIN102'),
('Informatique', 'HMIN101'),
('Informatique', 'HLIN302'),
('Informatique', 'HLIN301'),
('Informatique', 'HLIN202'),
('Informatique', 'HLIN201'),
('Informatique', 'HLIN102'),
('Informatique', 'HLIN101'),
('Mathematiques', 'HMMA201'),
('Mathematiques', 'HMMA202'),
('Mathematiques', 'HMA1'),
('Mathematiques', 'HMA2');

-- --------------------------------------------------------

--
-- Structure de la table `qcm`
--

CREATE TABLE `qcm` (
  `_id` int(11) NOT NULL,
  `Intitule_id` varchar(50) DEFAULT NULL,
  `Nom` text NOT NULL,
  `Code` text NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `qcm`
--

INSERT INTO `qcm` (`_id`, `Intitule_id`, `Nom`, `Code`) VALUES
(149, 'HMA1', 'QCM 1 math', 'Question 1?|Réponse 1.1@true&Réponse 1.2@false&Réponse 1.3@false$Question 2?|Réponse 2.1@true&Réponse 2.2@false&Réponse 2.3@false$Question 3?|Réponse 3.1@true&Réponse 3.2@false&Réponse 3.3@false'),
(150, 'HMA1', 'QCM 2 math', 'Question 1?|Réponse 1.1@true&Réponse 1.2@false&Réponse 1.3@false$Question 2?|Réponse 2.1@true&Réponse 2.2@false&Réponse 2.3@false$Question 3?|Réponse 3.1@true&Réponse 3.2@false&Réponse 3.3@false'),
(148, 'HMMA202', 'QCM 2 M2 math', 'Question 1?|Réponse 1.1@true&Réponse 1.2@false&Réponse 1.3@false$Question 2?|Réponse 2.1@true&Réponse 2.2@false&Réponse 2.3@false$Question 3?|Réponse 3.1@true&Réponse 3.2@false&Réponse 3.3@false'),
(147, 'HMMA202', 'QCM 1 M2 math', 'Question 1?|Réponse 1.1@true&Réponse 1.2@false&Réponse 1.3@false$Question 2?|Réponse 2.1@true&Réponse 2.2@false&Réponse 2.3@false$Question 3?|Réponse 3.1@true&Réponse 3.2@false&Réponse 3.3@false'),
(146, 'HMMA201', 'QCM 2 M2 math', 'Question 1?|Réponse 1.1@true&Réponse 1.2@false&Réponse 1.3@false$Question 2?|Réponse 2.1@true&Réponse 2.2@false&Réponse 2.3@false$Question 3?|Réponse 3.1@true&Réponse 3.2@false&Réponse 3.3@false'),
(145, 'HMMA201', 'QCM 1 M2 math', 'Question 1?|Réponse 1.1@true&Réponse 1.2@false&Réponse 1.3@false$Question 2?|Réponse 2.1@true&Réponse 2.2@false&Réponse 2.3@false$Question 3?|Réponse 3.1@true&Réponse 3.2@false&Réponse 3.3@false'),
(144, 'HMMA102', 'QCM 2 M1 math', 'Question 1?|Réponse 1.1@true&Réponse 1.2@false&Réponse 1.3@false$Question 2?|Réponse 2.1@true&Réponse 2.2@false&Réponse 2.3@false$Question 3?|Réponse 3.1@true&Réponse 3.2@false&Réponse 3.3@false'),
(143, 'HMMA102', 'QCM 1 M1 math', 'Question 1?|Réponse 1.1@true&Réponse 1.2@false&Réponse 1.3@false$Question 2?|Réponse 2.1@true&Réponse 2.2@false&Réponse 2.3@false$Question 3?|Réponse 3.1@true&Réponse 3.2@false&Réponse 3.3@false'),
(142, 'HMMA101', 'QCM 2 M1 math', 'Question 1?|Réponse 1.1@true&Réponse 1.2@false&Réponse 1.3@false$Question 2?|Réponse 2.1@true&Réponse 2.2@false&Réponse 2.3@false$Question 3?|Réponse 3.1@true&Réponse 3.2@false&Réponse 3.3@false'),
(141, 'HMMA101', 'QCM 1 M1 math', 'Question 1?|Réponse 1.1@true&Réponse 1.2@false&Réponse 1.3@false$Question 2?|Réponse 2.1@true&Réponse 2.2@false&Réponse 2.3@false$Question 3?|Réponse 3.1@true&Réponse 3.2@false&Réponse 3.3@false'),
(140, 'HLMA302', 'QCM 2 L3 math', 'Question 1?|Réponse 1.1@true&Réponse 1.2@false&Réponse 1.3@false$Question 2?|Réponse 2.1@true&Réponse 2.2@false&Réponse 2.3@false$Question 3?|Réponse 3.1@true&Réponse 3.2@false&Réponse 3.3@false'),
(139, 'HLMA302', 'QCM 1 L3 math', 'Question 1?|Réponse 1.1@true&Réponse 1.2@false&Réponse 1.3@false$Question 2?|Réponse 2.1@true&Réponse 2.2@false&Réponse 2.3@false$Question 3?|Réponse 3.1@true&Réponse 3.2@false&Réponse 3.3@false'),
(138, 'HLMA301', 'QCM 2 L3 math', 'Question 1?|Réponse 1.1@true&Réponse 1.2@false&Réponse 1.3@false$Question 2?|Réponse 2.1@true&Réponse 2.2@false&Réponse 2.3@false$Question 3?|Réponse 3.1@true&Réponse 3.2@false&Réponse 3.3@false'),
(137, 'HLMA301', 'QCM 1 L3 math', 'Question 1?|Réponse 1.1@true&Réponse 1.2@false&Réponse 1.3@false$Question 2?|Réponse 2.1@true&Réponse 2.2@false&Réponse 2.3@false$Question 3?|Réponse 3.1@true&Réponse 3.2@false&Réponse 3.3@false'),
(136, 'HLMA202', 'QCM 2 L2 math', 'Question 1?|Réponse 1.1@true&Réponse 1.2@false&Réponse 1.3@false$Question 2?|Réponse 2.1@true&Réponse 2.2@false&Réponse 2.3@false$Question 3?|Réponse 3.1@true&Réponse 3.2@false&Réponse 3.3@false'),
(135, 'HLMA202', 'QCM 1 L2 math', 'Question 1?|Réponse 1.1@true&Réponse 1.2@false&Réponse 1.3@false$Question 2?|Réponse 2.1@true&Réponse 2.2@false&Réponse 2.3@false$Question 3?|Réponse 3.1@true&Réponse 3.2@false&Réponse 3.3@false'),
(134, 'HLMA201', 'QCM 2 L2 math', 'Question 1?|Réponse 1.1@true&Réponse 1.2@false&Réponse 1.3@false$Question 2?|Réponse 2.1@true&Réponse 2.2@false&Réponse 2.3@false$Question 3?|Réponse 3.1@true&Réponse 3.2@false&Réponse 3.3@false'),
(133, 'HLMA201', 'QCM 1 L2 math', 'Question 1?|Réponse 1.1@true&Réponse 1.2@false&Réponse 1.3@false$Question 2?|Réponse 2.1@true&Réponse 2.2@false&Réponse 2.3@false$Question 3?|Réponse 3.1@true&Réponse 3.2@false&Réponse 3.3@false'),
(132, 'HLMA102', 'QCM 2 L1 math', 'Question 1?|Réponse 1.1@true&Réponse 1.2@false&Réponse 1.3@false$Question 2?|Réponse 2.1@true&Réponse 2.2@false&Réponse 2.3@false$Question 3?|Réponse 3.1@true&Réponse 3.2@false&Réponse 3.3@false'),
(131, 'HLMA102', 'QCM 1 L1 math', 'Question 1?|Réponse 1.1@true&Réponse 1.2@false&Réponse 1.3@false$Question 2?|Réponse 2.1@true&Réponse 2.2@false&Réponse 2.3@false$Question 3?|Réponse 3.1@true&Réponse 3.2@false&Réponse 3.3@false'),
(130, 'HLMA101', 'QCM 2 L1 math', 'Question 1?|Réponse 1.1@true&Réponse 1.2@false&Réponse 1.3@false$Question 2?|Réponse 2.1@true&Réponse 2.2@false&Réponse 2.3@false$Question 3?|Réponse 3.1@true&Réponse 3.2@false&Réponse 3.3@false'),
(129, 'HLMA101', 'QCM 1 L1 math', 'Question 1?|Réponse 1.1@true&Réponse 1.2@false&Réponse 1.3@false$Question 2?|Réponse 2.1@true&Réponse 2.2@false&Réponse 2.3@false$Question 3?|Réponse 3.1@true&Réponse 3.2@false&Réponse 3.3@false'),
(128, 'HBI2', 'QCM 2 bio', 'Question 1?|Réponse 1.1@true&Réponse 1.2@false&Réponse 1.3@false$Question 2?|Réponse 2.1@true&Réponse 2.2@false&Réponse 2.3@false$Question 3?|Réponse 3.1@true&Réponse 3.2@false&Réponse 3.3@false'),
(127, 'HBI2', 'QCM 1 bio', 'Question 1?|Réponse 1.1@true&Réponse 1.2@false&Réponse 1.3@false$Question 2?|Réponse 2.1@true&Réponse 2.2@false&Réponse 2.3@false$Question 3?|Réponse 3.1@true&Réponse 3.2@false&Réponse 3.3@false'),
(126, 'HBI1', 'QCM 2 bio', 'Question 1?|Réponse 1.1@true&Réponse 1.2@false&Réponse 1.3@false$Question 2?|Réponse 2.1@true&Réponse 2.2@false&Réponse 2.3@false$Question 3?|Réponse 3.1@true&Réponse 3.2@false&Réponse 3.3@false'),
(125, 'HBI1', 'QCM 1 bio', 'Question 1?|Réponse 1.1@true&Réponse 1.2@false&Réponse 1.3@false$Question 2?|Réponse 2.1@true&Réponse 2.2@false&Réponse 2.3@false$Question 3?|Réponse 3.1@true&Réponse 3.2@false&Réponse 3.3@false'),
(124, 'HMBI202', 'QCM 2 M2 bio', 'Question 1?|Réponse 1.1@true&Réponse 1.2@false&Réponse 1.3@false$Question 2?|Réponse 2.1@true&Réponse 2.2@false&Réponse 2.3@false$Question 3?|Réponse 3.1@true&Réponse 3.2@false&Réponse 3.3@false'),
(123, 'HMBI202', 'QCM 1 M2 bio', 'Question 1?|Réponse 1.1@true&Réponse 1.2@false&Réponse 1.3@false$Question 2?|Réponse 2.1@true&Réponse 2.2@false&Réponse 2.3@false$Question 3?|Réponse 3.1@true&Réponse 3.2@false&Réponse 3.3@false'),
(122, 'HMBI201', 'QCM 2 M2 bio', 'Question 1?|Réponse 1.1@true&Réponse 1.2@false&Réponse 1.3@false$Question 2?|Réponse 2.1@true&Réponse 2.2@false&Réponse 2.3@false$Question 3?|Réponse 3.1@true&Réponse 3.2@false&Réponse 3.3@false'),
(121, 'HMBI201', 'QCM 1 M2 bio', 'Question 1?|Réponse 1.1@true&Réponse 1.2@false&Réponse 1.3@false$Question 2?|Réponse 2.1@true&Réponse 2.2@false&Réponse 2.3@false$Question 3?|Réponse 3.1@true&Réponse 3.2@false&Réponse 3.3@false'),
(120, 'HMBI102', 'QCM 2 M1 bio', 'Question 1?|Réponse 1.1@true&Réponse 1.2@false&Réponse 1.3@false$Question 2?|Réponse 2.1@true&Réponse 2.2@false&Réponse 2.3@false$Question 3?|Réponse 3.1@true&Réponse 3.2@false&Réponse 3.3@false'),
(119, 'HMBI102', 'QCM 1 M1 bio', 'Question 1?|Réponse 1.1@true&Réponse 1.2@false&Réponse 1.3@false$Question 2?|Réponse 2.1@true&Réponse 2.2@false&Réponse 2.3@false$Question 3?|Réponse 3.1@true&Réponse 3.2@false&Réponse 3.3@false'),
(118, 'HMBI101', 'QCM 2 M1 bio', 'Question 1?|Réponse 1.1@true&Réponse 1.2@false&Réponse 1.3@false$Question 2?|Réponse 2.1@true&Réponse 2.2@false&Réponse 2.3@false$Question 3?|Réponse 3.1@true&Réponse 3.2@false&Réponse 3.3@false'),
(117, 'HMBI101', 'QCM 1 M1 bio', 'Question 1?|Réponse 1.1@true&Réponse 1.2@false&Réponse 1.3@false$Question 2?|Réponse 2.1@true&Réponse 2.2@false&Réponse 2.3@false$Question 3?|Réponse 3.1@true&Réponse 3.2@false&Réponse 3.3@false'),
(116, 'HLBI302', 'QCM 2 L3 bio', 'Question 1?|Réponse 1.1@true&Réponse 1.2@false&Réponse 1.3@false$Question 2?|Réponse 2.1@true&Réponse 2.2@false&Réponse 2.3@false$Question 3?|Réponse 3.1@true&Réponse 3.2@false&Réponse 3.3@false'),
(115, 'HLBI302', 'QCM 1 L3 bio', 'Question 1?|Réponse 1.1@true&Réponse 1.2@false&Réponse 1.3@false$Question 2?|Réponse 2.1@true&Réponse 2.2@false&Réponse 2.3@false$Question 3?|Réponse 3.1@true&Réponse 3.2@false&Réponse 3.3@false'),
(114, 'HLBI301', 'QCM 2 L3 bio', 'Question 1?|Réponse 1.1@true&Réponse 1.2@false&Réponse 1.3@false$Question 2?|Réponse 2.1@true&Réponse 2.2@false&Réponse 2.3@false$Question 3?|Réponse 3.1@true&Réponse 3.2@false&Réponse 3.3@false'),
(113, 'HLBI301', 'QCM 1 L3 bio', 'Question 1?|Réponse 1.1@true&Réponse 1.2@false&Réponse 1.3@false$Question 2?|Réponse 2.1@true&Réponse 2.2@false&Réponse 2.3@false$Question 3?|Réponse 3.1@true&Réponse 3.2@false&Réponse 3.3@false'),
(112, 'HLBI202', 'QCM 2 L2 bio', 'Question 1?|Réponse 1.1@true&Réponse 1.2@false&Réponse 1.3@false$Question 2?|Réponse 2.1@true&Réponse 2.2@false&Réponse 2.3@false$Question 3?|Réponse 3.1@true&Réponse 3.2@false&Réponse 3.3@false'),
(111, 'HLBI202', 'QCM 1 L2 bio', 'Question 1?|Réponse 1.1@true&Réponse 1.2@false&Réponse 1.3@false$Question 2?|Réponse 2.1@true&Réponse 2.2@false&Réponse 2.3@false$Question 3?|Réponse 3.1@true&Réponse 3.2@false&Réponse 3.3@false'),
(110, 'HLBI201', 'QCM 2 L2 bio', 'Question 1?|Réponse 1.1@true&Réponse 1.2@false&Réponse 1.3@false$Question 2?|Réponse 2.1@true&Réponse 2.2@false&Réponse 2.3@false$Question 3?|Réponse 3.1@true&Réponse 3.2@false&Réponse 3.3@false'),
(109, 'HLBI201', 'QCM 1 L2 bio', 'Question 1?|Réponse 1.1@true&Réponse 1.2@false&Réponse 1.3@false$Question 2?|Réponse 2.1@true&Réponse 2.2@false&Réponse 2.3@false$Question 3?|Réponse 3.1@true&Réponse 3.2@false&Réponse 3.3@false'),
(108, 'HLBI102', 'QCM 2 L1 bio', 'Question 1?|Réponse 1.1@true&Réponse 1.2@false&Réponse 1.3@false$Question 2?|Réponse 2.1@true&Réponse 2.2@false&Réponse 2.3@false$Question 3?|Réponse 3.1@true&Réponse 3.2@false&Réponse 3.3@false'),
(107, 'HLBI102', 'QCM 1 L1 bio', 'Question 1?|Réponse 1.1@true&Réponse 1.2@false&Réponse 1.3@false$Question 2?|Réponse 2.1@true&Réponse 2.2@false&Réponse 2.3@false$Question 3?|Réponse 3.1@true&Réponse 3.2@false&Réponse 3.3@false'),
(106, 'HLBI101', 'QCM 2 L1 bio', 'Question 1?|Réponse 1.1@true&Réponse 1.2@false&Réponse 1.3@false$Question 2?|Réponse 2.1@true&Réponse 2.2@false&Réponse 2.3@false$Question 3?|Réponse 3.1@true&Réponse 3.2@false&Réponse 3.3@false'),
(105, 'HLBI101', 'QCM 1 L1 bio', 'Question 1?|Réponse 1.1@true&Réponse 1.2@false&Réponse 1.3@false$Question 2?|Réponse 2.1@true&Réponse 2.2@false&Réponse 2.3@false$Question 3?|Réponse 3.1@true&Réponse 3.2@false&Réponse 3.3@false'),
(104, 'HIN2', 'QCM 2 info', 'Question 1?|Réponse 1.1@true&Réponse 1.2@false&Réponse 1.3@false$Question 2?|Réponse 2.1@true&Réponse 2.2@false&Réponse 2.3@false$Question 3?|Réponse 3.1@true&Réponse 3.2@false&Réponse 3.3@false'),
(103, 'HIN2', 'QCM 1 info', 'Question 1?|Réponse 1.1@true&Réponse 1.2@false&Réponse 1.3@false$Question 2?|Réponse 2.1@true&Réponse 2.2@false&Réponse 2.3@false$Question 3?|Réponse 3.1@true&Réponse 3.2@false&Réponse 3.3@false'),
(102, 'HIN1', 'QCM 2 info', 'Question 1?|Réponse 1.1@true&Réponse 1.2@false&Réponse 1.3@false$Question 2?|Réponse 2.1@true&Réponse 2.2@false&Réponse 2.3@false$Question 3?|Réponse 3.1@true&Réponse 3.2@false&Réponse 3.3@false'),
(101, 'HIN1', 'QCM 1 info', 'Question 1?|Réponse 1.1@true&Réponse 1.2@false&Réponse 1.3@false$Question 2?|Réponse 2.1@true&Réponse 2.2@false&Réponse 2.3@false$Question 3?|Réponse 3.1@true&Réponse 3.2@false&Réponse 3.3@false'),
(100, 'HMIN202', 'QCM 2 M2 info', 'Question 1?|Réponse 1.1@true&Réponse 1.2@false&Réponse 1.3@false$Question 2?|Réponse 2.1@true&Réponse 2.2@false&Réponse 2.3@false$Question 3?|Réponse 3.1@true&Réponse 3.2@false&Réponse 3.3@false'),
(99, 'HMIN202', 'QCM 1 M2 info', 'Question 1?|Réponse 1.1@true&Réponse 1.2@false&Réponse 1.3@false$Question 2?|Réponse 2.1@true&Réponse 2.2@false&Réponse 2.3@false$Question 3?|Réponse 3.1@true&Réponse 3.2@false&Réponse 3.3@false'),
(98, 'HMIN201', 'QCM 2 M2 info', 'Question 1?|Réponse 1.1@true&Réponse 1.2@false&Réponse 1.3@false$Question 2?|Réponse 2.1@true&Réponse 2.2@false&Réponse 2.3@false$Question 3?|Réponse 3.1@true&Réponse 3.2@false&Réponse 3.3@false'),
(97, 'HMIN201', 'QCM 1 M2 info', 'Question 1?|Réponse 1.1@true&Réponse 1.2@false&Réponse 1.3@false$Question 2?|Réponse 2.1@true&Réponse 2.2@false&Réponse 2.3@false$Question 3?|Réponse 3.1@true&Réponse 3.2@false&Réponse 3.3@false'),
(96, 'HMIN102', 'QCM 2 M1 info', 'Question 1?|Réponse 1.1@true&Réponse 1.2@false&Réponse 1.3@false$Question 2?|Réponse 2.1@true&Réponse 2.2@false&Réponse 2.3@false$Question 3?|Réponse 3.1@true&Réponse 3.2@false&Réponse 3.3@false'),
(95, 'HMIN102', 'QCM 1 M1 info', 'Question 1?|Réponse 1.1@true&Réponse 1.2@false&Réponse 1.3@false$Question 2?|Réponse 2.1@true&Réponse 2.2@false&Réponse 2.3@false$Question 3?|Réponse 3.1@true&Réponse 3.2@false&Réponse 3.3@false'),
(94, 'HMIN101', 'QCM 2 M1 info', 'Question 1?|Réponse 1.1@true&Réponse 1.2@false&Réponse 1.3@false$Question 2?|Réponse 2.1@true&Réponse 2.2@false&Réponse 2.3@false$Question 3?|Réponse 3.1@true&Réponse 3.2@false&Réponse 3.3@false'),
(93, 'HMIN101', 'QCM 1 M1 info', 'Question 1?|Réponse 1.1@true&Réponse 1.2@false&Réponse 1.3@false$Question 2?|Réponse 2.1@true&Réponse 2.2@false&Réponse 2.3@false$Question 3?|Réponse 3.1@true&Réponse 3.2@false&Réponse 3.3@false'),
(92, 'HLIN302', 'QCM 2 L3 info', 'Question 1?|Réponse 1.1@true&Réponse 1.2@false&Réponse 1.3@false$Question 2?|Réponse 2.1@true&Réponse 2.2@false&Réponse 2.3@false$Question 3?|Réponse 3.1@true&Réponse 3.2@false&Réponse 3.3@false'),
(91, 'HLIN302', 'QCM 1 L3 info', 'Question 1?|Réponse 1.1@true&Réponse 1.2@false&Réponse 1.3@false$Question 2?|Réponse 2.1@true&Réponse 2.2@false&Réponse 2.3@false$Question 3?|Réponse 3.1@true&Réponse 3.2@false&Réponse 3.3@false'),
(90, 'HLIN301', 'QCM 2 L3 info', 'Question 1?|Réponse 1.1@true&Réponse 1.2@false&Réponse 1.3@false$Question 2?|Réponse 2.1@true&Réponse 2.2@false&Réponse 2.3@false$Question 3?|Réponse 3.1@true&Réponse 3.2@false&Réponse 3.3@false'),
(89, 'HLIN301', 'QCM 1 L3 info', 'Question 1?|Réponse 1.1@true&Réponse 1.2@false&Réponse 1.3@false$Question 2?|Réponse 2.1@true&Réponse 2.2@false&Réponse 2.3@false$Question 3?|Réponse 3.1@true&Réponse 3.2@false&Réponse 3.3@false'),
(88, 'HLIN202', 'QCM 2 L2 info', 'Question 1?|Réponse 1.1@true&Réponse 1.2@false&Réponse 1.3@false$Question 2?|Réponse 2.1@true&Réponse 2.2@false&Réponse 2.3@false$Question 3?|Réponse 3.1@true&Réponse 3.2@false&Réponse 3.3@false'),
(87, 'HLIN202', 'QCM 1 L2 info', 'Question 1?|Réponse 1.1@true&Réponse 1.2@false&Réponse 1.3@false$Question 2?|Réponse 2.1@true&Réponse 2.2@false&Réponse 2.3@false$Question 3?|Réponse 3.1@true&Réponse 3.2@false&Réponse 3.3@false'),
(86, 'HLIN201', 'QCM 2 L2 info', 'Question 1?|Réponse 1.1@true&Réponse 1.2@false&Réponse 1.3@false$Question 2?|Réponse 2.1@true&Réponse 2.2@false&Réponse 2.3@false$Question 3?|Réponse 3.1@true&Réponse 3.2@false&Réponse 3.3@false'),
(85, 'HLIN201', 'QCM 1 L2 info', 'Question 1?|Réponse 1.1@true&Réponse 1.2@false&Réponse 1.3@false$Question 2?|Réponse 2.1@true&Réponse 2.2@false&Réponse 2.3@false$Question 3?|Réponse 3.1@true&Réponse 3.2@false&Réponse 3.3@false'),
(84, 'HLIN102', 'QCM 2 L1 info', 'Question 1?|Réponse 1.1@true&Réponse 1.2@false&Réponse 1.3@false$Question 2?|Réponse 2.1@true&Réponse 2.2@false&Réponse 2.3@false$Question 3?|Réponse 3.1@true&Réponse 3.2@false&Réponse 3.3@false'),
(83, 'HLIN102', 'QCM 1 L1 info', 'Question 1?|Réponse 1.1@true&Réponse 1.2@false&Réponse 1.3@false$Question 2?|Réponse 2.1@true&Réponse 2.2@false&Réponse 2.3@false$Question 3?|Réponse 3.1@true&Réponse 3.2@false&Réponse 3.3@false'),
(82, 'HLIN101', 'QCM 2 L1 info', 'Question 1?|Réponse 1.1@true&Réponse 1.2@false&Réponse 1.3@false$Question 2?|Réponse 2.1@true&Réponse 2.2@false&Réponse 2.3@false$Question 3?|Réponse 3.1@true&Réponse 3.2@false&Réponse 3.3@false'),
(81, 'HLIN101', 'QCM 1 L1 info', 'Question 1?|Réponse 1.1@true&Réponse 1.2@false&Réponse 1.3@false$Question 2?|Réponse 2.1@true&Réponse 2.2@false&Réponse 2.3@false$Question 3?|Réponse 3.1@true&Réponse 3.2@false&Réponse 3.3@false'),
(151, 'HMA2', 'QCM 1 math', 'Question 1?|Réponse 1.1@true&Réponse 1.2@false&Réponse 1.3@false$Question 2?|Réponse 2.1@true&Réponse 2.2@false&Réponse 2.3@false$Question 3?|Réponse 3.1@true&Réponse 3.2@false&Réponse 3.3@false'),
(152, 'HMA2', 'QCM 2 math', 'Question 1?|Réponse 1.1@true&Réponse 1.2@false&Réponse 1.3@false$Question 2?|Réponse 2.1@true&Réponse 2.2@false&Réponse 2.3@false$Question 3?|Réponse 3.1@true&Réponse 3.2@false&Réponse 3.3@false');

-- --------------------------------------------------------

--
-- Structure de la table `qcmcandidat`
--

CREATE TABLE `qcmcandidat` (
  `_id` int(11) NOT NULL,
  `QCM_id` int(11) DEFAULT NULL,
  `Utilisateur_id` varchar(50) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `qcmcandidat`
--

INSERT INTO `qcmcandidat` (`_id`, `QCM_id`, `Utilisateur_id`) VALUES
(249, 148, 'test2@M2.com'),
(248, 147, 'test1@M2.com'),
(247, 147, 'test2@M2.com'),
(246, 146, 'test1@M2.com'),
(245, 146, 'test2@M2.com'),
(244, 145, 'test1@M2.com'),
(243, 145, 'test2@M2.com'),
(242, 144, 'test1@M1.com'),
(241, 144, 'test2@M1.com'),
(240, 143, 'test1@M1.com'),
(239, 143, 'test2@M1.com'),
(238, 142, 'test1@M1.com'),
(237, 142, 'test2@M1.com'),
(236, 141, 'test1@M1.com'),
(235, 141, 'test2@M1.com'),
(234, 140, 'test1@L3.com'),
(233, 140, 'test2@L3.com'),
(232, 139, 'test1@L3.com'),
(231, 139, 'test2@L3.com'),
(230, 138, 'test1@L3.com'),
(229, 138, 'test2@L3.com'),
(228, 137, 'test1@L3.com'),
(227, 137, 'test2@L3.com'),
(226, 136, 'test1@L2.com'),
(225, 136, 'test2@L2.com'),
(224, 135, 'test1@L2.com'),
(223, 135, 'test2@L2.com'),
(222, 134, 'test1@L2.com'),
(221, 134, 'test2@L2.com'),
(220, 133, 'test1@L2.com'),
(219, 133, 'test2@L2.com'),
(218, 132, 'test1@L1.com'),
(217, 132, 'test2@L1.com'),
(216, 131, 'test1@L1.com'),
(215, 131, 'test2@L1.com'),
(214, 130, 'test1@L1.com'),
(213, 130, 'test2@L1.com'),
(212, 129, 'test1@L1.com'),
(211, 129, 'test2@L1.com'),
(210, 124, 'test1@M2.com'),
(209, 124, 'test2@M2.com'),
(208, 123, 'test1@M2.com'),
(207, 123, 'test2@M2.com'),
(206, 122, 'test1@M2.com'),
(205, 122, 'test2@M2.com'),
(204, 121, 'test1@M2.com'),
(203, 121, 'test2@M2.com'),
(202, 120, 'test1@M1.com'),
(201, 120, 'test2@M1.com'),
(200, 119, 'test1@M1.com'),
(199, 119, 'test2@M1.com'),
(198, 118, 'test1@M1.com'),
(197, 118, 'test2@M1.com'),
(196, 117, 'test1@M1.com'),
(195, 117, 'test2@M1.com'),
(194, 116, 'test1@L3.com'),
(193, 116, 'test2@L3.com'),
(192, 115, 'test1@L3.com'),
(191, 115, 'test2@L3.com'),
(190, 114, 'test1@L3.com'),
(189, 114, 'test2@L3.com'),
(188, 113, 'test1@L3.com'),
(187, 113, 'test2@L3.com'),
(186, 112, 'test1@L2.com'),
(185, 112, 'test2@L2.com'),
(184, 111, 'test1@L2.com'),
(183, 111, 'test2@L2.com'),
(182, 110, 'test1@L2.com'),
(181, 110, 'test2@L2.com'),
(180, 109, 'test1@L2.com'),
(179, 109, 'test2@L2.com'),
(178, 108, 'test1@L1.com'),
(177, 108, 'test2@L1.com'),
(176, 107, 'test1@L1.com'),
(175, 107, 'test2@L1.com'),
(174, 106, 'test1@L1.com'),
(173, 106, 'test2@L1.com'),
(172, 105, 'test1@L1.com'),
(171, 105, 'test2@L1.com'),
(170, 100, 'test1@M2.com'),
(169, 100, 'test2@M2.com'),
(168, 99, 'test1@M2.com'),
(167, 99, 'test2@M2.com'),
(166, 98, 'test1@M2.com'),
(165, 98, 'test2@M2.com'),
(164, 97, 'test1@M2.com'),
(163, 97, 'test2@M2.com'),
(162, 96, 'test1@M1.com'),
(161, 96, 'test2@M1.com'),
(160, 95, 'test1@M1.com'),
(159, 95, 'test2@M1.com'),
(158, 94, 'test1@M1.com'),
(157, 94, 'test2@M1.com'),
(156, 93, 'test1@M1.com'),
(155, 93, 'test2@M1.com'),
(154, 92, 'test1@L3.com'),
(153, 92, 'test2@L3.com'),
(152, 91, 'test1@L3.com'),
(151, 91, 'test2@L3.com'),
(150, 90, 'test1@L3.com'),
(149, 90, 'test2@L3.com'),
(148, 89, 'test1@L3.com'),
(147, 89, 'test2@L3.com'),
(146, 88, 'test1@L2.com'),
(145, 88, 'test2@L2.com'),
(144, 87, 'test1@L2.com'),
(143, 87, 'test2@L2.com'),
(142, 86, 'test1@L2.com'),
(141, 86, 'test2@L2.com'),
(140, 85, 'test1@L2.com'),
(139, 85, 'test2@L2.com'),
(138, 84, 'test1@L1.com'),
(137, 84, 'test2@L1.com'),
(136, 83, 'test1@L1.com'),
(135, 83, 'test2@L1.com'),
(134, 82, 'test1@L1.com'),
(133, 82, 'test2@L1.com'),
(132, 81, 'test1@L1.com'),
(131, 81, 'test2@L1.com'),
(250, 148, 'test1@M2.com');

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

CREATE TABLE `utilisateur` (
  `_idmail` varchar(50) NOT NULL,
  `Nom` text NOT NULL,
  `Prenom` text NOT NULL,
  `Etudiant` tinyint(1) DEFAULT NULL,
  `MotDePasse` text NOT NULL,
  `Annee` text NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `utilisateur`
--

INSERT INTO `utilisateur` (`_idmail`, `Nom`, `Prenom`, `Etudiant`, `MotDePasse`, `Annee`) VALUES
('test1@L2.com', 'numero1', 'EtudiantL2', 1, 'motdepasse', 'L2'),
('test2@L1.com', 'numero2', 'EtudiantL1', 1, 'motdepasse', 'L1'),
('test1@L1.com', 'numero1', 'EtudiantL1', 1, 'motdepasse', 'L1'),
('test2@L2.com', 'numero2', 'EtudiantL2', 1, 'motdepasse', 'L2'),
('test1@L3.com', 'numero1', 'EtudiantL3', 1, 'motdepasse', 'L3'),
('test2@L3.com', 'numero2', 'EtudiantL3', 1, 'motdepasse', 'L3'),
('test1@M1.com', 'numero1', 'EtudiantM1', 1, 'motdepasse', 'M1'),
('test2@M1.com', 'numero2', 'EtudiantM1', 1, 'motdepasse', 'M1'),
('test1@M2.com', 'numero1', 'EtudiantM2', 1, 'motdepasse', 'M2'),
('test2@M2.com', 'numero2', 'EtudiantM2', 1, 'motdepasse', 'M2'),
('test1@Prof.com', 'numero1', 'Prof', 0, 'motdepasse', 'None'),
('test2@Prof.com', 'numero2', 'Prof', 0, 'motdepasse', 'None');

--
-- Index pour les tables exportées
--

--
-- Index pour la table `anneeauthorisee`
--
ALTER TABLE `anneeauthorisee`
  ADD PRIMARY KEY (`_id`),
  ADD KEY `fk_Cours_id` (`Intitule_id`);

--
-- Index pour la table `cours`
--
ALTER TABLE `cours`
  ADD PRIMARY KEY (`_id`),
  ADD KEY `fk_Intitule_id` (`Intitule_id`);

--
-- Index pour la table `intitule`
--
ALTER TABLE `intitule`
  ADD PRIMARY KEY (`Nom`);

--
-- Index pour la table `qcm`
--
ALTER TABLE `qcm`
  ADD PRIMARY KEY (`_id`),
  ADD KEY `fk_Intitule_id` (`Intitule_id`);

--
-- Index pour la table `qcmcandidat`
--
ALTER TABLE `qcmcandidat`
  ADD PRIMARY KEY (`_id`),
  ADD KEY `fk_QCM_id` (`QCM_id`),
  ADD KEY `fk_Utilisateur_id` (`Utilisateur_id`);

--
-- Index pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD PRIMARY KEY (`_idmail`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `anneeauthorisee`
--
ALTER TABLE `anneeauthorisee`
  MODIFY `_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=73;
--
-- AUTO_INCREMENT pour la table `cours`
--
ALTER TABLE `cours`
  MODIFY `_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=196;
--
-- AUTO_INCREMENT pour la table `qcm`
--
ALTER TABLE `qcm`
  MODIFY `_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=153;
--
-- AUTO_INCREMENT pour la table `qcmcandidat`
--
ALTER TABLE `qcmcandidat`
  MODIFY `_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=251;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
