package com.peixin.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.peixin.entity.Images;
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
        wrapper.lt("id",4);
        List<Images> images = mapper.selectList(wrapper);
        return images;
    }
}
