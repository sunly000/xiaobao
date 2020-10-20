package com.xiaobao.demo.mapper;

import com.xiaobao.demo.domain.User;
import org.apache.ibatis.annotations.Mapper;


public interface UserMapper {
    User getUserById(Integer id);
    User getUserByName(String name);
    void updateUser(User user);
}
