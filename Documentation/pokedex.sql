-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Client :  127.0.0.1
-- Généré le :  Lun 27 Février 2017 à 18:57
-- Version du serveur :  5.7.14
-- Version de PHP :  5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `pokedex`
--

-- --------------------------------------------------------

--
-- Structure de la table `havepokemon`
--

CREATE TABLE `havepokemon` (
  `ID` int(11) NOT NULL,
  `ID_user` int(11) NOT NULL,
  `ID_Pokemon` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `havepokemon`
--

INSERT INTO `havepokemon` (`ID`, `ID_user`, `ID_Pokemon`) VALUES
(43, 2, 107),
(27, 2, 3),
(42, 2, 26),
(11, 2, 2),
(41, 3, 16),
(28, 2, 1),
(40, 3, 144),
(39, 3, 14),
(38, 3, 13),
(37, 3, 10),
(36, 3, 7),
(35, 3, 4),
(34, 3, 1),
(33, 2, 6),
(32, 2, 10),
(30, 2, 7),
(29, 2, 12),
(44, 2, 123),
(45, 2, 149),
(46, 2, 151),
(47, 1, 1),
(48, 1, 2),
(49, 1, 6),
(50, 1, 9),
(51, 1, 9),
(52, 1, 15),
(53, 1, 16),
(54, 1, 59),
(55, 1, 106),
(56, 1, 123),
(57, 1, 122),
(58, 1, 58),
(59, 1, 25),
(60, 1, 130),
(61, 1, 143),
(62, 1, 148);

-- --------------------------------------------------------

--
-- Structure de la table `pokemon`
--

CREATE TABLE `pokemon` (
  `ID` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `HP` int(11) NOT NULL,
  `elementary` varchar(255) NOT NULL,
  `length` varchar(255) NOT NULL,
  `weight` varchar(255) NOT NULL,
  `weakness` varchar(255) NOT NULL,
  `attack` varchar(255) NOT NULL,
  `damage` int(11) NOT NULL,
  `pathPicture` varchar(255) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `pokemon`
--

INSERT INTO `pokemon` (`ID`, `name`, `HP`, `elementary`, `length`, `weight`, `weakness`, `attack`, `damage`, `pathPicture`) VALUES
(1, 'Bulbizarre', 40, 'Plante', '0.7m', '6.9kg', 'Feu', 'Vampigraine', 20, '/img/pokemon/Bulbizarre.png'),
(2, 'Herbizarre', 60, 'Plante', '1m', '13kg', 'Feu', 'Fouet-lianes', 30, '/img/pokemon/Herbizarre.png'),
(3, 'Florizarre', 100, 'Plante', '2m', '100kg', 'Feu', 'Lance-soleil', 60, '/img/pokemon/Florizarre.png'),
(4, 'Salamèche', 50, 'Feu', '0.6m', '8.5kg', 'Eau', 'Flammèche', 30, '/img/pokemon/Salamèche.png'),
(5, 'Reptincel', 80, 'Feu', '1.1m', '19kg', 'Eau', 'Lance-flamme', 50, '/img/pokemon/Reptincel.png'),
(6, 'Dracaufeu', 120, 'Feu', '1.7m', '90.5kg', 'Eau', 'Danseflamme', 100, '/img/pokemon/Dracaufeu.png'),
(7, 'Carapuce', 40, 'Eau', '0.5m', '9kg', 'Electrique', 'Ecume', 10, '/img/pokemon/Carapuce.png'),
(8, 'Carabaffe', 70, 'Eau', '1m', '22.5kg', 'Electrique', 'Morsure', 40, '/img/pokemon/Carabaffe.png'),
(9, 'Tortank', 100, 'Eau', '1.6m', '85.5kg', 'Electrique', 'Hydrocanon', 80, '/img/pokemon/Tortank.png'),
(10, 'Chenipan', 40, 'Plante', '0.3m', '2.9kg', 'Feu', 'Sécretion', 10, '/img/pokemon/Chenipan.png'),
(11, 'Chrysacier', 70, 'Plante', '0.7m', '9.9kg', 'Feu', 'Para-spore', 20, '/img/pokemon/Chrysacier.png'),
(12, 'Papilusion', 70, 'Plante', '1.1m', '32kg', 'Feu', 'Mega-sangsue', 40, '/img/pokemon/Papilusion.png'),
(13, 'Aspicot', 40, 'Plante', '0.3m', '3.2kg', 'Feu', 'Dard-venin', 10, '/img/pokemon/Aspicot.png'),
(14, 'Coconfort', 80, 'Plante', '0.6m', '10kg', 'Feu', 'Poudre-toxic', 20, '/img/pokemon/Coconfort.png'),
(15, 'Dardargnan', 80, 'Plante', '1m', '29.5kg', 'Feu', 'Dard-venin', 40, '/img/pokemon/Dardargnan.png'),
(16, 'Roucool', 40, 'Vol', '0.3m', '1.8kg', 'Electrique', 'Cyclone', 10, '/img/pokemon/Roucool.png'),
(17, 'Roucoups', 60, 'Vol', '1.1m', '30kg', 'Electrique', 'Cyclone', 20, '/img/pokemon/Roucoups.png'),
(18, 'Roucarnage', 80, 'Vol', '1.5m', '39.5kg', 'Electrique', 'Cru-Aile', 30, '/img/pokemon/Roucarnage.png'),
(25, 'Pikachu', 40, 'Electrique', '0.4m', '6kg', 'Combat', 'Tonnerre', 30, '/img/pokemon/Pikachu.png'),
(26, 'Raichu', 80, 'Electrique', '0.8m', '30kg', 'Combat', 'Fatal-Foudre', 60, '/img/pokemon/Raichu.png'),
(58, 'Caninos', 60, 'Feu', '0.7m', '19kg', 'Eau', 'Intimidation', 20, '/img/pokemon/Caninos.png'),
(59, 'Arcanin', 100, 'Feu', '1.9m', '155kg', 'Eau', 'Lance-Flamme', 50, '/img/pokemon/Arcanin.png'),
(106, 'Kicklee', 60, 'Combat', '1.5m', '49.5kg', 'Psy', 'Pied Voltige', 50, '/img/pokemon/Kicklee.png'),
(107, 'Tygnon', 60, 'Combat', '1.4m', '50.2kg', 'Psy', 'Punch Spécial', 40, '/img/pokemon/Tygnon.png'),
(122, 'Mr Mime', 40, 'Psy', '1.3m', '54.5kg', 'Psy', 'Yoga', 20, '/img/pokemon/Mr_Mime.png'),
(123, 'Insecateur', 70, 'Plante', '1.5m', '56kg', 'Feu', 'Tranche', 30, '/img/pokemon/Insecateur.png'),
(124, 'Lippoutou', 70, 'Psy', '1.4m', '40.6kg', 'Psy', 'Torgnoles', 20, '/img/pokemon/Lippoutou.png'),
(125, 'Elektek', 70, 'Electrique', '1.1m', '30kg', 'Combat', 'Poing-éclair', 30, '/img/pokemon/Elektek.png'),
(126, 'Magmar', 50, 'Feu', '1.3m', '44.5kg', 'Eau', 'Lance-Flamme', 50, '/img/pokemon/Magmar.png'),
(128, 'Tauros', 60, 'Normal', '1.4m', '88.4kg', 'Combat', 'Saccage', 30, '/img/pokemon/Tauros.png'),
(129, 'Magicarpe', 30, 'Eau', '0.9m', '10kg', 'Electrique', 'Nageoire', 10, '/img/pokemon/Magicarpe.png'),
(130, 'Leviator', 100, 'Eau', '6.5m', '235kg', 'Plante', 'Drago-rage', 50, '/img/pokemon/Leviator.png'),
(131, 'Lokhlass', 80, 'Eau', '2.5m', '220kg', 'Electrique', 'Pistolet à O', 30, '/img/pokemon/Lokhlass.png'),
(143, 'Ronflex', 90, 'Normal', '2.1m', '460kg', 'Combat', 'Plaquage', 30, '/img/pokemon/Ronflex.png'),
(144, 'Artikodin', 70, 'Glace', '1.7m', '55.4kg', '', 'Blizzard', 50, '/img/pokemon/Artikodin.png'),
(145, 'Electhor', 90, 'Electrique', '1.6m', '52.6kg', '', 'Fatal-Foudre', 100, '/img/pokemon/Electhor.png'),
(146, 'Sulfura', 70, 'Feu', '2m', '60kg', '', 'Bombardement', 80, '/img/pokemon/Sulfura.png'),
(147, 'Minidraco', 40, 'Dragon', '1.8m', '3.3kg', '', 'Ecras\'face', 10, '/img/pokemon/Minidraco.png'),
(148, 'Draco', 80, 'Dragon', '4m', '16.5kg', '', 'Souplesse', 40, '/img/pokemon/Draco.png'),
(149, 'Dracolosse', 100, 'Dragon', '2.2m', '210kg', '', 'Souplesse', 60, '/img/pokemon/Dracolosse.png'),
(150, 'Mewtwo', 60, 'Psy', '2m', '122kg', 'Psy', 'Psyko', 50, '/img/pokemon/Mewtwo.png'),
(151, 'Mew', 50, 'Psy', '0.4m', '4kg', 'Psy', 'Vague-psy', 50, '/img/pokemon/Mew.png');

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

CREATE TABLE `user` (
  `ID` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `firstname` varchar(255) NOT NULL,
  `pseudo` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `user`
--

INSERT INTO `user` (`ID`, `name`, `firstname`, `pseudo`, `password`) VALUES
(1, 'moderateur', 'pokedex', 'moderateur', '123456'),
(2, 'Hernandez', 'Julien', 'julienHernanBarragan', '123456'),
(3, 'Java', 'Prof', 'profjava', '123456');

--
-- Index pour les tables exportées
--

--
-- Index pour la table `havepokemon`
--
ALTER TABLE `havepokemon`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `FK_havePokemon_ID_user` (`ID_user`),
  ADD KEY `FK_havePokemon_ID_pokemon` (`ID_Pokemon`);

--
-- Index pour la table `pokemon`
--
ALTER TABLE `pokemon`
  ADD PRIMARY KEY (`ID`);

--
-- Index pour la table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `havepokemon`
--
ALTER TABLE `havepokemon`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=63;
--
-- AUTO_INCREMENT pour la table `user`
--
ALTER TABLE `user`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
