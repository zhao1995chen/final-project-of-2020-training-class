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

 Date: 26/07/2020 18:07:54
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for drop_data
-- ----------------------------
DROP TABLE IF EXISTS `drop_data`;
CREATE TABLE `drop_data`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `dropperid` int(11) NOT NULL,
  `itemid` int(11) NOT NULL DEFAULT 0,
  `minimum_quantity` int(11) NOT NULL DEFAULT 1,
  `maximum_quantity` int(11) NOT NULL DEFAULT 1,
  `questid` int(11) NOT NULL DEFAULT 0,
  `chance` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `mobid`(`dropperid`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 200282 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Fixed;

SET FOREIGN_KEY_CHECKS = 1;
