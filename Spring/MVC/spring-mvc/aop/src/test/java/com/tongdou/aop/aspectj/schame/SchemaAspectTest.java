package com.tongdou.aop.aspectj.schame;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by shenyuzhu on 2017/9/7.
 */
public class SchemaAspectTest {

    @Test
    public void test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:aspectj/shema/schema_aspect.xml");
        SchemaAspectDao dao = (SchemaAspectDao) context.getBean("dao");
        dao.query();
        dao.save();
    }

}