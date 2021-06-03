package com.lga.mybatis.vo;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
public class Comment implements Serializable {
    private String id;
    private Integer blogId;
    private String body;
    private Blog blog;

}
