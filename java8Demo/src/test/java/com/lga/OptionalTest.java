package com.lga;

import org.junit.Test;

import javax.swing.text.html.Option;
import java.util.Optional;

/**
 * Optional类
 */
public class OptionalTest {

    /**
     * Optional 容器类的常用方法
     * Optional.of(T t) ：创建一个Optional实例
     * Optional.empty()：创建一个空的Optional实例
     * Optional.ofNullable(T t)：若t不为null，则创建对应的实例，否则创建一个null
     * isPresent()：判断是否包含值
     * orElse(T t)：如果调用的包含值，返回该值，否则返回t
     * orElseGet(Supplier s)：如果调用的包含值，返回该值，否则返回s中的对象
     * map(Function f)：若果有值对其处理，并返回处理后的Optional,否则返回Optional.empty()
     * flatMap(Fuction f):和map类似，要求返回值必须是Optional
     *
     */

    @Test
    public void test1() {

        Optional<Employee> employee = Optional.of(new Employee());
        System.out.println("employee.get().getName() = " + employee.get().getName());

    }


    @Test
    public void test2() {
        Optional<Employee> op = Optional.empty();
        if (op.isPresent()) {
            System.out.println("op.get().getName() = " + op.get().getName());
        }
        System.out.println("op = " + op);
    }
    
    @Test
    public void test3() {
        Optional<Employee> employee = Optional.ofNullable(new Employee());
        System.out.println("employee.get() = " + employee.get());
    }

    @Test
    public void test4() {
        Employee employee = new Employee("lga",23,99.99,Status.FREE);

        Employee employee1 = Optional.ofNullable(employee).orElse(new Employee());
        System.out.println("employee1 = " + employee1);
    }


    @Test
    public void test5() {

        Employee employee = new Employee("lga",23,99.99,Status.FREE);
        Employee employee1 = Optional.ofNullable(employee).orElseGet(() -> new Employee());
        System.out.println("employee1 = " + employee1);
    }

    @Test
    public void test6() {
        Employee employee = new Employee("lga",23,99.99,Status.FREE);
        Optional<String> optionalS = Optional.ofNullable(employee).map((e) -> {
            return e.getName();
        });
        System.out.println("optionalS.get() = " + optionalS.get());

    }


}
