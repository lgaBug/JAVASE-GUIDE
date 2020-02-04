package com.lga.ws.client;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import com.lga.ws.service.HelloService;

public class Client {

    public static void main(String[] args) {

        //创建cxf代理工厂
        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();

        //设置远程服务器的访问地址
        factory.setAddress("http://127.0.0.1:8080/ws/hello");

        factory.setServiceClass(HelloService.class);

        HelloService helloService = factory.create(HelloService.class);

        System.out.println("helloService = " + helloService.getClass());

        String s = helloService.sayBayBay("333");
        System.out.println("s = " + s);

    }
}
