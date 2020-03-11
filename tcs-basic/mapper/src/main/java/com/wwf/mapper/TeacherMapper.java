package com.wwf.mapper;

import com.wwf.commons.IBaseDao;
import com.wwf.entity.Teacher;

/**
 * @author WangWeifeng
 * @date 2020-3-7 下午 6:55
 */
public interface TeacherMapper extends IBaseDao<Teacher> {
    /**
     * 检验用户名是否存在
     * @param username
     * @return
     */
    public  int checkUserNameIsExist(String username);

    /**
     * 检验手机号是否存在
     * @param phone
     * @return
     */
    public  int checkPhoneIsExist(String phone);

    /**
     * 检验邮箱是否存在
     * @param email
     * @return
     */
    public  int checkEmailIsExist(String email);

    public Teacher selectByIdentification(String identification);
}
