package com.gupao.designPattern.delegate.mvc;

import com.gupao.designPattern.delegate.mvc.controllers.MemberController;
import com.gupao.designPattern.delegate.mvc.controllers.OrderController;
import com.gupao.designPattern.delegate.mvc.controllers.SystemController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DispatcherServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //完成调度，以前在xml里面完成调度：一个url匹配一个servlet
        //现在只需要一个servlet
        //浏览器输入一个url，http://localhost:8080/getMemberById.do调用对应的方法
        doDispatcher(req,resp);

    }

    private void doDispatcher(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String uri = req.getRequestURI();
        String mid = req.getParameter("mid");



        if ("getMemberByID".equals(uri)){//spring 中自动配置
            new MemberController().getMemberById(mid);
        }else if ("getOrderById".equals(uri)){
            new OrderController().getOrderById(mid);
        }else if ("logout".equals(uri)){
            new SystemController().logout();
        }else {
            resp.getWriter().write("404 not found");
        }

    }
}
