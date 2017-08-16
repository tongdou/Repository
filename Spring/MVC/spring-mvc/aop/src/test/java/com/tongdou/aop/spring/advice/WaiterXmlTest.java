package com.tongdou.aop.spring.advice;

import org.junit.Test;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Waiter tester for xml
 * Created by shenyuzhu on 2017/8/9.
 */
public class WaiterXmlTest {
    @Test
    public void before_advice() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:before_advice.xml");
        Waiter waiter = (Waiter) context.getBean("proxyWaiter");
        waiter.doService("Jim");

    }


    @Test
    public void after_advice() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:after_returning_advice.xml");
        Waiter waiter = (Waiter) context.getBean("proxyWaiter");
        waiter.doService("mark");

    }

    @Test
    public void surround_test() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:surround_advice.xml");
        Waiter waiter = (Waiter) context.getBean("proxyWaiter");
        waiter.doService("tongdou");
    }


}