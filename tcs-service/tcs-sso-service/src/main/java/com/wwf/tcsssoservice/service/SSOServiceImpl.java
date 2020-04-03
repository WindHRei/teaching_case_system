package com.wwf.tcsssoservice.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.wwf.commons.IBaseDao;
import com.wwf.commons.constant.UserConstant;
import com.wwf.commons.impl.BaseServiceImpl;
import com.wwf.commons.pojo.ResultBean;
import com.wwf.entity.Teacher;
import com.wwf.mapper.CategoryMapper;
import com.wwf.mapper.TeacherMapper;
import com.wwf.tcsssoapi.ISSOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author WangWeifeng
 * @date 2020-3-11 下午 4:09
 */
@Service
public class SSOServiceImpl extends BaseServiceImpl<Teacher> implements ISSOService{
    @Autowired
    private TeacherMapper teacherMapper;


    @Resource(name = "stringSerializerRedisTemplate")
    private RedisTemplate redisTemplate;
    @Override
    public IBaseDao<Teacher> getDao() {
        return teacherMapper;
    }


    @Override
    public ResultBean checkLogin(Teacher teacher) {
        try {
            Teacher currentTeacher = teacherMapper.selectByIdentification(teacher.getUsername());
            System.out.println("登录的教师对象为..."+currentTeacher);
            if (currentTeacher!=null){
                if (teacher.getPassword().equals(currentTeacher.getPassword())){
                    String uuid = UUID.randomUUID().toString();
                    redisTemplate.opsForValue().set(UserConstant.USER_LOGIN_KEY +uuid,currentTeacher,30, TimeUnit.MINUTES);
                    return new ResultBean("200",uuid);
                }
            }
            return new ResultBean("404",null);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("检验出错====>"+teacher.getPhone());
            return new ResultBean("404",null);
        }
    }

    @Override
    public ResultBean checkIsLogin(String identification) {
        Teacher teacher = (Teacher) redisTemplate.opsForValue().get(UserConstant.USER_LOGIN_KEY + identification);
        if ( null != teacher){
            redisTemplate.expire(UserConstant.USER_LOGIN_KEY+identification,30,TimeUnit.MINUTES);
            return new ResultBean("200",identification);
        }
        return new ResultBean("404",null);
    }
}
