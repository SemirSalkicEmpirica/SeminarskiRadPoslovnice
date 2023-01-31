-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: localhost    Database: poslovnice
-- ------------------------------------------------------
-- Server version	8.0.26

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `hrana`
--

DROP TABLE IF EXISTS `hrana`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hrana` (
  `id` int NOT NULL,
  `ime` varchar(255) DEFAULT NULL,
  `domace` tinyint(1) DEFAULT NULL,
  `proizvodjac` varchar(255) DEFAULT NULL,
  `datum_isteka` date DEFAULT NULL,
  `datum_proizvodnje` date DEFAULT NULL,
  `cijena` bigint DEFAULT NULL,
  `kolicina` bigint DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hrana`
--

LOCK TABLES `hrana` WRITE;
/*!40000 ALTER TABLE `hrana` DISABLE KEYS */;
INSERT INTO `hrana` VALUES (1,'Kulen',1,'Bajra','2001-01-20','2001-01-20',22,51),(2,'Kulen1',0,'Bajra1','2001-01-20','2001-01-20',222,65),(3,'Kulen2',0,'Bajra2','2001-01-20','2001-01-20',122,75),(4,'Kulen3',1,'Bajra3','2001-01-20','2001-01-20',522,55),(5,'Kulen4',0,'Bajra4','2001-01-20','2001-01-20',622,45),(6,'Kulen5',1,'Bajra5','2001-01-20','2001-01-20',722,5);
/*!40000 ALTER TABLE `hrana` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-01-31 21:01:49
