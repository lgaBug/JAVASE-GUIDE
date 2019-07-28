package com.lga;

import org.junit.Test;

/**
 * Lambda表达式：需要函数式接口的支持（接口中只有一个方法的接口）
 * 左侧：表达式中的参数列表
 * 右侧：所需要执行的功能
 *
 * (x...) -> {}
 */
public class LambdaTest {
    public Integer integerHandler(Integer num, MyFunction mf) {
        return mf.getValue(num);
    }

    @Test
    public void test1() {
        Integer num = integerHandler(3, (x) -> x * x);
        System.out.println("num = " + num);
    }
}
