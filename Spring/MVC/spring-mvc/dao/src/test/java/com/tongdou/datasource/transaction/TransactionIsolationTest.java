package com.tongdou.datasource.transaction;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import javax.annotation.Resource;
import javax.swing.*;

import static org.testng.Assert.*;

/**
 * Created by shenyuzhu on 2017/9/17.
 */
@ContextConfiguration(locations = {"classpath:com/tongdou/dao/applicationContext.xml"})
public class TransactionIsolationTest extends AbstractTestNGSpringContextTests {
    @Resource(name = "transactionIsolation")
    private TransactionIsolation transactionIsolation;


    @Test
    public void testIsolationInfo() throws Exception {
        transactionIsolation.isolationInfo();
    }

}