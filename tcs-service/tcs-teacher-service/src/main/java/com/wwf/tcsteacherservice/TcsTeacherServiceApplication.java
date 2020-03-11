package com.wwf.tcsteacherservice;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Wangweifeng
 */
@SpringBootApplication
@MapperScan(value = "com.wwf.mapper")
@EnableDubbo
public class TcsTeacherServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(TcsTeacherServiceApplication.class, args);
    }

}
