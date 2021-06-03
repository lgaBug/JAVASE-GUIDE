package com.lga.mybatis.dao;

import com.lga.mybatis.vo.Score;
import org.apache.ibatis.annotations.Select;

public interface ScoreDao {


    @Select("select * from score where id = #{agr0}")
    Score findById(int id);
}
