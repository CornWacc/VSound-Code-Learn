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

 Date: 27/08/2019 17:27:47
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for code_base
-- ----------------------------
DROP TABLE IF EXISTS `code_base`;
CREATE TABLE `code_base` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `code_id` varchar(255) COLLATE utf8mb4_bin NOT NULL COMMENT '源码id',
  `code_name` varchar(255) COLLATE utf8mb4_bin NOT NULL COMMENT '源码名称',
  `code_type` varchar(255) COLLATE utf8mb4_bin NOT NULL COMMENT '源码类型',
  `code_level` int(255) NOT NULL COMMENT '源码等级',
  `code_program` varchar(255) COLLATE utf8mb4_bin NOT NULL COMMENT '源码所属框架Id',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='源码内容';

-- ----------------------------
-- Table structure for code_extra
-- ----------------------------
DROP TABLE IF EXISTS `code_extra`;
CREATE TABLE `code_extra` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code_id` varchar(255) COLLATE utf8mb4_bin NOT NULL COMMENT '源码id',
  `use_position` varchar(255) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '适用范围',
  `code_remark` varchar(255) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '简介',
  `code_methods` varchar(9999) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '方法列表',
  `code_parameter` varchar(255) COLLATE utf8mb4_bin DEFAULT '' COMMENT '参数列表',
  `out_side_url` varchar(255) COLLATE utf8mb4_bin DEFAULT '' COMMENT '外链列表',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

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
  `remark` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '简介',
  `gather_class_count` int(255) DEFAULT '0' COMMENT '已收集类数',
  `gather_interface_count` int(255) DEFAULT '0' COMMENT '已收集接口数',
  `create_user_id` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '创建人id',
  `create_user_name` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '创建人名称',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Table structure for user_base
-- ----------------------------
DROP TABLE IF EXISTS `user_base`;
CREATE TABLE `user_base` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(255) COLLATE utf8_bin NOT NULL,
  `user_account` varchar(255) COLLATE utf8_bin NOT NULL,
  `user_password` varchar(255) COLLATE utf8_bin NOT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='用户登录信息\r\n';

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(255) COLLATE utf8_bin NOT NULL COMMENT '用户id',
  `user_name` varchar(255) COLLATE utf8_bin NOT NULL COMMENT '用户名称',
  `user_avatar` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '用户头像',
  `create_user_id` varchar(255) CHARACTER SET utf8 NOT NULL COMMENT '创建人id',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='用户基础信息';

SET FOREIGN_KEY_CHECKS = 1;
