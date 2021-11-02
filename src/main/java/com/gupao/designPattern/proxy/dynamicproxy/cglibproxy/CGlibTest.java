package com.gupao.designPattern.proxy.dynamicproxy.cglibproxy;

public class CGlibTest {
    public static void main(String[] args) {
        Customer obj = (Customer) new CGlibMeipo().getInstance(Customer.class);
        obj.findLove();

    }
}
