INSERT INTO `db_gestion_ecole`.`personnes` (`type_personne`, `email`, `identifiant`, `mote_de_passe`, `nom`, `prenom`, `date_de_naissance`) VALUES ('ROLE_ADMIN', 'admin@gmail.com', 'admin', '111', 'Simard', 'Honoré', '1960/01/04/');

INSERT INTO `db_gestion_ecole`.`personnes` (`type_personne`, `email`, `identifiant`, `mote_de_passe`, `nom`, `prenom`, `date_de_naissance`) VALUES ('ROLE_ENS', 'm.tollmache@gmail.com', 'tmusette', '111', 'Tollmache', 'Musette', '1955/06/27');
INSERT INTO `db_gestion_ecole`.`personnes` (`type_personne`, `email`, `identifiant`, `mote_de_passe`, `nom`, `prenom`, `date_de_naissance`) VALUES ('ROLE_ENS', 'b.beaulac@gmail.com', 'bbeaulac', '111', 'Beaulac', 'Bevis', '1975/06/22');
INSERT INTO `db_gestion_ecole`.`personnes` (`type_personne`, `email`, `identifiant`, `mote_de_passe`, `nom`, `prenom`, `date_de_naissance`) VALUES ('ROLE_ENS', 'm.dubeau@gmail.com', 'mdubeau', '111', 'Dubeau', 'Martin', '1987/08/19');

INSERT INTO `db_gestion_ecole`.`adresses` (`code_postal`, `rue`, `ville`) VALUES ('83100', '23, rue du Fossé des Tanneurs', 'TOULON');
INSERT INTO `db_gestion_ecole`.`adresses` (`code_postal`, `rue`, `ville`) VALUES ('27200', '26, Rue Frédéric Chopin', 'VERNON');
INSERT INTO `db_gestion_ecole`.`adresses` (`code_postal`, `rue`, `ville`) VALUES ('13004', '64, rue Beauvau', 'MARSEILLE');
INSERT INTO `db_gestion_ecole`.`adresses` (`code_postal`, `rue`, `ville`) VALUES ('75009', '21, Place de la Madeleine', 'PARIS');
INSERT INTO `db_gestion_ecole`.`adresses` (`code_postal`, `rue`, `ville`) VALUES ('80090', '83, rue de Geneve', 'AMIENS');
INSERT INTO `db_gestion_ecole`.`adresses` (`code_postal`, `rue`, `ville`) VALUES ('33110', '39, boulevard Aristide Briand', 'LE BOUSCAT');
INSERT INTO `db_gestion_ecole`.`adresses` (`code_postal`, `rue`, `ville`) VALUES ('44100', '14, place Stanislas', 'NANTES');
INSERT INTO `db_gestion_ecole`.`adresses` (`code_postal`, `rue`, `ville`) VALUES ('13008', '11, cours Franklin Roosevelt', 'MARSEILLE');
INSERT INTO `db_gestion_ecole`.`adresses` (`code_postal`, `rue`, `ville`) VALUES ('13001', '90, rue Beauvau', 'MARSEILLE');
INSERT INTO `db_gestion_ecole`.`adresses` (`code_postal`, `rue`, `ville`) VALUES ('38500', '24, Rue Bonnet', 'VOIRON');
INSERT INTO `db_gestion_ecole`.`adresses` (`code_postal`, `rue`, `ville`) VALUES ('01100', '33, boulevard Amiral Courbet', 'OYONNAX');
INSERT INTO `db_gestion_ecole`.`adresses` (`code_postal`, `rue`, `ville`) VALUES ('63000', '44, Rue de Strasbourg', 'CLERMONT-FERRAND');
INSERT INTO `db_gestion_ecole`.`adresses` (`code_postal`, `rue`, `ville`) VALUES ('62100', '66, Chemin Du Lavarin Sud', 'CALAIS');
INSERT INTO `db_gestion_ecole`.`adresses` (`code_postal`, `rue`, `ville`) VALUES ('59190', '27, Avenue des Tuileries', 'HAZEBROUCK');
INSERT INTO `db_gestion_ecole`.`adresses` (`code_postal`, `rue`, `ville`) VALUES ('33160', '42, rue des Dunes', 'SAINT-MÉDARD-EN-JALLES');


UPDATE `db_gestion_ecole`.`personnes` SET `adresse_id`='1' WHERE `id_personne`='1';
UPDATE `db_gestion_ecole`.`personnes` SET `adresse_id`='2' WHERE `id_personne`='2';
UPDATE `db_gestion_ecole`.`personnes` SET `adresse_id`='3' WHERE `id_personne`='3';
UPDATE `db_gestion_ecole`.`personnes` SET `adresse_id`='4' WHERE `id_personne`='4';

INSERT INTO `db_gestion_ecole`.`matieres` (`libelle`, `enseignant_id`) VALUES ('Java', '2');
INSERT INTO `db_gestion_ecole`.`matieres` (`libelle`, `enseignant_id`) VALUES ('Phython', '3');
INSERT INTO `db_gestion_ecole`.`matieres` (`libelle`, `enseignant_id`) VALUES ('C++', '4');

INSERT INTO `db_gestion_ecole`.`promotions` (`libelle`) VALUES ('Master 1 Devr Web');
INSERT INTO `db_gestion_ecole`.`promotions` (`libelle`) VALUES ('Master 2 Dev Web');

INSERT INTO `db_gestion_ecole`.`personnes` (`type_personne`, `email`, `identifiant`, `mote_de_passe`, `nom`, `prenom`, `date_de_naissance`, `adresse_id`, `promotion_id`) VALUES ('ROLE_ETU', 'p.tessier@gmail.com', 'ptessier', '111', 'Tessier', 'Patrick', '1999/07/28', '5', '1');
INSERT INTO `db_gestion_ecole`.`personnes` (`type_personne`, `email`, `identifiant`, `mote_de_passe`, `nom`, `prenom`, `date_de_naissance`, `adresse_id`, `promotion_id`) VALUES ('ROLE_ETU', 'a.beland@gmail.com', 'abelan', '111', 'Beland', 'Arthur', '1997/07/14', '6', '1');
INSERT INTO `db_gestion_ecole`.`personnes` (`type_personne`, `email`, `identifiant`, `mote_de_passe`, `nom`, `prenom`, `date_de_naissance`, `adresse_id`, `promotion_id`) VALUES ('ROLE_ETU', 'e.bordeleau@gmail.com', 'ebordeleau', '111', 'Bordeleau', 'Evrad', '1998/02/14', '7', '1');
INSERT INTO `db_gestion_ecole`.`personnes` (`type_personne`, `email`, `identifiant`, `mote_de_passe`, `nom`, `prenom`, `date_de_naissance`, `adresse_id`, `promotion_id`) VALUES ('ROLE_ETU', 'p.rene@gmail.com', 'prene', '111', 'René', 'Paul', '1999/03/16', '8', '1');
INSERT INTO `db_gestion_ecole`.`personnes` (`type_personne`, `email`, `identifiant`, `mote_de_passe`, `nom`, `prenom`, `date_de_naissance`, `adresse_id`, `promotion_id`) VALUES ('ROLE_ETU', 'h.vadnais@gmail.com', 'hvadnais', '111', 'Vadnais', 'Henry', '2000/07/19', '9', '1');
INSERT INTO `db_gestion_ecole`.`personnes` (`type_personne`, `email`, `identifiant`, `mote_de_passe`, `nom`, `prenom`, `date_de_naissance`, `adresse_id`, `promotion_id`) VALUES ('ROLE_ETU', 'r.barjavel@gmail.com', 'rbarjavel', '111', 'Barjavel', 'Russell', '1996/12/25', '10', '2');
INSERT INTO `db_gestion_ecole`.`personnes` (`type_personne`, `email`, `identifiant`, `mote_de_passe`, `nom`, `prenom`, `date_de_naissance`, `adresse_id`, `promotion_id`) VALUES ('ROLE_ETU', 'p.loiseau@gmail.com', 'ploiseau', '111', 'Loiseau', 'Pauline', '1999/01/01', '11', '2');
INSERT INTO `db_gestion_ecole`.`personnes` (`type_personne`, `email`, `identifiant`, `mote_de_passe`, `nom`, `prenom`, `date_de_naissance`, `adresse_id`, `promotion_id`) VALUES ('ROLE_ETU', 'a.mercure@gmail.com', 'amercure', '111', 'Mercure', 'Aubert', '2001/03/19', '12', '2');
INSERT INTO `db_gestion_ecole`.`personnes` (`type_personne`, `email`, `identifiant`, `mote_de_passe`, `nom`, `prenom`, `date_de_naissance`, `adresse_id`, `promotion_id`) VALUES ('ROLE_ETU', 'e.auger@gmail.com', 'eauger', '111', 'Auger', 'Emmanuel', '1999/04/17', '13', '2');
INSERT INTO `db_gestion_ecole`.`personnes` (`type_personne`, `email`, `identifiant`, `mote_de_passe`, `nom`, `prenom`, `date_de_naissance`, `adresse_id`, `promotion_id`) VALUES ('ROLE_ETU', 'b.lamontagne@gmail.com', 'blamontagne', '111', 'Lamontagne', 'Blondelle', '1999/05/17', '14', '2');

INSERT INTO `db_gestion_ecole`.`cours` (`date`, `description`, `duree`, `libelle`, `matiere_id`, `promotion_id`) VALUES ('2020/08/12', 'Introduction à Java', '8', 'Java intro', '1', '1');
INSERT INTO `db_gestion_ecole`.`cours` (`date`, `description`, `duree`, `libelle`, `matiere_id`, `promotion_id`) VALUES ('2020/08/13', 'Mise en pratique de l\'intro java', '6', 'Java TP1', '1', '1');
INSERT INTO `db_gestion_ecole`.`cours` (`date`, `description`, `duree`, `libelle`, `matiere_id`, `promotion_id`) VALUES ('2020/08/14', 'Les streams en java', '4', 'Java Stream', '1', '1');
