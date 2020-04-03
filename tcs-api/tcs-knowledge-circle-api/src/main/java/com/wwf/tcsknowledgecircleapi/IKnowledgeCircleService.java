package com.wwf.tcsknowledgecircleapi;

import com.github.pagehelper.PageInfo;
import com.wwf.commons.IBaseService;
import com.wwf.entity.KnowledgeCircle;

import java.util.Map;

/**
 * @author WangWeifeng
 * @date 2020-3-11 下午 4:56
 */
public interface IKnowledgeCircleService extends IBaseService<KnowledgeCircle> {
    Object createKnowledge(String body,String userToken);

    PageInfo<KnowledgeCircle> getCircles(Integer current, Integer limit, String userToken);

    Map<String, Object> showDetail(Integer circleId,String userToken);

    Object declareCase(String body, String userToken);

    Map<String, Object> getCaseEditInfo(Integer caseId, Integer circleId, String userToken);

    Object caseRedit(String body, String userToken);

    PageInfo getUserCircles(Integer current, Integer limit, String userToken);
}
