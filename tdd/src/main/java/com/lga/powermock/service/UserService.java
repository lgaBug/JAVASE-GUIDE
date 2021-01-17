package com.lga.powermock.service;

import com.lga.powermock.dao.UserDao;
import com.lga.powermock.vo.User;

public class UserService {

    private UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public int queryUserCount() {
        return userDao.getCount();
    }

    public void saveUser(User user) {
         userDao.insertUser(user);
    }
}
