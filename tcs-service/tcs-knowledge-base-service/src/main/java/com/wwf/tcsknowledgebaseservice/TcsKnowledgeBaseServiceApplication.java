package com.wwf.tcsknowledgebaseservice;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = "com.wwf.mapper")
@EnableDubbo
public class TcsKnowledgeBaseServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(TcsKnowledgeBaseServiceApplication.class, args);
    }

}
