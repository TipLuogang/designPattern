package com.gupao.designPattern.proxy.staticproxy;

public class Father {
    private Person person;

    public Father(Person person){
        this.person = person;
    }

    public void findLove(){
        System.out.println("物色对象");
        this.person.findLove();
        System.out.println("确立关系");

    }

}
