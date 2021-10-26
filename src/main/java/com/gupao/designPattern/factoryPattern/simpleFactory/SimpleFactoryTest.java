package com.gupao.designPattern.factoryPattern.simpleFactory;


import com.gupao.designPattern.factoryPattern.ICourse;
import com.gupao.designPattern.factoryPattern.JavaCourse;
import org.slf4j.LoggerFactory;

import java.util.Calendar;

public class SimpleFactoryTest {
    public static void main(String[] args) {
//        ICourse course = new JavaCourse();
//        course.record();


        CourseFactory factory = new CourseFactory();
//        ICourse course = factory.create("com.gupao.designPattern.factoryPattern.JavaCourse");
        ICourse course = factory.create(JavaCourse.class);
        course.record();


        Calendar.getInstance();//不同的场景创建不同的实现类
        LoggerFactory.getLogger(JavaCourse.class);
        LoggerFactory.getLogger("xxxx");
        //工厂本身就是一个单例

    }

}
