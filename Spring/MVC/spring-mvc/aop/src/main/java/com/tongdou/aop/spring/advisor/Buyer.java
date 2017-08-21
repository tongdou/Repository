package com.tongdou.aop.spring.advisor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * bean
 * Created by shenyuzhu on 2017/8/21.
 */
public class Buyer {
    static final Logger logger = LoggerFactory.getLogger(Seller.class);

    public void greetTo() {
        logger.info("greetTo");
    }

    public void seviceTo() {
        logger.info("serviceTo");
    }

}
