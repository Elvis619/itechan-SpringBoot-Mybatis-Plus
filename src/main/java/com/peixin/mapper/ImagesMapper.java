package com.peixin.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.peixin.entity.Images;
import com.peixin.entity.ImagesVO;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImagesMapper extends BaseMapper<Images> {
    @Select("SELECT g.`g_name`,g.`g_price`,i.* FROM images i,goods g WHERE i.`gid` = g.`id` AND i.id <=3 ")
    List<ImagesVO> swiperList();
    @Select("SELECT g.`g_name`,g.`g_price`,i.* FROM images i,goods g WHERE i.`gid` = g.`id` AND i.id >=4 AND i.id <=8 ")
    List<ImagesVO> hengList();
    @Select("SELECT g.`g_name`,g.`g_price`,i.* FROM images i,goods g WHERE i.`gid` = g.`id` AND i.id >=9 AND i.id <=14 ")
    List<ImagesVO> suList();
    @Select("SELECT g.`g_name`,g.`g_price`,i.* FROM images i,goods g WHERE i.`gid` = g.`id`")
    List<ImagesVO> allList();
}
