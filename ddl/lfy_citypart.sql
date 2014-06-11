-- phpMyAdmin SQL Dump
-- version 4.1.4
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: 2014-06-10 17:36:50
-- 服务器版本： 5.6.16
-- PHP Version: 5.3.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `shopdb`
--

-- --------------------------------------------------------

--
-- 表的结构 `lfy_citypart`
--

CREATE TABLE IF NOT EXISTS `lfy_citypart` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `address_name` varchar(50) DEFAULT NULL,
  `address_desc` varchar(200) DEFAULT NULL,
  `address_parent` bigint(10) DEFAULT NULL COMMENT '节点父id 顶级为-1',
  `status` varchar(10) DEFAULT NULL COMMENT '状态 1正常 0删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB;

--
-- 转存表中的数据 `lfy_citypart`
--

INSERT INTO `lfy_citypart` (`id`, `address_name`, `address_desc`, `address_parent`, `status`) VALUES
(1, '上海市', '上海', -1, '1'),
(2, '闵行区', '闵行区', 1, '1'),
(3, '浦东新区', '普通新区', 1, '1'),
(4, '徐汇区', '徐汇区', 1, '1'),
(5, '苏州市', '苏州', -1, '1'),
(6, '吴中区', '吴中区', 5, '1'),
(7, '高新区', '高新区', 5, '1'),
(8, '世纪大道', '世纪大道', 3, '1'),
(9, '闸北区', '', 1, '1'),
(10, '常州市', '常州', -1, '1'),
(11, '新北区', '新北区', 10, '1'),
(12, '长宁区', '长宁区', -1, '1');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
