package com.ash.workorder.controller;

import com.ash.workorder.dao.UserDao;
import com.ash.workorder.dao.po.UserPo;
import com.ash.workorder.service.UserServiceImpl;
import com.mchange.util.AlreadyExistsException;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.mail.MessagingException;

/**
 * @Created by Ash on 2019/6/9 10:57
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    UserDao userDao;

    @Resource
    UserServiceImpl userService;


    /**
     * 用户注册，校验
     * @param user
     * @return
     * @throws Exception
     */
    @PostMapping("/login")
    public UserPo login(@RequestBody UserPo user) throws Exception {
        //logger.info("user {} ready to login.", user.getUsername());

        //logger.info("user {} check succeed.", user.getPassword());
        return userService.login(user);
    }

    /**
     * 用户登出
     * @throws Exception
     */
    @GetMapping("/logout")
    public void logout() throws Exception {
        userService.logout();
    }

    /**
     * 用户注册，校验
     * @param user
     */
    @PostMapping("/signup")
    public void signup(@RequestBody UserPo user) throws AlreadyExistsException {
        userService.signup(user);
    }

    /**
     * 更改密码，校验
     * @param user
     */
    @PostMapping("/changePassword")
    public void changePassword(@RequestBody UserPo user) throws Exception {
        userService.changePassword(user);
    }

    /**
     * 用户名是否重复查询接口
     * @param userPo
     * @return
     */
    @PostMapping("/usernameCheck")
    public int usernameCheck(@RequestBody UserPo userPo){
        return userService.usernameCheck(userPo.getUsername());
    }

    /**
     * 激活用户账户
     * @param username
     */
    @GetMapping("/activateAccount")
    public void activateAccount(String username){
        userService.activateAccount(username);
    }

    /**
     * 发送激活邮件
     * @param username
     */
    @RequestMapping("/sendVerifyMail")
    public void VerifyMailSend(@RequestParam(value = "username",required = true) String username) throws MessagingException {
        userService.sendVerifyMail(username);
    }
}
