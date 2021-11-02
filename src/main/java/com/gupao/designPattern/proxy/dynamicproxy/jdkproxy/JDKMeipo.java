package com.gupao.designPattern.proxy.dynamicproxy.jdkproxy;

import com.gupao.designPattern.proxy.staticproxy.Person;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKMeipo implements InvocationHandler {

    private Person target;
    public Object getInstance(Person person) throws Exception{
        this.target = person;
        Class<? extends Person> clazz = target.getClass();
        return Proxy.newProxyInstance(clazz.getClassLoader(),
                                        clazz.getInterfaces(),//jdk动态代理基于接口
                                        this);
    }

    /**
     * 传入的new Girl() 对象，Girl实现了Person接口
     * (Person) new JDKMeipo().getInstance(new Girl())时，返回动态生成的对象，
     * 这个对象实现了接口Person，
     * proxy.findLove()调用时，会调用InvocationHandler对象JDKMeipo的invoke方法
     *      super.h.invoke(this, m3, null) --this就是proxy对象，m3就是Girl的的findLove方法
     *
     * JavaComplier类对class字符串进行编译...生成.class文件
     * 赋值给到Class对象
     *
     * 自定义classloader对象继承classloader,实现findClass方法
     * 把.class文件转换为字节码流(OutputStream)，再通过原生方法defineClass返回Class对象
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object o = method.invoke(this.target, args);
        after();
        return o;
    }

    private void before(){
        System.out.println("before...");
    }
    private void after(){
        System.out.println("after...");
    }
}
