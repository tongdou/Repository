package com.tongdou.aop.aspectj;

import com.tongdou.aop.spring.advisor.Buyer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by shenyuzhu on 2017/9/4.
 */
public class EnableDeclearParentsTest {
    Logger logger = LoggerFactory.getLogger(MyJob.class);

    @Test
    public void test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("aspectj/enable_declear_parents.xml");

        Job job = (Job) context.getBean("myJob");
        job.start();

        Order order = (Order) job;
        order.getId();
    }
}