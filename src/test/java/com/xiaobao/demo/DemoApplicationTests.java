package com.xiaobao.demo;

import com.xiaobao.demo.service.MailService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class DemoApplicationTests {
    @Autowired
    private MailService mailService;
    @Value("${mail.fromMail.addr}")
    private String form;
    @Test
    public void sendMailTest() throws Exception{
        mailService.sentMail("1054097910@qq.com","测试","邮件测试");
    }

}
