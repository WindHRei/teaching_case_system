package com.wwf.tcstopicapi;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.wwf.commons.IBaseService;
import com.wwf.entity.Topic;

import java.util.Map;

/**
 * @author WangWeifeng
 * @date 2020-3-11 下午 4:58
 */
public interface ITopicService extends IBaseService<Topic> {
    Object toPublish(String body, String userToken);

    Map<String, Object> getDetail(Integer topicId, String userToken);

    Map<String, Object> getTopic(Integer topicId);

    Object redit(JSONObject jsonObject, String userToken);

    Map<String, Object> toPublishTopic(String userToken);

    PageInfo<Topic> listTopic(Integer curr, Integer limit,String userToken);

    Object publishTopicComment(String body, String userToken);

    PageInfo<Topic> showUserTopicByStatus(Integer curr, Integer limit, Integer userId, String status);

    Object toAcceptComment(Integer topicId, Integer commentId, String userToken);
}
