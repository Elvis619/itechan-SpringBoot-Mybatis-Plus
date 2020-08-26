package com.peixin.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.peixin.entity.User;
import com.peixin.mapper.UserMapper;
import com.peixin.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceImplTest {


    @Autowired
    private UserMapper userMapper;
    @Test
    void findAll() {
        Page<User> page = new Page<>(1,6);
        Page<User> result = userMapper.selectPage(page, null);
        System.out.println(result.getSize());
        System.out.println(result.getTotal());
        result.getRecords().forEach(System.out::println);
    }

}