package com.lga;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class GroupByTest {


    public static void main(String[] args){
        List<User> list = getUserList();
        Map<String,List<User>> userGroupMap = list.stream().collect(Collectors.groupingBy(User::getName));

        final Collection<List<User>> listCollection = userGroupMap.values();
        System.out.println("listCollection = " + listCollection);

    }


    public static List<User> getUserList(){
        User user1 = new User(1,"张三","小学");
        User user2 = new User(2,"李四","小学");
        User user3 = new User(3,"王五","初中");
        User user4 = new User(4,"马六","高中");

        List<User> list = new ArrayList<User>();
        list.add(user1);
        list.add(user2);
        list.add(user3);
        list.add(user4);

        return list;
    }

//    public static void main(String[] args) {
//
//        List<Apple> appleList = new ArrayList<>();
//        Apple apple1 = new Apple();
//        apple1.setId("1");
//        apple1.setName("fendo1");
//        apple1.setCount((long) 10);
//        apple1.setType("1");
//        apple1.setPrice(new BigDecimal(20));
//        appleList.add(apple1);
//
//        Apple apple2 = new Apple();
//        apple2.setId("2");
//        apple2.setName("fendo2");
//        apple2.setCount((long) 10);
//        apple2.setType("1");
//        apple2.setPrice(new BigDecimal(20));
//        appleList.add(apple2);
//
//        Apple apple6 = new Apple();
//        apple6.setId("6");
//        apple6.setName("fendo6");
//        apple6.setCount((long) 30);
//        apple6.setType("1");
//        apple6.setPrice(new BigDecimal(20));
//        appleList.add(apple6);
//
//        Apple apple3 = new Apple();
//        apple3.setId("3");
//        apple3.setName("fendo3");
//        apple3.setCount((long) 10);
//        apple3.setType("2");
//        apple3.setPrice(new BigDecimal(20));
//        appleList.add(apple3);
//
//        Apple apple4 = new Apple();
//        apple4.setId("4");
//        apple4.setName("fendo4");
//        apple4.setCount((long) 10);
//        apple4.setType("3");
//        apple4.setPrice(new BigDecimal(20));
//        appleList.add(apple4);
//
//        Apple apple5 = new Apple();
//        apple5.setId("5");
//        apple5.setName("fendo5");
//        apple5.setCount((long) 10);
//        apple5.setType("4");
//        apple5.setPrice(new BigDecimal(20));
//        appleList.add(apple5);
//
//        //分组
//        Map<String, List<Apple>> map = appleList.stream().collect(Collectors.groupingBy(Apple::getType));
//        for (Map.Entry<String, List<Apple>> entry : map.entrySet()) {
//            System.out.println("分组" + entry);
//        }
//
//        //分组求和
//        Map<String, LongSummaryStatistics> collect = appleList.stream().collect(
//                Collectors.groupingBy(Apple::getType,
//                        Collectors.summarizingLong(Apple::getCount)));
//        for (Map.Entry<String, LongSummaryStatistics> entry : collect.entrySet()) {
//            LongSummaryStatistics longSummaryStatistics = entry.getValue();
//            System.out.println("----------------key----------------" + entry.getKey());
//            System.out.println("求和:" + longSummaryStatistics.getSum());
//            System.out.println("求平均" + longSummaryStatistics.getAverage());
//            System.out.println("求最大:" + longSummaryStatistics.getMax());
//            System.out.println("求最小:" + longSummaryStatistics.getMin());
//            System.out.println("求总数:" + longSummaryStatistics.getCount());
//        }
//
//    }


}
