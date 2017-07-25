package com.tongdou.beans.bean;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.logging.Logger;

/**
 * 测试FactoryBean的实现
 * Created by shenyuzhu on 2017/7/23.
 */
public class FactoryBeanTest {
    public static Log log = LogFactory.getLog(FactoryBeanTest.class);

    @Test
    public void factoryBeanTest() {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:factoryBean.xml");
        User user = (User) context.getBean("user");

        log.info("user.id" + user.getId());
        log.info("user.name" + user.getName());

    }
}
