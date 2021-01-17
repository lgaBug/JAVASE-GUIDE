package com.lga.powermock.verify;

import com.lga.powermock.vo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;


@RunWith(PowerMockRunner.class)
@PrepareForTest({UserService.class,UserDao.class})
public class UserServiceTest {

    @Mock
    private User user;

    @Mock
    private UserDao userDao;

    @InjectMocks
    private UserService userService;

    @Test
    public void saveOrUpdate() throws Exception {
        PowerMockito.whenNew(UserDao.class).withAnyArguments().thenReturn(userDao);
        PowerMockito.when(userDao.getUser(user)).thenReturn(1);
        PowerMockito.doNothing().when(userDao).update(user);
        userService.saveOrUpdate(user);
        Mockito.verify(userDao).update(user);
        Mockito.verify(userDao,Mockito.never()).insertUser(user);
    }
}