package com.lga.ws.service;

import com.lga.ws.dao.UserDao;
import com.lga.ws.dao.UserDaoimpl;
import com.lga.ws.entity.User;
import com.lga.ws.exception.RejectAccessException;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HelloServiceImplTest {

    private Mockery context = new Mockery();
    private HelloServiceImpl helloService = new HelloServiceImpl();
    UserDao userDao = context.mock(UserDao.class);

    @Before
    public void setUp() {
        helloService.setUserDao(userDao);
    }

    @Test(expected = RejectAccessException.class)
    public void printUser01() {
        User user = null;
        User user1 = helloService.printUser(user);
    }

    @Test(expected = RejectAccessException.class)
    public void printUser02() {
        User user = new User();
        user.setName("lga");
        user.setSalary(9500.0f);
        User user1 = helloService.printUser(user);
    }

    @Test(expected = RejectAccessException.class)
    public void printUser03() {
        User user = new User();
        user.setName("lga");
        user.setAge(22);
        User user1 = helloService.printUser(user);
    }

    @Test(expected = RejectAccessException.class)
    public void printUser04() {
        User user = new User();
        user.setAge(22);
        user.setSalary(9500.0f);
        User user1 = helloService.printUser(user);
    }

    @Test(expected = RejectAccessException.class)
    public void printUser05() {
        UserDaoimpl userDaoimpl = new UserDaoimpl();
        helloService.setUserDao(userDaoimpl);
        User user = new User();
        user.setName("lga");
        user.setAge(22);
        user.setSalary(9500.0f);
        User user1 = helloService.printUser(user);
    }

    @Test(expected = RejectAccessException.class)
    public void printUser06() {
        User user = new User();
        user.setName("lga");
        user.setAge(22);
        user.setSalary(9500.0f);
        context.checking(new Expectations(){
            {
                oneOf(userDao).getUser("name");
                will(returnValue(new User()));
            }
        });
        User user1 = helloService.printUser(user);
    }

    @Test()
    public void printUser07() {
        User user = new User();
        user.setName("lga");
        user.setAge(22);
        user.setSalary(9500.0f);
        context.checking(new Expectations(){
            {
                oneOf(userDao).getUser("lga");
                will(returnValue(null));
            }
        });
        User result = helloService.printUser(user);
        Assert.assertNotNull(result);
    }



    @Test
    public void printUser() {
    }
}