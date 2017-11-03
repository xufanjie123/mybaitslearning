/*
SQLyog v10.2 
MySQL - 5.7.17-log : Database - mybatistest
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`mybatistest` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `mybatistest`;

/*Table structure for table `items` */

DROP TABLE IF EXISTS `items`;

CREATE TABLE `items` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) DEFAULT NULL,
  `price` float(10,1) DEFAULT NULL,
  `detail` text,
  `pic` varchar(512) DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `items` */

/*Table structure for table `orderdetail` */

DROP TABLE IF EXISTS `orderdetail`;

CREATE TABLE `orderdetail` (
  `id` int(11) DEFAULT NULL,
  `orders_id` int(11) DEFAULT NULL,
  `items_id` int(11) DEFAULT NULL,
  `items_num` int(11) DEFAULT NULL,
  KEY `foreignkey_ordersid` (`orders_id`),
  KEY `foreignkey_itemsid` (`items_id`),
  CONSTRAINT `foreignkey_itemsid` FOREIGN KEY (`items_id`) REFERENCES `items` (`id`),
  CONSTRAINT `foreignkey_ordersid` FOREIGN KEY (`orders_id`) REFERENCES `orders` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `orderdetail` */

/*Table structure for table `orders` */

DROP TABLE IF EXISTS `orders`;

CREATE TABLE `orders` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `number` varchar(32) DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  `note` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `forenign_userid` (`user_id`),
  CONSTRAINT `forenign_userid` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `orders` */

insert  into `orders`(`id`,`user_id`,`number`,`createtime`,`note`) values (2,1,'21','2017-11-03 15:40:55',NULL),(3,3,'31','2017-11-03 15:41:10',NULL),(4,6,'432','2017-11-03 15:41:19',NULL);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(32) NOT NULL,
  `gender` varchar(8) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `address` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`username`,`gender`,`birthday`,`address`) values (1,'11111','male','2006-06-30',NULL),(2,'11111','female',NULL,NULL),(3,'33333','female',NULL,NULL),(5,'李四','male','1999-01-13','浙江省杭州市'),(6,'李四','male','3895-08-13','浙江省杭州市'),(7,'李四','male','1995-01-13','浙江省杭州市'),(10,'王五','male','2017-11-01','2312312');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
