package com.tongdou.aop.aspectj;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by shenyuzhu on 2017/9/4.
 */
public class MyJob implements Job {
    Logger logger = LoggerFactory.getLogger(MyJob.class);

    public void stop() {
        logger.info("stop");
    }

    public void start() {
        logger.info("start");

    }
}
