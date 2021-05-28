package com.lga.mybatis.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Properties;


@Slf4j
@Intercepts({ @Signature(type = StatementHandler.class, method = "query", args = {Statement.class, ResultHandler.class}) })
public class QueryInterceptor implements Interceptor {


    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        log.info("执行 query 之前");
        Object returnObject = invocation.proceed();
        log.info("执行 query 之后");
        return returnObject;
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
