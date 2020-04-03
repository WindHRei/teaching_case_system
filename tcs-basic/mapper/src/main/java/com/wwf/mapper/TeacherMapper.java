package com.wwf.mapper;

import com.wwf.commons.IBaseDao;
import com.wwf.entity.Teacher;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

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

    /**
     * 根据用户名更新密码
     * @param teacher
     * @return
     */
    public int updatePassword(Teacher teacher);

    /**
     * 添加教师偏好
     * @param like
     * @return
     */
    Integer addTeacherLikes(@Param("teacherId") int teacherId,@Param("like") String like);

    String getTeacherLikes(int id);

    Integer updateTeacherLikes(@Param("teacherId")int teacherId,@Param("like") String like);

    /**
     * 更新教师收藏数
     * @param teacherId
     * @return
     */
    Integer updateCollectCount(Integer teacherId);

    /**
     *更新教师订阅数
     * @param teacherId
     * @return
     */
    Integer updateSubscribeCount(Integer teacherId);

    /**
     * 更新用户粉丝数
     * @param teacherId
     * @return
     */
    Integer updateFansCount(Integer teacherId);

    /**
     * 更新用户积分数
     */

    /**
     * 更新用户发布案例数+1
     * @param teacherId 被更新的用户id
     */
    Integer updateReleaseCaseCount(Integer teacherId);

    /**
     * 更新用户发布的话题数+1
     * @param teacherId
     * @return
     */
    Integer updateReleaseTopicCount(Integer teacherId);

    /**
     * 用户订阅
     * @param map
     * @return
     */
    Integer addTeacherSubscribe(Map<String,Object> map);

    Integer getTargetCount(String targetId);

    Integer getCurrentTeacherSubscribeCount(int id);

    Integer addTeacherCollections(Map<String, Object> map);

    Integer getCollectCountByTeacherId(int currentTeacherId);

    Integer getTargetCollectCount(@Param("targetId") Integer targetId,@Param("typeId") String typeId);

    List<Teacher> getMembers(List<Integer> memberIds);

    int checkHasSubscribed(@Param("writerId") Integer writerId,@Param("currentId") int currentTeacherId);

    int checkHasCollected(@Param("currentId") int currentTeacherId,@Param("targetId") Integer targetId,@Param("identity") String typeIdentity);

    Teacher getTeacherByIdForUpdate(int commentFromId);

    List<Integer> getUserCollectCaseId(int currentTeacherId);

    List<Integer> getUserCollectTopicId(int currentTeacherId);

    List<Integer> getSubscribeTeachers(int currentTeacherId);
}