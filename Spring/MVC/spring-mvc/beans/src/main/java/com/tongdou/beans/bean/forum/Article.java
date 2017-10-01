package com.tongdou.beans.bean.forum;

import java.io.File;

/**
 * Created by shenyuzhu on 2017/10/1.
 */
public class Article {
    private int id;
    private String name;
    /**
     * 内容：clob
     */
    private String context;
    /**
     * 图片：blob
     */
    private File image;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public File getImage() {
        return image;
    }

    public void setImage(File image) {
        this.image = image;
    }
}
