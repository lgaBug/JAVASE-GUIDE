package com.lga.mock;

import com.lga.mock.dao.LoginDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class MockByRunnerTest {

    @Test
    public void testMock() {

        LoginDao mockLogindao = mock(LoginDao.class, Mockito.RETURNS_SMART_NULLS);
        int i = mockLogindao.deleteAccount("lga", "123");
        System.out.println("i = " + i);

    }
}
