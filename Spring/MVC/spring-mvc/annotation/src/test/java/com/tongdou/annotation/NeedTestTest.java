package com.tongdou.annotation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.lang.annotation.Annotation;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * testor
 * Created by shenyuzhu on 2017/9/1.
 */
public class NeedTestTest {
    Logger logger = LoggerFactory.getLogger(NeedTestTest.class);
    private Annotation annotation;

    @Test
    public void test() {

        // class annotation
        Annotation[] annotations = Sun.class.getAnnotations();
        for (Annotation annotation : annotations) {
            logger.info("class name {} annotaions {}", Sun.class.getName(), annotation.toString());
        }

        // method annotation
        Method[] methods = Sun.class.getDeclaredMethods();
        for (Method m : methods) {
            logger.info("method name {} annotaions {}", m.getName(), m.getAnnotation(NeedTest.class));
        }

        // field annotation
        Field[] fields = Sun.class.getDeclaredFields();
        for (Field f : fields) {
            logger.info("field name {}, annotaions {}", f.getName(), f.getAnnotation(NeedTest.class));
        }
    }
}