package com.lga.mybatis;

import com.lga.mybatis.vo.User;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.session.Configuration;
import org.junit.Test;

public class MetaObjectTest {


    @Test
    public void test1() {

        final User user = new User();
        final Configuration configuration = new Configuration();
        final MetaObject metaObject = configuration.newMetaObject(user);


        metaObject.setValue("id", 1);
        System.out.println(user.getId());

        System.out.println(metaObject.findProperty("name", false));

    }

    @Test
    public void test2() {

        Object user = new User();

        Configuration configuration = new Configuration();
        MetaObject metaObject = configuration.newMetaObject(user);

        metaObject.setValue("id", 1);
        metaObject.setValue("name","liugaoan");
        metaObject.setValue("score.math",100L);




        System.out.println(user);


    }
}
