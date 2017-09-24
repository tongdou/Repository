package com.tongdou.serviceImpl.forum;

import com.tongdou.beans.bean.forum.Forum;
import com.tongdou.beans.bean.forum.Post;
import com.tongdou.beans.bean.forum.Topic;
import com.tongdou.service.forum.ForumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.*;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by shenyuzhu on 2017/9/23.
 */
@Service
public class ForumServiceImpl implements ForumService {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public void addTransactionProxyTopic(final Topic topic) {
        // save topic
        String sql = "insert into topic(name) values(?)";
        jdbcTemplate.update(sql, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setString(1, topic.getName());
            }
        });

        if (true) {
            throw new RuntimeException();
        }

        // save post
        String savePostSql = "insert into post(name) values(?)";
        final List<Post> postList = topic.getPostList();
        jdbcTemplate.batchUpdate(savePostSql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                Post post = postList.get(i);
                ps.setString(1, post.getName());
            }

            @Override
            public int getBatchSize() {
                return postList.size();
            }
        });
    }


    public void addWithoutTransactionTopic(final Topic topic) {
        // save topic
        String sql = "insert into topic(name) values(?)";
        jdbcTemplate.update(sql, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setString(1, topic.getName());
            }
        });

        if (true) {
            throw new RuntimeException();
        }

        // save post
        String savePostSql = "insert into post(name) values(?)";
        final List<Post> postList = topic.getPostList();
        jdbcTemplate.batchUpdate(savePostSql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                Post post = postList.get(i);
                ps.setString(1, post.getName());
            }

            @Override
            public int getBatchSize() {
                return postList.size();
            }
        });
    }

    public void addTopic(final Topic topic) {
        // save topic
        String sql = "insert into topic(name) values(?)";
        jdbcTemplate.update(sql, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setString(1, topic.getName());
            }
        });

        // save post
        String savePostSql = "insert into post(name) values(?)";
        final List<Post> postList = topic.getPostList();
        jdbcTemplate.batchUpdate(savePostSql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                Post post = postList.get(i);
                ps.setString(1, post.getName());
            }

            @Override
            public int getBatchSize() {
                return postList.size();
            }
        });
    }


    @Override
    public void addForum(final Forum forum) {
        String sql = "insert into forum(name) values(?)";
        jdbcTemplate.update(sql, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setString(1, forum.getName());
            }
        });
    }

    public void updateForum(final Forum forum) {
        String sql = "update forum set NAME =? where id=?";
        jdbcTemplate.update(sql, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setString(1, forum.getName());
                ps.setInt(2, forum.getId());
            }
        });
    }

    public Forum getForum(final int forumId) {
        String sql = "select * from forum where id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{forumId}, new RowMapper<Forum>() {
            @Override
            public Forum mapRow(ResultSet rs, int rowNum) throws SQLException {
                Forum forum = new Forum();
                forum.setId(rs.getInt("id"));
                forum.setName(rs.getString("name"));
                return forum;
            }
        });
    }

    public long getForumNum() {
        String sql = "select count(1) as count from forum";
        return jdbcTemplate.queryForObject(sql, new RowMapper<Long>() {
            @Override
            public Long mapRow(ResultSet rs, int rowNum) throws SQLException {
                return rs.getLong("count");
            }
        });
    }
}
