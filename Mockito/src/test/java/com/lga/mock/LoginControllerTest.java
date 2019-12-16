package com.lga.mock;

import com.lga.mock.controller.LoginController;
import com.lga.mock.dao.LoginDao;
import com.lga.mock.service.LoginService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import javax.servlet.http.HttpServletRequest;

import static org.mockito.Matchers.anyString;

@RunWith(MockitoJUnitRunner.class)
public class LoginControllerTest {

    private LoginService loginService;
    private LoginDao loginDao;
    private LoginController loginController;
    private HttpServletRequest request;

    @Before
    public void setUp() {
        loginDao = Mockito.mock(LoginDao.class);
        loginService = Mockito.mock(LoginService.class);
        loginService.setLoginDao(loginDao);
        request = Mockito.mock(HttpServletRequest.class);
        loginController = new LoginController(loginService);
    }

    @Test
    public void testSuccess() {
        Mockito.when(request.getParameter("username")).thenReturn("lga");
        Mockito.when(request.getParameter("password")).thenReturn("123456");
        Mockito.when(loginService.login("lga", "123456")).thenReturn(true);
        String loginstr = loginController.login(request);
        Assert.assertEquals("success.jsp",loginstr);
    }

    @Test
    public void testFail() {
        Mockito.when(request.getParameter("username")).thenReturn("lga");
        Mockito.when(request.getParameter("password")).thenReturn("1234");
        Mockito.when(loginService.login(anyString(), anyString())).thenReturn(false);
        String loginstr = loginController.login(request);
        Assert.assertEquals("error.jsp",loginstr);
    }
}
