package com.lga.mybatis.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;

import java.sql.Connection;
import java.util.Properties;


@Slf4j
@Intercepts({ @Signature(type = StatementHandler.class, method = "query", args = { Connection.class, Integer.class}) })
public class QueryInterceptor implements Interceptor {

    public Object intercept(Invocation invocation) throws Throwable {
        log.info("执行 query 之前");
        Object returnObject = invocation.proceed();
        log.info("执行 query 之后");
        return returnObject;
    }

    public Object plugin(Object target) {
        return null;
    }

    public void setProperties(Properties properties) {

    }
}
