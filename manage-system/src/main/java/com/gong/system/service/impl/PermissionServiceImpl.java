package com.gong.system.service.impl;

import com.gong.system.entity.dto.CustomUserDetails;
import com.gong.system.service.PermissionService;
import com.gong.system.utils.CustomUserDetailsUtils;
import org.springframework.stereotype.Service;


@Service("s")
public class PermissionServiceImpl implements PermissionService {
    @Override
    public boolean hasAuthority(String authority) {
        // 判断是否是管理员，如果是直接通过权限验证。;
        if (CustomUserDetailsUtils.isAdmin()) {
            return true;
        }
        CustomUserDetails userDetails = CustomUserDetailsUtils.getCustomUserDetails();
        // 如果不是管理员就查看是否具有访问的权限标识符
        return userDetails.getAuthorityList().contains(authority);
    }
}
