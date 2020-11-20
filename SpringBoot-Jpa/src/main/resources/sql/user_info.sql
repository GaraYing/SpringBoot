/*
 Navicat Premium Data Transfer

 Source Server         : lcoalhost
 Source Server Type    : MySQL
 Source Server Version : 50724
 Source Host           : localhost:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 50724
 File Encoding         : 65001

 Date: 20/11/2020 14:17:45
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info`  (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '用户名',
  `password` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `usertype` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户类型',
  `enabled` int(2) NOT NULL DEFAULT 1 COMMENT '是否可用',
  `realname` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '真实姓名',
  `qq` varchar(14) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'QQ',
  `email` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `tel` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系电话',
  PRIMARY KEY (`Id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES (1, 'test1', '12345678', '1', 1, 'ds', 'ww@qq.com', 'ssd@qw.com', '4542178464654');
INSERT INTO `user_info` VALUES (2, 'test2', 'aaaa', '2', 1, NULL, NULL, NULL, NULL);
INSERT INTO `user_info` VALUES (3, 'test3', 'bbbb', '1', 1, NULL, NULL, NULL, NULL);
INSERT INTO `user_info` VALUES (4, 'test4', 'cccc', '2', 1, NULL, NULL, NULL, NULL);
INSERT INTO `user_info` VALUES (5, 'test5', 'dddd', '1', 1, NULL, NULL, NULL, NULL);
INSERT INTO `user_info` VALUES (6, 'test6', 'ewew', '1', 1, NULL, NULL, NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
