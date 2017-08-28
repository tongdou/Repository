package com.tongdou.beans.event;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationListener;

/**
 * mail listener
 * Created by shenyuzhu on 2017/8/1.
 */
public class MailSendListener implements ApplicationListener<MailSendEvent> {
    private static final Log log = LogFactory.getLog(MailSendListener.class);

    public void onApplicationEvent(MailSendEvent event) {
        log.info(String.format(" %s =====> %s", event.getContent(), event.getDestination()));
    }
}
