package com.gong.service.impl;

import com.gong.dto.CustomUserDetails;
import com.gong.dto.LoginForm;
import com.gong.dto.SysUserDTO;
import com.gong.entity.SysUser;
import com.gong.exception.ExistException;
import com.gong.mapper.SysUserMapper;
import com.gong.service.LoginService;
import com.gong.utils.JWTUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Objects;

@Service
public class LoginServiceImpl implements LoginService, UserDetailsService {

    private SysUserMapper sysUserMapper;

    private PasswordEncoder passwordEncoder;

    private AuthenticationManager authenticationManager;

    public LoginServiceImpl(SysUserMapper sysUserMapper, PasswordEncoder passwordEncoder, @Lazy AuthenticationManager authenticationManager) {
        this.sysUserMapper = sysUserMapper;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }

    /**
     * 密码校验
     */
    @Override
    public String login(String username, String password) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password);
        // 进行用户名和密码的认证，
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
        // 如果成功就返回一个认证成功的 Authentication
        if (authenticate.isAuthenticated()) {
            CustomUserDetails details = (CustomUserDetails) authenticate.getPrincipal();
            String id = details.getSysUserDTO().getId().toString();
            return JWTUtils.createToken(id);
        }
        return null;
    }

    /**
     * 注册账号
     * @param form
     * @return
     */
    @Override
    public int register(LoginForm form) {
        if (StringUtils.hasText(form.getUsername())
                && StringUtils.hasText(form.getPassword())
                && form.getUsername().length() <= 30
                && form.getPassword().length() <= 30 ) {
            // 根据用户名查询用户
            SysUser query = new SysUser();
            query.setUsername(form.getUsername());
            List<SysUser> res = sysUserMapper.selectList(query);
            if (!Objects.isNull(res) && !res.isEmpty()) throw new ExistException("用户已存在");
            // 不存在就注册
            SysUser sysUser = new SysUser();
            sysUser.setUsername(form.getUsername());
            sysUser.setPassword(passwordEncoder.encode(form.getPassword()));
            sysUser.setUserType("R"); // 注册用户
            // 默认的昵称就是用户名
            sysUser.setNickname(form.getUsername());
            return sysUserMapper.insertOne(sysUser);
        }
        return 0;
    }

    /**
     * 用于 Security 的用户名密码认证
     */
    @Override
    public UserDetails loadUserByUsername(String username) {
        // 根据用户名查询用户
        SysUser query = new SysUser();
        query.setUsername(username);
        List<SysUser> res = sysUserMapper.selectList(query);
        if (Objects.isNull(res) || res.isEmpty()) {
            throw new RuntimeException("账号不存在");
        }
        SysUser sysUser = res.get(0);
        SysUserDTO sysUserDTO = new SysUserDTO();
        BeanUtils.copyProperties(sysUser, sysUserDTO, "roles");
        return new CustomUserDetails(sysUserDTO, null);
    }

}
