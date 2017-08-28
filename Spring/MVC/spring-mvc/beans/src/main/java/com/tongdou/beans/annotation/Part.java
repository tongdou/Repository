package com.tongdou.beans.annotation;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Annotation Test
 * Created by shenyuzhu on 2017/7/25.
 */
@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class Part {

    public Part() {
        System.out.println("construct ==== ");
    }

    @PostConstruct
    public void init() {
        System.out.println("init ==== ");

        this.zookeeper = "120.0.0.1";
        this.key = "FT_ATP";
    }

    @PreDestroy
    public void destroy() {
        System.out.println("destroy================");
    }

    private String zookeeper;
    private String key;

    public String getZookeeper() {
        return zookeeper;
    }

    public void setZookeeper(String zookeeper) {
        this.zookeeper = zookeeper;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
