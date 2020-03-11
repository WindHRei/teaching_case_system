package com.wwf.tcsteacherapi;

import com.wwf.commons.IBaseService;
import com.wwf.commons.pojo.ResultBean;
import com.wwf.entity.Teacher;

/**
 * @author WangWeifeng
 * @date 2020-3-9 下午 5:23
 */
public interface ITeacherService extends IBaseService<Teacher> {
    /**
     * 验证用户名是否存在
     * @param username 用户名
     * @return
     */
    public ResultBean checkUserNameIsExist(String username);

    /**
     * 验证手机号是否存在
     * @param phone
     * @return
     */
    public ResultBean checkPhoneIsExist(String phone);

    /**
     * 验证邮箱是否存在
     * @param email 邮箱号码
     * @return
     */
    public ResultBean checkEmailIsExist(String email);

    /**
     * 注册账号
     * @param teacher 教师信息
     * @return
     */
    public ResultBean register(Teacher teacher);

    /**
     * 生成短信验证码---短信服务
     * @param identification 凭证
     * @return
     */
    public ResultBean generateCode(String identification);


}
