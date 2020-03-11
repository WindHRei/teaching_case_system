package com.wwf.tcsssoapi;

import com.wwf.commons.IBaseService;
import com.wwf.commons.pojo.ResultBean;
import com.wwf.entity.Teacher;

/**
 * @author WangWeifeng
 * @date 2020-3-11 下午 4:10
 */
public interface ISSOService  extends IBaseService<Teacher> {
    /**
     * 验证用户信息
     * @param teacher 携带用户名，密码
     * @return
     */
    ResultBean checkLogin(Teacher teacher);

    /**
     * 验证用户是否登录
     * @param identification
     * @return
     */
    ResultBean checkIsLogin(String identification);

}
