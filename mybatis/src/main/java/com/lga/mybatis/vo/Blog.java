package com.lga.mybatis.vo;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Data
public class Blog implements Serializable {

    private int id;
    private String title;
    private User author;
    private String body;
    private List<Comment> comments;
    Map<String, String> labels;

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author=" + author +
                ", body='" + body + '\'' +
                ", comments=" + comments +
                '}';
    }
}
