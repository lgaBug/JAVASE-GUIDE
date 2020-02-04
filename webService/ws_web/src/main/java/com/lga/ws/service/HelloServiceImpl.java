package com.lga.ws.service;

import com.lga.ws.dao.UserDao;
import com.lga.ws.dao.UserDaoimpl;
import com.lga.ws.entity.User;
import com.lga.ws.exception.RejectAccessException;
import org.apache.commons.lang3.StringUtils;

public class HelloServiceImpl implements HelloService {

    private UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public HelloServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    public HelloServiceImpl() {
    }

    @Override
    public String sayHello(String str) {
        System.out.println("hello ws : " + str);
        return "hello ws : " + str;
    }

    @Override
    public User printUser(User user) {
        System.out.println("user = " + user);
        if (user == null) {
            throw new RejectAccessException("user 为空");
        }
        if (StringUtils.isBlank(user.getName())) {
            throw new RejectAccessException("name 为空");
        }
        if (user.getAge() == null) {
            throw new RejectAccessException("age 为空");
        }
        if (user.getSalary() == null) {
            throw new RejectAccessException("salary 为空");
        }

        userDao = new UserDaoimpl();
        User user1 = userDao.getUser(user.getName());
        if (user1 != null) {
            throw new RejectAccessException("该 name 已经 存在");
        }
        return user;
    }



}
