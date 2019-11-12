package com.lga.pattern.singlePattern;


/**
 *describe: 静态内部类
 *summary:推荐使用，lazy loading,并且线程安全。采用了类加载机制保证了创建实例的时候只有 一个线程
 *@author lga 
 *@date  2019/11/9 0009 13:53
 */ 
public class SingletonPattern07 {

    //构造器私有化，外部不能new对象
    private SingletonPattern07() {
    }

    private static class SingletonInstance{
        private static final SingletonPattern07 INSTANCE =new SingletonPattern07();
    }

    //当去调用getInstance的时候才进行实例化
    public static SingletonPattern07 getInstance(){
        return SingletonInstance.INSTANCE;
    }


}
