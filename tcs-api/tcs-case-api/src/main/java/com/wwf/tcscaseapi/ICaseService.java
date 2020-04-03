package com.wwf.tcscaseapi;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.wwf.commons.IBaseService;
import com.wwf.commons.pojo.ResultBean;
import com.wwf.entity.Case;
import com.wwf.entity.Topic;
import com.wwf.entity.UserAccessLogs;

import java.util.Map;

/**
 * @author WangWeifeng
 * @date 2020-3-11 下午 4:50
 */
public interface ICaseService extends IBaseService<Case> {

    /**
     * 获取当前用户相关领域内的案例,按照时间排序
     * @param teacherId  当前教师id
     * @return
     */
    PageInfo<Case> selectByTeacherLikes(Integer teacherId);

    /**
     * 根据点赞数分页展示
     * @param curr
     * @param limit
     * @return
     */
    PageInfo<Case> selectByLikesCount(Integer curr,Integer limit);

    /**
     * 根据教师偏好查询话题
     * @param teacherId
     * @return
     */
    PageInfo<Topic> selectTopicByTeacherLikes(Integer teacherId);

    /**
     * 发布案例
     * @param jsonObject
     * @param uuid
     * @return
     */
    ResultBean publish(JSONObject jsonObject, String uuid);

    /**
     * 查看案例详情
     * @param caseId
     * @param currentUserId
     * @return
     */
    Map<String, Object> getDetail(int caseId, Integer currentUserId);

    PageInfo getCasePageInfo(Integer curr, Integer limit, Integer typeId);

    PageInfo<Case> selectByLikesCountNewly();

    PageInfo<Case> selectByUserId(Integer curr, Integer limit, Integer userId, String status);

    PageInfo<UserAccessLogs> getUserHasRead(Integer userId, Integer curr, Integer limit);

    Object deleteHistory(Integer logId);

    Map<String, Object> getCaseDetail(Integer caseId);

    Object redit(JSONObject jsonObject, String uuid);

    Object publishComment(String body, String userToken);


}
