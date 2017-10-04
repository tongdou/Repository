package com.tongdou.dao.mybatis;

import com.tongdou.beans.bean.forum.Forum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

/**
 * Created by shenyuzhu on 2017/10/4.
 */
@ContextConfiguration(locations = {"classpath:com/tongdou/dao/applicationContext.xml", "classpath:mybatis/AC-mybatis.xml"})
public class ForumTemplateDaoTest extends AbstractTestNGSpringContextTests {
    @Autowired
    ForumTemplateDao forumTemplateDao;

    @Test
    public void testInsert() {
        Forum forum = new Forum();
        forum.setName("申明宇");
        forumTemplateDao.insert(forum);
    }

}