package com.tongdou.user.service;

import com.tongdou.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by shenyuzhu on 17/1/30.
 */
@ContextConfiguration(locations = {"/com/tongdou/service/applicationContext.xml"})
public class TestUserService extends AbstractTestNGSpringContextTests {
    @Autowired
    private UserService userService;

    @Test
    public void hasMatchUser() {
        boolean exist = userService.hasMatchUser("admin", "123456");
        Assert.assertTrue(exist);
    }

    @Test
    public void findUserByUserName() {
        User user = userService.findUserByUserName("admin");
        Assert.assertEquals(user.getUserName(), "admin");
    }

    @Test
    public void loginSuccess() {
        User user = userService.findUserByUserName("admin");
        userService.loginSuccess(user);

    }

//    public static void main(String[] args) {
//        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/com/tongdou/service/applicationContext.xml");
//        UserService service = (UserService) context.getBean(UserService.class);
//        User user = service.findUserByUserName("admin");
//        System.out.println(user.getPassword());
//    }
}
