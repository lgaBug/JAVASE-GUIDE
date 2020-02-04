package com.lga.ws.service;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * 对外发布服务的接口
 */

@WebService
public interface HelloService {

    @WebMethod
    public String sayHello(String str);

    @WebMethod
    public String sayBayBay(String str);

}
