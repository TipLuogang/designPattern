package com.gupao.designPattern.factoryPattern.factoryMethod;

import com.gupao.designPattern.factoryPattern.ICourse;
import com.gupao.designPattern.factoryPattern.JavaCourse;
import com.gupao.designPattern.factoryPattern.PythonCourse;

public class PythonCourseFactory implements ICourseFactory{
    @Override
    public ICourse create() {
        return new PythonCourse();
    }
}
