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

 Date: 26/07/2020 18:15:17
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for paybill_bills
-- ----------------------------
DROP TABLE IF EXISTS `paybill_bills`;
CREATE TABLE `paybill_bills`  (
  `BillID` int(11) NOT NULL AUTO_INCREMENT,
  `money` int(11) NOT NULL,
  `account` char(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `accountID` int(11) NOT NULL,
  `characterID` int(11) NOT NULL,
  `Date` timestamp(0) NOT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  `isSent` tinyint(10) NOT NULL DEFAULT -1,
  `TradeNo` char(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `url` char(30) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  PRIMARY KEY (`BillID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;
