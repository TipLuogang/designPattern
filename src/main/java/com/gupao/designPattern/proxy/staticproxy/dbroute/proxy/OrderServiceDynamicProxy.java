package com.gupao.designPattern.proxy.staticproxy.dbroute.proxy;

import com.gupao.designPattern.proxy.staticproxy.dbroute.db.DynamicDataSourceEntity;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.text.SimpleDateFormat;
import java.util.Date;

public class OrderServiceDynamicProxy implements InvocationHandler {

    private  Object proxyObj;
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy");

    //    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
//    private IOrderService orderService;//静态代理只能代理orderService
//
//    public OrderServiceDynamicProxy(IOrderService orderService) {
//        this.orderService = orderService;
//    }
//
//    @Override
//    public int createOrder(Order order) {
//
//        Long time  = order.getCreateTime();
//        Integer dbRouter = Integer.valueOf(sdf.format(new Date(time)));
//        System.out.println("静态代理内自动分配到DB：" + dbRouter);
//        DynamicDataSourceEntity.set(dbRouter);
//
//        orderService.createOrder(order);
//
//        DynamicDataSourceEntity.restore();
//        return 0;
//    }
    public Object getInstance(Object o){
        this.proxyObj = o;
        Class<?> clazz = proxyObj.getClass();

        return Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        before(args[0]);

        Object object = method.invoke(proxyObj, args);

        after();
        return object;
    }

    private void after() {
        System.out.println("proxy after...");
        //还原默认数据源
        DynamicDataSourceEntity.restore();
    }

    //target是订单对象order
    private void before(Object target) {
        //切换数据源
        System.out.println("proxy before...");
        try {
            //约定优于配置
            Long time = (Long) target.getClass().getMethod("getCreateTime").invoke(target);
//            Long time = target.getCreateTime();
            Integer dbRouter = Integer.valueOf(sdf.format(new Date(time)));
            System.out.println("静态代理内自动分配到DB：" + dbRouter);
            DynamicDataSourceEntity.set(dbRouter);
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
