package com.gupao.designPattern.delegate.simple;

public class EmployeeB implements IEmployee{
    @Override
    public void doing(String command) {
        System.out.println("员工B，doing....擅长架构..." + command);
    }
}
