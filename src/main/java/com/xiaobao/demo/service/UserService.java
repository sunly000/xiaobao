package com.xiaobao.demo.service;

import com.xiaobao.demo.domain.User;
import org.springframework.stereotype.Service;


public interface UserService {
    User getUserById(Integer id);
    User getUserByName(String name);
    void updateUser(User user);
}
