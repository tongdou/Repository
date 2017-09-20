package com.tongdou.concurrent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 序列数据
 * Created by shenyuzhu on 2017/9/20.
 */
public class SequenceNumber {
    private static Logger logger = LoggerFactory.getLogger(SequenceNumber.class);
    /**
     * Thread local param
     */
    private ThreadLocal<Integer> local = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };


    public Integer getValue() {
        local.set(local.get() + 1);
        return local.get();
    }

    public static void main(String[] args) {

        SequenceNumber sn = new SequenceNumber();
        Thread t1 = new TreadClient(sn);
        Thread t2 = new TreadClient(sn);
        Thread t3 = new TreadClient(sn);

        logger.info("Thread:{}", t1.getId());
        logger.info("Thread:{}", t2.getId());
        logger.info("Thread:{}", t3.getId());

        t1.start();
        t2.start();
        t3.start();
    }


    private static class TreadClient extends Thread {
        private SequenceNumber sequenceNumber;

        public TreadClient(SequenceNumber sequenceNumber) {
            this.sequenceNumber = sequenceNumber;
        }

        public void run() {
            for (int i = 0; i < 3; i++) {
                logger.info("Thread:{}, value:{}", Thread.currentThread().getId(), sequenceNumber.getValue());
            }

        }
    }
}
