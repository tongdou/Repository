package com.tongdou.beans.annotation;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.MessageFormat;

/**
 * Part test
 * Created by shenyuzhu on 2017/7/25.
 */
public class PartTest {

    public static Log log = LogFactory.getLog(PartTest.class);

    @Test
    public void partTest() {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:annotation/AnnotationBeans.xml");
        Part part = (Part) context.getBean("part");
        Part part2 = (Part) context.getBean("part");

        ((ClassPathXmlApplicationContext) context).destroy();
        System.gc();
//        log.info(MessageFormat.format("info {0}- {1}- {2}-{3}", part.getClass(), part, part.getZookeeper(), part.getKey()));
//        log.info(MessageFormat.format("info {0}- {1}- {2}-{3}", part2.getClass(), part2, part.getZookeeper(), part.getKey()));


    }
}
