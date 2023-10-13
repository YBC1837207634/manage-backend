package com.gong.controller;

import com.gong.common.ResponseStatus;
import com.gong.service.SysMenuService;
import com.gong.vo.MenuItem;
import com.gong.vo.MenuSelect;
import com.gong.vo.Result;
import com.gong.entity.SysMenu;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/system/menu")
public class SysMenuController {

    private SysMenuService sysMenuService;

    public SysMenuController(SysMenuService sysMenuService) {
        this.sysMenuService = sysMenuService;
    }

    /**
     * 添加菜单
     * @param menu
     * @return
     */
    @PostMapping
    @PreAuthorize("@s.hasAuthority('system:menu:add')")
    Result<String> save(@RequestBody @Validated SysMenu menu) {
        if (sysMenuService.saveOne(menu) != 0) {
            return Result.success("添加成功！");
        }
        return Result.error(ResponseStatus.NOT_MODIFY, "添加失败");
    }

    @PutMapping
    @PreAuthorize("@s.hasAuthority('system:menu:edit')")
    Result<String> update(@RequestBody @Validated SysMenu menu) {
        if (sysMenuService.updateSysMenuById(menu) != 0) {
            return Result.success("更新成功！");
        }
        return Result.error(ResponseStatus.NOT_MODIFY, "更新失败");
    }

    /**
     * 菜单列表
     * @return
     */
    @GetMapping("/list")
    @PreAuthorize("@s.hasAuthority('system:menu:list')")
    Result<List<SysMenu>> list() {
        return Result.success(sysMenuService.getList(null));
    }

    /**
     * 根据用户id获取菜单树
     * @param id
     * @return
     */
    @GetMapping("/menuTreeSelect/{id}")
    @PreAuthorize("@s.hasAuthority('system:menu:list')")
    Result<MenuSelect> menuTreeSelect(@PathVariable("id") long id) {
        List<MenuItem> menuTree = sysMenuService.getMenuTree();
        List<SysMenu> menuList = sysMenuService.getMenuListByUserId(id);
        List<Long> longs = menuList.stream().map(SysMenu::getId).toList();
        return Result.success(new MenuSelect(menuTree, longs));
    }

    /**
     * 获取菜单树
     */
    @GetMapping("/menuTree")
    Result<List<MenuItem>> menuTree() {
        List<MenuItem> menuTree = sysMenuService.getMenuTree();
        return Result.success(menuTree);
    }

    /**
     * 根据菜单id获取菜单信息
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    @PreAuthorize("@s.hasAuthority('system:menu:list')")
    Result<SysMenu> userMenuList(@PathVariable("id") long id) {
        return Result.success(sysMenuService.getById(id));
    }

    /**
     * 删除菜单
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    @PreAuthorize("@s.hasAuthority('system:menu:del')")
    Result<String> remove(@PathVariable("id") long id) {
        sysMenuService.removeById(id);
        return Result.success("删除成功");
    }

}
