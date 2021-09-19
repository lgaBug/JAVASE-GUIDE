package com.lga.juc.pc;

public class Data {


    private  int number = 0;

    public synchronized void increment() {
        while (number != 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        number++;
        System.out.println(Thread.currentThread().getName()+" = " + number);
        notifyAll();
    }

    public synchronized void decrement() {
        while (number == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        number--;
        System.out.println(Thread.currentThread().getName()+" = " + number);
        notifyAll();
    }


    public static void main(String[] args) {


        final Data data = new Data();
        new Thread(() -> { for (int i = 0; i < 30; i++) data.increment(); },"A").start();
        new Thread(() -> { for (int i = 0; i < 30; i++) data.decrement(); },"B").start();
        new Thread(() -> { for (int i = 0; i < 30; i++) data.increment(); },"C").start();
        new Thread(() -> { for (int i = 0; i < 30; i++) data.decrement(); },"D").start();



    }
}
