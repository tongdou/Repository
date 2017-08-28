package com.tongdou.aop.spring.advice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

import java.sql.SQLException;

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

    @Test
    public void afterThrowingInsert() throws SQLException {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:after_throwing_advice.xml");
        Waiter waiter = (Waiter) context.getBean("waiterProxy");
        try {
            waiter.insert();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void afterThrowingUpdate() throws SQLException {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:after_throwing_advice.xml");
        Waiter waiter = (Waiter) context.getBean("waiterProxy");
        try {
            waiter.update();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    @Test
    public void delegatingInterceptor() throws SQLException {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:delegating_interceptor_advice.xml");
        Waiter waiter = (Waiter) context.getBean("waiterProxy");

        // not monitorable
        waiter.monitorableMethod();

        // monitorable
        Monitorable monitorable = (Monitorable) context.getBean("waiterProxy");
        monitorable.setMonitorActive(true);
        waiter.monitorableMethod();

    }
}