package com.lga.ws.service;

import com.lga.ws.entity.User;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface HelloService {

    @WebMethod
    public String sayHello(String string);

    public User printUser(User user);


}
