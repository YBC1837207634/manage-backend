package com.gong.service.impl;

import com.gong.common.BaseContent;
import com.gong.dto.MenuDTO;
import com.gong.entity.*;
import com.gong.mapper.SysMenuMapper;
import com.gong.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class SysMenuServiceImpl implements SysMenuService {

    @Autowired
    private SysMenuMapper sysMenuMapper;


    @Override
    public int count() {
        return sysMenuMapper.count();
    }

    /**
     * 分页查询
     * @param page
     * @param pageSize
     * @return
     */
    @Override
    public Pages<SysMenu> pages(int page, int pageSize) {
        List<SysMenu> limit = sysMenuMapper.limit((page - 1) * pageSize, pageSize);
        int total = sysMenuMapper.count();
        return new Pages<>(total, limit.size(), page, pageSize, limit);
    }

    @Override
    public SysMenu getOne(int id) {
        return sysMenuMapper.selectById(id);
    }

    /**
     * 根据类型、id来选择目录、菜单、按钮，
     * @param types  类型
     * @param ids 所要选择菜单的id
     * @return
     */
    @Override
    public List<Route> getRouter(List<String> types, List<Integer> ids) {
        List<SysMenu> sysMenus = sysMenuMapper.selectByTypeAndId(types, ids);
        return getChildrenList(sysMenus, 0);
    }

    public List<Route> getRouter(List<String> types) {
        List<SysMenu> sysMenus = sysMenuMapper.selectByType(types);
        return getChildrenList(sysMenus, 0);
    }

    /**
     * 传入菜单，递归查找子菜单并返回 Route 列表
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
                if (!menu.getMenuType().equals("B")) meta.setAside(true);
                // 配置路由信息
                route.setPath(menu.getPath());
                if (StringUtils.hasText(menu.getComponent())) {
                    route.setComponent(menu.getComponent());
                } else {
                    route.setComponent("Layout");
                }
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

    @Override
    public List<SysMenu> list() {
        return sysMenuMapper.selectList();
    }

    /**
     * 插入一个菜单
     * @param menu
     * @return
     */
    @Override
    public int saveOne(MenuDTO menu) {

        menu.setCreateBy(BaseContent.getId());
        menu.setUpdateBy(BaseContent.getId());
        return sysMenuMapper.insert(menu);
    }

    /**
     * 根据id删除菜单，如果删除的类型是目录则整个下级菜单也一并删除
     * @param id
     * @return
     */
    @Override
    @Transactional
    public void remove(int id, boolean isCatalog) {
        sysMenuMapper.delete(id);
        if (isCatalog) {
            sysMenuMapper.deleteByParent(id);
        }
    }
}
