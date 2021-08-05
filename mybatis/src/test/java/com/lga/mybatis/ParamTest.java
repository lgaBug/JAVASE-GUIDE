package com.lga.mybatis;

import com.lga.mybatis.dao.UserDao;
import com.lga.mybatis.vo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class ParamTest {

    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void init() {
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        try {
            sqlSessionFactory = sqlSessionFactoryBuilder.build(Resources.getResourceAsReader("configuration.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test1() {

        final SqlSession sqlSession = sqlSessionFactory.openSession();
        final UserDao userDao = sqlSession.getMapper(UserDao.class);

        final User user = userDao.findUserById(2);
        System.out.println("user = " + user);


        final User user1 = userDao.get(2, "wl666666");
        System.out.println("user1 = " + user1);
    }


}
