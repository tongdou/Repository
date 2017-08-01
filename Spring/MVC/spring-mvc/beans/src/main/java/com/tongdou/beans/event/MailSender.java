package com.tongdou.beans.event;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Created by shenyuzhu on 2017/8/1.
 */
public class MailSender implements ApplicationContextAware {
    private ApplicationContext ctx;

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.ctx = applicationContext;
    }

    public void sender(String destination, String content) {
        MailSendEvent event = new MailSendEvent(this.ctx, destination, content);
        this.ctx.publishEvent(event);
    }
}
