package com.lga.powermock.mockostatic.service;

import com.lga.powermock.mockostatic.dao.UserDao;
import com.lga.powermock.vo.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@RunWith(PowerMockRunner.class)
@PrepareForTest({UserService.class,UserDao.class})
public class UserServiceTest {

    private UserService userService;

    @Before
    public void setUp() throws Exception {
        userService = new UserService();
        PowerMockito.mockStatic(UserDao.class);
    }

    @Test
    public void test_queryUserCount_should_success() {
        PowerMockito.when(UserDao.getCount()).thenReturn(100);
        int count = userService.queryUserCount();
        assertThat(count, equalTo(100));
    }

    @Test
    public void test_saveUser_should_success() throws Exception {
        User zs = new User("zs", 22);
        PowerMockito.doNothing().when(UserDao.class,"insertUser",zs);
        userService.saveUser(zs);
        PowerMockito.verifyStatic(UserDao.class);
    }
}