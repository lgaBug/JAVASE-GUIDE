package com.lga;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * 方法引用：若Lambda体中的内容方法已经实现了，我们可以使用“方法引用”。
 *          （可以理解为方法引用是Lambda的另一种表现形式）
 *
 * 主要有三种形式：
 * 对象::实例方法名
 * 类::静态方法名
 * 类::实例方法名
 *
 * 注意：Lambda体中的调用方法的参数列表与返回值类型，要与函数式接口中抽象方法的
 * 参数列表与返回值的类型一致
 */
public class MehodRefTest {

    @Test
    public void test1() {

        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5);
        integerList.stream().forEach(
                (x) -> System.out.println(x)
        );

        Consumer<String> consumer = System.out::println;
        consumer.accept("abc");

        Supplier<Double> supplier = Math::random;
        System.out.println(supplier.get());
    }


}
