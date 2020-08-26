package com.peixin.controller;

import com.peixin.entity.Admin;
import com.peixin.service.AdminService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sys")
public class AdminController {
    @Autowired
    private AdminService adminService;
    @PostMapping("/login")
    public Boolean Login(@RequestBody Admin admin){
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(admin.getUsername(),admin.getPassword());
        System.out.println(admin);
        try {
            subject.login(token);
            return true;
        }catch (UnknownAccountException e){
            System.out.println("账户名异常");
            return false;
        }catch (IncorrectCredentialsException e){
            System.out.println("密码异常");
            return false;
        }
    }
}
