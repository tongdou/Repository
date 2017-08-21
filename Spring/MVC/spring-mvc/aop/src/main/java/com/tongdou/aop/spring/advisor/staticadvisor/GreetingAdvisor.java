package com.tongdou.aop.spring.advisor.staticadvisor;

import com.tongdou.aop.spring.advisor.Buyer;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.StaticMethodMatcherPointcutAdvisor;

import java.lang.reflect.Method;

/**
 * 切点
 * Created by shenyuzhu on 2017/8/21.
 */
public class GreetingAdvisor extends StaticMethodMatcherPointcutAdvisor {

    public boolean matches(Method method, Class<?> targetClass) {
        if ("greetTo".equals(method.getName()))
            return true;
        return false;
    }

    @Override
    public ClassFilter getClassFilter() {
        return new ClassFilter() {
            public boolean matches(Class<?> clazz) {
                return Buyer.class.isAssignableFrom(clazz);
            }
        };
    }
}
