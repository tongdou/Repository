package com.tongdou.aop.withoutaop;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Map;
import java.util.UUID;

/**
 * monite performance
 * <p>
 * Created by shenyuzhu on 2017/8/2.
 */
public class PerformanceMonitor {
    public static Log log = LogFactory.getLog(PerformanceMonitor.class);


    public static ThreadLocal<MethodMonitor> monitorThreadLocals = new ThreadLocal<MethodMonitor>();


    public static void begin(String name) {
        log.info(String.format("Start monitor %s", name));
        MethodMonitor monitor = new MethodMonitor();
        monitor.setId(UUID.randomUUID().toString().replaceAll("-", ""));
        monitor.setName(name);
        monitor.setStart(System.currentTimeMillis());
        monitorThreadLocals.set(monitor);
    }

    public static void print() {
        MethodMonitor monitor = monitorThreadLocals.get();

        long cost = System.currentTimeMillis() - monitor.getStart();

        log.info(String.format("cost time %s %s %s ms", monitor.getId(), monitor.getName(), cost));

    }

}
