package com.peixin.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 订单基本信息
 */
@Data
public class Orders {
    @TableId(type = IdType.AUTO)
    private Integer id;

    private BigDecimal totalPrice; //订单金额
    private Integer uid;          //用户姓名
    private String orderSn;       //订单编号

    private Integer state;       //订单状态

    private Integer addressId;   //收货人的地址id

//    private Address address;     //收货人地址对象

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
    @TableField(exist = false)
    private List<OrdersDetail> ordersDetailList;
}
