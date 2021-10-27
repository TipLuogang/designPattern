package com.gupao.designPattern.singleton;

import com.gupao.designPattern.singleton.register.EnumSingleton;

import java.lang.reflect.Constructor;

public class EnumSingletonTest {
    public static void main(String[] args) {
//        EnumSingleton instance = EnumSingleton.getInstance();
//        instance.setData(new Object());

        try {
            Class clazz = EnumSingleton.class;
            Constructor c = clazz.getDeclaredConstructor(String.class, int.class);
            System.out.println(c);
            c.setAccessible(true);
            Object o = c.newInstance();//jdk限制无法用反射去创建反射对象
            System.out.println(o);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
