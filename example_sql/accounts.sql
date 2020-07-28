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

 Date: 26/07/2020 18:06:15
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for accounts
-- ----------------------------
DROP TABLE IF EXISTS `accounts`;
CREATE TABLE `accounts`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `password` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `salt` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `2ndpassword` varchar(134) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `salt2` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `loggedin` tinyint(1) UNSIGNED NOT NULL DEFAULT 0,
  `lastlogin` timestamp(0) NULL DEFAULT NULL,
  `createdat` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `birthday` date NOT NULL,
  `banned` tinyint(1) NOT NULL DEFAULT 0,
  `banreason` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `gm` tinyint(1) NOT NULL DEFAULT 0,
  `email` tinytext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `macs` tinytext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `tempban` timestamp(0) NOT NULL,
  `greason` tinyint(4) UNSIGNED NULL DEFAULT NULL,
  `ACash` int(11) NULL DEFAULT 0,
  `mPoints` int(11) NULL DEFAULT 0,
  `gender` tinyint(1) UNSIGNED NOT NULL DEFAULT 0,
  `SessionIP` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `points` int(11) NOT NULL DEFAULT 0,
  `vpoints` int(11) NOT NULL DEFAULT 0,
  `lastlogon` timestamp(0) NULL DEFAULT NULL,
  `facebook_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `access_token` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `password_otp` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `expiration` timestamp(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `name`(`name`) USING BTREE,
  INDEX `ranking1`(`id`, `banned`, `gm`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3329 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;
