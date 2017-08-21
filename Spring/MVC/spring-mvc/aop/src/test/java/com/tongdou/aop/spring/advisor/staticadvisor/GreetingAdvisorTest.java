package com.tongdou.aop.spring.advisor.staticadvisor;

import com.tongdou.aop.spring.advisor.Buyer;
import com.tongdou.aop.spring.advisor.Seller;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * Created by shenyuzhu on 2017/8/21.
 */
public class GreetingAdvisorTest {
    @Test
    public void staticAdvisor() {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:advisor/static_advisor.xml");
        Buyer buyer = (Buyer) context.getBean("buyerProxy");
        buyer.greetTo();
        buyer.seviceTo();

        Seller seller = (Seller) context.getBean("sellerProxy");
        seller.greetTo();
        seller.seviceTo();


    }

}