package com.gong.manage.system.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysRoleMenu implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /* 自增id */
    private Long id;
    /* 角色id */
    private Long roleId;
    /* 菜单id */
    private Long menuId;
}
