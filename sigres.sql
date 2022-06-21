-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         5.7.33 - MySQL Community Server (GPL)
-- SO del servidor:              Win64
-- HeidiSQL Versión:             11.2.0.6213
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Volcando estructura de base de datos para movil1
CREATE DATABASE IF NOT EXISTS `movil1` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_spanish2_ci */;
USE `movil1`;

-- Volcando estructura para tabla movil1.cargos
CREATE TABLE IF NOT EXISTS `cargos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) COLLATE utf8_spanish2_ci NOT NULL,
  `descripcion` text COLLATE utf8_spanish2_ci,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

-- Volcando datos para la tabla movil1.cargos: ~16 rows (aproximadamente)
/*!40000 ALTER TABLE `cargos` DISABLE KEYS */;
INSERT INTO `cargos` (`id`, `nombre`, `descripcion`) VALUES
	(1, 'VendedorEditado', ''),
	(2, 'Cajero', NULL),
	(3, 'Gerente', NULL),
	(4, 'Conserje', NULL),
	(5, 'Seguridad', NULL),
	(6, 'Jefe de Planta', NULL),
	(7, 'Supervisor', NULL),
	(8, 'Atencion al Cliente', NULL),
	(9, 'Administrador', ''),
	(10, 'cargo', 'carho'),
	(11, 'Javier', NULL),
	(12, 'Javier', NULL),
	(13, 'CargoTe', 'Test'),
	(14, 'Javier', 'Test 1'),
	(15, 'test', 'test'),
	(16, 'test', 'test'),
	(17, 'Test2', 'test'),
	(18, 'test', 'test');
/*!40000 ALTER TABLE `cargos` ENABLE KEYS */;

-- Volcando estructura para tabla movil1.empleados
CREATE TABLE IF NOT EXISTS `empleados` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `identidad` varchar(15) COLLATE utf8_spanish2_ci NOT NULL,
  `nombre` varchar(50) COLLATE utf8_spanish2_ci NOT NULL,
  `apellido` varchar(50) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `cargo_id` int(11) DEFAULT NULL,
  `fechaingreso` date DEFAULT NULL,
  `salario` double DEFAULT NULL,
  `imagen` varchar(250) COLLATE utf8_spanish2_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `CargoEmpleado` (`cargo_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

-- Volcando datos para la tabla movil1.empleados: ~8 rows (aproximadamente)
/*!40000 ALTER TABLE `empleados` DISABLE KEYS */;
INSERT INTO `empleados` (`id`, `identidad`, `nombre`, `apellido`, `cargo_id`, `fechaingreso`, `salario`, `imagen`) VALUES
	(1, '12345678', 'Raul', 'Castejon', 2, '2022-05-30', 7000, 'img-1655167386699-835113187image.jpeg'),
	(3, '12345678', 'Test', 'test', 1, NULL, 4000, ''),
	(4, '0401200100483', 'Javier', 'Tabora', NULL, '2022-06-16', 1000, ''),
	(5, '0401200100483', 'Elvis', 'Alfaro', NULL, '2022-06-16', 1000, ''),
	(6, '0401200100483', 'Elvis', 'Alfaro', NULL, '2022-06-16', 1000, ''),
	(7, '0401200100483', 'Elvis', 'Alfaro', NULL, '2022-06-16', 1000, ''),
	(8, '0401200100483', 'Javier', 'Tabora', 1, '2022-06-16', 1000, ''),
	(9, '0401200100483', 'Claudia', 'Castejon', 1, '2022-06-16', 1000, ''),
	(10, '0401200100483', 'Javier', 'Tabora', 1, '2022-06-16', 1000, ''),
	(11, '0401200100483', 'Javier', 'Tabora', 1, '2022-06-16', 1000, '');
/*!40000 ALTER TABLE `empleados` ENABLE KEYS */;

-- Volcando estructura para tabla movil1.usuarios
CREATE TABLE IF NOT EXISTS `usuarios` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `LoginUsuario` varchar(50) COLLATE utf8_spanish2_ci NOT NULL,
  `empleado` int(11) NOT NULL,
  `contrasena` varchar(250) COLLATE utf8_spanish2_ci NOT NULL,
  `AccesoTotal` tinyint(4) DEFAULT NULL,
  `Habilitado` tinyint(4) DEFAULT NULL,
  `pin` varchar(4) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `fallidos` int(11) DEFAULT NULL,
  `correo` varchar(250) COLLATE utf8_spanish2_ci NOT NULL,
  `estado` enum('BL','AC','IN') COLLATE utf8_spanish2_ci NOT NULL DEFAULT 'AC',
  PRIMARY KEY (`id`),
  UNIQUE KEY `correo` (`correo`),
  UNIQUE KEY `LoginUsuario` (`LoginUsuario`),
  UNIQUE KEY `empleado` (`empleado`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

-- Volcando datos para la tabla movil1.usuarios: ~4 rows (aproximadamente)
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` (`id`, `LoginUsuario`, `empleado`, `contrasena`, `AccesoTotal`, `Habilitado`, `pin`, `fallidos`, `correo`, `estado`) VALUES
	(1, 'Test', 1, '$2b$10$cmtX7GH2ErKFgvlTNRwMo.GFNWO5oSggnz8dm.j7cKGyy4duSYkNe', NULL, NULL, '9718', 1, 'javiertaboracastejon@gmail.com', 'AC'),
	(2, 'test2', 3, '$2b$10$IEgHXMj3YTbIDv2Up5DwfOnkFPAoFEuBWC9ozhXgDNER4F1G4Tw8S', 1, NULL, NULL, NULL, 'te@c.com', 'AC'),
	(3, 'test3', 4, '$2b$10$Fg6izRNkIeIPq0VvzecVw.dgTZclnd3dt2eEO9Wpq9w6TQ9fDdz2G', 1, NULL, '1111', 1, 'te3@c.com', 'AC'),
	(4, 'test5', 2, '$2b$10$E7ZsqnDOXc67npRm2Hi4n.J.3MSOejjdnQlYWAj1.7mQtnD1d.6ei', 1, 0, '111', 1, 'te5@c.com', 'AC');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
