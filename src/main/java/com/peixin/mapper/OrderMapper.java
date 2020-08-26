package com.peixin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.peixin.entity.Orders;
import com.peixin.entity.OrdersVO;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface OrderMapper extends BaseMapper<Orders> {
    @Select("SELECT o.`id`,(SELECT COUNT(*) FROM orders) total, u.`username`,u.`tel`,u.`address`,g.`g_name`,g.`g_price`,o.`g_count`,(g.`g_price`*o.`g_count`) money,o.`create_time` FROM orders o,USER u,goods g WHERE o.`uid` = u.`id` AND o.`gid` = g.`id`")
    List<OrdersVO> ordersList(Page<OrdersVO> voPage);
}
