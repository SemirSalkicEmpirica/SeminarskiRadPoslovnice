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
-- Table structure for table `radnja`
--

DROP TABLE IF EXISTS `radnja`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `radnja` (
  `id` int NOT NULL,
  `fk_napitci` int DEFAULT NULL,
  `fk_odjeca` int DEFAULT NULL,
  `fk_hrana` int DEFAULT NULL,
  `fk_radnja_lokacija` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_radnja_lokacija` (`fk_radnja_lokacija`),
  KEY `fk_napitci` (`fk_napitci`),
  KEY `fk_odjeca` (`fk_odjeca`),
  KEY `fk_hrana` (`fk_hrana`),
  CONSTRAINT `radnja_ibfk_1` FOREIGN KEY (`fk_radnja_lokacija`) REFERENCES `radnja_lokacija` (`id`),
  CONSTRAINT `radnja_ibfk_2` FOREIGN KEY (`fk_napitci`) REFERENCES `napitci` (`id`),
  CONSTRAINT `radnja_ibfk_3` FOREIGN KEY (`fk_odjeca`) REFERENCES `odjeca` (`id`),
  CONSTRAINT `radnja_ibfk_4` FOREIGN KEY (`fk_hrana`) REFERENCES `hrana` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `radnja`
--

LOCK TABLES `radnja` WRITE;
/*!40000 ALTER TABLE `radnja` DISABLE KEYS */;
INSERT INTO `radnja` VALUES (1000,1,100,2,1),(1001,2,101,3,2),(1002,3,102,4,3),(1003,4,101,5,4),(1004,5,101,6,5),(1005,5,102,1,6),(1006,1,101,2,7),(1007,3,100,3,8),(1008,2,100,4,2),(1009,1,100,5,2),(1010,2,101,6,5),(1011,3,102,1,4),(1012,4,101,2,1),(1013,5,101,3,6),(1014,5,102,4,7),(1100,2,100,1,1);
/*!40000 ALTER TABLE `radnja` ENABLE KEYS */;
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
