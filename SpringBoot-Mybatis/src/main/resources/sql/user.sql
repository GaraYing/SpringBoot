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

 Date: 02/12/2019 15:34:19
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `nick_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sex` int(1) NULL DEFAULT NULL,
  `register_date` datetime(0) NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 23 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '89921218@qq.com', '1ee04e0b1cb5af7367c80c22e42efd8b', '土豆', 1, '2017-06-23 14:24:23');
INSERT INTO `user` VALUES (2, '2@qq.com', '1ee04e0b1cb5af7367c80c22e42efd8b', '土豆-2', 1, '2017-06-23 14:24:23');
INSERT INTO `user` VALUES (3, '3@qq.com', '1ee04e0b1cb5af7367c80c22e42efd8b', '土豆-3', 1, '2017-06-23 14:24:23');
INSERT INTO `user` VALUES (4, '4@qq.com', '1ee04e0b1cb5af7367c80c22e42efd8b', '土豆-4', 1, '2017-06-23 14:24:23');
INSERT INTO `user` VALUES (5, '5@qq.com', '1ee04e0b1cb5af7367c80c22e42efd8b', '土豆-5', 1, '2017-06-23 14:24:23');
INSERT INTO `user` VALUES (6, '6@qq.com', '1ee04e0b1cb5af7367c80c22e42efd8b', '土豆-6', 1, '2017-06-23 14:24:23');
INSERT INTO `user` VALUES (7, '7@qq.com', '1ee04e0b1cb5af7367c80c22e42efd8b', '土豆-7', 1, '2017-06-23 14:24:23');
INSERT INTO `user` VALUES (8, '8@qq.com', '1ee04e0b1cb5af7367c80c22e42efd8b', '土豆-8', 1, '2017-06-23 14:24:23');
INSERT INTO `user` VALUES (9, '9@qq.com', '1ee04e0b1cb5af7367c80c22e42efd8b', '土豆-9', 1, '2017-06-23 14:24:23');
INSERT INTO `user` VALUES (10, '10@qq.com', '1ee04e0b1cb5af7367c80c22e42efd8b', '土豆-10', 1, '2017-06-23 14:24:23');
INSERT INTO `user` VALUES (11, 'gara', '123456', 'yz', 2, '2018-02-23 00:00:00');
INSERT INTO `user` VALUES (12, 'gara111', '123456', 'yz222', 2, '2019-02-23 00:00:00');
INSERT INTO `user` VALUES (13, 'gara111', '123456', 'yz222', 2, '2019-02-23 00:00:00');
INSERT INTO `user` VALUES (14, 'gara555', '123456', 'yz222', 2, '2019-03-28 11:48:01');
INSERT INTO `user` VALUES (15, 'gara555', '123456', 'yz222', 2, '2019-03-28 11:25:45');
INSERT INTO `user` VALUES (16, 'gara555', '123456', 'yz222', 2, '2019-03-28 11:48:02');
INSERT INTO `user` VALUES (17, 'gara555', '123456', 'yz222', 2, '2019-03-28 11:48:02');
INSERT INTO `user` VALUES (18, 'gara555', '123456', 'yz222', 2, '2019-03-28 11:48:02');
INSERT INTO `user` VALUES (19, 'gara555', '123456', 'yz222', 2, '2019-03-28 11:48:02');
INSERT INTO `user` VALUES (20, 'gara555', '123456', 'yz222', 2, '2019-03-28 11:48:02');
INSERT INTO `user` VALUES (21, 'gara555', '123456', 'yz222', 2, '2019-03-28 11:48:07');
INSERT INTO `user` VALUES (22, 'gara555', '123456', 'yz222', 2, '2019-03-28 11:48:10');

SET FOREIGN_KEY_CHECKS = 1;
