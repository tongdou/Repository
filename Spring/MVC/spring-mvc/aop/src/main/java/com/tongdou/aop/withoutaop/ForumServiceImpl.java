package com.tongdou.aop.withoutaop;

/**
 * implement forumService
 * Created by shenyuzhu on 2017/8/2.
 */
public class ForumServiceImpl implements ForumService {
    public void addTopic(String topic) {
        PerformanceMonitor.begin(String.format("addTopic %s", topic));

        try {
            Thread.sleep(Math.round(Math.random() * 10000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        PerformanceMonitor.print();

    }


    public void removeTopic(String topic) {

        PerformanceMonitor.begin(String.format("removeTopic %s", topic));

        try {
            Thread.sleep(Math.round(Math.random() * 10000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        PerformanceMonitor.print();
    }
}
