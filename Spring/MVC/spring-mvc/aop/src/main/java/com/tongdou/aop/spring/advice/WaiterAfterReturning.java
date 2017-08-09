package com.tongdou.aop.spring.advice;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * after return advice
 * Created by shenyuzhu on 2017/8/9.
 */
public class WaiterAfterReturning implements AfterReturningAdvice {
    private static Log log = LogFactory.getLog(Waiter.class);

    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        log.info(String.format("bye bye %s", objects));
    }
}
