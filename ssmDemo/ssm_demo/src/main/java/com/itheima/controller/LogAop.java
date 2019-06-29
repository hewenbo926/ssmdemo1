package com.itheima.controller;

import com.itheima.domain.Log;
import com.itheima.domain.User;
import com.itheima.service.LogService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Component
@Aspect
public class LogAop {

    @Autowired
    private LogService logService;
    @Autowired
    private HttpServletRequest request;

    //前置+后置

    //环绕
    @Around("execution(* com.itheima.controller.*.*(..))")
    public Object arround(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("进入了切面类");
        Date start = new Date();
        Object proceed = pjp.proceed();//执行 目标方法
        long cost = new Date().getTime() - start.getTime();
        System.out.println("目标方法执行了 返回值:" + proceed);

        User user = (User) request.getSession().getAttribute("user");
        String name = null;
        if (user != null) {
            name = user.getName();
        } else {
            name = request.getParameter("name") + "[登陆失败]";
        }
        String className = pjp.getTarget().getClass().getName();//获取目标类全限定名
        String methodName = pjp.getSignature().getName();//获取目标方法名
        System.out.println(name);
        Log log = new Log();
        log.setUrl("[类名]" + className + "[方法名]" + methodName);
        log.setTime(new Date());
        log.setName(name);
        log.setCost((int) cost);

        logService.insert(log);
        return proceed;

    }
}




















