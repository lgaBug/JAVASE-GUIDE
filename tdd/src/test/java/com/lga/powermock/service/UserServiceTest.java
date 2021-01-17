package com.lga.powermock.service;

import com.lga.powermock.dao.UserDao;
import com.lga.powermock.vo.User;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;

public class UserServiceTest {


//    @Mock
    private UserDao userDao;

//    @InjectMocks
    private UserService userService;

    @Before
    public void setUp() throws Exception {
//        MockitoAnnotations.initMocks(this);

    }

    @Test
    public void should_success_when_mock_count() {
        UserDao userDaoMock = PowerMockito.mock(UserDao.class);
        userService = new UserService(userDaoMock);
        PowerMockito.when(userDaoMock.getCount()).thenReturn(100);
        int count = userService.queryUserCount();
        assertThat(count,equalTo(100));


    }

    @Test
    public void shoud_success_when_db_available() {
        Mockito.when(userDao.getCount()).thenReturn(10);
        int count = userService.queryUserCount();
        assertThat(count,greaterThan(0));
    }

    @Test
    public void test_saveUser_should_success() {
        UserDao userDao = PowerMockito.mock(UserDao.class);
        User user = new User("lga",22);
        userService = new UserService(userDao);
        PowerMockito.doNothing().when(userDao).insertUser(user);
        userService.saveUser(user);
        Mockito.verify(userDao).insertUser(user);
    }



    @Ignore
    @Test
    public void test_queryUserCount() {
        int count = userService.queryUserCount();
    }

    @Ignore
    @Test(expected = UnsupportedOperationException.class)
    public void should_throw_exception_when_db_not_available() {
        int count = userService.queryUserCount();
    }

    @Ignore
    @Test
    public void saveUser() {
    }
}