package com.tongdou.dao.mybatis;

import com.tongdou.beans.bean.forum.Forum;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

/**
 * Created by shenyuzhu on 2017/10/4.
 */
@ContextConfiguration(locations = {"classpath:com/tongdou/dao/applicationContext.xml", "classpath:mybatis/AC-mybatis.xml"})
public class ForumDaoTest extends AbstractTestNGSpringContextTests {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    @Autowired
    private ForumDao forumDao;

    /**
     * 通过方法名称字符串调用
     */
    @Test
    public void testInsert() {
        Forum forum = new Forum();
        forum.setName("申明宇");
        int rows = sqlSessionTemplate.insert("com.tongdou.dao.mybatis.ForumDao.insert"
                , forum);
        logger.info("rows:{}", rows);
    }

    /**
     * 通过mapper调用
     */
    @Test
    public void testInsertByMapper() {
        Forum forum = new Forum();
        forum.setName("申明宇ByMapper");
        ForumDao forumDao = sqlSessionTemplate.getMapper(ForumDao.class);
        forumDao.insert(forum);
    }


    @Test
    public void testInsertByInterface() {
        Forum forum = new Forum();
        forum.setName("申明宇ByInterface");
        forumDao.insert(forum);
    }


}