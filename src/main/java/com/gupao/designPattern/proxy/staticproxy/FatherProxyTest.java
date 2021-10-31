package com.gupao.designPattern.proxy.staticproxy;

public class FatherProxyTest {

    public static void main(String[] args) {
        //静态代理1
        Father father = new Father(new Son());
        father.findLove();

        //静态代理2
        //数据库分库分表
        //ThreadLocal线程单例，数据源动态切换


    }
}
