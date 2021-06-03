package com.lga.mybatis;

import org.junit.Test;

import java.util.HashMap;

public class TestDemo {


    @Test
    public void test1() {


        if (null instanceof String) {
            System.out.println("1111");
        }

        final HashMap<Object, Object> objectObjectHashMap = new HashMap(18){

            {
                put("123", "aa");
                put("2", "aa");
                put("3", "aa");
                put("4", "aa");
                put("5", "aa");
            }
        };

        System.out.println(objectObjectHashMap.size());

        objectObjectHashMap.clear();

        System.out.println(objectObjectHashMap.size());

    }
}
