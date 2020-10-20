package com.xiaobao.demo.controller;

import com.xiaobao.demo.domain.Backlog;
import com.xiaobao.demo.domain.User;
import com.xiaobao.demo.service.BacklogService;
import com.xiaobao.demo.service.MailService;
import com.xiaobao.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Controller
@Component

public class TimeJobController {

    @Autowired
    private BacklogService backlogService;

    @Autowired
    private UserService userService;

    @Autowired
    private MailService mailService;


//    @Scheduled(cron = "0 */1 * * * ?")
    @RequestMapping("/startJob")
    public String startJob(@RequestParam("bId") int id){
        Backlog backlog = backlogService.getLogById(id);
        User user = userService.getUserById(backlog.getUserId());
        //实现Runnable接口，jdk就知道这个类是一个线程
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                mailService.sentMail(user.getEmail(),"待办事项提醒","不要忘了"+backlog.getbContent()+"哦！！！");
            }
        };
        // ScheduledExecutorService:是从Java SE5的java.util.concurrent里，
        // 做为并发工具类被引进的，这是最理想的定时任务实现方式。
        ScheduledExecutorService service = Executors
                .newSingleThreadScheduledExecutor();
        // 第二个参数为首次执行的延时时间，第三个参数为定时执行的间隔时间
        // 第一次执行的时间为10秒，然后每隔五小时执行一次
        service.scheduleAtFixedRate(runnable, 10, 18000, TimeUnit.SECONDS);
        Date date = new Date(); //获取当前时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm"); //指定格式化格式
        String trueDate = sdf.format(date); //格式化当前日期
        if (trueDate.equals(backlog.getbTime())){
            service.shutdown();
        }
        return "redirect:/backlog";
    }

}
