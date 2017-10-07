package com.tongdou.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by shenyuzhu on 2017/10/7.
 */
@ContextConfiguration(locations = {"/applicationContext.xml"})
public class SimpleTriggerRunnerTest extends AbstractTestNGSpringContextTests {
    @Autowired
    private SimpleTriggerRunner simpleTriggerRunner;

    @Test
    public void testStartJob() throws Exception {
        simpleTriggerRunner.startJob();
    }

}