package com.peixin.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.peixin.entity.Images;
import com.peixin.entity.ImagesVO;
import com.peixin.mapper.ImagesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/images")
public class ImagesController {
    @Autowired
    private ImagesMapper mapper;
    @GetMapping("/swiper")
    public List<Images> imgSrc(){
        QueryWrapper<Images> wrapper = new QueryWrapper<>();
        wrapper.le("id",3);
        List<Images> images = mapper.selectList(wrapper);
        return images;
    }
    @GetMapping("/horizontal")
    public List<ImagesVO> imagesVOList(){
        List<ImagesVO> horizontalList = mapper.hengList();
        return horizontalList;
    }
    @GetMapping("/vertical")
    public List<ImagesVO> suImgList(){
        List<ImagesVO> verticalList = mapper.suList();
        return verticalList;
    }
}
