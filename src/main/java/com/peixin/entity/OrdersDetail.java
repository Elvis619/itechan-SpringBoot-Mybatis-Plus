package com.peixin.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 *订单详情列表
 */

@Data
public class OrdersDetail {
    @TableId(type = IdType.AUTO)
    private Integer id;

    private Integer goodsId; //产品ID

    private String name; //产品名字

    private String imgSrc;

    private Integer ordersId; //订单编号

    private Integer count; //购买数量

    private BigDecimal price; //单价
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;





}
