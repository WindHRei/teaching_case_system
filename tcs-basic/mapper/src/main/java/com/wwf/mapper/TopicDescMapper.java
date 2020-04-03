package com.wwf.mapper;

import com.wwf.commons.IBaseDao;
import com.wwf.entity.Topic;
import com.wwf.entity.TopicDesc;

/**
 * @author WangWeifeng
 * @date 2020-3-9 上午 10:06
 */
public interface TopicDescMapper extends IBaseDao<TopicDesc> {
    TopicDesc selectByTopicId(Integer topicId);

    Integer updateByTopicId(TopicDesc desc);
}
