package com.tongdou.aop.spring.advice;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.WildcardType;
import java.sql.SQLException;

/**
 * 服务员
 * Created by shenyuzhu on 2017/8/9.
 */
public class Waiter {
    private static final Logger log = LoggerFactory.getLogger(WaiterSurroundAdvice.class);

    public String doService(String name) {
        log.info(String.format("doServcie %s ", name));
        return print();
    }

    private String print() {
        log.info("print");
        return "back";
    }


    public void update() {
        throw new RuntimeException("update");
    }

    public void insert() throws SQLException {
        throw new SQLException("insert");
    }


    public void monitorableMethod() {

    }


}