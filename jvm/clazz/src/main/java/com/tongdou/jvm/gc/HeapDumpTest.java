package com.tongdou.jvm.gc;

import java.util.ArrayList;
import java.util.List;

/**
 * set VM options
 * -showversion -XX:+PrintCommandLineFlags -Xms1M -Xmx1M -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/tmp/heapdump -XX:OnOutOfMemoryError="date >> ~/tmp.txt"
 * <p>
 * Created by shenyuzhu on 2017/5/26.
 */
public class HeapDumpTest {


    public static void main(String[] args) {
        List<HeapDumpTest> list = new ArrayList();
        for (int i = 0; i < 100000; i++) {
            list.add(new HeapDumpTest());

        }
    }


    private String name;
    private String address;
    private String company;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }


}
