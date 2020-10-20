package com.xiaobao.demo.service.impl;

import com.xiaobao.demo.mapper.BacklogMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class TimeJob {
    //日志
    private static final Logger logger = LoggerFactory.getLogger(TimeJob.class);

    //注入对象
    @Autowired
    private BacklogMapper backlogMapper;

    /*
    * 当到达截止时间删除事项的处理
    * */
    @Scheduled(cron = "0 0 0 * * *") //每天凌晨0点开启定时任务
    public void clearDataJob(){
        logger.info("---------定时任务开始执行---------"+new SimpleDateFormat("HH:mm:ss").format(new Date()));
        clearData(backlogMapper);
        logger.info("---------定时任务执行成功---------"+new SimpleDateFormat("HH:mm:ss").format(new Date()));
    }
    public static void clearData(BacklogMapper backlogMapper){
        try{
            backlogMapper.clearDataJob();
        }catch (Exception e){
            logger.info("清理数据失败，失败原因："+e.getMessage());
        }
    }

}
