CREATE DATABASE  IF NOT EXISTS `proyecto_agua` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `proyecto_agua`;
-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: proyecto_agua
-- ------------------------------------------------------
-- Server version	5.6.32-log

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
-- Table structure for table `administrador`
--

DROP TABLE IF EXISTS `administrador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `administrador` (
  `idAdministrador` varchar(45) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`idAdministrador`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `consumo`
--

DROP TABLE IF EXISTS `consumo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `consumo` (
  `fecha` date NOT NULL,
  `socio_idsocio` int(11) NOT NULL,
  `cantidad` double DEFAULT '0',
  PRIMARY KEY (`socio_idsocio`,`fecha`),
  KEY `fk_consumo_socio1_idx` (`socio_idsocio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `factura`
--

DROP TABLE IF EXISTS `factura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `factura` (
  `idSocio` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `tipo` int(11) NOT NULL,
  `cantidadConsumo` double NOT NULL DEFAULT '0',
  `multaTrabajo` double DEFAULT '0',
  `multaReunion` double DEFAULT '0',
  `valorConsumo` double DEFAULT '0',
  `excesoConsumo` double DEFAULT '0',
  `totalMes` double DEFAULT '0',
  `mesesQueDebe` double DEFAULT '0',
  `valorQueDebe` double DEFAULT '0',
  `Recargos` double DEFAULT '0',
  `reinstalacion` double DEFAULT '0',
  `Total` double DEFAULT '0',
  PRIMARY KEY (`idSocio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `pago`
--

DROP TABLE IF EXISTS `pago`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pago` (
  `idsocio` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `estado` varchar(45) NOT NULL,
  `cantidadConsumo` double NOT NULL,
  PRIMARY KEY (`idsocio`,`fecha`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `precios`
--

DROP TABLE IF EXISTS `precios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `precios` (
  `idPrecios` int(11) NOT NULL,
  `cantidad` double NOT NULL,
  `Descripcion` varchar(100) NOT NULL,
  PRIMARY KEY (`idPrecios`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `reinstalacion`
--

DROP TABLE IF EXISTS `reinstalacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reinstalacion` (
  `idreingreso` int(11) NOT NULL AUTO_INCREMENT,
  `idsocio` int(11) NOT NULL,
  `valor` double NOT NULL,
  `estado` int(11) NOT NULL,
  `fecha` date NOT NULL,
  PRIMARY KEY (`idreingreso`,`idsocio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `reunion`
--

DROP TABLE IF EXISTS `reunion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reunion` (
  `fecha` date NOT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `descripcion` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`fecha`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `socio`
--

DROP TABLE IF EXISTS `socio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `socio` (
  `idsocio` int(11) NOT NULL,
  `medidor` int(50) DEFAULT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `cedula` varchar(10) DEFAULT NULL,
  `telefono` varchar(45) DEFAULT NULL,
  `correo` varchar(80) DEFAULT NULL,
  `consumoInicial` double NOT NULL DEFAULT '0',
  `estado` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`idsocio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `socio_has_reunion`
--

DROP TABLE IF EXISTS `socio_has_reunion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `socio_has_reunion` (
  `socio_idsocio` int(11) NOT NULL,
  `reunion_fecha` date NOT NULL,
  `tipoAsis` int(11) NOT NULL,
  `pago` int(11) DEFAULT NULL,
  PRIMARY KEY (`socio_idsocio`,`reunion_fecha`),
  KEY `fk_socio_has_reunion_reunion1_idx` (`reunion_fecha`),
  KEY `fk_socio_has_reunion_socio_idx` (`socio_idsocio`),
  CONSTRAINT `fk_socio_has_reunion_reunion1` FOREIGN KEY (`reunion_fecha`) REFERENCES `reunion` (`fecha`),
  CONSTRAINT `fk_socio_has_reunion_socio` FOREIGN KEY (`socio_idsocio`) REFERENCES `socio` (`idsocio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `trabajo`
--

DROP TABLE IF EXISTS `trabajo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `trabajo` (
  `fecha` date NOT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `descripcion` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`fecha`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `trabajo_has_socio`
--

DROP TABLE IF EXISTS `trabajo_has_socio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `trabajo_has_socio` (
  `trabajo_fecha` date NOT NULL,
  `socio_idsocio` int(11) NOT NULL,
  `asistencia` varchar(45) NOT NULL,
  `pago` int(11) NOT NULL,
  PRIMARY KEY (`trabajo_fecha`,`socio_idsocio`),
  KEY `fk_trabajo_has_socio_socio1_idx` (`socio_idsocio`),
  KEY `fk_trabajo_has_socio_trabajo1_idx` (`trabajo_fecha`),
  CONSTRAINT `fk_trabajo_has_socio_socio1` FOREIGN KEY (`socio_idsocio`) REFERENCES `socio` (`idsocio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-07-18 15:18:28
