-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  Dim 07 juin 2020 à 14:46
-- Version du serveur :  10.4.10-MariaDB
-- Version de PHP :  7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `edtece_db`
--

-- --------------------------------------------------------

--
-- Structure de la table `cours`
--

DROP TABLE IF EXISTS `cours`;
CREATE TABLE IF NOT EXISTS `cours` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NOM` varchar(25) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `cours`
--

INSERT INTO `cours` (`ID`, `NOM`) VALUES
(1, 'Mathematiques'),
(2, 'Electromagnetisme'),
(3, 'Informatique'),
(4, 'Electronique'),
(5, 'Projet');

-- --------------------------------------------------------

--
-- Structure de la table `enseignant`
--

DROP TABLE IF EXISTS `enseignant`;
CREATE TABLE IF NOT EXISTS `enseignant` (
  `ID_UTILISATEUR` int(11) NOT NULL,
  `ID_COURS` int(11) NOT NULL,
  PRIMARY KEY (`ID_UTILISATEUR`,`ID_COURS`),
  KEY `ID_COURS` (`ID_COURS`),
  KEY `ID_UTILISATEUR` (`ID_UTILISATEUR`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `enseignant`
--

INSERT INTO `enseignant` (`ID_UTILISATEUR`, `ID_COURS`) VALUES
(2, 3),
(3, 1),
(16, 4),
(17, 5),
(18, 4),
(19, 1),
(20, 2),
(21, 2),
(21, 3),
(21, 5);

-- --------------------------------------------------------

--
-- Structure de la table `etudiant`
--

DROP TABLE IF EXISTS `etudiant`;
CREATE TABLE IF NOT EXISTS `etudiant` (
  `ID_UTILISATEUR` int(11) NOT NULL,
  `NUMERO` int(25) NOT NULL,
  `ID_GROUPE` int(11) NOT NULL,
  PRIMARY KEY (`ID_UTILISATEUR`),
  KEY `ID_GROUPE` (`ID_GROUPE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `etudiant`
--

INSERT INTO `etudiant` (`ID_UTILISATEUR`, `NUMERO`, `ID_GROUPE`) VALUES
(4, 965732, 4),
(5, 254935, 1),
(6, 587263, 4),
(7, 948325, 5),
(8, 648352, 2),
(9, 648529, 3),
(10, 756245, 3),
(11, 983258, 5),
(12, 6983254, 6),
(13, 986425, 6),
(14, 965237, 2),
(15, 2167364, 1);

-- --------------------------------------------------------

--
-- Structure de la table `groupe`
--

DROP TABLE IF EXISTS `groupe`;
CREATE TABLE IF NOT EXISTS `groupe` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NOM` varchar(25) NOT NULL,
  `ID_PROMOTION` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `ID_PROMOTION` (`ID_PROMOTION`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `groupe`
--

INSERT INTO `groupe` (`ID`, `NOM`, `ID_PROMOTION`) VALUES
(1, 'TD01', 1),
(2, 'TD02', 1),
(3, 'TD01', 2),
(4, 'TD02', 2),
(5, 'TD01', 3),
(6, 'TD02', 3);

-- --------------------------------------------------------

--
-- Structure de la table `promotion`
--

DROP TABLE IF EXISTS `promotion`;
CREATE TABLE IF NOT EXISTS `promotion` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NOM` varchar(25) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `promotion`
--

INSERT INTO `promotion` (`ID`, `NOM`) VALUES
(1, '2020'),
(2, '2021'),
(3, '2022');

-- --------------------------------------------------------

--
-- Structure de la table `salle`
--

DROP TABLE IF EXISTS `salle`;
CREATE TABLE IF NOT EXISTS `salle` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NOM` varchar(25) NOT NULL,
  `CAPACITE` int(4) NOT NULL,
  `ID_SITE` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `ID_SITE` (`ID_SITE`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `salle`
--

INSERT INTO `salle` (`ID`, `NOM`, `CAPACITE`, `ID_SITE`) VALUES
(1, 'EM_205', 20, 1),
(2, 'EM_009', 70, 1),
(3, 'P_307', 30, 2),
(4, 'P_416', 30, 2),
(5, 'EM_009', 30, 3),
(6, 'EM_001', 90, 3);

-- --------------------------------------------------------

--
-- Structure de la table `seance`
--

DROP TABLE IF EXISTS `seance`;
CREATE TABLE IF NOT EXISTS `seance` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `SEMAINE` int(2) NOT NULL,
  `DATE` date NOT NULL,
  `HEURE_DEBUT` int(4) NOT NULL,
  `HEURE_FIN` int(4) NOT NULL,
  `ETAT` varchar(20) NOT NULL,
  `ID_COURS` int(11) NOT NULL,
  `ID_TYPE` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `ID_COURS` (`ID_COURS`),
  KEY `ID_TYPE` (`ID_TYPE`)
) ENGINE=InnoDB AUTO_INCREMENT=66 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `seance`
--

INSERT INTO `seance` (`ID`, `SEMAINE`, `DATE`, `HEURE_DEBUT`, `HEURE_FIN`, `ETAT`, `ID_COURS`, `ID_TYPE`) VALUES
(1, 23, '2020-06-01', 830, 1145, 'Valide', 1, 4),
(2, 23, '2020-06-01', 1345, 1515, 'Valide', 1, 1),
(3, 23, '2020-06-02', 1015, 1330, 'Valide', 2, 4),
(4, 23, '2020-06-02', 1530, 1700, 'Annule', 2, 1),
(5, 23, '2020-06-03', 830, 1145, 'Valide', 3, 4),
(6, 23, '2020-06-03', 1345, 1700, 'Valide', 3, 2),
(7, 23, '2020-06-04', 1015, 1330, 'Valide', 4, 4),
(8, 23, '2020-06-04', 1530, 1700, 'Valide', 4, 2),
(9, 23, '2020-06-01', 1345, 1515, 'Valide', 1, 1),
(10, 23, '2020-06-02', 1530, 1700, 'Valide', 2, 1),
(11, 23, '2020-06-03', 1345, 1515, 'Valide', 3, 2),
(12, 23, '2020-06-04', 1530, 1700, 'Valide', 4, 2),
(13, 23, '2020-06-01', 830, 1145, 'Valide', 2, 4),
(14, 23, '2020-06-01', 1345, 1700, 'Valide', 3, 4),
(15, 23, '2020-06-02', 830, 1145, 'Valide', 1, 4),
(16, 23, '2020-06-02', 1530, 1845, 'Valide', 4, 4),
(17, 23, '2020-06-03', 1015, 1145, 'Valide', 1, 1),
(18, 23, '2020-06-03', 1200, 1330, 'Valide', 2, 1),
(19, 23, '2020-06-04', 830, 1000, 'Valide', 4, 2),
(20, 23, '2020-06-04', 1015, 1145, 'Valide', 3, 2),
(21, 23, '2020-06-04', 830, 1000, 'Valide', 3, 2),
(22, 23, '2020-06-04', 1015, 1145, 'Valide', 4, 2),
(23, 23, '2020-06-03', 1345, 1515, 'Valide', 1, 1),
(24, 23, '2020-06-03', 1530, 1700, 'Valide', 2, 1),
(25, 23, '2020-06-01', 830, 1700, 'Valide', 5, 5),
(26, 23, '2020-06-02', 830, 1700, 'Valide', 5, 5),
(27, 23, '2020-06-03', 830, 1700, 'Valide', 5, 5),
(28, 23, '2020-06-04', 830, 1700, 'Valide', 5, 5),
(29, 23, '2020-06-05', 830, 1700, 'Valide', 5, 5),
(30, 24, '2020-06-08', 830, 1000, 'Valide', 1, 1),
(31, 24, '2020-06-08', 1015, 1145, 'Valide', 1, 1),
(32, 24, '2020-06-08', 1345, 1700, 'Valide', 1, 4),
(33, 24, '2020-06-08', 830, 1145, 'Valide', 3, 2),
(34, 24, '2020-06-08', 1015, 1330, 'Valide', 3, 2),
(35, 24, '2020-06-08', 1345, 1700, 'Valide', 3, 4),
(36, 24, '2020-06-09', 1015, 1330, 'Valide', 4, 2),
(37, 24, '2020-06-09', 830, 1015, 'Valide', 4, 2),
(38, 24, '2020-06-09', 1345, 1700, 'Valide', 4, 4),
(39, 24, '2020-06-09', 830, 1145, 'Valide', 1, 4),
(40, 24, '2020-06-09', 1345, 1700, 'Valide', 2, 4),
(41, 24, '2020-06-09', 830, 1000, 'Valide', 1, 1),
(42, 24, '2020-06-09', 830, 1000, 'Valide', 2, 1),
(43, 24, '2020-06-09', 1015, 1145, 'Valide', 2, 1),
(44, 24, '2020-06-09', 1015, 1145, 'Valide', 1, 1),
(45, 24, '2020-06-09', 1345, 1700, 'Valide', 1, 4),
(46, 24, '2020-06-10', 830, 1000, 'Valide', 2, 1),
(47, 24, '2020-06-10', 1015, 1145, 'Valide', 2, 1),
(48, 24, '2020-06-10', 1345, 1700, 'Valide', 2, 4),
(49, 24, '2020-06-10', 1015, 1145, 'Valide', 4, 2),
(50, 24, '2020-06-10', 1015, 1145, 'Valide', 4, 2),
(51, 24, '2020-06-10', 1345, 1700, 'Valide', 4, 4),
(52, 24, '2020-06-10', 830, 1145, 'Valide', 2, 4),
(53, 24, '2020-06-10', 1345, 1700, 'Valide', 3, 2),
(54, 24, '2020-06-10', 1345, 1700, 'Valide', 3, 2),
(55, 24, '2020-06-11', 1015, 1145, 'Valide', 1, 1),
(56, 24, '2020-06-11', 830, 1000, 'Valide', 1, 1),
(57, 24, '2020-06-11', 830, 1145, 'Annule', 3, 4),
(58, 24, '2020-06-12', 830, 1145, 'Valide', 3, 2),
(59, 24, '2020-06-12', 830, 1145, 'Valide', 3, 2),
(60, 24, '2020-06-12', 1345, 1700, 'Valide', 3, 4),
(61, 24, '2020-06-12', 1200, 1330, 'Valide', 2, 1),
(62, 24, '2020-06-12', 1345, 1515, 'Valide', 2, 1),
(63, 24, '2020-06-12', 1015, 1145, 'Valide', 2, 1),
(64, 24, '2020-06-12', 830, 1000, 'Valide', 2, 1),
(65, 24, '2020-06-12', 1345, 1700, 'Valide', 2, 4);

-- --------------------------------------------------------

--
-- Structure de la table `seance_enseignant`
--

DROP TABLE IF EXISTS `seance_enseignant`;
CREATE TABLE IF NOT EXISTS `seance_enseignant` (
  `ID_SCEANCE` int(11) NOT NULL,
  `ID_ENSEIGNANT` int(11) NOT NULL,
  PRIMARY KEY (`ID_SCEANCE`,`ID_ENSEIGNANT`),
  KEY `ID_ENSEIGNANT` (`ID_ENSEIGNANT`),
  KEY `ID_SCEANCE` (`ID_SCEANCE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `seance_enseignant`
--

INSERT INTO `seance_enseignant` (`ID_SCEANCE`, `ID_ENSEIGNANT`) VALUES
(1, 19),
(2, 3),
(3, 20),
(4, 21),
(5, 2),
(6, 21),
(7, 18),
(8, 16),
(9, 19),
(10, 20),
(11, 2),
(12, 18),
(13, 2),
(14, 2),
(15, 19),
(16, 18),
(17, 3),
(18, 21),
(19, 16),
(20, 2),
(21, 2),
(22, 16),
(23, 3),
(24, 21),
(25, 17),
(26, 17),
(27, 17),
(28, 17),
(29, 17),
(30, 3),
(31, 3),
(32, 19),
(33, 21),
(34, 21),
(35, 2),
(36, 16),
(37, 16),
(38, 18),
(39, 19),
(40, 20),
(41, 3),
(42, 18),
(43, 18),
(44, 3),
(45, 19),
(46, 21),
(47, 21),
(48, 20),
(49, 18),
(50, 16),
(51, 18),
(52, 18),
(53, 21),
(54, 2),
(55, 3),
(56, 3),
(57, 2),
(58, 21),
(59, 2),
(60, 2),
(61, 20),
(62, 20),
(63, 21),
(64, 21),
(65, 20);

-- --------------------------------------------------------

--
-- Structure de la table `seance_groupe`
--

DROP TABLE IF EXISTS `seance_groupe`;
CREATE TABLE IF NOT EXISTS `seance_groupe` (
  `ID_SEANCE` int(11) NOT NULL,
  `ID_GROUPE` int(11) NOT NULL,
  PRIMARY KEY (`ID_SEANCE`,`ID_GROUPE`),
  KEY `ID_SEANCE` (`ID_SEANCE`,`ID_GROUPE`),
  KEY `ID_GROUPE` (`ID_GROUPE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `seance_groupe`
--

INSERT INTO `seance_groupe` (`ID_SEANCE`, `ID_GROUPE`) VALUES
(1, 1),
(1, 2),
(2, 1),
(3, 1),
(3, 2),
(4, 1),
(5, 1),
(5, 2),
(6, 1),
(7, 1),
(7, 2),
(8, 1),
(9, 2),
(10, 2),
(11, 2),
(12, 2),
(13, 3),
(13, 4),
(14, 3),
(14, 4),
(15, 3),
(15, 4),
(16, 3),
(16, 4),
(17, 3),
(18, 3),
(19, 3),
(20, 3),
(21, 4),
(22, 4),
(23, 4),
(24, 4),
(25, 5),
(25, 6),
(26, 5),
(26, 6),
(27, 5),
(27, 6),
(28, 5),
(28, 6),
(29, 5),
(29, 6),
(30, 1),
(31, 2),
(32, 1),
(32, 2),
(33, 3),
(34, 4),
(35, 3),
(35, 4),
(36, 1),
(37, 2),
(38, 1),
(38, 2),
(39, 3),
(39, 4),
(40, 3),
(40, 4),
(41, 5),
(42, 6),
(43, 5),
(44, 6),
(45, 5),
(45, 6),
(46, 1),
(47, 2),
(48, 1),
(48, 2),
(49, 3),
(50, 4),
(51, 3),
(51, 4),
(52, 5),
(52, 6),
(53, 5),
(54, 6),
(55, 3),
(56, 4),
(57, 5),
(57, 6),
(58, 1),
(59, 2),
(60, 1),
(60, 2),
(61, 3),
(62, 4),
(63, 5),
(64, 6),
(65, 5),
(65, 6);

-- --------------------------------------------------------

--
-- Structure de la table `seance_salles`
--

DROP TABLE IF EXISTS `seance_salles`;
CREATE TABLE IF NOT EXISTS `seance_salles` (
  `ID_SEANCE` int(11) NOT NULL,
  `ID_SALLE` int(11) NOT NULL,
  PRIMARY KEY (`ID_SEANCE`,`ID_SALLE`),
  KEY `ID_SALLE` (`ID_SALLE`),
  KEY `ID_SEANCE` (`ID_SEANCE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `seance_salles`
--

INSERT INTO `seance_salles` (`ID_SEANCE`, `ID_SALLE`) VALUES
(1, 2),
(2, 3),
(3, 1),
(4, 1),
(5, 6),
(6, 4),
(7, 2),
(8, 3),
(9, 4),
(10, 4),
(11, 1),
(12, 3),
(13, 6),
(14, 6),
(15, 2),
(16, 5),
(17, 5),
(18, 6),
(19, 6),
(20, 3),
(21, 4),
(22, 1),
(23, 1),
(24, 3),
(25, 2),
(26, 2),
(27, 2),
(28, 2),
(29, 2),
(30, 3),
(31, 3),
(32, 6),
(33, 4),
(34, 4),
(35, 2),
(36, 1),
(37, 1),
(38, 6),
(39, 2),
(40, 5),
(41, 3),
(42, 4),
(43, 4),
(44, 3),
(45, 2),
(46, 3),
(47, 3),
(48, 2),
(49, 4),
(50, 1),
(51, 6),
(52, 2),
(53, 4),
(54, 1),
(55, 3),
(56, 3),
(57, 2),
(58, 1),
(59, 4),
(60, 2),
(61, 3),
(62, 3),
(63, 3),
(64, 3),
(65, 6);

-- --------------------------------------------------------

--
-- Structure de la table `site`
--

DROP TABLE IF EXISTS `site`;
CREATE TABLE IF NOT EXISTS `site` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NOM` varchar(25) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `site`
--

INSERT INTO `site` (`ID`, `NOM`) VALUES
(1, 'E1'),
(2, 'E2'),
(3, 'E4');

-- --------------------------------------------------------

--
-- Structure de la table `type_cours`
--

DROP TABLE IF EXISTS `type_cours`;
CREATE TABLE IF NOT EXISTS `type_cours` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NOM` varchar(25) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `type_cours`
--

INSERT INTO `type_cours` (`ID`, `NOM`) VALUES
(1, 'TD'),
(2, 'TP'),
(3, 'CI'),
(4, 'CM'),
(5, 'Projet');

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

DROP TABLE IF EXISTS `utilisateur`;
CREATE TABLE IF NOT EXISTS `utilisateur` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `EMAIL` varchar(50) NOT NULL,
  `PASSWORD` varchar(25) NOT NULL,
  `NOM` varchar(25) NOT NULL,
  `PRENOM` varchar(25) NOT NULL,
  `DROIT` int(1) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `utilisateur`
--

INSERT INTO `utilisateur` (`ID`, `EMAIL`, `PASSWORD`, `NOM`, `PRENOM`, `DROIT`) VALUES
(1, 'thom.ferrier@gmail.com', 'bleudywind99', 'Ferrier', 'Thomas', 1),
(2, 'Segado.JP@edu.ece.fr', 'jp', 'Segado', 'Jean Pierre', 2),
(3, 'Bianchini.marc@edu.ece.fr', 'marc', 'Bianchini', 'Marc', 3),
(4, 'louis.roussel@gmail.com', 'louis', 'Roussel', 'Louis', 4),
(5, 'adrien.martinon@gmail.com', 'adrien', 'Martinon', 'Adrien', 4),
(6, 'lucas.dessouki@gmail.com', 'lucas', 'Dessouki', 'Lucas', 4),
(7, 'marie.pussard@gmail.com', 'marie', 'Pussard', 'Marie', 4),
(8, 'baptiste.boyer@gmail.com', 'baptiste', 'Boyer', 'Baptiste', 4),
(9, 'juliette.stephane@gmail.com', 'juliette', 'Stephane', 'Juliette', 4),
(10, 'ln.clavelier@gmail.com', 'ln', 'Clavelier', 'Helene', 4),
(11, 'mathieu.bach@gmail.com', 'mathieu', 'Bach', 'Mathieu', 4),
(12, 'octave.mesquita@gmail.com', 'octave', 'Mesquita', 'Octave', 4),
(13, 'pierre.ader@gmail.com', 'pierre', 'Ader', 'Pierre', 4),
(14, 'eva.dorise@gmail.com', 'eva', 'Dorise', 'Eva', 4),
(15, 'alexandre.jodin@gmail.com', 'alexandre', 'Jodin', 'Alexandre', 4),
(16, 'ait.bouzid@gmail.com', 'ait', 'Bouzid', 'Ait', 3),
(17, 'lemarec.stephanie@gmail.com', 'lemarec', 'Lemarec', 'Stephanie', 3),
(18, 'schneider.maxime@gmail.com', 'maxime', 'Schneider', 'Maxime', 3),
(19, 'fabienne.coudray@gmail.com', 'fabienne', 'Coudray', 'Fabienne', 2),
(20, 'mouhali.waleed@gmail.com', 'waleed', 'Mouhali', 'Waleed', 2),
(21, 'maylinh.grand@mail.com', 'grand', 'Grand', 'Maylinh', 3);

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `enseignant`
--
ALTER TABLE `enseignant`
  ADD CONSTRAINT `ID_COURS` FOREIGN KEY (`ID_COURS`) REFERENCES `cours` (`ID`),
  ADD CONSTRAINT `enseignant_ibfk_1` FOREIGN KEY (`ID_UTILISATEUR`) REFERENCES `utilisateur` (`ID`);

--
-- Contraintes pour la table `etudiant`
--
ALTER TABLE `etudiant`
  ADD CONSTRAINT `ID_GROUPE` FOREIGN KEY (`ID_GROUPE`) REFERENCES `groupe` (`ID`),
  ADD CONSTRAINT `ID_UTILISATEUR` FOREIGN KEY (`ID_UTILISATEUR`) REFERENCES `utilisateur` (`ID`);

--
-- Contraintes pour la table `groupe`
--
ALTER TABLE `groupe`
  ADD CONSTRAINT `ID_PROMOTION` FOREIGN KEY (`ID_PROMOTION`) REFERENCES `promotion` (`ID`);

--
-- Contraintes pour la table `salle`
--
ALTER TABLE `salle`
  ADD CONSTRAINT `salle_ibfk_1` FOREIGN KEY (`ID_SITE`) REFERENCES `site` (`ID`);

--
-- Contraintes pour la table `seance`
--
ALTER TABLE `seance`
  ADD CONSTRAINT `seance_ibfk_1` FOREIGN KEY (`ID_COURS`) REFERENCES `cours` (`ID`),
  ADD CONSTRAINT `seance_ibfk_2` FOREIGN KEY (`ID_TYPE`) REFERENCES `type_cours` (`ID`);

--
-- Contraintes pour la table `seance_enseignant`
--
ALTER TABLE `seance_enseignant`
  ADD CONSTRAINT `seance_enseignant_ibfk_1` FOREIGN KEY (`ID_ENSEIGNANT`) REFERENCES `enseignant` (`ID_UTILISATEUR`),
  ADD CONSTRAINT `seance_enseignant_ibfk_2` FOREIGN KEY (`ID_SCEANCE`) REFERENCES `seance` (`ID`);

--
-- Contraintes pour la table `seance_groupe`
--
ALTER TABLE `seance_groupe`
  ADD CONSTRAINT `seance_groupe_ibfk_1` FOREIGN KEY (`ID_GROUPE`) REFERENCES `groupe` (`ID`),
  ADD CONSTRAINT `seance_groupe_ibfk_2` FOREIGN KEY (`ID_SEANCE`) REFERENCES `seance` (`ID`);

--
-- Contraintes pour la table `seance_salles`
--
ALTER TABLE `seance_salles`
  ADD CONSTRAINT `seance_salles_ibfk_1` FOREIGN KEY (`ID_SALLE`) REFERENCES `salle` (`ID`),
  ADD CONSTRAINT `seance_salles_ibfk_2` FOREIGN KEY (`ID_SEANCE`) REFERENCES `seance` (`ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
