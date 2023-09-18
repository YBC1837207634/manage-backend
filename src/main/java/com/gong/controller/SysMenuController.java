package com.gong.controller;

import com.gong.common.ResponseStatus;
import com.gong.dto.MenuDTO;
import com.gong.entity.Result;
import com.gong.entity.SysMenu;
import com.gong.service.SysMenuService;
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
    Result<String> save(@RequestBody @Validated MenuDTO menu ) {

        if (sysMenuService.saveOne(menu) != 0) {
            return Result.success("添加成功！");
        }
        return Result.error(ResponseStatus.NOT_MODIFY, "添加失败");
    }

    /**
     * 菜单列表
     * @return
     */
    @GetMapping("/list")
    Result<List<SysMenu>> list() {
        return Result.success(sysMenuService.list());
    }

    @DeleteMapping("/{id}")
    Result<String> remove(@PathVariable("id") int id) {
        SysMenu one = sysMenuService.getOne(id);
        sysMenuService.remove(id, one.getMenuType().equals("M"));
        return Result.success("删除成功");
    }

}
