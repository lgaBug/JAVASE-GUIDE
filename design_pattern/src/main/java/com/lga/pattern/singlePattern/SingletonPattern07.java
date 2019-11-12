package com.lga.pattern.singlePattern;


/**
 *describe: 双重检查
 *advantage:lazy loading，需要的时候才加载，节省内存
 * summary:在实际开发中，一般使用这种模式。
 *
 *@author lga 
 *@date  2019/11/9 0009 13:53
 */ 
public class SingletonPattern06 {
    //volatile保证了多线程情况下的静态变量可见性。
    private static volatile SingletonPattern06 instance;

    //构造器私有化，外部不能new对象
    private SingletonPattern06() {
    }

    //当去调用getInstance的时候才进行实例化
    public static SingletonPattern06 getInstance(){
        if (instance == null){
            synchronized(SingletonPattern06.class){
                if (instance == null){
                    instance = new SingletonPattern06();
                }
            }
        }
        return instance;
    }



}
