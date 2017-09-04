package com.tongdou.aop.aspectj;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Pre order Aspect
 * Created by shenyuzhu on 2017/9/3.
 */

@Aspect
public class PreOrderAspect {
    Logger logger = LoggerFactory.getLogger(PreOrderAspect.class);

    /*invoke before get*/
    @Before("execution(* getId(..))")
    public void beforeGet() {
        logger.info("beforeGet");
    }

}
