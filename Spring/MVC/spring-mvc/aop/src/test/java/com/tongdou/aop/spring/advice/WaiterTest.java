package com.tongdou.aop.spring.advice;

import org.junit.Test;
import org.springframework.aop.framework.ProxyFactory;

import static org.junit.Assert.*;

/**
 * Waiter tester
 * Created by shenyuzhu on 2017/8/9.
 */
public class WaiterTest {
    @Test
    public void doService() throws Exception {
        WaiterBeforeAdvice advice = new WaiterBeforeAdvice();
        Waiter t = new Waiter();

        ProxyFactory pf = new ProxyFactory();
        pf.setTarget(t);
        pf.addAdvice(advice);

        Waiter proxy = (Waiter) pf.getProxy();
        proxy.doService("tom");
    }

}