package com.xiaobao.demo.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Backlog {
    private Integer bId;
    private Integer userId;
    private Integer priority;
    private String bTitle; //标题
    private String bContent; //详细内容
    private String bTime;   //提醒倒计时
    private String bCreateTime;
    private String bLastUpdateTime;
    private String bDeadline;   //截止日期
    private Integer flag; //用来标记是否超出截止日期


    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Integer getbId() {
        return bId;
    }

    public void setbId(Integer bId) {
        this.bId = bId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getbTitle() {
        return bTitle;
    }

    public void setbTitle(String bTitle) {
        this.bTitle = bTitle;
    }

    public String getbContent() {
        return bContent;
    }

    public void setbContent(String bContent) {
        this.bContent = bContent;
    }

    public String getbTime() {
        return bTime;
    }

    public void setbTime(String bTime) {
        this.bTime = bTime;
    }

    public String getbCreateTime() {
        return bCreateTime;
    }

    public void setbCreateTime(String bCreateTime) {
        this.bCreateTime = bCreateTime;
    }

    public String getbLastUpdateTime() {
        return bLastUpdateTime;
    }

    public void setbLastUpdateTime(String bLastUpdateTime) {
        this.bLastUpdateTime = bLastUpdateTime;
    }

    public String getbDeadline() {
        return bDeadline;
    }

    public void setbDeadline(String bDeadline) {
        this.bDeadline = bDeadline;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "Backlog{" +
                "bId=" + bId +
                ", userId=" + userId +
                ", priority='" + priority + '\'' +
                ", bTitle='" + bTitle + '\'' +
                ", bContent='" + bContent + '\'' +
                ", bTime='" + bTime + '\'' +
                ", bCreateTime='" + bCreateTime + '\'' +
                ", bLastUpdateTime='" + bLastUpdateTime + '\'' +
                ", bDeadline='" + bDeadline + '\'' +
                ", flag=" + flag +
                '}';
    }
}
