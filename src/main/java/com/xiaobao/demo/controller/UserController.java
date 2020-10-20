package com.xiaobao.demo.controller;

import com.xiaobao.demo.domain.User;
import com.xiaobao.demo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;


@Controller
public class UserController {


    @Autowired
    UserService userService;

    @RequestMapping("/login")
    public String show(){
        return "/login";
    }

    @RequestMapping(value="/loginVerify",method = RequestMethod.POST)
    //登录验证
    public String loginVerify(String username, String password, HttpSession session, ModelMap model) {
        User user = userService.getUserByName(username);

        if (user != null) { // 用户名存在
            if (user.getPassword().equals(password)) {
                model.addAttribute("user",user);
                session.setAttribute("user",user);
                return "/index";
            } else {
                model.addAttribute("user",user);
                return "/login";
            }
        } else {
            model.addAttribute("user",user);
            return "/login";
        }
    }


}
