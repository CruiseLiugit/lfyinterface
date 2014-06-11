-- phpMyAdmin SQL Dump
-- version 4.1.4
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: 2014-06-09 22:29:03
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
-- 表的结构 `lfy_store_address`
--

CREATE TABLE IF NOT EXISTS `lfy_store_address` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `store_code` varchar(100) NOT NULL COMMENT '门店编号',
  `store_name` varchar(100) NOT NULL COMMENT '门店名称',
  `manage_type` varchar(100) NOT NULL COMMENT '经营类型',
  `store_type` varchar(100) NOT NULL COMMENT '店铺类型',
  `depart_own` varchar(100) NOT NULL COMMENT '所属部门',
  `area` varchar(100) NOT NULL COMMENT '所属大区',
  `province` varchar(100) NOT NULL COMMENT '省份',
  `city` varchar(100) NOT NULL COMMENT '城市',
  `city_part` varchar(100) NOT NULL COMMENT '城区',
  `city_id` int(10) NOT NULL COMMENT '城市id',
  `store_address` varchar(100) NOT NULL COMMENT '门店地址',
  `store_director` varchar(100) DEFAULT NULL COMMENT '主管姓名',
  `store_directorphone` varchar(100) DEFAULT NULL COMMENT '主管电话',
  `store_assistant` varchar(100) DEFAULT NULL COMMENT '店员姓名',
  `store_assistantphone` varchar(100) DEFAULT NULL COMMENT '店员电话',
  `gps_lng` varchar(100) NOT NULL COMMENT '经度',
  `gps_lat` varchar(100) NOT NULL COMMENT '纬度',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `status` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB;

--
-- 转存表中的数据 `lfy_store_address`
--

INSERT INTO `lfy_store_address` (`id`, `store_code`, `store_name`, `manage_type`, `store_type`, `depart_own`, `area`, `province`, `city`, `city_part`, `city_id`, `store_address`, `store_director`, `store_directorphone`, `store_assistant`, `store_assistantphone`, `gps_lng`, `gps_lat`, `create_date`, `status`) VALUES
(1, '020083', '凯旋路店', '加盟', '商社型', '营运', '华东', '上海市', '上海市', '徐汇区', 4, '上海徐汇区凯旋路1451号', '主管名', '18701756005', '张晨', '18701800787', '121.42744617251', '31.202383576095', '2014-06-09 21:48:59', '1'),
(2, '020079', '罗秀路店', '加盟', '商社型', '营运', '华东', '上海市', '上海市', '徐汇区', 4, '上海徐汇区长桥镇罗秀路258号', '主管名', '64761650', '罗建强', '13817046975', '121.45160839224', '31.139963420445', '2014-06-09 21:51:47', '1'),
(3, '020199', '沧源路店', '加盟', '商社型', '营运', '华东', '上海市', '上海市', '闵行区', 2, '上海市闵行沧源路781号', '主管名', '15800672908', '党闯', '15800672908', '121.43526677773', '31.020861008409', '2014-06-09 21:54:20', '1'),
(4, '020314', '仙霞西路店', '加盟', '商社型', '营运', '华东', '上海市', '上海市', '长宁区', 12, '上海市长宁区仙霞西路87号', '主管名', '13524034382', '吴桂玲', '18217565463', '121.37401123517', '31.213989930474', '2014-06-09 21:57:09', '1'),
(5, '020607', '虹鑫广场', '加盟', '商社型', '营运', '华东', '上海市', '上海市', '长宁区', 12, '上海市长宁区天山路762号', '主管名', '15052820887', '蒋传金', '13321968293', '121.40851227523', '31.217520882513 ', '2014-06-09 21:58:53', '1'),
(6, '020011', '北渔路店', '加盟', '商社型', '营运', '华东', '上海市', '上海市', '长宁区', 12, '上海长宁区北渔路84号', '主管名', '52179100', '马立霞', '13681800544', '121.37919212237', '31.221748538479 ', '2014-06-09 22:00:46', '1'),
(7, '10191', '延长中路2店', '直营', '商社型', '营运', '华东', '上海市', '上海市', '闸北区', 9, '上海市闸北区延长中路453号', '主管名', '18221463733', '王建琴', '15000460869', '121.45848932262', '31.27662116549 ', '2014-06-09 22:04:07', '1'),
(8, '020119', '平型关路店', '加盟', '商社型', '营运', '华东', '上海市', '上海市', '闸北区', 9, '上海闸北平型关路577号', '主管名', '13818518984', '张应增', '13816819797', '121.46783870671', '31.280707117986 ', '2014-06-09 22:07:22', '1');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
