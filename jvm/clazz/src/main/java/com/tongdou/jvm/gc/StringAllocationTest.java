package com.tongdou.jvm.gc;

import java.util.ArrayList;
import java.util.List;

/**
 * String 对象是分配在堆内存还是方法区，测试用例
 * <p>
 * -showversion -XX:+PrintCommandLineFlags -XX:+PrintFlagsFinal -Xms3m -Xmx3m -XX:NewSize=1m  -XX:MaxNewSize=1m  -XX:NewRatio=2
 * Created by shenyuzhu on 2017/5/30.
 */
public class StringAllocationTest {

    static String base = "string";

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            String str = base + base;
            base = str;
            list.add(str.intern());
        }
    }
}
