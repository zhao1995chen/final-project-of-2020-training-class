/*
 Navicat Premium Data Transfer

 Source Server         : NFMSGMSQLMY
 Source Server Type    : MySQL
 Source Server Version : 50730
 Source Host           : localhost:41614
 Source Schema         : twms113

 Target Server Type    : MySQL
 Target Server Version : 50730
 File Encoding         : 65001

 Date: 26/07/2020 18:08:28
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for shops
-- ----------------------------
DROP TABLE IF EXISTS `shops`;
CREATE TABLE `shops`  (
  `shopid` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `npcid` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`shopid`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 1013 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Fixed;

SET FOREIGN_KEY_CHECKS = 1;
