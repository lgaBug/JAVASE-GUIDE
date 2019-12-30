package com.lga.mock;

import com.lga.mock.dao.LoginDao;
import com.lga.mock.pojo.User;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class MockByAnnotationTest {

    @Mock(answer = Answers.RETURNS_DEFAULTS)
    private LoginDao loginDao;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testMock() {

        User lga = loginDao.findAccountByUserNameAndPassword("lga", "123");
        System.out.println("lga = " + lga);
    }


}
