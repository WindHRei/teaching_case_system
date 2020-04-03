package com.wwf.tcsteacherservice;

import com.wwf.entity.Teacher;
import com.wwf.mapper.TeacherMapper;
import com.wwf.tcsteacherapi.ITeacherService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class TcsTeacherServiceApplicationTests {

    @Resource(name = "stringSerializerRedisTemplate")
    private RedisTemplate redisTemplate;

    @Autowired
    private ITeacherService teacherService;
    @Autowired
    private TeacherMapper teacherMapper;
    @Test
    void contextLoads() {
        redisTemplate.opsForValue().set("k1","10086");
        String v1 = (String) redisTemplate.opsForValue().get("k1");
        System.out.println(v1);
    }

    public void serviceTest(){
        teacherService.checkUserNameIsExist("123");
    }

    @Test
    public void addTest(){
        Teacher teacher = new Teacher();
        teacher.setId(62);
        teacher.setNickName("zsf");
        Map<String,Object> map = new HashMap<>();
        map.put("targetTeacher",teacher);
        map.put("currentTeacherId",1);
        teacherMapper.addTeacherSubscribe(map);
    }
}
