package com.gupao.designPattern.singleton;

import com.gupao.designPattern.singleton.lazy.LazyStaticInnerClassSingleton;

import java.lang.reflect.Constructor;

public class RefectTest {
    public static void main(String[] args) {
        Class<?> clazz = LazyStaticInnerClassSingleton.class;
        try {
            Constructor<?> c = clazz.getDeclaredConstructor(null);
            c.setAccessible(true);
            Object instance1 = c.newInstance();
            Object instance2 = c.newInstance();
            System.out.println(instance1);
            System.out.println(instance2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
