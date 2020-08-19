/*
 Navicat Premium Data Transfer

 Source Server         : NFMSGMSQLMY
 Source Server Type    : MySQL
 Source Server Version : 50730
 Source Host           : localhost:41614
 Source Schema         : twm145

 Target Server Type    : MySQL
 Target Server Version : 50730
 File Encoding         : 65001

 Date: 26/07/2020 18:15:52
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for savedlocations
-- ----------------------------
DROP TABLE IF EXISTS `savedlocations`;
CREATE TABLE `savedlocations`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `characterid` int(11) UNSIGNED NOT NULL,
  `locationtype` int(11) NOT NULL DEFAULT 0,
  `map` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `savedlocations_ibfk_1`(`characterid`) USING BTREE,
  CONSTRAINT `savedlocations_ibfk_1` FOREIGN KEY (`characterid`) REFERENCES `characters` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;
