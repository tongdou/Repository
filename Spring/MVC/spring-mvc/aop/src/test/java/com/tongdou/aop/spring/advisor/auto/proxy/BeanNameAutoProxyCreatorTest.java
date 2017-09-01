package com.tongdou.aop.spring.advisor.auto.proxy;

import com.tongdou.aop.spring.advisor.Buyer;
import com.tongdou.aop.spring.advisor.Seller;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

/**
 * 通过名称自动创建代理
 * Created by shenyuzhu on 2017/9/1.
 */
public class BeanNameAutoProxyCreatorTest {

    @Test
    public void test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("advisor/bean_name_auto_proxy_creator.xml");

        Buyer buyer = (Buyer) context.getBean("buyer");
        buyer.greetTo();

        Seller seller = (Seller) context.getBean("seller");
        seller.greetTo();

    }
}
