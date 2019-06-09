package com.ash.workorder.controller;

import com.ash.workorder.dao.UserDao;
import com.ash.workorder.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.mail.MessagingException;

/**
 * @Created by Ash on 2019/6/9 10:57
 */
@RestController
public class UserController {

    @Resource
    UserDao userDao;

    @Resource
    UserService userService;

    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }

    @RequestMapping("/login")
    public String login(String email){
        return userDao.selectByEmail(email).toString();
    }

    @RequestMapping("/sendVerifyMail")
    public void VerifyMailSend(@RequestParam(value = "username",required = true) String username) throws MessagingException {
        userService.setSimpleMailMessage(username);
    }
}
