package com.gong.service;

import com.gong.entity.SysRoleMenu;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface SysRoleMenuService {

    SysRoleMenu getByRoleId(Long roleId);

    List<SysRoleMenu> getList(SysRoleMenu sysRoleMenu);

    int saveOne(SysRoleMenu sysRoleMenu);

    int saveBatch(List<SysRoleMenu> sysRoleMenus);

    int updateSysRoleMenuByRoleId(SysRoleMenu sysRoleMenu);

    int removeByRoleId(Long roleId);

    int removeByRoleIds(List<Long> roleIds);

}
