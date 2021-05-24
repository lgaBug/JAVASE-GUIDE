package com.lga.mybatis.dao;

import com.lga.mybatis.vo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

/**
 * 一级缓存测试
 */
public class FirstCacheTest {

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
        sqlSession.clearCache();
        User user2 = userDao.findUserById(1);

        System.out.println(user1 == user2);


    }
}
