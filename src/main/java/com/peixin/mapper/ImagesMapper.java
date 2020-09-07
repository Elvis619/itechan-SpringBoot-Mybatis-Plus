package com.peixin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.peixin.entity.Images;
import com.peixin.entity.ImagesVO;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImagesMapper extends BaseMapper<Images> {
    @Select("SELECT i.`id`g.`g_name`,g.`g_price`,i.`img_src` FROM images i,goods g WHERE i.`gid` = g.`id`")
    List<ImagesVO> imgList();
}
