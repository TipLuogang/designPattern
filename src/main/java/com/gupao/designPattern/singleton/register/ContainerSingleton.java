package com.gupao.designPattern.singleton.register;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 线程安全问题:sync(ioc){...}
 *  AbstractBeanFactory
 *      getBean()...
 * 序列化问题
 *      内存中的对象--磁盘文件--内存中的对象
 *      增加一个readResolve()方法， 里面返回INSTANCE
 * 对象方便管理，懒加载
 */
public class ContainerSingleton {
    private ContainerSingleton(){}

    private static Map<String, Object> ioc = new ConcurrentHashMap<>();

    public static Object getInstance(String className){
        Object o = null;
        if(!ioc.containsKey(className)){
            try {
                o = Class.forName(className).newInstance();
                ioc.put(className, o);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return o;
        }else {
            return ioc.get(className);
        }
    }

}
