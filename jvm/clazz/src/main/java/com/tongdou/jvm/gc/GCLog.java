package com.tongdou.jvm.gc;

import java.util.ArrayList;
import java.util.List;

/**
 * -showversion  -XX:+PrintCommandLineFlags -Xms10m -Xmx10m -XX:+PrintGCDetails  -XX:+PrintGCTimeStamps -XX:+PrintGCDateStamps  -Xloggc:/tmp/gc.log
 * Created by shenyuzhu on 2017/5/30.
 */
public class GCLog {


    public static void main(String[] args) throws Exception {
        List<MemoryObject> objects = new ArrayList<MemoryObject>(6);
        for (int i = 0; i < 8; i++) {
            objects.add(new MemoryObject(1024 * 1024));
        }

        objects.clear();
        System.out.println("1====");
        Thread.sleep(2000);

        for (int i = 0; i < 6; i++) {
            objects.add(new MemoryObject(1024 * 1024));
        }
        System.out.println("2====");
        Thread.sleep(2000);
    }


}

class MemoryObject {
    private byte[] bytes;

    public MemoryObject(int objectSize) {
        this.bytes = new byte[objectSize];
    }
}