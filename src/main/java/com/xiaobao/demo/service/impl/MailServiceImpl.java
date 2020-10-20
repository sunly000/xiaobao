package com.xiaobao.demo.service.impl;

import com.xiaobao.demo.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailServiceImpl implements MailService {
    @Autowired
    private JavaMailSender mailSender;

    //读取application.properties的内容
    @Value("${mail.fromMail.addr}")
    private String form;

    @Override
    public void sentMail(String to,String subject,String content){
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(form);
        mailMessage.setTo(to);
        mailMessage.setSubject(subject);
        mailMessage.setText(content);
        try {
            mailSender.send(mailMessage);
            System.out.println("发送邮件中");
        }catch (Exception e){
            System.out.println("发送失败，失败原因为："+e);
        }
    }
}
