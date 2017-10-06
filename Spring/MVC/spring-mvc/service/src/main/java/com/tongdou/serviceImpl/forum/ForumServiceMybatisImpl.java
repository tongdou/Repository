package com.tongdou.serviceImpl.forum;

import com.tongdou.beans.bean.forum.Forum;
import com.tongdou.beans.bean.forum.Post;
import com.tongdou.beans.bean.forum.Topic;
import com.tongdou.dao.mybatis.ForumDao;
import com.tongdou.service.forum.ForumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by shenyuzhu on 2017/9/23.
 */
public class ForumServiceMybatisImpl {

    @Autowired
    private ForumDao forumDao;


    /**
     * 测试mybatis事务
     *
     * @param parent
     * @param child
     */
    @Transactional
    public void addTxAnnotationMybatisForum(final Forum parent, final Forum child) {
        forumDao.insert(parent);

        if (true)
            throw new RuntimeException();

        forumDao.insert(child);
    }
}
