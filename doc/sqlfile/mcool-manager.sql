/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 80011
 Source Host           : localhost:3306
 Source Schema         : mcool-manager

 Target Server Type    : MySQL
 Target Server Version : 80011
 File Encoding         : 65001

 Date: 28/01/2020 17:29:00
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for manager
-- ----------------------------
DROP TABLE IF EXISTS `manager`;
CREATE TABLE `manager` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `ManagerID` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `ManagerName` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `ManagerPower` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `ManagerPosition` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `ManagerSexuality` varchar(1) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `AccountPassword` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `EmailAddress` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of manager
-- ----------------------------
INSERT INTO `manager` VALUES ('001', 'Eric', NULL, NULL, 'M', '112233', 'ericzya@outlook.com');

SET FOREIGN_KEY_CHECKS = 1;
