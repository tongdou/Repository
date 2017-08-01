package com.tongdou.beans.event;

import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ApplicationContextEvent;

/**
 * Send mail event
 * Created by shenyuzhu on 2017/8/1.
 */
public class MailSendEvent extends ApplicationContextEvent {

    private String destination;


    private String content;


    /**
     * Create a new ContextStartedEvent.
     *
     * @param source the {@code ApplicationContext} that the event is raised for
     *               (must not be {@code null})
     */
    public MailSendEvent(ApplicationContext source, String destination, String content) {
        super(source);
        this.destination = destination;
        this.content = content;
    }


    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
