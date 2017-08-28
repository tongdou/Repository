package com.tongdou.user.dao;


import com.tongdou.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by shenyuzhu on 17/1/30.
 */
@Repository
public class UserDao {
    public UserDao() {
        System.out.println("create dao====");
    }

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int getMatchCount(String userName, String password) {
        String sqlStr = "select count(*) from t_user t where t.user_name=? " +
                "and t.password=?";

        return jdbcTemplate.queryForInt(sqlStr, new Object[]{
                userName, password
        });
    }

    public User findUserByUserName(String userName) {
        String sqlStr = "select * from t_user t where " +
                "t.user_name=?";

        final User user = new User();
        jdbcTemplate.query(sqlStr, new Object[]{userName}, new RowCallbackHandler() {
            public void processRow(ResultSet rs) throws SQLException {
                user.setUserId(rs.getInt("USER_ID"));
                user.setUserName(rs.getString("USER_NAME"));
                user.setCredits(rs.getInt("CREDITS"));
                user.setPassword(rs.getString("password"));
            }
        });

        return user;

    }

    public void updateLoginInfo(User user) {
        String sqlStr = "update t_user t set t.last_ip=?" +
                ",t.last_visit=?,t.credits=? where t.user_id=?";
        jdbcTemplate.update(sqlStr, new Object[]{
                user.getLastIp(), user.getLastVisit(), user.getCredits(), user.getUserId()
        });
    }

}
