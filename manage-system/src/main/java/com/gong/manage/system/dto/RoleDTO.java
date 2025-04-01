package com.gong.manage.system.dto;

import com.gong.manage.system.entity.SysRole;

import java.util.Set;

public class RoleDTO extends SysRole {
    // 存放分配的菜单id
    private Set<Long> menuAssignment;

    public Set<Long> getMenuAssignment() {
        return menuAssignment;
    }

    public void setMenuAssignment(Set<Long> menuAssignment) {
        this.menuAssignment = menuAssignment;
    }
}
