package com.peixin.service.impl;

import com.peixin.service.AdminService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AdminServiceImplTest {
    @Autowired
    private AdminService adminService;
    @Test
    void findByUsername() {
        System.out.println(adminService.findByUsername("admin"));
    }
}