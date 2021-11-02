package com.gupao.designPattern.proxy.dynamicproxy.cglibproxy;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CGlibMeipo implements MethodInterceptor {
    public Object getInstance(Class clazz){

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        return enhancer.create();
    }

    /**
     * 生成了3个class文件
     * class1： 继承了Customer，实现了Factory接口
     * 重写了findLove方法，在里面调用了intercept方法，还调用了super.findLove()方法
     *          intercept();
     *          super.findLove();
     * 客户端调用obj.findLove()是调用重写的findLove方法
     *
     * class2: extends FastClass
     *
     * class3: 内部类
     *
     * 使用asm写class字节码，比jdk代理效率低
     * jdk调用代理的方法使用的是反射机制，cglib是调用fastClass，而fastClass是调用的时候生成的，cglib的执行效率比jdk更高
     *
     * jdk采用读取接口的信息（接口个数少于65535）
     * cglib覆盖父类方法
     * 目的：都是生成一个新的类，去实现增强代码逻辑的功能
     *
     * jdk proxy对于用户而言，必须要有一个接口实现，目标类相对来水复杂
     * cglib 可以代理任意一个普通的类，没有任何要求
     *
     * cglib生成代理的逻辑更复杂，效率低，但是调用效率高（生成了一个包含了所有逻辑的fastClass，不需要反射调用）
     * jdk proxy生成代理的逻辑简单，执行效率相对比较低（每次都要反射动态调用）
     *
     * cglib不能代理final修饰的方法
     * @param o
     * @param method    通过父类去继承实现的methodProxy
     * @param objects
     * @param methodProxy
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        before();
//        Object o = method.invoke(this.target, args);
         o = methodProxy.invokeSuper(o,objects);
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
