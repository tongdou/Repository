package com.tongdou.aop.proxy;

import com.tongdou.aop.withoutaop.ForumService;
import com.tongdou.aop.withoutaop.PerformanceMonitor;

/**
 * implement forumService
 * Created by shenyuzhu on 2017/8/2.
 */
public class ForumServiceProxyImpl implements ForumService {
    public void addTopic(String topic) {

        try {
            Thread.sleep(Math.round(Math.random() * 10000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }


    public void removeTopic(String topic) {


        try {
            Thread.sleep(Math.round(Math.random() * 10000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
