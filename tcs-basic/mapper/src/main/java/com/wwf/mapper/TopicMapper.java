package com.wwf.mapper;

import com.wwf.commons.IBaseDao;
import com.wwf.entity.Category;
import com.wwf.entity.Comment;
import com.wwf.entity.Topic;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author WangWeifeng
 * @date 2020-3-7 下午 6:56
 */
public interface TopicMapper extends IBaseDao<Topic> {
    List<Topic> getTopicByTeacherLikes(List<Category> list);


    void updateTopicCommentCount(@Param("topicId") Integer topicId,@Param("count") Integer count);

    void updateByTeacherId(Topic topic);

    List<Topic> listUserTopicByStatus(@Param("userId") Integer userId,@Param("status") String status);

    Topic selectUnReleasedTopic(Integer topicId);

    Topic checkCurrentUser(@Param("currentId") int currentTeacherId,@Param("topicId") Integer topicId);

    List<Topic> getTopicByIds(@Param("topicIds") List<Integer> topicIds);
}
