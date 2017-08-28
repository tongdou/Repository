package com.tongdou.aop.spring.advisor.dynamic;

import com.tongdou.aop.spring.advisor.Buyer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;


/**
 * testor
 * Created by shenyuzhu on 2017/8/24.
 */
public class DynamicPointcutTest {

    @Test
    public void test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:advisor/dynamic_advisor.xml");
        Buyer buyer = (Buyer) context.getBean("buyProxy");
        buyer.greetTo("tomcat");
        buyer.greetTo("tom");
        buyer.greetTo("cat");
    }

}