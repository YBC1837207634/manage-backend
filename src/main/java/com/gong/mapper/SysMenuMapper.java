package com.gong.mapper;

import com.gong.dto.MenuDTO;
import com.gong.entity.SysMenu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface SysMenuMapper {

    SysMenu selectById(int id);

    List<SysMenu> selectList();

    List<SysMenu> selectByType(List<String> menuTypes);

    List<SysMenu> selectByTypeAndId(List<String> menuTypes, List<Integer> menuIds);

    List<SysMenu> limit(int start, int total);

    @Select("select count(*) from sys_menu")
    int count();

    int insert(MenuDTO menu);

    int delete(int id);

    int deleteByParent(int parentId);

}
