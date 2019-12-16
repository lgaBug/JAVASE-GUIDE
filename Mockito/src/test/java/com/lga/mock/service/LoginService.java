package com.lga.mock.service;

import com.lga.mock.dao.LoginDao;

public class LoginService {

    private LoginDao loginDao;

    public boolean login(String userName, String password) {
      return  loginDao.findAccount(userName, password);
    }

    public LoginDao getLoginDao() {
        return loginDao;
    }

    public void setLoginDao(LoginDao loginDao) {
        this.loginDao = loginDao;
    }
}
