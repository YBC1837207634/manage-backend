package com.gong.entity;


import lombok.Data;

/**
 * 角色和菜单关联表
 */
@Data
public class RoleMenu {
    private Integer id;
    private Integer roleId;
    private Integer menuId;
}
