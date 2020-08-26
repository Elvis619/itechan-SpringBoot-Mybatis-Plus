package com.peixin.service.impl;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.peixin.entity.Goods;
import com.peixin.entity.Orders;
import com.peixin.entity.OrdersVO;
import com.peixin.mapper.GoodsMapper;
import com.peixin.mapper.OrderMapper;
import com.peixin.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public List<OrdersVO> findAll(Integer page, Integer size) {

        Page<OrdersVO> voPage = new Page<>(page,size);
        return orderMapper.ordersList(voPage);
    }

    @Override
    public void deleteById(Integer id) {
        Orders orders = orderMapper.selectById(id);

        Integer gCount = orders.getGCount();

        Integer gid = orders.getGid();

        Goods goods = goodsMapper.selectById(gid);
        Integer gSold = goods.getGSold();

        goods.setGSold(gSold - gCount);
        System.out.println(goods.getGSold());
        goodsMapper.updateById(goods);
        System.out.println(goodsMapper.selectById(gid));
        orderMapper.deleteById(id);
    }
}
