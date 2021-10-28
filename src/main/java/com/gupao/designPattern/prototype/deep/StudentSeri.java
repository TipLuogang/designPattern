package com.gupao.designPattern.prototype.deep;

import java.io.Serializable;

public class StudentSeri implements Serializable {

    private String name;

    public StudentSeri(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }
}
