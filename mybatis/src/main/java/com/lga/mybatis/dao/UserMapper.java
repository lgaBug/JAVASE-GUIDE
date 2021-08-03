package com.lga.mybatis.dao;

import com.lga.mybatis.vo.User;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Select;

@CacheNamespace
public interface UserMapper {

    @Select("select * from user where id = #{arg0}")
    User findUserById01(int userId);

}
