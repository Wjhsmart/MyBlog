/*
 Navicat Premium Data Transfer

 Source Server         : 本地开发-127.0.0.1
 Source Server Type    : MySQL
 Source Server Version : 50724
 Source Host           : localhost:3306
 Source Schema         : my_blog

 Target Server Type    : MySQL
 Target Server Version : 50724
 File Encoding         : 65001

 Date: 06/03/2019 18:47:56
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_article
-- ----------------------------
DROP TABLE IF EXISTS `t_article`;
CREATE TABLE `t_article` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '文章编号',
  `category_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '类别编号',
  `title` varchar(50) NOT NULL DEFAULT '' COMMENT '文章标题',
  `cover_img` varchar(500) NOT NULL DEFAULT '' COMMENT '封面图片',
  `summary` varchar(500) DEFAULT NULL COMMENT '文章摘要',
  `content` text NOT NULL COMMENT '文章内容',
  `view_count` bigint(11) DEFAULT '0' COMMENT '阅读数',
  `comment_count` bigint(11) DEFAULT '0' COMMENT '评论数',
  `recommend` int(2) DEFAULT '0' COMMENT '是否推荐',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) DEFAULT '1' COMMENT '是否激活',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8mb4 COMMENT='文章表';

-- ----------------------------
-- Records of t_article
-- ----------------------------
BEGIN;
INSERT INTO `t_article` VALUES (1, 1, 'Hello World', 'images/text02.jpg', '这篇博客用来测试，这个是我的第一篇博客，自己小站的博客，欢迎大家捧场，后续会慢慢更新的，感谢感谢感谢，非常感谢', '<span>内容很少，但都是i 精华</span>', 0, 0, 1, '2019-03-01 17:25:06', '2019-03-04 19:46:17', 1);
COMMIT;

-- ----------------------------
-- Table structure for t_article_category
-- ----------------------------
DROP TABLE IF EXISTS `t_article_category`;
CREATE TABLE `t_article_category` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '类别编号',
  `title` varchar(20) NOT NULL COMMENT '类别名称',
  `description` varchar(255) DEFAULT NULL COMMENT '类别描述',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) DEFAULT '1' COMMENT '是否激活',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COMMENT='文章类别表';

-- ----------------------------
-- Records of t_article_category
-- ----------------------------
BEGIN;
INSERT INTO `t_article_category` VALUES (1, 'Java', 'Java相关的博客', '2019-03-04 14:36:34', '2019-03-04 14:36:58', 1);
INSERT INTO `t_article_category` VALUES (2, 'Linux', 'Linux相关的博客', '2019-03-04 14:36:46', '2019-03-04 14:37:02', 1);
INSERT INTO `t_article_category` VALUES (3, 'Mac', 'Mac相关的博客', '2019-03-04 14:37:45', '2019-03-04 14:37:42', 1);
COMMIT;

-- ----------------------------
-- Table structure for t_article_comment
-- ----------------------------
DROP TABLE IF EXISTS `t_article_comment`;
CREATE TABLE `t_article_comment` (
  `id` bigint(20) NOT NULL COMMENT '评论编号',
  `article_id` bigint(20) NOT NULL COMMENT '文章编号',
  `username` varchar(20) NOT NULL COMMENT '用户昵称',
  `title` varchar(50) NOT NULL COMMENT '评论标题',
  `content` varchar(500) NOT NULL COMMENT '评论详情',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `is_active` tinyint(4) DEFAULT '1' COMMENT '是否激活',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='文章评论表';

-- ----------------------------
-- Table structure for t_info
-- ----------------------------
DROP TABLE IF EXISTS `t_info`;
CREATE TABLE `t_info` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '系统信息主键',
  `title` varchar(32) DEFAULT '' COMMENT '系统名称',
  `desc` varchar(255) DEFAULT '' COMMENT '说明',
  `record_num` varchar(32) DEFAULT '' COMMENT '备案号',
  `domain_name` varchar(32) DEFAULT '' COMMENT '域名',
  `name` varchar(10) DEFAULT '' COMMENT '姓名',
  `rename` varchar(20) DEFAULT '' COMMENT '真实姓名',
  `net_name` varchar(32) DEFAULT '' COMMENT '网名',
  `vocation` varchar(20) DEFAULT '' COMMENT '职业',
  `qq` varchar(20) DEFAULT '' COMMENT 'QQ',
  `wechat` varchar(20) DEFAULT '' COMMENT '微信',
  `email` varchar(20) DEFAULT '' COMMENT '邮箱',
  `head_img` varchar(100) DEFAULT '' COMMENT '头像',
  `wechat_code` varchar(100) DEFAULT '' COMMENT '微信二维码',
  `motto` varchar(100) DEFAULT '' COMMENT '格言',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COMMENT='系统信息表';

-- ----------------------------
-- Records of t_info
-- ----------------------------
BEGIN;
INSERT INTO `t_info` VALUES (1, '危锦辉的个人小站', '一个阳光的90后小哥哥，喜欢专研技术，分享技术。', '赣ICP备19000931号-1', 'www.wjhsmart.vip', '危锦辉', '危锦辉', 'Wjhsmart', 'Java Web开发工程师', '672630243', 'GZWjhsmart', 'wjhsmarter@126.com', 'images/avatar.jpg', 'images/wx.jpg', '当你的实力不足以撑起你的野心，你就应该静下心来好好学习。');
COMMIT;

-- ----------------------------
-- Table structure for t_leave_word
-- ----------------------------
DROP TABLE IF EXISTS `t_leave_word`;
CREATE TABLE `t_leave_word` (
  `id` bigint(22) NOT NULL AUTO_INCREMENT COMMENT '留言表主键',
  `nickname` varchar(32) NOT NULL DEFAULT '' COMMENT '称呼',
  `email` varchar(20) NOT NULL DEFAULT '' COMMENT '邮箱',
  `reply_flag` int(4) NOT NULL DEFAULT '0' COMMENT '回复标识',
  `reply_content` varchar(255) DEFAULT '' COMMENT '回复内容',
  `reply_time` datetime DEFAULT NULL COMMENT '回复时间',
  `read_flag` int(4) DEFAULT '0' COMMENT '是否已读',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '提交时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COMMENT='留言表';

SET FOREIGN_KEY_CHECKS = 1;
