package com.tongdou.redis.jedis;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import redis.clients.jedis.Jedis;

/**
 * Jedis test
 * Created by shenyuzhu on 2017/8/2.
 */
public class TestJedis {
    private static Log log = LogFactory.getLog(TestJedis.class);

    /**
     * create jedis connection
     */
    @Test
    public void testJedisConnection() {
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        String name = jedis.get("user:name");

        log.info(String.format("user:name %s", name));
        jedis.close();
    }

}
