package com.gong.service;

import com.gong.dto.LoginForm;

public interface LoginService {

    String login(String username, String password);

    boolean register(LoginForm form);

}
