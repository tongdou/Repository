package com.tongdou.jvm.gc;

import java.util.ArrayList;
import java.util.List;

/**
 * Print GC information
 * -showversion -XX:+PrintCommandLineFlags -XX:+PrintFlagsFinal -Xms3m -Xmx3m -XX:NewSize=1m  -XX:MaxNewSize=1m  -XX:NewRatio=2 -XX:+PrintTenuringDistribution
 * Created by shenyuzhu on 2017/5/30.
 */
public class GCPrintTenuringDistributionTest {
    private String name;

    public static List<GCPrintTenuringDistributionTest> list = new ArrayList<GCPrintTenuringDistributionTest>();

    public GCPrintTenuringDistributionTest() {
        double d = Math.random();
        this.name = Double.toString(d);
        if (d > 0.7)
            list.add(this);
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new Runnable() {
            public void run() {
                for (int j = 0; j < 5; j++) {
                    for (int i = 0; i < 100000; i++) {
                        new GCPrintTenuringDistributionTest();
                    }

                    System.out.println(j);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });


        t.start();

    }


}
