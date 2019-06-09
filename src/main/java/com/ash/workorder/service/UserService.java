package com.ash.workorder.service;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * @Created by Ash on 2019/6/9 15:49
 */
@Service
public class UserService {

    @Resource
    private JavaMailSender mailSender;

    public void setSimpleMailMessage(String username) throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
        helper.setFrom("963639898@qq.com");
        helper.setTo("1322020818@qq.com");
        helper.setSubject("hsy nmsl");
        //helper.setText("<html><body>click to unlock : <a href='localhost:8090/user/unlock?username="+username+"'/></body></html>",true);
        helper.setText("<html><body>click to unlock : <a href=\"http://localhost:8090/user/activateAccount?username="+username+"\">HERE</a></body></html>",true);
        mailSender.send(mimeMessage);
    }
}
