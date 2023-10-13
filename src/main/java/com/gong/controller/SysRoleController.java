package com.gong.controller;

import com.github.pagehelper.PageInfo;
import com.gong.dto.RoleDTO;
import com.gong.entity.SysRole;
import com.gong.service.SysRoleService;
import com.gong.vo.Pages;
import com.gong.vo.Result;
import com.gong.utils.CustomUserDetailsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("system/role")
public class SysRoleController {

    @Autowired
    private SysRoleService sysRoleService;

    /**
     * 修改角色信息，包括角色的菜单
     * @param roleDTO
     * @return
     */
    @PutMapping
    @PreAuthorize("@s.hasAuthority('system:role:edit')")
    Result<String> update(@RequestBody RoleDTO roleDTO) {
        roleDTO.setUpdateBy(CustomUserDetailsUtils.getId());
        sysRoleService.updateRoleAndMenu(roleDTO);
        return Result.success("修改成功");
    }

    /**
     * 角色列表
     * @return
     */
    @GetMapping("/list")
    @PreAuthorize("@s.hasAuthority('system:role:list')")
    Result<Pages<SysRole>> list(SysRole role) {
        List<SysRole> list = sysRoleService.getList(role);
        PageInfo<SysRole> pageInfo = new PageInfo<>(list);
        return Result.success(new Pages<>(pageInfo.getTotal(), list.size(), pageInfo.getPageNum(), pageInfo.getPageSize(), list));
    }

    /**
     * 根据id返回对应角色
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    @PreAuthorize("@s.hasAuthority('system:role:list')")
    Result<SysRole> getOne(@PathVariable("id") long id) {
        return Result.success(sysRoleService.getById(id));
    }

    /**
     * /system/role
     * 添加一个角色
     * @param role
     * @return
     */
    @PostMapping
    @PreAuthorize("@s.hasAuthority('system:role:add')")
    Result<String> save(@RequestBody RoleDTO role) {
        sysRoleService.saveRoleAndMenu(role);
        return Result.success("添加成功！");
    }

    /**
     * /system/role/5
     * @param ids
     * @return
     */
    @DeleteMapping("/{ids}")
    @PreAuthorize("@s.hasAuthority('system:role:del')")
    Result<String> remove(@PathVariable("ids") List<Long> ids) {
        sysRoleService.removeByIds(ids);
        return Result.success("删除成功");
    }

}
