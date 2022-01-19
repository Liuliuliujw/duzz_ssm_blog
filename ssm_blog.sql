/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80027
 Source Host           : localhost:3306
 Source Schema         : ssm_blog

 Target Server Type    : MySQL
 Target Server Version : 80027
 File Encoding         : 65001

 Date: 19/01/2022 18:02:46
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article`  (
  `article_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '文章ID',
  `article_user_id` int(0) UNSIGNED NULL DEFAULT NULL COMMENT '作者ID',
  `article_title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '标题',
  `article_summary` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '摘要',
  `article_thumbnail` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '缩略图',
  `article_content` mediumtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '内容',
  `article_view_count` int(0) NULL DEFAULT 0 COMMENT '访问量',
  `article_comment_count` int(0) NULL DEFAULT 0 COMMENT '评论数',
  `article_like_count` int(0) NULL DEFAULT 0 COMMENT '点赞数',
  `article_status` int(0) UNSIGNED NULL DEFAULT 1 COMMENT '状态',
  `article_create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `article_update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`article_id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 65 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article` VALUES (56, 1014, '测试文', '文章测试', '/static/img/article/2.jpg', '<h1>文章测试测试测试测试测试</h1>', 2, 2, 2, 1, '2022-01-09 10:38:18', '2022-01-09 10:38:18');
INSERT INTO `article` VALUES (63, 1011, '测试文章2', '测试文章2的摘要', '/static/img/article/test-2.jpg', '<h1>测试文章 222</h1>', 0, 0, 0, 1, '2022-01-09 11:17:21', '2022-01-09 11:17:21');
INSERT INTO `article` VALUES (62, 1011, '测试文章', '测试文章的摘要', '/static/img/article/test-1.jpg', '<h1>测试文章 111</h1>', 0, 0, 0, 1, '2022-01-09 10:52:37', '2022-01-09 10:52:37');
INSERT INTO `article` VALUES (64, 1011, '测试文章3', '测试文章3的摘要', '/static/img/article/test-3.jpg', '<h1>测试文章 333</h1>', 0, 0, 0, 1, '2022-01-09 11:17:41', '2022-01-09 11:17:41');

-- ----------------------------
-- Table structure for article_category_ref
-- ----------------------------
DROP TABLE IF EXISTS `article_category_ref`;
CREATE TABLE `article_category_ref`  (
  `article_id` int(0) NOT NULL COMMENT '文章ID',
  `category_id` int(0) NOT NULL COMMENT '分类ID',
  PRIMARY KEY (`article_id`, `category_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of article_category_ref
-- ----------------------------
INSERT INTO `article_category_ref` VALUES (56, 100000025);
INSERT INTO `article_category_ref` VALUES (56, 100000026);
INSERT INTO `article_category_ref` VALUES (62, 100000025);
INSERT INTO `article_category_ref` VALUES (63, 100000025);
INSERT INTO `article_category_ref` VALUES (64, 100000025);

-- ----------------------------
-- Table structure for article_tag_ref
-- ----------------------------
DROP TABLE IF EXISTS `article_tag_ref`;
CREATE TABLE `article_tag_ref`  (
  `article_id` int(0) NOT NULL COMMENT '文章ID',
  `tag_id` int(0) NOT NULL COMMENT '标签ID',
  PRIMARY KEY (`article_id`, `tag_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of article_tag_ref
-- ----------------------------
INSERT INTO `article_tag_ref` VALUES (56, 64);
INSERT INTO `article_tag_ref` VALUES (56, 65);
INSERT INTO `article_tag_ref` VALUES (56, 66);
INSERT INTO `article_tag_ref` VALUES (62, 64);
INSERT INTO `article_tag_ref` VALUES (62, 66);
INSERT INTO `article_tag_ref` VALUES (63, 64);
INSERT INTO `article_tag_ref` VALUES (63, 66);
INSERT INTO `article_tag_ref` VALUES (64, 64);
INSERT INTO `article_tag_ref` VALUES (64, 66);

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category`  (
  `category_id` int(0) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '分类ID',
  `category_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '分类名称',
  `category_description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`category_id`) USING BTREE,
  UNIQUE INDEX `category_name`(`category_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 100000027 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES (100000025, 'TestCategory', '测试分类');
INSERT INTO `category` VALUES (100000026, 'TestCategory2', '测试分类2');

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `comment_id` int(0) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '评论ID',
  `comment_pid` int(0) UNSIGNED NULL DEFAULT 0 COMMENT '上级评论ID',
  `comment_article_id` int(0) UNSIGNED NOT NULL COMMENT '文章ID',
  `comment_user_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '评论人名称',
  `comment_content` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '内容',
  `comment_create_time` datetime(0) NULL DEFAULT NULL COMMENT '评论时间',
  PRIMARY KEY (`comment_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 44 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES (44, NULL, 56, '1014', '测试评论', '2022-01-09 10:38:19');

-- ----------------------------
-- Table structure for custom_page
-- ----------------------------
DROP TABLE IF EXISTS `custom_page`;
CREATE TABLE `custom_page`  (
  `page_id` int(0) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自定义页面ID',
  `page_key` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'key',
  `page_title` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '标题',
  `page_content` mediumtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '内容',
  `page_create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `page_update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `page_status` int(0) UNSIGNED NULL DEFAULT 1 COMMENT '状态',
  PRIMARY KEY (`page_id`) USING BTREE,
  UNIQUE INDEX `page_key`(`page_key`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of custom_page
-- ----------------------------

-- ----------------------------
-- Table structure for link
-- ----------------------------
DROP TABLE IF EXISTS `link`;
CREATE TABLE `link`  (
  `link_id` int(0) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '链接ID',
  `link_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'URL',
  `link_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `link_description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `link_owner_nickname` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所属人名称',
  `link_owner_contact` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系方式',
  `link_update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `link_create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `link_status` int(0) UNSIGNED NULL DEFAULT 1 COMMENT '状态',
  PRIMARY KEY (`link_id`) USING BTREE,
  UNIQUE INDEX `link_name`(`link_name`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 21 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of link
-- ----------------------------
INSERT INTO `link` VALUES (19, 'http://www.moguit.cn/', '蘑菇社区', '蘑菇博客 - 专注于技术分享的博客平台', '陌溪', 'coder_moxi', NULL, NULL, 1);
INSERT INTO `link` VALUES (20, 'https://mianshiya.com/', '面试鸭', '面试鸭-一个简洁的面试刷题系统', '鱼皮', 'https://github.com/liyupi/', NULL, NULL, 1);

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu`  (
  `menu_id` int(0) NOT NULL AUTO_INCREMENT COMMENT '菜单ID',
  `menu_pid` int(0) NULL DEFAULT NULL COMMENT '上级菜单，根为0',
  `menu_type` int(0) NULL DEFAULT NULL COMMENT '菜单类型',
  `menu_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称',
  `menu_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'URL',
  PRIMARY KEY (`menu_id`) USING BTREE,
  UNIQUE INDEX `menu_name`(`menu_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES (7, 0, 1, '归档', '');
INSERT INTO `menu` VALUES (8, 0, 1, '友链', '/link');
INSERT INTO `menu` VALUES (9, 0, 2, '关于', '');
INSERT INTO `menu` VALUES (10, 9, 2, '关于我', '/aboutMe');
INSERT INTO `menu` VALUES (11, 9, 2, '关于本站', '/about');
INSERT INTO `menu` VALUES (12, 7, 1, '按时间', '/archive/CreateTime');
INSERT INTO `menu` VALUES (13, 7, 1, '按评论数', '/archive/CommentCount');
INSERT INTO `menu` VALUES (14, 7, 1, '按浏览量', '/archive/ViewCount');

-- ----------------------------
-- Table structure for site_option
-- ----------------------------
DROP TABLE IF EXISTS `site_option`;
CREATE TABLE `site_option`  (
  `option_id` int(0) NOT NULL COMMENT 'ID',
  `site_title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '网站标题',
  `site_descrption` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '网站描述',
  `site_keyword` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '网站关键字',
  `site_index_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '网站首页URL',
  `site_icp_num` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '网站ICP备案号',
  PRIMARY KEY (`option_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of site_option
-- ----------------------------
INSERT INTO `site_option` VALUES (123, '杜兹博客', '一个简洁的SSM博客', 'Blog', 'http://localhost:8080/duzz_ssm_blog_war', '暂无');

-- ----------------------------
-- Table structure for tag
-- ----------------------------
DROP TABLE IF EXISTS `tag`;
CREATE TABLE `tag`  (
  `tag_id` int(0) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '标签ID',
  `tag_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '标签名称',
  `tag_description` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`tag_id`) USING BTREE,
  UNIQUE INDEX `tag_name`(`tag_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 67 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tag
-- ----------------------------
INSERT INTO `tag` VALUES (64, 'TestTag', '测试标签');
INSERT INTO `tag` VALUES (65, 'TestTag2', '测试标签2');
INSERT INTO `tag` VALUES (66, 'TestTag3', '测试标签3');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` int(0) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `user_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '用户名',
  `user_pass` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '密码',
  `user_nickname` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '昵称',
  `user_email` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '邮箱',
  `user_avatar` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像',
  `user_register_time` datetime(0) NULL DEFAULT NULL COMMENT '注册时间',
  `user_last_login_time` datetime(0) NULL DEFAULT NULL COMMENT '上次登录时间',
  `user_status` int(0) UNSIGNED NULL DEFAULT 1 COMMENT '状态',
  `user_role` int(0) NOT NULL DEFAULT 2 COMMENT '角色',
  PRIMARY KEY (`user_id`) USING BTREE,
  UNIQUE INDEX `user_name`(`user_name`) USING BTREE,
  UNIQUE INDEX `user_email`(`user_email`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 1015 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1014, 'test111', '123123123', '11111111', '123@163.com', '/static/img/user/default.jpg', '2022-01-09 10:38:17', '2022-01-09 10:38:17', 1, 2);
INSERT INTO `user` VALUES (1011, 'testUser', '123456', '测试用户', '456123@163.com', '/static/img/user/ceshi.jpg', '2022-01-09 18:21:40', '2022-01-09 18:21:45', 1, 2);

SET FOREIGN_KEY_CHECKS = 1;
