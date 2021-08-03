package com.lga.mybatis.dao;

import com.lga.mybatis.vo.User;
import org.apache.ibatis.cache.Cache;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class SecondCacheTest {


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
    public void cacheTest() {
        Cache cache = sqlSessionFactory.getConfiguration().getCache("com.lga.mybatis.dao.UserDao");
        cache.putObject("test1", new User());
        cache.getObject("test1");
    }


    /**
     * 二级缓存命中条件：
     * 运行时参数：
     * 1、会话提交
     * 2、sql语句、参数相同
     * 3、相同的statementId
     * 4、RowBounds相同
     *
     * 配置相关：
     * 1、设置 cacheEnabled 为 true
     * 2、namespace 中添加<cache/>
     * 3、flushCache 为false， 如果flushCache 为true，则会清空所有的缓存
     */
    @Test
    public void test1() {
        SqlSession sqlSession1 = sqlSessionFactory.openSession();
        SqlSession sqlSession2 = sqlSessionFactory.openSession();

        User user1 = sqlSession1.getMapper(UserMapper.class).findUserById01(2);
        sqlSession1.commit();

        User user2 = sqlSession2.getMapper(UserMapper.class).findUserById01(2);


    }


}
