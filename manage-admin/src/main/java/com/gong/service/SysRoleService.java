package com.gong.service;

import com.gong.dto.RoleDTO;
import com.gong.entity.SysRole;

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
