package com.gong.controller;

import com.gong.common.BaseContent;
import com.gong.common.ResponseStatus;
import com.gong.entity.*;
import com.gong.service.UserService;
import com.gong.utils.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    private UserService userService;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    /**
     * /login 登录接口
     * @param from
     * @return
     */
    @PostMapping("/login")
    public AuthResult login(@RequestBody LoginFrom from) {

        User u = userService.isLogin(from.getUsername(), from.getPassword());
        if (u == null) {
            return AuthResult.error(ResponseStatus.WARN, "登陆失败：账号或密码错误！");
        } else if (u.getStatus() != 1) {
            return AuthResult.error(ResponseStatus.WARN, "账号已停用");
        }
        String token = JWTUtils.createToken(u.getId());
        return AuthResult.success("登陆成功！", token);
    }


    /**
     * /register 注册
     */
    @PostMapping("/register")
    public Result<String> register(@RequestBody User user) {
        if (userService.register(user) != 0) {
            return Result.success("注册成功！");
        }
        return Result.error(ResponseStatus.WARN,"注册失败");
    }
    /**
     * /getInfo 返回当前登录的用户信息
     * @return
     */
    @GetMapping("/getInfo")
    public Result<User> getInfo() {
        User user = userService.getById(BaseContent.get());
        return Result.success(user);
    }
}
