package com.lga.mybatis.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class Score implements Serializable {

    private int id;

    private Long math;

    private Long english;

}
