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

 Date: 26/07/2020 18:15:22
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for paybill_paylog
-- ----------------------------
DROP TABLE IF EXISTS `paybill_paylog`;
CREATE TABLE `paybill_paylog`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(30) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `money` int(11) NOT NULL,
  `dps` int(11) NOT NULL,
  `paytime` date NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;
