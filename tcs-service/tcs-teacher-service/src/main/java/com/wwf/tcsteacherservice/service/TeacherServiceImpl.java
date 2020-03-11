package com.wwf.tcsteacherservice.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.wwf.commons.IBaseDao;
import com.wwf.commons.impl.BaseServiceImpl;
import com.wwf.commons.pojo.ResultBean;
import com.wwf.entity.Teacher;
import com.wwf.mapper.TeacherMapper;
import com.wwf.tcsteacherapi.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author WangWeifeng
 * @date 2020-3-9 下午 5:40
 */
@Service
public class TeacherServiceImpl extends BaseServiceImpl<Teacher> implements ITeacherService{

    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public IBaseDao<Teacher> getDao() {
        return teacherMapper;
    }

    @Override
    public ResultBean checkUserNameIsExist(String username) {
        int i = teacherMapper.checkUserNameIsExist(username);
        if (i == 0){
            return new ResultBean("200",false);
        }
        return new ResultBean("500",true);
    }

    @Override
    public ResultBean checkPhoneIsExist(String phone) {
        int i = teacherMapper.checkPhoneIsExist(phone);
        if (i == 0){
            return new ResultBean("200",false);
        }
        return new ResultBean("500",true);
    }

    @Override
    public ResultBean checkEmailIsExist(String email) {
        int i = teacherMapper.checkEmailIsExist(email);
        if (i == 0){
            return new ResultBean("200",false);
        }
        return new ResultBean("500",true);
    }

    @Override
    public ResultBean register(Teacher teacher) {
        int i = getDao().insertSelective(teacher);
        if (i==1){
            return new ResultBean("200",teacher);
        }
        return new ResultBean("500",null);
    }

    @Override
    public ResultBean generateCode(String identification) {
        return null;
    }
}
