package com.gupao.designPattern.proxy.staticproxy.dbroute.proxy;

import com.gupao.designPattern.proxy.staticproxy.dbroute.IOrderService;
import com.gupao.designPattern.proxy.staticproxy.dbroute.Order;
import com.gupao.designPattern.proxy.staticproxy.dbroute.db.DynamicDataSourceEntity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class OrderServiceStaticProxy implements IOrderService {

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
    private IOrderService orderService;//静态代理只能代理orderService

    public OrderServiceStaticProxy(IOrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public int createOrder(Order order) {

        Long time  = order.getCreateTime();
        Integer dbRouter = Integer.valueOf(sdf.format(new Date(time)));
        System.out.println("静态代理内自动分配到DB：" + dbRouter);
        DynamicDataSourceEntity.set(dbRouter);

        orderService.createOrder(order);

        DynamicDataSourceEntity.restore();
        return 0;
    }
}
