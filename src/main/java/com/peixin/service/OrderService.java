package com.peixin.service;

import com.peixin.entity.OrdersVO;

import java.util.List;

public interface OrderService {

    List<OrdersVO> findAll(Integer page,Integer size);
    void deleteById(Integer id);
}
