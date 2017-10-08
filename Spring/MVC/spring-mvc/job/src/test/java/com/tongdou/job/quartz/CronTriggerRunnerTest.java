package com.tongdou.job.quartz;

import com.tongdou.job.quartz.CronTriggerRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

/**
 * Created by shenyuzhu on 2017/10/8.
 */
@ContextConfiguration(locations = {"/applicationContext.xml"})
public class CronTriggerRunnerTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private CronTriggerRunner cronTriggerRunner;

    @Test
    public void testStartJob() throws Exception {
        cronTriggerRunner.startJob();
    }

}