package com.lga.gc;

public class DeadLockTest {

    public static void main(String[] args) {

        Object lock1 = new Object();
        Object lock2 = new Object();

        new Thread(() -> {

            synchronized (lock1) {
                System.out.println("获得锁lock1");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock2) {
                    System.out.println("获得锁lock2");
                }
            }


        }, "thread1").start();

        new Thread(() -> {

            synchronized (lock2) {
                System.out.println("获得锁lock2");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock1) {
                    System.out.println("获得锁lock1");
                }
            }

        }, "thread2").start();
    }
}
