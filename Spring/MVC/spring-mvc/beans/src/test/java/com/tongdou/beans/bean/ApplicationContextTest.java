package com.tongdou.beans.bean;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * ApplicationContext Tester
 * 创建Spring容器：
 * 1、读取xml
 * 2、使用注解
 * Created by shenyuzhu on 2017/7/16.
 */
public class ApplicationContextTest {

    public static Log log = LogFactory.getLog(ApplicationContextTest.class);

    /**
     * 测试加载XML配置的bean
     */
    @Test
    public void xmlBeansTest() {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:xmlBeans.xml");
        User user = (User) context.getBean("user");
        user.setId("googogogogog");
        log.info("id===" + user.getId());
    }


    /**
     * 测试加载注解配置的bean
     */
    @Test
    public void annotationBeansTest() {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.tongdou.beans.bean");
        User user = (User) context.getBean("user");
        user.setId("googogogogog");
        log.info("id===" + user.getId());
    }


}
