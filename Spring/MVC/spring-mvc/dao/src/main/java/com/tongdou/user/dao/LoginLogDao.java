package com.tongdou.user.dao;


import com.tongdou.user.domain.LoginLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created by shenyuzhu on 17/1/30.
 */
@Repository
public class LoginLogDao {
    public LoginLogDao() {
        System.out.println("create LoginLogDao===");
    }

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insertLoginLog(LoginLog log) {
        String sqlStr = "insert into t_login_log(user_id,ip,login_datetime)" +
                " values(?,?,?)";

        jdbcTemplate.update(sqlStr, new Object[]{
                log.getUserId(), log.getIp(), log.getLoginDate()
        });
    }
}
