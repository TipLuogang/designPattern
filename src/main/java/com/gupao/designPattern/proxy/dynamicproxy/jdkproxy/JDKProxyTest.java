package com.gupao.designPattern.proxy.dynamicproxy.jdkproxy;

import com.gupao.designPattern.proxy.staticproxy.Person;

public class JDKProxyTest {

    public static void main(String[] args) throws Exception{
        Person person = (Person) new JDKMeipo().getInstance(new Girl());

        person.findLove();
    }
}
