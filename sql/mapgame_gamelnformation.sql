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
-- Table structure for table `gamelnformation`
--

DROP TABLE IF EXISTS `gamelnformation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `gamelnformation` (
  `giid` int(10) NOT NULL,
  `nickname` varchar(50) NOT NULL,
  `level` int(10) NOT NULL,
  `hp` int(10) NOT NULL,
  `money` int(10) NOT NULL,
  `moveMoney` int(10) NOT NULL,
  `position` varchar(20) DEFAULT NULL,
  `logintime` datetime DEFAULT NULL,
  `logouttime` datetime DEFAULT NULL,
  PRIMARY KEY (`giid`),
  KEY `giid` (`giid`),
  CONSTRAINT `gamelnformation_ibfk_1` FOREIGN KEY (`giid`) REFERENCES `user` (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gamelnformation`
--

LOCK TABLES `gamelnformation` WRITE;
/*!40000 ALTER TABLE `gamelnformation` DISABLE KEYS */;
INSERT INTO `gamelnformation` VALUES (1,'gameid1',1,1,1,1,'10041','2011-01-01 01:01:01','2011-01-01 01:01:01'),(2,'gameid2',2,2,22,2,'10047','2012-02-02 02:02:02','2012-02-02 02:02:02'),(3,'gameid3',3,3,333,3,'10047','2013-03-03 03:03:03','2013-03-03 03:03:03'),(4,'gameid4',4,4,4444,4,'10047','2014-04-04 04:04:04','2014-04-04 04:04:04'),(5,'gameid5',5,5,55555,5,'10047','2015-05-05 05:05:05','2015-05-05 05:05:05');
/*!40000 ALTER TABLE `gamelnformation` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-08-11 18:39:41
