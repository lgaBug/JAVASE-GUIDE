package com.lga.mybatis.dao;

import com.lga.mybatis.vo.Blog;

public interface BlogDao {

    Blog selectBlogByBlogId(int id);

}
