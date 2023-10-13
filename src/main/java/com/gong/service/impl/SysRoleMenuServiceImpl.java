package com.gong.service.impl;

import com.gong.entity.SysRoleMenu;
import com.gong.mapper.SysRoleMenuMapper;
import com.gong.service.SysRoleMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysRoleMenuServiceImpl implements SysRoleMenuService {

    @Autowired
    private SysRoleMenuMapper sysRoleMenuMapper;

    @Override
    public SysRoleMenu getByRoleId(Long roleId) {
        return sysRoleMenuMapper.selectByRoleId(roleId);
    }

    @Override
    public List<SysRoleMenu> getList(SysRoleMenu sysRoleMenu) {
        return sysRoleMenuMapper.selectList(sysRoleMenu);
    }

    @Override
    public int saveOne(SysRoleMenu sysRoleMenu) {
        return sysRoleMenuMapper.insertOne(sysRoleMenu);
    }

    @Override
    public int saveBatch(List<SysRoleMenu> sysRoleMenu) {
        return sysRoleMenuMapper.insertBatch(sysRoleMenu);
    }

    @Override
    public int updateSysRoleMenuByRoleId(SysRoleMenu sysRoleMenu) {
        return sysRoleMenuMapper.updateByRoleId(sysRoleMenu);
    }

    @Override
    public int removeByRoleId(Long roleId) {
        return sysRoleMenuMapper.deleteByRoleId(roleId);
    }

    @Override
    public int removeByRoleIds(List<Long> roleIds) {
        return sysRoleMenuMapper.deleteByRoleIds(roleIds);
    }
}
