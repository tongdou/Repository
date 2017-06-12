package com.tongdou.jvm.gc;

import net.sf.cglib.beans.BeanGenerator;
import net.sf.cglib.core.ClassGenerator;
import org.objectweb.asm.ClassVisitor;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * create class and object by cglib
 * -showversion -Xms20m -Xmx20m -XX:PermSize=4m -XX:MaxPermSize=4m -XX:+PrintGCDetails
 * <p>
 * Created by shenyuzhu on 2017/6/11.
 */
public class CGLIB {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            createObject();
            System.out.println(i);
        }
    }


    public static Object createObject() {
        BeanGenerator generator = new BeanGenerator();

        Map<String, Class> propertyMap = new HashMap();
        propertyMap.put("name" + Math.random(), String.class);

        Set keySet = propertyMap.keySet();
        for (Iterator i = keySet.iterator(); i.hasNext(); ) {
            String key = (String) i.next();
            generator.addProperty(key, (Class) propertyMap.get(key));
        }
        return generator.create();
    }

}
