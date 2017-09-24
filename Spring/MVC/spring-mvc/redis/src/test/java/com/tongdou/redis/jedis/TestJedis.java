package com.tongdou.redis.jedis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import redis.clients.jedis.Jedis;

/**
 * Jedis test
 * Created by shenyuzhu on 2017/8/2.
 */
public class TestJedis {
    private static Logger log = LoggerFactory.getLogger(TestJedis.class);

    /**
     * create jedis connection
     */
    @Test
    public void testJedisConnection() {
        try {
            Jedis jedis = new Jedis("127.0.0.1", 6379);
            String name = jedis.get("user:name");

            log.info(String.format("user:name %s", name));
            jedis.close();
        } catch (Exception e) {
            log.error("redis server not active");
        }
    }

}
