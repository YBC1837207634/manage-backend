package com.gong.mapper;

import com.gong.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    User selectById(Integer id);

    User selectByUsername(String username);

    User selectByUsernameAndPassword(String username, String password);

    int updateById(User user);

    int insert(User user);
}
