package com.gupao.designPattern.singleton;

import com.gupao.designPattern.singleton.threadLocal.ThreadLocalSingleton;

public class ThreadSingletonTest {
    public static void main(String[] args) {
        System.out.println(ThreadLocalSingleton.getInstance());
        System.out.println(ThreadLocalSingleton.getInstance());
        System.out.println(ThreadLocalSingleton.getInstance());

        //mybatis ErrorContext
        //多数据源动态切换，数据源路由
    }
}
