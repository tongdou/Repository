package com.tongdou.aop.withoutaop;

/**
 * monitor method invoke time cost
 * Created by shenyuzhu on 2017/8/2.
 */
public class MethodMonitor {


    private String id;
    private String name;
    private long start;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getStart() {
        return start;
    }

    public void setStart(long start) {
        this.start = start;
    }
}
