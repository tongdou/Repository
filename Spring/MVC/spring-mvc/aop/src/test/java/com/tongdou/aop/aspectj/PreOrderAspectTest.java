package com.tongdou.aop.aspectj;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.aspectj.annotation.AspectJAdvisorFactory;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by shenyuzhu on 2017/9/3.
 */
public class PreOrderAspectTest {
    Logger logger = LoggerFactory.getLogger(PreOrderAspect.class);

    @Test
    public void testBeforeGet() throws Exception {

        MyOrder myOrder = new MyOrder("id1", "number1");

        AspectJProxyFactory factory = new AspectJProxyFactory();
        factory.setTarget(myOrder);
        factory.addAspect(PreOrderAspect.class);


        Order order = factory.getProxy();
        logger.info(order.getId());
        logger.info(order.getNumber());
    }

    @Test
    public void testAutoBeforeGet() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("aspectj/pre_order_aspect.xml");
        Order order = (Order) context.getBean("myOrder");
        logger.info(order.getId());
        logger.info(order.getNumber());
    }

    @Test
    public void testAutoBeforeGetByAopTag() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("aspectj/pre_order_aspect_auto.xml");
        Order order = (Order) context.getBean("myOrder");
        logger.info(order.getId());
        logger.info(order.getNumber());
    }
}