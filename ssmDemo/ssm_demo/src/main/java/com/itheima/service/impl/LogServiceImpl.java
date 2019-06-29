package com.itheima.service.impl;

import com.itheima.domain.Log;
import com.itheima.mapper.LogMapper;
import com.itheima.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogServiceImpl implements LogService {
   @Autowired
   private LogMapper logMapper;

    @Override
    public void insert(Log log) {
    logMapper.insert(log);
    }
}
