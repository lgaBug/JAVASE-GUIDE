package com;

import com.lga.A;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("spring-beans.xml");
        A bean = context.getBean(A.class);
        System.out.println("bean = " + bean);

    }
}
