package com.peixin.service;

import com.peixin.entity.Admin;

public interface AdminService {

    public Admin findByUsername(String username);
}
