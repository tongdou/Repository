package com.tongdou.beans.i18n;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Locale;

/**
 * test i18n
 * Created by shenyuzhu on 2017/7/31.
 */
public class TestI18N {

    private static final Log log = LogFactory.getLog(TestI18N.class);

    @Test
    public void testI18n() {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:i18n/i18n.xml");

        String zh_CN = context.getMessage("country.name", null, Locale.SIMPLIFIED_CHINESE);
        String en_US = context.getMessage("country.name", null, Locale.US);
        String dfLocale = context.getMessage("country.name", null, Locale.getDefault());


        log.info(String.format("zh_CH %s", zh_CN));
        log.info(String.format("en_US %s", en_US));
        log.info(String.format("dfLocale %s", dfLocale));

    }

}
