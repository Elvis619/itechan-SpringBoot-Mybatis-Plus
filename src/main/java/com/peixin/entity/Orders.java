package com.peixin.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Orders {
    private Integer id;
    private Integer uid;
    private Integer gid;
    private Integer gCount;
    private Date createTime;
}
