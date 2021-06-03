package com.lga.mybatis.dao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.Transaction;
import org.apache.ibatis.transaction.jdbc.JdbcTransaction;
import org.junit.Before;
import org.junit.Test;

import java.sql.DriverManager;

public class BlogTest {


    private SqlSessionFactory sqlSessionFactory;

    private Configuration configuration;
    private Transaction transaction;

    @Before
    public void init() {
        String resource = "configuration.xml";
        try {
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader(resource));
            configuration = sqlSessionFactory.getConfiguration();
            transaction = new JdbcTransaction(DriverManager.getConnection("jdbc:mysql://101.133.164.37:3306/mybatis", "root", "123456"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    public void test() {
        final SqlSession sqlSession = sqlSessionFactory.openSession();
        Object blog = sqlSession.selectOne("com.lga.mybatis.dao.BlogDao.selectBlogByBlogId", 1);
        System.out.println(blog);
    }
}
