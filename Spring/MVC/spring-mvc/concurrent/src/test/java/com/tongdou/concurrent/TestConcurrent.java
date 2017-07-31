package com.tongdou.concurrent;

import com.sun.javafx.binding.StringFormatter;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * concurrent examples
 * Created by shenyuzhu on 2017/7/31.
 */
public class TestConcurrent {
    private static final Log log = LogFactory.getLog(TestConcurrent.class);


    @Test
    public void doFibonacciExecutorService() {
        // 创建线程池
        ExecutorService executorService = Executors.newCachedThreadPool();

        // 创建任务
        List<FutureTask<Long>> futureTasks = new ArrayList<FutureTask<Long>>();
        futureTasks.add(new FutureTask<Long>(new FibonacciTask(48)));
        futureTasks.add(new FutureTask<Long>(new FibonacciTask(10)));

        long start = System.currentTimeMillis();

        // 执行任务
        for (FutureTask<Long> futureTask :
                futureTasks) {
            executorService.submit(futureTask);
        }

        // 返回结果
        List<Long> results = new ArrayList<Long>();
        for (FutureTask<Long> futureTask :
                futureTasks) {
            try {
//                results.add(futureTask.get(10L, TimeUnit.SECONDS));
                results.add(futureTask.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

        long end = System.currentTimeMillis();
        log.info(String.format("cost %s seconds", (end - start) / 1000));
        // 打印结果
        for (Long i :
                results) {
            log.info(String.format("result %s", i));
        }


    }

}
