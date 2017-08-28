package com.tongdou.aop.spring.advisor.dynamic;

import com.tongdou.aop.spring.advisor.Buyer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.DynamicMethodMatcherPointcut;

import java.lang.reflect.Method;

/**
 * 动态切面
 * Created by shenyuzhu on 2017/8/24.
 */
public class DynamicPointcut extends DynamicMethodMatcherPointcut {
    static final Logger logger = LoggerFactory.getLogger(DynamicPointcut.class);

    @Override
    public boolean matches(Method method, Class<?> targetClass) {
        logger.info("method name {} {}", "matches1", method.getName());
        return "greetTo".equals(method.getName());
    }

    @Override
    public ClassFilter getClassFilter() {
        logger.info("method name {}", "getClassFilter");
        return new ClassFilter() {
            public boolean matches(Class<?> clazz) {
                return Buyer.class.isAssignableFrom(clazz);
            }
        };
    }

    public boolean matches(Method method, Class<?> targetClass, Object[] args) {
        logger.info("method name {}", "matches2");
        return "tom".equals(args[0]) || "jack".equals(args[0]);
    }
}
