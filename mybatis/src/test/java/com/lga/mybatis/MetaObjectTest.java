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
}
