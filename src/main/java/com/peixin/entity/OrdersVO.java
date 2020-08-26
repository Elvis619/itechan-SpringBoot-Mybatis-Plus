package com.peixin.entity;

import lombok.Data;

import java.util.Date;

@Data
public class OrdersVO {
    private Integer id;
    private String username;
    private Long tel;
    private String address;
    private String gName;
    private Double gPrice;
    private Integer gCount;
    private Double money;
    private Date createTime;
    private Integer total;

}
