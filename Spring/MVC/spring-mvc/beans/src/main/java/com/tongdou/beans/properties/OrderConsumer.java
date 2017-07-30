package com.tongdou.beans.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 模拟Diamond从数据库中读取资源文件
 * <p>
 * Created by shenyuzhu on 2017/7/30.
 */
@Component
public class OrderConsumer {
    @Value("${rocket.topic}")
    private String topic;

    @Value("${rocket.tags}")
    private String tags;

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }
}
