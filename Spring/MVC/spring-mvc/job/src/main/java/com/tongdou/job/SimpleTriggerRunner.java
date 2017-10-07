package com.tongdou.job;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.triggers.SimpleTriggerImpl;
import org.springframework.stereotype.Service;

/**
 * Created by shenyuzhu on 2017/10/7.
 */
@Service
public class SimpleTriggerRunner {
    /**
     * start a job
     */
    public void startJob() throws SchedulerException {
        JobBuilder jobBuilder = JobBuilder.newJob(SimpleJob.class);

        // 3秒执行一次
        SimpleScheduleBuilder triggerBuilder = SimpleScheduleBuilder.repeatSecondlyForever(3);
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity("testSimpleTrigger").withSchedule(triggerBuilder).build();

        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
        scheduler.scheduleJob(jobBuilder.build(), trigger);
        scheduler.start();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
