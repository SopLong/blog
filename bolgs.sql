/*
 Navicat Premium Data Transfer

 Source Server         : myBlogs
 Source Server Type    : MySQL
 Source Server Version : 50721
 Source Host           : localhost:3306
 Source Schema         : bolgs

 Target Server Type    : MySQL
 Target Server Version : 50721
 File Encoding         : 65001

 Date: 20/12/2019 07:27:00
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for article_content
-- ----------------------------
DROP TABLE IF EXISTS `article_content`;
CREATE TABLE `article_content`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '内容',
  `article_id` int(11) NULL DEFAULT NULL COMMENT '文章id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of article_content
-- ----------------------------
INSERT INTO `article_content` VALUES (1, '<p>我的第一篇博客内容</p>', 1);
INSERT INTO `article_content` VALUES (2, '<p>请输入内容...</p>', 2);
INSERT INTO `article_content` VALUES (3, '<p>请输入内容...</p>', 3);
INSERT INTO `article_content` VALUES (4, '<p>请输入内容...333</p>', 4);
INSERT INTO `article_content` VALUES (5, '<p>请输入内容...444</p>', 5);
INSERT INTO `article_content` VALUES (6, '<p>请输入内容...555</p>', 6);
INSERT INTO `article_content` VALUES (7, '<p>请输入内容...sfsdfsdf</p>', 7);
INSERT INTO `article_content` VALUES (8, '<p>请输入内容...asdasdas</p>', 8);
INSERT INTO `article_content` VALUES (9, '<p>请输入内容...奥术大师</p>', 9);
INSERT INTO `article_content` VALUES (10, '<p>请输入内容...</p>', 10);
INSERT INTO `article_content` VALUES (11, '<p>请输入内容...电饭锅电饭锅</p>', 11);
INSERT INTO `article_content` VALUES (12, '<p>请输入内容...水电费水电费</p>', 12);
INSERT INTO `article_content` VALUES (13, '<p>请输入内容...</p>', 13);
INSERT INTO `article_content` VALUES (14, NULL, 14);
INSERT INTO `article_content` VALUES (15, '<p>请输入内容...</p>', 15);

-- ----------------------------
-- Table structure for article_file
-- ----------------------------
DROP TABLE IF EXISTS `article_file`;
CREATE TABLE `article_file`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `article_id` int(11) NULL DEFAULT NULL COMMENT '对应文章id',
  `file_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '附件url',
  `createtime` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updatetime` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for article_info
-- ----------------------------
DROP TABLE IF EXISTS `article_info`;
CREATE TABLE `article_info`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文章标题',
  `summary` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文章简介',
  `is_top` tinyint(1) NULL DEFAULT NULL COMMENT '是否置顶,0为否,1为是',
  `traffic` int(10) NULL DEFAULT NULL COMMENT '文章访问量 ',
  `createtime` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updatetime` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `del_flag` tinyint(1) NULL DEFAULT 0 COMMENT '删除标记',
  `img_url` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图片路径',
  `is_post` int(1) NULL DEFAULT 0 COMMENT '是否发布 【0】未发布 【1】已发布',
  `post_time` datetime(0) NULL DEFAULT NULL COMMENT '发布时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of article_info
-- ----------------------------
INSERT INTO `article_info` VALUES (1, '我的第一遍博客', '我的第一篇博客简介', 1, NULL, '2019-08-19 21:42:55', '2019-08-28 20:18:17', 1, 'https://588ku.com/sheyingtu/4323.html', 0, NULL);
INSERT INTO `article_info` VALUES (2, '标题', '简介', 0, NULL, '2019-08-19 21:47:38', '2019-08-28 20:18:14', 1, 'https://588ku.com/sheyingtu/4323.html', 0, NULL);
INSERT INTO `article_info` VALUES (3, '标题', '简介', 0, NULL, '2019-08-19 21:50:25', '2019-08-28 20:18:17', 1, 'https://588ku.com/sheyingtu/4323.html', 0, NULL);
INSERT INTO `article_info` VALUES (4, '11', '22', 0, NULL, '2019-08-19 22:13:44', '2019-12-02 21:55:33', 0, 'http://img.1ppt.com/uploads/allimg/1901/1_190115152633_1.JPG', 1, NULL);
INSERT INTO `article_info` VALUES (5, '22', '33', 0, NULL, '2019-08-19 22:16:00', '2019-08-28 20:19:58', 0, 'http://img.1ppt.com/uploads/allimg/1901/1_190109165905_1.JPG', 0, NULL);
INSERT INTO `article_info` VALUES (6, '33', '44', 0, NULL, '2019-08-19 22:16:33', '2019-08-28 20:18:17', 1, 'https://588ku.com/sheyingtu/4323.html', 0, NULL);
INSERT INTO `article_info` VALUES (7, 'asd', 'rfsd', 0, NULL, '2019-08-19 22:17:52', '2019-08-28 20:18:17', 1, 'https://588ku.com/sheyingtu/4323.html', 0, NULL);
INSERT INTO `article_info` VALUES (8, 'asdas', 'szxxzc', 0, NULL, '2019-08-19 22:19:07', '2019-08-28 20:18:17', 1, 'https://588ku.com/sheyingtu/4323.html', 0, NULL);
INSERT INTO `article_info` VALUES (9, '阿萨德', '双方都', 0, NULL, '2019-08-19 22:20:54', '2019-08-28 20:18:17', 1, 'https://588ku.com/sheyingtu/4323.html', 0, NULL);
INSERT INTO `article_info` VALUES (10, '所发生的', '是的范德萨', 0, NULL, '2019-08-19 22:21:25', '2019-08-28 20:18:17', 1, 'https://588ku.com/sheyingtu/4323.html', 0, NULL);
INSERT INTO `article_info` VALUES (11, '奥术大师多', '发斯蒂芬斯蒂芬', 0, NULL, '2019-08-19 22:23:27', '2019-08-28 20:18:17', 1, 'https://588ku.com/sheyingtu/4323.html', 0, NULL);
INSERT INTO `article_info` VALUES (12, '胜多负少的', '方师傅的说法', 1, NULL, '2019-08-19 22:26:32', '2019-08-28 20:18:17', 1, 'https://588ku.com/sheyingtu/4323.html', 0, NULL);
INSERT INTO `article_info` VALUES (13, NULL, NULL, 0, NULL, '2019-08-19 22:30:15', '2019-08-28 20:18:17', 1, 'https://588ku.com/sheyingtu/4323.html', 0, NULL);
INSERT INTO `article_info` VALUES (14, NULL, NULL, 0, NULL, '2019-08-19 22:30:23', '2019-08-28 20:18:17', 1, 'https://588ku.com/sheyingtu/4323.html', 0, NULL);
INSERT INTO `article_info` VALUES (15, '1111', '11111', 0, NULL, '2019-08-19 22:30:41', '2019-08-28 20:18:17', 1, 'https://588ku.com/sheyingtu/4323.html', 0, NULL);

-- ----------------------------
-- Table structure for article_message
-- ----------------------------
DROP TABLE IF EXISTS `article_message`;
CREATE TABLE `article_message`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `article_id` int(11) NULL DEFAULT NULL COMMENT '文章ID',
  `message_id` int(11) NULL DEFAULT NULL COMMENT '留言ID',
  `createtime` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `is_effective` tinyint(1) NULL DEFAULT 1 COMMENT '是否有效，默认为1有效，置0无效',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for article_sort
-- ----------------------------
DROP TABLE IF EXISTS `article_sort`;
CREATE TABLE `article_sort`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sort_id` int(11) NULL DEFAULT NULL COMMENT '分类id',
  `article_id` int(11) NULL DEFAULT NULL COMMENT '文章id',
  `createtime` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updatetime` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `is_effective` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '1' COMMENT '表示当前数据是否有效，默认为1有效，0则无效',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for article_tag
-- ----------------------------
DROP TABLE IF EXISTS `article_tag`;
CREATE TABLE `article_tag`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tag_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '标签名称',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_user` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `update_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `update_user` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `del_flag` int(1) NULL DEFAULT 0 COMMENT '删除标记 【0】正常 【1】删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of article_tag
-- ----------------------------
INSERT INTO `article_tag` VALUES (1, 'java', '2019-12-08 20:13:00', NULL, '2019-12-08 20:13:00', NULL, 0);
INSERT INTO `article_tag` VALUES (2, 'jaba', '2019-12-08 21:33:27', NULL, '2019-12-08 21:33:27', NULL, 0);
INSERT INTO `article_tag` VALUES (3, 'java1', '2019-12-11 20:51:10', NULL, '2019-12-11 20:51:10', NULL, 0);

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '留言/评论内容',
  `createtime` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `email` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '评论人名称',
  `ip` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '留言/评论ip',
  `is_effective` tinyint(1) NULL DEFAULT 1 COMMENT '是否有效,默认为1有效,0为无效',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sort_info
-- ----------------------------
DROP TABLE IF EXISTS `sort_info`;
CREATE TABLE `sort_info`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '分类名称',
  `number` tinyint(10) NULL DEFAULT NULL COMMENT '该分类下的文章数量',
  `createtime` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updatetime` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `is_effective` tinyint(1) NULL DEFAULT 1 COMMENT '是否有效,默认为1有效，为0无效',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_code
-- ----------------------------
DROP TABLE IF EXISTS `sys_code`;
CREATE TABLE `sys_code`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '类型编码',
  `type_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '类型名称',
  `item_code` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '字典编码',
  `item_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `del_flag` tinyint(1) NOT NULL DEFAULT 0 COMMENT '删除标记',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_code
-- ----------------------------
INSERT INTO `sys_code` VALUES (1, 'blogType', '博客类型', '1', '基础类', 0);
INSERT INTO `sys_code` VALUES (2, 'blogType', '博客类型', '2', '进阶类', 0);

-- ----------------------------
-- Table structure for sys_logs
-- ----------------------------
DROP TABLE IF EXISTS `sys_logs`;
CREATE TABLE `sys_logs`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `desc` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `exception_detail` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '异常详情',
  `type` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '类型',
  `method` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '方法',
  `params` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '参数',
  `request_ip` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '请求IP',
  `time` bigint(10) NULL DEFAULT NULL COMMENT '请求时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_logs
-- ----------------------------
INSERT INTO `sys_logs` VALUES (1, '新增博客', NULL, 'INFO', 'com.soplong.bolgs.controller.article.ArticleInfoController', '{ articleInfoDto: ArticleInfoDto(content=<p>请输入内容...</p>, articleId=null) }', '0:0:0:0:0:0:0:1', 11);
INSERT INTO `sys_logs` VALUES (2, '新增博客', NULL, 'INFO', 'com.soplong.bolgs.controller.article.ArticleInfoController', '{ articleInfoDto: ArticleInfoDto(content=<p>请输入内容...333</p>, articleId=null) }', '0:0:0:0:0:0:0:1', 19);
INSERT INTO `sys_logs` VALUES (3, '新增博客', NULL, 'INFO', 'com.soplong.bolgs.controller.article.ArticleInfoController', '{ articleInfoDto: ArticleInfoDto(content=<p>请输入内容...444</p>, articleId=null) }', '0:0:0:0:0:0:0:1', 8);
INSERT INTO `sys_logs` VALUES (4, '新增博客', NULL, 'INFO', 'com.soplong.bolgs.controller.article.ArticleInfoController', '{ articleInfoDto: ArticleInfoDto(content=<p>请输入内容...555</p>, articleId=null) }', '0:0:0:0:0:0:0:1', 8);
INSERT INTO `sys_logs` VALUES (5, '新增博客', NULL, 'INFO', 'com.soplong.bolgs.controller.article.ArticleInfoController', '{ articleInfoDto: ArticleInfoDto(content=<p>请输入内容...sfsdfsdf</p>, articleId=null) }', '0:0:0:0:0:0:0:1', 102);
INSERT INTO `sys_logs` VALUES (6, '新增博客', NULL, 'INFO', 'com.soplong.bolgs.controller.article.ArticleInfoController', '{ articleInfoDto: ArticleInfoDto(content=<p>请输入内容...asdasdas</p>, articleId=null) }', '0:0:0:0:0:0:0:1', 39);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '登录名',
  `full_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `createtime` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `is_effective` tinyint(1) NULL DEFAULT 1 COMMENT '是否有效 1有效 0无效',
  `profile` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin', 'SopLong', 'fc1709d0a95a6be30bc5926fdb7f22f4', '2019-07-28 20:40:45', 1, NULL);
INSERT INTO `user` VALUES (2, 'test', '测试', 'fc1709d0a95a6be30bc5926fdb7f22f4', '2019-08-03 12:44:58', 1, NULL);

-- ----------------------------
-- Table structure for work_point_record
-- ----------------------------
DROP TABLE IF EXISTS `work_point_record`;
CREATE TABLE `work_point_record`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date_time` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '时间',
  `all_hours` double(8, 2) NULL DEFAULT NULL COMMENT '总时长',
  `normal_work_hours` double(8, 2) NULL DEFAULT 0.00 COMMENT '正常工作时长',
  `normal_overwork_hours` double(8, 2) NULL DEFAULT 0.00 COMMENT '正常加班时长',
  `weekend_work_hours` double(8, 2) NULL DEFAULT 0.00 COMMENT '周末工作时长',
  `weekend_overwork_hours` double(8, 2) NULL DEFAULT 0.00 COMMENT '周末加班时长',
  `createtime` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updatetime` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `del_flag` tinyint(2) NULL DEFAULT 0 COMMENT '删除标记',
  `is_week` tinyint(1) NULL DEFAULT NULL COMMENT '是否是周末 【0】不是 【1】是',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 87 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of work_point_record
-- ----------------------------
INSERT INTO `work_point_record` VALUES (44, '2019-05-04', 9.50, 0.00, 0.00, 8.00, 1.50, NULL, NULL, 0, 1);
INSERT INTO `work_point_record` VALUES (45, '2019-05-05', 10.00, 0.00, 0.00, 8.00, 2.00, NULL, NULL, 0, 1);
INSERT INTO `work_point_record` VALUES (46, '2019-05-06', 10.00, 8.00, 2.00, 0.00, 0.00, NULL, NULL, 0, 0);
INSERT INTO `work_point_record` VALUES (47, '2019-05-07', 10.00, 8.00, 2.00, 0.00, 0.00, NULL, NULL, 0, 0);
INSERT INTO `work_point_record` VALUES (48, '2019-05-14', 9.50, 8.00, 1.50, 0.00, 0.00, NULL, NULL, 0, 0);
INSERT INTO `work_point_record` VALUES (49, '2019-05-15', 9.50, 8.00, 1.50, 0.00, 0.00, NULL, NULL, 0, 0);
INSERT INTO `work_point_record` VALUES (50, '2019-05-16', 9.50, 8.00, 1.50, 0.00, 0.00, NULL, NULL, 0, 0);
INSERT INTO `work_point_record` VALUES (51, '2019-05-17', 9.50, 8.00, 1.50, 0.00, 0.00, NULL, NULL, 0, 0);
INSERT INTO `work_point_record` VALUES (52, '2019-05-20', 9.00, 8.00, 1.00, 0.00, 0.00, NULL, NULL, 0, 0);
INSERT INTO `work_point_record` VALUES (53, '2019-05-21', 9.00, 8.00, 1.00, 0.00, 0.00, NULL, NULL, 0, 0);
INSERT INTO `work_point_record` VALUES (54, '2019-05-22', 8.50, 8.00, 0.50, 0.00, 0.00, NULL, NULL, 0, 0);
INSERT INTO `work_point_record` VALUES (55, '2019-05-23', 9.00, 8.00, 1.00, 0.00, 0.00, NULL, NULL, 0, 0);
INSERT INTO `work_point_record` VALUES (56, '2019-05-24', 9.00, 8.00, 1.00, 0.00, 0.00, NULL, NULL, 0, 0);
INSERT INTO `work_point_record` VALUES (57, '2019-05-25', 9.50, 0.00, 0.00, 8.00, 1.50, NULL, NULL, 0, 1);
INSERT INTO `work_point_record` VALUES (58, '2019-05-28', 10.00, 8.00, 2.00, 0.00, 0.00, NULL, NULL, 0, 0);
INSERT INTO `work_point_record` VALUES (59, '2019-05-29', 10.00, 8.00, 2.00, 0.00, 0.00, NULL, NULL, 0, 0);
INSERT INTO `work_point_record` VALUES (60, '2019-05-30', 9.50, 8.00, 1.50, 0.00, 0.00, NULL, NULL, 0, 0);
INSERT INTO `work_point_record` VALUES (61, '2019-05-31', 6.00, 6.00, 0.00, 0.00, 0.00, NULL, NULL, 0, 0);
INSERT INTO `work_point_record` VALUES (62, '2019-06-01', 10.00, 0.00, 0.00, 8.00, 2.00, NULL, NULL, 0, 1);
INSERT INTO `work_point_record` VALUES (63, '2019-06-03', 10.00, 8.00, 2.00, 0.00, 0.00, NULL, NULL, 0, 0);
INSERT INTO `work_point_record` VALUES (64, '2019-06-04', 10.00, 8.00, 2.00, 0.00, 0.00, NULL, NULL, 0, 0);
INSERT INTO `work_point_record` VALUES (65, '2019-06-05', 10.00, 8.00, 2.00, 0.00, 0.00, NULL, NULL, 0, 0);
INSERT INTO `work_point_record` VALUES (66, '2019-06-06', 10.00, 8.00, 2.00, 0.00, 0.00, NULL, NULL, 0, 0);
INSERT INTO `work_point_record` VALUES (67, '2019-06-11', 10.00, 8.00, 2.00, 0.00, 0.00, NULL, NULL, 0, 0);
INSERT INTO `work_point_record` VALUES (68, '2019-06-12', 10.00, 8.00, 2.00, 0.00, 0.00, NULL, NULL, 0, 0);
INSERT INTO `work_point_record` VALUES (69, '2019-06-13', 10.00, 8.00, 2.00, 0.00, 0.00, NULL, NULL, 0, 0);
INSERT INTO `work_point_record` VALUES (70, '2019-06-14', 10.00, 8.00, 2.00, 0.00, 0.00, NULL, NULL, 0, 0);
INSERT INTO `work_point_record` VALUES (71, '2019-06-15', 10.00, 0.00, 0.00, 8.00, 2.00, NULL, NULL, 0, 1);
INSERT INTO `work_point_record` VALUES (72, '2019-06-17', 10.50, 8.00, 2.50, 0.00, 0.00, NULL, NULL, 0, 0);
INSERT INTO `work_point_record` VALUES (73, '2019-06-18', 10.50, 8.00, 2.50, 0.00, 0.00, NULL, NULL, 0, 0);
INSERT INTO `work_point_record` VALUES (74, '2019-06-19', 9.50, 8.00, 1.50, 0.00, 0.00, NULL, NULL, 0, 0);
INSERT INTO `work_point_record` VALUES (75, '2019-06-20', 10.00, 8.00, 2.00, 0.00, 0.00, NULL, NULL, 0, 0);
INSERT INTO `work_point_record` VALUES (76, '2019-06-21', 10.50, 8.00, 2.50, 0.00, 0.00, NULL, NULL, 0, 0);
INSERT INTO `work_point_record` VALUES (77, '2019-06-22', 10.00, 0.00, 0.00, 8.00, 2.00, NULL, NULL, 0, 1);
INSERT INTO `work_point_record` VALUES (78, '2019-06-24', 10.00, 8.00, 2.00, 0.00, 0.00, NULL, NULL, 0, 0);
INSERT INTO `work_point_record` VALUES (79, '2019-06-25', 10.00, 8.00, 2.00, 0.00, 0.00, NULL, NULL, 0, 0);
INSERT INTO `work_point_record` VALUES (80, '2019-06-26', 10.00, 8.00, 2.00, 0.00, 0.00, NULL, NULL, 0, 0);
INSERT INTO `work_point_record` VALUES (81, '2019-06-27', 10.00, 8.00, 2.00, 0.00, 0.00, NULL, NULL, 0, 0);
INSERT INTO `work_point_record` VALUES (82, '2019-06-28', 10.00, 8.00, 2.00, 0.00, 0.00, NULL, NULL, 0, 0);
INSERT INTO `work_point_record` VALUES (83, '2019-06-29', 10.00, 0.00, 0.00, 8.00, 2.00, NULL, NULL, 0, 1);
INSERT INTO `work_point_record` VALUES (84, '2019-08-14', 22.00, 8.00, 14.00, 0.00, 0.00, NULL, NULL, 0, 0);
INSERT INTO `work_point_record` VALUES (85, '2019-08-14', 22.00, 8.00, 14.00, 0.00, 0.00, NULL, NULL, 0, 0);
INSERT INTO `work_point_record` VALUES (86, '2019-08-15', 5455.00, 8.00, 5447.00, 0.00, 0.00, NULL, NULL, 0, 0);

SET FOREIGN_KEY_CHECKS = 1;
