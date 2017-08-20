package com.tongdou.aop.spring.advice;

import com.tongdou.aop.withoutaop.PerformanceMonitor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;

/**
 * 引介增强
 * Created by shenyuzhu on 2017/8/20.
 */
public class DelegatingInterceptor extends DelegatingIntroductionInterceptor implements Monitorable {
    public static Logger log = LoggerFactory.getLogger(PerformanceMonitor.class);

    /**
     * 记录线程是否开启监控
     */
    private ThreadLocal<Boolean> monitorActive = new ThreadLocal<Boolean>();

    public void setMonitorActive(boolean active) {
        monitorActive.set(active);
    }

    @Override
    public Object invoke(MethodInvocation mi) throws Throwable {
        if (monitorActive.get() != null && monitorActive.get()) {
            PerformanceMonitor.begin("start monitor   " + mi.getMethod().getName());
            return super.invoke(mi);
        } else {
            return super.invoke(mi);
        }
    }
}