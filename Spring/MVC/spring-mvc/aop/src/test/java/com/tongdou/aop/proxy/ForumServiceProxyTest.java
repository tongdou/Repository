package com.tongdou.aop.proxy;

import com.tongdou.aop.withoutaop.ForumService;
import com.tongdou.aop.withoutaop.ForumServiceImpl;
import org.junit.Test;

import java.lang.reflect.Proxy;

/**
 * Test forum proxy
 * Created by shenyuzhu on 2017/8/5.
 */
public class ForumServiceProxyTest {

    @Test
    public void proxyTest() {
        ForumService service = new ForumServiceProxyImpl();


        // create proxy
        PerformanceHandler handler = new PerformanceHandler(service);
        ForumService proxy = (ForumService) Proxy.newProxyInstance(service.getClass().getClassLoader(), service.getClass().getInterfaces(),
                handler);

        // invoke
        proxy.addTopic("乐视");


    }

}
