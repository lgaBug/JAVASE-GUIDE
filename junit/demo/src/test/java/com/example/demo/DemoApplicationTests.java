package com.example.demo;

import com.example.demo.type.FirstDemo;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DemoApplicationTests {
    @Test
    public void test_assertEquals() {
        String result = "5";
        Assert.assertEquals("比较错误01", 5, result);
    }

    @Test
    public void test2(){
        String result = "5";
        Assert.assertEquals("比较错误02", "5", result);
    }


    @Test
    public void test_nullPoint(){
        String s1 = "axa";
        Assert.assertEquals("为空",true,s1.length()>1);
    }


    @Test
    public void test_assertNotNull(){
        String s1 = null;
        Assert.assertNotNull("为空",s1);
    }

    @Test
    public void test_assertTrue(){
        Boolean falg = false;
        Assert.assertTrue("不成功",falg);
    }


    @Test
    public void test_assertSame(){

        String name = "我是刘高";
        Assert.assertSame("不一样","我是刘高安",name);
    }

    @Test
    public void test_firstDemo(){

        FirstDemo firsstDemo = new FirstDemo();
        boolean flag = firsstDemo.Parameterization(12);
        Assert.assertTrue(flag);

    }

}