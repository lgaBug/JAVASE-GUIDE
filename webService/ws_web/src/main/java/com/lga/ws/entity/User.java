package com.lga.ws.entity;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "user")
@XmlType(name = "", propOrder = {"name", "age", "salary"})
@XmlAccessorType(XmlAccessType.FIELD)
public class User {

    private String name;
    private Integer age;
    private Float salary;

    public Float getSalary() {
        return salary;
    }

    public void setSalary(Float salary) {
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

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }
}
