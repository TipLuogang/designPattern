package com.gupao.designPattern.singleton.lazy;

//优点：节省内存
//缺点：线程不安全问题
//解决：加锁
public class LazySimpleSingleton {
    private static LazySimpleSingleton instance;
    private LazySimpleSingleton(){}


    public static synchronized LazySimpleSingleton getInstance(){

        if(instance==null){
            new LazySimpleSingleton();
        }
        return instance;
    }



}
