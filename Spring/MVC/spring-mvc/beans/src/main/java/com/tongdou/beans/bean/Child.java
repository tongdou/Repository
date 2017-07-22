package com.tongdou.beans.bean;

import org.springframework.stereotype.Component;

/**
 * 儿子xml中的类
 * Created by shenyuzhu on 2017/7/16.
 */
@Component
public class Child {
    private Parent parent;

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }
}
