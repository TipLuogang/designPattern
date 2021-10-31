package com.gupao.designPattern.proxy.staticproxy.dbroute;

public class OrderDao {

    public int insert(Order order){
        System.out.println("db插入order对象");
        return 1;
    }

}
