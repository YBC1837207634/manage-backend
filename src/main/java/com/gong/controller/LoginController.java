package com.gong.controller;

import com.gong.enums.BusinessType;
import com.gong.annotation.Log;
import com.gong.common.ResponseStatus;
import com.gong.dto.LoginForm;
import com.gong.dto.SysUserDTO;
import com.gong.service.SysMenuService;
import com.gong.vo.AuthResult;
import com.gong.vo.Result;
import com.gong.vo.Route;
import com.gong.service.LoginService;
import com.gong.utils.CustomUserDetailsUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LoginController {

    private LoginService loginService;

    private SysMenuService sysMenuService;

    public LoginController(LoginService loginService, SysMenuService sysMenuService) {
        this.loginService = loginService;
        this.sysMenuService = sysMenuService;
    }

    /**
     * /login 登录接口
     * @param from
     * @return
     */
    @PostMapping("/login")
    public AuthResult login(@RequestBody LoginForm from) {
        String token = loginService.login(from.getUsername(), from.getPassword());
        if (token != null) {
            return AuthResult.success("登陆成功！",token);
        }
        return AuthResult.error(ResponseStatus.INTERNAL, "用户名或密码错误");
    }

    /**
     * /register 注册
     */
    @Log(title = "注册",businessType = BusinessType.INSERT)
    @PostMapping("/register")
    public Result<String> register(@RequestBody LoginForm from) {
        if (loginService.register(from)) {
            return Result.success("注册成功！");
        }
        return Result.error(ResponseStatus.WARN,"注册失败");
    }

    /**
     * /getInfo 返回当前登录的用户信息
     * @return
     */
    @GetMapping("/getInfo")
    public Result<SysUserDTO> getInfo() {
        return Result.success(CustomUserDetailsUtils.getCustomUserDetails().getSysUserDTO());
    }

    /**
     * 获取当前用户的路由
     */
    @GetMapping("/getRouter")
    public Result<List<Route>> getRouter() {
        if (CustomUserDetailsUtils.isAdmin()) {
            return Result.success(sysMenuService.getRouter(null));
        }
        Long id = CustomUserDetailsUtils.getId();
        return Result.success(sysMenuService.getRouter(id));
    }


}
