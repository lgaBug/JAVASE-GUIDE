package com.ws.server;

import com.lga.ws.service.HelloServiceImpl;
import org.apache.cxf.jaxws.JaxWsServerFactoryBean;

public class Server {

    public static void main(String[] args) {

        //设置服务的工厂
        JaxWsServerFactoryBean factory = new JaxWsServerFactoryBean();

        //设置服务的地址
        factory.setAddress("http://127.0.0.1:8080/ws/hello");

        //设置服务类
        factory.setServiceBean(new HelloServiceImpl());

        //发布服务
        factory.create();

        System.out.println("发布ws成功!!,端口号为:8000");


    }
}
