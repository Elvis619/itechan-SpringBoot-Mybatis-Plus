package com.peixin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.peixin.entity.User;
import com.peixin.mapper.UserMapper;
import com.peixin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public Object findAll(Integer pageNO, Integer size) {
        Page<User> page = new Page<>(pageNO,size);
        IPage<User> mapIPage = userMapper.selectPage(page, null);
        return mapIPage;
    }

    @Override
    public User fingByUsername(String username) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("username",username);
        return userMapper.selectOne(wrapper);
    }

    @Override
    public Integer updateUser(User user) {
        UpdateWrapper<User> wrapper = new UpdateWrapper<>();
        wrapper.eq("username",user.getUsername());
        return userMapper.update(user,wrapper);

    }

    @Override
    public void deleteById(Integer id) {
        userMapper.deleteById(id);
    }

    @Override
    public String save(User user) {
        int insert = userMapper.insert(user);
        return insert == 1 ? "success" : "error";
    }

    @Override
    public String login(String username, String password) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username",username).eq("password",password);

        User user = userMapper.selectOne(wrapper);
        return user == null ? "fail":"success";
    }
}
