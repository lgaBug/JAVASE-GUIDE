package com.lga.ws.service;

public class HelloServiceImpl implements HelloService{

    @Override
    public String sayHello(String str) {
        System.out.println("str = " + str);
        return "hello ws" + str;
    }

    @Override
    public String sayBayBay(String str) {
        System.out.println("str = " + str);
        return "bay bay ws" +str;
    }
}
