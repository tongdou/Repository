package com.tongdou.serviceImpl.forum;

import com.tongdou.beans.bean.forum.Forum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by shenyuzhu on 2017/10/5.
 */
@ContextConfiguration(locations = {"classpath:/com/tongdou/dao/applicationContext.xml"
        , "classpath:mybatis/AC-mybatis.xml"
        , "classpath:com/tongdou/service/forum/txAnnotationMybatis.xml"})
public class ForumServiceMybatisImplTest extends AbstractTestNGSpringContextTests {

    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private ForumServiceMybatisImpl forumServiceMybatis;

    @Test
    public void testAddTxAnnotationMybatisForum() throws Exception {

        Forum parent = new Forum();
        parent.setName("梁晓斐");

        Forum child = new Forum();
        child.setName("申明宇");

        try {
            forumServiceMybatis.addTxAnnotationMybatisForum(parent, child);
        } catch (Exception e) {
            logger.error("forumServiceMybatis.addTxAnnotationMybatisForum");
        }
    }

}