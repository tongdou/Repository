package com.tongdou.jvm.gc;

import java.util.ArrayList;
import java.util.List;

/**
 * -showversion  -XX:+PrintCommandLineFlags -Xms10m -Xmx10m -XX:+PrintGCDetails  -XX:+PrintGCTimeStamps -XX:+PrintGCDateStamps  -Xloggc:/tmp/gc.log
 * <p>
 * -----
 * [GC [PSYoungGen: 2329K->432K(3072K)] 2329K->1456K(10240K), 0.0034620 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
 * *          新生代                       堆
 * - 大小：   3072K                        10240K
 * - 使用：   2329K->432K（减少了1897）     2329K->1456K（减少了873）
 * - 总结：   有1024K（1897-873）从新生代移动到了老年代
 * - 用时：   [Times: user=0.00（用户空间CPU时间，如果是多核CPU，这个时间可能大于真实时间） sys=0.00（系统空间CPU时间）, real=0.01 secs （真实时间） ]
 * <p>
 * [Full GC
 * * [PSYoungGen: 448K->0K(3072K)]
 * * [ParOldGen: 5120K->5472K(7168K)] 5568K->5472K(10240K)
 * * [PSPermGen: 2903K->2902K(21504K)], 0.0141350 secs
 * ] [Times: user=0.01 sys=0.00, real=0.02 secs]
 * *          新生代                    老年代                   堆                        方法区
 * - 大小：   3072K                     7168K                   10240K                    21504K
 * - 内存：   448K->0K（减少448K）       5120K->5472K（增加352K） 5568K->5472K（减少96K）    2903K->2902K(21504K)
 * - 用时： [Times: user=0.01 sys=0.00, real=0.02 secs]
 * <p>
 * <p>
 * <p>
 * Created by shenyuzhu on 2017/5/30.
 */
public class GCLog {


    public static void main(String[] args) throws Exception {
        testGClog();
    }

    public static void testGClog() throws InterruptedException {
        List<MemoryObject> objects = new ArrayList<MemoryObject>(6);
        for (int i = 0; i < 8; i++) {
            objects.add(new MemoryObject(1024 * 1024));
        }

        objects.clear();
        System.out.println("1====");
        Thread.sleep(1000);

        for (int i = 0; i < 7; i++) {
            objects.add(new MemoryObject(1024 * 1024));
        }
        System.out.println("2====");
        Thread.sleep(20000);
    }


}

class MemoryObject {
    private byte[] bytes;

    public MemoryObject(int objectSize) {
        this.bytes = new byte[objectSize];
    }
}