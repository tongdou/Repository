package com.tongdou.dao.jdbc.lob;

import com.tongdou.beans.bean.forum.Article;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.AbstractLobCreatingPreparedStatementCallback;
import org.springframework.jdbc.support.lob.LobCreator;
import org.springframework.jdbc.support.lob.LobHandler;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * clob/blob
 * Created by shenyuzhu on 2017/10/1.
 */
@Component
public class LobDao {

    Logger logger = LoggerFactory.getLogger(LobDao.class);
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private LobHandler lobHandler;

    public void insert(final Article article) {
        String sql = "insert into article(name, context, image) values(?,?,?)";
        jdbcTemplate.execute(sql, new AbstractLobCreatingPreparedStatementCallback(this.lobHandler) {
            @Override
            protected void setValues(PreparedStatement ps, LobCreator lobCreator) throws SQLException, DataAccessException {
                ps.setString(1, article.getName());
                lobCreator.setClobAsString(ps, 2, article.getContext());
                try {
                    lobCreator.setBlobAsBytes(ps, 3, FileUtils.readFileToByteArray(article.getImage()));
                } catch (IOException e) {
                    logger.error("setBlobAsBytes", e);
                }
            }
        });
    }


    public List<Article> get() {
        String sql = "select id,name,context,image from article";

        List<Article> articleList = jdbcTemplate.query(sql, new RowMapper<Article>() {
            @Override
            public Article mapRow(ResultSet rs, int rowNum) throws SQLException {
                Article article = new Article();
                article.setId(rs.getInt(1));
                article.setName(rs.getString(2));
                article.setContext(lobHandler.getClobAsString(rs, 3));

                try {
                    File file = File.createTempFile("article", ".tmp");
                    FileUtils.copyInputStreamToFile(lobHandler.getBlobAsBinaryStream(rs, 4), file);
                    article.setImage(file);
                } catch (IOException e) {
                    logger.error("article", e);
                }

                return article;

            }
        });

        return articleList;
    }
}
