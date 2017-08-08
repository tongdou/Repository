package com.tongdou.aop.cglib;


import com.tongdou.aop.withoutaop.PerformanceMonitor;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Cglib proxy
 * Created by shenyuzhu on 2017/8/8.
 */
public class CglibProxy implements MethodInterceptor {
    private Enhancer enhancer = new Enhancer();


    public Object getProxy(Class clazz) {
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        return enhancer.create();

    }

    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        Object result = null;
        PerformanceMonitor.begin(String.format("method %s class instance %s ", method.getName(), o.getClass()));
        result = methodProxy.invokeSuper(o, objects);
        PerformanceMonitor.print();
        return result;
    }
}
