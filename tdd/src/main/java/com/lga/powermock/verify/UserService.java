package com.lga.powermock.verify;

import com.lga.powermock.vo.User;

public class UserService {

    public void saveOrUpdate(User user) {
        UserDao userDao = new UserDao();
        if (userDao.getUser(user) > 0) {
            userDao.update(user);
        }else{
            userDao.insertUser(user);
        }
    }
}
