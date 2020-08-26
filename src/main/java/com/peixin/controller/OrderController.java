package com.peixin.controller;

import com.peixin.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

}
