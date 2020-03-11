package com.wwf.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author WangWeifeng
 * @date 2020-3-7 下午 7:25
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CaseDesc implements Serializable {
    /**
     * @param caseBackground 案例背景
     * @param caseDesc 案例描述
     * @param caseSummary 案例总结
     * @param caseTemplateName； 案例模板页面名称
     * @param caseEditTime 案例编辑时间
     */
    private  int id;
    private int caseId;
    private String caseBackground;
    private String caseDesc;
    private String caseSummary;
    private String caseTemplateName;
    private Date caseEditTime;
}
