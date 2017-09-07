package com.tongdou.aop.aspectj.schame;

/**
 * Just for test
 * Created by shenyuzhu on 2017/9/7.
 */
public class SchemaAspectDao {

    public void save() {
        try {
            Thread.sleep(Math.round(Math.random() * 5000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void update() {
        try {
            Thread.sleep(Math.round(Math.random() * 5000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void query() {
        try {
            Thread.sleep(Math.round(Math.random() * 5000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
