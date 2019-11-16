package com.lga.struts2.service;

import com.lga.struts2.dao.UserDao;
import com.lga.struts2.domain.User;

import java.util.List;

public class UserService implements IUserService {

    private UserDao userDao = new UserDao();
    @Override
    public List<User> searchAll() {

        return null;
    }
}
