package com.tongdou.jvm.clazz;

/**
 * Class Loader steps<br/>
 * 1、loader bytecode
 * Created by shenyuzhu on 2017/6/11.
 */
public class ClassLoaderTest {

    public static void main(String[] args) {
        System.out.println(Son.class.getClassLoader());
        System.out.println(Son.class.getSuperclass().getClassLoader());
        System.out.println(Son.class.getSuperclass().getSuperclass().getClassLoader());
        System.out.println(Thread.currentThread().getContextClassLoader());

        Son s = new Son();
        System.out.println(s.getClass() == Son.class);


        Thread t = new Thread(new Runnable() {
            public void run() {
                System.out.println("running");
                System.out.println(Thread.currentThread().getContextClassLoader());
            }
        });

        t.start();



    }
}

class Grandpa {

}

class Father extends Grandpa {

}

class Son extends Father {

}