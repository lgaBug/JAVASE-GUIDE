package com.lga.mybatis.dao;

import com.lga.mybatis.vo.User;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserDao {

    void insert(User user);

    User findUserById(int userId);

    List<User> findAllUsers();

    @Update("update `user` set name = #{arg1} where id = #{arg0}")
    int setName(Integer id, String name);

    User find(int userId);
}
