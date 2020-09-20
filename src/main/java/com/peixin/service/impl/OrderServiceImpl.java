package com.peixin.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.peixin.entity.Goods;
import com.peixin.entity.Orders;
import com.peixin.entity.OrdersDetail;
import com.peixin.entity.OrdersVO;
import com.peixin.mapper.GoodsMapper;
import com.peixin.mapper.OrderDetailMapper;
import com.peixin.mapper.OrderMapper;
import com.peixin.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private OrderDetailMapper orderDetailMapper;

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public List<OrdersVO> findAll(Integer page, Integer size) {

        Page<OrdersVO> voPage = new Page<>(page,size);
        return orderMapper.ordersList(voPage);
    }

    @Override
    public void deleteById(Integer id) {
//        Orders orders = orderMapper.selectById(id);
//
//        Integer gCount = orders.getGCount();
//
//        Integer gid = orders.getGid();
//
//        Goods goods = goodsMapper.selectById(gid);
//        Integer gSold = goods.getGSold();
//
//        goods.setGSold(gSold - gCount);
//        System.out.println(goods.getGSold());
//        goodsMapper.updateById(goods);
//        System.out.println(goodsMapper.selectById(gid));
//        orderMapper.deleteById(id);
    }

    @Override
    public int orderAdd(Orders orders) {
        String orderSn = UUID.randomUUID().toString();
        orders.setOrderSn(orderSn);
        //1支付，2订单关闭（没付款成功,逻辑删除）
        orders.setState(2);
        int i = orderMapper.insert(orders);
        Integer ordersId = orders.getId();
        if(i == 1){
            for (OrdersDetail ordersDetail: orders.getOrdersDetailList()) {
                ordersDetail.setOrdersId(ordersId);
                orderDetailMapper.insert(ordersDetail);
            }
        }
        return i;
    }

    @Override
    public List<Orders> getOrderList() {
        List<Orders> ordersList = orderMapper.selectList(null);
        List<Orders> result = new ArrayList<>();
        for (Orders orders: ordersList) {
            Integer ordersId = orders.getId();
            QueryWrapper wrapper = new QueryWrapper();
            wrapper.eq("orders_id",ordersId);
            List<OrdersDetail> list = orderDetailMapper.selectList(wrapper);
            orders.setOrdersDetailList(list);
            result.add(orders);
        }
        return result;
    }

    @Override
    public List<Orders> selectByState(Integer state) {
        List<Orders> result = new ArrayList<>();
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("state",state);
        List<Orders> list = orderMapper.selectList(wrapper);
        for (Orders orders: list) {
            Integer ordersId = orders.getId();
            QueryWrapper qw = new QueryWrapper();
            qw.eq("orders_id",ordersId);
            List<OrdersDetail> list1 = orderDetailMapper.selectList(qw);
            orders.setOrdersDetailList(list1);
            result.add(orders);
        }
        return result;
    }

    @Override
    public Orders updateState(Integer id) {
        Orders orders = orderMapper.selectById(id);
        orders.setState(2);
        orderMapper.updateById(orders);
        return orders;
    }

    @Override
    public Orders updateWaitState(Integer id) {
        Orders orders = orderMapper.selectById(id);
        orders.setState(4);
        orderMapper.updateById(orders);
        return orders;

    }

    @Override
    public List<Orders> orderById(Integer id) {
        List<Orders> list = new ArrayList<>();
        Orders orders = orderMapper.selectById(id);
        Integer ordersId = orders.getId();
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("orders_id",ordersId);
        List<OrdersDetail> ordersDetails = orderDetailMapper.selectList(wrapper);
        orders.setOrdersDetailList(ordersDetails);
        list.add(orders);
        return list;
    }


}
