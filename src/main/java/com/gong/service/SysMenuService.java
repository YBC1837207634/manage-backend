package com.gong.service;

import com.gong.entity.Route;
import com.gong.entity.SysMenu;

import java.util.List;

public interface SysMenuService {

    List<SysMenu> getByPower(String power);

    List<Route> getChildrenList(List<SysMenu> menus, long parent);

}
