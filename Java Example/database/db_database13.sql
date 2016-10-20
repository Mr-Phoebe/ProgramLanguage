-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.0.67-community-nt


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema db_database13
--

CREATE DATABASE IF NOT EXISTS db_database13;
USE db_database13;

--
-- Definition of table `tb_book`
--

DROP TABLE IF EXISTS `tb_book`;
CREATE TABLE `tb_book` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=123456790 DEFAULT CHARSET=gbk;

--
-- Dumping data for table `tb_book`
--

/*!40000 ALTER TABLE `tb_book` DISABLE KEYS */;
INSERT INTO `tb_book` (`id`,`name`) VALUES 
 (12345678,'Java范例大全二卷'),
 (123456789,'Java范例大全一卷');
/*!40000 ALTER TABLE `tb_book` ENABLE KEYS */;


--
-- Definition of table `tb_books1`
--

DROP TABLE IF EXISTS `tb_books1`;
CREATE TABLE `tb_books1` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `name` varchar(45) NOT NULL,
  `total` float NOT NULL,
  `species` varchar(45) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=gbk;

--
-- Dumping data for table `tb_books1`
--

/*!40000 ALTER TABLE `tb_books1` DISABLE KEYS */;
INSERT INTO `tb_books1` (`id`,`name`,`total`,`species`) VALUES 
 (1,'Java从入门到精通',59,'计算机类'),
 (2,'高二数学练习',26,'教材类'),
 (3,'Java实战开发1200例',89,'计算机类');
/*!40000 ALTER TABLE `tb_books1` ENABLE KEYS */;


--
-- Definition of table `tb_commodity`
--

DROP TABLE IF EXISTS `tb_commodity`;
CREATE TABLE `tb_commodity` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `name` varchar(45) NOT NULL,
  `price` float NOT NULL,
  `type` varchar(45) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=gbk;

--
-- Dumping data for table `tb_commodity`
--

/*!40000 ALTER TABLE `tb_commodity` DISABLE KEYS */;
INSERT INTO `tb_commodity` (`id`,`name`,`price`,`type`) VALUES 
 (1,'轻微',12,'爱上');
/*!40000 ALTER TABLE `tb_commodity` ENABLE KEYS */;


--
-- Definition of table `tb_employee`
--

DROP TABLE IF EXISTS `tb_employee`;
CREATE TABLE `tb_employee` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `name` varchar(45) NOT NULL,
  `sex` varchar(45) NOT NULL,
  `age` int(10) unsigned NOT NULL,
  `dept` varchar(45) NOT NULL,
  `duty` varchar(45) NOT NULL,
  `telephone` varchar(45) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=gbk;

--
-- Dumping data for table `tb_employee`
--

/*!40000 ALTER TABLE `tb_employee` DISABLE KEYS */;
INSERT INTO `tb_employee` (`id`,`name`,`sex`,`age`,`dept`,`duty`,`telephone`) VALUES 
 (1,'陈丹丹','女',26,'Java','程序员','123'),
 (2,'小李','男',27,'质量部','程序测试','123'),
 (3,'小王','女',28,'VB','程序员','1234'),
 (4,'小葛','男',29,'Java','程序员','123451'),
 (5,'小刘','男',26,'C#','程序员','12312'),
 (6,'小张','男',28,'销售部','业务员','123123'),
 (7,'陈丹丹','nv',26,'fg','tr','123123');
/*!40000 ALTER TABLE `tb_employee` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
