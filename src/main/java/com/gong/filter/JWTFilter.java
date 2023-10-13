package com.gong.filter;

import com.auth0.jwt.interfaces.Claim;
import com.gong.dto.SysUserDTO;
import com.gong.dto.CustomUserDetails;
import com.gong.entity.SysRole;
import com.gong.entity.SysUser;
import com.gong.exception.TokenException;
import com.gong.handler.TokenExceptionHandler;
import com.gong.service.SysRoleService;
import com.gong.service.SysUserService;
import com.gong.utils.CustomUserDetailsUtils;
import com.gong.utils.JWTUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * JWT 验证
 */
@Slf4j
@Component
public class JWTFilter extends OncePerRequestFilter {

    private SysUserService sysUserService;

    private SysRoleService sysRoleService;

    @Autowired
    public void setUserMapper(SysUserService sysUserService) {
        this.sysUserService = sysUserService;
    }

    @Autowired
    public void setSysRoleService(SysRoleService sysRoleService) {
        this.sysRoleService = sysRoleService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader("token");
        if (request.getRequestURI().contains("/login")
                || request.getRequestURI().contains("/register")
                || request.getRequestURI().contains("/file")) {
            filterChain.doFilter(request,response);
            return;
        }
        if (StringUtils.hasText(token)) {
            Map<String, Claim> claimMap = JWTUtils.verifyToken(token);;
            if (Objects.isNull(claimMap)) {
                TokenExceptionHandler.commence(request, response, new TokenException("token无效"));
                return;
            }
            // 查找数据库
            String userId = claimMap.get("userId").asString();
            SysUser user = sysUserService.getById(Long.valueOf(userId));
            if (Objects.isNull(user) || user.getStatus() == 0) {
                TokenExceptionHandler.commence(request, response, new TokenException("token失效"));
                return;
            }
            // 获取角色列表
            List<SysRole> roles = sysUserService.getSysRoleByUserId(user.getId());
            SysUserDTO userDTO = new SysUserDTO();
            BeanUtils.copyProperties(user,userDTO,"roles");
            // 是否是管理员
            for (SysRole role: roles) {
                if (role.getKey().equals("admin")) {
                    userDTO.setAdmin(true);
                    break;
                }
            }
            List<String> purview = new ArrayList<>();
            if (userDTO.isAdmin()) {
                purview.add("*:*:*");
            } else {
                // 不是管理员得到用户所对应的权限标识符列表
                purview = sysUserService.getPurviewByUserId(user.getId());
            }
            userDTO.setRoles(roles);
            userDTO.setPurview(purview);
            // 创建一个 userDetails 存放到凭证中，用于后续使用
            CustomUserDetails userDetails = new CustomUserDetails(userDTO, purview);
            // 创建认证凭证 将凭证设置到 SecurityContext 中去，凭借该凭证通过后续的过滤链不需要再进行登陆验证
            CustomUserDetailsUtils.setCustomUserDetails(userDetails);
            filterChain.doFilter(request,response);
        } else {
            // 没有携带token
            TokenExceptionHandler.commence(request, response, new TokenException("未携带令牌"));
        }
    }
}
