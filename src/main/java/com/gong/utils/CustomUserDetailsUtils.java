package com.gong.utils;

import com.gong.dto.CustomUserDetails;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import java.util.List;

/**
 *  UserDetailsUtils
 */
public class CustomUserDetailsUtils {

    /**
     * 从 SecurityContext 中的 Authentication 里获取到用户信息
     * @return
     */
    public static CustomUserDetails getCustomUserDetails() {
        return (CustomUserDetails) SecurityUtils.getUserDetails();
    }

    /**
     * 将用户信息存放到Authentication中然后将生成的Authentication存入SecurityContext
     * @param userDetails
     */
    public static void setCustomUserDetails(CustomUserDetails userDetails) {
        UsernamePasswordAuthenticationToken token =
                new UsernamePasswordAuthenticationToken(userDetails, null, null);
        SecurityUtils.setAuthentication(token);
    }

    /**
     * 获取用户id
     * @return
     */
    public static Long getId() {
        return CustomUserDetailsUtils.getCustomUserDetails().getSysUserDTO().getId();
    }

    /**
     * 是否是管理员
     * @return
     */
    public static boolean isAdmin() {
        CustomUserDetails userDetails = CustomUserDetailsUtils.getCustomUserDetails();
        return userDetails.isAdmin();
    }

}
