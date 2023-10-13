package com.gong.service;

import com.gong.entity.SysUserRole;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface SysUserRoleService {

    List<SysUserRole> getList(SysUserRole sysUserRole);

    int saveOne(SysUserRole sysUserRole);

    int saveBatch(List<SysUserRole> sysUserRoles);

    int updateSysUserRoleByUserId(SysUserRole sysUserRole);

    int removeByUserId(Long userId);

    int removeByUserIds(List<Long> userIds);

}
