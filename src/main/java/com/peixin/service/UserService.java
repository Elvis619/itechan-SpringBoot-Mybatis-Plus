package com.peixin.service;


import com.peixin.entity.User;

public interface UserService {
    Object findAll(Integer page,Integer size);
    User fingByUsername(String username);
    Integer updateUser(User user);
    void deleteById(Integer id);
    String save(User user);
    String login(String username,String password);
}
