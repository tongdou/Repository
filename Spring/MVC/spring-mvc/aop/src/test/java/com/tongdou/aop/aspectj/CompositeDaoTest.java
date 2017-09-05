package com.tongdou.aop.aspectj;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by shenyuzhu on 2017/9/5.
 */
public class CompositeDaoTest {
    Logger logger = LoggerFactory.getLogger(CompositeAspect.class);


    @Test
    public void testBefore() {
        ApplicationContext context = new ClassPathXmlApplicationContext("aspectj/composite_aspect.xml");

        CompositeDao compositeDao = (CompositeDao) context.getBean("compositeDao");
        CompositeTestDao compositeTestDao = (CompositeTestDao) context.getBean("compositeTestDao");

        compositeDao.update();
        compositeTestDao.update();

    }


}