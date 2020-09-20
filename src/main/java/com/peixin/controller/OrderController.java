package com.peixin.controller;

import com.peixin.entity.Orders;
import com.peixin.entity.OrdersDetail;
import com.peixin.mapper.OrderDetailMapper;
import com.peixin.mapper.OrderMapper;
import com.peixin.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/findAll/{page}/{size}")
    public Object findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
       return orderService.findAll(page,size);
    }
    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") Integer id){
        orderService.deleteById(id);
    }

    @PostMapping("/orderAdd")
    public boolean orderAdd(@RequestBody Orders orders){

        int i = orderService.orderAdd(orders);
        return  i == 1;
    }
    @GetMapping("/orderList")
    public List<Orders> getOrderList(){
        List<Orders> orderList = orderService.getOrderList();
        return orderList;
    }
    @GetMapping("/orderById/{id}")
    public  List<Orders> orderById(@PathVariable("id") Integer id){
        List<Orders> list = orderService.orderById(id);
        return list;
    }

    @GetMapping("/orderListByState/{state}")
    public List<Orders> selectByState(@PathVariable("state") Integer state){
        List<Orders> ordersList = orderService.selectByState(state);
        return ordersList;
    }
    @GetMapping("/updatePayState/{id}")
    public Orders updateState(@PathVariable("id") Integer id){
        Orders orders = orderService.updateState(id);
        return  orders;
    }

    @GetMapping("/updateWaitState/{id}")
    public Object updateWaitState(@PathVariable("id") Integer id){
        Orders orders = orderService.updateWaitState(id);
        return  orders;
    }
}
