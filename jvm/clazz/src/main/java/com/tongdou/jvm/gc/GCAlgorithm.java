package com.tongdou.jvm.gc;

/**
 * GC Algorithm （GC算法参数）
 * -showversion -XX:+PrintCommandLineFlags -XX:+PrintFlagsFinal
 * -XX:+UseSerialGC  串行GC 新生代和老年代都是串行GC
 * -XX:+UseParNewGC
 * CreateXX:+UseSerialGCd by shenyuzhu on 2017/5/30.
 */
public class GCAlgorithm {

    public static void main(String[] args) {

        System.out.println(Runtime.getRuntime().availableProcessors());
        System.out.println(Runtime.getRuntime().freeMemory());
        System.out.println(Runtime.getRuntime().totalMemory());


    }
}



