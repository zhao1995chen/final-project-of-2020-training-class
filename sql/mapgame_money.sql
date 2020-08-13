-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: mapgame
-- ------------------------------------------------------
-- Server version	5.6.40-log

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
-- Table structure for table `money`
--

DROP TABLE IF EXISTS `money`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `money` (
  `mid` int(10) NOT NULL,
  `uid` int(10) NOT NULL,
  `date` datetime NOT NULL,
  `paytype` int(10) NOT NULL,
  `paytime` int(10) NOT NULL,
  `isSent` tinyint(1) NOT NULL,
  `tradeNote` varchar(50) DEFAULT NULL,
  `url` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`mid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `money`
--

LOCK TABLES `money` WRITE;
/*!40000 ALTER TABLE `money` DISABLE KEYS */;
INSERT INTO `money` VALUES (1,1,'2011-01-01 01:01:01',1,1,1,'tradeNote1','url1'),(2,2,'2012-02-02 02:02:02',2,2,0,'tradeNote2','url2'),(3,1,'2013-03-03 03:03:03',3,3,1,'tradeNote3','url3'),(4,2,'2014-04-04 04:04:04',4,4,0,'tradeNote4','url4'),(5,1,'2015-05-05 05:05:05',5,5,1,'tradeNote5','url5');
/*!40000 ALTER TABLE `money` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-08-12 17:35:56
