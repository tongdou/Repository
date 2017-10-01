package com.tongdou.user.service;

import com.tongdou.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by shenyuzhu on 17/1/30.
 */
@ContextConfiguration(locations = {"/com/tongdou/service/applicationContext.xml"})
public class TestUserService extends AbstractTestNGSpringContextTests {
    @Autowired
    private UserService userService;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @BeforeClass
    public void initDatabase() {
        String createUser = "CREATE TABLE `t_user` (\n" +
                "  `USER_ID` int(11) NOT NULL AUTO_INCREMENT,\n" +
                "  `last_ip` varchar(255) DEFAULT NULL,\n" +
                "  `last_visit` varchar(255) DEFAULT NULL,\n" +
                "  `credits` varchar(255) DEFAULT NULL,\n" +
                "  `USER_NAME` varchar(255) DEFAULT NULL,\n" +
                "  `password` varchar(255) DEFAULT NULL,\n" +
                "  PRIMARY KEY (`USER_ID`)\n" +
                ") ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8";
        String createLogin = "CREATE TABLE `t_login_log` (\n" +
                "  `user_id` int(11) NOT NULL AUTO_INCREMENT,\n" +
                "  `ip` varchar(255) DEFAULT NULL,\n" +
                "  `login_datetime` datetime DEFAULT NULL,\n" +
                "  PRIMARY KEY (`USER_ID`)\n" +
                ") ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8";


        logger.info("start init database ");
        try {
            jdbcTemplate.execute(createUser);
        } catch (Exception e) {
//            logger.error("init database error", e);
        }
        try {
            jdbcTemplate.execute(createLogin);
        } catch (Exception e) {
//            logger.error("init database error", e);
        }
    }


    @Test
    public void hasMatchUser() {
        boolean exist = userService.hasMatchUser("admin", "123456");
//        Assert.assertTrue(exist);
    }

    @Test
    public void findUserByUserName() {
        User user = userService.findUserByUserName("admin");
//        Assert.assertEquals(user.getUserName(), "admin");
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
