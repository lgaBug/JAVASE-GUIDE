package com.lga.mybatis.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class Blog implements Serializable {

    private int id;
    private String title;
    private User author;
    private String body;
    private List<Comment> comments;
    Map<String, String> labels;

}
