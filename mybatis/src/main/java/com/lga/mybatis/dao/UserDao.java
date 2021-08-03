package com.lga.mybatis.dao;

import com.lga.mybatis.vo.User;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@CacheNamespace
public interface UserDao {

    void insert(User user);

    User findUserById(int userId);

    @Select("select * from user where id = #{arg0}")
    User findUserById01(int userId);


    List<User> findAllUsers();

    @Update("update `user` set name = #{arg1} where id = #{arg0}")
    int setName(Integer id, String name);


    @Select("select * from `user` t where t.id = #{arg0} and t.name = #{arg1}")
    User get(int id,String name);

}
