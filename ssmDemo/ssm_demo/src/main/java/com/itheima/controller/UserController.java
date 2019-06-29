package com.itheima.controller;

import com.itheima.domain.User;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String login(String name, String password, HttpSession session, HttpServletRequest request){
        User user = userService.login(name, password);

        if (user!=null){
            //登陆成功 将user存储到session
            session.setAttribute("user",user);
            return "redirect:/student/list";
        }else{
            System.out.println("用户名或密码错误");
            request.setAttribute("msg","用户名密码错误");
            return "login";
        }
    }

}
