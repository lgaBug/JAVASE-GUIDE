package com.lga.powermock.local.service;

import com.lga.powermock.dao.UserDao;
import com.lga.powermock.vo.User;

public class UserService {



    public int queryUserCount() {
        UserDao userDao = new UserDao();
        return userDao.getCount();
    }

    public void saveUser(User user) {
        UserDao userDao = new UserDao();
        userDao.insertUser(user);
    }
}
