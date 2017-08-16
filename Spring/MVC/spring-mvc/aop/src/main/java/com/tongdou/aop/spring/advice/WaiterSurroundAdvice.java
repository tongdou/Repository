package com.tongdou.aop.spring.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by shenyuzhu on 2017/8/16.
 */
public class WaiterSurroundAdvice implements MethodInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(WaiterSurroundAdvice.class);

    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        logger.info("welcome  {}", methodInvocation.getArguments()[0]);

        Object result = methodInvocation.getMethod().invoke(methodInvocation.getThis(), methodInvocation.getArguments());

        logger.info("bye bye {}", methodInvocation.getArguments()[0]);
        return result;
    }

}
