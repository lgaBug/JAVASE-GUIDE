package com.lga.mybatis.vo;

import java.io.Serializable;

public class Comment implements Serializable {
    private String id;
    private Integer blogId;
    private String body;
    private Blog blog;

    @Override
    public String toString() {
        return super.toString();
    }

}
