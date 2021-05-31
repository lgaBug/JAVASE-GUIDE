package com.lga.mybatis.dao;

import com.lga.mybatis.vo.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;


@Slf4j
public class UserDaoTest {

    //Mybatis 通过SqlSessionFactory获取SqlSession, 然后才能通过SqlSession与数据库进行交互
    private static SqlSessionFactory getSessionFactory() {

        SqlSessionFactory sessionFactory = null;
        String resource = "configuration.xml";
        try {
            sessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader(resource));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sessionFactory;
    }


    @Test
    public void testFindAllUsers() {
        SqlSession sqlSession = getSessionFactory().openSession();
        UserDao userMapper = sqlSession.getMapper(UserDao.class);
        User user = userMapper.findUserById(1);
        log.info("user:{}",user);
    }

    @Test
    public void testUserAndScore() {

        SqlSession sqlSession = getSessionFactory().openSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        User user = mapper.find(1);
        System.out.println("user = " + user);

    }

}