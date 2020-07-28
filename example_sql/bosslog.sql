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

 Date: 26/07/2020 18:12:01
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for bosslog
-- ----------------------------
DROP TABLE IF EXISTS `bosslog`;
CREATE TABLE `bosslog`  (
  `bosslogid` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `characterid` int(10) UNSIGNED NOT NULL,
  `bossid` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `lastattempt` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`bosslogid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 252656 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;
