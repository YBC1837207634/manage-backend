package com.gong.service.impl;

import com.gong.entity.BaseUserInfo;
import com.gong.entity.User;
import com.gong.mapper.UserMapper;
import com.gong.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 密码校验
     */
    @Override
    public User isLogin(String username, String password) {
        if (StringUtils.hasText(username)
                && StringUtils.hasText(password)
                && username.length()<= 30
                && password.length() <= 30) {
            User u = userMapper.selectByUsernameAndPassword(username, password);
            if (u!= null) return u;
        }
        return null;
    }

    public User getById(Integer id) {
        return userMapper.selectById(id);
    }

    /**
     * 通过 id 来更新用户的基本信息
     * @param from
     * @return
     */
    @Override
    public int updateBaseUserInfoById(BaseUserInfo from) {
        User user = new User();
        BeanUtils.copyProperties(from, user,
            "username","password","role","status", "deleted", "createTime", "updateTime"
        );
        user.setUpdateTime(LocalDateTime.now());
        return userMapper.updateById(user);
    }

    /**
     * 修改密码
     * @param id
     * @param password
     * @return
     */
    @Override
    public int updatePwdById(int id, String password) {
        if(StringUtils.hasText(password) && password.length() <= 30) {
            User user = new User();
            user.setId(id);
            user.setPassword(password);
            user.setUpdateTime(LocalDateTime.now());
            return userMapper.updateById(user);
        }
        return 0;
    }

    /**
     * 注册账号
     * @param user
     * @return
     */
    @Override
    public int register(User user) {
        user.setRole(null);
        if (StringUtils.hasText(user.getUsername())
                && StringUtils.hasText(user.getPassword())
                && user.getUsername().length() <= 30
                && user.getPassword().length() <= 30
        ) {
            return userMapper.insertRequired(user);
        }
        return 0;
    }


}
