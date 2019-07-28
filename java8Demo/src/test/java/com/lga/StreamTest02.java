package com.lga;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 一、Stream 的三个操作步骤
 * 1.创建stream
 * 2.中间操作
 * 3.终止操作
 */
public class StreamTest02 {

    //终止操作
    List<User> userList = Arrays.asList(
            new User("lga", 22, 99.99d),
            new User("lga1", 32, 55.99d),
            new User("lga2", 42, 66.66d),
            new User("lga3", 52, 77.77d)
    );

    List<Employee> employeeList = Arrays.asList(
            new Employee("lga", 22, 99.99d, Status.BUSY),
            new Employee("lga1", 32, 55.99d, Status.BUSY),
            new Employee("lga2", 42, 66.66d, Status.FREE),
            new Employee("lga3", 52, 77.77d, Status.VOCATION)
    );




    /**
     * 查找与匹配
     * allMatch----检查是否匹配所有元素
     * anyMatch----检查是否匹配一个元素
     * noneMatch----检查是否没有匹配所有元素
     * findFirst----返回第一个元素
     * findAny----返回当前流中的任意元素
     * count----返回流中元素的总个数
     * max----返回流中的最大值
     * min----返回流中的最小值
     */
    @Test
    public void test1() {
        boolean flag = userList.stream().allMatch((user) -> {
            return user.getName().contains("lga1");
        });
        System.out.println("flag = " + flag);

        boolean flag1 =  userList.stream().anyMatch((user) -> {
            return user.getName().contains("lga1");
        });
        System.out.println("flag1 = " + flag1);

        boolean flag2 =  userList.stream().noneMatch((user) -> {
            return user.getName().contains("lga1");
        });
        System.out.println("flag1 = " + flag1);

        Optional<User> optionalUser = userList.stream().findFirst();
        System.out.println("optionalUser = " + optionalUser);
        optionalUser.get();
    }

    /**
     *
     * 归约
     * reduce --- 可以将流中元素反复结合起来，得到一个值
     */
    @Test
    public void test3() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer result = list.stream()
                .reduce(0, (x, y) -> x + y);
        System.out.println("result = " + result);

        //获取工资总和
        Double result1 = userList.stream()
                .map((user) -> user.getSalary())
                .reduce(0.0, (x, y) -> x + y);
        System.out.println("result1 = " + result1);
    }

    /**
     * 收集
     * collect --- 将流转换为其他形式，接收一个Collector接口的实现，用于给Stream
     * 中元素做汇总的方法
     */
    @Test
    public void test4() {
        List<String> list = userList.stream()
                .map(User::getName)
                .collect(Collectors.toList());
        list.forEach(System.out::println);

        System.out.println("-------------------");

        List<User> users = userList.stream()
                .filter((user) -> user.getAge() > 30)
                .collect(Collectors.toList());
        users.forEach(System.out::println);

        //获取最大工资的员工
        //方式一
        Optional<User> userOptional = userList.stream()
                .collect(Collectors.maxBy((user1, user2) -> Double.compare(user1.getSalary(), user2.getSalary())));
        System.out.println("userOptional.get() = " + userOptional.get());

        System.out.println("---------------");
        //方式二
        Optional<User> userOptional1 = userList.stream()
                .max((user1, user2) -> Double.compare(user1.getSalary(), user2.getSalary()));
        System.out.println("userOptional.get() = " + userOptional.get());
    }

    /**
     * 分组
     */
    @Test
    public void test5() {

        //根据状态进行分组
        Map<Status, List<Employee>> map = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getStatus));

        System.out.println("map = " + map);
    }


}
