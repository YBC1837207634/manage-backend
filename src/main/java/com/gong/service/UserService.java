package com.gong.service;


import com.gong.entity.BaseUserInfo;
import com.gong.entity.LoginFrom;
import com.gong.entity.Pages;
import com.gong.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    User isLogin(String username, String password);

    User getById(Integer id);

    int count();
    Pages<User> pages(int page, int pageSize);

    int updateBaseUserInfoById(BaseUserInfo from);

    int updateUserById(User user);

    int updatePwdById(int id, String password);

    int register(LoginFrom from);
}
