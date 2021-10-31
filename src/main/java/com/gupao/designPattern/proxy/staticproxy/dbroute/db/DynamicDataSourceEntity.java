package com.gupao.designPattern.proxy.staticproxy.dbroute.db;

public class DynamicDataSourceEntity {//AbstraceRoutingDataSource...

    private final static ThreadLocal<String> local = new ThreadLocal<>();
    private static final String DEFAULT_SOURCE = null;

    private DynamicDataSourceEntity(){}


    public static String get(){
        return local.get();
    }



    public static void restore(){
        local.set(DEFAULT_SOURCE);
    }


    public static void set(String source){
        local.set(source);//db_2018
    }

    public static void set(int year){
        local.set("db_" + year);//db_2018
    }

}
