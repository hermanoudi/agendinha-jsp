-- MySQL dump 10.13  Distrib 8.0.19, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: agendinha
-- ------------------------------------------------------
-- Server version	8.0.19-0ubuntu5

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
-- Table structure for table `bairro`
--

DROP TABLE IF EXISTS `bairro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bairro` (
  `bai_id` int NOT NULL AUTO_INCREMENT,
  `bai_nome` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`bai_id`),
  UNIQUE KEY `bai_id_UNIQUE` (`bai_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bairro`
--

LOCK TABLES `bairro` WRITE;
/*!40000 ALTER TABLE `bairro` DISABLE KEYS */;
INSERT INTO `bairro` VALUES (1,'Jardim Inconfidencia');
/*!40000 ALTER TABLE `bairro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cidade`
--

DROP TABLE IF EXISTS `cidade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cidade` (
  `cid_id` int NOT NULL AUTO_INCREMENT,
  `cid_nome` varchar(250) DEFAULT NULL,
  `cid_uf` char(2) DEFAULT NULL,
  `ddd_cid` varchar(3) DEFAULT NULL,
  PRIMARY KEY (`cid_id`),
  UNIQUE KEY `cid_id_UNIQUE` (`cid_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cidade`
--

LOCK TABLES `cidade` WRITE;
/*!40000 ALTER TABLE `cidade` DISABLE KEYS */;
INSERT INTO `cidade` VALUES (1,'Uberlandia','MG','034');
/*!40000 ALTER TABLE `cidade` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contato`
--

DROP TABLE IF EXISTS `contato`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contato` (
  `con_id` int NOT NULL AUTO_INCREMENT,
  `con_nome` varchar(250) DEFAULT NULL,
  `con_endereco` varchar(250) DEFAULT NULL,
  `bai_id` int DEFAULT NULL,
  `cid_id` int DEFAULT NULL,
  `con_residencial` varchar(45) DEFAULT NULL,
  `con_comercial` varchar(45) DEFAULT NULL,
  `con_celular` varchar(45) DEFAULT NULL,
  `con_email` varchar(250) DEFAULT NULL,
  `con_msn` varchar(250) DEFAULT NULL,
  `pai_id` int DEFAULT NULL,
  PRIMARY KEY (`con_id`),
  UNIQUE KEY `con_id_UNIQUE` (`con_id`),
  KEY `bai_id_idx` (`bai_id`),
  KEY `cid_id_idx` (`cid_id`),
  KEY `pai_id_idx` (`pai_id`),
  CONSTRAINT `bai_id` FOREIGN KEY (`bai_id`) REFERENCES `bairro` (`bai_id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `cid_id` FOREIGN KEY (`cid_id`) REFERENCES `cidade` (`cid_id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `pai_id` FOREIGN KEY (`pai_id`) REFERENCES `pais` (`pai_id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contato`
--

LOCK TABLES `contato` WRITE;
/*!40000 ALTER TABLE `contato` DISABLE KEYS */;
INSERT INTO `contato` VALUES (3,'Hermano Flávio de Moura','Rua Renato de Oliveira Grama, 240',1,1,'3432227788','3499887766','2488899009','hermanoudi@gmail.com','hermanoudi',1),(4,'Dayane Carolina de Oliveira','Rua Renato de Oliveira Grama, 240',1,1,'3432224455','3488997766','3477889900','dayane@gmail.com','dayane',1);
/*!40000 ALTER TABLE `contato` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pais`
--

DROP TABLE IF EXISTS `pais`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pais` (
  `pai_id` int NOT NULL AUTO_INCREMENT,
  `pai_nome` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`pai_id`),
  UNIQUE KEY `pai_id_UNIQUE` (`pai_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pais`
--

LOCK TABLES `pais` WRITE;
/*!40000 ALTER TABLE `pais` DISABLE KEYS */;
INSERT INTO `pais` VALUES (1,'Brasil');
/*!40000 ALTER TABLE `pais` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'agendinha'
--

--
-- Dumping routines for database 'agendinha'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-05-04 11:50:57
