package com.ash.workorder.service;

import com.ash.workorder.dao.UserDao;
import com.ash.workorder.dao.po.UserPo;
import com.ash.workorder.utils.MD5Utils;
import com.mchange.util.AlreadyExistsException;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Date;

/**
 * @Created by Ash on 2019/6/9 15:49
 */
@Service
public class UserServiceImpl implements UserService{
    
    private final static Logger logger = LoggerFactory.getLogger(UserService.class);

    @Resource
    private UserDao userDao;

    @Resource
    private JavaMailSender mailSender;

    public void sendVerifyMail(String username) throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
        helper.setFrom("963639898@qq.com");
        helper.setTo(username);
        helper.setSubject("Activate your account");
        helper.setText("<html><body>click to activate : <a href=\"http://localhost:8090/user/activateAccount?username="+username+"\">ActivateAddress</a></body></html>",true);
        mailSender.send(mimeMessage);
    }
    

    /**
     * 用户登陆
     * @param user
     * @throws Exception
     */
    @Override
    public UserPo login(UserPo user) throws Exception {
        String username = user.getUsername();
        String password = MD5Utils.encode(user.getPassword(), "");
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        Subject subject = SecurityUtils.getSubject();

        subject.login(token);
        if (!subject.isAuthenticated()) {
            logger.warn("user: {} authc failed.", username);
            throw new Exception("未知原因，登录失败");
        }
        user = userDao.selectByUsername(username);
        user.setPassword(null);
        userDao.updateLoginTime(username, new Date());
        return user;
    }

    /**
     * 用户登出
     * @throws Exception
     */
    @Override
    public void logout() throws Exception {
        SecurityUtils.getSubject().logout();
    }

    /**
     * 用户注册
     * @param userPo
     * @return
     */
    @Override
    public void signup(UserPo userPo) throws AlreadyExistsException {
        if (userDao.searchUsername(userPo.getUsername()) == null) {
            String password = MD5Utils.encode(userPo.getPassword(), "");
            userPo.setPassword(password);
            userDao.insert(userPo);
        }
        else throw new AlreadyExistsException("用户名已存在");
    }

    /**
     * 更改密码
     * @param userPo
     */
    @Override
    public void changePassword(UserPo userPo) throws Exception{
        String password = MD5Utils.encode(userPo.getPassword(), "");
        String OldPassword = userDao.selectByUsername(userPo.getUsername()).getPassword();
        if (OldPassword == password)
            throw new Exception("更改密码需与原密码不同");
        userDao.updatePassword(userPo);
    }

    /**
     * 查询用户名是否存在
     * @param username
     * @return 存在 1 ，不存在 0
     */
    @Override
    public int usernameCheck(String username) {
        UserPo a = userDao.searchUsername(username);
        if(a == null)
            return 0;
        else return 1;
    }

    /**
     * 激活账户
     * @param username
     * @return
     */
    @Override
    public int activateAccount(String username) {
        return userDao.activate(username);
    }
}
