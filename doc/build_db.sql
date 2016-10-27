CREATE DATABASE `spring_boot_demo` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

CREATE TABLE `tb_news` (
  `id`          INT(11)    NOT NULL AUTO_INCREMENT,
  `title`       VARCHAR(100)        DEFAULT NULL
  COMMENT '标题',
  `author`      VARCHAR(32)         DEFAULT NULL
  COMMENT '新闻作者',
  `content`     TEXT COMMENT '新闻正文',
  `imageUrl`    VARCHAR(100)        DEFAULT NULL
  COMMENT '新闻缩略图片',
  `link`        VARCHAR(100)        DEFAULT NULL
  COMMENT '原文链接',
  `description` VARCHAR(2000)       DEFAULT NULL
  COMMENT '新闻描述',
  `time`        DATETIME   NOT NULL
  COMMENT '新闻时间',
  `updateTime`  DATETIME            DEFAULT NULL
  COMMENT '上一次更新时间',
  `isDelete`    TINYINT(4) NOT NULL DEFAULT '0'
  COMMENT '是否删除: 0：false;（默认值） 1: true;',
  `isShow`      TINYINT(4) NOT NULL DEFAULT '0'
  COMMENT '是否对外发布：0 false (默认) ; 1 true',
  PRIMARY KEY (`id`)
)
  COMMENT = '新闻表';
