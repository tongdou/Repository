package com.tongdou.jvm.gc;

import org.junit.Test;

/**
 * 调试Yong Generation（新生代）
 * - Eden（伊甸园）
 * - From Survivor（From 幸存区）
 * - To Survivor（To 幸存区）
 *
 * -showversion -XX:+PrintCommandLineFlags -XX:+PrintFlagsFinal -Xms3m -Xmx3m -XX:NewSize=1m  -XX:MaxNewSize=1m -XX:NewRatio=2
 * -XX:NewSize and -XX:MaxNewSize
 * <p>
 * Created by shenyuzhu on 2017/5/30.
 */
public class YongGenerationTest {

    @Test
    public void test(){

    }
}
