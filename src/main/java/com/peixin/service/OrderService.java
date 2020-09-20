package com.peixin.service;

import com.peixin.entity.Orders;
import com.peixin.entity.OrdersVO;

import java.util.List;

public interface OrderService {

    List<OrdersVO> findAll(Integer page,Integer size);
    void deleteById(Integer id);

    int orderAdd(Orders orders);

    List<Orders> getOrderList();

    List<Orders> selectByState(Integer state);

    Orders updateState(Integer id);

    Orders updateWaitState(Integer id);

    List<Orders> orderById(Integer id);
}
