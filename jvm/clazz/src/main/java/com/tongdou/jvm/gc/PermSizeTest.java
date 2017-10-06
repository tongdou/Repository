package com.tongdou.jvm.gc;

import com.itranswarp.compiler.JavaStringCompiler;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * set VM options
 * -showversion -XX:+PrintCommandLineFlags -XX:PermSize=8m -XX:MaxPermSize=8m
 * <p>
 * Exception in thread "main" java.lang.OutOfMemoryError: PermGen space
 * at java.lang.ClassLoader.defineClass1(Native Method)
 * at java.lang.ClassLoader.defineClass(ClassLoader.java:800)
 * at java.lang.ClassLoader.defineClass(ClassLoader.java:643)
 * <p>
 * Created by shenyuzhu on 2017/5/26.
 */
@Service
public class PermSizeTest {


    public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        JavaStringCompiler compiler = new JavaStringCompiler();


        StringBuffer sb = new StringBuffer();
        sb.append(SINGLE_JAVA);
        // add 10000 motheds
        for (int i = 0; i < 10000; i++) {
            sb.append("    public boolean isDirty" + i + "() { return this._dirty;   }  ");
        }
        sb.append("}");


        Map<String, byte[]> results = compiler.compile("UserProxy.java", sb.toString());

        Class<?> clazz = compiler.loadClass("on.the.fly.UserProxy", results);
        // get method:
        Method setId = clazz.getMethod("setId", String.class);
        Method setName = clazz.getMethod("setName", String.class);
        Method setCreated = clazz.getMethod("setCreated", long.class);
        Method isDirty = clazz.getMethod("isDirty5");

        // try instance:
        Object obj = clazz.newInstance();
        System.out.println(isDirty.invoke(obj));
        setId.invoke(obj, "1231");
        System.out.println(isDirty.invoke(obj));

    }


    static final String SINGLE_JAVA = "/* a single java class to one file */  "
            + "package on.the.fly;                                            "
            + "import com.tongdou.jvm.gc.*;                            "
            + "public class UserProxy extends PermSizeTest  {     "
            + "    boolean _dirty = false;                                    "
            + "    public void setId(String id) {                             "
            + "        super.setId(id);                                       "
            + "        setDirty(true);                                        "
            + "    }                                                          "
            + "    public void setName(String name) {                         "
            + "        super.setName(name);                                   "
            + "        setDirty(true);                                        "
            + "    }                                                          "
            + "    public void setCreated(long created) {                     "
            + "        super.setCreated(created);                             "
            + "        setDirty(true);                                        "
            + "    }                                                          "
            + "    public void setDirty(boolean dirty) {                      "
            + "        this._dirty = dirty;                                   "
            + "    }                                                          "
            + "    public boolean isDirty() {                                 "
            + "        return this._dirty;                                    "
            + "    }                                                          ";


    private String id;
    private String name;
    private long created;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getCreated() {
        return created;
    }

    public void setCreated(long created) {
        this.created = created;
    }
}
