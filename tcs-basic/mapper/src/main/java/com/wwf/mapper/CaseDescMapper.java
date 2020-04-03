package com.wwf.mapper;

import com.wwf.commons.IBaseDao;
import com.wwf.entity.CaseDesc;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author WangWeifeng
 * @date 2020-3-9 下午 4:55
 */
public interface CaseDescMapper extends IBaseDao<CaseDesc> {
    CaseDesc selectByCaseId(Integer caseId);

    Integer updateByCaseId(CaseDesc caseDesc);

    List<CaseDesc> listExcludeUserById(@Param("caseId") Integer caseId,@Param("currentId") Integer currentId);

    CaseDesc getCurrentTeacherCaseDesc(@Param("caseId") Integer caseId,@Param("currentId") Integer currentId);

}
