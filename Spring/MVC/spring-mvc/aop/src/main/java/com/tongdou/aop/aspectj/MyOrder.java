package com.tongdou.aop.aspectj;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by shenyuzhu on 2017/9/3.
 */
public class MyOrder implements Order {

    Logger logger = LoggerFactory.getLogger(MyJob.class);

    public MyOrder() {
    }

    public MyOrder(String id, String number) {
        this.id = id;
        this.number = number;
    }

    private String id;
    private String number;


    public String getId() {
        logger.info("getId");
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
