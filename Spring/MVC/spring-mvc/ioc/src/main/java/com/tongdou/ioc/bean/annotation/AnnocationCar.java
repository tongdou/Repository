package com.tongdou.ioc.bean.annotation;

import com.tongdou.ioc.bean.xml.XmlCar;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by shenyuzhu on 2017/5/14.
 */
@Configuration
public class AnnocationCar {
    @Bean(name = "car2")
    public XmlCar buildCar() {
        XmlCar car = new XmlCar();
        car.setColor("black");
        return car;
    }

}
