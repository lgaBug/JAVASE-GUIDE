package com.lga.pattern.singlePattern;


/**
 *describe: 饿汉式（静态代码块） 应用实例
 * summary:和SinglePattern01 一样都是在类加载的时候进行实例化，会创建出一个唯一的实例。但是可能会造成内存的浪费
 *
 *@author lga 
 *@date  2019/11/9 0009 14:05
 */ 

public class SinglePattern02 {
    private static SinglePattern02 singleInstance;

    //静态代码块，创建单个对象
    static{
        singleInstance = new SinglePattern02();
    }

    //构造器私有化，外部不能new对象
    private SinglePattern02() {
    }

    public static SinglePattern02 getInstance(){
        return singleInstance;
    }

    public static void main(String[] args){

        SinglePattern02 instance01 = SinglePattern02.getInstance();
        SinglePattern02 instance02 = SinglePattern02.getInstance();

        System.out.println("instance01 == instance02 = " + (instance01 == instance02));

    }



}
