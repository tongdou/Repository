package com.tongdou.aop.spring.advice;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * 方法执行前
 * Created by shenyuzhu on 2017/8/9.
 */
public class WaiterBeforeAdvice implements MethodBeforeAdvice {
    private static Log log = LogFactory.getLog(Waiter.class);

    public void before(Method method, Object[] objects, Object o) throws Throwable {
        log.info(String.format(" Welcome! %s", objects));
    }
}
