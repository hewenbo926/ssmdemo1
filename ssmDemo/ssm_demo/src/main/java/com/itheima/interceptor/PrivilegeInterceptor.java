package com.itheima.interceptor;

import com.itheima.domain.User;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class PrivilegeInterceptor implements HandlerInterceptor {

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {

        //判断用户是否登录,本质是判断session中有没有user
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        if (user==null){
            //没有登陆
            response.sendRedirect(request.getContextPath()+"/denied.jsp");
            return false;
        }
        //放行 访问目标资源
        return true;
    }
}
