package com.gupao.designPattern.prototype.deep;

import java.io.Serializable;

public class SchoolSeri implements Serializable{
    private String name;
    private StudentSeri stu;

    public SchoolSeri(String name, StudentSeri stu) {
        this.name = name;
        this.stu = stu;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public StudentSeri getStu() {
        return stu;
    }

    public void setStu(StudentSeri stu) {
        this.stu = stu;
    }

    @Override
    public String toString() {
        return "School{" +
                "name='" + name + '\'' +
                ", stu=" + stu +
                '}';
    }
}


