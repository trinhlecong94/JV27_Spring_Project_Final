-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: localhost    Database: doan
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
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES (1,'Hoa Tien, Hoa Vang','1992-01-12','dinhtai92dn@gmail.com','Nguyen Dinh Tai','123456','0704555444','ACTIVE','user'),(2,'Cam Le','1992-01-04','admin@gmail.com','TAI NGUYEN','123456','0704666988','ACTIVE','admin'),(3,'Hoa Khanh','1992-01-22','seller@gmail.com','Seller Seller','123456','0704222333','ACTIVE','seller'),(7,'4609 Lincoln Park Drive','2019-01-15','nguyendinhtai92dn@gmail.com','USER MOT','1234','7034934583','ACTIVE','user1'),(8,'Cam Le','1992-01-04','taikhin123@gmail.com','TAI NGUYEN','123456','0704666988','ACTIVE','taikhin123'),(9,'NNNNNN','2019-01-05','user3@gmail.com','USER Ba','12345','4444555544','INACTIVE','user3'),(10,'Hoa Tien, Hoa Vang','1997-01-28','dinhtai92.dn@gmail.com','TAI NGUYEN','12345','012345611','ACTIVE','dinhtai92dn'),(11,'DA NANG',NULL,'dinhtai9.2dn@gmail.com','DINH TAI','123456','','ACTIVE','dinhtai'),(12,NULL,NULL,'nguyendinhtai92.dn@gmail.com','SELLER 2','123456',NULL,'ACTIVE','seller2');
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `account_role`
--

LOCK TABLES `account_role` WRITE;
/*!40000 ALTER TABLE `account_role` DISABLE KEYS */;
INSERT INTO `account_role` VALUES (1,'ROLE_ADMIN'),(2,'ROLE_SELLER'),(3,'ROLE_USER');
/*!40000 ALTER TABLE `account_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `account_role_relation`
--

LOCK TABLES `account_role_relation` WRITE;
/*!40000 ALTER TABLE `account_role_relation` DISABLE KEYS */;
INSERT INTO `account_role_relation` VALUES (1,3),(2,1),(3,2),(2,3),(3,3),(7,3),(8,3),(9,3),(10,3),(11,3),(12,2),(12,3);
/*!40000 ALTER TABLE `account_role_relation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,_binary '\0','Women','Women'),(2,_binary '\0','Men','Men'),(3,_binary '\0','Kids','Kids');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `color`
--

LOCK TABLES `color` WRITE;
/*!40000 ALTER TABLE `color` DISABLE KEYS */;
INSERT INTO `color` VALUES (1,'Black'),(2,'Blue'),(3,'Cyan'),(4,'DarkGray'),(5,'Gray'),(6,'Green'),(7,'Light gray'),(8,'Magenta'),(9,'Orange'),(10,'Pink'),(11,'Red'),(12,'White'),(13,'Yellow'),(14,'N/A');
/*!40000 ALTER TABLE `color` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
INSERT INTO `comment` VALUES (1,'2019-03-23','nice shirt, i really like it',1,1),(2,'2019-03-23','wow! perfect',3,1),(3,'2019-03-23','I like it',1,2),(4,'2019-04-05','so hot',1,11),(5,'2019-04-09','Nice',1,2),(6,'2019-04-09','Nice product',10,1),(7,'2019-04-17','This shirt is too beautiful',1,15);
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `favorite`
--

LOCK TABLES `favorite` WRITE;
/*!40000 ALTER TABLE `favorite` DISABLE KEYS */;
INSERT INTO `favorite` VALUES (9,1,3),(16,1,1),(17,1,5),(18,3,5),(19,1,11),(20,1,10),(21,1,2),(22,10,1);
/*!40000 ALTER TABLE `favorite` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `images`
--

LOCK TABLES `images` WRITE;
/*!40000 ALTER TABLE `images` DISABLE KEYS */;
INSERT INTO `images` VALUES (6,_binary '\0',NULL,'https://assets.myntassets.com/h_720,q_90,w_540/v1/assets/images/2378362/2018/6/9/270e0a7e-365b-4640-9433-b269c60bf3061528527188563-Moda-Rapido-Men-Maroon-Printed-Round-Neck-T-shirt-3811528527-1.jpg',2),(7,_binary '\0',NULL,'https://assets.myntassets.com/h_720,q_90,w_540/v1/assets/images/2378362/2018/6/9/405568f1-c3c1-4713-9c38-6dd95ac962d31528527188543-Moda-Rapido-Men-Maroon-Printed-Round-Neck-T-shirt-3811528527-2.jpg',2),(8,_binary '\0',NULL,'https://assets.myntassets.com/h_720,q_90,w_540/v1/assets/images/2378362/2018/6/9/33523035-65f5-4fcb-b7a5-4062e656d10b1528527188511-Moda-Rapido-Men-Maroon-Printed-Round-Neck-T-shirt-3811528527-3.jpg',2),(9,_binary '\0',NULL,'https://assets.myntassets.com/h_720,q_90,w_540/v1/assets/images/2378362/2018/6/9/ed7b0cd1-8fa7-4f65-95b4-36518bfa94461528527188485-Moda-Rapido-Men-Maroon-Printed-Round-Neck-T-shirt-3811528527-4.jpg',2),(10,_binary '\0',NULL,'https://assets.myntassets.com/h_720,q_90,w_540/v1/assets/images/8675777/2019/2/8/c8cbb91b-8a3c-4a6b-8db1-a7c3aa548d4c1549627570947-MANGO-Women-Tshirts-6761549627569578-1.jpg',3),(11,_binary '\0',NULL,'https://assets.myntassets.com/h_720,q_90,w_540/v1/assets/images/8675777/2019/2/8/c59d1629-4456-4547-a6a4-e60d531a90eb1549627570924-MANGO-Women-Tshirts-6761549627569578-2.jpg',3),(12,_binary '\0',NULL,'https://assets.myntassets.com/h_720,q_90,w_540/v1/assets/images/8675777/2019/2/8/544c44da-093c-496a-a92d-261edb1ee2461549627570904-MANGO-Women-Tshirts-6761549627569578-3.jpg',3),(13,_binary '\0',NULL,'https://assets.myntassets.com/h_720,q_90,w_540/v1/assets/images/8675777/2019/2/8/6169a94b-3c1e-4abc-bd9c-d5fffeea39251549627570887-MANGO-Women-Tshirts-6761549627569578-4.jpg',3),(14,_binary '\0',NULL,'https://assets.myntassets.com/h_720,q_90,w_540/v1/assets/images/8588765/2019/2/16/996a4fd9-7830-4f27-9a8e-8e77665f8a6d1550302405311-Tommy-Hilfiger-Women-Pink-Solid-V-Neck-T-shirt-4561550302403-1.jpg',4),(15,_binary '\0',NULL,'https://assets.myntassets.com/h_720,q_90,w_540/v1/assets/images/8588765/2019/2/16/671ec568-0536-4365-86e7-f7c558cd521f1550302405294-Tommy-Hilfiger-Women-Pink-Solid-V-Neck-T-shirt-4561550302403-2.jpg',4),(16,_binary '\0',NULL,'https://assets.myntassets.com/h_720,q_90,w_540/v1/assets/images/8588765/2019/2/16/a1b1a6d1-0c35-4838-96dc-9e42ecfbb7d91550302405276-Tommy-Hilfiger-Women-Pink-Solid-V-Neck-T-shirt-4561550302403-3.jpg',4),(17,_binary '\0',NULL,'https://assets.myntassets.com/h_720,q_90,w_540/v1/assets/images/8588765/2019/2/16/d8380e8c-0e8d-4bd8-87a2-b33d4454f1151550302405256-Tommy-Hilfiger-Women-Pink-Solid-V-Neck-T-shirt-4561550302403-4.jpg',4),(18,_binary '\0',NULL,'https://assets.myntassets.com/h_720,q_90,w_540/v1/assets/images/8588765/2019/2/16/3b49edc6-f83d-46d0-b126-efc2fbbfd0e61550302405244-Tommy-Hilfiger-Women-Pink-Solid-V-Neck-T-shirt-4561550302403-5.jpg',4),(40,_binary '\0',NULL,'https://assets.myntassets.com/h_720,q_90,w_540/v1/assets/images/8378519/2019/1/23/6bfe3d23-84d0-4f6f-85df-f946cc0ab8f51548246009011-Pepe-Jeans-Boys-Tshirts-6941548246008189-1.jpg',5),(41,_binary '\0',NULL,'https://assets.myntassets.com/h_720,q_90,w_540/v1/assets/images/8378519/2019/1/23/0f9bcef9-4b64-4310-9b8b-e46d1c0a963c1548246008985-Pepe-Jeans-Boys-Tshirts-6941548246008189-2.jpg',5),(42,_binary '\0',NULL,'https://assets.myntassets.com/h_720,q_90,w_540/v1/assets/images/8378519/2019/1/23/3c13c0f7-76ee-4e7d-ba97-462ecdfe02421548246008951-Pepe-Jeans-Boys-Tshirts-6941548246008189-3.jpg',5),(43,_binary '\0',NULL,'https://assets.myntassets.com/h_720,q_90,w_540/v1/assets/images/4318138/2018/5/4/11525433792765-HERENOW-Men-Black-Printed-Round-Neck-T-shirt-2881525433792598-1.jpg',6),(44,_binary '\0',NULL,'https://assets.myntassets.com/h_720,q_90,w_540/v1/assets/images/4318138/2018/5/4/11525433792736-HERENOW-Men-Black-Printed-Round-Neck-T-shirt-2881525433792598-2.jpg',6),(45,_binary '\0',NULL,'https://assets.myntassets.com/h_720,q_90,w_540/v1/assets/images/4318138/2018/5/4/11525433792709-HERENOW-Men-Black-Printed-Round-Neck-T-shirt-2881525433792598-3.jpg',6),(46,_binary '\0',NULL,'https://assets.myntassets.com/h_720,q_90,w_540/v1/assets/images/4318138/2018/5/4/11525433792691-HERENOW-Men-Black-Printed-Round-Neck-T-shirt-2881525433792598-4.jpg',6),(47,_binary '\0',NULL,'https://assets.myntassets.com/h_720,q_90,w_540/v1/assets/images/2471500/2018/2/9/11518159758071-FIDO-DIDO-Men-Tshirts-9591518159757862-1.jpg',7),(48,_binary '\0',NULL,'https://assets.myntassets.com/h_1440,q_100,w_1080/v1/assets/images/2471500/2018/2/9/11518159758046-FIDO-DIDO-Men-Tshirts-9591518159757862-2.jpg',7),(49,_binary '\0',NULL,'https://assets.myntassets.com/h_1440,q_100,w_1080/v1/assets/images/2471500/2018/2/9/11518159758019-FIDO-DIDO-Men-Tshirts-9591518159757862-3.jpg',7),(50,_binary '\0',NULL,'https://assets.myntassets.com/h_1440,q_100,w_1080/v1/assets/images/2471500/2018/2/9/11518159757994-FIDO-DIDO-Men-Tshirts-9591518159757862-4.jpg',7),(51,_binary '\0',NULL,'https://assets.myntassets.com/h_1440,q_100,w_1080/v1/assets/images/2471500/2018/2/9/11518159757971-FIDO-DIDO-Men-Tshirts-9591518159757862-5.jpg',7),(52,_binary '\0',NULL,'https://assets.myntassets.com/h_1440,q_100,w_1080/v1/assets/images/3314131/2018/5/23/043198c4-a8ea-4b81-a688-3562937b790b1527055422713-Roadster-Men-Black-Solid-Round-Neck-T-shirt-4351527055421300-1.jpg',8),(53,_binary '\0',NULL,'https://assets.myntassets.com/h_1440,q_100,w_1080/v1/assets/images/3314131/2018/5/23/f44a8cb7-c798-4f8f-80e7-98a0cc747d641527055422694-Roadster-Men-Black-Solid-Round-Neck-T-shirt-4351527055421300-2.jpg',8),(54,_binary '\0',NULL,'https://assets.myntassets.com/h_1440,q_100,w_1080/v1/assets/images/3314131/2018/5/23/b4921821-e9d7-4844-a01e-97b075c381561527055422644-Roadster-Men-Black-Solid-Round-Neck-T-shirt-4351527055421300-4.jpg',8),(55,_binary '\0',NULL,'https://assets.myntassets.com/h_1440,q_100,w_1080/v1/assets/images/3314131/2018/5/23/f4e49847-d4d9-43f2-8fed-a7d67a6c878e1527055422624-Roadster-Men-Black-Solid-Round-Neck-T-shirt-4351527055421300-5.jpg',8),(56,_binary '\0',NULL,'https://assets.myntassets.com/h_1440,q_100,w_1080/v1/assets/images/8588669/2019/3/14/61074788-ea2f-430d-abb5-bb650fc09ef71552538394125-Tommy-Hilfiger-Women-Green-Solid-Round-Neck-T-shirt-65015525-1.jpg',9),(57,_binary '\0',NULL,'https://assets.myntassets.com/h_1440,q_100,w_1080/v1/assets/images/8588669/2019/3/14/d6a7cfab-fcfe-4a02-a648-4c7d57248bb91552538394103-Tommy-Hilfiger-Women-Green-Solid-Round-Neck-T-shirt-65015525-2.jpg',9),(58,_binary '\0',NULL,'https://assets.myntassets.com/h_1440,q_100,w_1080/v1/assets/images/8588669/2019/3/14/a376a237-7511-4c87-ae45-cfef789fee521552538394081-Tommy-Hilfiger-Women-Green-Solid-Round-Neck-T-shirt-65015525-3.jpg',9),(59,_binary '\0',NULL,'https://assets.myntassets.com/h_1440,q_100,w_1080/v1/assets/images/8588669/2019/3/14/eb416de3-4969-4da1-81f3-245b4cc1addf1552538394063-Tommy-Hilfiger-Women-Green-Solid-Round-Neck-T-shirt-65015525-4.jpg',9),(60,_binary '\0',NULL,'https://assets.myntassets.com/h_1440,q_100,w_1080/v1/assets/images/8588669/2019/3/14/26995bbf-722e-4caf-96f0-9b78e220ac111552538394051-Tommy-Hilfiger-Women-Green-Solid-Round-Neck-T-shirt-65015525-5.jpg',9),(61,_binary '\0',NULL,'https://assets.myntassets.com/h_1440,q_100,w_1080/v1/assets/images/2312468/2018/2/21/11519195992929-Roadster-Women-Maroon-Solid-Round-Neck-T-shirt-7951519195992737-1.jpg',10),(62,_binary '\0',NULL,'https://assets.myntassets.com/h_1440,q_100,w_1080/v1/assets/images/2312468/2018/2/21/11519195992900-Roadster-Women-Maroon-Solid-Round-Neck-T-shirt-7951519195992737-2.jpg',10),(63,_binary '\0',NULL,'https://assets.myntassets.com/h_1440,q_100,w_1080/v1/assets/images/2312468/2018/2/21/11519195992877-Roadster-Women-Maroon-Solid-Round-Neck-T-shirt-7951519195992737-3.jpg',10),(64,_binary '\0',NULL,'https://assets.myntassets.com/h_1440,q_100,w_1080/v1/assets/images/2312468/2018/2/21/11519195992846-Roadster-Women-Maroon-Solid-Round-Neck-T-shirt-7951519195992737-4.jpg',10),(65,_binary '\0',NULL,'https://assets.myntassets.com/h_1440,q_100,w_1080/v1/assets/images/2312468/2018/2/21/11519195992813-Roadster-Women-Maroon-Solid-Round-Neck-T-shirt-7951519195992737-5.jpg',10),(66,_binary '\0',NULL,'https://assets.myntassets.com/h_1440,q_100,w_1080/v1/assets/images/8754499/2019/3/7/f3d12560-5c45-4f92-bfca-27de06f965cf1551942281489-Calvin-Klein-Jeans-Women-Pink-Printed-Round-Neck-T-shirt-528-1.jpg',11),(67,_binary '\0',NULL,'https://assets.myntassets.com/h_1440,q_100,w_1080/v1/assets/images/8754499/2019/3/7/27ac6ca5-7b5f-4e67-94f5-2164c6a367611551942281468-Calvin-Klein-Jeans-Women-Pink-Printed-Round-Neck-T-shirt-528-2.jpg',11),(68,_binary '\0',NULL,'https://assets.myntassets.com/h_1440,q_100,w_1080/v1/assets/images/8754499/2019/3/7/d8a9af51-4544-4556-a342-4a2ec3615c3b1551942281454-Calvin-Klein-Jeans-Women-Pink-Printed-Round-Neck-T-shirt-528-3.jpg',11),(69,_binary '\0',NULL,'https://assets.myntassets.com/h_1440,q_100,w_1080/v1/assets/images/8754499/2019/3/7/650eff2e-34c6-40ca-bc06-66e572254f291551942281436-Calvin-Klein-Jeans-Women-Pink-Printed-Round-Neck-T-shirt-528-4.jpg',11),(70,_binary '\0',NULL,'https://assets.myntassets.com/h_1440,q_100,w_1080/v1/assets/images/8754499/2019/3/7/08c6d66b-7bf9-469c-a4d5-f671977191741551942281425-Calvin-Klein-Jeans-Women-Pink-Printed-Round-Neck-T-shirt-528-5.jpg',11),(71,_binary '\0',NULL,'https://assets.myntassets.com/h_1440,q_100,w_1080/v1/assets/images/2275365/2018/2/2/11517569167995-Roadster-Men-White-Solid-Round-Neck-T-shirt-3961517569167870-1.jpg',12),(72,_binary '\0',NULL,'https://assets.myntassets.com/h_1440,q_100,w_1080/v1/assets/images/2275365/2018/2/2/11517569167974-Roadster-Men-White-Solid-Round-Neck-T-shirt-3961517569167870-2.jpg',12),(73,_binary '\0',NULL,'https://assets.myntassets.com/h_1440,q_100,w_1080/v1/assets/images/2275365/2018/2/2/11517569167954-Roadster-Men-White-Solid-Round-Neck-T-shirt-3961517569167870-3.jpg',12),(74,_binary '\0',NULL,'https://assets.myntassets.com/h_1440,q_100,w_1080/v1/assets/images/2275365/2018/2/2/11517569167935-Roadster-Men-White-Solid-Round-Neck-T-shirt-3961517569167870-4.jpg',12),(75,_binary '\0',NULL,'https://assets.myntassets.com/h_1440,q_100,w_1080/v1/assets/images/2275365/2018/2/2/11517569167919-Roadster-Men-White-Solid-Round-Neck-T-shirt-3961517569167870-5.jpg',12),(76,_binary '\0',NULL,'https://assets.myntassets.com/h_1440,q_100,w_1080/v1/assets/images/9062699/2019/3/25/b4754bac-d92d-4585-a995-fda4b40db7df1553501240998-Polo-Ralph-Lauren-Men-Tshirts-9961553501239387-1.jpg',13),(77,_binary '\0',NULL,'https://assets.myntassets.com/h_1440,q_100,w_1080/v1/assets/images/9062699/2019/3/25/0c73897f-2b92-4c01-b035-052053b851cf1553501240973-Polo-Ralph-Lauren-Men-Tshirts-9961553501239387-2.jpg',13),(78,_binary '\0',NULL,'https://assets.myntassets.com/h_1440,q_100,w_1080/v1/assets/images/9062699/2019/3/25/9d1806fd-8cdd-4c50-9e92-025a090d021e1553501240945-Polo-Ralph-Lauren-Men-Tshirts-9961553501239387-3.jpg',13),(79,_binary '\0',NULL,'https://assets.myntassets.com/h_1440,q_100,w_1080/v1/assets/images/9062699/2019/3/25/576aa667-1120-4cd3-b8ba-e8d85351e9061553501240919-Polo-Ralph-Lauren-Men-Tshirts-9961553501239387-4.jpg',13),(80,_binary '\0',NULL,'https://assets.myntassets.com/h_1440,q_100,w_1080/v1/assets/images/9062699/2019/3/25/73a3f80c-3a25-49fb-84c8-5f5adff70ba31553501240901-Polo-Ralph-Lauren-Men-Tshirts-9961553501239387-5.jpg',13),(81,_binary '\0',NULL,'https://assets.myntassets.com/h_1440,q_100,w_1080/v1/assets/images/8509609/2019/2/1/1c5170e4-ce53-4f88-8621-4a3514f0525d1549013042194-Calvin-Klein-Jeans-Men-Blue-Solid-Polo-Collar-T-shirt-538154-1.jpg',14),(82,_binary '\0',NULL,'https://assets.myntassets.com/h_1440,q_100,w_1080/v1/assets/images/8509609/2019/2/1/b6fe893f-d895-47b6-a9d2-a37683fc9e801549013042177-Calvin-Klein-Jeans-Men-Blue-Solid-Polo-Collar-T-shirt-538154-2.jpg',14),(83,_binary '\0',NULL,'https://assets.myntassets.com/h_1440,q_100,w_1080/v1/assets/images/8509609/2019/2/1/f7a5e6cb-47f5-42aa-80eb-9eb8e3becf6c1549013042158-Calvin-Klein-Jeans-Men-Blue-Solid-Polo-Collar-T-shirt-538154-3.jpg',14),(84,_binary '\0',NULL,'https://assets.myntassets.com/h_1440,q_100,w_1080/v1/assets/images/8509609/2019/2/1/af1f974f-8660-4168-8b3d-9859179c12dc1549013042131-Calvin-Klein-Jeans-Men-Blue-Solid-Polo-Collar-T-shirt-538154-5.jpg',14),(85,_binary '\0',NULL,'https://assets.myntassets.com/h_1440,q_100,w_1080/v1/assets/images/7578951/2018/10/24/b2197469-6bab-4242-8928-a6fd092d04721540383597284-Harpa-Women-Tops-2001540383597148-1.jpg',15),(86,_binary '\0',NULL,'https://assets.myntassets.com/h_1440,q_100,w_1080/v1/assets/images/7578951/2018/10/24/314695d9-2b96-445e-806d-397c6a54c3271540383597271-Harpa-Women-Tops-2001540383597148-2.jpg',15),(87,_binary '\0',NULL,'https://assets.myntassets.com/h_1440,q_100,w_1080/v1/assets/images/7578951/2018/10/24/81403cab-76e1-474f-abca-47375a4efd691540383597245-Harpa-Women-Tops-2001540383597148-3.jpg',15),(88,_binary '\0',NULL,'https://assets.myntassets.com/h_1440,q_100,w_1080/v1/assets/images/7578951/2018/10/24/ef7fe1ec-8875-4320-a018-6ce36bf114441540383597233-Harpa-Women-Tops-2001540383597148-4.jpg',15),(89,_binary '\0',NULL,'https://assets.myntassets.com/h_1440,q_100,w_1080/v1/assets/images/7578951/2018/10/24/99f3488e-7ece-4ec2-817a-94f5a0e3e1941540383597299-Harpa-Women-Tops-2001540383597148-5.jpg',15),(90,_binary '\0',NULL,'https://assets.myntassets.com/h_1440,q_100,w_1080/v1/assets/images/2355195/2019/3/14/b4a2b438-8183-4a60-8f43-b33b6fc98bff1552563548653-Roadster-Women-White-Solid-Round-Neck-T-shirt-32115525635468-1.jpg',16),(91,_binary '\0',NULL,'https://assets.myntassets.com/h_1440,q_100,w_1080/v1/assets/images/2355195/2019/3/14/67d19790-a08d-408c-bfc0-18e06b14519e1552563548624-Roadster-Women-White-Solid-Round-Neck-T-shirt-32115525635468-2.jpg',16),(92,_binary '\0',NULL,'https://assets.myntassets.com/h_1440,q_100,w_1080/v1/assets/images/2355195/2019/3/14/ca9734a0-079d-4bd6-b47b-479837247a2b1552563548600-Roadster-Women-White-Solid-Round-Neck-T-shirt-32115525635468-3.jpg',16),(93,_binary '\0',NULL,'https://assets.myntassets.com/h_1440,q_100,w_1080/v1/assets/images/2355195/2019/3/14/0408bf47-690a-495b-92ea-f6d2a71d57191552563548583-Roadster-Women-White-Solid-Round-Neck-T-shirt-32115525635468-4.jpg',16),(94,_binary '\0',NULL,'https://assets.myntassets.com/h_1440,q_100,w_1080/v1/assets/images/2355195/2019/3/14/04c87ae2-65ef-4a07-a59d-10c182a4c1391552563548558-Roadster-Women-White-Solid-Round-Neck-T-shirt-32115525635468-5.jpg',16),(104,_binary '\0',NULL,'https://assets.myntassets.com/h_1440,q_100,w_1080/v1/assets/images/8822195/2019/3/19/752f5432-d321-498c-bc7f-5a7d49ee80ab1552998180282-FOREVER-21-Women-Tshirts-3291552998179684-5.jpg',17),(103,_binary '\0',NULL,'https://assets.myntassets.com/h_1440,q_100,w_1080/v1/assets/images/8822195/2019/3/19/d60705ee-c850-464f-8e39-66d7a59e3c061552998180298-FOREVER-21-Women-Tshirts-3291552998179684-4.jpg',17),(102,_binary '\0',NULL,'https://assets.myntassets.com/h_1440,q_100,w_1080/v1/assets/images/8822195/2019/3/19/608d584f-52f2-49e5-86a7-9166ff264f321552998180316-FOREVER-21-Women-Tshirts-3291552998179684-3.jpg',17),(101,_binary '\0',NULL,'https://assets.myntassets.com/h_1440,q_100,w_1080/v1/assets/images/8822195/2019/3/19/b60f639e-cd45-4e5b-849d-08e05159ea3f1552998180332-FOREVER-21-Women-Tshirts-3291552998179684-2.jpg',17),(100,_binary '\0',NULL,'https://assets.myntassets.com/h_1440,q_100,w_1080/v1/assets/images/8822195/2019/3/19/af34381c-eca8-450c-b462-7e04a1569a261552998180350-FOREVER-21-Women-Tshirts-3291552998179684-1.jpg',17),(105,_binary '\0',NULL,'https://assets.myntassets.com/h_1440,q_100,w_1080/v1/assets/images/productimage/2019/3/22/2820a42c-8d1f-4621-8272-d131fa8faced1553258832098-1.jpg',1),(107,_binary '\0',NULL,'https://assets.myntassets.com/h_1440,q_100,w_1080/v1/assets/images/productimage/2019/3/22/efe39b53-a4a9-4a30-ba90-838886b004861553258832135-2.jpg',1),(108,_binary '\0',NULL,'https://assets.myntassets.com/h_1440,q_100,w_1080/v1/assets/images/productimage/2019/3/22/8276a3b2-08d8-40ac-8913-9995fb000a391553258832169-3.jpg',1),(109,_binary '\0',NULL,'https://assets.myntassets.com/h_1440,q_100,w_1080/v1/assets/images/productimage/2019/3/22/e0cbf320-9bd4-40c1-bf0c-76054a95b9741553258832198-4.jpg',1),(110,_binary '\0',NULL,'https://assets.myntassets.com/h_1440,q_100,w_1080/v1/assets/images/productimage/2019/3/22/7b2beca2-a6be-40f5-ad0a-18f3580e87531553258832225-5.jpg',1);
/*!40000 ALTER TABLE `images` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `order_detail`
--

LOCK TABLES `order_detail` WRITE;
/*!40000 ALTER TABLE `order_detail` DISABLE KEYS */;
INSERT INTO `order_detail` VALUES (1,2,1,1,NULL,4),(2,1,1,3,1,3),(3,3,2,4,NULL,4),(4,1,3,1,NULL,5),(5,1,3,1,NULL,2),(6,1,4,1,NULL,5),(7,2,5,8,NULL,4),(8,1,6,3,NULL,2),(9,1,6,8,NULL,4),(10,1,7,2,NULL,2),(11,1,8,4,NULL,4),(12,1,9,5,NULL,1),(13,1,9,4,1,3),(14,1,10,11,NULL,3),(15,1,11,2,NULL,4),(16,1,11,4,1,3),(17,3,12,1,NULL,4),(18,1,12,3,1,4),(19,1,13,6,NULL,5);
/*!40000 ALTER TABLE `order_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (1,'2019-03-28','PROCESSING',143.2,1,6),(2,'2019-03-28','PENDING',141,1,7),(3,'2019-03-28','CANCELLED',112,1,8),(4,'2019-03-29','PENDING',56,NULL,9),(5,'2019-04-01','PENDING',108,7,10),(6,'2019-04-01','PENDING',93,7,11),(7,'2019-04-03','PENDING',45,NULL,12),(8,'2019-04-03','PROCESSING',47,1,13),(9,'2019-04-03','PENDING',72.6,1,14),(10,'2019-04-05','PENDING',33,1,15),(11,'2019-04-09','CANCELLED',82.6,1,16),(12,'2019-04-09','PENDING',199.2,10,17),(13,'2019-04-10','CANCELLED',45,10,18);
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'Roadster','2475784','2019-01-01','Navy Blue printed T-shirt, has a polo collar, short sleeves','Men Navy Blue Printed Polo Collar T-shirt',56,'ACTIVE',2,1),(2,'Moda Rapido','2378362','2019-01-02','Maroon and black printed T-shirt, has a round neck, long sleeves','Men Maroon Printed Round Neck T-shirt',45,'ACTIVE',2,11),(3,'MANGO','8675777','2019-01-03','Red and white printed T-shirt with embroidered, has a round neck, short sleeves','Women Red Printed Round Neck T-shirt',39,'ACTIVE',1,11),(4,'Tommy Hilfiger','8588765','2019-01-04','Pink solid T-shirt, has a V-neck, short sleeves','Women Pink Solid V-Neck T-shirt',47,'ACTIVE',1,10),(5,'Pepe Jeans','8378533','2019-01-05','Green printed T-shirt, has a round neck, short sleeves','Boys Green Printed Round Neck T-shirt',35,'ACTIVE',3,6),(6,'HERE&NOW','4318138','2019-01-06','Black and orange printed T-shirt, has a round neck, short sleeves','Men Black Printed Round Neck T-shirt',45,'ACTIVE',2,1),(7,'FIDO DIDO','2471500','2019-01-07','Pink solid T-shirt, has a polo collar, short sleeves.','Men Pink Solid Polo Collar Slim Fit T-shirt',48,'ACTIVE',2,10),(8,'Roadster','3314131','2019-01-08','Black solid T-shirt, has a round neck, short sleeves','Men Black Solid Round Neck T-shirt',54,'ACTIVE',2,1),(9,'Tommy Hilfiger','8588669','2019-01-09','Green solid T-shirt, has a round neck, short sleeves','Women Green Solid Round Neck T-shirt',35,'ACTIVE',1,6),(10,'Roadster','2312468','2019-01-10','Maroon solid T-shirt, has a round neck, short sleeves','Women Maroon Solid Round Neck T-shirt',47,'ACTIVE',1,11),(11,'Calvin Klein Jeans','8754499','2019-01-11','Pink printed T-shirt, has a round neck, short sleeves','Women Pink Printed Round Neck T-shirt',33,'ACTIVE',1,10),(12,'Roadster','2275365','2019-01-12','White solid T-shirt, has a round neck, short sleeves','Men White Solid Round Neck T-shirt',45,'ACTIVE',2,12),(13,'Polo Ralph Lauren','9062699','2019-01-13','Green solid T-shirt, has a polo collar, short sleeves','Men Green Solid Polo Collar T-shirt',56,'ACTIVE',2,6),(14,'Calvin Klein Jeans','8509609','2019-01-14','Blue solid T-shirt, has a polo collar, short sleeves','Men Blue Solid Polo Collar T-shirt',53,'ACTIVE',2,2),(15,'Harpa','7578951','2019-01-15','Dusty pink solid T-shirt, has a round neck, three-quarter sleeves with striped detail','Women Dusty Pink Solid Round Neck T-shirt',35,'ACTIVE',1,10),(16,'Roadster','2355195','2019-01-16','White solid T-shirt, has a round neck, short sleeves','Women White Solid Round Neck T-shirt',44,'ACTIVE',1,12),(17,'FOREVER 21','8822195','2019-01-17','Red printed T-shirt, has a round neck, short sleeves','Women Red Printed Round Neck T-shirt',38,'INACTIVE',1,11);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `product_promotion_relation`
--

LOCK TABLES `product_promotion_relation` WRITE;
/*!40000 ALTER TABLE `product_promotion_relation` DISABLE KEYS */;
INSERT INTO `product_promotion_relation` VALUES (1,11),(1,10),(1,9),(1,4),(1,3),(2,6),(2,2),(2,1),(3,5),(2,7),(1,15),(1,16);
/*!40000 ALTER TABLE `product_promotion_relation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `product_size_relation`
--

LOCK TABLES `product_size_relation` WRITE;
/*!40000 ALTER TABLE `product_size_relation` DISABLE KEYS */;
INSERT INTO `product_size_relation` VALUES (1,5),(1,4),(1,3),(1,2),(2,5),(2,4),(2,3),(2,2),(3,2),(3,3),(3,4),(4,2),(4,3),(4,4),(5,2),(5,1),(6,2),(6,3),(6,4),(6,5),(7,2),(7,3),(7,4),(7,5),(8,3),(8,4),(8,5),(9,1),(9,2),(9,3),(9,4),(10,1),(10,2),(10,3),(10,4),(10,5),(11,1),(11,2),(11,3),(11,4),(12,2),(12,3),(12,4),(13,2),(13,3),(13,4),(13,5),(14,3),(14,4),(14,5),(15,1),(15,2),(15,3),(15,4),(16,1),(16,2),(16,3),(16,4),(17,3),(17,2),(17,1),(2,6);
/*!40000 ALTER TABLE `product_size_relation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `promotion`
--

LOCK TABLES `promotion` WRITE;
/*!40000 ALTER TABLE `promotion` DISABLE KEYS */;
INSERT INTO `promotion` VALUES (1,'Sale Off 20% for Women clothes',20,'2019-05-07','SALEOFF20','2019-03-28','ACTIVE'),(2,'Sale Off 10% for Men clothes',10,'2019-04-30','SALE4MEN10','2019-04-10','ACTIVE'),(3,'Sale Off 15% for Kids clothes',15,'2019-04-30','SALE4KID15','2019-04-11','ACTIVE');
/*!40000 ALTER TABLE `promotion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `shipping`
--

LOCK TABLES `shipping` WRITE;
/*!40000 ALTER TABLE `shipping` DISABLE KEYS */;
INSERT INTO `shipping` VALUES (1,'Hoa Tien','dinhtai92dn@gmail.com','Nguyen Dinh Tai','0704555666'),(2,'Hoa Tien','dinhtai92dn@gmail.com','Nguyen Dinh Tai','0704555666'),(3,'Hoa Tien, Hoa Vang','dinhtai92dn@gmail.com','Nguyen Dinh Tai','0704555444'),(4,'Hoa Tien, Hoa Vang','dinhtai92dn@gmail.com','Nguyen Dinh Tai','0704555444'),(5,'Hoa Tien, Hoa Vang','dinhtai92dn@gmail.com','Nguyen Dinh Tai','0704555444'),(6,'Hoa Tien, Hoa Vang','dinhtai92dn@gmail.com','Nguyen Dinh Tai','0704555444'),(7,'La Bong, Hoa Tien, Hoa Vang','dinhtai92dn@gmail.com','Nguyen Dinh Tai','0704555444'),(8,'Hoa Tien, Hoa Vang','dinhtai92dn@gmail.com','Nguyen Dinh Tai','0704555444'),(9,'4609 Lincoln Park Drive','nguyendinhtai92dn@gmail.com','USER MOT','7034934583'),(10,'4609 Lincoln Park Drive','nguyendinhtai92dn@gmail.com','USER MOT','7034934583'),(11,'4609 Lincoln Park Drive','nguyendinhtai92dn@gmail.com','USER MOT','7034934583'),(12,'HOA THO','dinhtai92dn@gmail.com','NHU Y','9090999999'),(13,'Hoa Tien, Hoa Vang','dinhtai92dn@gmail.com','Nguyen Dinh Tai','0704555444'),(14,'Hoa Tien, Hoa Vang','dinhtai92dn@gmail.com','Nguyen Dinh Tai','0704555444'),(15,'Hoa Tien, Hoa Vang','dinhtai92dn@gmail.com','Nguyen Dinh Tai','0704555444'),(16,'Hoa Tien, Hoa Vang','dinhtai92dn@gmail.com','Nguyen Dinh Tai','0704555444'),(17,'Hoa Tien, Hoa Vang','dinhtai92.dn@gmail.com','TAI NGUYEN','012345611'),(18,'Hoa Tien, Hoa Vang','dinhtai92.dn@gmail.com','TAI NGUYEN','012345611');
/*!40000 ALTER TABLE `shipping` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `size`
--

LOCK TABLES `size` WRITE;
/*!40000 ALTER TABLE `size` DISABLE KEYS */;
INSERT INTO `size` VALUES (1,'XS'),(2,'S'),(3,'M'),(4,'L'),(5,'XL'),(6,'XXL');
/*!40000 ALTER TABLE `size` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `verify`
--

LOCK TABLES `verify` WRITE;
/*!40000 ALTER TABLE `verify` DISABLE KEYS */;
INSERT INTO `verify` VALUES (2,'aeffe162-d3d5-44cd-ba1e-47f82e655a8c','user3@gmail.com');
/*!40000 ALTER TABLE `verify` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-04-18 12:31:22
