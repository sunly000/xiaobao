package com.xiaobao.demo.service;

import com.xiaobao.demo.domain.Backlog;

import java.util.List;

public interface BacklogService {
    List<Backlog> getLogList(Backlog backlog);
    List<Backlog> getDelLogList(Backlog backlog);
    Backlog getLogById(Integer id);
    void addLog(Backlog backlog);
    void update(Backlog backlog);
    void doLog(Backlog backlog);
    void deleteData(Backlog backlog);
}
