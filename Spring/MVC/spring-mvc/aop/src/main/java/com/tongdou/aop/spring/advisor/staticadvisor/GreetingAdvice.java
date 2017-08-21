package com.tongdou.aop.spring.advisor.staticadvisor;

import com.tongdou.aop.spring.advisor.Seller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.adapter.MethodBeforeAdviceInterceptor;

import java.lang.reflect.Method;

/**
 * 接入点
 * Created by shenyuzhu on 2017/8/21.
 */
public class GreetingAdvice implements MethodBeforeAdvice {
    static final Logger logger = LoggerFactory.getLogger(Seller.class);

    public void before(Method method, Object[] args, Object target) throws Throwable {
        logger.info("method {} before", method.getName());
    }
}
