package com.peixin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.peixin.mapper")
public class ItechanApplication {

    public static void main(String[] args) {
        SpringApplication.run(ItechanApplication.class, args);
    }

}
