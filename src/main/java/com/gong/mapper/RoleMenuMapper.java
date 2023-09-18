package com.gong.mapper;

import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface RoleMenuMapper {

    List<Integer> selectMenuIdByRoleId(Integer roleId);

}
