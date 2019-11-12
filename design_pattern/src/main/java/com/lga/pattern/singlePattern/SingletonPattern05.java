package com.lga.pattern.singlePattern;


/**
 *describe: 懒汉式（线程安全，同步方法）
 *advantage:lazy loading，需要的时候才加载，节省内存
 * disadvantage: 但是每个线程进入之后都要进行同步操作。效率比较低
 * summary:在实际开发中，一般不使用这种方式。
 *
 *@author lga 
 *@date  2019/11/9 0009 13:53
 */ 
public class SingletonPattern04 {
    private static SingletonPattern04 instance;

    //构造器私有化，外部不能new对象
    private SingletonPattern04() {
    }

    //当去调用getInstance的时候才进行实例化
    public static synchronized SingletonPattern04 getInstance(){
        if (instance == null){
            instance = new SingletonPattern04();
        }
        return instance;
    }



}
