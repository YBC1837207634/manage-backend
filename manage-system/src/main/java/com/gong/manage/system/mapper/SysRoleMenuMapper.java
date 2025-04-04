package com.gong.manage.system.mapper;

import com.gong.manage.system.entity.SysRoleMenu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysRoleMenuMapper {

    int insertBatch(List<SysRoleMenu> sysRoleMenuList);

    int insertOne(SysRoleMenu sysRoleMenu);

    int deleteByMenuId(Long menuId);

    int deleteByRoleId(Long roleId);

    int deleteByRoleIds(List<Long> roleIds);

    List<SysRoleMenu> selectList(SysRoleMenu sysRoleMenu);

    SysRoleMenu selectByRoleId(Long roleId);

    int updateByRoleId(SysRoleMenu sysRoleMenu);
}
