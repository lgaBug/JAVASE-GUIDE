package com.lga;

import org.junit.Test;

import java.lang.annotation.Target;

public class LambdaDemo01 {

    interface Printer {
        void print(String content);
    }

    void printSomething(String content, Printer printer) {
        printer.print(content);
    }

    @Test
    public void test1() {
        LambdaDemo01 lambdaDemo01 = new LambdaDemo01();
        Printer printer = new Printer() {
            @Override
            public void print(String content) {
                System.out.println("content:" + content);
            }
        };
        lambdaDemo01.printSomething("123", printer);
    }

    @Test
    public void test2() {
        LambdaDemo01 lambdaDemo01 = new LambdaDemo01();
//        Printer printer = (String content) -> {
//            System.out.println("lanmbda content:" + content);
//        };
//        lambdaDemo01.printSomething("222222",content -> {
//            System.out.println("lanmbda content:" + content);
//        });
        //如果函数体中只有一行。可以省略括号
        lambdaDemo01.printSomething("222222", content -> System.out.println("lanmbda content:" + content));

    }

}
