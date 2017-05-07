package com.tongdou.user.web;

/**
 * Created by shenyuzhu on 17/2/1.
 */
public class LoginCommand {
    private String password;
    private String userName;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
