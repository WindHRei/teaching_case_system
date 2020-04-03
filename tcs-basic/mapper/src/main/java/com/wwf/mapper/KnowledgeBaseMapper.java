package com.wwf.mapper;

import com.wwf.commons.IBaseDao;
import com.wwf.commons.vo.CategoryVO;
import com.wwf.entity.KnowledgeBase;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author WangWeifeng
 * @date 2020-3-7 下午 6:54
 */
public interface KnowledgeBaseMapper extends IBaseDao<KnowledgeBase> {
    /**
     * 获取标题的vo
     * @param parentId
     * @return
     */
    List<CategoryVO> selectVOByPid(Integer parentId);

    /**
     * 通过baseNo获取knowledgeBase对象
     * @param baseNo
     * @return
     */
    KnowledgeBase selectByBaseNo(String baseNo);
}
