/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80033
 Source Host           : localhost:3306
 Source Schema         : manage

 Target Server Type    : MySQL
 Target Server Version : 80033
 File Encoding         : 65001

 Date: 27/02/2024 21:12:04
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for files
-- ----------------------------
DROP TABLE IF EXISTS `files`;
CREATE TABLE `files`  (
  `id` int(0) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id',
  `file_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '文件名称',
  `type` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '文件类型',
  `size` bigint(0) UNSIGNED NOT NULL COMMENT '字节',
  `md5` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'md5',
  `url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'url',
  `deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否删除\r\n',
  `status` tinyint(1) NOT NULL DEFAULT 1 COMMENT '是否可用',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建日期',
  `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '更新日期',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uniqued`(`file_name`, `md5`, `url`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '文件' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of files
-- ----------------------------
INSERT INTO `files` VALUES (11, 'f097b335-ffa6-4646-b33f-ffc43e49887c.jpg', 'image/jpeg', 54925, '74258aba44e154544f6fe57d46c120dd', 'http://localhost:8080/file/f097b335-ffa6-4646-b33f-ffc43e49887c.jpg', 0, 1, '2024-02-20 11:29:58', '2024-02-20 11:29:58');

-- ----------------------------
-- Table structure for gen_table
-- ----------------------------
DROP TABLE IF EXISTS `gen_table`;
CREATE TABLE `gen_table`  (
  `table_id` bigint(0) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id',
  `table_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '表名',
  `table_comment` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注信息',
  `class_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '类名',
  `package_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '包名',
  `module_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '模块名称',
  `business_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '业务名称',
  `function_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '功能名称',
  `function_author` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '作者名称',
  `gen_type` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '代码生成方式',
  `gen_path` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '生成路径',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`table_id`) USING BTREE,
  UNIQUE INDEX `idx_table_name`(`table_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 188 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gen_table
-- ----------------------------
INSERT INTO `gen_table` VALUES (179, 'files', '文件', 'Files', 'com.gong.system', 'system', 'files', '文件', 'g', NULL, NULL, NULL, '2024-02-27 21:11:24', '2024-02-27 21:11:24');
INSERT INTO `gen_table` VALUES (180, 'student', NULL, 'Student', 'com.gong.system', 'system', 'student', '测试', 'g', NULL, NULL, NULL, '2024-02-27 21:11:24', '2024-02-27 21:11:24');
INSERT INTO `gen_table` VALUES (181, 'sys_logininfor', '系统访问记录', 'SysLogininfor', 'com.gong.system', 'system', 'sysLogininfor', '系统访问记录', 'g', NULL, NULL, NULL, '2024-02-27 21:11:24', '2024-02-27 21:11:24');
INSERT INTO `gen_table` VALUES (182, 'sys_menu', '菜单表', 'SysMenu', 'com.gong.system', 'system', 'sysMenu', '菜单表', 'g', NULL, NULL, NULL, '2024-02-27 21:11:24', '2024-02-27 21:11:24');
INSERT INTO `gen_table` VALUES (183, 'sys_oper_log', '操作日志记录', 'SysOperLog', 'com.gong.system', 'system', 'sysOperLog', '操作日志记录', 'g', NULL, NULL, NULL, '2024-02-27 21:11:24', '2024-02-27 21:11:24');
INSERT INTO `gen_table` VALUES (184, 'sys_role', '角色表', 'SysRole', 'com.gong.system', 'system', 'sysRole', '角色表', 'g', NULL, NULL, NULL, '2024-02-27 21:11:24', '2024-02-27 21:11:24');
INSERT INTO `gen_table` VALUES (185, 'sys_role_menu', '角色菜单关联表', 'SysRoleMenu', 'com.gong.system', 'system', 'sysRoleMenu', '角色菜单关联表', 'g', NULL, NULL, NULL, '2024-02-27 21:11:24', '2024-02-27 21:11:24');
INSERT INTO `gen_table` VALUES (186, 'sys_user', '用户表', 'SysUser', 'com.gong.system', 'system', 'sysUser', '用户表', 'g', NULL, NULL, NULL, '2024-02-27 21:11:24', '2024-02-27 21:11:24');
INSERT INTO `gen_table` VALUES (187, 'sys_user_role', '用户角色关联表', 'SysUserRole', 'com.gong.system', 'system', 'sysUserRole', '用户角色关联表', 'g', NULL, NULL, NULL, '2024-02-27 21:11:24', '2024-02-27 21:11:24');

-- ----------------------------
-- Table structure for gen_table_column
-- ----------------------------
DROP TABLE IF EXISTS `gen_table_column`;
CREATE TABLE `gen_table_column`  (
  `column_id` bigint(0) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id',
  `table_id` bigint(0) UNSIGNED NOT NULL COMMENT '表id',
  `column_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '列名',
  `column_comment` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '列描述',
  `column_type` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '列类型',
  `java_type` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'java类型',
  `java_field` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '字段名',
  `is_pk` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '1' COMMENT '是否是主键',
  `is_increment` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '1' COMMENT '是否自增',
  `is_required` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '1' COMMENT '是否唯一',
  `is_insert` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '1' COMMENT '是否插入',
  `is_edit` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '1' COMMENT '是否编辑',
  `is_list` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '1' COMMENT '是否列表字段',
  `is_query` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '1' COMMENT '是否查询字段',
  `query_type` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '查询方式',
  `html_type` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '显示方式',
  `sort` int(0) UNSIGNED NULL DEFAULT NULL COMMENT '排序字段',
  `create_by` bigint(0) UNSIGNED NOT NULL COMMENT '创建人',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_by` bigint(0) UNSIGNED NULL DEFAULT NULL COMMENT '修改人',
  `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  PRIMARY KEY (`column_id`) USING BTREE,
  INDEX `index_table_id`(`table_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1769 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gen_table_column
-- ----------------------------
INSERT INTO `gen_table_column` VALUES (1679, 179, 'id', 'id', 'int unsigned', 'Integer', 'id', '1', '1', '0', '1', '1', '1', '1', 'EQ', 'input', 1, 1, '2024-02-27 21:11:24', NULL, '2024-02-27 21:11:24');
INSERT INTO `gen_table_column` VALUES (1680, 179, 'file_name', '文件名称', 'varchar(255)', 'String', 'fileName', '0', '0', '1', '1', '1', '1', '0', 'EQ', 'input', 2, 1, '2024-02-27 21:11:24', NULL, '2024-02-27 21:11:24');
INSERT INTO `gen_table_column` VALUES (1681, 179, 'type', '文件类型', 'varchar(50)', 'String', 'type', '0', '0', '1', '1', '1', '1', '0', 'EQ', 'input', 3, 1, '2024-02-27 21:11:24', NULL, '2024-02-27 21:11:24');
INSERT INTO `gen_table_column` VALUES (1682, 179, 'size', '字节', 'bigint unsigned', 'Long', 'size', '0', '0', '1', '1', '1', '1', '0', 'EQ', 'input', 4, 1, '2024-02-27 21:11:24', NULL, '2024-02-27 21:11:24');
INSERT INTO `gen_table_column` VALUES (1683, 179, 'md5', 'md5', 'varchar(32)', 'String', 'md5', '0', '0', '1', '1', '1', '1', '0', 'EQ', 'input', 5, 1, '2024-02-27 21:11:24', NULL, '2024-02-27 21:11:24');
INSERT INTO `gen_table_column` VALUES (1684, 179, 'url', 'url', 'varchar(255)', 'String', 'url', '0', '0', '1', '1', '1', '1', '0', 'EQ', 'input', 6, 1, '2024-02-27 21:11:24', NULL, '2024-02-27 21:11:24');
INSERT INTO `gen_table_column` VALUES (1685, 179, 'deleted', '是否删除\r\n', 'tinyint(1)', 'Integer', 'deleted', '0', '0', '1', '1', '1', '1', '0', 'EQ', 'input', 7, 1, '2024-02-27 21:11:24', NULL, '2024-02-27 21:11:24');
INSERT INTO `gen_table_column` VALUES (1686, 179, 'status', '是否可用', 'tinyint(1)', 'Integer', 'status', '0', '0', '1', '1', '1', '1', '0', 'EQ', 'input', 8, 1, '2024-02-27 21:11:24', NULL, '2024-02-27 21:11:24');
INSERT INTO `gen_table_column` VALUES (1687, 179, 'create_time', '创建日期', 'datetime', 'LocalDateTime', 'createTime', '0', '0', '1', '0', '0', '1', '0', 'EQ', 'datetime', 9, 1, '2024-02-27 21:11:24', NULL, '2024-02-27 21:11:24');
INSERT INTO `gen_table_column` VALUES (1688, 179, 'update_time', '更新日期', 'datetime', 'LocalDateTime', 'updateTime', '0', '0', '1', '0', '0', '1', '0', 'EQ', 'datetime', 10, 1, '2024-02-27 21:11:24', NULL, '2024-02-27 21:11:24');
INSERT INTO `gen_table_column` VALUES (1689, 180, 'id', 'id', 'bigint', 'Long', 'id', '1', '1', '0', '1', '1', '1', '1', 'EQ', 'input', 1, 1, '2024-02-27 21:11:24', NULL, '2024-02-27 21:11:24');
INSERT INTO `gen_table_column` VALUES (1690, 180, 'student_name', '学生名称', 'varchar(50)', 'String', 'studentName', '0', '0', '1', '1', '1', '1', '0', 'EQ', 'input', 2, 1, '2024-02-27 21:11:24', NULL, '2024-02-27 21:11:24');
INSERT INTO `gen_table_column` VALUES (1691, 180, 'age', '年龄', 'int unsigned', 'Integer', 'age', '0', '0', '0', '1', '1', '1', '0', 'EQ', 'input', 3, 1, '2024-02-27 21:11:24', NULL, '2024-02-27 21:11:24');
INSERT INTO `gen_table_column` VALUES (1692, 180, 'gender', '性别', 'char(1)', 'String', 'gender', '0', '0', '1', '1', '1', '1', '0', 'EQ', 'input', 4, 1, '2024-02-27 21:11:24', NULL, '2024-02-27 21:11:24');
INSERT INTO `gen_table_column` VALUES (1693, 180, 'create_time', '创建时间', 'datetime', 'LocalDateTime', 'createTime', '0', '0', '1', '0', '0', '1', '0', 'EQ', 'datetime', 5, 1, '2024-02-27 21:11:24', NULL, '2024-02-27 21:11:24');
INSERT INTO `gen_table_column` VALUES (1694, 180, 'update_time', '更新时间', 'datetime', 'LocalDateTime', 'updateTime', '0', '0', '1', '0', '0', '1', '0', 'EQ', 'datetime', 6, 1, '2024-02-27 21:11:24', NULL, '2024-02-27 21:11:24');
INSERT INTO `gen_table_column` VALUES (1695, 181, 'id', '访问ID', 'bigint', 'Long', 'id', '1', '1', '0', '1', '1', '1', '1', 'EQ', 'input', 1, 1, '2024-02-27 21:11:24', NULL, '2024-02-27 21:11:24');
INSERT INTO `gen_table_column` VALUES (1696, 181, 'user_name', '用户账号', 'varchar(50)', 'String', 'userName', '0', '0', '0', '1', '1', '1', '0', 'EQ', 'input', 2, 1, '2024-02-27 21:11:24', NULL, '2024-02-27 21:11:24');
INSERT INTO `gen_table_column` VALUES (1697, 181, 'ipaddr', '登录IP地址', 'varchar(128)', 'String', 'ipaddr', '0', '0', '0', '1', '1', '1', '0', 'EQ', 'input', 3, 1, '2024-02-27 21:11:24', NULL, '2024-02-27 21:11:24');
INSERT INTO `gen_table_column` VALUES (1698, 181, 'login_location', '登录地点', 'varchar(255)', 'String', 'loginLocation', '0', '0', '0', '1', '1', '1', '0', 'EQ', 'input', 4, 1, '2024-02-27 21:11:24', NULL, '2024-02-27 21:11:24');
INSERT INTO `gen_table_column` VALUES (1699, 181, 'browser', '浏览器类型', 'varchar(50)', 'String', 'browser', '0', '0', '0', '1', '1', '1', '0', 'EQ', 'input', 5, 1, '2024-02-27 21:11:24', NULL, '2024-02-27 21:11:24');
INSERT INTO `gen_table_column` VALUES (1700, 181, 'os', '操作系统', 'varchar(50)', 'String', 'os', '0', '0', '0', '1', '1', '1', '0', 'EQ', 'input', 6, 1, '2024-02-27 21:11:24', NULL, '2024-02-27 21:11:24');
INSERT INTO `gen_table_column` VALUES (1701, 181, 'status', '登录状态（0成功 1失败）', 'char(1)', 'String', 'status', '0', '0', '0', '1', '1', '1', '0', 'EQ', 'input', 7, 1, '2024-02-27 21:11:24', NULL, '2024-02-27 21:11:24');
INSERT INTO `gen_table_column` VALUES (1702, 181, 'msg', '提示消息', 'varchar(255)', 'String', 'msg', '0', '0', '0', '1', '1', '1', '0', 'EQ', 'input', 8, 1, '2024-02-27 21:11:24', NULL, '2024-02-27 21:11:24');
INSERT INTO `gen_table_column` VALUES (1703, 181, 'login_time', '访问时间', 'datetime', 'LocalDateTime', 'loginTime', '0', '0', '0', '1', '1', '1', '0', 'EQ', 'datetime', 9, 1, '2024-02-27 21:11:24', NULL, '2024-02-27 21:11:24');
INSERT INTO `gen_table_column` VALUES (1704, 182, 'id', 'id', 'bigint unsigned', 'Long', 'id', '1', '1', '0', '1', '1', '1', '1', 'EQ', 'input', 1, 1, '2024-02-27 21:11:24', NULL, '2024-02-27 21:11:24');
INSERT INTO `gen_table_column` VALUES (1705, 182, 'parent_id', '父菜单id', 'bigint unsigned', 'Long', 'parentId', '0', '0', '1', '1', '1', '1', '0', 'EQ', 'input', 2, 1, '2024-02-27 21:11:24', NULL, '2024-02-27 21:11:24');
INSERT INTO `gen_table_column` VALUES (1706, 182, 'name', '组件名称', 'varchar(50)', 'String', 'name', '0', '0', '0', '1', '1', '1', '0', 'EQ', 'input', 3, 1, '2024-02-27 21:11:24', NULL, '2024-02-27 21:11:24');
INSERT INTO `gen_table_column` VALUES (1707, 182, 'menu_name', '菜单名称', 'varchar(50)', 'String', 'menuName', '0', '0', '1', '1', '1', '1', '0', 'EQ', 'input', 4, 1, '2024-02-27 21:11:24', NULL, '2024-02-27 21:11:24');
INSERT INTO `gen_table_column` VALUES (1708, 182, 'icon', '菜单图标', 'varchar(50)', 'String', 'icon', '0', '0', '0', '1', '1', '1', '0', 'EQ', 'input', 5, 1, '2024-02-27 21:11:24', NULL, '2024-02-27 21:11:24');
INSERT INTO `gen_table_column` VALUES (1709, 182, 'path', '路由', 'varchar(255)', 'String', 'path', '0', '0', '0', '1', '1', '1', '0', 'EQ', 'input', 6, 1, '2024-02-27 21:11:24', NULL, '2024-02-27 21:11:24');
INSERT INTO `gen_table_column` VALUES (1710, 182, 'component', '组件位置', 'varchar(255)', 'String', 'component', '0', '0', '0', '1', '1', '1', '0', 'EQ', 'input', 7, 1, '2024-02-27 21:11:24', NULL, '2024-02-27 21:11:24');
INSERT INTO `gen_table_column` VALUES (1711, 182, 'aside', '是否为侧边菜单', 'tinyint(1)', 'Integer', 'aside', '0', '0', '1', '1', '1', '1', '0', 'EQ', 'input', 8, 1, '2024-02-27 21:11:24', NULL, '2024-02-27 21:11:24');
INSERT INTO `gen_table_column` VALUES (1712, 182, 'menu_type', 'M目录，C菜单，B按钮', 'char(1)', 'String', 'menuType', '0', '0', '1', '1', '1', '1', '0', 'EQ', 'input', 9, 1, '2024-02-27 21:11:24', NULL, '2024-02-27 21:11:24');
INSERT INTO `gen_table_column` VALUES (1713, 182, 'cache', '0 不缓存组件 1 缓存', 'tinyint(1)', 'Integer', 'cache', '0', '0', '1', '1', '1', '1', '0', 'EQ', 'input', 10, 1, '2024-02-27 21:11:24', NULL, '2024-02-27 21:11:24');
INSERT INTO `gen_table_column` VALUES (1714, 182, 'status', '状态', 'tinyint(1)', 'Integer', 'status', '0', '0', '1', '1', '1', '1', '0', 'EQ', 'input', 11, 1, '2024-02-27 21:11:24', NULL, '2024-02-27 21:11:24');
INSERT INTO `gen_table_column` VALUES (1715, 182, 'params', '路由参数', 'varchar(255)', 'String', 'params', '0', '0', '0', '1', '1', '1', '0', 'EQ', 'input', 12, 1, '2024-02-27 21:11:24', NULL, '2024-02-27 21:11:24');
INSERT INTO `gen_table_column` VALUES (1716, 182, 'purview', '权限标识', 'varchar(100)', 'String', 'purview', '0', '0', '0', '1', '1', '1', '0', 'EQ', 'input', 13, 1, '2024-02-27 21:11:24', NULL, '2024-02-27 21:11:24');
INSERT INTO `gen_table_column` VALUES (1717, 182, 'remark', '注释', 'varchar(255)', 'String', 'remark', '0', '0', '0', '1', '1', '1', '0', 'EQ', 'input', 14, 1, '2024-02-27 21:11:24', NULL, '2024-02-27 21:11:24');
INSERT INTO `gen_table_column` VALUES (1718, 182, 'order_menu', '排序字段', 'int unsigned', 'Integer', 'orderMenu', '0', '0', '0', '1', '1', '1', '0', 'EQ', 'input', 15, 1, '2024-02-27 21:11:24', NULL, '2024-02-27 21:11:24');
INSERT INTO `gen_table_column` VALUES (1719, 182, 'create_by', '添加人', 'bigint unsigned', 'Long', 'createBy', '0', '0', '1', '0', '0', '1', '0', 'EQ', 'input', 16, 1, '2024-02-27 21:11:24', NULL, '2024-02-27 21:11:24');
INSERT INTO `gen_table_column` VALUES (1720, 182, 'update_by', '修改人', 'bigint unsigned', 'Long', 'updateBy', '0', '0', '1', '0', '0', '1', '0', 'EQ', 'input', 17, 1, '2024-02-27 21:11:24', NULL, '2024-02-27 21:11:24');
INSERT INTO `gen_table_column` VALUES (1721, 182, 'create_time', '创建时间', 'datetime', 'LocalDateTime', 'createTime', '0', '0', '1', '0', '0', '1', '0', 'EQ', 'datetime', 18, 1, '2024-02-27 21:11:24', NULL, '2024-02-27 21:11:24');
INSERT INTO `gen_table_column` VALUES (1722, 182, 'update_time', '修改时间', 'datetime', 'LocalDateTime', 'updateTime', '0', '0', '1', '0', '0', '1', '0', 'EQ', 'datetime', 19, 1, '2024-02-27 21:11:24', NULL, '2024-02-27 21:11:24');
INSERT INTO `gen_table_column` VALUES (1723, 183, 'id', '日志主键', 'bigint', 'Long', 'id', '1', '1', '0', '1', '1', '1', '1', 'EQ', 'input', 1, 1, '2024-02-27 21:11:24', NULL, '2024-02-27 21:11:24');
INSERT INTO `gen_table_column` VALUES (1724, 183, 'title', '模块标题', 'varchar(50)', 'String', 'title', '0', '0', '0', '1', '1', '1', '0', 'EQ', 'input', 2, 1, '2024-02-27 21:11:24', NULL, '2024-02-27 21:11:24');
INSERT INTO `gen_table_column` VALUES (1725, 183, 'business_type', '业务类型（0其它 1新增 2修改 3删除）', 'int', 'Integer', 'businessType', '0', '0', '0', '1', '1', '1', '0', 'EQ', 'input', 3, 1, '2024-02-27 21:11:24', NULL, '2024-02-27 21:11:24');
INSERT INTO `gen_table_column` VALUES (1726, 183, 'method', '方法名称', 'varchar(100)', 'String', 'method', '0', '0', '0', '1', '1', '1', '0', 'EQ', 'input', 4, 1, '2024-02-27 21:11:24', NULL, '2024-02-27 21:11:24');
INSERT INTO `gen_table_column` VALUES (1727, 183, 'request_method', '请求方式', 'varchar(10)', 'String', 'requestMethod', '0', '0', '0', '1', '1', '1', '0', 'EQ', 'input', 5, 1, '2024-02-27 21:11:24', NULL, '2024-02-27 21:11:24');
INSERT INTO `gen_table_column` VALUES (1728, 183, 'operator_type', '操作类别（0其它 1后台用户 2手机端用户）', 'int', 'Integer', 'operatorType', '0', '0', '0', '1', '1', '1', '0', 'EQ', 'input', 6, 1, '2024-02-27 21:11:24', NULL, '2024-02-27 21:11:24');
INSERT INTO `gen_table_column` VALUES (1729, 183, 'oper_name', '操作人员', 'varchar(50)', 'String', 'operName', '0', '0', '0', '1', '1', '1', '0', 'EQ', 'input', 7, 1, '2024-02-27 21:11:24', NULL, '2024-02-27 21:11:24');
INSERT INTO `gen_table_column` VALUES (1730, 183, 'dept_name', '部门名称', 'varchar(50)', 'String', 'deptName', '0', '0', '0', '1', '1', '1', '0', 'EQ', 'input', 8, 1, '2024-02-27 21:11:24', NULL, '2024-02-27 21:11:24');
INSERT INTO `gen_table_column` VALUES (1731, 183, 'oper_url', '请求URL', 'varchar(255)', 'String', 'operUrl', '0', '0', '0', '1', '1', '1', '0', 'EQ', 'input', 9, 1, '2024-02-27 21:11:24', NULL, '2024-02-27 21:11:24');
INSERT INTO `gen_table_column` VALUES (1732, 183, 'oper_ip', '主机地址', 'varchar(128)', 'String', 'operIp', '0', '0', '0', '1', '1', '1', '0', 'EQ', 'input', 10, 1, '2024-02-27 21:11:24', NULL, '2024-02-27 21:11:24');
INSERT INTO `gen_table_column` VALUES (1733, 183, 'oper_location', '操作地点', 'varchar(255)', 'String', 'operLocation', '0', '0', '0', '1', '1', '1', '0', 'EQ', 'input', 11, 1, '2024-02-27 21:11:24', NULL, '2024-02-27 21:11:24');
INSERT INTO `gen_table_column` VALUES (1734, 183, 'oper_param', '请求参数', 'varchar(2000)', 'String', 'operParam', '0', '0', '0', '1', '1', '1', '0', 'EQ', 'input', 12, 1, '2024-02-27 21:11:24', NULL, '2024-02-27 21:11:24');
INSERT INTO `gen_table_column` VALUES (1735, 183, 'json_result', '返回参数', 'varchar(2000)', 'String', 'jsonResult', '0', '0', '0', '1', '1', '1', '0', 'EQ', 'input', 13, 1, '2024-02-27 21:11:24', NULL, '2024-02-27 21:11:24');
INSERT INTO `gen_table_column` VALUES (1736, 183, 'status', '操作状态（1正常 0异常）', 'int', 'Integer', 'status', '0', '0', '0', '1', '1', '1', '0', 'EQ', 'input', 14, 1, '2024-02-27 21:11:24', NULL, '2024-02-27 21:11:24');
INSERT INTO `gen_table_column` VALUES (1737, 183, 'error_msg', '错误消息', 'varchar(2000)', 'String', 'errorMsg', '0', '0', '0', '1', '1', '1', '0', 'EQ', 'input', 15, 1, '2024-02-27 21:11:24', NULL, '2024-02-27 21:11:24');
INSERT INTO `gen_table_column` VALUES (1738, 183, 'oper_time', '操作时间', 'datetime', 'LocalDateTime', 'operTime', '0', '0', '0', '1', '1', '1', '0', 'EQ', 'datetime', 16, 1, '2024-02-27 21:11:24', NULL, '2024-02-27 21:11:24');
INSERT INTO `gen_table_column` VALUES (1739, 183, 'cost_time', '消耗时间', 'bigint', 'Long', 'costTime', '0', '0', '0', '1', '1', '1', '0', 'EQ', 'input', 17, 1, '2024-02-27 21:11:24', NULL, '2024-02-27 21:11:24');
INSERT INTO `gen_table_column` VALUES (1740, 184, 'id', '角色id', 'bigint unsigned', 'Long', 'id', '1', '1', '0', '1', '1', '1', '1', 'EQ', 'input', 1, 1, '2024-02-27 21:11:24', NULL, '2024-02-27 21:11:24');
INSERT INTO `gen_table_column` VALUES (1741, 184, 'name', '角色名称', 'varchar(100)', 'String', 'name', '0', '0', '1', '1', '1', '1', '0', 'EQ', 'input', 2, 1, '2024-02-27 21:11:24', NULL, '2024-02-27 21:11:24');
INSERT INTO `gen_table_column` VALUES (1742, 184, 'key', '角色标识', 'varchar(100)', 'String', 'key', '0', '0', '1', '1', '1', '1', '0', 'EQ', 'input', 3, 1, '2024-02-27 21:11:24', NULL, '2024-02-27 21:11:24');
INSERT INTO `gen_table_column` VALUES (1743, 184, 'status', '0 停用 ', 'tinyint(1)', 'Integer', 'status', '0', '0', '1', '1', '1', '1', '0', 'EQ', 'input', 4, 1, '2024-02-27 21:11:24', NULL, '2024-02-27 21:11:24');
INSERT INTO `gen_table_column` VALUES (1744, 184, 'create_by', '创建者', 'bigint unsigned', 'Long', 'createBy', '0', '0', '1', '0', '0', '1', '0', 'EQ', 'input', 5, 1, '2024-02-27 21:11:24', NULL, '2024-02-27 21:11:24');
INSERT INTO `gen_table_column` VALUES (1745, 184, 'update_by', '修改者', 'bigint unsigned', 'Long', 'updateBy', '0', '0', '1', '0', '0', '1', '0', 'EQ', 'input', 6, 1, '2024-02-27 21:11:24', NULL, '2024-02-27 21:11:24');
INSERT INTO `gen_table_column` VALUES (1746, 184, 'create_time', '创建时间', 'datetime', 'LocalDateTime', 'createTime', '0', '0', '1', '0', '0', '1', '0', 'EQ', 'datetime', 7, 1, '2024-02-27 21:11:24', NULL, '2024-02-27 21:11:24');
INSERT INTO `gen_table_column` VALUES (1747, 184, 'update_time', '修改时间', 'datetime', 'LocalDateTime', 'updateTime', '0', '0', '1', '0', '0', '1', '0', 'EQ', 'datetime', 8, 1, '2024-02-27 21:11:24', NULL, '2024-02-27 21:11:24');
INSERT INTO `gen_table_column` VALUES (1748, 185, 'id', '自增id', 'bigint unsigned', 'Long', 'id', '1', '1', '0', '1', '1', '1', '1', 'EQ', 'input', 1, 1, '2024-02-27 21:11:24', NULL, '2024-02-27 21:11:24');
INSERT INTO `gen_table_column` VALUES (1749, 185, 'role_id', '角色id', 'bigint unsigned', 'Long', 'roleId', '0', '0', '1', '1', '1', '1', '0', 'EQ', 'input', 2, 1, '2024-02-27 21:11:24', NULL, '2024-02-27 21:11:24');
INSERT INTO `gen_table_column` VALUES (1750, 185, 'menu_id', '菜单id', 'bigint unsigned', 'Long', 'menuId', '0', '0', '1', '1', '1', '1', '0', 'EQ', 'input', 3, 1, '2024-02-27 21:11:24', NULL, '2024-02-27 21:11:24');
INSERT INTO `gen_table_column` VALUES (1751, 186, 'id', 'id', 'bigint unsigned', 'Long', 'id', '1', '1', '0', '1', '1', '1', '1', 'EQ', 'input', 1, 1, '2024-02-27 21:11:24', NULL, '2024-02-27 21:11:24');
INSERT INTO `gen_table_column` VALUES (1752, 186, 'nickname', '昵称', 'varchar(30)', 'String', 'nickname', '0', '0', '0', '1', '1', '1', '0', 'EQ', 'input', 2, 1, '2024-02-27 21:11:24', NULL, '2024-02-27 21:11:24');
INSERT INTO `gen_table_column` VALUES (1753, 186, 'username', '用户名', 'varchar(30)', 'String', 'username', '0', '0', '1', '1', '1', '1', '0', 'EQ', 'input', 3, 1, '2024-02-27 21:11:24', NULL, '2024-02-27 21:11:24');
INSERT INTO `gen_table_column` VALUES (1754, 186, 'password', '密码', 'varchar(80)', 'String', 'password', '0', '0', '1', '1', '1', '1', '0', 'EQ', 'input', 4, 1, '2024-02-27 21:11:24', NULL, '2024-02-27 21:11:24');
INSERT INTO `gen_table_column` VALUES (1755, 186, 'gender', '默认男', 'char(1)', 'String', 'gender', '0', '0', '1', '1', '1', '1', '0', 'EQ', 'input', 5, 1, '2024-02-27 21:11:24', NULL, '2024-02-27 21:11:24');
INSERT INTO `gen_table_column` VALUES (1756, 186, 'avatar', '头像', 'varchar(255)', 'String', 'avatar', '0', '0', '0', '1', '1', '1', '0', 'EQ', 'input', 6, 1, '2024-02-27 21:11:24', NULL, '2024-02-27 21:11:24');
INSERT INTO `gen_table_column` VALUES (1757, 186, 'mail', '邮箱', 'varchar(50)', 'String', 'mail', '0', '0', '0', '1', '1', '1', '0', 'EQ', 'input', 7, 1, '2024-02-27 21:11:24', NULL, '2024-02-27 21:11:24');
INSERT INTO `gen_table_column` VALUES (1758, 186, 'phone', '电话号码', 'varchar(11)', 'String', 'phone', '0', '0', '0', '1', '1', '1', '0', 'EQ', 'input', 8, 1, '2024-02-27 21:11:24', NULL, '2024-02-27 21:11:24');
INSERT INTO `gen_table_column` VALUES (1759, 186, 'signature', '个性签名', 'varchar(255)', 'String', 'signature', '0', '0', '0', '1', '1', '1', '0', 'EQ', 'input', 9, 1, '2024-02-27 21:11:24', NULL, '2024-02-27 21:11:24');
INSERT INTO `gen_table_column` VALUES (1760, 186, 'user_type', 'S 系统用户 C 普通用户', 'char(1)', 'String', 'userType', '0', '0', '1', '1', '1', '1', '0', 'EQ', 'input', 10, 1, '2024-02-27 21:11:24', NULL, '2024-02-27 21:11:24');
INSERT INTO `gen_table_column` VALUES (1761, 186, 'status', '1 启用 0 停用', 'tinyint(1)', 'Integer', 'status', '0', '0', '1', '1', '1', '1', '0', 'EQ', 'input', 11, 1, '2024-02-27 21:11:24', NULL, '2024-02-27 21:11:24');
INSERT INTO `gen_table_column` VALUES (1762, 186, 'create_by', '创建用户', 'bigint', 'Long', 'createBy', '0', '0', '1', '0', '0', '1', '0', 'EQ', 'input', 12, 1, '2024-02-27 21:11:24', NULL, '2024-02-27 21:11:24');
INSERT INTO `gen_table_column` VALUES (1763, 186, 'update_by', '更新用户', 'bigint', 'Long', 'updateBy', '0', '0', '1', '0', '0', '1', '0', 'EQ', 'input', 13, 1, '2024-02-27 21:11:24', NULL, '2024-02-27 21:11:24');
INSERT INTO `gen_table_column` VALUES (1764, 186, 'create_time', '创建时间', 'datetime', 'LocalDateTime', 'createTime', '0', '0', '1', '0', '0', '1', '0', 'EQ', 'datetime', 14, 1, '2024-02-27 21:11:24', NULL, '2024-02-27 21:11:24');
INSERT INTO `gen_table_column` VALUES (1765, 186, 'update_time', '更新时间', 'datetime', 'LocalDateTime', 'updateTime', '0', '0', '1', '0', '0', '1', '0', 'EQ', 'datetime', 15, 1, '2024-02-27 21:11:24', NULL, '2024-02-27 21:11:24');
INSERT INTO `gen_table_column` VALUES (1766, 187, 'id', 'id', 'bigint unsigned', 'Long', 'id', '1', '1', '0', '1', '1', '1', '1', 'EQ', 'input', 1, 1, '2024-02-27 21:11:24', NULL, '2024-02-27 21:11:24');
INSERT INTO `gen_table_column` VALUES (1767, 187, 'user_id', '用户id', 'bigint unsigned', 'Long', 'userId', '0', '0', '1', '1', '1', '1', '0', 'EQ', 'input', 2, 1, '2024-02-27 21:11:24', NULL, '2024-02-27 21:11:24');
INSERT INTO `gen_table_column` VALUES (1768, 187, 'role_id', '角色id', 'bigint unsigned', 'Long', 'roleId', '0', '0', '1', '1', '1', '1', '0', 'EQ', 'input', 3, 1, '2024-02-27 21:11:24', NULL, '2024-02-27 21:11:24');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `student_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '学生名称',
  `age` int(0) UNSIGNED NULL DEFAULT NULL COMMENT '年龄',
  `gender` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '性别',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (3, '王五', 18, '1', '2024-02-27 13:24:22', '2024-02-27 13:24:22');
INSERT INTO `student` VALUES (4, '王五22', 22, '2', '2024-02-27 13:45:58', '2024-02-27 13:45:58');

-- ----------------------------
-- Table structure for sys_logininfor
-- ----------------------------
DROP TABLE IF EXISTS `sys_logininfor`;
CREATE TABLE `sys_logininfor`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '访问ID',
  `user_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '用户账号',
  `ipaddr` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '登录IP地址',
  `login_location` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '登录地点',
  `browser` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '浏览器类型',
  `os` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '操作系统',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '登录状态（0成功 1失败）',
  `msg` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '提示消息',
  `login_time` datetime(0) NULL DEFAULT NULL COMMENT '访问时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_sys_logininfor_s`(`status`) USING BTREE,
  INDEX `idx_sys_logininfor_lt`(`login_time`) USING BTREE,
  INDEX `idx_sys_logininfor_u`(`user_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 238 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '系统访问记录' ROW_FORMAT = Dynamic;



-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`  (
  `id` bigint(0) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id',
  `parent_id` bigint(0) UNSIGNED NOT NULL COMMENT '父菜单id',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '组件名称',
  `menu_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '菜单名称',
  `icon` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '菜单图标',
  `path` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '路由',
  `component` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '组件位置',
  `aside` tinyint(1) NOT NULL DEFAULT 1 COMMENT '是否为侧边菜单',
  `menu_type` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT 'M' COMMENT 'M目录，C菜单，B按钮',
  `cache` tinyint(1) NOT NULL DEFAULT 0 COMMENT '0 不缓存组件 1 缓存',
  `status` tinyint(1) NOT NULL DEFAULT 1 COMMENT '状态',
  `params` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '路由参数',
  `purview` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT ' ' COMMENT '权限标识',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '注释',
  `order_menu` int(0) UNSIGNED NULL DEFAULT NULL COMMENT '排序字段',
  `create_by` bigint(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '添加人',
  `update_by` bigint(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '修改人',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 38 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '菜单表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES (1, 0, '', '系统设置', 'el-icon-s-tools', '/system', 'Layout', 1, 'M', 0, 1, NULL, '', NULL, 1, 1, 1, '2023-09-16 19:54:29', '2023-09-16 19:54:29');
INSERT INTO `sys_menu` VALUES (2, 0, '', '系统工具', 'el-icon-suitcase-1', '/tool', 'Layout', 1, 'M', 0, 1, NULL, '', NULL, 2, 1, 1, '2023-09-16 19:55:48', '2023-10-13 19:20:05');
INSERT INTO `sys_menu` VALUES (3, 1, 'SysUser', '用户管理', 'el-icon-user-solid', 'user', 'system/user', 1, 'C', 1, 1, NULL, 'system:user:view', '用户管理', 1, 1, 1, '2023-09-16 19:56:45', '2023-10-27 12:56:16');
INSERT INTO `sys_menu` VALUES (4, 1, 'Role', '角色管理', 'el-icon-s-custom', 'role', 'system/role', 1, 'C', 1, 1, NULL, 'system:role:view', '角色管理', 2, 1, 1, '2023-09-16 19:57:18', '2023-10-13 19:20:45');
INSERT INTO `sys_menu` VALUES (5, 1, 'Menu', '菜单管理', 'el-icon-s-order', 'menu', 'system/menu', 1, 'C', 1, 1, NULL, 'system:menu:view', '菜单管理', 3, 1, 1, '2023-09-16 19:57:53', '2023-09-16 19:57:53');
INSERT INTO `sys_menu` VALUES (6, 3, '', '用户修改', NULL, '#', NULL, 0, 'B', 0, 1, NULL, 'system:user:edit', '修改用户用户信息', 1, 1, 1, '2023-09-20 09:43:27', '2023-09-20 09:43:27');
INSERT INTO `sys_menu` VALUES (7, 3, '', '用户查询', NULL, '#', NULL, 0, 'B', 0, 1, NULL, 'system:user:list', NULL, 2, 1, 1, '2023-09-20 09:51:12', '2023-09-20 09:51:12');
INSERT INTO `sys_menu` VALUES (8, 3, '', '用户删除', NULL, '#', NULL, 0, 'B', 0, 1, NULL, 'system:user:del', NULL, 3, 1, 1, '2023-09-20 09:54:14', '2023-09-20 09:54:14');
INSERT INTO `sys_menu` VALUES (9, 3, '', '用户新增', NULL, '#', NULL, 0, 'B', 0, 1, NULL, 'system:user:add', NULL, 4, 1, 1, '2023-09-20 09:54:45', '2023-09-20 09:54:45');
INSERT INTO `sys_menu` VALUES (10, 3, '', '用户导出', NULL, '#', NULL, 0, 'B', 0, 1, NULL, 'system:user:export', NULL, 6, 1, 1, '2023-10-01 13:46:43', '2023-10-01 13:46:43');
INSERT INTO `sys_menu` VALUES (11, 3, '', '用户导入', NULL, '#', NULL, 0, 'B', 0, 1, NULL, 'system:user:import', NULL, 5, 1, 1, '2023-10-04 18:54:44', '2023-10-04 18:54:44');
INSERT INTO `sys_menu` VALUES (12, 5, '', '菜单新增', NULL, '#', NULL, 0, 'B', 0, 1, NULL, 'system:menu:add', '增加菜单', 1, 1, 1, '2023-09-20 14:22:56', '2023-09-20 14:22:56');
INSERT INTO `sys_menu` VALUES (13, 5, '', '菜单删除', NULL, '#', NULL, 0, 'B', 0, 1, NULL, 'system:menu:del', NULL, 2, 1, 1, '2023-09-20 14:23:50', '2023-09-20 14:23:50');
INSERT INTO `sys_menu` VALUES (14, 5, '', '菜单修改', NULL, '#', NULL, 0, 'B', 0, 1, NULL, 'system:menu:edit', '修改菜单', 3, 1, 1, '2023-09-20 14:24:44', '2023-09-20 14:24:44');
INSERT INTO `sys_menu` VALUES (15, 5, '', '菜单查询', NULL, '#', NULL, 0, 'B', 0, 1, NULL, 'system:menu:list', NULL, 4, 1, 1, '2023-09-20 14:28:00', '2023-09-20 14:28:00');
INSERT INTO `sys_menu` VALUES (16, 4, '', '角色修改', NULL, '#', NULL, 0, 'B', 0, 1, NULL, 'system:role:edit', NULL, 1, 1, 1, '2023-09-22 14:57:25', '2023-09-22 14:57:25');
INSERT INTO `sys_menu` VALUES (17, 4, '', '角色新增', NULL, '#', NULL, 0, 'B', 0, 1, NULL, 'system:role:add', NULL, 2, 1, 1, '2023-09-22 14:58:05', '2023-09-22 14:58:05');
INSERT INTO `sys_menu` VALUES (18, 4, '', '角色查询', NULL, '#', NULL, 0, 'B', 0, 1, NULL, 'system:role:list', NULL, 3, 1, 1, '2023-09-22 14:59:11', '2023-09-22 14:59:11');
INSERT INTO `sys_menu` VALUES (19, 4, '', '角色删除', NULL, '#', NULL, 0, 'B', 0, 1, NULL, 'system:role:del', NULL, 4, 1, 1, '2023-09-22 14:59:31', '2023-09-22 14:59:31');
INSERT INTO `sys_menu` VALUES (20, 1, '', '系统日志', 'el-icon-date', 'log', 'parentMenu', 1, 'M', 0, 1, NULL, '', '系统日志', NULL, 1, 1, '2023-10-15 12:51:03', '2023-10-15 16:33:36');
INSERT INTO `sys_menu` VALUES (21, 20, 'OperLog', '操作日志', 'el-icon-document', 'operLog', 'system/log/operLog', 1, 'C', 1, 1, NULL, 'system:oper:operLog', '操作日志', NULL, 1, 1, '2023-10-15 12:53:41', '2023-10-15 13:03:03');
INSERT INTO `sys_menu` VALUES (22, 21, '', '日志查询', '', '', '', 0, 'B', 0, 1, NULL, 'system:operLog:list', '日志查询权限', NULL, 1, 1, '2023-10-15 16:37:14', '2023-10-15 16:37:14');
INSERT INTO `sys_menu` VALUES (23, 20, 'Logininfor', '登录日志', 'el-icon-location-outline', 'logininfor', 'system/log/logininfor', 1, 'C', 1, 1, NULL, '', '登陆日志', NULL, 1, 1, '2023-10-15 18:37:00', '2023-10-16 20:38:26');
INSERT INTO `sys_menu` VALUES (24, 2, 'Markdown', 'markdown', 'el-icon-upload', 'markdown', 'tool/markdown/index', 1, 'C', 0, 1, NULL, 'aa', '富文本测试', 8, 1, 1, '2023-10-21 16:35:26', '2024-02-27 21:08:17');
INSERT INTO `sys_menu` VALUES (31, 2, 'Generator', '代码生成', 'el-icon-folder-remove', 'generator', 'tool/generator', 1, 'C', 0, 1, NULL, '', '代码生成', NULL, 1, 1, '2024-02-20 11:41:57', '2024-02-27 12:22:30');

-- ----------------------------
-- Table structure for sys_oper_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_oper_log`;
CREATE TABLE `sys_oper_log`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '日志主键',
  `title` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '模块标题',
  `business_type` int(0) NULL DEFAULT 0 COMMENT '业务类型（0其它 1新增 2修改 3删除）',
  `method` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '方法名称',
  `request_method` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '请求方式',
  `operator_type` int(0) NULL DEFAULT 0 COMMENT '操作类别（0其它 1后台用户 2手机端用户）',
  `oper_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '操作人员',
  `dept_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '部门名称',
  `oper_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '请求URL',
  `oper_ip` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '主机地址',
  `oper_location` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '操作地点',
  `oper_param` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '请求参数',
  `json_result` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '返回参数',
  `status` int(0) NULL DEFAULT 0 COMMENT '操作状态（1正常 0异常）',
  `error_msg` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '错误消息',
  `oper_time` datetime(0) NULL DEFAULT NULL COMMENT '操作时间',
  `cost_time` bigint(0) NULL DEFAULT 0 COMMENT '消耗时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_sys_oper_log_bt`(`business_type`) USING BTREE,
  INDEX `idx_sys_oper_log_s`(`status`) USING BTREE,
  INDEX `idx_sys_oper_log_ot`(`oper_time`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 169 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '操作日志记录' ROW_FORMAT = Dynamic;


-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `id` bigint(0) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '角色名称',
  `key` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT 'common' COMMENT '角色标识',
  `status` tinyint(1) NOT NULL DEFAULT 1 COMMENT '0 停用 ',
  `create_by` bigint(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '创建者',
  `update_by` bigint(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '修改者',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `idx_name_key`(`name`, `key`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '角色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (1, '管理员', 'admin', 1, 1, 1, '2023-09-12 17:51:19', '2023-10-12 12:50:58');
INSERT INTO `sys_role` VALUES (2, '普通用户', 'common', 1, 1, 1, '2023-09-12 17:52:53', '2023-10-17 09:57:11');
INSERT INTO `sys_role` VALUES (3, '注册用户', 'register', 1, 1, 1, '2023-10-14 12:40:24', '2024-02-20 11:18:16');

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu`  (
  `id` bigint(0) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `role_id` bigint(0) UNSIGNED NOT NULL COMMENT '角色id',
  `menu_id` bigint(0) UNSIGNED NOT NULL COMMENT '菜单id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 50 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '角色菜单关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES (9, 3, 2);
INSERT INTO `sys_role_menu` VALUES (42, 2, 1);
INSERT INTO `sys_role_menu` VALUES (43, 2, 18);
INSERT INTO `sys_role_menu` VALUES (44, 2, 2);
INSERT INTO `sys_role_menu` VALUES (45, 2, 3);
INSERT INTO `sys_role_menu` VALUES (46, 2, 4);
INSERT INTO `sys_role_menu` VALUES (47, 2, 5);
INSERT INTO `sys_role_menu` VALUES (48, 2, 7);
INSERT INTO `sys_role_menu` VALUES (49, 2, 15);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` bigint(0) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id',
  `nickname` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '昵称',
  `username` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(80) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '密码',
  `gender` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '男' COMMENT '默认男',
  `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '头像',
  `mail` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '电话号码',
  `signature` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '个性签名',
  `user_type` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT 'C' COMMENT 'S 系统用户 C 普通用户',
  `status` tinyint(1) NOT NULL DEFAULT 1 COMMENT '1 启用 0 停用',
  `create_by` bigint(0) NOT NULL DEFAULT 0 COMMENT '创建用户',
  `update_by` bigint(0) NOT NULL DEFAULT 0 COMMENT '更新用户',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `username`(`username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, '管理员', 'admin', '$2a$10$yDYwXgWun6m5LkA515JmCujDlMHgZydaN/.Rs32MQThLeHkDoTVJy', '男', 'http://localhost:8080/file/f097b335-ffa6-4646-b33f-ffc43e49887c.jpg', '', '', NULL, 'S', 1, 1, 1, '2023-09-06 19:40:45', '2024-02-20 11:29:59');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`  (
  `id` bigint(0) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` bigint(0) UNSIGNED NOT NULL COMMENT '用户id',
  `role_id` bigint(0) UNSIGNED NOT NULL COMMENT '角色id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户角色关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES (19, 11, 2);
INSERT INTO `sys_user_role` VALUES (20, 13, 2);

SET FOREIGN_KEY_CHECKS = 1;
