package com.tongdou.aop.spring.advisor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Bean
 * Created by shenyuzhu on 2017/8/21.
 */
public class Seller {
    static final Logger logger = LoggerFactory.getLogger(Seller.class);

    public void greetTo() {
        logger.info("greetTo");
    }

    public void seviceTo() {
        logger.info("serviceTo");
    }

}
