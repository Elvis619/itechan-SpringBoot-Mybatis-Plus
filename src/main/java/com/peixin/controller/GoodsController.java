package com.peixin.controller;


import com.peixin.entity.Goods;
import com.peixin.entity.GoodsVO;
import com.peixin.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;
    @GetMapping("/findAll/{page}/{size}")
    public Object findAll(@PathVariable("page") Integer page,@PathVariable("size") Integer size){
        return goodsService.findAll(page,size);
    }

    @PostMapping("/save")
    public String save(@RequestBody Goods goods){
        String result = goodsService.save(goods);
        return result;
    }
    @GetMapping("/findById/{id}")
    public Goods findById(@PathVariable("id") Integer id){
        return goodsService.findById(id);
    }
    @PutMapping("/updateGoods")
    public String updateGoods(@RequestBody Goods goods){
        String s = goodsService.updateGoods(goods);
        return s;
    }
    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") Integer id){
        goodsService.deleteById(id);
    }

}
