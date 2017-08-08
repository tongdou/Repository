package com.tongdou.aop.cglib;

import com.tongdou.aop.proxy.ForumServiceProxyImpl;
import com.tongdou.aop.withoutaop.ForumService;
import com.tongdou.aop.withoutaop.ForumServiceImpl;
import net.sf.cglib.core.DebuggingClassWriter;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test cglib proxy
 * Created by shenyuzhu on 2017/8/8.
 */
public class CglibProxyTest {
    private Log log = LogFactory.getLog(CglibProxy.class);

    @Test
    public void testCglibProxy() {
        // 输出Cglib生产类的class字节码
        log.info(String.format("class path %s", Class.class.getResource("/").getPath()));
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, Class.class.getResource("/").getPath());

        CglibProxy proxy = new CglibProxy();
        ForumServiceProxyImpl service = (ForumServiceProxyImpl) proxy.getProxy(ForumServiceProxyImpl.class);
        service.addTopic("cglib topic");

    }

}