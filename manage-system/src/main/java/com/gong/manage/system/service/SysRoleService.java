package com.gong.manage.system.service;

import com.gong.manage.system.entity.SysRole;
import com.gong.manage.system.dto.RoleDTO;

import java.util.List;

public interface SysRoleService {

    SysRole getById(Long id);

    List<SysRole> getList(SysRole sysRole);

    void saveRoleAndMenu(RoleDTO roleDTO);

    int saveOne(SysRole sysRole);

    int saveBatch(List<SysRole> sysRoles);

    int updateSysRoleById(SysRole sysRole);

    int removeByIds(List<Long> ids);

    int updateRoleAndMenu(RoleDTO roleDTO);

}
