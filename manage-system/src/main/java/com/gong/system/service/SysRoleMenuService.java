package com.gong.system.service;

import com.gong.system.entity.SysRoleMenu;

import java.util.List;


public interface SysRoleMenuService {

    SysRoleMenu getByRoleId(Long roleId);

    List<SysRoleMenu> getList(SysRoleMenu sysRoleMenu);

    int saveOne(SysRoleMenu sysRoleMenu);

    int saveBatch(List<SysRoleMenu> sysRoleMenus);

    int updateSysRoleMenuByRoleId(SysRoleMenu sysRoleMenu);

    int removeByRoleId(Long roleId);

    int removeByRoleIds(List<Long> roleIds);

}
