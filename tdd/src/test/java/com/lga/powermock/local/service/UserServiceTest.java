package com.lga.powermock.local.service;

import com.lga.powermock.dao.UserDao;
import com.lga.powermock.vo.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


@RunWith(PowerMockRunner.class)
@PrepareForTest(UserService.class)
public class UserServiceTest {

    private UserService userService;

    private UserDao userDao;

    @Before
    public void setUp() {
        userService = new UserService();
        userDao = PowerMockito.mock(UserDao.class);

    }

    @Test
    public void test_queryUserCount_should_success() throws Exception {
        PowerMockito.whenNew(UserDao.class).withNoArguments().thenReturn(userDao);
        PowerMockito.when(userDao.getCount()).thenReturn(10);
        int count = userService.queryUserCount();
        assertThat(count, equalTo(10));
    }

    @Test
    public void test_saveUser_should_success() throws Exception {
        User user = new User("wl",21);
        PowerMockito.whenNew(UserDao.class).withAnyArguments().thenReturn(userDao);
        PowerMockito.doNothing().when(userDao).insertUser(user);
        userService.saveUser(user);
        Mockito.verify(userDao,Mockito.times(1)).insertUser(user);
    }

}