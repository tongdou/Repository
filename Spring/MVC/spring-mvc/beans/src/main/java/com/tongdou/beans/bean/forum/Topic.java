package com.tongdou.beans.bean.forum;


import java.util.ArrayList;
import java.util.List;

/**
 * 标题
 * Created by shenyuzhu on 2017/9/23.
 */
public class Topic {
    private Integer id;
    private String name;
    private List<Post> postList = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Post> getPostList() {
        return postList;
    }

    public void setPostList(List<Post> postList) {
        this.postList = postList;
    }
}
