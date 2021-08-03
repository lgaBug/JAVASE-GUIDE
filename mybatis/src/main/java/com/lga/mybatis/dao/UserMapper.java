package com.lga.mybatis.dao;

import com.lga.mybatis.vo.User;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@CacheNamespace
public interface UserMapper {

    @Select("select * from user where id = #{arg0}")
    @Options(useCache = true,flushCache = Options.FlushCachePolicy.FALSE)
    User findUserById01(int userId);

}
