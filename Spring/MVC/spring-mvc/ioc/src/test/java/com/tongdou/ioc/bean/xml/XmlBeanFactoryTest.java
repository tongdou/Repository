package com.tongdou.ioc.bean.xml;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * Created by shenyuzhu on 2017/5/14.
 */
public class XmlBeanFactoryTest {
    public static void main(String[] args) {
        Resource beans = new ClassPathResource("com/tongdou/ioc/xmlBeans.xml");
        BeanFactory xmlFactory = new XmlBeanFactory(beans);

        XmlCar car = xmlFactory.getBean("car5", XmlCar.class);
        System.out.println(car.getColor());

        // test git
        // test git2
    }
}
