package com.gong.service.impl;

import com.gong.entity.Meta;
import com.gong.entity.Route;
import com.gong.entity.SysMenu;
import com.gong.mapper.SysMenuMapper;
import com.gong.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SysMenuServiceImpl implements SysMenuService {

    @Autowired
    private SysMenuMapper sysMenuMapper;

    /**
     * 根据用户权限查询
     * @param power
     * @return
     */
    @Override
    public List<SysMenu> getByPower(String power) {
        return sysMenuMapper.selectByPower(power);
    }


    /**
     * 返回权限菜单路由
     * @param menus
     * @param parentId
     * @return
     */
    @Override
    public List<Route> getChildrenList(List<SysMenu> menus, long parentId) {
        List<Route> routes = new ArrayList<>();
        for (SysMenu menu : menus) {
            if (menu.getParentId() == parentId) {
                Route route = new Route();
                // 路由元信息
                Meta meta = new Meta();
                meta.setIcon(menu.getIcon());
                meta.setTitle(menu.getMenuName());
                meta.setCache(menu.getCache());
                // 配置路由信息
                route.setPath(menu.getPath());
                route.setComponent(menu.getComponent());
                route.setName(menu.getPath().toUpperCase());
                // 如果是目录则不可被点击
                if (menu.getMenuType().equals("M")) route.setRedirect("noRedirect");
                route.setMeta(meta);
                // 递归遍历查找是否还有子路由
                List<Route> children = getChildrenList(menus, menu.getId());
                // 如果有就存到当前路由中
                if(children.size() > 0) route.setChildren(children);
                // 将当前路有存入列表
                routes.add(route);
            }
        }
        return routes;
    }
}
