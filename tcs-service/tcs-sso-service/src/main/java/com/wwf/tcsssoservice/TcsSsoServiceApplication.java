package com.wwf.tcsssoservice;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo
@MapperScan(value = "com.wwf.mapper")
public class TcsSsoServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(TcsSsoServiceApplication.class, args);
    }

}
