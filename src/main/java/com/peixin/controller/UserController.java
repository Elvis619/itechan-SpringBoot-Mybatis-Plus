package com.peixin.controller;

import com.peixin.entity.User;
import com.peixin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/findAll/{pageNO}/{size}")
    public Object findAll(@PathVariable("pageNO") Integer pageNO, @PathVariable("size") Integer size){
        return userService.findAll(pageNO,size);
    }
    @GetMapping("/findByUserName/{username}")
    public User fingByUsername(@PathVariable("username") String username){
        return userService.fingByUsername(username);
    }
    @PutMapping("/updateUser")
    public String updateUser(@RequestBody User user){
        Integer user1 = userService.updateUser(user);
        return user1 == 1 ? "success":"error";
    }
    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") Integer id){
        userService.deleteById(id);
    }
    @PostMapping("/save")
    public String save(@RequestBody User user){
        String result = userService.save(user);
        return result;
    }
    //小程序登录接口
    @GetMapping("/login")
    public String login(String username,String password){
        String s = userService.login(username, password);
        return s;
    }
}
