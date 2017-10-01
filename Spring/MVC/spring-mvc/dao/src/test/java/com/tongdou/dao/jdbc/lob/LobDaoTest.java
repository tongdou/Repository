package com.tongdou.dao.jdbc.lob;

import com.tongdou.beans.bean.forum.Article;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.net.URL;

/**
 * Created by shenyuzhu on 2017/10/1.
 */
@ContextConfiguration("classpath:com/tongdou/dao/applicationContext.xml")
public class LobDaoTest extends AbstractTestNGSpringContextTests {

    private static Logger logger = LoggerFactory.getLogger(LobDao.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private LobDao lobDao;

    @BeforeClass
    public void initDatabase() {
        String createArticle = "CREATE TABLE `article` (\n" +
                "\t`id` INT (11) NOT NULL AUTO_INCREMENT,\n" +
                "\t`name` VARCHAR (255),\n" +
                "\t`context` LONGTEXT,\n" +
                "\t`image` mediumblob,\n" +
                "\tPRIMARY KEY (`id`)\n" +
                ") ENGINE = INNODB AUTO_INCREMENT = 2 DEFAULT CHARSET = utf8";
        try {
            jdbcTemplate.execute(createArticle);
        } catch (Exception e) {
            logger.error("jdbcTemplate.execute sql:{}", createArticle, e);
        }
    }

    @Test
    public void testInsert() throws Exception {
        Article article = new Article();
        article.setName("明宇");
        article.setContext("小公主");
        article.setImage(new File(this.getClass().getResource("/mingyu.JPG").getPath()));

        lobDao.insert(article);
    }

}