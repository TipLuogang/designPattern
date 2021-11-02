package com.gupao.designPattern.delegate.simple;

public class EmployeeA implements IEmployee{
    @Override
    public void doing(String command) {
        System.out.println("员工A，doing....擅长加密..." + command);
    }
}
