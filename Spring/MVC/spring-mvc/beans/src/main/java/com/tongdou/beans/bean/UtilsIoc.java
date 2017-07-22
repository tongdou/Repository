package com.tongdou.beans.bean;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * java.util包中类的注入：List，Map，Set，Properties
 * Created by shenyuzhu on 2017/7/21.
 */
public class UtilsIoc {
    private List favorates;
    private Set friends;
    private Map sills;
    private Properties info;

    public Set getFriends() {
        return friends;
    }

    public void setFriends(Set friends) {
        this.friends = friends;
    }

    public Map getSills() {
        return sills;
    }

    public void setSills(Map sills) {
        this.sills = sills;
    }

    public Properties getInfo() {
        return info;
    }

    public void setInfo(Properties info) {
        this.info = info;
    }

    public List getFavorates() {
        return favorates;
    }

    public void setFavorates(List favorates) {
        this.favorates = favorates;
    }


}
