package com.tongdou.aop.withoutaop;

import org.junit.Test;

/**
 * forum service time cost test
 * Created by shenyuzhu on 2017/8/2.
 */
public class TestForumService {
    @Test
    public void testForumService() {

        ForumService service = new ForumServiceImpl();
        service.addTopic("乐视");
        service.removeTopic("贾跃亭");


    }

    public static void main(String[] args) {
        System.out.println("43875141-2321-4fd4-8264-39701a89ebc3".length());
    }

}
