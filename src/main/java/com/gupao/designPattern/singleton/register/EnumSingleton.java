package com.gupao.designPattern.singleton.register;

/**
 * 继承Enum抽象类
 *
 *
 */
public enum EnumSingleton {
    INSTANCE;
    //声明的时候，把INSTANCE当做一个常量放到一个map容器中，不存在线程安全问题，存在内存浪费问题，解决：spring ioc容器

    //自定义属性
    private Object data;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static EnumSingleton getInstance(){
        return INSTANCE;
    }

}
