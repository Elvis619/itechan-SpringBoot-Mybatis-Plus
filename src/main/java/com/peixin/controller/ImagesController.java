package com.peixin.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.peixin.entity.Images;
import com.peixin.entity.ImagesVO;
import com.peixin.mapper.ImagesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/images")
public class ImagesController {
    @Autowired
    private ImagesMapper mapper;
    @GetMapping("/swiper")
    public List<ImagesVO> imgSrc(){
        List<ImagesVO> images = mapper.swiperList();
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
    @GetMapping("/findById/{id}")
    public Object findById(@PathVariable("id") Integer id){
        Images detail = mapper.selectById(id);
        return detail;
    }
    @GetMapping("/findAll")
    public List<ImagesVO>findAll(){
        List<ImagesVO> allList = mapper.allList();
        return allList;
    }
}
