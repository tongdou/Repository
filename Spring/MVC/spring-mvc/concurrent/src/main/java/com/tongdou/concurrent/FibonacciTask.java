package com.tongdou.concurrent;

import java.util.concurrent.Callable;

/**
 * Created by shenyuzhu on 2017/7/31.
 */
public class FibonacciTask implements Callable<Long> {

    public FibonacciTask(int number) {
        this.number = number;
    }

    private int number;

    public Long call() throws Exception {
        return fibonacci(number);
    }

    private long fibonacci(long i) {
        if (i == 0 || i == 1)
            return 1;
        else
            return fibonacci(i - 1) + fibonacci(i - 2);

    }
}
