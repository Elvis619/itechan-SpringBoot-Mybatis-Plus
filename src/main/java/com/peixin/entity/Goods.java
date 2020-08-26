package com.peixin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Goods {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String gName;
    private Double gPrice;
    private Integer gTotal;
    private Integer gSold;
    @TableField(value = "categories_id")
    private Integer type;
}
