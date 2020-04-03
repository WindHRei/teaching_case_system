package com.wwf.tcsteacherapi;

import com.alibaba.fastjson.JSONObject;
import com.wwf.commons.IBaseService;
import com.wwf.commons.pojo.ResultBean;
import com.wwf.entity.Category;
import com.wwf.entity.Teacher;

import java.util.List;
import java.util.Map;

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
     * @param jsonObject 教师信息字符串
     * @return
     */
    public Map<String,String> register(JSONObject jsonObject);

    /**
     * 生成短信验证码---短信服务
     * @param identification 凭证
     * @return
     */
    public ResultBean generateCode(String identification);

    /**
     * 更新密码
     * @param teacher 用户名 新密码
     * @return
     */

    public Object updatePassword(Teacher teacher);

    /**
     * 根据uuid获取到当前教师对象
     * @param uuid
     * @return
     */
    public Teacher getByToken(String uuid);
    /**
     * 获取用户偏好
     * @param id
     * @return
     */
    List<Category> getTeacherLikes(int id);

    /**
     * 更新用户redis中的对象
     * @param teacherId
     * @param userToken
     * @return
     */
    ResultBean updateToken(int teacherId, String userToken);

    /**
     * 更新数据库和redis中教师信息
     * @param teacher
     * @return
     */
    Object modifyTeacher(String teacher);

    Object toSubscribe(String targetId,String userToken);

    Object toCollect(Integer targetId,String identity, String userToken);

    Object checkHasSubscribed(Integer writerId, String userToken);

    Object checkHasCollected(String identity, Integer targetId, String userToken);

    Map<String, Object> getTeacherCollections(String userToken);

    Map<String, Object> getTeacherSubscribe(String userToken);
}
