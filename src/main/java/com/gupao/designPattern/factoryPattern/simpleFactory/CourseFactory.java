package com.gupao.designPattern.factoryPattern.simpleFactory;

import com.gupao.designPattern.factoryPattern.ICourse;

public class CourseFactory {

//    public ICourse create(String name){
//        if("java".equals(name)){
//            return new JavaCourse();
//        }else {
//            return null;
//        }
//    }

    public ICourse create(Class clzz){
       try {
           if (!(null == clzz)){
               return (ICourse) clzz.newInstance();
           }
       } catch (Exception e){
           e.printStackTrace();
       }
       return null;
    }
}
