package com.lga.struts2.action;

import com.lga.struts2.domain.User;
import com.lga.struts2.service.IUserService;
import com.lga.struts2.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.ExceptionMapping;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import java.util.List;

public class UserAction extends ActionSupport {

    private IUserService userService = new UserService();
    private String message;
    private List<User> users;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String init(){
        List<User> users = userService.searchAll();

        //User user = new User("wl", 22);
        message = "hello world";
        ActionContext.getContext().put("location","黄陂");

        return "input";
    }

    public String search(){
        int i = 3 / 0;
        System.out.println("message = " + message);
        return "input";
    }

}
