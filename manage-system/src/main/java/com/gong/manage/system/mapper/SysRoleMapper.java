package com.gong.manage.system.mapper;

import com.gong.manage.system.entity.SysRole;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysRoleMapper {

    int insertBatch(List<SysRole> sysRoleList);

    int insertOne(SysRole sysRole);

    int deleteById(Long id);

    int deleteByIds(List<Long> ids);

    SysRole selectById(Long id);

    List<SysRole> selectList(SysRole sysRole);

    int updateById(SysRole sysRole);
}
