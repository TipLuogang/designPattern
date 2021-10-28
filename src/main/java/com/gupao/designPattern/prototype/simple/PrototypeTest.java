package com.gupao.designPattern.prototype.simple;

import java.util.ArrayList;

public class PrototypeTest {
    public static void main(String[] args) {
        ConcretePrototypeA concretePrototype = new ConcretePrototypeA();
        concretePrototype.setAge(18);
        concretePrototype.setName("Tom");
        ArrayList<String> strings = new ArrayList<>();
        concretePrototype.setHobbies(strings);

        //浅克隆
        Client client = new Client();
        ConcretePrototypeA copy = (ConcretePrototypeA) client.startClone(concretePrototype);
        System.out.println("clone中list对象的地址："+copy.getHobbies());
        System.out.println("concretePrototype中list对象的地址："+concretePrototype.getHobbies());
        System.out.println("对象本身地址的比较：" + (copy.getHobbies()==concretePrototype.getHobbies()));//true



    }
}
