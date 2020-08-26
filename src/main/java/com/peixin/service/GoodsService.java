package com.peixin.service;

import com.peixin.entity.Goods;


public interface GoodsService {
    Object findAll(Integer page,Integer size);
    String save(Goods goods);
    Goods findById(Integer id);
    String updateGoods(Goods goods);
    void deleteById(Integer id);
}
