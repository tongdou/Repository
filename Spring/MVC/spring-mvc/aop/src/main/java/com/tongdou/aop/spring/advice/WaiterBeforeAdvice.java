package com.tongdou.aop.spring.advice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * 方法执行前
 * Created by shenyuzhu on 2017/8/9.
 */
public class WaiterBeforeAdvice implements MethodBeforeAdvice {

    private static Logger log = LoggerFactory.getLogger(WaiterBeforeAdvice.class);

    public void before(Method method, Object[] objects, Object o) throws Throwable {
        log.info(String.format(" Welcome! {}", objects));
    }
}
