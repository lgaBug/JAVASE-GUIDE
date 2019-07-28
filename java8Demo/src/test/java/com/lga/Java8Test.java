package com.lga;

import org.junit.Test;

import java.util.Comparator;
import java.util.TreeSet;

public class Java8Test {

    @Test
    public void test1() {
        Comparator<Integer> comparator = new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };

        TreeSet<Integer> treeSet = new TreeSet<Integer>(comparator);

    }

    @Test
    public void test2() {
        Comparator<Integer> comparator = (x, y) -> {
            return x.compareTo(y);
        };
    }
}
