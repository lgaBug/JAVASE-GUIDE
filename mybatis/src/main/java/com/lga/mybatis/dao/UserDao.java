package com.lga.mybatis.dao;

import com.lga.mybatis.vo.User;

import java.util.List;

public interface UserDao {

    public void insert(User user);

    public User findUserById (int userId);

    public List<User> findAllUsers();

}
