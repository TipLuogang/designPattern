package com.gupao.designPattern.singleton.threadLocal;

/**
 * 基于线程单例，线程中单例
 *
 */
public class ThreadLocalSingleton {
    private static final ThreadLocal<ThreadLocalSingleton> instance =
            new ThreadLocal<ThreadLocalSingleton>(){
                @Override
                protected ThreadLocalSingleton initialValue() {
                    return new ThreadLocalSingleton();
                }
            };

    private ThreadLocalSingleton(){}

    public static ThreadLocalSingleton getInstance(){
        return instance.get();
    }

}
