package com.gong.mapper;

import com.gong.entity.SysRole;
import com.gong.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;

@Mapper
public interface SysUserMapper {

    int count();

    int insertBatch(List<SysUser> sysUserList);

    int insertOne(SysUser sysUser);

    int deleteById(Long id);

    int deleteByIds(List<Long> ids);

    SysUser selectById(Long id);

    SysUser selectByUserName(String username);

    List<SysUser> selectList(SysUser sysUser);

    int updateById(SysUser sysUser);

    List<SysRole> selectRoleByUserId(Long userId);
}
