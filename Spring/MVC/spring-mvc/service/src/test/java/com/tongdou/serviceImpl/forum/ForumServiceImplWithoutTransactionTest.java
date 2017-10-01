package com.tongdou.serviceImpl.forum;

import com.tongdou.beans.bean.forum.Forum;
import com.tongdou.beans.bean.forum.Post;
import com.tongdou.beans.bean.forum.Topic;
import com.tongdou.service.forum.ForumService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * 论坛测试类
 * Created by shenyuzhu on 2017/9/23.
 */
@ContextConfiguration(locations = {"classpath:com/tongdou/service/forum/withoutTransaction.xml", "classpath:/com/tongdou/dao/applicationContext.xml"})
public class ForumServiceImplWithoutTransactionTest extends AbstractTestNGSpringContextTests {
    Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    private ForumService forumService;


    @Test
    public void testWithoutTransaction() {
        // create topic
        Topic topic = new Topic();
        topic.setName("withoutTransaction005");

        // create post
        Post post1 = new Post();
        post1.setName("post005_1");

        Post post2 = new Post();
        post2.setName("post005_2");

        topic.getPostList().add(post1);
        topic.getPostList().add(post2);

        // save into database
        try {
            forumService.addWithoutTransactionTopic(topic);
        } catch (Exception e) {
            logger.error("forumService.addWithoutTransactionTopic");
        }

    }


    /**
     * 创建表
     */
    @BeforeClass
    public void initDatabase() {
        String createForum = "CREATE TABLE `forum` (\n" +
                "  `id` int(11) NOT NULL AUTO_INCREMENT,\n" +
                "  `name` varchar(255) DEFAULT NULL,\n" +
                "  PRIMARY KEY (`id`)\n" +
                ") ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8";
        String createTopic = "CREATE TABLE `topic` (\n" +
                "  `id` int(11) NOT NULL AUTO_INCREMENT,\n" +
                "  `name` varchar(255) DEFAULT NULL,\n" +
                "  PRIMARY KEY (`id`)\n" +
                ") ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8";
        String createPost = "CREATE TABLE `post` (\n" +
                "  `id` int(11) NOT NULL AUTO_INCREMENT,\n" +
                "  `name` varchar(255) DEFAULT NULL,\n" +
                "  PRIMARY KEY (`id`)\n" +
                ") ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8";


        logger.info("start init database ");
        try {
            jdbcTemplate.execute(createForum);
            jdbcTemplate.execute(createTopic);
            jdbcTemplate.execute(createPost);
        } catch (Exception e) {
//            logger.error("init database error", e);
        }

        logger.info("end init database ");
    }

    @Test
    public void testAddTopic() throws Exception {
        Topic topic = new Topic();
        topic.setName("topic1");
        forumService.addTopic(topic);
    }


    @Test
    public void testAddForum() throws Exception {
        Forum forum = new Forum();
        forum.setName("forum1");
        forumService.addForum(forum);
    }


    @Test
    public void testUpdateForum() throws Exception {
        Forum forum = new Forum();
        forum.setId(2);
        forum.setName("forum2");
        forumService.updateForum(forum);
    }

    @Test
    public void testGetForum() throws Exception {
//        Forum forum = forumService.getForum(2);
//        logger.info("forum id:{}, name:{}", forum.getId(), forum.getName());
    }

    @Test
    public void testGetForumNum() throws Exception {
        long count = forumService.getForumNum();
        logger.info("count:{}", count);
    }

}