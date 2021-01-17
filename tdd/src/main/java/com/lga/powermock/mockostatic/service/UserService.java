package com.lga.powermock.mockostatic.service;

import com.lga.powermock.mockostatic.dao.UserDao;
import com.lga.powermock.vo.User;

public class UserService {


    public int queryUserCount() {
        return UserDao.getCount();
    }

    public void saveUser(User user) {
        UserDao.insertUser(user);
    }
}
