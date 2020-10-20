package com.xiaobao.demo.service.impl;

import com.xiaobao.demo.domain.Backlog;
import com.xiaobao.demo.mapper.BacklogMapper;
import com.xiaobao.demo.service.BacklogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BacklogServiceImpl implements BacklogService {
    @Autowired
    private BacklogMapper backlogMapper;

    @Override
    public List<Backlog> getLogList(Backlog backlog){
        return backlogMapper.getLogList(backlog);
    }
    @Override
    public List<Backlog> getDelLogList(Backlog backlog){
        return backlogMapper.getDelLogList(backlog);
    }
    @Override
    public Backlog getLogById(Integer id){
        return backlogMapper.getLogById(id);
    }
    @Override
    public void addLog(Backlog backlog){
        backlogMapper.addLog(backlog);
    }

    @Override
    public void update(Backlog backlog){
        backlogMapper.update(backlog);
    }

    @Override
    public void doLog(Backlog backlog){
        backlogMapper.doLog(backlog);
    }

    @Override
    public void deleteData(Backlog backlog){
        backlogMapper.deleteData(backlog);
    }
}
