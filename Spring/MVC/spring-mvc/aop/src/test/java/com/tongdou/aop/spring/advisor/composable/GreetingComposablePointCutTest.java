package com.tongdou.aop.spring.advisor.composable;

import com.tongdou.aop.spring.advisor.Buyer;
import com.tongdou.aop.spring.advisor.controlflow.BuyerDelegate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by shenyuzhu on 2017/8/30.
 */
public class GreetingComposablePointCutTest {


    @Test
    public void testComposablePointCut() {
        ApplicationContext context = new ClassPathXmlApplicationContext("advisor/composable_point_cut.xml");
        Buyer buyer = (Buyer) context.getBean("buyProxy");

        buyer.greetTo();
        buyer.seviceTo();


        BuyerDelegate delegate = new BuyerDelegate();
        delegate.setBuyer(buyer);
        delegate.service();

    }
}