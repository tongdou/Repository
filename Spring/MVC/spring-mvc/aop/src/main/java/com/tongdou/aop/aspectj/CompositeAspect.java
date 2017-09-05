package com.tongdou.aop.aspectj;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 符合切面
 * Created by shenyuzhu on 2017/9/5.
 */
@Aspect
public class CompositeAspect {
    Logger logger = LoggerFactory.getLogger(CompositeAspect.class);


    @Before("execution(* com.tongdou.aop.aspectj.*Dao.update*(..)) && !target(com.tongdou.aop.aspectj.CompositeTestDao)")
    public void before() {
        logger.info("before");
    }
}
