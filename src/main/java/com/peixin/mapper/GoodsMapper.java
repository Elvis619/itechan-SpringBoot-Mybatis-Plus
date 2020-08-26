package com.peixin.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.peixin.entity.Goods;
import com.peixin.entity.GoodsVO;
import com.peixin.entity.OrdersVO;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodsMapper extends BaseMapper<Goods> {
    @Select("SELECT  (SELECT COUNT(*) FROM goods) total,g.id,g.`g_price`,g.`g_total`,(g.`g_total` - g.`g_sold`) ghave,(g.`g_price`*g.`g_sold`) money,g.`g_sold`,c.`type`,g.`g_name` FROM goods g,categories c  WHERE  g.`categories_id` = c.`id`")
    List<GoodsVO> goodList(Page<GoodsVO> goodsPage, QueryWrapper<GoodsVO> queryWrapper);

    @Select("SELECT o.`id`,(SELECT COUNT(*) FROM orders) total, u.`username`,u.`tel`,u.`address`,g.`g_name`,g.`g_price`,o.`g_count`,(g.`g_price`*o.`g_count`) money,o.`create_time` FROM orders o,USER u,goods g WHERE o.`uid` = u.`id` AND o.`gid` = g.`id`")
    List<OrdersVO> ordersList(Page<OrdersVO> voPage);
}