package com.tongdou.job.quartz.spring;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

import java.util.Map;

/**
 * Created by shenyuzhu on 2017/10/8.
 */
public class MyJob implements Job {
    Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        Map dataMap = context.getJobDetail().getJobDataMap();

        String size = (String) dataMap.get("size");
        ApplicationContext applicationContext = (ApplicationContext) dataMap.get("applicationContext");


        logger.info("size:{}", size);
        logger.info("applicationContext:{}", applicationContext);


        Map triggerDataMap = context.getTrigger().getJobDataMap();
        String count = (String) triggerDataMap.get("count");
        logger.info("count:{}", count);
    }
}
