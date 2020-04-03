package com.wwf.mapper;

import com.github.pagehelper.PageInfo;
import com.wwf.commons.IBaseDao;
import com.wwf.entity.Case;
import com.wwf.entity.CaseDesc;
import com.wwf.entity.Category;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author WangWeifeng
 * @date 2020-3-7 下午 6:53
 */
public interface CaseMapper extends IBaseDao<Case> {
    /**
     * 根据用户喜好来获取首页展示案例
     * @param list
     * @return
     */
    List<Case> getCaseByTeacherLikes(List<Category> list);


    void updateByTeacherId(Case teachingCase);


    List<Case> listByType(@Param("typeId") Integer typeId);

    List<Case> selectByTime(Map<String, Object> params);

    List<Case> selectByUserId(@Param("userId") Integer userId, @Param("status") String status);

    Case selectReditCase(Integer caseId);

    List<Case> getAllCaseByCircleId(Integer circleId);

    List<Case> getPublishedCaseByCircleId(Integer circleId);

    Case getCircleEditCaseById(Integer caseId);

    Integer selectCaseStatus(Integer caseId);

    Integer getCircleCaseCount(Integer circleId);


    void updateCaseCommentCount(@Param("caseId") Integer caseId,@Param("count") Integer count);

    List<Case> getCaseByIds(@Param("caseIds") List<Integer> caseIds);
}
