package com.tongdou.beans.bean;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Map;


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

    /**
     * 测试加载XML配置的bean，并且设置bean的值
     */
    @Test
    public void xmlSimpleTest() {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:xmlBeans.xml");
        Simple user = (Simple) context.getBean("simple");
        log.info("id===" + user.getId());
    }

    /**
     * 测试加载XML配置的bean，并且设置bean的值
     */
    @Test
    public void xmlRefTest() {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:xmlBeans.xml");
        Complex user = (Complex) context.getBean("complex");
        log.info("id===" + user.getSimple().getId());
        log.info("id===" + user.getSimple().getName());
    }


    /**
     * 测试加载XML配置的bean，父子之间的引用
     */
    @Test
    public void xmlHierarchyTest() {
        ApplicationContext parentCotext = new ClassPathXmlApplicationContext("classpath:parent.xml");
        ApplicationContext childContext = new ClassPathXmlApplicationContext(new String[]{"classpath:child.xml"}, parentCotext);
        Child user = (Child) childContext.getBean("child");
        log.info("name===" + user.getParent().getName());
    }


    /**
     * 测试加载XML配置，Inner bean
     */
    @Test
    public void xmlInnerBeanTest() {
        ApplicationContext childContext = new ClassPathXmlApplicationContext(new String[]{"classpath:child.xml"});
        Child user = (Child) childContext.getBean("child2");
        log.info("name===" + user.getParent().getName());
    }


    /**
     * 测试加载XML配置，java.util集合类
     */
    @Test
    public void xmlUtilsIocTest() {
        ApplicationContext utilsIocBeans = new ClassPathXmlApplicationContext(new String[]{"classpath:utilsIocBeans.xml"});
        UtilsIoc utilsIoc = (UtilsIoc) utilsIocBeans.getBean("utilsIoc");
        log.info(utilsIoc.getFavorates());
        log.info(utilsIoc.getFriends());
        log.info(utilsIoc.getSills());
        log.info(utilsIoc.getInfo());

    }

    /**
     * 创建java.util包中的类，而不是将java.util中的类注入进去作为属性
     */
    @Test
    public void xmlUtilsClassTest() {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:utilClass.xml");
        List list = (List) context.getBean("list");
        Map map = (Map) context.getBean("map");

        log.info(list);
        log.info(map);
    }

    /**
     * 测试Spring p tag
     */
    @Test
    public void xmlTagPTest() {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:tagP.xml");
        Parent complex = (Parent) context.getBean("complex");
        Parent simple = (Parent) context.getBean("simple");

        log.info(complex.getId() + complex.getName());
        log.info(simple.getId() + simple.getName());
    }
}