package com.gupao.designPattern.proxy.staticproxy.dbroute;

import com.gupao.designPattern.proxy.staticproxy.dbroute.proxy.OrderServiceStaticProxy;

import java.util.Date;

public class DbRouteProxyTest {

    public static void main(String[] args) {
        Order order = new Order();
        order.setCreateTime(new Date().getTime());

        IOrderService orderService = new OrderServiceStaticProxy(new OrderService());
        orderService.createOrder(order);
    }
}
