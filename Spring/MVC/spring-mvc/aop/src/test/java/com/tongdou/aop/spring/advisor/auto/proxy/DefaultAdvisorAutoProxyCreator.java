package com.tongdou.aop.spring.advisor.auto.proxy;

import com.tongdou.aop.spring.advisor.Buyer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

/**
 * 默认切面生成器
 * Created by shenyuzhu on 2017/9/1.
 */
public class DefaultAdvisorAutoProxyCreator {


    @Test
    public void test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("advisor/default_advisor_auto_proxy_creator.xml");
        Buyer buyer = (Buyer) context.getBean("buyer");
        buyer.seviceTo();
        buyer.greetTo();
    }

}
