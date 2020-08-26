package com.peixin.controller;

import com.peixin.entity.Categories;
import com.peixin.mapper.CategoriesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/wx")
public class CategoriesController {
    @Autowired
    private CategoriesMapper mapper;
    @GetMapping("/category")
    public List<Categories> category(){
        return mapper.selectList(null);
    }
}
