
DROP DATABASE IF EXISTS `univert`;

CREATE DATABASE IF NOT EXISTS `univert` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `univert`;



DROP TABLE IF EXISTS `u_badge`;
CREATE TABLE `u_badge` (
  `b_id` int(11) NOT NULL,
  `b_description` varchar(45) NOT NULL,
  `b_picture` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



INSERT INTO `u_badge` (`b_id`, `b_description`, `b_picture`) VALUES
(2, 'Super récolteur', 'BadgeSuperRecolteur.png'),
(3, 'Super tailleur', 'BadgeSuperTailleur.png'),
(4, 'Expert récolteur', 'BadgeExpertRecolteur.png'),
(5, 'Expert semeur', 'BadgeExpertSemeur.png');



DROP TABLE IF EXISTS `u_character`;
CREATE TABLE `u_character` (
  `c_id` int(11) NOT NULL,
  `c_name` varchar(45) NOT NULL,
  `c_experience` int(11) NOT NULL,
  `c_level` int(11) NOT NULL,
  `c_fk_garden` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



INSERT INTO `u_character` (`c_id`, `c_name`, `c_experience`, `c_level`, `c_fk_garden`) VALUES
(1, 'Andrè Le Notre', 600, 1, 1),
(2, 'Passe Partout', 730, 1, 1);



DROP TABLE IF EXISTS `u_character_badge`;
CREATE TABLE `u_character_badge` (
  `cb_id` int(11) NOT NULL,
  `cb_fk_character` int(11) NOT NULL,
  `cb_badge` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `u_character_item`;
CREATE TABLE `u_character_item` (
  `ci_id` int(11) NOT NULL,
  `ci_fk_character` int(11) NOT NULL,
  `ci_fk_item` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



DROP TABLE IF EXISTS `u_character_quest`;
CREATE TABLE `u_character_quest` (
  `cq_id` int(11) NOT NULL,
  `cq_fk_character` int(11) NOT NULL,
  `cq_fk_quest` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



DROP TABLE IF EXISTS `u_garden`;
CREATE TABLE `u_garden` (
  `g_id` int(11) NOT NULL,
  `g_name` varchar(45) NOT NULL,
  `g_num_row` int(11) NOT NULL,
  `g_num_col` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO `u_garden` (`g_id`, `g_name`, `g_num_row`, `g_num_col`) VALUES
(1, 'mon Jardin', 1, 1);


DROP TABLE IF EXISTS `u_item`;
CREATE TABLE `u_item` (
  `i_id` int(11) NOT NULL,
  `i_description` varchar(45) NOT NULL,
  `i_picture` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `u_item` (`i_id`, `i_description`, `i_picture`) VALUES
(2, 'Chapeau', 'ItemChapeau1.png'),
(3, 'Chapeau', 'ItemChapeau2.png'),
(4, 'Lunette', 'ItemLunette1.png'),
(5, 'Lunette', 'ItemLunette2.png'),
(6, 'Arrosoir', 'ItemArrosoir.png'),
(7, 'Pelle', 'ItemPelle.png');


DROP TABLE IF EXISTS `u_item_loot`;
CREATE TABLE `u_item_loot` (
  `il_id` int(11) NOT NULL,
  `u_fk_item` int(11) NOT NULL,
  `u_fk_loot_package` int(11) NOT NULL,
  `u_loot_chance` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



INSERT INTO `u_item_loot` (`il_id`, `u_fk_item`, `u_fk_loot_package`, `u_loot_chance`) VALUES
(2, 2, 2, 100),
(3, 3, 3, 100),
(4, 4, 4, 100),
(5, 5, 5, 100),
(6, 6, 6, 100),
(7, 7, 7, 100);



DROP TABLE IF EXISTS `u_loot_package`;
CREATE TABLE `u_loot_package` (
  `lp_id` int(11) NOT NULL,
  `lp_description` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



INSERT INTO `u_loot_package` (`lp_id`, `lp_description`) VALUES
(2, 'desc'),
(3, 'desc'),
(4, 'desc'),
(5, 'desc'),
(6, 'desc'),
(7, 'desc');



DROP TABLE IF EXISTS `u_plant`;
CREATE TABLE `u_plant` (
  `p_id` int(11) NOT NULL,
  `p_desciption` varchar(45) NOT NULL,
  `p_picture` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



INSERT INTO `u_plant` (`p_id`, `p_desciption`, `p_picture`) VALUES
(1, 'Radis', '');



DROP TABLE IF EXISTS `u_quest`;
CREATE TABLE `u_quest` (
  `q_id` int(11) NOT NULL,
  `q_title` varchar(45) NOT NULL,
  `q_description` varchar(1024) NOT NULL,
  `q_start_date` date DEFAULT NULL,
  `q_end_date` date DEFAULT NULL,
  `q_min_character` int(11) NOT NULL,
  `q_max_character` int(11) NOT NULL,
  `q_experience` int(11) NOT NULL,
  `q_fk_slot` int(11) NOT NULL,
  `q_fk_creation_user` int(11) DEFAULT NULL,
  `q_fk_loot_package` int(11) DEFAULT NULL,
  `q_fk_status` int(11) NOT NULL,
  `q_fk_type` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO `u_quest` (`q_id`, `q_title`, `q_description`, `q_start_date`, `q_end_date`, `q_min_character`, `q_max_character`, `q_experience`, `q_fk_slot`, `q_fk_creation_user`, `q_fk_loot_package`, `q_fk_status`, `q_fk_type`) VALUES
(2, 'Arroser les tomates', 'Arroser', NULL, NULL, 1, 2, 500, 1, NULL, 2, 4, NULL),
(3, 'Arracher les mauvaises herbes', 'Arracher', NULL, NULL, 1, 2, 600, 1, NULL, 3, 4, NULL),
(4, 'Récolter les fraises', 'Recolter', NULL, NULL, 1, 3, 300, 1, NULL, 4, 4, NULL),
(5, 'Récolter les pommes de terre', 'Recolter', NULL, NULL, 1, 3, 400, 1, NULL, 5, 4, NULL),
(6, 'Tailler les rosiers', 'Tailler', NULL, NULL, 1, 2, 500, 1, NULL, 6, 4, NULL),
(7, 'Arroser la salade', 'Arroser', NULL, NULL, 1, 2, 550, 1, NULL, 7, 4, NULL),
(8, 'Récolter les cerises', 'Recolter', NULL, NULL, 1, 1, 600, 1, NULL, 5, 4, NULL);



DROP TABLE IF EXISTS `u_slot`;
CREATE TABLE `u_slot` (
  `s_id` int(11) NOT NULL,
  `s_position_row` int(11) NOT NULL,
  `s_position_column` int(11) NOT NULL,
  `s_fk_garden` int(11) NOT NULL,
  `s_fk_plant` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO `u_slot` (`s_id`, `s_position_row`, `s_position_column`, `s_fk_garden`, `s_fk_plant`) VALUES
(1, 0, 0, 1, 1);



DROP TABLE IF EXISTS `u_status`;
CREATE TABLE `u_status` (
  `s_id` int(11) NOT NULL,
  `s_description` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



INSERT INTO `u_status` (`s_id`, `s_description`) VALUES
(1, 'InProgress'),
(2, 'Closed'),
(3, 'Canceled'),
(4, 'Open');



DROP TABLE IF EXISTS `u_type`;
CREATE TABLE `u_type` (
  `t_id` int(11) NOT NULL,
  `t_description` varchar(64) NOT NULL,
  `t_picture` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



DROP TABLE IF EXISTS `u_user`;
CREATE TABLE `u_user` (
  `u_id` int(11) NOT NULL,
  `u_username` varchar(45) NOT NULL,
  `u_password` varchar(45) NOT NULL,
  `u_badgeId` varchar(45) DEFAULT NULL,
  `u_email` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



INSERT INTO `u_user` (`u_id`, `u_username`, `u_password`, `u_badgeId`, `u_email`) VALUES
(1, 'bast', 'mdp', '044463b2744d80', 'bastien.laf@XXX.com'),
(2, 'identifiant', 'mdp2', '042563b2744d80', 'pasdemail');



DROP TABLE IF EXISTS `u_user_character`;
CREATE TABLE `u_user_character` (
  `uc_user_character` int(11) NOT NULL,
  `uc_fk_user` int(11) NOT NULL,
  `uc_fk_character` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



INSERT INTO `u_user_character` (`uc_user_character`, `uc_fk_user`, `uc_fk_character`) VALUES
(2, 1, 1),
(3, 2, 2);


ALTER TABLE `u_badge`
  ADD PRIMARY KEY (`b_id`),
  ADD UNIQUE KEY `b_id_UNIQUE` (`b_id`),
  ADD UNIQUE KEY `b_description_UNIQUE` (`b_description`);


ALTER TABLE `u_character`
  ADD PRIMARY KEY (`c_id`),
  ADD UNIQUE KEY `c_id_UNIQUE` (`c_id`),
  ADD KEY `fk_u_character_u_garden_idx` (`c_fk_garden`);


ALTER TABLE `u_character_badge`
  ADD PRIMARY KEY (`cb_id`),
  ADD UNIQUE KEY `cb_id_UNIQUE` (`cb_id`),
  ADD KEY `fk_u_character_badge_u_character1_idx` (`cb_fk_character`),
  ADD KEY `fk_u_character_badge_u_badge1_idx` (`cb_badge`);


ALTER TABLE `u_character_item`
  ADD PRIMARY KEY (`ci_id`),
  ADD UNIQUE KEY `ci_id_UNIQUE` (`ci_id`),
  ADD KEY `fk_u_character_item_u_character1_idx` (`ci_fk_character`),
  ADD KEY `fk_u_character_item_u_item1_idx` (`ci_fk_item`);


ALTER TABLE `u_character_quest`
  ADD PRIMARY KEY (`cq_id`),
  ADD UNIQUE KEY `cq_id_UNIQUE` (`cq_id`),
  ADD KEY `fk_u_character_quest_u_character1_idx` (`cq_fk_character`),
  ADD KEY `fk_u_character_quest_u_quest1_idx` (`cq_fk_quest`);


ALTER TABLE `u_garden`
  ADD PRIMARY KEY (`g_id`),
  ADD UNIQUE KEY `g_id_UNIQUE` (`g_id`),
  ADD UNIQUE KEY `g_name_UNIQUE` (`g_name`);


ALTER TABLE `u_item`
  ADD PRIMARY KEY (`i_id`),
  ADD UNIQUE KEY `i_id_UNIQUE` (`i_id`);


ALTER TABLE `u_item_loot`
  ADD PRIMARY KEY (`il_id`),
  ADD UNIQUE KEY `il_id_UNIQUE` (`il_id`),
  ADD KEY `fk_u_item_loot_u_item1_idx` (`u_fk_item`),
  ADD KEY `fk_u_item_loot_u_loot_package1_idx` (`u_fk_loot_package`);


ALTER TABLE `u_loot_package`
  ADD PRIMARY KEY (`lp_id`),
  ADD UNIQUE KEY `il_id_UNIQUE` (`lp_id`);


ALTER TABLE `u_plant`
  ADD PRIMARY KEY (`p_id`),
  ADD UNIQUE KEY `p_id_UNIQUE` (`p_id`);


ALTER TABLE `u_quest`
  ADD PRIMARY KEY (`q_id`),
  ADD UNIQUE KEY `q_id_UNIQUE` (`q_id`),
  ADD KEY `fk_u_quest_u_slot1_idx` (`q_fk_slot`),
  ADD KEY `fk_u_quest_u_character1_idx` (`q_fk_creation_user`),
  ADD KEY `fk_u_quest_u_loot_package1_idx` (`q_fk_loot_package`),
  ADD KEY `fk_u_quest_u_status1_idx` (`q_fk_status`),
  ADD KEY `fk_u_quest_u_type1_idx` (`q_fk_type`);


ALTER TABLE `u_slot`
  ADD PRIMARY KEY (`s_id`),
  ADD KEY `fk_u_slot_u_garden1_idx` (`s_fk_garden`),
  ADD KEY `fk_u_slot_u_plant1_idx` (`s_fk_plant`);


ALTER TABLE `u_status`
  ADD PRIMARY KEY (`s_id`),
  ADD UNIQUE KEY `s_id_UNIQUE` (`s_id`);


ALTER TABLE `u_type`
  ADD PRIMARY KEY (`t_id`),
  ADD UNIQUE KEY `t_id_UNIQUE` (`t_id`);


ALTER TABLE `u_user`
  ADD PRIMARY KEY (`u_id`),
  ADD UNIQUE KEY `u_username_UNIQUE` (`u_username`),
  ADD UNIQUE KEY `u_id_UNIQUE` (`u_id`);


ALTER TABLE `u_user_character`
  ADD PRIMARY KEY (`uc_user_character`),
  ADD UNIQUE KEY `uc_user_character_UNIQUE` (`uc_user_character`),
  ADD KEY `fk_u_user_character_u_user1_idx` (`uc_fk_user`),
  ADD KEY `fk_u_user_character_u_character1_idx` (`uc_fk_character`);


ALTER TABLE `u_badge`
  MODIFY `b_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

ALTER TABLE `u_character`
  MODIFY `c_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

ALTER TABLE `u_character_badge`
  MODIFY `cb_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

ALTER TABLE `u_character_item`
  MODIFY `ci_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

ALTER TABLE `u_character_quest`
  MODIFY `cq_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

ALTER TABLE `u_garden`
  MODIFY `g_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

ALTER TABLE `u_item`
  MODIFY `i_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

ALTER TABLE `u_item_loot`
  MODIFY `il_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

ALTER TABLE `u_loot_package`
  MODIFY `lp_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

ALTER TABLE `u_plant`
  MODIFY `p_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

ALTER TABLE `u_quest`
  MODIFY `q_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

ALTER TABLE `u_slot`
  MODIFY `s_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

ALTER TABLE `u_status`
  MODIFY `s_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

ALTER TABLE `u_type`
  MODIFY `t_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

ALTER TABLE `u_user`
  MODIFY `u_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

ALTER TABLE `u_user_character`
  MODIFY `uc_user_character` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

  
ALTER TABLE `u_character`
  ADD CONSTRAINT `fk_u_character_u_garden` FOREIGN KEY (`c_fk_garden`) REFERENCES `u_garden` (`g_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;


ALTER TABLE `u_character_badge`
  ADD CONSTRAINT `fk_u_character_badge_u_badge1` FOREIGN KEY (`cb_badge`) REFERENCES `u_badge` (`b_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_u_character_badge_u_character1` FOREIGN KEY (`cb_fk_character`) REFERENCES `u_character` (`c_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;


ALTER TABLE `u_character_item`
  ADD CONSTRAINT `fk_u_character_item_u_character1` FOREIGN KEY (`ci_fk_character`) REFERENCES `u_character` (`c_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_u_character_item_u_item1` FOREIGN KEY (`ci_fk_item`) REFERENCES `u_item` (`i_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;


ALTER TABLE `u_character_quest`
  ADD CONSTRAINT `fk_u_character_quest_u_character1` FOREIGN KEY (`cq_fk_character`) REFERENCES `u_character` (`c_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_u_character_quest_u_quest1` FOREIGN KEY (`cq_fk_quest`) REFERENCES `u_quest` (`q_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;


ALTER TABLE `u_item_loot`
  ADD CONSTRAINT `fk_u_item_loot_u_item1` FOREIGN KEY (`u_fk_item`) REFERENCES `u_item` (`i_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_u_item_loot_u_loot_package1` FOREIGN KEY (`u_fk_loot_package`) REFERENCES `u_loot_package` (`lp_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;


ALTER TABLE `u_quest`
  ADD CONSTRAINT `fk_u_quest_u_character1` FOREIGN KEY (`q_fk_creation_user`) REFERENCES `u_character` (`c_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_u_quest_u_loot_package1` FOREIGN KEY (`q_fk_loot_package`) REFERENCES `u_loot_package` (`lp_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_u_quest_u_slot1` FOREIGN KEY (`q_fk_slot`) REFERENCES `u_slot` (`s_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_u_quest_u_status1` FOREIGN KEY (`q_fk_status`) REFERENCES `u_status` (`s_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_u_quest_u_type1` FOREIGN KEY (`q_fk_type`) REFERENCES `u_type` (`t_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;


ALTER TABLE `u_slot`
  ADD CONSTRAINT `fk_u_slot_u_garden1` FOREIGN KEY (`s_fk_garden`) REFERENCES `u_garden` (`g_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_u_slot_u_plant1` FOREIGN KEY (`s_fk_plant`) REFERENCES `u_plant` (`p_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;


ALTER TABLE `u_user_character`
  ADD CONSTRAINT `fk_u_user_character_u_character1` FOREIGN KEY (`uc_fk_character`) REFERENCES `u_character` (`c_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_u_user_character_u_user1` FOREIGN KEY (`uc_fk_user`) REFERENCES `u_user` (`u_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;
