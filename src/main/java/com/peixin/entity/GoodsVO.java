package com.peixin.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class GoodsVO {
    @TableId()
    private Integer id;
    private String gName;
    private Double gPrice;
    private Integer gTotal;
    private Integer gHave;
    private Integer gSold;
    private String type;
    private Double money;
    private Integer total;
}
