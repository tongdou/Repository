package com.tongdou.job;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Created by shenyuzhu on 2017/10/8.
 */
@Service
public class CronTriggerRunner {
    private static Logger logger = LoggerFactory.getLogger(CronTriggerRunner.class);


    public void startJob() throws SchedulerException {
        JobBuilder jobBuilder = JobBuilder.newJob(SimpleJob.class);

        // 3秒执行一次
        CronScheduleBuilder triggerBuilder = CronScheduleBuilder.cronSchedule("*/1 * * ? * * *");
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity("testSimpleTrigger").withSchedule(triggerBuilder).build();

        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
        scheduler.scheduleJob(jobBuilder.build(), trigger);
        scheduler.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    /**
     * 测试cron表达式的语法
     */
    public static void main(String[] args) {
        CronScheduleBuilder triggerBuilder = null;
//        Support for specifying both a day-of-week AND a day-of-month parameter is not implemented.
        try {
            triggerBuilder = CronScheduleBuilder.cronSchedule("*/3 * * * * * *");
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
//        '?' can only be specified for Day-of-Month -OR- Day-of-Week.
        try {
            triggerBuilder = CronScheduleBuilder.cronSchedule("*/3 * * ? * ? *");
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

    }
}
