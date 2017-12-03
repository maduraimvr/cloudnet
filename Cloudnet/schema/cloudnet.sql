# ************************************************************
# Sequel Pro SQL dump
# Version 4096
#
# http://www.sequelpro.com/
# http://code.google.com/p/sequel-pro/
#
# Host: 127.0.0.1 (MySQL 5.6.16)
# Database: green
# Generation Time: 2014-06-13 04:55:23 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table t_board
# ------------------------------------------------------------

DROP TABLE IF EXISTS `t_board`;

CREATE TABLE `t_board` (
  `board_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `board_name` varchar(150) NOT NULL DEFAULT '' COMMENT 'NAME',
  `board_desc` varchar(1000) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'DESC',
  `topic_num` int(11) NOT NULL DEFAULT '0' COMMENT 'NO',
  PRIMARY KEY (`board_id`),
  KEY `AK_Board_NAME` (`board_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `t_board` WRITE;
/*!40000 ALTER TABLE `t_board` DISABLE KEYS */;

/*!40000 ALTER TABLE `t_board` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table t_board_manager
# ------------------------------------------------------------

DROP TABLE IF EXISTS `t_board_manager`;

CREATE TABLE `t_board_manager` (
  `board_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`board_id`,`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Manager';



# Dump of table t_login_log
# ------------------------------------------------------------

DROP TABLE IF EXISTS `t_login_log`;

CREATE TABLE `t_login_log` (
  `login_log_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `ip` varchar(30) NOT NULL DEFAULT '',
  `login_datetime` varchar(14) NOT NULL,
  PRIMARY KEY (`login_log_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;





# Dump of table t_user
# ------------------------------------------------------------

DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Id',
  `user_name` varchar(30) NOT NULL COMMENT 'uname',
  `password` varchar(30) NOT NULL DEFAULT '' COMMENT 'password',
  `user_type` tinyint(4) NOT NULL DEFAULT '1' COMMENT 'type',
  `locked` tinyint(4) NOT NULL DEFAULT '0' COMMENT 'locked',
  `credit` int(11) DEFAULT NULL COMMENT 'credit',
  `last_visit` datetime DEFAULT NULL COMMENT 'lastvisit',
  `last_ip` varchar(20) DEFAULT NULL COMMENT 'ip',
  PRIMARY KEY (`user_id`),
  KEY `AK_AK_USER_USER_NAME` (`user_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `t_user` WRITE;
/*!40000 ALTER TABLE `t_user` DISABLE KEYS */;

INSERT INTO `t_user` (`user_id`, `user_name`, `password`, `user_type`, `locked`, `credit`, `last_visit`, `last_ip`)
VALUES
	(7,'admin','admin',2,0,820,'2014-06-13 12:50:03','0:0:0:0:0:0:0:1%0');

/*!40000 ALTER TABLE `t_user` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;


# Dump of table t_item
# ------------------------------------------------------------

DROP TABLE IF EXISTS `t_item`;

CREATE TABLE `t_item` (
  `item_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Id',
  `item_name` varchar(30) NOT NULL COMMENT 'itemname',
  `item_price` int(11) NOT NULL DEFAULT 0 COMMENT 'price',
  
  PRIMARY KEY (`item_id`),
  KEY `AK_AK_ITEM_ID` (`item_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
