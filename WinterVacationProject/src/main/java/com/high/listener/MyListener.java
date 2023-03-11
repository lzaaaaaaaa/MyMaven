package com.high.listener;

import com.high.entity.Users;
import com.high.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.util.ArrayList;

@Component
public class MyListener implements ServletContextListener, HttpSessionListener {

    @Autowired
    private UsersService usersService;

    private ServletContext app;

    public MyListener() {
        System.out.println("监听器开启");
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        app = sce.getServletContext();
        System.out.println("application初始化：");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("application销毁：");
    }

    //不能直接访问静态页面，负责session不会创建
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        System.out.println("session创建：" + session.getId());
        session.setMaxInactiveInterval(3600);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("进入销毁");
        HttpSession session = se.getSession();
        Users users = (Users) session.getAttribute("userss");
//        usersService.updateStatus("0", uid);
        users.setStatus(0);
        usersService.updateById(users);
        System.out.println("session销毁：" + session.getId());
    }
}
