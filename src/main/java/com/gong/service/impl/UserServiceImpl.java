package com.gong.service.impl;

import com.gong.entity.BaseUserInfo;
import com.gong.entity.LoginFrom;
import com.gong.entity.Pages;
import com.gong.entity.User;
import com.gong.exception.ExistException;
import com.gong.mapper.UserMapper;
import com.gong.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.List;

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

    @Override
    public int count() {
        return userMapper.count();
    }

    /**
     * 分页查询
     * @param page
     * @param pageSize
     * @return
     */
    @Override
    public Pages<User> pages(int page, int pageSize) {
        List<User> limit = userMapper.limit((page - 1) * pageSize, pageSize);
        int total = userMapper.count();
        return new Pages<>(total, limit.size(), page, pageSize, limit);
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
     * 修改用户所有信息 （需要权限）
     * @param user
     * @return
     */
    @Override
    public int updateUserById(User user) {
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
     * @param form
     * @return
     */
    @Override
    public int register(LoginFrom form) {
        if (StringUtils.hasText(form.getUsername())
            && StringUtils.hasText(form.getPassword())
            && form.getUsername().length() <= 30
            && form.getPassword().length() <= 30 ) {
            User res = userMapper.selectByUsername(form.getUsername());
            if (res != null) throw new ExistException("用户已存在");
            // 不存在就注册
            User user = new User();
            user.setUsername(form.getUsername());
            user.setPassword(form.getPassword());
            // 默认的昵称就是用户名
            user.setNickname(form.getUsername());
            return userMapper.insert(user);
        }
        return 0;
    }


}
