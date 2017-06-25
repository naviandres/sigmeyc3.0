-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: sigmeyc
-- ------------------------------------------------------
-- Server version	5.5.5-10.1.21-MariaDB

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
-- Table structure for table `bitacoraplanillas`
--

DROP TABLE IF EXISTS `bitacoraplanillas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bitacoraplanillas` (
  `idbitacora` int(11) NOT NULL AUTO_INCREMENT,
  `movimiento` varchar(20) NOT NULL,
  `codigoPlanilla` int(11) NOT NULL,
  `ruta` varchar(20) NOT NULL,
  `cantidadGuias` int(11) NOT NULL,
  `descripcion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idbitacora`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Tabla de soporte Triggers\n																																																								';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bitacoraplanillas`
--

LOCK TABLES `bitacoraplanillas` WRITE;
/*!40000 ALTER TABLE `bitacoraplanillas` DISABLE KEYS */;
/*!40000 ALTER TABLE `bitacoraplanillas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ciudades`
--

DROP TABLE IF EXISTS `ciudades`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ciudades` (
  `idCiudades` int(11) NOT NULL AUTO_INCREMENT,
  `nombreCiudad` varchar(45) NOT NULL,
  `departamentos_idDepartamento` int(11) NOT NULL,
  PRIMARY KEY (`idCiudades`),
  KEY `fk_ciudades_departamentos1_idx` (`departamentos_idDepartamento`),
  CONSTRAINT `fk_ciudades_departamentos1` FOREIGN KEY (`departamentos_idDepartamento`) REFERENCES `departamentos` (`idDepartamento`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='Esta tabla permite el registro de la ciudades donde sera recogida o entregada la mercancia';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ciudades`
--

LOCK TABLES `ciudades` WRITE;
/*!40000 ALTER TABLE `ciudades` DISABLE KEYS */;
INSERT INTO `ciudades` VALUES (1,'Bogota D.C',1);
/*!40000 ALTER TABLE `ciudades` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `conductores`
--

DROP TABLE IF EXISTS `conductores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `conductores` (
  `documento` bigint(15) NOT NULL,
  `tipoLicencia` varchar(5) NOT NULL,
  `numeroLicencia` bigint(20) NOT NULL,
  `vehiculos_idVehiculo` int(11) NOT NULL,
  PRIMARY KEY (`documento`),
  UNIQUE KEY `documento_UNIQUE` (`documento`),
  KEY `fk_conductores_usuarios1_idx` (`documento`),
  KEY `fk_conductores_vehiculos1_idx` (`vehiculos_idVehiculo`),
  CONSTRAINT `fk_conductores_usuarios1` FOREIGN KEY (`documento`) REFERENCES `usuarios` (`documento`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_conductores_vehiculos1` FOREIGN KEY (`vehiculos_idVehiculo`) REFERENCES `vehiculos` (`idVehiculo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Esta tabla permite registrar los conductores asignados a cada vehiculo\n';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `conductores`
--

LOCK TABLES `conductores` WRITE;
/*!40000 ALTER TABLE `conductores` DISABLE KEYS */;
/*!40000 ALTER TABLE `conductores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cotizaciones`
--

DROP TABLE IF EXISTS `cotizaciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cotizaciones` (
  `idcotizaciones` int(11) NOT NULL AUTO_INCREMENT,
  `ciudadDestino` varchar(20) DEFAULT NULL,
  `cantidad` int(11) DEFAULT NULL,
  `peso` double DEFAULT NULL,
  `valorDeclarado` double DEFAULT NULL,
  `fechaCotizacion` date NOT NULL,
  `usuarios_documento` bigint(15) NOT NULL,
  PRIMARY KEY (`idcotizaciones`),
  KEY `fk_cotizaciones_usuarios1_idx` (`usuarios_documento`),
  CONSTRAINT `fk_cotizaciones_usuarios1` FOREIGN KEY (`usuarios_documento`) REFERENCES `usuarios` (`documento`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cotizaciones`
--

LOCK TABLES `cotizaciones` WRITE;
/*!40000 ALTER TABLE `cotizaciones` DISABLE KEYS */;
/*!40000 ALTER TABLE `cotizaciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cubicaciones`
--

DROP TABLE IF EXISTS `cubicaciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cubicaciones` (
  `idcotizaciones` int(11) NOT NULL,
  `altura` double DEFAULT NULL,
  `ancho` double DEFAULT NULL,
  `longitud` double DEFAULT NULL,
  `volumen` double DEFAULT NULL,
  KEY `fk_cubicaciones_cotizaciones1_idx` (`idcotizaciones`),
  CONSTRAINT `fk_cubicaciones_cotizaciones1` FOREIGN KEY (`idcotizaciones`) REFERENCES `cotizaciones` (`idcotizaciones`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cubicaciones`
--

LOCK TABLES `cubicaciones` WRITE;
/*!40000 ALTER TABLE `cubicaciones` DISABLE KEYS */;
/*!40000 ALTER TABLE `cubicaciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `departamentos`
--

DROP TABLE IF EXISTS `departamentos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `departamentos` (
  `idDepartamento` int(11) NOT NULL AUTO_INCREMENT,
  `nombreDepartamento` varchar(45) NOT NULL,
  PRIMARY KEY (`idDepartamento`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='Esta tabla permite el registro de los departamentos de origen y destino de la mercancia';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `departamentos`
--

LOCK TABLES `departamentos` WRITE;
/*!40000 ALTER TABLE `departamentos` DISABLE KEYS */;
INSERT INTO `departamentos` VALUES (1,'Cundinamarca');
/*!40000 ALTER TABLE `departamentos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `emails`
--

DROP TABLE IF EXISTS `emails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `emails` (
  `idemails` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `apellido` varchar(45) DEFAULT NULL,
  `correo` varchar(45) DEFAULT NULL,
  `correoDestinatario` varchar(45) DEFAULT NULL,
  `asunto` varchar(45) DEFAULT NULL,
  `mensaje` varchar(400) DEFAULT NULL,
  `usuarios_documento` bigint(15) DEFAULT NULL,
  PRIMARY KEY (`idemails`),
  KEY `fk_emails_usuarios1_idx` (`usuarios_documento`),
  CONSTRAINT `fk_emails_usuarios1` FOREIGN KEY (`usuarios_documento`) REFERENCES `usuarios` (`documento`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `emails`
--

LOCK TABLES `emails` WRITE;
/*!40000 ALTER TABLE `emails` DISABLE KEYS */;
/*!40000 ALTER TABLE `emails` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empresas`
--

DROP TABLE IF EXISTS `empresas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `empresas` (
  `nit` bigint(15) NOT NULL,
  `razonSocial` varchar(30) NOT NULL,
  PRIMARY KEY (`nit`),
  UNIQUE KEY `nit_UNIQUE` (`nit`),
  KEY `fk_empresas_usuarios1_idx` (`nit`),
  CONSTRAINT `fk_empresas_usuarios1` FOREIGN KEY (`nit`) REFERENCES `usuarios` (`documento`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Esta tabla permitira el registro de las empresas y su razon social.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empresas`
--

LOCK TABLES `empresas` WRITE;
/*!40000 ALTER TABLE `empresas` DISABLE KEYS */;
INSERT INTO `empresas` VALUES (123456789,'Empresa s.a');
/*!40000 ALTER TABLE `empresas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `guias`
--

DROP TABLE IF EXISTS `guias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `guias` (
  `numeroGuia` int(11) NOT NULL AUTO_INCREMENT,
  `detalleMercancia` varchar(45) NOT NULL,
  `planillas_idPlanilla` int(11) NOT NULL,
  PRIMARY KEY (`numeroGuia`),
  KEY `fk_guia_planillas1_idx` (`planillas_idPlanilla`),
  CONSTRAINT `fk_guia_planillas1` FOREIGN KEY (`planillas_idPlanilla`) REFERENCES `planillas` (`idPlanilla`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=105 DEFAULT CHARSET=utf8 COMMENT='Esta tabla permite registrar las guias con las que se documenta la mercancia.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `guias`
--

LOCK TABLES `guias` WRITE;
/*!40000 ALTER TABLE `guias` DISABLE KEYS */;
INSERT INTO `guias` VALUES (101,'papel',1),(102,'televisor 42 p',1),(103,'computador Intel core',2),(104,'computador Intel core',1);
/*!40000 ALTER TABLE `guias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `localidades`
--

DROP TABLE IF EXISTS `localidades`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `localidades` (
  `idLocalidad` int(11) NOT NULL AUTO_INCREMENT,
  `nombreLocalidad` varchar(45) NOT NULL,
  `ciudades_idCiudades` int(11) NOT NULL,
  PRIMARY KEY (`idLocalidad`),
  KEY `fk_localidades_ciudades1_idx` (`ciudades_idCiudades`),
  CONSTRAINT `fk_localidades_ciudades1` FOREIGN KEY (`ciudades_idCiudades`) REFERENCES `ciudades` (`idCiudades`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='Esta tabla permite el registro de las localidades donde se zonifica la mercancia.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `localidades`
--

LOCK TABLES `localidades` WRITE;
/*!40000 ALTER TABLE `localidades` DISABLE KEYS */;
INSERT INTO `localidades` VALUES (1,'chapinero',1),(2,'bosa',1);
/*!40000 ALTER TABLE `localidades` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `marcas`
--

DROP TABLE IF EXISTS `marcas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `marcas` (
  `idMarca` int(11) NOT NULL,
  `marca` varchar(45) NOT NULL,
  PRIMARY KEY (`idMarca`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `marcas`
--

LOCK TABLES `marcas` WRITE;
/*!40000 ALTER TABLE `marcas` DISABLE KEYS */;
INSERT INTO `marcas` VALUES (1,'ford');
/*!40000 ALTER TABLE `marcas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mercancias`
--

DROP TABLE IF EXISTS `mercancias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mercancias` (
  `idMercancia` int(11) NOT NULL AUTO_INCREMENT,
  `tipoMercancia` varchar(20) NOT NULL,
  `descripcionMercancia` varchar(45) DEFAULT NULL,
  `peso` double DEFAULT NULL,
  `longitud` double NOT NULL,
  `ancho` double NOT NULL,
  `altura` double NOT NULL,
  `volumen` double NOT NULL,
  `cantidad` int(11) NOT NULL,
  `embalaje` varchar(30) DEFAULT NULL,
  `estadoMercancia` varchar(45) NOT NULL,
  `guias_numeroGuia` int(11) NOT NULL,
  `solicitudes_idSolicitud` int(11) NOT NULL,
  `vehiculos_idVehiculo` int(11) NOT NULL,
  `precios_idprecios` int(11) NOT NULL,
  PRIMARY KEY (`idMercancia`),
  KEY `fk_mercancias_solicitudes1_idx` (`solicitudes_idSolicitud`),
  KEY `fk_mercancias_vehiculos1_idx` (`vehiculos_idVehiculo`),
  KEY `fk_mercancias_precios1_idx` (`precios_idprecios`),
  KEY `fk_mercancias_guias1_idx` (`guias_numeroGuia`),
  CONSTRAINT `fk_mercancias_guias1` FOREIGN KEY (`guias_numeroGuia`) REFERENCES `guias` (`numeroGuia`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_mercancias_precios1` FOREIGN KEY (`precios_idprecios`) REFERENCES `precios` (`idprecios`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_mercancias_solicitudes1` FOREIGN KEY (`solicitudes_idSolicitud`) REFERENCES `solicitudes` (`idSolicitud`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_mercancias_vehiculos1` FOREIGN KEY (`vehiculos_idVehiculo`) REFERENCES `vehiculos` (`idVehiculo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='Esta tabla permite el registro de toda la mercancia a entregar';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mercancias`
--

LOCK TABLES `mercancias` WRITE;
/*!40000 ALTER TABLE `mercancias` DISABLE KEYS */;
INSERT INTO `mercancias` VALUES (1,'televisor','42 p',1,28,24,14,9408,1,'caja','Regular',102,1,1,1),(2,'computador','Intel core',1,41,44,28,50512,2,'caja','Regular',104,3,1,1);
/*!40000 ALTER TABLE `mercancias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `modelos`
--

DROP TABLE IF EXISTS `modelos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `modelos` (
  `idModelo` varchar(45) NOT NULL,
  `modelo` varchar(50) NOT NULL,
  `year` varchar(4) NOT NULL,
  `marcas_idMarca` int(11) NOT NULL,
  PRIMARY KEY (`idModelo`),
  UNIQUE KEY `modelo_UNIQUE` (`modelo`),
  KEY `fk_modelos_marcas1_idx` (`marcas_idMarca`),
  CONSTRAINT `fk_modelos_marcas1` FOREIGN KEY (`marcas_idMarca`) REFERENCES `marcas` (`idMarca`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `modelos`
--

LOCK TABLES `modelos` WRITE;
/*!40000 ALTER TABLE `modelos` DISABLE KEYS */;
/*!40000 ALTER TABLE `modelos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `novedades`
--

DROP TABLE IF EXISTS `novedades`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `novedades` (
  `idMercancia` int(11) NOT NULL,
  `tipoNovedad` varchar(20) NOT NULL,
  `detalle` varchar(40) NOT NULL,
  `prioridad` varchar(45) NOT NULL,
  `descripcion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idMercancia`),
  UNIQUE KEY `idMercancia_UNIQUE` (`idMercancia`),
  KEY `fk_novedades_mercancias1_idx` (`idMercancia`),
  CONSTRAINT `fk_novedades_mercancias1` FOREIGN KEY (`idMercancia`) REFERENCES `mercancias` (`idMercancia`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Esta tabla permite el registro de las novedades que presenta la mercancia en caso de no ser entregadas';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `novedades`
--

LOCK TABLES `novedades` WRITE;
/*!40000 ALTER TABLE `novedades` DISABLE KEYS */;
/*!40000 ALTER TABLE `novedades` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `permisos`
--

DROP TABLE IF EXISTS `permisos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `permisos` (
  `idPermisos` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(40) NOT NULL,
  `url` varchar(40) NOT NULL,
  `icon` varchar(45) DEFAULT NULL,
  `permiso_padre` int(11) DEFAULT NULL,
  PRIMARY KEY (`idPermisos`),
  KEY `fk_permisos_permisos1_idx` (`permiso_padre`),
  CONSTRAINT `fk_permisos_permisos1` FOREIGN KEY (`permiso_padre`) REFERENCES `permisos` (`idPermisos`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8 COMMENT='En esta tabla se registran los permisos de a los que accederan y que tendra cada usuario';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `permisos`
--

LOCK TABLES `permisos` WRITE;
/*!40000 ALTER TABLE `permisos` DISABLE KEYS */;
INSERT INTO `permisos` VALUES (1,'Diagramas','',NULL,NULL),(2,'Reportes','',NULL,NULL),(11,'Inicio','',NULL,NULL),(12,'Listar ciudad','app/crud/ciudad/List.xhtml',NULL,2),(21,'Listar conductor','app/crud/conductor/List.xhtml',NULL,2),(22,'Listar departamento','app/crud/departamento/List.xhtml',NULL,2),(23,'Listar empresa','app/crud/empresa/List.xhtml',NULL,2),(24,'Listar guia','app/crud/guia/List.xhtml',NULL,2),(25,'Listar localidad','app/crud/localidad/List.xhtml',NULL,2),(26,'Listar mercancia','app/crud/mercancia/List.xhtml',NULL,2),(27,'Listar novedad','app/crud/novedad/List.xhtml',NULL,2),(28,'Listar planilla','app/crud/planilla/List.xhtml',NULL,2),(29,'Listar solicitud','app/crud/solicitud/List.xhtml',NULL,2),(30,'Listar usuario','app/crud/usuario/List.xhtml',NULL,2),(31,'Listar vehiculo','app/crud/vehiculo/List.xhtml',NULL,2),(32,'Añadir Novedad','app/operador/añadirnovedad.xhml',NULL,44),(33,'Consultar mercancia','app/operador/consultarmercancia.xhml',NULL,48),(34,'Detalle de Guía','app/operador/detalledeguia.xhml',NULL,45),(35,'Generar guía','app/operador/generarguia.xhml',NULL,45),(36,'Mercancía del vehículo','app/operador/mercanciadelvehiculo.xhml',NULL,47),(37,'Planillas','app/operador/planillas.xhml',NULL,46),(38,'Registrar vehículo','app/operador/registrarvehiculo.xhml',NULL,47),(39,'Consultar mercancia','app/recepcion/consultmercancia.xhtml',NULL,43),(40,'Cotizar Mercancia','app/recepcion/cotizarmercancia.xhtml',NULL,43),(42,'Registrar solicitud','app/recepcion/registarsolicitud.xhtml',NULL,43),(43,'Mercancia','',NULL,NULL),(44,'Novedad','',NULL,NULL),(45,'Guia','',NULL,NULL),(46,'Planilla','',NULL,NULL),(47,'Vehiculo','',NULL,NULL),(48,'Mercancias','',NULL,NULL);
/*!40000 ALTER TABLE `permisos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `planillas`
--

DROP TABLE IF EXISTS `planillas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `planillas` (
  `idPlanilla` int(11) NOT NULL AUTO_INCREMENT,
  `cantidadGuias` int(11) NOT NULL,
  PRIMARY KEY (`idPlanilla`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='En esta tabla se registran las planillas o registros de toda la mercancia que es cargada en un vehiculo';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `planillas`
--

LOCK TABLES `planillas` WRITE;
/*!40000 ALTER TABLE `planillas` DISABLE KEYS */;
INSERT INTO `planillas` VALUES (1,3),(2,3);
/*!40000 ALTER TABLE `planillas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `precios`
--

DROP TABLE IF EXISTS `precios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `precios` (
  `idprecios` int(11) NOT NULL AUTO_INCREMENT,
  `valor` double NOT NULL,
  PRIMARY KEY (`idprecios`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `precios`
--

LOCK TABLES `precios` WRITE;
/*!40000 ALTER TABLE `precios` DISABLE KEYS */;
INSERT INTO `precios` VALUES (1,3750),(2,5200),(3,8500),(4,9950),(5,15000),(6,20000),(7,32400),(8,40100),(9,43200),(10,50000),(11,55000),(12,60000),(13,72000),(14,83500),(15,92400),(16,102340),(17,140000),(18,153000),(19,185000),(20,205300);
/*!40000 ALTER TABLE `precios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `roles` (
  `identificadorRol` int(11) NOT NULL AUTO_INCREMENT,
  `nombreRol` varchar(20) NOT NULL,
  `detalleRol` varchar(45) NOT NULL,
  PRIMARY KEY (`identificadorRol`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='En esta tabla se registran los roles que puede seleccionar o elegir un usuario.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,'cliente',''),(2,'administrador',''),(3,'operador',''),(4,'recepcionista','');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles_has_permisos`
--

DROP TABLE IF EXISTS `roles_has_permisos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `roles_has_permisos` (
  `roles_identificadorRol` int(11) NOT NULL,
  `permisos_idPermisos` int(11) NOT NULL,
  PRIMARY KEY (`roles_identificadorRol`,`permisos_idPermisos`),
  KEY `fk_roles_has_permisos_permisos1_idx` (`permisos_idPermisos`),
  KEY `fk_roles_has_permisos_roles1_idx` (`roles_identificadorRol`),
  CONSTRAINT `fk_roles_has_permisos_permisos1` FOREIGN KEY (`permisos_idPermisos`) REFERENCES `permisos` (`idPermisos`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_roles_has_permisos_roles1` FOREIGN KEY (`roles_identificadorRol`) REFERENCES `roles` (`identificadorRol`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles_has_permisos`
--

LOCK TABLES `roles_has_permisos` WRITE;
/*!40000 ALTER TABLE `roles_has_permisos` DISABLE KEYS */;
INSERT INTO `roles_has_permisos` VALUES (2,1),(2,2),(2,11),(2,12),(2,21),(2,22),(2,23),(2,24),(2,25),(2,26),(2,27),(2,28),(2,29),(2,30),(2,31),(3,32),(3,33),(3,34),(3,35),(3,36),(3,37),(3,38),(3,44),(3,45),(3,46),(3,47),(3,48),(4,39),(4,40),(4,42),(4,43);
/*!40000 ALTER TABLE `roles_has_permisos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rutas`
--

DROP TABLE IF EXISTS `rutas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rutas` (
  `idRutas` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `planillas_idPlanilla` int(11) NOT NULL,
  `vehiculos_idVehiculo` int(11) NOT NULL,
  PRIMARY KEY (`idRutas`),
  KEY `fk_rutas_planillas1_idx` (`planillas_idPlanilla`),
  KEY `fk_rutas_vehiculos1_idx` (`vehiculos_idVehiculo`),
  CONSTRAINT `fk_rutas_planillas1` FOREIGN KEY (`planillas_idPlanilla`) REFERENCES `planillas` (`idPlanilla`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_rutas_vehiculos1` FOREIGN KEY (`vehiculos_idVehiculo`) REFERENCES `vehiculos` (`idVehiculo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rutas`
--

LOCK TABLES `rutas` WRITE;
/*!40000 ALTER TABLE `rutas` DISABLE KEYS */;
INSERT INTO `rutas` VALUES (1,'chapinero',1,1),(2,'bosa',2,2);
/*!40000 ALTER TABLE `rutas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `solicitudes`
--

DROP TABLE IF EXISTS `solicitudes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `solicitudes` (
  `idSolicitud` int(11) NOT NULL AUTO_INCREMENT,
  `tipoServicio` varchar(20) NOT NULL,
  `direccionOrigen` varchar(50) NOT NULL,
  `direccionDestino` varchar(50) NOT NULL,
  `nombreDestinatario` varchar(20) NOT NULL,
  `apellidoDestinatario` varchar(20) NOT NULL,
  `telefonoDestinatario` varchar(15) NOT NULL,
  `priorizacion` varchar(20) DEFAULT NULL,
  `fechaSolicitud` date DEFAULT NULL,
  `hora` varchar(45) NOT NULL,
  `fechaRecoleccion` date NOT NULL,
  `estadoSolicitud` varchar(20) NOT NULL,
  `usuarios_documento` bigint(15) NOT NULL,
  `localidades_idLocalidad` int(11) NOT NULL,
  PRIMARY KEY (`idSolicitud`),
  KEY `fk_solicitudes_usuarios1_idx` (`usuarios_documento`),
  KEY `fk_solicitudes_localidades1_idx` (`localidades_idLocalidad`),
  CONSTRAINT `fk_solicitudes_localidades1` FOREIGN KEY (`localidades_idLocalidad`) REFERENCES `localidades` (`idLocalidad`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_solicitudes_usuarios1` FOREIGN KEY (`usuarios_documento`) REFERENCES `usuarios` (`documento`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='En esta tabla se registraran las solicitudes que los usuarios o empresas diligencien.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `solicitudes`
--

LOCK TABLES `solicitudes` WRITE;
/*!40000 ALTER TABLE `solicitudes` DISABLE KEYS */;
INSERT INTO `solicitudes` VALUES (1,'Mensajeria expresa','car 12.B bis . #12..-12.','car 2.. . #3..-2.','juan','camilo','621122','alta','2017-06-22','08:11:49','2017-06-22','Sin recoger',12312312,1),(2,'Mensajeria masiva','car 12.B bis . #12..-12.','car 2.. . #3..-2.','daniel','perez','11111','baja','2017-06-22','08:16:32','2017-06-24','Sin recoger',12312312,2),(3,'Mercancia terrestre','car 12.B bis . #12..-12.','car 2.. . #3..-2.','daniel','perez','2222','baja','2017-06-22','08:17:59','2017-06-25','Sin recoger',12312312,1);
/*!40000 ALTER TABLE `solicitudes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuarios` (
  `documento` bigint(15) NOT NULL COMMENT '\n\n\n',
  `tipoIdentificacion` varchar(10) NOT NULL,
  `primerNombre` varchar(45) NOT NULL,
  `segundoNombre` varchar(45) DEFAULT NULL,
  `primerApellido` varchar(45) NOT NULL,
  `segundoApellido` varchar(45) DEFAULT NULL,
  `telefono` varchar(15) DEFAULT NULL,
  `celular` varchar(15) NOT NULL,
  `email` varchar(45) NOT NULL,
  `clave` varchar(20) NOT NULL,
  `estado` int(11) DEFAULT NULL,
  PRIMARY KEY (`documento`),
  UNIQUE KEY `documento_UNIQUE` (`documento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Esta tabla permite el registro de usuarios como el cliente, administrador,operador y funcionario.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (123123,'CC','daniel','camilo','salazar','perez','325246','46246246','da@gmail.com','54321',1),(12312312,'CC','juan ','camilo','peña','neita','123312413','3413413413','juancamilo@gmail.com','1234',1),(42462462,'CC','nick','andersson','fontecha','salazar','134134','525245245','nick@gmail.com','98765',1),(123312121,'CC','ivan','andres','venegas','avellaneda','12124','4134134444','ivan@gmail.com',' ',1),(123456789,'empresa','empresa',NULL,'empresa',NULL,NULL,'302147864','empresa@gmail.com','aple',1);
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios_has_roles`
--

DROP TABLE IF EXISTS `usuarios_has_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuarios_has_roles` (
  `usuarios_documento` bigint(15) NOT NULL,
  `roles_identificadorRol` int(11) NOT NULL,
  PRIMARY KEY (`usuarios_documento`,`roles_identificadorRol`),
  KEY `fk_usuarios_has_roles_roles1_idx` (`roles_identificadorRol`),
  KEY `fk_usuarios_has_roles_usuarios1_idx` (`usuarios_documento`),
  CONSTRAINT `fk_usuarios_has_roles_roles1` FOREIGN KEY (`roles_identificadorRol`) REFERENCES `roles` (`identificadorRol`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_usuarios_has_roles_usuarios1` FOREIGN KEY (`usuarios_documento`) REFERENCES `usuarios` (`documento`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios_has_roles`
--

LOCK TABLES `usuarios_has_roles` WRITE;
/*!40000 ALTER TABLE `usuarios_has_roles` DISABLE KEYS */;
INSERT INTO `usuarios_has_roles` VALUES (123123,3),(12312312,1),(42462462,4),(123312121,2),(123456789,1);
/*!40000 ALTER TABLE `usuarios_has_roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vehiculos`
--

DROP TABLE IF EXISTS `vehiculos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vehiculos` (
  `idVehiculo` int(11) NOT NULL AUTO_INCREMENT,
  `placaVehiculo` varchar(6) NOT NULL,
  `tipoVehiculo` varchar(40) NOT NULL,
  `capacidadCarga` varchar(30) NOT NULL,
  `marcas_idMarca` int(11) NOT NULL,
  PRIMARY KEY (`idVehiculo`),
  KEY `fk_vehiculos_marcas1_idx` (`marcas_idMarca`),
  CONSTRAINT `fk_vehiculos_marcas1` FOREIGN KEY (`marcas_idMarca`) REFERENCES `marcas` (`idMarca`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='Esta tabla permite registrar todos los vehiculos de las diferentes rutas.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vehiculos`
--

LOCK TABLES `vehiculos` WRITE;
/*!40000 ALTER TABLE `vehiculos` DISABLE KEYS */;
INSERT INTO `vehiculos` VALUES (1,'qwe123','Camion dos ejes','2 toneladas',1);
/*!40000 ALTER TABLE `vehiculos` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-06-22  8:23:14
