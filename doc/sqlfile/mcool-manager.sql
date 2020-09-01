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
  `id` int NOT NULL AUTO_INCREMENT,
  `manager_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `manager_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `manager_power` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `manager_position` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `manager_sexuality` varchar(1) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `account_password` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `email_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of manager
-- ----------------------------
INSERT INTO `manager` VALUES (null,'001', 'Eric', NULL, NULL, 'M', '$2a$10$P2kuPC.oCuNnhTjZDFYIteRDgvWzleqnfsxTs9WpXECJYmdrLpuNi', 'ericzya@outlook.com');

SET FOREIGN_KEY_CHECKS = 1;
