-- MySQL dump 10.13  Distrib 5.7.20, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: mall
-- ------------------------------------------------------
-- Server version	5.5.36-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `address`
--

DROP TABLE IF EXISTS `address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `address` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `rec_user_name` varchar(45) DEFAULT NULL,
  `rec_user_phone` varchar(45) DEFAULT NULL,
  `rec_user_address` varchar(200) DEFAULT NULL,
  `rec_user_area` varchar(45) DEFAULT NULL,
  `is_default` int(11) DEFAULT NULL COMMENT '是否默认地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
INSERT INTO `address` VALUES (1,1,'丁玉新','13241115252','北京朝阳区创业新区','天津市',0),(14,1,'丁玉新','13241115253','花家地北里','北京市',0),(17,1,'城小亮','15116323254','大兴','河北省',0);
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `advert`
--

DROP TABLE IF EXISTS `advert`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `advert` (
  `id` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `image` varchar(400) DEFAULT NULL COMMENT '图片地址',
  `toUrl` varchar(400) DEFAULT NULL COMMENT '地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `advert`
--

LOCK TABLES `advert` WRITE;
/*!40000 ALTER TABLE `advert` DISABLE KEYS */;
INSERT INTO `advert` VALUES (1,'a1','static/images/wap/wepbanner.jpg','http://quandashi.com'),(2,'a2','static/images/wepindividuality01.jpg','http://jd.com');
/*!40000 ALTER TABLE `advert` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `goods`
--

DROP TABLE IF EXISTS `goods`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `goods` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `image` varchar(400) DEFAULT NULL,
  `num` int(11) DEFAULT NULL,
  `goodsNo` varchar(45) DEFAULT NULL COMMENT '商品编号',
  `price` varchar(45) DEFAULT NULL,
  `promotionPrice` varchar(45) DEFAULT NULL,
  `descripe` varchar(400) DEFAULT NULL,
  `isindex` int(11) NOT NULL DEFAULT '0' COMMENT '是否是首页商品1是0否',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `goods`
--

LOCK TABLES `goods` WRITE;
/*!40000 ALTER TABLE `goods` DISABLE KEYS */;
INSERT INTO `goods` VALUES (1,'麻糖','http://www.java1234.com/uploads/allimg/150616/1-15061610353M56.jpg',100,'86型插座5UB01081CC1','10.12','10','好吃不贵',0),(2,'西门子开关插座面板','static/images/wepindividuality01.jpg',100,'86型插座','55','50','西门子开关真是好',1),(3,'西门子开关插座面板','static/images/wepindividuality02.jpg',100,'85型插座','45','44.1','特别好',1);
/*!40000 ALTER TABLE `goods` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order`
--

DROP TABLE IF EXISTS `order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `orderCode` varchar(45) DEFAULT NULL,
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `userId` int(11) DEFAULT NULL,
  `recUserName` varchar(45) DEFAULT NULL,
  `recUserPhone` varchar(45) DEFAULT NULL,
  `recUserAddress` varchar(45) DEFAULT NULL,
  `goodsNum` int(11) DEFAULT NULL COMMENT '订单中商品的数量',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order`
--

LOCK TABLES `order` WRITE;
/*!40000 ALTER TABLE `order` DISABLE KEYS */;
INSERT INTO `order` VALUES (1,NULL,'2017-12-02 10:09:31',1,'丁玉新','13241115253','北京市朝阳区',NULL),(2,NULL,'2017-12-02 10:09:31',1,'丁玉新','13241115253','北京市朝阳区',NULL),(3,NULL,'2017-12-02 10:09:31',1,'丁玉新','13241115253','北京市朝阳区',NULL),(4,'77c868add21547a9b866cb3b3ebdd03c','2017-12-02 10:15:05',1,'丁玉新','13241115253','北京市朝阳区',NULL),(5,'ffd76f098aac42a9abb82e00d6ec2cd8','2017-12-02 10:20:01',1,'丁玉新','13241115253','北京市朝阳区',3);
/*!40000 ALTER TABLE `order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_goods`
--

DROP TABLE IF EXISTS `order_goods`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order_goods` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `orderCode` varchar(45) DEFAULT NULL,
  `goodsName` varchar(45) DEFAULT NULL,
  `goodsImg` varchar(45) DEFAULT NULL,
  `goodsPrice` varchar(45) DEFAULT NULL,
  `goodsPromotionPrice` varchar(45) DEFAULT NULL,
  `goodsId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_goods`
--

LOCK TABLES `order_goods` WRITE;
/*!40000 ALTER TABLE `order_goods` DISABLE KEYS */;
INSERT INTO `order_goods` VALUES (1,NULL,'开关',NULL,NULL,NULL,NULL),(2,NULL,'开关',NULL,NULL,NULL,NULL),(3,NULL,'开关2',NULL,NULL,NULL,NULL),(4,NULL,'开关2',NULL,NULL,NULL,NULL),(5,NULL,'开关',NULL,NULL,NULL,NULL),(6,NULL,'开关2',NULL,NULL,NULL,NULL),(7,NULL,'开关2',NULL,NULL,NULL,NULL),(8,NULL,'开关',NULL,NULL,NULL,NULL),(9,NULL,'开关2',NULL,NULL,NULL,NULL),(10,NULL,'开关2',NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `order_goods` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `usercol` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'dingyuxin',NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-12-02 19:18:28
