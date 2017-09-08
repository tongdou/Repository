package com.tongdou.agent.transform;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

/**
 * Created by shenyuzhu on 2017/9/8.
 */
public class Transformer implements ClassFileTransformer {
    Logger logger = LoggerFactory.getLogger(Transformer.class);

    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer)
            throws IllegalClassFormatException {

        logger.info("====loader:{} className:{}", loader, className);

        return null;
    }
}
