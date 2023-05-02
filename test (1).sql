-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : mar. 02 mai 2023 à 11:59
-- Version du serveur : 10.4.27-MariaDB
-- Version de PHP : 7.4.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `test`
--

-- --------------------------------------------------------

--
-- Structure de la table `adresse`
--

CREATE TABLE `adresse` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `firstname` varchar(255) NOT NULL,
  `lastname` varchar(255) NOT NULL,
  `adress` varchar(255) NOT NULL,
  `postal` varchar(255) NOT NULL,
  `ville` varchar(255) NOT NULL,
  `phone` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `adresse`
--

INSERT INTO `adresse` (`id`, `user_id`, `name`, `firstname`, `lastname`, `adress`, `postal`, `ville`, `phone`) VALUES
(1, 6, 'domicileee', 'joe', 'rak', '19 rue 11063 ibn sina', '2006', 'tunis', '92705635'),
(2, 6, 'Bureau', 'joe', 'rakrouki', '29 rue zarkoun', '1009', 'tunis', '92705635'),
(3, 9, 'domicile', 'joe', 'rakrouki', '19 rue 11063 ibn sina', '2006', 'tunis', '92705635'),
(4, 10, 'domicile', 'joe', 'rakrouki', '19 rue 11063 ibn sina', '2006', 'tunis', '92705635'),
(6, 11, 'Bureau', 'joe', 'rakrouki', '19 rue 11063 ibn sina', '1009', 'gabes', '92705635');

-- --------------------------------------------------------

--
-- Structure de la table `article`
--

CREATE TABLE `article` (
  `id` int(11) NOT NULL,
  `category` varchar(255) NOT NULL,
  `subject` varchar(255) NOT NULL,
  `text` varchar(255) NOT NULL,
  `date_pub` timestamp NOT NULL DEFAULT current_timestamp(),
  `user` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Déchargement des données de la table `article`
--

INSERT INTO `article` (`id`, `category`, `subject`, `text`, `date_pub`, `user`) VALUES
(6, 'cat 4', 'sujet', 'text', '2022-09-01 16:47:17', 'ines12'),
(7, 'cat 5', 'sujet', 'text', '2022-09-01 16:48:57', 'ines12');

-- --------------------------------------------------------

--
-- Structure de la table `carrier`
--

CREATE TABLE `carrier` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL,
  `prix` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `carrier`
--

INSERT INTO `carrier` (`id`, `name`, `description`, `prix`) VALUES
(1, 'livraison expresse', 'livraison dans les prochaines 48h', 25),
(3, 'livraison gratuite', 'livraison aprés 7 jours', 0);

-- --------------------------------------------------------

--
-- Structure de la table `category`
--

CREATE TABLE `category` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `category`
--

INSERT INTO `category` (`id`, `name`) VALUES
(2, 'prod'),
(3, 'visage'),
(10, 'produit'),
(16, 'cheveux');

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

CREATE TABLE `client` (
  `id` int(11) NOT NULL,
  `LoginClient` varchar(255) NOT NULL,
  `MdpClient` varchar(255) NOT NULL,
  `NomClient` varchar(255) NOT NULL,
  `PrenomClient` varchar(255) NOT NULL,
  `TelClient` int(11) NOT NULL,
  `MailClient` varchar(255) NOT NULL,
  `AdresseClient` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- --------------------------------------------------------

--
-- Structure de la table `commande`
--

CREATE TABLE `commande` (
  `id` int(11) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `description` varchar(255) NOT NULL,
  `quantite` int(11) NOT NULL,
  `date_creation` varchar(255) DEFAULT NULL,
  `date_c` datetime DEFAULT NULL,
  `idPanier` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `commande`
--

INSERT INTO `commande` (`id`, `nom`, `description`, `quantite`, `date_creation`, `date_c`, `idPanier`) VALUES
(17, 'dgfgdf', 'gdfgdfgdfgdf', 21, 'qskdhqskh', '2023-04-20 00:15:18', 4),
(18, 'sfjdlsjfjklsd', 'jsjdlfjsdlj', 12, 'zefiopzifp', '2023-04-20 01:28:53', 4),
(19, 'dgf', 'gdfgdf', 214, 'hjh', '2023-04-20 00:00:00', 4),
(20, 'dgfhgjg', 'gdfgdfccccc', 214, 'hjh', '2023-04-20 00:00:00', 4),
(21, 'aaaaaaa', 'jsjdlfjsdljj', 12756, 'hjh', '2023-04-12 00:00:00', 5),
(22, 'han', 'aaaaaaaaaa', 41, 'hjh', '2023-04-19 00:00:00', 4),
(23, 'fatma', 'nice', 4, 'hjh', '2023-04-12 00:00:00', 4),
(24, 'fatma', 'nice', 4, 'hjh', '2023-04-12 00:00:00', 4),
(25, 'fatmaa', 'fff', 7, 'hjh', '2023-03-28 00:00:00', 6),
(26, 'commande A', 'tres grabd', 5, 'hjh', '2023-03-28 00:00:00', 7),
(27, 'f', 'fghj', 7, 'hjh', '2023-03-28 00:00:00', 11),
(31, 'fatma', 'tere', 4, 'hjh', '2023-03-28 00:00:00', 5),
(32, 'fatma', 'tere', 4, 'hjh', '2023-03-28 00:00:00', 5),
(33, 'aza', 'fffff', 5, 'hjh', '2023-05-03 00:00:00', 6);

-- --------------------------------------------------------

--
-- Structure de la table `commandedetails`
--

CREATE TABLE `commandedetails` (
  `id` int(11) NOT NULL,
  `idProduct` int(11) NOT NULL,
  `idOrder` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  `total` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Déchargement des données de la table `commandedetails`
--

INSERT INTO `commandedetails` (`id`, `idProduct`, `idOrder`, `quantity`, `total`) VALUES
(1, 12, 0, 1, 20),
(2, 11, 0, 1, 105),
(3, 12, 0, 1, 20),
(4, 12, 0, 1, 20),
(5, 11, 0, 1, 105),
(6, 11, 0, 1, 105),
(7, 12, 1, 1, 25),
(8, 11, 2, 1, 105),
(9, 11, 3, 2, 210),
(10, 14, 3, 3, 45);

-- --------------------------------------------------------

--
-- Structure de la table `competition`
--

CREATE TABLE `competition` (
  `id` int(11) NOT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `description` longtext DEFAULT NULL,
  `category` varchar(255) DEFAULT NULL,
  `nombre_de_place` int(11) DEFAULT NULL,
  `image` longtext DEFAULT NULL,
  `adresse` varchar(255) DEFAULT NULL,
  `date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `competition`
--

INSERT INTO `competition` (`id`, `nom`, `description`, `category`, `nombre_de_place`, `image`, `adresse`, `date`) VALUES
(1, 'football', '10 joueur', 'categorie', 10, '?', 'ibn sina', '2021-03-02'),
(2, 'jeu de dame', 'description', 'categorie', 22, '?', 'tunis', '2021-04-04'),
(3, 'jeu de dame', 'description', 'categorie', 50, '?', 'sousse', '2021-02-02'),
(4, 'ajout', 'description', 'nautique', 2, NULL, 'ibn sina', '2021-04-29'),
(5, 'competition foot', 'description', 'nautique', 50, NULL, 'tunis', '2021-04-29');

-- --------------------------------------------------------

--
-- Structure de la table `doctrine_migration_versions`
--

CREATE TABLE `doctrine_migration_versions` (
  `version` varchar(191) NOT NULL,
  `executed_at` datetime DEFAULT NULL,
  `execution_time` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `doctrine_migration_versions`
--

INSERT INTO `doctrine_migration_versions` (`version`, `executed_at`, `execution_time`) VALUES
('DoctrineMigrations\\Version20210221233419', '2021-02-21 23:34:27', 149),
('DoctrineMigrations\\Version20210222210249', '2021-02-22 21:03:39', 197),
('DoctrineMigrations\\Version20210225154540', '2021-02-25 15:46:44', 141),
('DoctrineMigrations\\Version20210225161756', '2021-02-25 16:18:51', 188),
('DoctrineMigrations\\Version20210227134912', '2021-02-27 13:49:43', 193),
('DoctrineMigrations\\Version20210228230131', '2021-02-28 23:02:46', 223),
('DoctrineMigrations\\Version20210301111349', '2021-03-01 11:18:01', 134),
('DoctrineMigrations\\Version20210302231942', '2021-03-02 23:20:15', 271),
('DoctrineMigrations\\Version20210303213236', '2021-03-03 21:33:59', 155),
('DoctrineMigrations\\Version20210306201503', '2021-03-06 20:15:24', 183),
('DoctrineMigrations\\Version20210306215150', '2021-03-06 21:52:14', 202),
('DoctrineMigrations\\Version20210307225156', '2021-03-07 22:52:18', 179),
('DoctrineMigrations\\Version20210310213550', '2021-03-10 21:36:19', 231),
('DoctrineMigrations\\Version20210331100740', '2021-03-31 10:08:03', 549),
('DoctrineMigrations\\Version20210331101559', '2021-03-31 10:16:51', 223),
('DoctrineMigrations\\Version20210331200501', '2021-03-31 20:05:36', 256),
('DoctrineMigrations\\Version20210331220734', '2021-03-31 22:08:05', 149),
('DoctrineMigrations\\Version20210401001148', '2021-04-01 00:13:54', 237),
('DoctrineMigrations\\Version20230228115124', '2023-02-28 12:51:32', 148);

-- --------------------------------------------------------

--
-- Structure de la table `evenement`
--

CREATE TABLE `evenement` (
  `id_evenement` int(11) NOT NULL,
  `id_organisateur` int(11) NOT NULL,
  `titre` varchar(255) NOT NULL,
  `date_debut` date NOT NULL,
  `date_fin` date NOT NULL,
  `heure` varchar(255) NOT NULL,
  `ville` varchar(255) NOT NULL,
  `adresse` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL,
  `photo` varchar(255) NOT NULL,
  `approuver` tinyint(1) NOT NULL,
  `nombre_vus` int(11) NOT NULL,
  `nombre_participants` int(11) NOT NULL,
  `nombre_max` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `evenement`
--

INSERT INTO `evenement` (`id_evenement`, `id_organisateur`, `titre`, `date_debut`, `date_fin`, `heure`, `ville`, `adresse`, `description`, `photo`, `approuver`, `nombre_vus`, `nombre_participants`, `nombre_max`) VALUES
(2, 1, 'camping', '2016-01-01', '2016-01-01', '12', 'tunis', '19 rue 11063 ibn sina', 'description', 'a7c662e19a1da456c88ff87247ea32a5.png', 1, 1, 1, 35);

-- --------------------------------------------------------

--
-- Structure de la table `location_materiel`
--

CREATE TABLE `location_materiel` (
  `id` int(11) NOT NULL,
  `total_location` double NOT NULL,
  `duree_location` int(11) NOT NULL,
  `date_debut_location` date NOT NULL,
  `date_fin_location` date NOT NULL,
  `adresse_locataire_location` varchar(255) NOT NULL,
  `nom_locataire_location` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `location_materiel`
--

INSERT INTO `location_materiel` (`id`, `total_location`, `duree_location`, `date_debut_location`, `date_fin_location`, `adresse_locataire_location`, `nom_locataire_location`) VALUES
(1, 100, 30, '2021-03-02', '2021-03-03', '19 rue 11063 ibn sina', 'joe');

-- --------------------------------------------------------

--
-- Structure de la table `materiel`
--

CREATE TABLE `materiel` (
  `id` int(11) NOT NULL,
  `location_id` int(11) DEFAULT NULL,
  `nom_materiel` varchar(255) NOT NULL,
  `description_materiel` varchar(255) NOT NULL,
  `prix_materiel` double NOT NULL,
  `photo_materiel` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `materiel`
--

INSERT INTO `materiel` (`id`, `location_id`, `nom_materiel`, `description_materiel`, `prix_materiel`, `photo_materiel`) VALUES
(1, 1, 'materiel camp', 'description', 25, '/private/var/folders/ht/3rngmt750cg8kfby896llxfm0000gn/T/phpzWfOWS'),
(2, 1, 'materiel foot', 'description', 20, '32a72ee754cee7274fbbad3fe751a832.jpg'),
(3, 1, 'mqteriel', 'description', 12, 'image'),
(4, 1, 'materiel', 'description', 15, 'aaaa');

-- --------------------------------------------------------

--
-- Structure de la table `messenger_messages`
--

CREATE TABLE `messenger_messages` (
  `id` bigint(20) NOT NULL,
  `body` longtext NOT NULL,
  `headers` longtext NOT NULL,
  `queue_name` varchar(190) NOT NULL,
  `created_at` datetime NOT NULL,
  `available_at` datetime NOT NULL,
  `delivered_at` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Structure de la table `order`
--

CREATE TABLE `order` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `created_at` datetime NOT NULL,
  `carrier_name` varchar(255) NOT NULL,
  `carrier_price` double NOT NULL,
  `delivery` longtext NOT NULL,
  `reference` varchar(255) NOT NULL,
  `stripe_session_id` varchar(255) DEFAULT NULL,
  `state` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `order`
--

INSERT INTO `order` (`id`, `user_id`, `created_at`, `carrier_name`, `carrier_price`, `delivery`, `reference`, `stripe_session_id`, `state`) VALUES
(16, 6, '2021-03-04 00:13:11', 'livraison', 100, 'joe rak<br/>92705635<br/>19 rue 11063 ibn sina tunis 2006', '', NULL, 0),
(17, 6, '2021-03-04 00:13:29', 'livraison', 100, 'joe rak<br/>92705635<br/>19 rue 11063 ibn sina tunis 2006', '', NULL, 0),
(18, 6, '2021-03-04 09:07:18', 'livraison', 100, 'joe rak<br/>92705635<br/>19 rue 11063 ibn sina tunis 2006', '', NULL, 0),
(19, 9, '2021-03-04 10:27:12', 'livraison expresse', 20, 'joe rakrouki<br/>92705635<br/>19 rue 11063 ibn sina tunis 2006', '', NULL, 0),
(20, 10, '2021-03-06 12:26:29', 'livraison expresse', 20, 'joe rakrouki<br/>92705635<br/>19 rue 11063 ibn sina tunis 2006', '', NULL, 0),
(21, 10, '2021-03-06 12:48:20', 'livraison expresse', 20, 'joe rakrouki<br/>92705635<br/>19 rue 11063 ibn sina tunis 2006', '', NULL, 0),
(22, 10, '2021-03-06 13:09:07', 'livraison expresse', 20, 'joe rakrouki<br/>92705635<br/>19 rue 11063 ibn sina tunis 2006', '', NULL, 0),
(23, 10, '2021-03-06 16:44:56', 'livraison expresse', 20, 'joe rakrouki<br/>92705635<br/>19 rue 11063 ibn sina tunis 2006', '', NULL, 0),
(24, 10, '2021-03-06 20:49:22', 'livraison expresse', 20, 'joe rakrouki<br/>92705635<br/>19 rue 11063 ibn sina tunis 2006', '06032021-6043ead2a5edb', NULL, 0),
(25, 10, '2021-03-06 20:51:57', 'livraison expresse', 20, 'joe rakrouki<br/>92705635<br/>19 rue 11063 ibn sina tunis 2006', '06032021-6043eb6d0e311', NULL, 0),
(26, 10, '2021-03-06 20:53:38', 'livraison expresse', 20, 'joe rakrouki<br/>92705635<br/>19 rue 11063 ibn sina tunis 2006', '06032021-6043ebd2c7d7d', NULL, 0),
(27, 10, '2021-03-06 20:56:00', 'livraison expresse', 20, 'joe rakrouki<br/>92705635<br/>19 rue 11063 ibn sina tunis 2006', '06032021-6043ec60a5100', NULL, 0),
(28, 10, '2021-03-06 20:57:15', 'livraison expresse', 20, 'joe rakrouki<br/>92705635<br/>19 rue 11063 ibn sina tunis 2006', '06032021-6043ecabc14eb', NULL, 0),
(29, 10, '2021-03-06 20:58:52', 'livraison expresse', 20, 'joe rakrouki<br/>92705635<br/>19 rue 11063 ibn sina tunis 2006', '06032021-6043ed0c59393', NULL, 0),
(30, 10, '2021-03-06 21:01:42', 'livraison expresse', 20, 'joe rakrouki<br/>92705635<br/>19 rue 11063 ibn sina tunis 2006', '06032021-6043edb6edce6', NULL, 0),
(31, 10, '2021-03-06 21:02:43', 'livraison expresse', 20, 'joe rakrouki<br/>92705635<br/>19 rue 11063 ibn sina tunis 2006', '06032021-6043edf394a5d', NULL, 0),
(32, 10, '2021-03-06 21:14:07', 'livraison expresse', 20, 'joe rakrouki<br/>92705635<br/>19 rue 11063 ibn sina tunis 2006', '06032021-6043f09f469b1', NULL, 0),
(33, 10, '2021-03-06 21:23:05', 'livraison expresse', 20, 'joe rakrouki<br/>92705635<br/>19 rue 11063 ibn sina tunis 2006', '06032021-6043f2b958435', NULL, 0),
(34, 10, '2021-03-06 21:38:51', 'livraison expresse', 20, 'joe rakrouki<br/>92705635<br/>19 rue 11063 ibn sina tunis 2006', '06032021-6043f66bbed15', NULL, 0),
(35, 10, '2021-03-07 20:53:00', 'livraison expresse', 20, 'joe rakrouki<br/>92705635<br/>19 rue 11063 ibn sina tunis 2006', '07032021-60453d2c5632b', NULL, 0),
(36, 10, '2021-03-07 21:03:21', 'livraison expresse', 20, 'joe rakrouki<br/>92705635<br/>19 rue 11063 ibn sina tunis 2006', '07032021-60453f9995188', NULL, 0),
(37, 10, '2021-03-07 21:16:54', 'livraison normal', 10, 'joe rakrouki<br/>92705635<br/>19 rue 11063 ibn sina tunis 2006', '07032021-604542c639e68', NULL, 0),
(38, 10, '2021-03-07 21:19:32', 'livraison expresse', 20, 'joe rakrouki<br/>92705635<br/>19 rue 11063 ibn sina tunis 2006', '07032021-604543644d9b2', NULL, 0),
(39, 10, '2021-03-07 21:22:30', 'livraison expresse', 20, 'joe rakrouki<br/>92705635<br/>19 rue 11063 ibn sina tunis 2006', '07032021-60454416148b9', NULL, 0),
(40, 10, '2021-03-07 21:45:27', 'livraison expresse', 20, 'joe rakrouki<br/>92705635<br/>19 rue 11063 ibn sina tunis 2006', '07032021-604549771254c', NULL, 0),
(41, 10, '2021-03-07 22:36:55', 'livraison expresse', 20, 'joe rakrouki<br/>92705635<br/>19 rue 11063 ibn sina tunis 2006', '07032021-60455587efeeb', NULL, 0),
(42, 10, '2021-03-07 22:41:07', 'livraison normal', 10, 'joe rakrouki<br/>92705635<br/>19 rue 11063 ibn sina tunis 2006', '07032021-60455683a3b4f', NULL, 0),
(43, 10, '2021-03-07 22:48:11', 'livraison normal', 10, 'joe rakrouki<br/>92705635<br/>19 rue 11063 ibn sina tunis 2006', '07032021-6045582b3ff4a', NULL, 0),
(44, 10, '2021-03-07 22:53:28', 'livraison normal', 10, 'joe rakrouki<br/>92705635<br/>19 rue 11063 ibn sina tunis 2006', '07032021-604559684ad86', 'cs_test_b14ctXwm0B8LtG2HgqfmELtXYrB1eEVgQYPezVsXbwSNk6BDMevEWwjaEe', 0),
(45, 10, '2021-03-07 22:54:40', 'livraison normal', 10, 'joe rakrouki<br/>92705635<br/>19 rue 11063 ibn sina tunis 2006', '07032021-604559b0c5f33', 'cs_test_b1m6oZU19QM2u7dzBFNKvLFSzCVK44dMqXtucKpYtWjou42navSgmTHmU1', 0),
(46, 10, '2021-03-09 21:22:03', 'livraison expresse', 20, 'joe rakrouki<br/>92705635<br/>19 rue 11063 ibn sina tunis 2006', '09032021-6047e6fbde28d', 'cs_test_b1DrN86ENfdAGjczARJcbbI8H29mNauQOm5P8RvXkhoT7wA8nMaU8pjbvR', 0),
(47, 10, '2021-03-10 21:47:27', 'livraison expresse', 20, 'joe rakrouki<br/>92705635<br/>19 rue 11063 ibn sina tunis 2006', '10032021-60493e6fec522', 'cs_test_b1gVGWOibLJtdhCFeiqz5i8wEeAjuRf92Ty7NKwV6KVAfNMEIuwfQvFO86', 1),
(48, 11, '2021-03-11 08:47:02', 'livraison expresse', 20, 'joe rakrouki<br/>92705635<br/>19 rue 11063 ibn sina tunis 2006', '11032021-6049d906d055e', 'cs_test_b1nm5SxKCvlbWzx9ERnnGcJQtRqfOGCrZ5IaVw7W2MoV3i8JvmRGnuu6pr', 1),
(49, 11, '2021-03-11 09:17:25', 'livraison expresse', 20, 'joe rakrouki<br/>92705635<br/>19 rue 11063 ibn sina tunis 2006', '11032021-6049e02592929', 'cs_test_b1vvX0efoDM0HqJ0cdTf8nA9EY58LbEunm42X2wb0M2nrNtKYZAltFserB', 1),
(50, 10, '2021-03-31 01:38:38', 'livraison expresse', 20, 'joe rakrouki<br/>92705635<br/>19 rue 11063 ibn sina tunis 2006', '31032021-6063d29e7774f', 'cs_test_b1jc7RWoxv3lMOXkdD0rUUmpGtRWhH1VPqjp7ZoGi6ytohz2KoIwIDec9P', 1),
(51, 10, '2021-03-31 09:33:55', 'livraison expresse', 20, 'joe rakrouki<br/>92705635<br/>19 rue 11063 ibn sina tunis 2006', '31032021-606442034edee', 'cs_test_b1mxCE3tFl4Wb71VFsSILtlKEGI7DZcYBiaTQKq4cRHJH5ma2SjLN0naXV', 0),
(52, 10, '2021-03-31 09:35:02', 'livraison expresse', 20, 'joe rakrouki<br/>92705635<br/>19 rue 11063 ibn sina tunis 2006', '31032021-606442468cbeb', 'cs_test_b1AZarxFQmhDr396pkwb7yJPa9G2tKAKfqogujwvZYtee4nXzBNBYXmvga', 0),
(53, 10, '2021-03-31 09:36:58', 'livraison normal', 10, 'joe rakrouki<br/>92705635<br/>19 rue 11063 ibn sina tunis 2006', '31032021-606442baeccc5', 'cs_test_b1rsr31zllyXm1H2LZ72F8cubOvJa3sZN4lrvtWCgxUDtp00DcjUcA8H5l', 1),
(54, 10, '2021-03-31 09:40:19', 'livraison expresse', 20, 'joe rakrouki<br/>92705635<br/>19 rue 11063 ibn sina tunis 2006', '31032021-606443831b7c3', 'cs_test_b1O16Lnxq7RRsS6NNpGumo1UN8nhad0FLVN3XRFMF9jueA1O3Ty7QbEpGN', 0),
(55, 10, '2021-03-31 09:41:48', 'livraison expresse', 20, 'joe rakrouki<br/>92705635<br/>19 rue 11063 ibn sina tunis 2006', '31032021-606443dcb055d', 'cs_test_b1EKWrUA6b5HMomBTEeYEVCGllFJk9ADB2qEJgLksYr5CCmFX2ZfPoBCSZ', 0),
(56, 10, '2021-03-31 10:10:26', 'livraison expresse', 20, 'joe rakrouki<br/>92705635<br/>19 rue 11063 ibn sina tunis 2006', '31032021-60644a928c3a5', 'cs_test_b1Xn0SEkd4C6EW4KcXWrTej94jMSmgAkGR4EXxxJSIl8mKtz6LnOJfseTN', 1),
(57, 10, '2021-03-31 10:19:02', 'livraison expresse', 20, 'joe rakrouki<br/>92705635<br/>19 rue 11063 ibn sina tunis 2006', '31032021-60644c9613f47', 'cs_test_b1goonqy223EzmatOmRyIJmbbSfveVOdX2ru1OKb9wSEY24DLcXshzqFrN', 1),
(58, 10, '2021-03-31 10:53:38', 'livraison expresse', 20, 'joe rakrouki<br/>92705635<br/>19 rue 11063 ibn sina tunis 2006', '31032021-606454b2d499c', 'cs_test_b1xYCEhd5C4uqOBURfIYYnaTfPmdB4RZIq8r1AIyNG3793tjGvLpJ0Bvy3', 1),
(59, 10, '2021-03-31 11:08:37', 'livraison expresse', 20, 'joe rakrouki<br/>92705635<br/>19 rue 11063 ibn sina tunis 2006', '31032021-606458352571f', NULL, 0),
(60, 10, '2021-03-31 11:09:29', 'livraison expresse', 20, 'joe rakrouki<br/>92705635<br/>19 rue 11063 ibn sina tunis 2006', '31032021-60645869edf67', NULL, 0),
(61, 10, '2021-03-31 11:15:58', 'livraison expresse', 20, 'joe rakrouki<br/>92705635<br/>19 rue 11063 ibn sina tunis 2006', '31032021-606459ee24f2f', NULL, 0),
(62, 10, '2021-03-31 11:18:38', 'livraison expresse', 20, 'joe rakrouki<br/>92705635<br/>19 rue 11063 ibn sina tunis 2006', '31032021-60645a8ebc7ae', NULL, 0),
(63, 10, '2021-03-31 11:24:00', 'livraison expresse', 20, 'joe rakrouki<br/>92705635<br/>19 rue 11063 ibn sina tunis 2006', '31032021-60645bd079039', NULL, 0),
(64, 10, '2021-03-31 11:24:32', 'livraison expresse', 20, 'joe rakrouki<br/>92705635<br/>19 rue 11063 ibn sina tunis 2006', '31032021-60645bf0d19ab', NULL, 0),
(65, 10, '2021-03-31 11:31:02', 'livraison expresse', 20, 'joe rakrouki<br/>92705635<br/>19 rue 11063 ibn sina tunis 2006', '31032021-60645d766d0b1', NULL, 0),
(66, 10, '2021-03-31 11:33:16', 'livraison expresse', 20, 'joe rakrouki<br/>92705635<br/>19 rue 11063 ibn sina tunis 2006', '31032021-60645dfcb7140', NULL, 0),
(67, 10, '2021-03-31 11:39:19', 'livraison expresse', 20, 'joe rakrouki<br/>92705635<br/>19 rue 11063 ibn sina tunis 2006', '31032021-60645f67b7dd3', NULL, 0),
(68, 10, '2021-03-31 11:41:07', 'livraison expresse', 20, 'joe rakrouki<br/>92705635<br/>19 rue 11063 ibn sina tunis 2006', '31032021-60645fd31e675', NULL, 0),
(69, 10, '2021-03-31 11:41:51', 'livraison expresse', 20, 'joe rakrouki<br/>92705635<br/>19 rue 11063 ibn sina tunis 2006', '31032021-60645fff8f8fb', NULL, 0),
(70, 10, '2021-03-31 11:47:05', 'livraison expresse', 20, 'joe rakrouki<br/>92705635<br/>19 rue 11063 ibn sina tunis 2006', '31032021-606461391d221', 'cs_test_b1boeaYXffrp3GaRUPbgSMg3qodugU0g957S74D8JVEtaQB49BOQMktEyn', 1),
(71, 10, '2021-03-31 12:49:39', 'livraison expresse', 20, 'joe rakrouki<br/>92705635<br/>19 rue 11063 ibn sina tunis 2006', '31032021-60646fe385bdb', NULL, 0),
(72, 10, '2021-03-31 12:54:32', 'livraison expresse', 20, 'joe rakrouki<br/>92705635<br/>19 rue 11063 ibn sina tunis 2006', '31032021-6064710830335', NULL, 0),
(73, 10, '2021-03-31 13:24:20', 'livraison expresse', 20, 'joe rakrouki<br/>92705635<br/>19 rue 11063 ibn sina tunis 2006', '31032021-6064780434877', 'cs_test_b1ohrQmuMud2916ik4wWApmT8sUOzqxUPTD22HOxNoEPrgFR4TH1tRahai', 1),
(74, 10, '2021-03-31 16:04:19', 'livraison expresse', 20, 'joe rakrouki<br/>92705635<br/>19 rue 11063 ibn sina tunis 2006', '31032021-60649d836cb10', 'cs_test_b1jW5DycWVDL4DAenFxmqF7Biy4RKAJzPr2UkCYdMEFIUa6jgTEkKzhYC9', 1),
(75, 10, '2021-03-31 16:08:19', 'livraison normal', 10, 'joe rakrouki<br/>92705635<br/>19 rue 11063 ibn sina tunis 2006', '31032021-60649e737ad79', 'cs_test_b1NcOLBDRJpWfHIuzJVuOFdHEvighD0k3InNDM7d6xKhReMuTfWzUJDms7', 1),
(76, 10, '2021-03-31 23:49:04', 'livraison normal', 10, 'joe rakrouki<br/>92705635<br/>19 rue 11063 ibn sina tunis 2006', '31032021-60650a7089a6a', 'cs_test_b1nXgDZL3bkXCj3yjXyfHkyfree2BhuchtNKcWQzAdgFNcNeqStxvAf91T', 1),
(77, 11, '2021-04-01 09:00:09', 'livraison normal', 10, 'joe rakrouki<br/>92705635<br/>19 rue 11063 ibn sina tunis 2006', '01042021-60658b997a761', 'cs_test_b1c143fvmWADEhndojreuVtjA26XT5ESdcureM1A5FjA0Jf72wkbvIE5Iy', 1),
(78, 11, '2021-04-01 09:23:25', 'livraison normal', 10, 'joe rakrouki<br/>92705635<br/>19 rue 11063 ibn sina gabes 1009', '01042021-6065910de6bdd', 'cs_test_b1iEUMbbRldo94KS7RJGrZ313gpsQMUhKPmwHTWTMfGX5Bn5Y8ULc5qgZk', 1),
(79, 11, '2021-04-29 01:27:31', 'livraison expresse', 25, 'joe rakrouki<br/>92705635<br/>19 rue 11063 ibn sina gabes 1009', '29042021-608a0b839e644', 'cs_test_b1nk8Ktx91oN41euuAYACF6Lbtqz3QrHAyE9wLi4WEKkxJGU0GnF6AAaTE', 1),
(80, 11, '2021-05-14 12:37:31', 'livraison gratuite', 0, 'joe rakrouki<br/>92705635<br/>19 rue 11063 ibn sina gabes 1009', '14052021-609e6f0be666e', 'cs_test_b1FDWVYOKdIjsxMTiPQRmBX7ARwQp2nXi8w7aYEn1g0uvvPko3M73YtY3M', 1),
(81, 11, '2021-05-15 21:18:28', 'livraison expresse', 25, 'joe rakrouki<br/>92705635<br/>19 rue 11063 ibn sina gabes 1009', '15052021-60a03aa4e8c6a', 'cs_test_b168XdDjd5az4hDPLBJnC7Zm2ArkKg6Aicg0E12FkrZ01tIQFiBsp9cCNP', 1),
(82, 11, '2021-05-15 23:08:59', 'livraison gratuite', 0, 'joe rakrouki<br/>92705635<br/>19 rue 11063 ibn sina gabes 1009', '15052021-60a0548b8f383', 'cs_test_b1hN74dsDDbmg9dK6d8Mtv4PUnH6CExtQB3jPmOzjEvmdT8PRVOrfUqzgx', 0);

-- --------------------------------------------------------

--
-- Structure de la table `order_details`
--

CREATE TABLE `order_details` (
  `id` int(11) NOT NULL,
  `my_order_id` int(11) NOT NULL,
  `product` varchar(255) NOT NULL,
  `quantity` int(11) NOT NULL,
  `price` double NOT NULL,
  `total` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `order_details`
--

INSERT INTO `order_details` (`id`, `my_order_id`, `product`, `quantity`, `price`, `total`) VALUES
(31, 16, 'cachecol2', 2, 20, 40),
(32, 16, 'bonnet-bleu', 2, 20, 40),
(33, 17, 'cachecol2', 2, 20, 40),
(34, 17, 'bonnet-bleu', 2, 20, 40),
(35, 18, 'manteau 1', 1, 45, 45),
(36, 19, 'bonnet-rouge', 1, 20, 20),
(37, 20, 'bonnet-bleu', 2, 20, 40),
(38, 21, 'bonnet-bleu', 2, 20, 40),
(39, 22, 'bonnet-bleu', 2, 20, 40),
(40, 22, 'bonnet-rouge', 1, 20, 20),
(41, 23, 'bonnet-bleu', 2, 20, 40),
(42, 23, 'bonnet-rouge', 1, 20, 20),
(43, 24, 'manteau 1', 2, 45, 90),
(44, 25, 'manteau 1', 2, 45, 90),
(45, 26, 'manteau 1', 2, 45, 90),
(46, 27, 'manteau 1', 2, 45, 90),
(47, 28, 'manteau 1', 2, 45, 90),
(48, 29, 'manteau 1', 2, 45, 90),
(49, 30, 'manteau 1', 2, 45, 90),
(50, 31, 'manteau 1', 2, 45, 90),
(51, 32, 'manteau 1', 2, 45, 90),
(52, 32, 'bonnet-bleu', 1, 20, 20),
(53, 33, 'manteau 1', 2, 45, 90),
(54, 33, 'bonnet-bleu', 1, 20, 20),
(55, 34, 'manteau 1', 2, 45, 90),
(56, 34, 'bonnet-bleu', 1, 20, 20),
(57, 35, 'cachecol2', 2, 20, 40),
(58, 35, 'manteau 1', 1, 45, 45),
(59, 36, 'cachecol2', 2, 20, 40),
(60, 36, 'manteau 1', 1, 45, 45),
(61, 37, 'cachecol2', 2, 20, 40),
(62, 37, 'manteau 1', 1, 45, 45),
(63, 38, 'cachecol2', 2, 20, 40),
(64, 38, 'manteau 1', 1, 45, 45),
(65, 39, 'cachecol2', 2, 20, 40),
(66, 39, 'manteau 1', 1, 45, 45),
(67, 40, 'cachecol2', 2, 20, 40),
(68, 40, 'manteau 1', 1, 45, 45),
(69, 41, 'cachecol2', 2, 20, 40),
(70, 41, 'manteau 1', 2, 45, 90),
(71, 42, 'cachecol2', 1, 20, 20),
(72, 43, 'cachecol2', 1, 20, 20),
(73, 44, 'cachecol2', 1, 20, 20),
(74, 45, 'cachecol2', 2, 20, 40),
(75, 46, 'bonnet-rouge', 2, 20, 40),
(76, 47, 'bonnet-rouge', 1, 20, 20),
(77, 48, 'bonnet-rouge', 1, 20, 20),
(78, 49, 'bonnet-bleu', 1, 20, 20),
(79, 50, 'bonnet-rouge', 1, 20, 20),
(80, 51, 'bonnet-rouge', 1, 20, 20),
(81, 52, 'bonnet-rouge', 1, 20, 20),
(82, 53, 'bonnet-rouge', 1, 20, 20),
(83, 53, 'bonnet-bleu', 1, 20, 20),
(84, 54, 'bonnet-bleu', 1, 20, 20),
(85, 55, 'bonnet-bleu', 1, 20, 20),
(86, 56, 'bonnet-bleu', 2, 20, 40),
(87, 57, 'cachecol2', 1, 20, 20),
(88, 58, 'bonnet-rouge', 1, 20, 20),
(89, 59, 'cachecol2', 1, 20, 20),
(90, 60, 'cachecol2', 1, 20, 20),
(91, 61, 'cachecol2', 1, 20, 20),
(92, 62, 'cachecol2', 2, 20, 40),
(93, 63, 'cachecol2', 2, 20, 40),
(94, 64, 'cachecol2', 2, 20, 40),
(95, 65, 'cachecol2', 2, 20, 40),
(96, 66, 'cachecol2', 2, 20, 40),
(97, 66, 'bonnet-rouge', 1, 20, 20),
(98, 67, 'cachecol2', 2, 20, 40),
(99, 67, 'bonnet-rouge', 1, 20, 20),
(100, 68, 'cachecol2', 2, 20, 40),
(101, 68, 'bonnet-rouge', 1, 20, 20),
(102, 69, 'cachecol2', 2, 20, 40),
(103, 69, 'bonnet-rouge', 1, 20, 20),
(104, 70, 'cachecol2', 2, 20, 40),
(105, 70, 'bonnet-rouge', 1, 20, 20),
(106, 70, 'bonnet-bleu', 1, 20, 20),
(107, 71, 'bonnet-rouge', 1, 20, 20),
(108, 72, 'bonnet-rouge', 1, 20, 20),
(109, 73, 'bonnet-rouge', 1, 20, 20),
(110, 73, 'bonnet-bleu', 1, 20, 20),
(111, 74, 'bonnet-rouge', 1, 20, 20),
(112, 75, 'bonnet-rouge', 1, 20, 20),
(113, 76, 'tshirt', 1, 20, 20),
(114, 77, 'bonnet-rouge', 1, 20, 20),
(115, 78, 'bonnet-rouge', 2, 20, 40),
(116, 79, 'bonnet', 2, 20, 40),
(117, 79, 'bonnet', 1, 105, 105),
(118, 80, 'bonnet', 1, 105, 105),
(119, 81, 'bonnet', 1, 105, 105),
(120, 82, 'produit', 1, 30, 30);

-- --------------------------------------------------------

--
-- Structure de la table `panier`
--

CREATE TABLE `panier` (
  `id` int(11) NOT NULL,
  `nom` varchar(255) NOT NULL,
  `quantite` int(11) NOT NULL,
  `iduser` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `panier`
--

INSERT INTO `panier` (`id`, `nom`, `quantite`, `iduser`) VALUES
(4, 'gdfgdf', 45, 0),
(5, 'gdfgdf', 45544, 0),
(6, 'ojjjklkj', 3232, 0),
(7, 'hxcvbxcvxc', 54, 0),
(9, 'lkjkljkljjj', 5454, 0),
(10, 'lkjkljkljjj', 5, 0),
(11, 'lkjkljkljjj', 5, 6),
(13, 'fff', 4, 6),
(14, 'az', 4, 4),
(15, 'gdfgdf', 45544, 4),
(16, 'azeea', 4, 4),
(17, 'ezez', 4, 6),
(18, 'az', 444, 8),
(19, 'zz', 4, 4),
(20, 'aaa', 8, 15),
(21, 'zz', 14, 15);

-- --------------------------------------------------------

--
-- Structure de la table `participation_eve`
--

CREATE TABLE `participation_eve` (
  `id_participation` int(11) NOT NULL,
  `id_evenement` int(11) NOT NULL,
  `id_participant` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `participation_eve`
--

INSERT INTO `participation_eve` (`id_participation`, `id_evenement`, `id_participant`) VALUES
(1, 1, 12),
(2, 2, 1),
(3, 2, 3);

-- --------------------------------------------------------

--
-- Structure de la table `plats`
--

CREATE TABLE `plats` (
  `id_plat` int(11) NOT NULL,
  `id_resto` int(11) NOT NULL,
  `nom` varchar(255) NOT NULL,
  `composition` varchar(255) NOT NULL,
  `prix` double NOT NULL,
  `type` varchar(255) NOT NULL,
  `photo` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `plats`
--

INSERT INTO `plats` (`id_plat`, `id_resto`, `nom`, `composition`, `prix`, `type`, `photo`) VALUES
(1, 2, 'ftour sbeh', '3dham chameya maajoun jben zit zitouna', 10, 'tunisienne', 'ea1a3b0270774adc43955d7d51c856f8.jpg'),
(3, 2, 'ftour nos nhar', '3dham chameya maajoun jben zit zitouna zebda', 10, 'tunisienne', '35d0956504d957fd25c7df26a7e77cb2.jpg'),
(4, 4, 'plat tunisien', 'composition', 15, 'type', '20210429_10015204dc3cf67714ecb34d45ace360041d0b.jpg');

-- --------------------------------------------------------

--
-- Structure de la table `product`
--

CREATE TABLE `product` (
  `id` int(11) NOT NULL,
  `category_id` int(11) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `image` varchar(255) NOT NULL,
  `subtitle` varchar(255) NOT NULL,
  `prix` double NOT NULL,
  `description` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `product`
--

INSERT INTO `product` (`id`, `category_id`, `name`, `image`, `subtitle`, `prix`, `description`) VALUES
(18, 3, 'creme', 'bhbb', 'kkkk', 1255, 'jjjj'),
(19, 10, 'kkk', 'kk', 'kkk', 150, 'mmmm'),
(20, 3, 'serume', 'kkk', 'solde', 120, 'des'),
(21, 3, 'hhhh', 'llll', 'kkkk', 123, 'hhhh'),
(24, 3, 'ecran', 'kkk', 'klll', 125, 'kkkk'),
(25, 2, 'zzae', 'mklmlk', 'sdsd', 11, 'azeaze'),
(26, 2, 'aezaz', 'C:\\Users\\hp\\Downloads\\ons.produit1 (1).rar', 'zaeaz', 11, 'aezaze');

-- --------------------------------------------------------

--
-- Structure de la table `produit`
--

CREATE TABLE `produit` (
  `id` int(11) NOT NULL,
  `prix` int(11) NOT NULL,
  `photo` varchar(255) NOT NULL,
  `nom` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Structure de la table `reclamation`
--

CREATE TABLE `reclamation` (
  `id` int(11) NOT NULL,
  `date` date NOT NULL,
  `type` varchar(255) NOT NULL,
  `etat` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL,
  `iduser` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `reclamation`
--

INSERT INTO `reclamation` (`id`, `date`, `type`, `etat`, `description`, `iduser`) VALUES
(11, '2023-05-01', 'Application', 'Accepted', 'DFSDFQ', 6),
(12, '2023-05-01', 'Application', 'non traité', 'ezrez', 4),
(13, '2023-05-01', 'User', 'Rejected', 'erfdfd', 4),
(14, '2023-05-01', 'User', 'Accepted', '1212', 4),
(15, '2023-05-01', 'Application', 'Rejected', 'lll', 4),
(16, '2023-05-01', 'Publication', 'Rejected', 'hjhgg', 13);

-- --------------------------------------------------------

--
-- Structure de la table `reservation_competition`
--

CREATE TABLE `reservation_competition` (
  `id` int(11) NOT NULL,
  `competition_id` int(11) DEFAULT NULL,
  `nbrparticipants` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `reservation_competition`
--

INSERT INTO `reservation_competition` (`id`, `competition_id`, `nbrparticipants`) VALUES
(1, 1, 3),
(2, 3, 222),
(3, 3, 8956),
(4, 2, 85);

-- --------------------------------------------------------

--
-- Structure de la table `reservation_plats`
--

CREATE TABLE `reservation_plats` (
  `id_res_plat` int(11) NOT NULL,
  `id_client` int(11) NOT NULL,
  `id_plat` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  `date_reservation` datetime NOT NULL,
  `etat` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `reservation_plats`
--

INSERT INTO `reservation_plats` (`id_res_plat`, `id_client`, `id_plat`, `quantity`, `date_reservation`, `etat`) VALUES
(2, 25, 1, 2, '2021-04-29 00:00:00', 1);

-- --------------------------------------------------------

--
-- Structure de la table `reset_password`
--

CREATE TABLE `reset_password` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `token` varchar(255) NOT NULL,
  `created_at` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `reset_password`
--

INSERT INTO `reset_password` (`id`, `user_id`, `token`, `created_at`) VALUES
(1, 11, '606584652d92b', '2021-04-01 08:29:25'),
(2, 11, '60658efe0110c', '2021-04-01 09:14:38'),
(3, 11, '608a0acd71dbe', '2021-04-29 01:24:29'),
(4, 11, '608b0a35d8969', '2021-04-29 19:34:13'),
(5, 11, '609e6e2d24eb5', '2021-05-14 12:33:49');

-- --------------------------------------------------------

--
-- Structure de la table `response`
--

CREATE TABLE `response` (
  `id` int(11) NOT NULL,
  `reclamation_id` int(11) DEFAULT NULL,
  `description` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Structure de la table `restaurants`
--

CREATE TABLE `restaurants` (
  `id_resto` int(11) NOT NULL,
  `nom` varchar(255) NOT NULL,
  `adresse` varchar(255) NOT NULL,
  `ville` varchar(255) NOT NULL,
  `description` varchar(10000) NOT NULL,
  `type` varchar(255) NOT NULL,
  `photo` varchar(255) NOT NULL,
  `num_tel` int(11) NOT NULL,
  `email` varchar(255) NOT NULL,
  `note` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `restaurants`
--

INSERT INTO `restaurants` (`id_resto`, `nom`, `adresse`, `ville`, `description`, `type`, `photo`, `num_tel`, `email`, `note`) VALUES
(2, 'why not', '19 rue 11063 ibn sina', 'tunis', 'description', 'tunisienne', '20210429_07304504dc3cf67714ecb34d45ace360041d0b.jpg', 12212234, 'youssef.rakrouki@esprit.tn', 3),
(4, 'mexicano', 'description', 'ibn sina', 'tunis', 'type', '20210429_10005404dc3cf67714ecb34d45ace360041d0b.jpg', 92705635, 'youssef.rakrouki.1@yopmail.com', 5);

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `email` varchar(180) NOT NULL,
  `roles` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `firstname` varchar(255) NOT NULL,
  `lastname` varchar(255) NOT NULL,
  `image` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `role` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`id`, `email`, `roles`, `password`, `firstname`, `lastname`, `image`, `code`, `role`) VALUES
(1, 'youssef.rakrouki1998@yopmail.com', NULL, 'QQRRSSTTUU', 'youssef', 'rakrouki', 'aaa', NULL, 'client'),
(6, 'youssef@aa.cc', '[]', '$2y$13$5OhxFMv/8pS2H7YqrxDTh.YAx5KkU29Mxj83X96D.vUZfVZO2XSw6', 'joe', 'RAKROUKI', NULL, NULL, ''),
(7, 'youssef@yy.com', '[]', '$2y$13$ccfd3A0c1uaHH0qyLiaT4OyN5A2zgMflxYKscXvC9FwUubB0z5tzu', 'joe', 'RAKROUKI', NULL, NULL, ''),
(8, 'haithem.angelcall@gmail.com', '[]', '$2y$13$b/yeS4qe79IsJuz8LXkb2O761mSZ0A1i1XjHU8Ofe4NMI.AhMsJIK', 'haithem', 'chaabani', NULL, NULL, ''),
(9, 'youssef@ee.com', '[]', '$2y$13$oePCpcoluFkGkbj/JKdAmOP3jHgm77jhZ39vAxYKAGdjAbfaWtS0m', 'youssef', 'rakrouki', NULL, NULL, ''),
(10, 'youssef@email.tn', '[\"ROLE_ADMIN\"]', '$2y$13$dIT4tjJ3tTAJ1GygwOnLoeRb.13EQe0L8eFWTSDI9r9vRTYd3RWu6', 'joseph', 'RAKROUKI', 'b2816c7f0a057e402f4e2f00a434c345.jpg', NULL, ''),
(11, 'youssef.rakrouki@esprit.tn', '[\"ROLE_ADMIN\"]', '$2y$13$E4/W0tZmCuMHtNhc8/VL6.E9MKatzDwtVEslxSnSDzLdLxCILwxqe', 'youssef', 'RAKROUKI', 'f9e6c89cb5fbcb4a6bc7f1acb63fcbc6.jpg', '6PUrRwwzzQ', ''),
(12, 'youssef.rak@email.com', '[]', '$2y$13$xoKeNd17tYkXLoMR9v5czurScUKbnUL70TnWukLHNvtWxdd1CKHpC', 'youssef', 'rakrouki', NULL, NULL, ''),
(13, 'mohamed.testouri@esprit.tnn', 'admin', 'azerazer123', 'Mohamed', 'Testouri', 'dfghuioprtyuiop', 'USHzZO0nFd', 'admin'),
(14, 'mohamed.testouri@esprit.tn', NULL, 'azeazeaze', 'med', 'test', 'rtyhjkl', 'ZdL5WYkZU6', 'client'),
(15, 'aaazz@aaz.az', NULL, 'azerazerazer', 'aaaa', 'aaaaz', 'ijaijaiaia', NULL, 'Client'),
(16, 'hbj@guhibkn.ijf', NULL, '123456789', 'oughibkjnlk', 'ugvhbikjlk', 'ugvhibjnolk', NULL, 'admin'),
(17, 'youssef.rakrouki@ieee.org', NULL, 'aabbccddee', 'joe', 'rakrouki', 'aaaa', NULL, 'admin'),
(18, 'yrakrouki98@gmail.com', NULL, 'aabbccddee', 'youssef', 'rakrouki', 'aaaa', 'F3eHGoqJdR', 'client'),
(19, 'youssef.r@aa.com', NULL, 'QQRRSSTTUU', 'joe', 'rak', 'aaaa', NULL, 'admin'),
(20, 'youssef.rak98@yopmail.com', NULL, 'QQRRSSTTUU', 'youssef', 'rakrouki', 'aaa', NULL, 'admin'),
(21, 'aabb@email.com', NULL, 'QQRRSSTTUU', 'youssef', 'rak', 'aaa', NULL, 'client'),
(23, 'youssef.rakrouki.1998@yopmail.com', NULL, 'aaccbbddee', 'youssef', 'rakrouki', 'aaa', '6fDDkgryNH', 'admin'),
(24, 'youssef.rakrouki.1@yopmail.com', NULL, 'QQRRSSTTUU', 'youssef', 'rakrouki', 'aaa', NULL, 'admin'),
(25, 'youssef.rakrouki.2@yopmail.com', NULL, 'QQRRSSTTUU', 'youssef', 'rakrouki', 'aaa', NULL, 'client');

-- --------------------------------------------------------

--
-- Structure de la table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `lastname` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `gender` varchar(255) NOT NULL,
  `role` varchar(255) NOT NULL,
  `phone` int(11) NOT NULL,
  `birthday` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `users`
--

INSERT INTO `users` (`id`, `name`, `lastname`, `email`, `password`, `gender`, `role`, `phone`, `birthday`) VALUES
(4, 'hhff', 'hh', 'hh', '12', 'male', 'C:UsersYoussefDownloads155843058_2773951359486297_8591029021848132754_n (1).jpg', 4, '1993-02-01'),
(6, 'youssef', 'ouali', 'youssefouali20@gmail.com', '123456', 'homme', 'koko', 29265739, '2016-01-01'),
(13, 'jack', 'bessan', 'jack@gmail.com', 'jack02', 'male', '5f02a5c03d5ef7c71660a0f58b67c962.jpg', 29265739, '2016-01-01'),
(14, 'admin@gmail.com', 'aaaa', 'admin@gmail.com', '0000', 'male', '5d6851705b4f91985cd641a68afb653c.png', 92333996, '2017-02-02'),
(15, 'majd', 'majd', 'majd.idani@esprit.tn', '0000', 'male', 'ffff', 22905706, '2021-03-02'),
(16, 'Majd', 'aaaa', 'majd.dani@espri.tn', '123456', 'female', 'b05bcfc7d6864f352624dcd1ecf1d3d7.png', 92333996, '2016-01-01');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `adresse`
--
ALTER TABLE `adresse`
  ADD PRIMARY KEY (`id`),
  ADD KEY `IDX_C35F0816A76ED395` (`user_id`);

--
-- Index pour la table `article`
--
ALTER TABLE `article`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `carrier`
--
ALTER TABLE `carrier`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `commande`
--
ALTER TABLE `commande`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKPanierii` (`idPanier`);

--
-- Index pour la table `doctrine_migration_versions`
--
ALTER TABLE `doctrine_migration_versions`
  ADD PRIMARY KEY (`version`);

--
-- Index pour la table `messenger_messages`
--
ALTER TABLE `messenger_messages`
  ADD PRIMARY KEY (`id`),
  ADD KEY `IDX_75EA56E0FB7336F0` (`queue_name`),
  ADD KEY `IDX_75EA56E0E3BD61CE` (`available_at`),
  ADD KEY `IDX_75EA56E016BA31DB` (`delivered_at`);

--
-- Index pour la table `panier`
--
ALTER TABLE `panier`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `produit`
--
ALTER TABLE `produit`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `reclamation`
--
ALTER TABLE `reclamation`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `response`
--
ALTER TABLE `response`
  ADD PRIMARY KEY (`id`),
  ADD KEY `IDX_3E7B0BFB2D6BA2D9` (`reclamation_id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `article`
--
ALTER TABLE `article`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT pour la table `commande`
--
ALTER TABLE `commande`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=34;

--
-- AUTO_INCREMENT pour la table `messenger_messages`
--
ALTER TABLE `messenger_messages`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `panier`
--
ALTER TABLE `panier`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT pour la table `product`
--
ALTER TABLE `product`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- AUTO_INCREMENT pour la table `produit`
--
ALTER TABLE `produit`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `reclamation`
--
ALTER TABLE `reclamation`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT pour la table `response`
--
ALTER TABLE `response`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `commande`
--
ALTER TABLE `commande`
  ADD CONSTRAINT `FKPanierii` FOREIGN KEY (`idPanier`) REFERENCES `panier` (`id`);

--
-- Contraintes pour la table `response`
--
ALTER TABLE `response`
  ADD CONSTRAINT `FK_3E7B0BFB2D6BA2D9` FOREIGN KEY (`reclamation_id`) REFERENCES `reclamation` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
