package com.gupao.designPattern.proxy.staticproxy.dbroute;

public class OrderService implements IOrderService{
    private OrderDao orderDao;

    public  OrderService(){
        orderDao = new OrderDao();
    }

    public int createOrder(Order order){
        System.out.println("orderservice调用orderdao创建订单");
        return orderDao.insert(order);
    }


}
