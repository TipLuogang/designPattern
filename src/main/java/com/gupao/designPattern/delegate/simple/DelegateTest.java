package com.gupao.designPattern.delegate.simple;

public class DelegateTest {
    public static void main(String[] args) {

        Boss boss = new Boss();
        boss.command("加密", new Leader());
        boss.command("架构", new Leader());
    }
}
