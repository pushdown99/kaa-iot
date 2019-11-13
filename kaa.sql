-- MySQL dump 10.13  Distrib 5.7.27, for Linux (x86_64)
--
-- Host: localhost    Database: kaa
-- ------------------------------------------------------
-- Server version	5.7.27-0ubuntu0.16.04.1

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
-- Table structure for table `abstract_structure`
--

DROP TABLE IF EXISTS `abstract_structure`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `abstract_structure` (
  `id` bigint(20) NOT NULL,
  `activated_time` bigint(20) DEFAULT NULL,
  `activated_username` varchar(255) DEFAULT NULL,
  `created_time` bigint(20) DEFAULT NULL,
  `created_username` varchar(255) DEFAULT NULL,
  `deactivated_time` bigint(20) DEFAULT NULL,
  `deactivated_username` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `endpoint_count` bigint(20) DEFAULT NULL,
  `last_modify_time` bigint(20) DEFAULT NULL,
  `modified_username` varchar(255) DEFAULT NULL,
  `sequence_number` int(11) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `optimistic_lock` bigint(20) DEFAULT NULL,
  `application_id` bigint(20) NOT NULL,
  `endpoint_group_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_t5uv4cntp4vvigky5mtkxovde` (`application_id`),
  KEY `FK_g23m1sg61brt3fovtnkxq2opk` (`endpoint_group_id`),
  CONSTRAINT `FK_g23m1sg61brt3fovtnkxq2opk` FOREIGN KEY (`endpoint_group_id`) REFERENCES `endpoint_group` (`id`) ON DELETE CASCADE,
  CONSTRAINT `FK_t5uv4cntp4vvigky5mtkxovde` FOREIGN KEY (`application_id`) REFERENCES `application` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `abstract_structure`
--

LOCK TABLES `abstract_structure` WRITE;
/*!40000 ALTER TABLE `abstract_structure` DISABLE KEYS */;
INSERT INTO `abstract_structure` VALUES (1,1572496813862,'popup',1572496813792,'popup',0,NULL,'Generated',0,1572496813799,NULL,1,'ACTIVE',1,1,1),(2,1572497146069,'pushdown99',1572497145847,'pushdown99',0,NULL,'Generated',0,1572497145849,NULL,1,'ACTIVE',1,1,1);
/*!40000 ALTER TABLE `abstract_structure` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `admin_authority`
--

DROP TABLE IF EXISTS `admin_authority`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `admin_authority` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `authority` varchar(255) DEFAULT NULL,
  `user_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_pglc99q1ld4mr9nrsx8yfl53b` (`user_id`),
  CONSTRAINT `FK_pglc99q1ld4mr9nrsx8yfl53b` FOREIGN KEY (`user_id`) REFERENCES `admin_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin_authority`
--

LOCK TABLES `admin_authority` WRITE;
/*!40000 ALTER TABLE `admin_authority` DISABLE KEYS */;
INSERT INTO `admin_authority` VALUES (1,'KAA_ADMIN',1),(2,'TENANT_ADMIN',2),(3,'TENANT_DEVELOPER',3);
/*!40000 ALTER TABLE `admin_authority` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `admin_properties`
--

DROP TABLE IF EXISTS `admin_properties`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `admin_properties` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `fqn` varchar(255) DEFAULT NULL,
  `rawConfiguration` longblob,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin_properties`
--

LOCK TABLES `admin_properties` WRITE;
/*!40000 ALTER TABLE `admin_properties` DISABLE KEYS */;
INSERT INTO `admin_properties` VALUES (1,'org.kaaproject.kaa.server.admin.services.entity.gen.SmtpMailProperties',_binary 'BKaa <admin@localhost.localdomain>smtp.gmail.com¢\0 œ\0\0\0 haeyun@gmail.com\0aq17531234'),(2,'org.kaaproject.kaa.server.admin.services.entity.gen.GeneralProperties',_binary 'Kaa*http://localhost:8080');
/*!40000 ALTER TABLE `admin_properties` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `admin_user`
--

DROP TABLE IF EXISTS `admin_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `admin_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `enabled` bit(1) NOT NULL,
  `firstName` varchar(255) DEFAULT NULL,
  `lastName` varchar(255) DEFAULT NULL,
  `mail` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `passwordResetHash` varchar(255) DEFAULT NULL,
  `tempPassword` bit(1) NOT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_lvod9bfm438ex1071ku1glb70` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin_user`
--

LOCK TABLES `admin_user` WRITE;
/*!40000 ALTER TABLE `admin_user` DISABLE KEYS */;
INSERT INTO `admin_user` VALUES (1,_binary '',NULL,NULL,NULL,'$2a$10$LQxSzTOrgUfW9hRzkPOUe.5ddl7QTLJLULJA.Fxiyh8mfZY0nm4NW',NULL,_binary '\0','admin'),(2,_binary '',NULL,NULL,'popup@naver.com','$2a$10$CLttofK5moewmi.tkjVz5O6oISq9OYdjxaxv2fFGpdsMfNjoGuFMK',NULL,_binary '\0','popup'),(3,_binary '',NULL,NULL,'pushdown99@hotmail.com','$2a$10$APpOlap0TaMKX2i/6rU.1uFxN4RbCrwqbubxnQTYIkQ0fjakOcR4C',NULL,_binary '\0','pushdown99');
/*!40000 ALTER TABLE `admin_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `application`
--

DROP TABLE IF EXISTS `application`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `application` (
  `id` bigint(20) NOT NULL,
  `application_token` varchar(255) DEFAULT NULL,
  `credentials_service` varchar(255) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `sequence_number` int(11) DEFAULT NULL,
  `tenant_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_9sl087nu585d3i0rexu115ut2` (`tenant_id`,`name`),
  UNIQUE KEY `UK_6t3emgtt4qh9n03nshofv9od6` (`application_token`),
  CONSTRAINT `FK_8oamqms10799ijgmh8qb88yut` FOREIGN KEY (`tenant_id`) REFERENCES `tenant` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `application`
--

LOCK TABLES `application` WRITE;
/*!40000 ALTER TABLE `application` DISABLE KEYS */;
INSERT INTO `application` VALUES (1,'92158128884312751771','Trustful','Test Application',2,1);
/*!40000 ALTER TABLE `application` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `application_event_family_map`
--

DROP TABLE IF EXISTS `application_event_family_map`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `application_event_family_map` (
  `id` bigint(20) NOT NULL,
  `created_time` bigint(20) DEFAULT NULL,
  `created_username` varchar(255) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `application_id` bigint(20) NOT NULL,
  `events_class_family_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_o03hwph2m2111h4ld2psmvg5p` (`application_id`),
  KEY `FK_gvsyw3r82yby0synnr9u2sg05` (`events_class_family_id`),
  CONSTRAINT `FK_gvsyw3r82yby0synnr9u2sg05` FOREIGN KEY (`events_class_family_id`) REFERENCES `events_class_family` (`id`) ON DELETE CASCADE,
  CONSTRAINT `FK_o03hwph2m2111h4ld2psmvg5p` FOREIGN KEY (`application_id`) REFERENCES `application` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `application_event_family_map`
--

LOCK TABLES `application_event_family_map` WRITE;
/*!40000 ALTER TABLE `application_event_family_map` DISABLE KEYS */;
/*!40000 ALTER TABLE `application_event_family_map` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `application_event_map`
--

DROP TABLE IF EXISTS `application_event_map`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `application_event_map` (
  `id` bigint(20) NOT NULL,
  `action` varchar(255) DEFAULT NULL,
  `fqn` varchar(255) DEFAULT NULL,
  `events_class_id` bigint(20) NOT NULL,
  `application_event_family_map_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_i4f2pub85yeu4hvtnq0wbdth4` (`events_class_id`),
  KEY `FK_ff2h9p3e5dhh6y6vooa4mbad1` (`application_event_family_map_id`),
  CONSTRAINT `FK_ff2h9p3e5dhh6y6vooa4mbad1` FOREIGN KEY (`application_event_family_map_id`) REFERENCES `application_event_family_map` (`id`),
  CONSTRAINT `FK_i4f2pub85yeu4hvtnq0wbdth4` FOREIGN KEY (`events_class_id`) REFERENCES `events_class` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `application_event_map`
--

LOCK TABLES `application_event_map` WRITE;
/*!40000 ALTER TABLE `application_event_map` DISABLE KEYS */;
/*!40000 ALTER TABLE `application_event_map` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `base_schems`
--

DROP TABLE IF EXISTS `base_schems`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `base_schems` (
  `id` bigint(20) NOT NULL,
  `created_time` bigint(20) DEFAULT NULL,
  `created_username` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `application_id` bigint(20) DEFAULT NULL,
  `ctl_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_server_pf_schems_app_id` (`application_id`),
  KEY `fk_server_pf_schems_ctl_id` (`ctl_id`),
  CONSTRAINT `fk_server_pf_schems_app_id` FOREIGN KEY (`application_id`) REFERENCES `application` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_server_pf_schems_ctl_id` FOREIGN KEY (`ctl_id`) REFERENCES `ctl` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `base_schems`
--

LOCK TABLES `base_schems` WRITE;
/*!40000 ALTER TABLE `base_schems` DISABLE KEYS */;
INSERT INTO `base_schems` VALUES (1,1572496813680,'popup',NULL,'Generated',0,1,1),(2,1572496813763,'popup',NULL,'Generated',1,1,1),(3,1572496813986,'popup',NULL,'Generated',0,1,1),(4,1572496813989,'popup',NULL,'Generated',1,1,1),(5,1572496814006,'popup',NULL,'Generated',1,1,1),(6,1572497112247,'pushdown99',NULL,'Log Schemas',2,1,2),(7,1572497145692,'pushdown99',NULL,'Configuration Schemas',2,1,3);
/*!40000 ALTER TABLE `base_schems` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `changes`
--

DROP TABLE IF EXISTS `changes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `changes` (
  `id` bigint(20) NOT NULL,
  `configuration_id` bigint(20) DEFAULT NULL,
  `configuration_version` int(11) DEFAULT NULL,
  `endpoint_group_id` bigint(20) DEFAULT NULL,
  `profile_filter_id` bigint(20) DEFAULT NULL,
  `topic_id` bigint(20) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `changes`
--

LOCK TABLES `changes` WRITE;
/*!40000 ALTER TABLE `changes` DISABLE KEYS */;
INSERT INTO `changes` VALUES (1,1,1,1,NULL,NULL,'ADD_CONF'),(2,2,2,1,NULL,NULL,'ADD_CONF');
/*!40000 ALTER TABLE `changes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `configuration`
--

DROP TABLE IF EXISTS `configuration`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `configuration` (
  `configuration_body` longblob,
  `configuration_schems_version` int(11) DEFAULT NULL,
  `id` bigint(20) NOT NULL,
  `configuration_schems_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_smcmof238to6x3ta7enujgd8m` (`configuration_schems_id`),
  CONSTRAINT `FK_q1y4xb3dkmkvadurm574ago0j` FOREIGN KEY (`id`) REFERENCES `abstract_structure` (`id`) ON DELETE CASCADE,
  CONSTRAINT `FK_smcmof238to6x3ta7enujgd8m` FOREIGN KEY (`configuration_schems_id`) REFERENCES `configuration_schems` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `configuration`
--

LOCK TABLES `configuration` WRITE;
/*!40000 ALTER TABLE `configuration` DISABLE KEYS */;
INSERT INTO `configuration` VALUES (_binary '{\"__uuid\":{\"org.kaaproject.configuration.uuidT\":\"WO/gLV2XTOSkzWFtU5IqnA==\"}}',1,1,2),(_binary '{\"samplePeriod\":1,\"__uuid\":{\"org.kaaproject.configuration.uuidT\":\"hhfQryuOQtSaFQL1eq/daQ==\"}}',2,2,7);
/*!40000 ALTER TABLE `configuration` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `configuration_schems`
--

DROP TABLE IF EXISTS `configuration_schems`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `configuration_schems` (
  `base_schems` longtext,
  `override_schems` longtext,
  `protocol_schems` longtext,
  `id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FK_6c1w1hvw3794uenuce20voli9` FOREIGN KEY (`id`) REFERENCES `base_schems` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `configuration_schems`
--

LOCK TABLES `configuration_schems` WRITE;
/*!40000 ALTER TABLE `configuration_schems` DISABLE KEYS */;
INSERT INTO `configuration_schems` VALUES ('{\"type\":\"record\",\"name\":\"EmptyData\",\"namespace\":\"org.kaaproject.kaa.schema.system\",\"fields\":[{\"name\":\"__uuid\",\"type\":[{\"type\":\"fixed\",\"name\":\"uuidT\",\"namespace\":\"org.kaaproject.configuration\",\"size\":16},\"null\"],\"displayName\":\"Record Id\",\"fieldAccess\":\"read_only\"}],\"version\":1,\"displayName\":\"Empty Data\",\"description\":\"Auto generated\"}','{\"type\":\"record\",\"name\":\"EmptyData\",\"namespace\":\"org.kaaproject.kaa.schema.system\",\"fields\":[{\"name\":\"__uuid\",\"type\":[{\"type\":\"fixed\",\"name\":\"uuidT\",\"namespace\":\"org.kaaproject.configuration\",\"size\":16},\"null\"],\"displayName\":\"Record Id\",\"fieldAccess\":\"read_only\"}],\"version\":1,\"displayName\":\"Empty Data\",\"description\":\"Auto generated\"}','{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"deltaT\",\"namespace\":\"org.kaaproject.configuration\",\"fields\":[{\"name\":\"delta\",\"type\":[{\"type\":\"record\",\"name\":\"EmptyData\",\"namespace\":\"org.kaaproject.kaa.schema.system\",\"fields\":[{\"name\":\"__uuid\",\"type\":{\"type\":\"fixed\",\"name\":\"uuidT\",\"namespace\":\"org.kaaproject.configuration\",\"size\":16},\"displayName\":\"Record Id\",\"fieldAccess\":\"read_only\"}],\"version\":1,\"displayName\":\"Empty Data\",\"description\":\"Auto generated\"}]}]}}',2),('{\"type\":\"record\",\"name\":\"Configuration\",\"namespace\":\"org.kaaproject.kaa.schema.sample\",\"fields\":[{\"name\":\"samplePeriod\",\"type\":\"int\",\"by_default\":1},{\"name\":\"__uuid\",\"type\":[{\"type\":\"fixed\",\"name\":\"uuidT\",\"namespace\":\"org.kaaproject.configuration\",\"size\":16},\"null\"],\"displayName\":\"Record Id\",\"fieldAccess\":\"read_only\"}],\"version\":1,\"displayName\":\"Configuration Schemas\"}','{\"type\":\"record\",\"name\":\"Configuration\",\"namespace\":\"org.kaaproject.kaa.schema.sample\",\"fields\":[{\"name\":\"samplePeriod\",\"type\":[\"int\",{\"type\":\"enum\",\"name\":\"unchangedT\",\"namespace\":\"org.kaaproject.configuration\",\"symbols\":[\"unchanged\"]}],\"by_default\":1},{\"name\":\"__uuid\",\"type\":[{\"type\":\"fixed\",\"name\":\"uuidT\",\"namespace\":\"org.kaaproject.configuration\",\"size\":16},\"null\"],\"displayName\":\"Record Id\",\"fieldAccess\":\"read_only\"}],\"version\":1,\"displayName\":\"Configuration Schemas\"}','{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"deltaT\",\"namespace\":\"org.kaaproject.configuration\",\"fields\":[{\"name\":\"delta\",\"type\":[{\"type\":\"record\",\"name\":\"Configuration\",\"namespace\":\"org.kaaproject.kaa.schema.sample\",\"fields\":[{\"name\":\"samplePeriod\",\"type\":[\"int\",{\"type\":\"enum\",\"name\":\"unchangedT\",\"namespace\":\"org.kaaproject.configuration\",\"symbols\":[\"unchanged\"]}],\"by_default\":1},{\"name\":\"__uuid\",\"type\":{\"type\":\"fixed\",\"name\":\"uuidT\",\"namespace\":\"org.kaaproject.configuration\",\"size\":16},\"displayName\":\"Record Id\",\"fieldAccess\":\"read_only\"}],\"version\":1,\"displayName\":\"Configuration Schemas\"}]}]}}',7);
/*!40000 ALTER TABLE `configuration_schems` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ctl`
--

DROP TABLE IF EXISTS `ctl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ctl` (
  `id` bigint(20) NOT NULL,
  `body` longtext,
  `created_time` bigint(20) DEFAULT NULL,
  `created_username` varchar(255) DEFAULT NULL,
  `default_record` longtext,
  `version` int(11) DEFAULT NULL,
  `metainfo_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `ctl_unique_constraint` (`metainfo_id`,`version`),
  CONSTRAINT `fk_ctl_metainfo_id` FOREIGN KEY (`metainfo_id`) REFERENCES `ctl_metainfo` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ctl`
--

LOCK TABLES `ctl` WRITE;
/*!40000 ALTER TABLE `ctl` DISABLE KEYS */;
INSERT INTO `ctl` VALUES (1,'{\n    \"type\": \"record\",\n    \"name\": \"EmptyData\",\n    \"namespace\": \"org.kaaproject.kaa.schema.system\",\n    \"version\": 1,\n    \"dependencies\": [],\n    \"displayName\": \"Empty Data\",\n    \"description\": \"Auto generated\",\n    \"fields\": []\n}',1572496813418,'popup','',1,1),(2,'{\n  \"type\" : \"record\",\n  \"name\" : \"DataCollection\",\n  \"namespace\" : \"org.kaaproject.kaa.schema.sample\",\n  \"fields\" : [ {\n    \"name\" : \"temperature\",\n    \"type\" : \"int\"\n  } ],\n  \"version\" : 1,\n  \"dependencies\" : [ ],\n  \"displayName\" : \"Log Schemas\"\n}',1572497111850,'pushdown99','{\"temperature\":0}',1,2),(3,'{\n  \"type\" : \"record\",\n  \"name\" : \"Configuration\",\n  \"namespace\" : \"org.kaaproject.kaa.schema.sample\",\n  \"fields\" : [ {\n    \"name\" : \"samplePeriod\",\n    \"type\" : \"int\",\n    \"by_default\" : 1\n  } ],\n  \"version\" : 1,\n  \"dependencies\" : [ ],\n  \"displayName\" : \"Configuration Schemas\"\n}',1572497145521,'pushdown99','{\"samplePeriod\":1}',1,3);
/*!40000 ALTER TABLE `ctl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ctl_dependency`
--

DROP TABLE IF EXISTS `ctl_dependency`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ctl_dependency` (
  `parent_id` bigint(20) NOT NULL,
  `child_id` bigint(20) NOT NULL,
  PRIMARY KEY (`parent_id`,`child_id`),
  KEY `FK_csknwf0ihtl6tyswpfdvxl2ox` (`child_id`),
  CONSTRAINT `FK_csknwf0ihtl6tyswpfdvxl2ox` FOREIGN KEY (`child_id`) REFERENCES `ctl` (`id`),
  CONSTRAINT `FK_qf0hx7ehr412ubkwtvjkc25g1` FOREIGN KEY (`parent_id`) REFERENCES `ctl` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ctl_dependency`
--

LOCK TABLES `ctl_dependency` WRITE;
/*!40000 ALTER TABLE `ctl_dependency` DISABLE KEYS */;
/*!40000 ALTER TABLE `ctl_dependency` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ctl_metainfo`
--

DROP TABLE IF EXISTS `ctl_metainfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ctl_metainfo` (
  `id` bigint(20) NOT NULL,
  `fqn` varchar(255) DEFAULT NULL,
  `application_id` bigint(20) DEFAULT NULL,
  `tenant_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `ctl_metainfo_unique_constraint` (`fqn`,`tenant_id`,`application_id`),
  KEY `fk_ctl_metainfo_app_id` (`application_id`),
  KEY `fk_ctl_metainfo_tenant_id` (`tenant_id`),
  CONSTRAINT `fk_ctl_metainfo_app_id` FOREIGN KEY (`application_id`) REFERENCES `application` (`id`),
  CONSTRAINT `fk_ctl_metainfo_tenant_id` FOREIGN KEY (`tenant_id`) REFERENCES `tenant` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ctl_metainfo`
--

LOCK TABLES `ctl_metainfo` WRITE;
/*!40000 ALTER TABLE `ctl_metainfo` DISABLE KEYS */;
INSERT INTO `ctl_metainfo` VALUES (3,'org.kaaproject.kaa.schema.sample.Configuration',1,1),(2,'org.kaaproject.kaa.schema.sample.DataCollection',1,1),(1,'org.kaaproject.kaa.schema.system.EmptyData',NULL,NULL);
/*!40000 ALTER TABLE `ctl_metainfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `endpoint_group`
--

DROP TABLE IF EXISTS `endpoint_group`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `endpoint_group` (
  `id` bigint(20) NOT NULL,
  `created_time` bigint(20) DEFAULT NULL,
  `created_username` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `endpoint_count` bigint(20) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `sequence_number` int(11) DEFAULT NULL,
  `weight` int(11) DEFAULT NULL,
  `application_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_tp701e8bmnvi01nu4kv8hfloh` (`weight`,`application_id`),
  UNIQUE KEY `UK_eqa8f921it9bw7otht0nu1qev` (`name`,`application_id`),
  KEY `FK_6cot0d89oyq27hhhnpbn1daqh` (`application_id`),
  CONSTRAINT `FK_6cot0d89oyq27hhhnpbn1daqh` FOREIGN KEY (`application_id`) REFERENCES `application` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `endpoint_group`
--

LOCK TABLES `endpoint_group` WRITE;
/*!40000 ALTER TABLE `endpoint_group` DISABLE KEYS */;
INSERT INTO `endpoint_group` VALUES (1,1572496813187,'popup',NULL,0,'All',0,0,1);
/*!40000 ALTER TABLE `endpoint_group` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `endpoint_group_topic`
--

DROP TABLE IF EXISTS `endpoint_group_topic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `endpoint_group_topic` (
  `topic_id` bigint(20) NOT NULL,
  `endpoint_group_id` bigint(20) NOT NULL,
  PRIMARY KEY (`topic_id`,`endpoint_group_id`),
  KEY `FK_rj5nireuqqcr19cl770aivx5u` (`endpoint_group_id`),
  CONSTRAINT `FK_dk8mhmwthtwyie2xco1u90e19` FOREIGN KEY (`topic_id`) REFERENCES `topic` (`id`),
  CONSTRAINT `FK_rj5nireuqqcr19cl770aivx5u` FOREIGN KEY (`endpoint_group_id`) REFERENCES `endpoint_group` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `endpoint_group_topic`
--

LOCK TABLES `endpoint_group_topic` WRITE;
/*!40000 ALTER TABLE `endpoint_group_topic` DISABLE KEYS */;
/*!40000 ALTER TABLE `endpoint_group_topic` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `events_class`
--

DROP TABLE IF EXISTS `events_class`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `events_class` (
  `fqn` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `id` bigint(20) NOT NULL,
  `events_class_family_versions_id` bigint(20) NOT NULL,
  `tenant_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_b232w1agclbbkjp234pr24dl8` (`events_class_family_versions_id`),
  KEY `FK_e46pa13gxjvs1p97r1xsn2kdk` (`tenant_id`),
  CONSTRAINT `FK_2hsf4c4cb3n72wijuxlaywli0` FOREIGN KEY (`id`) REFERENCES `base_schems` (`id`),
  CONSTRAINT `FK_b232w1agclbbkjp234pr24dl8` FOREIGN KEY (`events_class_family_versions_id`) REFERENCES `events_class_family_versions` (`id`),
  CONSTRAINT `FK_e46pa13gxjvs1p97r1xsn2kdk` FOREIGN KEY (`tenant_id`) REFERENCES `tenant` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `events_class`
--

LOCK TABLES `events_class` WRITE;
/*!40000 ALTER TABLE `events_class` DISABLE KEYS */;
/*!40000 ALTER TABLE `events_class` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `events_class_family`
--

DROP TABLE IF EXISTS `events_class_family`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `events_class_family` (
  `id` bigint(20) NOT NULL,
  `class_name` varchar(255) DEFAULT NULL,
  `created_time` bigint(20) DEFAULT NULL,
  `created_username` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `namespace` varchar(255) DEFAULT NULL,
  `tenant_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_lsk6eeeeh7flqgyy4jvysk5qu` (`tenant_id`),
  CONSTRAINT `FK_lsk6eeeeh7flqgyy4jvysk5qu` FOREIGN KEY (`tenant_id`) REFERENCES `tenant` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `events_class_family`
--

LOCK TABLES `events_class_family` WRITE;
/*!40000 ALTER TABLE `events_class_family` DISABLE KEYS */;
/*!40000 ALTER TABLE `events_class_family` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `events_class_family_versions`
--

DROP TABLE IF EXISTS `events_class_family_versions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `events_class_family_versions` (
  `id` bigint(20) NOT NULL,
  `created_time` bigint(20) DEFAULT NULL,
  `created_username` varchar(255) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `events_class_family_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_kwemq9h2rn4ydxsfibecsl4nu` (`events_class_family_id`),
  CONSTRAINT `FK_kwemq9h2rn4ydxsfibecsl4nu` FOREIGN KEY (`events_class_family_id`) REFERENCES `events_class_family` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `events_class_family_versions`
--

LOCK TABLES `events_class_family_versions` WRITE;
/*!40000 ALTER TABLE `events_class_family_versions` DISABLE KEYS */;
/*!40000 ALTER TABLE `events_class_family_versions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `header_structure`
--

DROP TABLE IF EXISTS `header_structure`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `header_structure` (
  `LogAppender_id` bigint(20) NOT NULL,
  `structure_field` varchar(255) NOT NULL,
  KEY `FK_qtu8w8xl5bhbminn6wsdca5w7` (`LogAppender_id`),
  CONSTRAINT `FK_qtu8w8xl5bhbminn6wsdca5w7` FOREIGN KEY (`LogAppender_id`) REFERENCES `log_appender` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `header_structure`
--

LOCK TABLES `header_structure` WRITE;
/*!40000 ALTER TABLE `header_structure` DISABLE KEYS */;
INSERT INTO `header_structure` VALUES (32768,'KEYHASH'),(32768,'VERSION'),(32768,'TIMESTAMP'),(32768,'TOKEN'),(32768,'LSVERSION');
/*!40000 ALTER TABLE `header_structure` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequences`
--

DROP TABLE IF EXISTS `hibernate_sequences`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hibernate_sequences` (
  `sequence_name` varchar(255) DEFAULT NULL,
  `sequence_next_hi_value` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequences`
--

LOCK TABLES `hibernate_sequences` WRITE;
/*!40000 ALTER TABLE `hibernate_sequences` DISABLE KEYS */;
INSERT INTO `hibernate_sequences` VALUES ('tenant',1),('kaa_user',1),('application',1),('endpoint_group',1),('ctl_metainfo',1),('ctl',1),('base_schems',1),('abstract_structure',1),('history',1),('changes',1),('plugin',4),('sdk_token',2);
/*!40000 ALTER TABLE `hibernate_sequences` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `history`
--

DROP TABLE IF EXISTS `history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `history` (
  `id` bigint(20) NOT NULL,
  `last_modify_time` bigint(20) DEFAULT NULL,
  `sequence_number` int(11) DEFAULT NULL,
  `application_id` bigint(20) NOT NULL,
  `changes_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_eyxergb1sbprhre3qut0023fi` (`application_id`),
  KEY `FK_ha9grmepjf4bqbme96tcl6f6j` (`changes_id`),
  CONSTRAINT `FK_eyxergb1sbprhre3qut0023fi` FOREIGN KEY (`application_id`) REFERENCES `application` (`id`) ON DELETE CASCADE,
  CONSTRAINT `FK_ha9grmepjf4bqbme96tcl6f6j` FOREIGN KEY (`changes_id`) REFERENCES `changes` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `history`
--

LOCK TABLES `history` WRITE;
/*!40000 ALTER TABLE `history` DISABLE KEYS */;
INSERT INTO `history` VALUES (1,1572496813866,1,1,1),(2,1572497146145,2,1,2);
/*!40000 ALTER TABLE `history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kaa_user`
--

DROP TABLE IF EXISTS `kaa_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `kaa_user` (
  `id` bigint(20) NOT NULL,
  `authority` varchar(255) DEFAULT NULL,
  `external_uid` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `tenant_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_kf6art3d9xcj4sy91qegysgv` (`tenant_id`,`external_uid`),
  CONSTRAINT `FK_nwwouvn5xp4svu0yvf0du1scj` FOREIGN KEY (`tenant_id`) REFERENCES `tenant` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kaa_user`
--

LOCK TABLES `kaa_user` WRITE;
/*!40000 ALTER TABLE `kaa_user` DISABLE KEYS */;
INSERT INTO `kaa_user` VALUES (1,'TENANT_ADMIN','2','popup',1),(2,'TENANT_DEVELOPER','3','pushdown99',1);
/*!40000 ALTER TABLE `kaa_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `log_appender`
--

DROP TABLE IF EXISTS `log_appender`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `log_appender` (
  `confirm_delivery` bit(1) DEFAULT NULL,
  `max_log_schems_version` int(11) DEFAULT NULL,
  `min_log_schems_version` int(11) DEFAULT NULL,
  `id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FK_is9fjprh3841xd5vtbhe53av2` FOREIGN KEY (`id`) REFERENCES `plugin` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `log_appender`
--

LOCK TABLES `log_appender` WRITE;
/*!40000 ALTER TABLE `log_appender` DISABLE KEYS */;
INSERT INTO `log_appender` VALUES (_binary '',2147483647,1,32768);
/*!40000 ALTER TABLE `log_appender` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `log_schems`
--

DROP TABLE IF EXISTS `log_schems`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `log_schems` (
  `id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FK_qy3uck42ennaufnw01xluusrc` FOREIGN KEY (`id`) REFERENCES `base_schems` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `log_schems`
--

LOCK TABLES `log_schems` WRITE;
/*!40000 ALTER TABLE `log_schems` DISABLE KEYS */;
INSERT INTO `log_schems` VALUES (5),(6);
/*!40000 ALTER TABLE `log_schems` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notification_schems`
--

DROP TABLE IF EXISTS `notification_schems`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `notification_schems` (
  `type` int(11) DEFAULT NULL,
  `id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FK_jxs923lnfincmt0htt0hf8fpw` FOREIGN KEY (`id`) REFERENCES `base_schems` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notification_schems`
--

LOCK TABLES `notification_schems` WRITE;
/*!40000 ALTER TABLE `notification_schems` DISABLE KEYS */;
INSERT INTO `notification_schems` VALUES (0,4);
/*!40000 ALTER TABLE `notification_schems` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `plugin`
--

DROP TABLE IF EXISTS `plugin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `plugin` (
  `id` bigint(20) NOT NULL,
  `created_time` bigint(20) DEFAULT NULL,
  `created_username` varchar(255) DEFAULT NULL,
  `description` varchar(1000) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `plugin_class_name` varchar(255) DEFAULT NULL,
  `plugin_type_name` varchar(255) DEFAULT NULL,
  `raw_configuration` longblob,
  `application_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_9urxlnistpbq4ppw4i6x5d9hj` (`application_id`),
  CONSTRAINT `FK_9urxlnistpbq4ppw4i6x5d9hj` FOREIGN KEY (`application_id`) REFERENCES `application` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `plugin`
--

LOCK TABLES `plugin` WRITE;
/*!40000 ALTER TABLE `plugin` DISABLE KEYS */;
INSERT INTO `plugin` VALUES (1,1572497174458,'pushdown99','','User Verifier','org.kaaproject.kaa.server.verifiers.trustful.verifier.TrustfulUserVerifier','Trustful verifier','',1),(32768,1572499092190,'pushdown99','','My mongodb','org.kaaproject.kaa.server.appenders.mongo.appender.MongoDbLogAppender','MongoDB',_binary 'localhost’¦\0\0kaa\0<\0€\Ó\0N\0\0\0\0\0\0\0\0',1);
/*!40000 ALTER TABLE `plugin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `profile_filter`
--

DROP TABLE IF EXISTS `profile_filter`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `profile_filter` (
  `profile_filter_body` varchar(255) DEFAULT NULL,
  `id` bigint(20) NOT NULL,
  `endpoint_schems_id` bigint(20) DEFAULT NULL,
  `server_schems_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_44uw0i94fh2vk4llys30fdppb` (`endpoint_schems_id`),
  KEY `FK_pigj778qg4rknexptifpl7bik` (`server_schems_id`),
  CONSTRAINT `FK_44uw0i94fh2vk4llys30fdppb` FOREIGN KEY (`endpoint_schems_id`) REFERENCES `profile_schems` (`id`),
  CONSTRAINT `FK_pigj778qg4rknexptifpl7bik` FOREIGN KEY (`server_schems_id`) REFERENCES `server_profile_schems` (`id`),
  CONSTRAINT `FK_t2juyogk8wd20g5x54oafrn9e` FOREIGN KEY (`id`) REFERENCES `abstract_structure` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `profile_filter`
--

LOCK TABLES `profile_filter` WRITE;
/*!40000 ALTER TABLE `profile_filter` DISABLE KEYS */;
/*!40000 ALTER TABLE `profile_filter` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `profile_schems`
--

DROP TABLE IF EXISTS `profile_schems`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `profile_schems` (
  `id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FK_rwt514hdwy7bnib4kwo2dh9ny` FOREIGN KEY (`id`) REFERENCES `base_schems` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `profile_schems`
--

LOCK TABLES `profile_schems` WRITE;
/*!40000 ALTER TABLE `profile_schems` DISABLE KEYS */;
INSERT INTO `profile_schems` VALUES (1);
/*!40000 ALTER TABLE `profile_schems` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `schems`
--

DROP TABLE IF EXISTS `schems`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `schems` (
  `id` bigint(20) NOT NULL,
  `created_time` bigint(20) DEFAULT NULL,
  `created_username` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `endpoint_count` bigint(20) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `schems` longtext,
  `version` int(11) DEFAULT NULL,
  `application_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_no26f6n6hwan47ijhnxxp7isu` (`application_id`),
  CONSTRAINT `FK_no26f6n6hwan47ijhnxxp7isu` FOREIGN KEY (`application_id`) REFERENCES `application` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schems`
--

LOCK TABLES `schems` WRITE;
/*!40000 ALTER TABLE `schems` DISABLE KEYS */;
/*!40000 ALTER TABLE `schems` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sdk_token`
--

DROP TABLE IF EXISTS `sdk_token`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sdk_token` (
  `id` bigint(20) NOT NULL,
  `configuration_schems_version` int(11) DEFAULT NULL,
  `created_time` bigint(20) DEFAULT NULL,
  `created_username` varchar(255) DEFAULT NULL,
  `default_verifier_token` varchar(255) DEFAULT NULL,
  `endpoint_count` int(11) DEFAULT NULL,
  `log_schems_version` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `notification_schems_version` int(11) DEFAULT NULL,
  `profile_schems_version` int(11) DEFAULT NULL,
  `token` varchar(255) DEFAULT NULL,
  `application_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_jlbhe1m3k30f7y6pymylegf3p` (`application_id`),
  CONSTRAINT `FK_jlbhe1m3k30f7y6pymylegf3p` FOREIGN KEY (`application_id`) REFERENCES `application` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sdk_token`
--

LOCK TABLES `sdk_token` WRITE;
/*!40000 ALTER TABLE `sdk_token` DISABLE KEYS */;
INSERT INTO `sdk_token` VALUES (32768,2,1572498129833,'pushdown99','75573328582256784833',0,2,'My SDK',1,0,'Ik72lyuZez-SN9kj27tOAn9qsBc',1);
/*!40000 ALTER TABLE `sdk_token` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sdkprofile_aefmapids`
--

DROP TABLE IF EXISTS `sdkprofile_aefmapids`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sdkprofile_aefmapids` (
  `SdkProfile_id` bigint(20) NOT NULL,
  `aefMapIds` varchar(255) DEFAULT NULL,
  KEY `FK_ko8wc5lu38r1hgagjmv8w4j4t` (`SdkProfile_id`),
  CONSTRAINT `FK_ko8wc5lu38r1hgagjmv8w4j4t` FOREIGN KEY (`SdkProfile_id`) REFERENCES `sdk_token` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sdkprofile_aefmapids`
--

LOCK TABLES `sdkprofile_aefmapids` WRITE;
/*!40000 ALTER TABLE `sdkprofile_aefmapids` DISABLE KEYS */;
/*!40000 ALTER TABLE `sdkprofile_aefmapids` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `server_profile_schems`
--

DROP TABLE IF EXISTS `server_profile_schems`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `server_profile_schems` (
  `id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FK_6wjj3y9qvefue8ncc4nrdo24k` FOREIGN KEY (`id`) REFERENCES `base_schems` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `server_profile_schems`
--

LOCK TABLES `server_profile_schems` WRITE;
/*!40000 ALTER TABLE `server_profile_schems` DISABLE KEYS */;
INSERT INTO `server_profile_schems` VALUES (3);
/*!40000 ALTER TABLE `server_profile_schems` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tenant`
--

DROP TABLE IF EXISTS `tenant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tenant` (
  `id` bigint(20) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_dcxf3ksi0gyn1tieeq0id96lm` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tenant`
--

LOCK TABLES `tenant` WRITE;
/*!40000 ALTER TABLE `tenant` DISABLE KEYS */;
INSERT INTO `tenant` VALUES (1,'popup');
/*!40000 ALTER TABLE `tenant` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `topic`
--

DROP TABLE IF EXISTS `topic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `topic` (
  `id` bigint(20) NOT NULL,
  `created_time` bigint(20) DEFAULT NULL,
  `created_username` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `sequence_number` int(11) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `application_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_1xe10jw4ag452iy0sxi6t01jw` (`name`,`application_id`),
  KEY `FK_67pt395diacy1os1c4h08gm51` (`application_id`),
  CONSTRAINT `FK_67pt395diacy1os1c4h08gm51` FOREIGN KEY (`application_id`) REFERENCES `application` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `topic`
--

LOCK TABLES `topic` WRITE;
/*!40000 ALTER TABLE `topic` DISABLE KEYS */;
/*!40000 ALTER TABLE `topic` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_verifier`
--

DROP TABLE IF EXISTS `user_verifier`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_verifier` (
  `verifier_token` varchar(255) DEFAULT NULL,
  `id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FK_ghpj2j19qtpvhllhjwgcrwmtd` FOREIGN KEY (`id`) REFERENCES `plugin` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_verifier`
--

LOCK TABLES `user_verifier` WRITE;
/*!40000 ALTER TABLE `user_verifier` DISABLE KEYS */;
INSERT INTO `user_verifier` VALUES ('75573328582256784833',1);
/*!40000 ALTER TABLE `user_verifier` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-11-11  8:16:51
