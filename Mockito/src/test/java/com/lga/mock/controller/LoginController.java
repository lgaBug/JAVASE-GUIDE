package com.lga.mock.controller;

import com.lga.mock.service.LoginService;

import javax.servlet.http.HttpServletRequest;

public class LoginController {

    private LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    public String login(HttpServletRequest request) {
        boolean loginFlag = loginService.login(request.getParameter("username"), request.getParameter("password"));
        return loginFlag ? "success.jsp" : "error.jsp";
    }
}
