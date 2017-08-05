package com.tongdou.aop.proxy;

import com.tongdou.aop.withoutaop.ForumService;
import com.tongdou.aop.withoutaop.PerformanceMonitor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Performance handler for proxy invoke
 * Created by shenyuzhu on 2017/8/5.
 */
public class PerformanceHandler implements InvocationHandler {
    private ForumService target;

    public PerformanceHandler(ForumService forumService) {
        this.target = forumService;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        PerformanceMonitor.begin(String.format(" %s proxy", method.getName()));
        method.invoke(target, args);
        PerformanceMonitor.print();
        return null;
    }
}
