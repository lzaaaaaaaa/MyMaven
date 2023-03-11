package com.high.filter;

import com.high.entity.Users;
import org.apache.catalina.User;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "MyFilter", urlPatterns = "/*")
public class MyFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
        System.out.println("过滤器初始化");
    }

    public void destroy() {
        System.out.println("过滤器销毁");
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        String uri = request.getRequestURI();
        Users us = (Users)request.getSession().getAttribute("userss");
        boolean b = uri.contains("js") || uri.contains("gif") || uri.contains("jpg") || uri.contains("css") || uri.contains("login") || uri.contains("djreg") || uri.contains("exists") || uri.contains("register") || us != null;
        if (b) {
            chain.doFilter(req, resp);
        } else {
            request.getRequestDispatcher("login").forward(request, response);
        }

    }
}
