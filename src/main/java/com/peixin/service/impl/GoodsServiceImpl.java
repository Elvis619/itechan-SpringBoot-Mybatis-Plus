package com.peixin.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.peixin.entity.Goods;
import com.peixin.entity.GoodsVO;
import com.peixin.mapper.GoodsMapper;
import com.peixin.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public Object findAll(Integer page,Integer size) {
       Page<GoodsVO> goodsPage = new Page<>(page,size);
       return goodsMapper.goodList(goodsPage,null);
    }


    @Override
    public String save(Goods goods) {
        int insert = goodsMapper.insert(goods);
        return insert == 1? "success":"error";
    }

    @Override
    public Goods findById(Integer id) {

        Goods goods = goodsMapper.selectById(id);
        return goods;
    }

    @Override
    public String updateGoods(Goods goods) {
        int i = goodsMapper.updateById(goods);
        return i == 1 ?"success":"error";
    }

    @Override
    public void deleteById(Integer id) {
        goodsMapper.deleteById(id);
    }
}
