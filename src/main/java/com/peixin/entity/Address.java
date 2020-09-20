package com.peixin.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;


import java.util.Date;

/**
 * 收货地址
 */
@Data
public class Address {
    @TableId(type = IdType.AUTO)
    private Integer id;

    private String name;

    private String phone;

    private String address;

    private Integer uid;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
    @TableLogic
    private Integer state;


}
