package com.lga.gc.visualVM;

public class BTraceTest {

    public int add(int a, int b) {
        return a+b;
    }

    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(10000);
        BTraceTest bTraceTest = new BTraceTest();
        for (int i = 0; i < 10; i++) {
            int a = (int) Math.round(Math.random() * 1000);
            int b = (int) Math.round(Math.random() * 1000);
            System.out.println(bTraceTest.add(a,b));
        }
    }
}
