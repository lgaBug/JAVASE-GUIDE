package com.lga.pattern.singlePattern;


/**
 *describe: 懒汉式（线程安全，同步代码块）
 *advantage:lazy loading，需要的时候才加载，节省内存
 * disadvantage: 但是在多线程情况下会出现创建多个实例的问题。
 * summary:在实际开发中，不适用该方法。原因和 懒汉式（线程不安全） 的原因一样
 *
 *@author lga 
 *@date  2019/11/9 0009 13:53
 */ 
public class SingletonPattern05 {
    private static SingletonPattern05 instance;

    //构造器私有化，外部不能new对象
    private SingletonPattern05() {
    }

    //当去调用getInstance的时候才进行实例化
    public static  SingletonPattern05 getInstance(){
        if (instance == null){
            synchronized(SingletonPattern05.class){
                instance = new SingletonPattern05();
            }
        }
        return instance;
    }



}
