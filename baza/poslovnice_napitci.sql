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
-- Table structure for table `napitci`
--

DROP TABLE IF EXISTS `napitci`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `napitci` (
  `id` int NOT NULL,
  `ime` varchar(255) DEFAULT NULL,
  `datum_isteka` date DEFAULT NULL,
  `datum_proizvodnje` date DEFAULT NULL,
  `cijena` double DEFAULT NULL,
  `kolicina` bigint DEFAULT NULL,
  `vrsta_tekucine` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `napitci`
--

LOCK TABLES `napitci` WRITE;
/*!40000 ALTER TABLE `napitci` DISABLE KEYS */;
INSERT INTO `napitci` VALUES (1,'Fanta','2001-01-20','2001-01-20',2.5,10,'GAZIRANI'),(2,'Coca Cola','2002-02-20','2002-02-20',2.2,5,'GAZIRANI'),(3,'7 UP','2003-03-20','2003-03-20',3.2,20,'GAZIRANI'),(4,'Cappy','2004-04-20','2004-04-20',1.5,10,'NEGAZIRANI'),(5,'Fructal','2005-05-20','2005-05-20',1.2,40,'NEGAZIRANI'),(6,'Jack Daniels','2006-06-20','2006-06-20',20,3,'ALKOHOL');
/*!40000 ALTER TABLE `napitci` ENABLE KEYS */;
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
