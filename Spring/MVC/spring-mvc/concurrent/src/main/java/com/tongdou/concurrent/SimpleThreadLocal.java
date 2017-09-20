package com.tongdou.concurrent;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * thread local variable
 * Created by shenyuzhu on 2017/9/20.
 */
public class SimpleThreadLocal<T> {
    Map<Thread, T> map = Collections.synchronizedMap(new HashMap<Thread, T>());


    public void set(T value) {
        map.put(Thread.currentThread(), value);
    }

    public T get() {
        return map.get(Thread.currentThread());
    }


    public void remove() {
        map.remove(Thread.currentThread());
    }

    protected T initialValue() {
        return null;
    }

}
