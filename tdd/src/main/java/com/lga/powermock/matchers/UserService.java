package com.lga.powermock.matchers;

public class UserService {

    public String find(String nickName) {
        UserDao userDao = new UserDao();
        return userDao.find(nickName);
    }
}
