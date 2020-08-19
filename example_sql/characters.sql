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

 Date: 26/07/2020 18:06:32
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for characters
-- ----------------------------
DROP TABLE IF EXISTS `characters`;
CREATE TABLE `characters`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `accountid` int(11) NOT NULL DEFAULT 0,
  `world` tinyint(1) NOT NULL DEFAULT 0,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `level` int(3) UNSIGNED NOT NULL DEFAULT 0,
  `exp` int(11) NOT NULL DEFAULT 0,
  `str` int(5) NOT NULL DEFAULT 0,
  `dex` int(5) NOT NULL DEFAULT 0,
  `luk` int(5) NOT NULL DEFAULT 0,
  `int` int(5) NOT NULL DEFAULT 0,
  `hp` int(5) NOT NULL DEFAULT 0,
  `mp` int(5) NOT NULL DEFAULT 0,
  `maxhp` int(5) NOT NULL DEFAULT 0,
  `maxmp` int(5) NOT NULL DEFAULT 0,
  `meso` int(11) NOT NULL DEFAULT 0,
  `hpApUsed` int(5) NOT NULL DEFAULT 0,
  `job` int(5) NOT NULL DEFAULT 0,
  `skincolor` tinyint(1) NOT NULL DEFAULT 0,
  `gender` tinyint(1) NOT NULL DEFAULT 0,
  `fame` int(5) NOT NULL DEFAULT 0,
  `hair` int(11) NOT NULL DEFAULT 0,
  `face` int(11) NOT NULL DEFAULT 0,
  `ap` int(5) NOT NULL DEFAULT 0,
  `map` int(11) NOT NULL DEFAULT 0,
  `spawnpoint` int(3) NOT NULL DEFAULT 0,
  `gm` int(3) NOT NULL DEFAULT 0,
  `party` int(11) NOT NULL DEFAULT 0,
  `buddyCapacity` int(3) NOT NULL DEFAULT 25,
  `createdate` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `guildid` int(10) UNSIGNED NOT NULL DEFAULT 0,
  `guildrank` tinyint(1) UNSIGNED NOT NULL DEFAULT 5,
  `allianceRank` tinyint(1) UNSIGNED NOT NULL DEFAULT 5,
  `monsterbookcover` int(11) UNSIGNED NOT NULL DEFAULT 0,
  `dojo_pts` int(11) UNSIGNED NOT NULL DEFAULT 0,
  `dojoRecord` tinyint(2) UNSIGNED NOT NULL DEFAULT 0,
  `pets` varchar(13) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '-1,-1,-1',
  `sp` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '0,0,0,0,0,0,0,0,0,0',
  `subcategory` int(11) NOT NULL DEFAULT 0,
  `Jaguar` int(3) NOT NULL DEFAULT 0,
  `rank` int(11) NOT NULL DEFAULT 1,
  `rankMove` int(11) NOT NULL DEFAULT 0,
  `jobRank` int(11) NOT NULL DEFAULT 1,
  `jobRankMove` int(11) NOT NULL DEFAULT 0,
  `marriageId` int(11) NOT NULL DEFAULT 0,
  `familyid` int(11) NOT NULL DEFAULT 0,
  `seniorid` int(11) NOT NULL DEFAULT 0,
  `junior1` int(11) NOT NULL DEFAULT 0,
  `junior2` int(11) NOT NULL DEFAULT 0,
  `currentrep` int(11) NOT NULL DEFAULT 0,
  `totalrep` int(11) NOT NULL DEFAULT 0,
  `charmessage` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '安安',
  `expression` int(11) NOT NULL DEFAULT 0,
  `constellation` int(11) NOT NULL DEFAULT 0,
  `blood` int(11) NOT NULL DEFAULT 0,
  `month` int(11) NULL DEFAULT 0,
  `day` int(11) NOT NULL DEFAULT 0,
  `beans` int(11) NOT NULL DEFAULT 0,
  `prefix` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `gachexp` int(11) NOT NULL DEFAULT 0,
  `dps` bigint(20) NOT NULL DEFAULT 0,
  `bingocard` tinytext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `KillMobCount` int(11) NOT NULL,
  PRIMARY KEY (`id`, `int`) USING BTREE,
  INDEX `accountid`(`accountid`) USING BTREE,
  INDEX `party`(`party`) USING BTREE,
  INDEX `ranking1`(`level`, `exp`) USING BTREE,
  INDEX `ranking2`(`gm`, `job`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7461 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;
