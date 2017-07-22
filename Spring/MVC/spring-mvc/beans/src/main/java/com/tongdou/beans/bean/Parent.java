package com.tongdou.beans.bean;

import org.springframework.stereotype.Component;

/**
 * 父亲xml中的类
 * Created by shenyuzhu on 2017/7/16.
 */
@Component
public class Parent {
    private String name;
    private String id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
