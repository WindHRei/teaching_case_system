package com.wwf.mapper;

import com.wwf.commons.IBaseDao;
import com.wwf.entity.Category;
import com.wwf.entity.KnowledgeCircle;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author WangWeifeng
 * @date 2020-3-7 下午 6:55
 */
public interface KnowledgeCircleMapper extends IBaseDao<KnowledgeCircle> {
    Integer addMemberIds(@Param("circleId") int circleId,@Param(("memberIds")) List<Integer> ids);

    void addCircleCategories(@Param("circleId") int circleId,@Param("categories") List<Category> categoryList);

    List<KnowledgeCircle> listCircle();

    Integer getCircleCount();


    List<Integer> getMemberIds(Integer circleId);

    KnowledgeCircle getCircleById(Integer circleId);

    Integer getCreatorIdByCircleId(int circleId);

    void updateCircleCaseCount(@Param("circleId") Integer circleId,@Param("caseCount") Integer count);

    List<Integer> getCircleIdByUserId(int currentTeacherId);

    List<KnowledgeCircle> listCircleByIds(@Param("circleIds") List<Integer> circleIds);
}
