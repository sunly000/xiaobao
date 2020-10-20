package com.xiaobao.demo.service;

public interface MailService {
    /*
    *  to:接收人
    *  subject：主题
    *  content：内容
    *
    * */
    void sentMail(String to,String subject,String content);
}
