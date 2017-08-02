package com.tongdou.aop.withoutaop;

/**
 * forum service
 * Created by shenyuzhu on 2017/8/2.
 */
public interface ForumService {
    /**
     * add topic
     *
     * @param topic name
     */
    public void addTopic(String topic);

    /**
     * remove topic
     *
     * @param topic
     */
    public void removeTopic(String topic);
}
