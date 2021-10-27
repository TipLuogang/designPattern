package com.gupao.designPattern.singleton.lazy;

//优点:写法优雅，利用了java本身的语法特点,性能高，避免了内存浪费
//缺点：能够被反射破坏
//反射能破坏前面的那些写法--反射获取构造方法
//解决：在构造中加一个判断
public class LazyStaticInnerClassSingleton {

    private LazyStaticInnerClassSingleton(){
        if(LazyHolder.INSTANCE!=null){
            throw new RuntimeException("不允许非法访问");
        }
    }
    private static LazyStaticInnerClassSingleton getInstance(){
        return LazyHolder.INSTANCE;
    }

    //LazyStaticInnerClassSingleton被加载时，加载classpath下的LazyStaticInnerClassSingleton.class文件，
    // 内部类是LazyStaticInnerClassSingleton$LazyHolder.class
    //调用getInstance()的时候发现用到了内部类LazyHolder，才会去加载LazyStaticInnerClassSingleton$LazyHolder.class
    //再把类里面的逻辑执行完
    //再getInstance()返回
    private static class LazyHolder{
        private static final LazyStaticInnerClassSingleton INSTANCE = new LazyStaticInnerClassSingleton();
    }

}
