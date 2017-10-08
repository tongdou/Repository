package com.tongdou.job.quartz.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by shenyuzhu on 2017/10/8.
 */
@ContextConfiguration(locations = {"/applicationContext.xml", "/quartz/job.xml"})
public class MyJobTest extends AbstractTestNGSpringContextTests {
    Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    public void testExecute() {
        logger.info("load /quartz/job.xml");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}