package com.lga.pattern.singlePattern;


/**
 *describe: 懒汉式（线程不安全）
 *advantage:lazy loading，需要的时候才加载，节省内存
 * disadvantage: 存在多线程同步问题，只能在单线程中确保只创建一个实例
 * summary:在实际开发中，不要使用这种方式。
 *
 *@author lga 
 *@date  2019/11/9 0009 13:53
 */ 
public class SingletonPattern03 {
    private static SingletonPattern03 instance;

    //构造器私有化，外部不能new对象
    private SingletonPattern03() {
    }

    //当去调用getInstance的时候才进行实例化
    public static SingletonPattern03 getInstance(){
        if (instance == null){
            instance = new SingletonPattern03();
        }
        return instance;
    }



}
