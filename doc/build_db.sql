# Create by zhangdx 2016-11-21.
# Username: root
# Password: admin123

# Create DATABASE
CREATE DATABASE `spring_boot_demo` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

# User
DROP TABLE  `tb_user` ;
CREATE TABLE `tb_user` (
  `id`   INT(11)  NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(50)       DEFAULT NULL COMMENT '用户名',
  `time` DATETIME NOT NULL COMMENT '时间',
  PRIMARY KEY (`id`)
) COMMENT = '用户表';
