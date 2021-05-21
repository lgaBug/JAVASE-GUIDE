package com.lga.mybatis.vo;

import lombok.Data;

@Data
public class User {

    private int id;
    private String name;
    private String password;
    private int age;
    private int deleteFlag;

}