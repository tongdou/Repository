package com.tongdou.annotation;

import javax.annotation.Resource;

/**
 * pojo
 * Created by shenyuzhu on 2017/9/1.
 */
@Resource
public class Sun {
    @NeedTest(true)
    private String name;


    private String value;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NeedTest(false)
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
