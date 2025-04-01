package com.gong.manage.system.service;


import com.gong.manage.system.dto.LoginForm;

public interface LoginService {

    String login(String username, String password);

    boolean register(LoginForm form);

}
