package com.gong.mapper;


import com.gong.entity.Role;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RoleMapper {

    Role selectByName(String name);


}
