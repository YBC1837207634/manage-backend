package com.gong.dto;


import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 接受登陆表单
 */
@Data
public class LoginForm {
    @NotBlank(message = "用户名不可为空")
    private String username;

    @NotBlank(message = "密码不可为空")
    private String password;
}
