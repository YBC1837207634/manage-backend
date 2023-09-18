package com.gong.service;

import com.gong.dto.MenuDTO;
import com.gong.entity.Pages;
import com.gong.entity.Route;
import com.gong.entity.SysMenu;
import com.gong.entity.User;

import java.util.List;

public interface SysMenuService {
    List<Route> getRouter(List<String> types);

    List<Route> getRouter(List<String> types, List<Integer> ids);

    List<Route> getChildrenList(List<SysMenu> menus, long parent);

    List<SysMenu> list();

    SysMenu getOne(int id);

    int count();

    Pages<SysMenu> pages(int page, int pageSize);

    int saveOne(MenuDTO menu);

    void remove(int id, boolean isCatalog);
}
