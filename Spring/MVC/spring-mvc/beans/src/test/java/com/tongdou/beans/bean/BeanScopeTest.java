package com.tongdou.beans.bean;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;


/**
 * ApplicationContext Tester
 * 测试bean的作用域
 * Created by shenyuzhu on 2017/7/16.
 */
public class BeanScopeTest {

    public static Log log = LogFactory.getLog(BeanScopeTest.class);

    /**
     * 测试加载XML配置的bean
     */
    @Test
    public void xmlBeanSingletonTest() {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:beanScopeSingleton.xml");
        Complex complex1 = (Complex) context.getBean("complex1");
        Complex complex2 = (Complex) context.getBean("complex2");
        Complex complex3 = (Complex) context.getBean("complex3");

        log.info(complex1.getSimple());
        log.info(complex2.getSimple());
        log.info(complex3.getSimple());

    }


    /**
     * 测试加载XML配置的bean
     */
    @Test
    public void xmlBeanPrototypeTest() {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:beanScopeSingleton.xml");
        Complex complex1 = (Complex) context.getBean("complex2_1");
        Complex complex2 = (Complex) context.getBean("complex2_2");
        Complex complex3 = (Complex) context.getBean("complex2_3");

        log.info(complex1.getSimple());
        log.info(complex2.getSimple());
        log.info(complex3.getSimple());

    }
}