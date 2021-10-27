package com.gupao.designPattern.singleton;

import com.gupao.designPattern.singleton.register.ContainerSingleton;

public class ContainerSingletonTest {
    public static void main(String[] args) {
        Object instance1 = ContainerSingleton.getInstance("com.gupao.designPattern.singleton.Pojo");
        Object instance2 = ContainerSingleton.getInstance("com.gupao.designPattern.singleton.Pojo");
        System.out.println(instance1);
        System.out.println(instance2);


    }
}
