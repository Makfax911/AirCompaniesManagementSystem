-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: air_schema
-- ------------------------------------------------------
-- Server version	8.0.23

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
-- Table structure for table `aircompany`
--

DROP TABLE IF EXISTS `aircompany`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `aircompany` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `company_name` varchar(255) NOT NULL,
  `company_type` varchar(255) NOT NULL,
  `founded_at` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aircompany`
--

LOCK TABLES `aircompany` WRITE;
/*!40000 ALTER TABLE `aircompany` DISABLE KEYS */;
INSERT INTO `aircompany` VALUES (1,'wizzair','passenger\'s',1999),(2,'MaУ','passenger\'s',1999),(3,'Air France','passenger\'s',2005);
/*!40000 ALTER TABLE `aircompany` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `airplane`
--

DROP TABLE IF EXISTS `airplane`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `airplane` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_at` date NOT NULL,
  `factory_serial_number` int NOT NULL,
  `flight_distance` int NOT NULL,
  `fuel_capacity` int NOT NULL,
  `name_airplane` varchar(255) NOT NULL,
  `number_of_flights` int NOT NULL,
  `type` varchar(255) NOT NULL,
  `aircompany_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `aircompany_id_idx` (`aircompany_id`),
  CONSTRAINT `air_company_id` FOREIGN KEY (`aircompany_id`) REFERENCES `aircompany` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `airplane`
--

LOCK TABLES `airplane` WRITE;
/*!40000 ALTER TABLE `airplane` DISABLE KEYS */;
INSERT INTO `airplane` VALUES (4,'2021-12-31',123456,100000,3000,'Ан-140',5,'freight and passenger',1),(5,'2009-12-31',123457,180000,4000,'Ан-148',9,'passenger plane',2),(6,'2002-12-31',123467,140000,3000,'Ан-158',8,'passenger plane',3);
/*!40000 ALTER TABLE `airplane` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `flight`
--

DROP TABLE IF EXISTS `flight`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `flight` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `create_at` datetime(6) NOT NULL,
  `delay_started_at` datetime(6) DEFAULT NULL,
  `departure_country` varchar(255) NOT NULL,
  `destination_country` varchar(255) NOT NULL,
  `distance` int NOT NULL,
  `ended_at` datetime(6) DEFAULT NULL,
  `estimated_flight_time` time DEFAULT NULL,
  `flight_status` varchar(255) NOT NULL,
  `aircompany_id` bigint NOT NULL,
  `airplane_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `aircompany_id_idx` (`aircompany_id`),
  KEY `airplane_id_idx` (`airplane_id`),
  CONSTRAINT `aircompany_id` FOREIGN KEY (`aircompany_id`) REFERENCES `aircompany` (`id`),
  CONSTRAINT `airplane_id` FOREIGN KEY (`airplane_id`) REFERENCES `airplane` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flight`
--

LOCK TABLES `flight` WRITE;
/*!40000 ALTER TABLE `flight` DISABLE KEYS */;
INSERT INTO `flight` VALUES (3,'2021-12-31 09:37:22.000000','2021-12-31 10:37:22.000000','UA','SK',1121,'2021-12-31 11:37:22.000000','01:00:00','ACTIVE',2,5),(5,'2021-12-28 09:37:22.000000','2021-12-29 10:37:22.000000','SK','UA',1121,'2021-12-29 11:37:22.000000','01:00:00','COMPLETED',1,4),(6,'2021-12-19 09:37:22.000000','2021-12-20 10:37:22.000000','USA','UA',10121,'2021-12-21 11:37:22.000000','01:00:00','PENDING',3,6);
/*!40000 ALTER TABLE `flight` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-12-31 15:14:06
