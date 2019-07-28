package com.lga;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * 一、Stream 的三个操作步骤
 * 1.创建stream
 * 2.中间操作
 * 3.终止操作
 */
public class StreamTest {

    //创建Stream
    @Test
    public void test1() {
        List<String> list = new ArrayList<>();
        //集合中的获取流
        Stream<String> stream = list.stream();
        //数组中的获取流
        Stream<String> stream1 = Arrays.stream(new String[]{"abc", "def"});
        //通过Stream中的静态方法获取流
        Stream<String> aaa = Stream.of("aaa", "ppp");
        //创建无限流
        //1：迭代
        Stream.iterate(0, (x) -> x + 2).limit(10).forEach(System.out::println);
        //2:生成
        Stream.generate(() -> Math.random()).limit(5).forEach((x)->System.out.println(x));

    }

}
