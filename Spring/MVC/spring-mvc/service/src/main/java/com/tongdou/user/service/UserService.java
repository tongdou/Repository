package com.tongdou.user.service;

import com.tongdou.user.dao.LoginLogDao;
import com.tongdou.user.dao.UserDao;
import com.tongdou.user.domain.LoginLog;
import com.tongdou.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by shenyuzhu on 17/1/30.
 */
@Service
public class UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private LoginLogDao loginLogDao;

    public UserService(){
        System.out.println("created service===2222====");
    }

    public boolean hasMatchUser(String userName, String password) {
        int count = userDao.getMatchCount(userName, password);
        return count > 0;
    }


    public User findUserByUserName(String userName) {
        return userDao.findUserByUserName(userName);
    }


    public void loginSuccess(User user) {
        user.setCredits(user.getCredits() + 5);

        LoginLog loginLog = new LoginLog();
        loginLog.setUserId(user.getUserId());
        loginLog.setIp(user.getLastIp());
        loginLog.setLoginDate(new Date());

        userDao.updateLoginInfo(user);
        loginLogDao.insertLoginLog(loginLog);
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public LoginLogDao getLoginLogDao() {
        return loginLogDao;
    }

    public void setLoginLogDao(LoginLogDao loginLogDao) {
        this.loginLogDao = loginLogDao;
    }
}
