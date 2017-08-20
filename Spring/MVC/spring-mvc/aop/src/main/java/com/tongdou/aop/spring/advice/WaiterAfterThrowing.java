package com.tongdou.aop.spring.advice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.AfterAdvice;
import org.springframework.aop.ThrowsAdvice;

import java.sql.SQLException;

/**
 * 异常抛出增强
 * Created by shenyuzhu on 2017/8/20.
 */
public class WaiterAfterThrowing implements ThrowsAdvice {

    public static final Logger logger = LoggerFactory.getLogger(WaiterAfterThrowing.class);

    public void afterThrowing(SQLException e) {
        logger.info("afterThrowing SQLException {}", e.getErrorCode());
    }

    public void afterThrowing(Exception e) {
        logger.info("afterThrowing Exception ", e.getCause());
    }
}
