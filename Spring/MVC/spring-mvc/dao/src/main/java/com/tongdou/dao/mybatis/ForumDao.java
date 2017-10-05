package com.tongdou.dao.mybatis;

import com.tongdou.beans.bean.forum.Forum;

/**
 * use mybatis template
 * Created by shenyuzhu on 2017/10/4.
 */
public interface ForumDao {
    /**
     * 插入
     *
     * @param forum
     * @return
     */
    void insert(Forum forum);
}
