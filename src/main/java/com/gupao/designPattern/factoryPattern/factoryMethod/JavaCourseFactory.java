package com.gupao.designPattern.factoryPattern.factoryMethod;

import com.gupao.designPattern.factoryPattern.ICourse;
import com.gupao.designPattern.factoryPattern.JavaCourse;

public class JavaCourseFactory implements ICourseFactory{
    @Override
    public ICourse create() {
        return new JavaCourse();
    }
}
