package com.wwf.tcsteacherservice;

import com.wwf.tcsteacherapi.ITeacherService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;

@SpringBootTest
class TcsTeacherServiceApplicationTests {

    @Resource(name = "stringSerializerRedisTemplate")
    private RedisTemplate redisTemplate;

    @Autowired
    private ITeacherService teacherService;
    @Test
    void contextLoads() {
        redisTemplate.opsForValue().set("k1","10086");
        String v1 = (String) redisTemplate.opsForValue().get("k1");
        System.out.println(v1);
    }

    public void serviceTest(){
        teacherService.checkUserNameIsExist("123");
    }

}
