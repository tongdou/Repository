package com.tongdou.aop.aspectj;


/**
 * Created by shenyuzhu on 2017/9/3.
 */
public class MyOrder implements Order {
    public MyOrder() {
    }

    public MyOrder(String id, String number) {
        this.id = id;
        this.number = number;
    }

    private String id;
    private String number;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
