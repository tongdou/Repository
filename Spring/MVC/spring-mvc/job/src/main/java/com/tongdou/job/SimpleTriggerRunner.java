package com.tongdou.job;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
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

        TriggerBuilder triggerBuilder = TriggerBuilder.newTrigger();
        triggerBuilder.startNow();

        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
        scheduler.scheduleJob(jobBuilder.build(), triggerBuilder.build());
        scheduler.start();
    }
}
