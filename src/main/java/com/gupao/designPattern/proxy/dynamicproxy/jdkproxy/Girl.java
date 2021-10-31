package com.gupao.designPattern.proxy.dynamicproxy.jdkproxy;

import com.gupao.designPattern.proxy.staticproxy.Person;

public class Girl implements Person {
    @Override
    public void findLove() {
        System.out.println("girl findLove...");
    }


}
