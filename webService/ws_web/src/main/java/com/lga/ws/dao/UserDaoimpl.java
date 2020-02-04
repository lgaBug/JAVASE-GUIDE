package com.lga.ws.dao;

import com.lga.ws.entity.User;

public class UserDaoimpl implements UserDao{

    @Override
    public User getUser(String name) {
        User user = null;
        if ("lga".equals(name)) {
            user = new User();
            user.setName("lga");
        }
        return user;
    }
}
