/*
 Navicat Premium Data Transfer

 Source Server         : 本地数据库
 Source Server Type    : MySQL
 Source Server Version : 80029
 Source Host           : localhost:3306
 Source Schema         : chiralium

 Target Server Type    : MySQL
 Target Server Version : 80029
 File Encoding         : 65001

 Date: 05/07/2022 10:20:32
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sms_record
-- ----------------------------
DROP TABLE IF EXISTS `sms_record`;
CREATE TABLE `sms_record`  (
                               `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
                               `template_id` bigint NULL DEFAULT NULL COMMENT '模板id',
                               `phone_number` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '手机号',
                               `serial_no` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '批次号',
                               `request_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '请求id',
                               `charging_num` int NULL DEFAULT NULL COMMENT '计费条数',
                               `sms_content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '短信内容',
                               `record_message` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '回执信息',
                               `record_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '回执码',
                               `send_status` int NULL DEFAULT NULL COMMENT '发送状态',
                               `send_date` datetime NULL DEFAULT NULL COMMENT '发送时间',
                               `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
                               `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
                               PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sms_record
-- ----------------------------
INSERT INTO `sms_record` VALUES (1, 1290981, '+8617309694133', '2433:59450896716569482642459413', '5a644f00-c6ba-483c-8b62-9b7b7431d2f2', 1, '134679%;%30', 'send success', 'Ok', 30, NULL, '2022-07-04 23:24:24', '2022-07-04 23:24:24');

SET FOREIGN_KEY_CHECKS = 1;
