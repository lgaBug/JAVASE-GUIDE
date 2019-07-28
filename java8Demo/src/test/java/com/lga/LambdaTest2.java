package com.lga;

/**
 * java8 内置的四大核心函数式接口
 *
 * Consumer<T> 消费型接口
 *      void accept(T t);
 *
 * Supplier<T> 供给型接口
 *      T get();
 *
 * Function(T,R) 函数型接口
 *      R apply(T t);
 *
 *  Predicate<T> 断言型接口
 *       boolean test(T t);
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LambdaTest2 {

    //Consumer<T> 消费型接口
    public void happy(double money, Consumer<Double> consumer) {
        consumer.accept(money);
    }

    @Test
    public void test1() {
        happy(1000,(m)-> System.out.println("我上网花了："+m+"元"));
    }


    //需求：产生指定个数的整数，并放入集合中
    //Supplier<T> 供给型接口
    public List<Integer> getNumList(int num, Supplier<Integer> sup) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            Integer n = sup.get();
            list.add(n);
        }
        return list;
    }

    @Test
    public void test2() {
        List<Integer> numList = getNumList(10, () -> {
            return (int) (Math.random() * 100);
        });
        for (int num : numList) {
            System.out.println("num = " + num);
        }
    }


    //需求：处理字符串
    //Function(T,R) 函数型接口
    public String strHandler(String str, Function<String,String> fn) {
        return fn.apply(str);
    }

    @Test
    public void test3() {
        String str1 = strHandler("liugaoan", (str) -> str.toUpperCase());
        System.out.println("str1 = " + str1);
    }

    //需求：对集合进行处理筛选
    //Predicate<T> 断言型接口
    public List<Integer> filterNumber(List<Integer> list, Predicate<Integer> pre) {
        List<Integer> resultList = new ArrayList<>();
        for (Integer num : list) {
            if (pre.test(num)) {
                resultList.add(num);
            }
        }
        return resultList;
    }

    //筛选出集合中大于5的数字
    @Test
    public void test4() {
        System.out.println(filterNumber(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 11), (x) -> {
            return x > 5;
        }));
    }

}
