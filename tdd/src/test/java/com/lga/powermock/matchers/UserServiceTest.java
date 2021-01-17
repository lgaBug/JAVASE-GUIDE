package com.lga.powermock.matchers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;

@RunWith(PowerMockRunner.class)
@PrepareForTest({UserService.class, UserDao.class})
public class UserServiceTest {

    @Mock
    private UserDao userDao;

    @InjectMocks
    private UserService userService;

    @Test
    public void test_find_should_success() throws Exception {
        PowerMockito.whenNew(UserDao.class).withAnyArguments().thenReturn(userDao);
        PowerMockito.when(userDao.find(Matchers.argThat(new MyArgumentMatcher()))).thenReturn("刘高安");
        String name = userService.find("lga123");
        assertThat(name, equalTo("刘高安"));

        String name1 = userService.find("lga12");
        assertThat(name1, equalTo("刘高安"));

        String name2 = userService.find("lga");
        assertThat(name2, not("刘高安"));
    }

    @Test
    public void test_find_when_answer_should_success() throws Exception {
        PowerMockito.whenNew(UserDao.class).withAnyArguments().thenReturn(userDao);
        PowerMockito.when(userDao.find(Mockito.anyString())).then(invocation -> {
            String args = (String) invocation.getArguments()[0];
            return args + "66666";
        });
        String name2 = userService.find("lga");
        assertThat(name2, equalTo("lga66666"));
    }

    private class MyArgumentMatcher implements ArgumentMatcher<String> {
        @Override
        public boolean matches(String t) {
            return t.length() > 3;
        }
    }
}