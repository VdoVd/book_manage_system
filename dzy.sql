/*
SQLyog Ultimate v12.4.1 (64 bit)
MySQL - 5.5.27 : Database - dzy
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`dzy` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `dzy`;

/*Table structure for table `book` */

DROP TABLE IF EXISTS `book`;

CREATE TABLE `book` (
  `bookid` int(11) NOT NULL AUTO_INCREMENT,
  `bookname` varchar(20) NOT NULL,
  `publish` varchar(20) DEFAULT NULL,
  `author` varchar(20) DEFAULT NULL,
  `bookcount` int(11) NOT NULL,
  `booktype` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`bookid`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

/*Data for the table `book` */

insert  into `book`(`bookid`,`bookname`,`publish`,`author`,`bookcount`,`booktype`) values 
(1,'JAVA教程','外国出版社','刘畅',2,'计算机'),
(2,'C#教程','人民出版社','约翰逊',11,'计算机'),
(3,'C++教程','新华出版社','罗比特',10,'计算机'),
(4,'PHYTHON教程','陕西出版社','赛斯',10,'计算机'),
(5,'JS教程','渭南出版社','王能行',11,'计算机'),
(6,'小号入门教程','渭南出版社','王二能',10,'乐器'),
(7,'唢呐艺术','渭南出版社','欧阳',10,'乐器'),
(8,'长号入门教程','渭南出版社','王二能',10,'乐器'),
(9,'javaweb基础','尚硅谷','孙红康',10,'计算机'),
(10,'Hadoop从入门到精通','尚硅谷','孙红康',11,'计算机'),
(12,'爱情心理学','宝鸡大学出版社','蓓邰',12,'社科类'),
(13,'Hadoop从入门到精通','尚硅谷','宋红康',21,'计算机');

/*Table structure for table `operatebook` */

DROP TABLE IF EXISTS `operatebook`;

CREATE TABLE `operatebook` (
  `operatid` int(11) NOT NULL AUTO_INCREMENT,
  `bookid` int(11) NOT NULL,
  `bookname` varchar(20) NOT NULL,
  `userid` int(11) NOT NULL,
  `username` varchar(20) NOT NULL,
  `borrowtime` date NOT NULL,
  `renttime` int(11) NOT NULL,
  `isreturn` tinyint(1) NOT NULL,
  PRIMARY KEY (`operatid`),
  KEY `operatebook_ibfk_2` (`bookid`),
  KEY `operatebook_ibfk_1` (`userid`),
  CONSTRAINT `operatebook_ibfk_1` FOREIGN KEY (`userid`) REFERENCES `users` (`userid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `operatebook_ibfk_2` FOREIGN KEY (`bookid`) REFERENCES `book` (`bookid`)
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8;

/*Data for the table `operatebook` */

insert  into `operatebook`(`operatid`,`bookid`,`bookname`,`userid`,`username`,`borrowtime`,`renttime`,`isreturn`) values 
(22,2,'C#教程',5,'高怀玉','2018-12-08',60,1),
(23,2,'C#教程',5,'高怀玉','2018-12-08',60,1),
(24,2,'C#教程',5,'高怀玉','2018-12-08',60,1),
(25,2,'C#教程',5,'高怀玉','2018-12-08',60,1),
(27,2,'C#教程',5,'高怀玉','2018-12-08',60,1),
(28,2,'C#教程',5,'高怀玉','2018-12-08',60,1),
(29,2,'C#教程',5,'高怀玉','2018-12-08',60,1),
(30,2,'C#教程',5,'高怀玉','2018-12-08',60,1),
(31,2,'C#教程',5,'高怀玉','2018-12-08',60,1),
(32,3,'C++教程',2,'ghy','2018-12-08',30,0),
(33,4,'PHYTHON教程',4,'admin','2018-12-08',30,0),
(34,4,'PHYTHON教程',4,'admin','2018-12-08',30,0),
(35,4,'PHYTHON教程',4,'admin','2018-12-08',30,0),
(36,4,'PHYTHON教程',4,'admin','2018-12-08',30,0),
(37,4,'PHYTHON教程',4,'admin','2018-12-08',30,0),
(38,5,'JS教程',4,'admin','2018-12-08',30,1),
(39,5,'JS教程',4,'admin','2018-12-08',30,1),
(40,5,'JS教程',4,'admin','2018-12-08',30,1),
(41,5,'JS教程',4,'admin','2018-12-08',30,1),
(42,5,'JS教程',4,'admin','2018-12-08',30,1),
(43,5,'JS教程',4,'admin','2018-12-08',30,1),
(44,5,'JS教程',4,'admin','2018-12-08',30,1),
(45,5,'JS教程',4,'admin','2018-12-08',30,1),
(46,5,'JS教程',4,'admin','2018-12-08',30,1),
(47,5,'JS教程',4,'admin','2018-12-08',30,1),
(48,5,'JS教程',4,'admin','2018-12-08',30,1),
(49,5,'JS教程',4,'admin','2018-12-08',30,1),
(50,5,'JS教程',4,'admin','2018-12-08',30,1),
(51,4,'PHYTHON教程',5,'高怀玉','2018-12-08',30,0),
(52,10,'Hadoop从入门到精通',3,'fg','2018-12-09',30,0),
(53,1,'JAVA教程',4,'admin','2018-12-13',30,0);

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `userid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(10) NOT NULL,
  `passwords` varchar(10) NOT NULL,
  `birthday` datetime DEFAULT NULL,
  `sex` varchar(4) DEFAULT NULL,
  `usertype` int(11) NOT NULL,
  `isfull` varchar(2) DEFAULT NULL,
  `money` double DEFAULT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Data for the table `users` */

insert  into `users`(`userid`,`username`,`passwords`,`birthday`,`sex`,`usertype`,`isfull`,`money`) values 
(2,'ghy','123','2018-12-11 00:00:00','男',0,'0',0),
(3,'fg','123      ','1998-05-16 00:00:00','男',1,'0',0),
(4,'admin','123 ','2018-12-02 00:00:00','男',-1,'0',0),
(5,'高怀玉','409424','1996-05-28 00:00:00','男',0,'0',0),
(9,'高铭暄','1234','2018-12-03 00:00:00','男',1,'0',0),
(10,'王庭荣','1234','2018-12-04 00:00:00','男',0,'0',0);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
