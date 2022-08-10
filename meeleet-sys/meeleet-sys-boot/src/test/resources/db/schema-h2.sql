/*
* 系统管理
* h2版本
*/
DROP TABLE IF EXISTS `sys_dept`;
CREATE TABLE `sys_dept`
(
    `id`         bigint       NOT NULL AUTO_INCREMENT COMMENT '主键',
    `name`       varchar(64)  NULL DEFAULT '' COMMENT '部门名称',
    `parent_id`  bigint       NULL DEFAULT 0 COMMENT '父节点id',
    `tree_path`  varchar(255) NULL DEFAULT '' COMMENT '父节点id路径',
    `sort`       int          NULL DEFAULT 0 COMMENT '显示顺序',
    `status`     tinyint(1)   NULL DEFAULT 1 COMMENT '状态：1-正常 0-禁用',
    `is_deleted` tinyint(1)   NULL DEFAULT 0 COMMENT '删除状态：1-删除 0-未删除',
    `create_time` datetime     NULL DEFAULT NULL COMMENT '创建时间',
    `update_time` datetime     NULL DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS `sys_dict`;
CREATE TABLE `sys_dict`
(
    `id`         bigint       NOT NULL AUTO_INCREMENT COMMENT '主键 ',
    `name`       varchar(50)  NULL DEFAULT '' COMMENT '类型名称',
    `code`       varchar(50)  NULL DEFAULT '' COMMENT '类型编码',
    `status`     tinyint(1)   NULL DEFAULT 0 COMMENT '状态（0-正常 ,1-停用）',
    `remark`     varchar(255) NULL DEFAULT NULL COMMENT '备注',
    `create_time` datetime     NULL DEFAULT NULL COMMENT '创建时间',
    `update_time` datetime     NULL DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`),
    UNIQUE INDEX TYPE_CODE_0 (`code`)
);

DROP TABLE IF EXISTS `sys_dict_item`;
CREATE TABLE `sys_dict_item`
(
    `id`         bigint       NOT NULL AUTO_INCREMENT COMMENT '主键',
    `name`       varchar(50)  NULL DEFAULT '' COMMENT '字典项名称',
    `value`      varchar(50)  NULL DEFAULT '' COMMENT '字典项值',
    `dict_code`  varchar(50)  NULL DEFAULT '' COMMENT '字典编码',
    `sort`       int          NULL DEFAULT 0 COMMENT '排序',
    `status`     tinyint(1)   NULL DEFAULT 0 COMMENT '状态（0 停用 1正常）',
    `is_default` tinyint(1)   NULL DEFAULT 0 COMMENT '是否默认（0否 1是）',
    `remark`     varchar(255) NULL DEFAULT '' COMMENT '备注',
    `create_time` datetime     NULL DEFAULT NULL COMMENT '创建时间',
    `update_time` datetime     NULL DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`
(
    `id`         bigint       NOT NULL AUTO_INCREMENT,
    `parent_id`  bigint       NULL DEFAULT NULL COMMENT '父菜单ID',
    `name`       varchar(64)  NULL DEFAULT '' COMMENT '菜单名称',
    `path`       varchar(128) NULL DEFAULT '' COMMENT '路由路径(浏览器地址栏路径)',
    `component`  varchar(128) NULL DEFAULT NULL COMMENT '组件路径(vue页面完整路径，省略.vue后缀)',
    `icon`       varchar(64)  NULL DEFAULT '' COMMENT '菜单图标',
    `sort`       int          NULL DEFAULT 0 COMMENT '排序',
    `is_visible` tinyint(1)   NULL DEFAULT 1 COMMENT '状态(0:禁用;1:开启)',
    `redirect`   varchar(128) NULL DEFAULT '' COMMENT '跳转路径',
    `create_time` datetime     NULL DEFAULT NULL COMMENT '创建时间',
    `update_time` datetime     NULL DEFAULT NULL COMMENT '更新时间',
    `type`       tinyint      NULL DEFAULT NULL COMMENT '菜单类型(1:菜单;2:目录;3:外链)',
    PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS `sys_oauth_client`;
CREATE TABLE `sys_oauth_client`
(
    `client_id`               varchar(256)  NOT NULL,
    `resource_ids`            varchar(256)  NULL DEFAULT NULL,
    `client_secret`           varchar(256)  NULL DEFAULT NULL,
    `scope`                   varchar(256)  NULL DEFAULT NULL,
    `authorized_grant_types`  varchar(256)  NULL DEFAULT NULL,
    `web_server_redirect_uri` varchar(256)  NULL DEFAULT NULL,
    `authorities`             varchar(256)  NULL DEFAULT NULL,
    `access_token_validity`   int           NULL DEFAULT NULL,
    `refresh_token_validity`  int           NULL DEFAULT NULL,
    `additional_information`  varchar(4096) NULL DEFAULT NULL,
    `autoapprove`             varchar(256)  NULL DEFAULT NULL,
    PRIMARY KEY (`client_id`)
);

DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission`
(
    `id`         bigint       NOT NULL AUTO_INCREMENT COMMENT '主键',
    `name`       varchar(64)  NULL DEFAULT NULL COMMENT '权限名称',
    `menu_id`    int          NULL DEFAULT NULL COMMENT '菜单模块ID\r\n',
    `url_perm`   varchar(128) NULL DEFAULT NULL COMMENT 'URL权限标识',
    `btn_perm`   varchar(64)  NULL DEFAULT NULL COMMENT '按钮权限标识',
    `create_time` datetime     NULL DEFAULT NULL,
    `update_time` datetime     NULL DEFAULT NULL,
    PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`
(
    `id`         bigint      NOT NULL AUTO_INCREMENT,
    `name`       varchar(64) NOT NULL DEFAULT '' COMMENT '角色名称',
    `code`       varchar(32) NULL     DEFAULT NULL COMMENT '角色编码',
    `sort`       int         NULL     DEFAULT NULL COMMENT '显示顺序',
    `status`     tinyint(1)  NULL     DEFAULT 1 COMMENT '角色状态：0-正常；1-停用',
    `is_deleted` tinyint(1)  NOT NULL DEFAULT 0 COMMENT '逻辑删除标识：0-未删除；1-已删除',
    `create_time` datetime    NULL     DEFAULT NULL COMMENT '更新时间',
    `update_time` datetime    NULL     DEFAULT NULL COMMENT '创建时间',
    PRIMARY KEY (`id`),
    UNIQUE INDEX NAME_0 (`name`)
);

DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu`
(
    `role_id` bigint NOT NULL COMMENT '角色ID',
    `menu_id` bigint NOT NULL COMMENT '菜单ID'
);

DROP TABLE IF EXISTS `sys_role_permission`;
CREATE TABLE `sys_role_permission`
(
    `role_id`       int NULL DEFAULT NULL COMMENT '角色id',
    `permission_id` int NULL DEFAULT NULL COMMENT '资源id'
);

DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`
(
    `id`         int          NOT NULL AUTO_INCREMENT,
    `username`   varchar(64)  NULL DEFAULT NULL COMMENT '用户名',
    `nickname`   varchar(64)  NULL DEFAULT NULL COMMENT '昵称',
    `gender`     tinyint(1)   NULL DEFAULT 1 COMMENT '性别：1-男 2-女',
    `password`   varchar(100) NULL DEFAULT NULL COMMENT '密码',
    `dept_id`    int          NULL DEFAULT NULL COMMENT '部门ID',
    `avatar`     varchar(255) NULL DEFAULT '' COMMENT '用户头像',
    `mobile`     varchar(20)  NULL DEFAULT NULL COMMENT '联系方式',
    `status`     tinyint(1)   NULL DEFAULT 1 COMMENT '用户状态：1-正常 0-禁用',
    `email`      varchar(128) NULL DEFAULT NULL COMMENT '用户邮箱',
    `is_deleted` tinyint(1)   NULL DEFAULT 0 COMMENT '逻辑删除标识：0-未删除；1-已删除',
    `create_time` datetime     NULL DEFAULT NULL COMMENT '创建时间',
    `update_time` datetime     NULL DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`),
    UNIQUE INDEX LOGIN_NAME_0 (`username`)
);

DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`
(
    `user_id` int NOT NULL COMMENT '用户ID',
    `role_id` int NOT NULL COMMENT '角色ID',
    PRIMARY KEY (`user_id`, `role_id`)
);



