package com.gupao.designPattern.factoryPattern.abstractFactory;


import com.gupao.designPattern.factoryPattern.ICourse;

//要求所有子工厂实现这个工厂
public interface ICourseFactory {
    ICourse createCourse();

    INote createNote();

    IVideo createVideo();

}
