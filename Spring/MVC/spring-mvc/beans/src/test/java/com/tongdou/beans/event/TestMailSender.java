package com.tongdou.beans.event;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

/**
 * Created by shenyuzhu on 2017/8/1.
 */
public class TestMailSender {

    @Test
    public void testMailSender() {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:event/event.xml");
        MailSender mailSender = (MailSender) context.getBean("mailSender");
        mailSender.sender("sadfs@qq.com", "Hello world!");
    }
}
