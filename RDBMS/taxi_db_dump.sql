CREATE DATABASE  IF NOT EXISTS `taxi_db` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;
USE `taxi_db`;
-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: localhost    Database: taxi_db
-- ------------------------------------------------------
-- Server version	8.0.13

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `allocates`
--

DROP TABLE IF EXISTS `allocates`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `allocates` (
  `driver_id` int(11) NOT NULL,
  `booking_id` int(11) NOT NULL,
  PRIMARY KEY (`driver_id`,`booking_id`),
  KEY `booking_id` (`booking_id`),
  CONSTRAINT `allocates_ibfk_1` FOREIGN KEY (`driver_id`) REFERENCES `driver` (`driver_id`),
  CONSTRAINT `allocates_ibfk_2` FOREIGN KEY (`booking_id`) REFERENCES `booking_table` (`booking_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `allocates`
--

LOCK TABLES `allocates` WRITE;
/*!40000 ALTER TABLE `allocates` DISABLE KEYS */;
INSERT INTO `allocates` VALUES (1,1),(3,1),(1,2),(4,3),(1,5);
/*!40000 ALTER TABLE `allocates` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `booking_table`
--

DROP TABLE IF EXISTS `booking_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `booking_table` (
  `booking_id` int(11) NOT NULL,
  `payment_id` int(11) DEFAULT NULL,
  `amuont` int(11) DEFAULT NULL,
  `number_of_passengers` int(11) DEFAULT NULL,
  `taxi_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`booking_id`),
  KEY `user_id` (`user_id`),
  KEY `taxi_id` (`taxi_id`),
  CONSTRAINT `booking_table_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `booking_table_ibfk_2` FOREIGN KEY (`taxi_id`) REFERENCES `taxi` (`taxi_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `booking_table`
--

LOCK TABLES `booking_table` WRITE;
/*!40000 ALTER TABLE `booking_table` DISABLE KEYS */;
INSERT INTO `booking_table` VALUES (1,1,230,3,1,1),(2,2,20,3,1,1),(3,3,2930,3,5,2),(4,5,280,3,3,1),(5,9,2300,3,5,3);
/*!40000 ALTER TABLE `booking_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `driver`
--

DROP TABLE IF EXISTS `driver`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `driver` (
  `driver_id` int(11) NOT NULL,
  `driver_name` varchar(20) DEFAULT NULL,
  `driver_licence_number` int(11) DEFAULT NULL,
  `trips_completed` int(11) DEFAULT NULL,
  PRIMARY KEY (`driver_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `driver`
--

LOCK TABLES `driver` WRITE;
/*!40000 ALTER TABLE `driver` DISABLE KEYS */;
INSERT INTO `driver` VALUES (1,'subbu',234,12),(2,'suraj',234,127),(3,'subbu',25,162),(4,'suma',236,182),(5,'sumitra',34,129);
/*!40000 ALTER TABLE `driver` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `taxi`
--

DROP TABLE IF EXISTS `taxi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `taxi` (
  `taxi_id` int(11) NOT NULL,
  `taxi_name` varchar(20) DEFAULT NULL,
  `taxi_type` varchar(20) DEFAULT NULL,
  `taxi_reg_no` varchar(20) DEFAULT NULL,
  `taxi_owner` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`taxi_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `taxi`
--

LOCK TABLES `taxi` WRITE;
/*!40000 ALTER TABLE `taxi` DISABLE KEYS */;
INSERT INTO `taxi` VALUES (1,'taxi1','prime','123','ssy'),(2,'taxi2','luxury','173','ssy'),(3,'taxi3','prime','123','ssy'),(4,'taxi4','prime','1233','ssy'),(5,'taxi5','luxury','123','ssy');
/*!40000 ALTER TABLE `taxi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL,
  `user_name` varchar(20) DEFAULT NULL,
  `email` varchar(20) DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `phone_no` int(11) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `pickup_address` varchar(100) DEFAULT NULL,
  `destination_address` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'suresh','s.@gmail.com','male',7760,20,'banashankari,banglore','whitefield,banglore'),(2,'ram','s1.@gmail.com','male',7760,20,'banashankari,banglore','whitefield,banglore'),(3,'abhijit','s3.@gmail.com','male',7760,20,'banashankari,banglore','whitefield,banglore'),(4,'pawan','s4.@gmail.com','male',7760,20,'banashankari,banglore','whitefield,banglore'),(5,'ramya','s5.@gmail.com','male',7760,20,'banashankari,banglore','whitefield,banglore'),(6,'hanuma','s6.@gmail.com','male',7760,20,'banashankari,banglore','whitefield,banglore');
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

-- Dump completed on 2019-01-12 22:27:52
