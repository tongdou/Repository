package com.tongdou.ioc.resource;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import java.io.IOException;

/**
 * Created by shenyuzhu on 2017/5/13.
 */
public class ResourceExample {
    public static void main(String[] args) throws IOException {
        String filePath = "/Users/shenyuzhu/Documents/workspaces/java/Repository/Spring/MVC/spring-mvc/ioc/src/main/resources/com/tongdou/ioc/resource/resource.txt";
        Resource fileResource = new FileSystemResource(filePath);
        Resource classPathResource = new ClassPathResource("com/tongdou/ioc/resource/resource.txt");

        System.out.println(fileResource.getFile().exists());
        System.out.println(classPathResource.getFile().exists());

    }
}
