package com.tongdou.user.web;

import com.tongdou.user.domain.User;
import com.tongdou.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Created by shenyuzhu on 17/2/1.
 */
@Controller
@Scope(value = "request")
public class LoginController {
    private int token = 0;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/index.html")
    public String loginPage() {
        return "login";
    }


    @RequestMapping(value = "/loginCheck.html")
    public ModelAndView checkUser(HttpServletRequest request, LoginCommand loginCommand) {
        token++;
        boolean isValidUser = userService.hasMatchUser(loginCommand.getUserName(), loginCommand.getPassword());
        if (!isValidUser) {
            return new ModelAndView("login", "error", "输入的用户名或者密码错误!");
        } else {
            User user = userService.findUserByUserName(loginCommand.getUserName());
            user.setLastIp(request.getLocalAddr());
            user.setLastVisit(new Date());
            userService.loginSuccess(user);

            request.getSession().setAttribute("user", user);
            request.getSession().setAttribute("count",token);

            return new ModelAndView("main");
        }
    }
}
