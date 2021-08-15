package com.lga.mybatis;

import com.lga.mybatis.vo.Score;
import com.lga.mybatis.vo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.scripting.xmltags.DynamicContext;
import org.apache.ibatis.scripting.xmltags.ExpressionEvaluator;
import org.apache.ibatis.scripting.xmltags.IfSqlNode;
import org.apache.ibatis.scripting.xmltags.StaticTextSqlNode;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class BoundSqlTest {

    private SqlSessionFactory sqlSessionFactory;

    private Configuration configuration;

    @Before
    public void init() {
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        try {
            sqlSessionFactory = sqlSessionFactoryBuilder.build(Resources.getResourceAsReader("configuration.xml"));
            configuration = sqlSessionFactory.getConfiguration();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void ognlTest() {
        ExpressionEvaluator evaluator = new ExpressionEvaluator();
        User user = new User();
        user.setId(1);
        user.setName("lga");
        Score score = new Score();
        score.setId(1);
        score.setMath(100L);
        user.setScore(score);

        user.setScore(null);
        boolean b = evaluator.evaluateBoolean("id != null and score.math != null", user);
        System.out.println("b = " + b);
    }

    @Test
    public void ifTest() {

        User user = new User();
//        user.setId(1);

        DynamicContext context = new DynamicContext(configuration,user);

        //静态节点逻辑
        new StaticTextSqlNode("select * from user where 1=1").apply(context);

        new IfSqlNode(new StaticTextSqlNode(" and id=#{id}"), "id!=null && id != 0").apply(context);

        System.out.println("context.getSql() = " + context.getSql());



    }
}
