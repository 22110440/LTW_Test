-- MySQL dump 10.13  Distrib 8.0.41, for Win64 (x86_64)
--
-- Host: localhost    Database: ltw_qt
-- ------------------------------------------------------
-- Server version	5.5.5-10.4.32-MariaDB

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
-- Table structure for table `videos`
--

DROP TABLE IF EXISTS `videos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `videos` (
  `VideoId` bigint(20) NOT NULL AUTO_INCREMENT,
  `Title` varchar(200) NOT NULL,
  `Poster` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `Views` int(11) DEFAULT 0,
  `Description` text DEFAULT NULL,
  `Active` tinyint(1) DEFAULT 1,
  `CategoryId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`VideoId`),
  KEY `fk_video_category` (`CategoryId`),
  CONSTRAINT `fk_video_category` FOREIGN KEY (`CategoryId`) REFERENCES `category` (`CategoryId`)
) ENGINE=InnoDB AUTO_INCREMENT=87 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `videos`
--

LOCK TABLES `videos` WRITE;
/*!40000 ALTER TABLE `videos` DISABLE KEYS */;
INSERT INTO `videos` VALUES (46,'Test Video','https://picsum.photos/id/1015/600/400',0,'Mô tả video',1,1),(67,'Java OOP nâng cao','https://picsum.photos/id/1011/600/400',85,'Học lập trình hướng đối tượng trong Java.',1,1),(68,'Spring Security cơ bản','https://picsum.photos/id/1012/600/400',60,'Hướng dẫn bảo mật ứng dụng với Spring Security.',1,1),(69,'JPA Hibernate Tutorial','https://picsum.photos/id/1013/600/400',130,'ORM với JPA và Hibernate trong Java.',1,1),(70,'HTML5 nâng cao','https://picsum.photos/id/1014/600/400',200,'Học HTML5 với các tính năng mới.',1,2),(71,'CSS Flexbox & Grid','https://picsum.photos/id/1016/600/400',175,'Thiết kế layout bằng Flexbox và Grid.',1,2),(72,'JavaScript ES6','https://picsum.photos/id/1018/600/400',300,'Khóa học JavaScript ES6 hiện đại.',1,2),(73,'React Hooks toàn tập','https://picsum.photos/id/1020/600/400',281,'Học React Hooks từ cơ bản đến nâng cao.',1,2),(74,'NodeJS Express API','https://picsum.photos/id/1024/600/400',220,'Xây dựng REST API với NodeJS và Express.',1,2),(75,'MySQL nâng cao','https://picsum.photos/id/1025/600/400',95,'Các kỹ thuật nâng cao trong MySQL.',1,3),(76,'PostgreSQL Tutorial','https://picsum.photos/id/1027/600/400',70,'Học PostgreSQL từ cơ bản.',1,3),(77,'NoSQL với MongoDB','https://picsum.photos/id/1028/600/400',150,'Hướng dẫn MongoDB cho người mới.',1,3),(78,'Redis Cache cơ bản','https://picsum.photos/id/1030/600/400',80,'Sử dụng Redis làm cache cho ứng dụng.',1,3),(79,'Docker Compose toàn tập','https://picsum.photos/id/1031/600/400',65,'Triển khai ứng dụng với Docker Compose.',1,3),(80,'Kubernetes cơ bản','https://picsum.photos/id/1032/600/400',55,'Giới thiệu về Kubernetes và container orchestration.',1,2),(81,'CI/CD với Jenkins','https://picsum.photos/id/1033/600/400',40,'Tự động hoá pipeline với Jenkins.',1,2),(82,'Git nâng cao','https://picsum.photos/id/1035/600/400',191,'Branching, merging và workflow trong Git.',1,2),(83,'Angular cơ bản','https://picsum.photos/id/1037/600/400',110,'Xây dựng ứng dụng frontend với Angular.',1,3),(84,'VueJS toàn tập','https://picsum.photos/id/1039/600/400',105,'Khóa học VueJS chi tiết.',1,2),(85,'Python Flask API','https://picsum.photos/id/1041/600/400',125,'Xây dựng REST API với Flask.',1,1),(86,'Django Web Framework','https://picsum.photos/id/1042/600/400',141,'Phát triển web với Django.',1,2);
/*!40000 ALTER TABLE `videos` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-09-25 15:01:22
