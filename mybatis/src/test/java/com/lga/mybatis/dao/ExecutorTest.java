package com.lga.mybatis.dao;

import com.lga.mybatis.vo.User;
import org.apache.ibatis.executor.*;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.session.*;
import org.apache.ibatis.transaction.Transaction;
import org.apache.ibatis.transaction.jdbc.JdbcTransaction;
import org.junit.Before;
import org.junit.Test;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExecutorTest {

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

    /**
     * 简单执行器测试
     */
    @Test
    public void simpleExecutorTest() {

        Executor executor = new SimpleExecutor(configuration, transaction);
        MappedStatement ms = configuration.getMappedStatement("com.lga.mybatis.dao.UserDao.findUserById");

        try {
            executor.query(ms, 2, RowBounds.DEFAULT, SimpleExecutor.NO_RESULT_HANDLER);
            executor.query(ms, 2, RowBounds.DEFAULT, SimpleExecutor.NO_RESULT_HANDLER);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    /**
     * 可重用执行器测试
     */
    @Test
    public void reuseExecutorTest() {

        ReuseExecutor executor = new ReuseExecutor(configuration, transaction);
        MappedStatement ms = configuration.getMappedStatement("com.lga.mybatis.dao.UserDao.findUserById");

        try {
            executor.doQuery(ms, 2, RowBounds.DEFAULT, SimpleExecutor.NO_RESULT_HANDLER, ms.getBoundSql(2));
            executor.doQuery(ms, 2, RowBounds.DEFAULT, SimpleExecutor.NO_RESULT_HANDLER, ms.getBoundSql(2));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    /**
     * 批处理执行器测试
     * 只针对增删改操作
     * 需要手动刷新
     */
    @Test
    public void batchExecutorTest() {

        BatchExecutor executor = new BatchExecutor(configuration, transaction);
        try {

            //更新操作
            MappedStatement updateMs = configuration.getMappedStatement("com.lga.mybatis.dao.UserDao.setName");
            Map<String, Object> map = new HashMap();
            map.put("arg0", 2);
            map.put("arg1", "wl666666");
            executor.doUpdate(updateMs, map);


            Map<String, Object> map2 = new HashMap();
            map2.put("arg0", 1);
            map2.put("arg1", "lga111");
            executor.doUpdate(updateMs, map2);
            executor.flushStatements(false);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    /**
     * 基础执行器
     * 实现一级缓存相关逻辑的地方
     */
    @Test
    public void baseExecutorTest() {

        Executor executor = new SimpleExecutor(configuration, transaction);
        MappedStatement ms = configuration.getMappedStatement("com.lga.mybatis.dao.UserDao.findUserById");
        try {
            executor.query(ms, 2, RowBounds.DEFAULT, SimpleExecutor.NO_RESULT_HANDLER);
            executor.query(ms, 4, RowBounds.DEFAULT, SimpleExecutor.NO_RESULT_HANDLER);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    /**
     * 缓存执行器
     * 实现二级缓存相关逻辑的地方
     */
    @Test
    public void cacheExecutorTest() {
        Executor executor = new SimpleExecutor(configuration, transaction);
        Executor cachingExecutor = new CachingExecutor(executor);

        MappedStatement ms = configuration.getMappedStatement("com.lga.mybatis.dao.UserDao.findUserById");
        try {
            cachingExecutor.query(ms, 2, RowBounds.DEFAULT, SimpleExecutor.NO_RESULT_HANDLER);
            cachingExecutor.commit(true);
            cachingExecutor.query(ms, 2, RowBounds.DEFAULT, SimpleExecutor.NO_RESULT_HANDLER);
            cachingExecutor.query(ms, 2, RowBounds.DEFAULT, SimpleExecutor.NO_RESULT_HANDLER);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Test
    public void sqlSessionTest() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<Object> objects = sqlSession.selectList("com.lga.mybatis.dao.UserDao.findUserById", 2);
        System.out.println("objects.get(0) = " + objects.get(0));
    }


    @Test
    public void test() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        final UserDao userDaoMapper = sqlSession.getMapper(UserDao.class);
        final User user = userDaoMapper.get(1, "lga");
        System.out.println("user = " + user);

    }

}
