package com.gong.service.impl;

import com.gong.entity.Role;
import com.gong.mapper.RoleMapper;
import com.gong.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public Role getByName(String name) {
        return roleMapper.selectByName(name);
    }
}
