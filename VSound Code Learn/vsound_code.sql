/*
Navicat MySQL Data Transfer

Source Server         : ll
Source Server Version : 50643
Source Host           : 127.0.0.1:3306
Source Database       : vsound_code

Target Server Type    : MYSQL
Target Server Version : 50643
File Encoding         : 65001

Date: 2019-08-15 21:51:53
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user_base
-- ----------------------------
DROP TABLE IF EXISTS `user_base`;
CREATE TABLE `user_base` (
  `id` int(11) NOT NULL,
  `user_id` varchar(255) COLLATE utf8_bin NOT NULL,
  `user_account` varchar(255) COLLATE utf8_bin NOT NULL,
  `user_password` varchar(255) COLLATE utf8_bin NOT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='用户登录信息\r\n';

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `id` int(11) NOT NULL,
  `user_id` varchar(255) COLLATE utf8_bin NOT NULL COMMENT '用户id',
  `user_name` varchar(255) COLLATE utf8_bin NOT NULL COMMENT '用户名称',
  `user_avatar` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '用户头像',
  `create_user_id` varchar(255) CHARACTER SET utf8 NOT NULL COMMENT '创建人id',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='用户基础信息';
