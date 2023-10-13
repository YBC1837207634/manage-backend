package com.gong.service.impl;

import com.gong.dto.CustomUserDetails;
import com.gong.service.PermissionService;
import com.gong.utils.CustomUserDetailsUtils;
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
