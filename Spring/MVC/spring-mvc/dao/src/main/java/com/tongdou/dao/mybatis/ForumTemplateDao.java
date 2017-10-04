package com.tongdou.dao.mybatis;

import com.tongdou.beans.bean.forum.Forum;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * use mybatis template
 * Created by shenyuzhu on 2017/10/4.
 */
public class ForumTemplateDao {

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    public int insert(Forum forum) {
        return sqlSessionTemplate.insert("com.tongdou.dao.mybatis.ForumTemplateDao.insert"
                , forum);
    }

}
