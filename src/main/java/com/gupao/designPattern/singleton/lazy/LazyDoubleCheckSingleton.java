package com.gupao.designPattern.singleton.lazy;

//优点：性能搞了，线程安全了
//缺点：可读性降低，不够优雅
public class LazyDoubleCheckSingleton {
    private volatile static LazyDoubleCheckSingleton instance;
    private LazyDoubleCheckSingleton(){}


    public static LazyDoubleCheckSingleton getInstance(){
        if(instance==null) {//检查是否阻塞
            synchronized (LazyDoubleCheckSingleton.class) {
                if(instance==null){//检查是否要重新创建实例
                    instance = new LazyDoubleCheckSingleton();
                    //指令重排序问题  volatile解决
                }
            }
        }
        return instance;
    }



}
