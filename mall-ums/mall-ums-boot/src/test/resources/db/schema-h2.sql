/*
* 会员
* h2版本
*/
DROP TABLE IF EXISTS `ums_address`;
CREATE TABLE `ums_address`
(
    `id`               bigint       NOT NULL AUTO_INCREMENT,
    `member_id`        bigint       NULL DEFAULT NULL COMMENT '会员ID',
    `consignee_name`   varchar(64)  NULL DEFAULT NULL COMMENT '收货人姓名',
    `consignee_mobile` varchar(20)  NULL DEFAULT NULL COMMENT '收货人联系方式',
    `province`         varchar(64)  NULL DEFAULT NULL COMMENT '省',
    `city`             varchar(64)  NULL DEFAULT NULL COMMENT '市',
    `area`             varchar(64)  NULL DEFAULT NULL COMMENT '区',
    `detail_address`   varchar(255) NULL DEFAULT NULL COMMENT '详细地址',
    `zip_code`         char(6)      NULL DEFAULT NULL COMMENT '邮编',
    `defaulted`        tinyint      NULL DEFAULT NULL COMMENT '是否默认地址',
    `create_time`      datetime     NULL DEFAULT NULL COMMENT '创建时间',
    `update_time`      datetime     NULL DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS `ums_member`;
CREATE TABLE `ums_member`
(
    `id`          bigint       NOT NULL AUTO_INCREMENT,
    `gender`      tinyint(1)   NULL DEFAULT NULL,
    `nickname`    varchar(50)  NULL DEFAULT NULL,
    `username`    varchar(64)  DEFAULT NULL COMMENT '用户名',
    `password`    varchar(100) DEFAULT NULL COMMENT '密码',
    `mobile`      varchar(20)  NULL DEFAULT NULL,
    `birthday`    date         NULL DEFAULT NULL,
    `avatar_url`  varchar(255) NULL DEFAULT NULL,
    `openid`      char(28)     NULL DEFAULT NULL,
    `session_key` varchar(32)  NULL DEFAULT NULL,
    `status`      tinyint(1)   NULL DEFAULT 1,
    `point`       int          NULL DEFAULT 0 COMMENT '会员积分',
    `is_deleted`  tinyint(1)   NULL DEFAULT 0,
    `create_time` datetime     NULL DEFAULT NULL,
    `update_time` datetime     NULL DEFAULT NULL,
    `balance`     bigint       NULL DEFAULT 1000000000,
    `city`        varchar(32)  NULL DEFAULT NULL,
    `country`     varchar(32)  NULL DEFAULT NULL,
    `language`    varchar(10)  NULL DEFAULT NULL,
    `province`    varchar(32)  NULL DEFAULT NULL,
    PRIMARY KEY (`id`)
);
