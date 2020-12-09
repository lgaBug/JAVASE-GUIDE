package com.lga;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 一、Stream 的三个操作步骤
 * 1.创建stream
 * 2.中间操作
 * 3.终止操作
 */
public class StreamTest01 {

    //中间操作
    List<User> userList = Arrays.asList(
            new User("lga", 22, 99.99d),
            new User("lga1", 32, 55.99d),
            new User("lga2", 42, 66.66d),
            new User("lga3", 52, 77.77d)
    );

    //中间操作的所有操作都不会执行，只有执行了终止操作才会执行中间操作。

    /**
     * 筛选和切片
     * filter---接收Lambda,从流中排出某些元素
     * limit---截断流，使其元素不超过给定数量
     * skip(n)---跳过元素，返回一个扔掉了前n个元素的流。若流中元素不足一个，则返回一个空流，与limit(n)互补。
     * distinct---筛选，通过流所产生的hashCode()和equals()去除重复的元素。
     */
    @Test
    public void test1() {
        userList.stream()
                .filter((user) -> user.getAge() > 30)
                .forEach(System.out::println);
    }

    @Test
    public void test2() {
        userList.stream()
                .filter(e -> e.getAge() > 30 && e.getSalary() > 60)
                .map(e -> {
                    e.setName(e.getName().toUpperCase());
                    return e;
                })
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    @Test
    public void test3() {
        userList.stream()
                .filter(User.ageGreaterThan30AndSalayGraterThan60)
                .map(e -> {
                    e.setName(e.getName().toUpperCase());
                    return e;
                })
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

}
