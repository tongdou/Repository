package com.tongdou.ioc.bean.annotation;

import com.tongdou.ioc.bean.xml.XmlCar;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.beans.Beans;

/**
 * Created by shenyuzhu on 2017/5/14.
 */
public class AnnotationConfigApplicationContextTest {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AnnocationCar.class);
        XmlCar car = context.getBean("car2", XmlCar.class);
        System.out.println(car.getColor());

    }
}
