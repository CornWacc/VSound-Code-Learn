/*
 Navicat Premium Data Transfer

 Source Server         : home
 Source Server Type    : MySQL
 Source Server Version : 50725
 Source Host           : localhost:3306
 Source Schema         : vsound_code

 Target Server Type    : MySQL
 Target Server Version : 50725
 File Encoding         : 65001

 Date: 03/01/2020 17:09:38
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for code_base
-- ----------------------------
DROP TABLE IF EXISTS `code_base`;
CREATE TABLE `code_base` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `code_id` varchar(50) COLLATE utf8mb4_bin NOT NULL COMMENT '源码id',
  `code_name` varchar(50) COLLATE utf8mb4_bin NOT NULL COMMENT '源码名称',
  `code_type` varchar(50) COLLATE utf8mb4_bin NOT NULL COMMENT '源码类型',
  `from_project_id` varchar(50) COLLATE utf8mb4_bin DEFAULT '' COMMENT '源码所属框架Id',
  `code_remark` varchar(50) COLLATE utf8mb4_bin DEFAULT '' COMMENT '源码备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='源码内容';

-- ----------------------------
-- Table structure for code_method
-- ----------------------------
DROP TABLE IF EXISTS `code_method`;
CREATE TABLE `code_method` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `method_id` varchar(20) COLLATE utf8mb4_bin NOT NULL COMMENT '方法id',
  `method_name` varchar(20) COLLATE utf8mb4_bin NOT NULL COMMENT '方法名称',
  `method_usage` varchar(60) COLLATE utf8mb4_bin DEFAULT '' COMMENT '方法用法',
  `method_result` varchar(20) COLLATE utf8mb4_bin DEFAULT '无' COMMENT '方法反参',
  `method_base_type` varchar(20) COLLATE utf8mb4_bin NOT NULL DEFAULT 'N' COMMENT '方法基础类型(静态方法，抽象方法)',
  `method_common_use` varchar(20) COLLATE utf8mb4_bin NOT NULL DEFAULT 'Y' COMMENT '方法是否常用',
  `method_is_overwrite` char(1) CHARACTER SET utf8mb4 NOT NULL DEFAULT 'N' COMMENT '方法是否重写',
  `method_is_construct` char(1) CHARACTER SET utf8mb4 NOT NULL DEFAULT 'N' COMMENT '是否为构造方法',
  `method_action_scope` varchar(20) CHARACTER SET utf8mb4 NOT NULL DEFAULT 'PUBLIC' COMMENT '作用域',
  `from_code_id` varchar(30) COLLATE utf8mb4_bin NOT NULL COMMENT '所属源码id',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `methodId` (`method_id`) USING BTREE,
  KEY `codeId` (`from_code_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='源码方法\n';

-- ----------------------------
-- Table structure for code_method_order
-- ----------------------------
DROP TABLE IF EXISTS `code_method_order`;
CREATE TABLE `code_method_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code_method_order_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '方法入参id',
  `code_method_order_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '方法入参名称',
  `code_method_order_class_type` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '方法入参源类型',
  `code_method_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '所属方法id',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='源码方法入参';

-- ----------------------------
-- Table structure for code_out_side_url
-- ----------------------------
DROP TABLE IF EXISTS `code_out_side_url`;
CREATE TABLE `code_out_side_url` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `url_id` varchar(255) COLLATE utf8mb4_bin NOT NULL COMMENT '链接id',
  `url_remark` varchar(255) COLLATE utf8mb4_bin NOT NULL COMMENT '链接注释',
  `url_path` varchar(255) COLLATE utf8mb4_bin NOT NULL COMMENT '链接地址',
  `from_code_id` varchar(255) COLLATE utf8mb4_bin NOT NULL COMMENT '所属源码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='源码外链\n';

-- ----------------------------
-- Table structure for code_parameter
-- ----------------------------
DROP TABLE IF EXISTS `code_parameter`;
CREATE TABLE `code_parameter` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `parameter_id` varchar(255) COLLATE utf8mb4_bin NOT NULL COMMENT '参数id',
  `parameter_name` varchar(255) COLLATE utf8mb4_bin NOT NULL COMMENT '参数名称',
  `parameter_remark` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '参数注释',
  `parameter_type` varchar(255) COLLATE utf8mb4_bin NOT NULL COMMENT '参数类型',
  `is_final` varchar(255) COLLATE utf8mb4_bin NOT NULL COMMENT '是否为常量',
  `is_autowire` varchar(255) COLLATE utf8mb4_bin NOT NULL COMMENT '是否注入',
  `is_interface` varchar(255) COLLATE utf8mb4_bin NOT NULL COMMENT '是否为接口类型',
  `from_code_id` varchar(255) COLLATE utf8mb4_bin NOT NULL COMMENT '所属源码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='源码参数';

-- ----------------------------
-- Table structure for project_base
-- ----------------------------
DROP TABLE IF EXISTS `project_base`;
CREATE TABLE `project_base` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `project_id` varchar(252) COLLATE utf8mb4_bin NOT NULL COMMENT '项目id',
  `project_name` varchar(255) COLLATE utf8mb4_bin NOT NULL COMMENT '项目名称',
  `project_affiliation` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '源码所属框架',
  `project_type` varchar(255) COLLATE utf8mb4_bin NOT NULL COMMENT '项目类型',
  `use_position` varchar(255) COLLATE utf8mb4_bin NOT NULL COMMENT '适用范围',
  `remark` varchar(255) COLLATE utf8mb4_bin DEFAULT '' COMMENT '简介',
  `gather_class_count` int(255) DEFAULT '0' COMMENT '已收集类数',
  `gather_interface_count` int(255) DEFAULT '0' COMMENT '已收集接口数',
  `create_user_id` varchar(255) COLLATE utf8mb4_bin DEFAULT '' COMMENT '创建人id',
  `create_user_name` varchar(255) COLLATE utf8mb4_bin DEFAULT '' COMMENT '创建人名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='项目基础信息';

SET FOREIGN_KEY_CHECKS = 1;
