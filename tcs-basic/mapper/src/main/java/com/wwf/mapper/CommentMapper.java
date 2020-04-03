package com.wwf.mapper;

import com.wwf.commons.IBaseDao;
import com.wwf.entity.Comment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author WangWeifeng
 * @date 2020-3-7 下午 6:54
 */
public interface CommentMapper extends IBaseDao<Comment> {
    List<Comment> getCommentByIds(List<Integer> ids);

    List<Integer> getCommentIdByTopicId(Integer topicId);

    List<Integer> getCommentIdByCaseId(Integer caseId);

    void addCommentToCase(@Param("commentId") Integer id,@Param("caseId") Integer caseId);

    Integer getCaseCommentCount(Integer caseId);

    void addCommentToTopic(@Param("topicId") Integer topicId,@Param("commentId") int id);

    Integer getTopicCommentCount(Integer topicId);


}
