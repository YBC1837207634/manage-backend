package com.gong.Interceptor;

import com.alibaba.fastjson2.JSON;
import com.auth0.jwt.interfaces.Claim;
import com.gong.common.ResponseStatus;
import com.gong.entity.AuthResult;
import com.gong.common.BaseContent;
import com.gong.entity.Role;
import com.gong.entity.User;
import com.gong.service.RoleService;
import com.gong.service.UserService;
import com.gong.utils.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * 登陆验证
 */
@Component
public class JWTInterceptor implements HandlerInterceptor {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        if (StringUtils.hasText(token)) {
            Map<String, Claim> claimMap = JWTUtils.verifyToken(token);
            if (claimMap != null) {
                // 判断jwt所对应的用户是否还在数据库中
                User user = userService.getById(claimMap.get("userId").asInt());
                // 能够找到用户
                if (user != null && user.getStatus() == 1) {
                    BaseContent.setId(user.getId());        // 保存 id
                    Role role = roleService.getByName(user.getRole());
                    if (role != null && user.getStatus() == 1) BaseContent.setPower(role.getPower());    // 用户的权限
                    return true;
                }
            }
        }
        // 防止中文乱码
        response.setHeader("content-type","application/json;charset=utf-8");
        AuthResult result = AuthResult.error(ResponseStatus.UNAUTHORIZED, request.getRequestURI() +",认证失败，无法访问系统资源");
        response.getWriter().println(JSON.toJSONString(result));
        return false;
    }

}
