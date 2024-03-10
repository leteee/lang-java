#  创建数据库
create database demo DEFAULT CHARSET = utf8mb4;
use demo;

# user表和数据
drop table if exists `user`;
CREATE TABLE `user`
(
    `id`       int(11) NOT NULL AUTO_INCREMENT,
    `username` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '账号',
    `nickname` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '昵称',
    `password` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '密码',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 2
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;
insert into user(username, nickname, password)
values ("a", "A", "123456"),
       ("b", "B", "123456"),
       ("c", "C", "123456"),
       ("d", "D", "123456"),
       ("e", "E", "123456");
