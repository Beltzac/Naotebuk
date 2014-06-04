-- --------------------------------------------------------
-- Servidor:                     127.0.0.1
-- Versão do servidor:           5.5.27 - MySQL Community Server (GPL)
-- OS do Servidor:               Win32
-- HeidiSQL Versão:              8.0.0.4444
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Copiando estrutura do banco de dados para naotebuk
CREATE DATABASE IF NOT EXISTS `naotebuk` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `naotebuk`;


-- Copiando estrutura para tabela naotebuk.cliente
CREATE TABLE IF NOT EXISTS `cliente` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `cpf` varchar(15) DEFAULT NULL,
  `dataNasc` date DEFAULT NULL,
  `sexo` tinyint(1) DEFAULT NULL,
  `rua` varchar(200) DEFAULT NULL,
  `numero` varchar(50) DEFAULT NULL,
  `cep` varchar(10) DEFAULT NULL,
  `cidade` varchar(200) DEFAULT NULL,
  `estado` varchar(200) DEFAULT NULL,
  `email` varchar(200) DEFAULT NULL,
  `nome` varchar(200) DEFAULT NULL,
  `data_criacao` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela naotebuk.cliente: ~3 rows (aproximadamente)
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` (`id`, `cpf`, `dataNasc`, `sexo`, `rua`, `num`, `cep`, `cidade`, `estado`, `email`, `nome`, `data_criacao`) VALUES
	(1, NULL, '2014-05-19', 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(2, '231.231.231-23', NULL, 1, 'asdadasd', NULL, NULL, 'asdasdasd', 'pr', 'asdasdasd@arasfasfasf', 'asdasdasdasd', '2014-05-23'),
	(3, '123.123.123-12', '2008-05-02', 1, 'sadadsadasdas', NULL, NULL, 'sfsdfsdfsdf', 'pr', 'sdfsdfsf@asfsfasfas.com', 'Teste cli', '2014-05-23');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;


-- Copiando estrutura para tabela naotebuk.conserto
CREATE TABLE IF NOT EXISTS `conserto` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `estado_id` int(11) NOT NULL,
  `cliente_id` int(11) NOT NULL,
  `nome` varchar(200) DEFAULT NULL,
  `tipo` tinyint(1) DEFAULT NULL,
  `modelo` varchar(200) DEFAULT NULL,
  `fabricante` varchar(200) DEFAULT NULL,
  `descricao` varchar(10000) DEFAULT NULL,
  `observacao` varchar(10000) DEFAULT NULL,
  `valor` double DEFAULT NULL,
  `previsao` date DEFAULT NULL,
  `data_criacao` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_conserto_estado` (`estado_id`),
  KEY `FK_conserto_cliente` (`cliente_id`),
  CONSTRAINT `FK_conserto_estado` FOREIGN KEY (`estado_id`) REFERENCES `estado` (`id`),
  CONSTRAINT `FK_conserto_cliente` FOREIGN KEY (`cliente_id`) REFERENCES `cliente` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela naotebuk.conserto: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `conserto` DISABLE KEYS */;
INSERT INTO `conserto` (`id`, `estado_id`, `cliente_id`, `nome`, `tipo`, `modelo`, `fabricante`, `descricao`, `observacao`, `valor`, `previsao`, `data_criacao`) VALUES
	(5, 1, 3, 'asdasdasdasd', 1, 'sdasdasd', 'asdasdasdasd', 'asdasdasdsadasd', NULL, 14, '2014-05-10', '2014-05-23');
/*!40000 ALTER TABLE `conserto` ENABLE KEYS */;


-- Copiando estrutura para tabela naotebuk.estado
CREATE TABLE IF NOT EXISTS `estado` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `nome` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela naotebuk.estado: ~5 rows (aproximadamente)
/*!40000 ALTER TABLE `estado` DISABLE KEYS */;
INSERT INTO `estado` (`id`, `nome`) VALUES
	(1, 'Em Aberto'),
	(2, 'Atrasados'),
	(3, 'Prontos'),
	(4, 'Pagos'),
	(5, 'Finalizados');
/*!40000 ALTER TABLE `estado` ENABLE KEYS */;


-- Copiando estrutura para tabela naotebuk.usuario
CREATE TABLE IF NOT EXISTS `usuario` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `nome` varchar(200) DEFAULT NULL,
  `email` varchar(200) DEFAULT NULL,
  `senha` varchar(200) DEFAULT NULL,
  `gerente` tinyint(1) DEFAULT NULL,
  `matricula` varchar(100) DEFAULT NULL,
  `data_criacao` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela naotebuk.usuario: ~3 rows (aproximadamente)
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` (`id`, `nome`, `email`, `senha`, `gerente`, `matricula`, `data_criacao`) VALUES
	(1, 'samuel', 'lol@gmail.com', '4297f44b13955235245b2497399d7a93', 1, NULL, NULL),
	(2, 'zasasdasda', 'asdasdasd@dfsdfsdfsdf', '4297f44b13955235245b2497399d7a93', 0, NULL, '2014-05-23'),
	(3, 'Teste 1', 'teste@gmail.com', '4297f44b13955235245b2497399d7a93', 1, NULL, '2014-05-23');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
