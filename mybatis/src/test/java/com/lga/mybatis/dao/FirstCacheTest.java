package com.lga.mybatis.dao;

import com.lga.mybatis.vo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * 一级缓存测试
 */
public class FirstCacheTest {

    private static Logger log = Logger.getLogger(FirstCacheTest.class);

    private SqlSession sqlSession;

    @Before
    public void init() {
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        try {
            SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(Resources.getResourceAsReader("configuration.xml"));
            sqlSession = sqlSessionFactory.openSession();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 一级缓存的有效条件
     * 1：sql和参数必须相同
     * 2：statementId必须相同
     * 3：sqlSession必须一样（作用域:会话级别的缓存）
     * 4：rowbound 返回行范围必须相同
     */
    @Test
    public void test1() {
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        User user1 = userDao.findUserById(1);
        User user2 = userDao.findUserById(1);
        System.out.println(user1 == user2);
    }

    /**
     * 缓存失效：
     * 1：手动清空缓存
     * 2：配置flushCache=true
     * 3:执行update操作
     * 4：将缓存作用域设置为STATEMENT
     */
    @Test
    public void test2() {

    }

    @Test
    public void test3() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-beans.xml");
        UserDao userDao = context.getBean(UserDao.class);
        User user1 = userDao.findUserById(2);
        User user2 = userDao.findUserById(2);

        System.out.println(user1 == user2);
    }
}
