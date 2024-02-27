package com.gong.system.service;


import com.gong.system.entity.dto.LoginForm;

public interface LoginService {

    String login(String username, String password);

    boolean register(LoginForm form);

}
