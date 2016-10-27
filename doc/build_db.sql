CREATE DATABASE `spring_boot_demo` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

CREATE TABLE `tb_news` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) DEFAULT NULL COMMENT '标题',
  `author` varchar(32) DEFAULT NULL COMMENT '新闻作者',
  `content` text COMMENT '新闻正文',
  `imageUrl` varchar(100) DEFAULT NULL COMMENT '新闻缩略图片',
  `link` varchar(100)  DEFAULT NULL COMMENT '原文链接',
  `description` varchar(2000) DEFAULT NULL COMMENT '新闻描述',
  `time` datetime NOT NULL COMMENT '新闻时间',
  `updateTime` datetime DEFAULT NULL COMMENT '上一次更新时间',
  `isDelete` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否删除: 0：false;（默认值） 1: true;',
  `isShow` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否对外发布：0 false (默认) ; 1 true',
  PRIMARY KEY (`id`)
) COMMENT='新闻表';
