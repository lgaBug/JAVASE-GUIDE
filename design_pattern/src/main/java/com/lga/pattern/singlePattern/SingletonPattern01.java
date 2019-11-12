package com.lga.pattern.singlePattern;


/**
 *describe: 饿汉式（静态常量） 应用实例
 * advantage:写法简单，类在加载的时候就可以完成实例化，并且避免了线程同步问题
 * disadvantage:没有达到lazy loading目的，有可能创建了实例，但是至始至终没有使用过这个实例
 * 导致内存浪费。
 * summary:可以用，但是可能存在内存的浪费。
 * 
 *@author lga 
 *@date  2019/11/9 0009 13:53
 */ 
public class SinglePattern01 {
    private final static SinglePattern01 singleInstance = new SinglePattern01();

    //构造器私有化，外部不能new对象
    private SinglePattern01() {
    }

    public static SinglePattern01 getInstance(){
        return singleInstance;
    }



}
