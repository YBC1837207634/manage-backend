package com.gong.service.impl;


import com.gong.mapper.RoleMenuMapper;
import com.gong.service.RoleMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleMenuServiceImpl implements RoleMenuService {

    @Autowired
    private RoleMenuMapper roleMenuMapper;

    @Override
    public List<Integer> getMenuIdByRoleId(int roleId) {
        return roleMenuMapper.selectMenuIdByRoleId(roleId);
    }



}
