package com.wwf.tcsssoservice;

import com.wwf.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;

@SpringBootTest
class TcsSsoServiceApplicationTests {
    @Resource(name = "stringSerializerRedisTemplate")
    private RedisTemplate redisTemplate;

    @Test
    void contextLoads() {
        Teacher teacher = new Teacher();
        teacher.setUsername("zs");
        teacher.setPassword("123");
        teacher.setId(1);
        redisTemplate.opsForValue().set("zs123",teacher);
        Teacher teacher1 = (Teacher) redisTemplate.opsForValue().get("zs123");
        System.out.println(teacher1.getUsername());
    }

}
