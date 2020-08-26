package com.peixin.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.peixin.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserMapperTest {

    @Autowired
    private UserMapper userMapper;
    @Test
    void Test(){
        Page<User> page = new Page<>(2,6);
        List<User> result = userMapper.selectPage(page, null).getRecords();
        for (User user: result) {
            System.out.println(user);
        }
    }

}