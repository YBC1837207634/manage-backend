package com.gong.mapper;

import com.gong.entity.SysMenu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysMenuMapper {

    SysMenu selectById(int id);

    List<SysMenu> selectByPower(String power);
}
