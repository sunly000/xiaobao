package com.xiaobao.demo.service.impl;

import com.xiaobao.demo.domain.User;
import com.xiaobao.demo.mapper.UserMapper;
import com.xiaobao.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserById(Integer id){
        return userMapper.getUserById(id);
    }

    @Override
    public User getUserByName(String name){
        return userMapper.getUserByName(name);
    }

    @Override
    public void updateUser(User user){
        userMapper.updateUser(user);
    }
}
