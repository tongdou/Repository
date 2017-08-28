package com.tongdou.aop.spring.advisor.controlflow;


import com.tongdou.aop.spring.advisor.Buyer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

/**
 * Test buyer delegate
 * Created by shenyuzhu on 2017/8/28.
 */
public class BuyerDelegateTest {
    @Test
    public void testControlFlow() {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:advisor/control_flow_advisor.xml");
        Buyer buyer = (Buyer) context.getBean("buyer");
        buyer.seviceTo();
        buyer.greetTo();
        //==================


    }
}