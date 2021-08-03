package com.lga.mybatis.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

@Data
public class User implements Serializable {

    private int id;
    private String name;
    private String password;
    private int age;
    private int deleteFlag;

    private Score score;

}