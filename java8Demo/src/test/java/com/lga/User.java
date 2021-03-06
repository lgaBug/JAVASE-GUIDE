package com.lga;

import java.util.function.Predicate;

public class User {

    private String name;
    private Integer age;
    private Double salary;

    public User(String name, Integer age, Double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public static Predicate<User> ageGreaterThan30AndSalayGraterThan60 = e -> e.getAge() > 30 && e.getSalary() > 60;
}
