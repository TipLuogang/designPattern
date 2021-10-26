package com.gupao.designPattern.singleton.hungry;


//优点：执行效率高，没加锁
//缺点：类加载时初始化，可能内存浪费（初始化之后用不用都已经初始化，不浪费：用的时候才初始化）
//不能用的情况：大量使用单例的时候
public class HungrySingleton {
    //先静态，后动态
    //先上后下
    //先属性后方法
    public static final HungrySingleton singleton = new HungrySingleton();//初始化可以放static代码块中

    private HungrySingleton(){}

    public static HungrySingleton getInstance(){
        return singleton;
    }
}
