package com.peixin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.peixin.entity.Admin;
import com.peixin.mapper.AdminMapper;
import com.peixin.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper mapper;
    @Override
    public Admin findByUsername(String username) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("username",username);

        return mapper.selectOne(wrapper);
    }
}
