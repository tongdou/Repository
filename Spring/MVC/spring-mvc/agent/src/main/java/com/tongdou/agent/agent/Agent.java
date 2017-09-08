package com.tongdou.agent.agent;

import com.tongdou.agent.transform.Transformer;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.Instrumentation;

/**
 * Created by shenyuzhu on 2017/9/8.
 */
public class Agent {

    public static void premain(String agentArgs, Instrumentation instrumentation) {

        ClassFileTransformer fileTransformer = new Transformer();
        instrumentation.addTransformer(fileTransformer);
    }
}
