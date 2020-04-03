package com.wwf.tcsknowledgebaseapi;

import com.wwf.commons.IBaseService;
import com.wwf.commons.vo.CategoryVO;
import com.wwf.entity.KnowledgeBase;

import java.util.List;

/**
 * @author WangWeifeng
 * @date 2020-3-11 下午 4:55
 */
public interface IKnowledgeBaseService extends IBaseService<KnowledgeBase> {
    List<CategoryVO> selectVOByPid(Integer parentId);

    KnowledgeBase selectByBaseNo(String baseNo);
}
