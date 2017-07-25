package com.tongdou.beans.bean;

import org.springframework.beans.factory.FactoryBean;

/**
 * Created by shenyuzhu on 2017/7/23.
 */
public class UserFactoryBean implements FactoryBean<User> {


    public User getObject() throws Exception {

        User user = new User();
        user.setId("007");
        user.setName("bluegogo");
        return user;
    }

    public Class<?> getObjectType() {
        return User.class;
    }

    public boolean isSingleton() {
        return false;
    }
}
