package com.tongdou.aop.aspectj.schame;


import org.aspectj.lang.JoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Test Schame Aspect
 * Created by shenyuzhu on 2017/9/7.
 */
public class SchemaAspect {
    Logger logger = LoggerFactory.getLogger(SchemaAspect.class);
    ThreadLocal<Long> longThreadLocal = new ThreadLocal<Long>();

    public void beforeLog(JoinPoint joinPoint) {
        logger.info("{} start", joinPoint.getSignature().getName());
        longThreadLocal.set(System.currentTimeMillis());
    }

    public void afterLog(JoinPoint joinPoint) {
        logger.info("{} end cost time {}s", joinPoint.getSignature().getName(), (longThreadLocal.get() - System.currentTimeMillis()) / 1000);
    }

}
