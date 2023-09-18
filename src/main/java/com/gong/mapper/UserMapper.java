package com.gong.mapper;

import com.gong.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    User selectById(Integer id);

    User selectByUsername(String username);

    User selectByUsernameAndPassword(String username, String password);

    List<User> limit(int start, int total);

    int count();

    int updateById(User user);

    int insert(User user);
}
