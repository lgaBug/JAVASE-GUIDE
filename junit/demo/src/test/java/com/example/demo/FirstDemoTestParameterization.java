package com.example.demo;

import com.example.demo.type.FirstDemo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * 参数化测试
 */
@SpringBootTest
@RunWith(Parameterized.class)
public class FirstDemoTestParameterization {

    //1.要测试的类
    private FirstDemo firstDemo;

    //2.为测试类声明几个变量，分别存于期望值和所测试的数据
    private int input1;
    private boolean expected;

    //3.带有参数的公共构造方法
    public FirstDemoTestParameterization(int input1, boolean expected) {
        this.input1 = input1;
        this.expected = expected;
    }

    //4.初始化所需要的测试数据
    @Parameterized.Parameters
    public static Collection prepareData(){
        Object[][] object = {{-1,false},{13,true},{0,false}};
        return Arrays.asList(object);
    }


    @Before
    public void setUp() throws Exception{
        if (this.firstDemo == null){
            this.firstDemo = new FirstDemo();
        }
    }

    @Test
    public void test_parameterization(){

        Assert.assertEquals(expected,firstDemo.Parameterization(input1));
    }



}
