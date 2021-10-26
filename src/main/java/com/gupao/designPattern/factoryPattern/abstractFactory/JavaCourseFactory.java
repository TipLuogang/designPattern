package com.gupao.designPattern.factoryPattern.abstractFactory;

import com.gupao.designPattern.factoryPattern.ICourse;
import com.gupao.designPattern.factoryPattern.JavaCourse;

public class JavaCourseFactory implements ICourseFactory{
    @Override
    public ICourse createCourse() {
        return new JavaCourse();
    }

    @Override
    public INote createNote() {
        return new JavaNote();
    }

    @Override
    public IVideo createVideo() {
        return new JavaVideo();
    }
}
