package com.gong.service;


import com.gong.entity.BaseUserInfo;
import com.gong.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    User isLogin(String username, String password);

    User getById(Integer id);

    int updateBaseUserInfoById(BaseUserInfo from);

    int updatePwdById(int id, String password);

    int register(User user);
}
