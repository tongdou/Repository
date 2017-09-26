package com.tongdou.service.forum;

import com.tongdou.beans.bean.forum.Forum;
import com.tongdou.beans.bean.forum.Topic;

/**
 * 论坛服务
 * Created by shenyuzhu on 2017/9/23.
 */
public interface ForumService {

    void addTopic(Topic topic);

    void addForum(Forum forum);

    void updateForum(Forum forum);

    Forum getForum(int forumId);

    long getForumNum();


    /**
     * test without transaction
     *
     * @param topic
     */
    public void addWithoutTransactionTopic(final Topic topic);


    /**
     * test proxy transaction
     *
     * @param topic
     */
    public void addTransactionProxyTopic(final Topic topic);

    /**
     * test aop transaction
     *
     * @param topic
     */
    public void addTxAopTopic(final Topic topic);

    /**
     * 测试annotation transaction
     *
     * @param topic
     */
    public void addTxAnnotationTopic(final Topic topic);
}
