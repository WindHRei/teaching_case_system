package com.wwf.entity;



import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author WangWeifeng
 * @date 2020-3-2 下午 4:00
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Case implements Serializable {
    /**
     * @param id 主键
     * @param caseTitle 案例标题
     * @param caseTypeId 案例类型id
     * @param caseTypeName 案例类型名
     * @param caseOutline 案例梗概
     * @param writerId 作者id
     * @param writerName 作者名称
     * @param createTime 创建日期
     * @param updateTime 更新日期
     * @param collectCount 收藏数
     * @param likesCount 点赞数
     * @param caseStatus 案例状态 未发布 已发布
     * @param circleId 案例所属知识圈id 可为空
     * @param circleCreatorId 案例所属知识圈创建者id
     * @param circleName 案例所属知识圈名称
     * @param caseCommentCount 案例评论数

     * */
    private Integer id;
    private String caseTitle;
    private Integer caseTypeId;
    private String caseTypeName;
    private String caseOutline;
    private Integer caseWriterId;
    private String caseWriterName;
    private String writerImageUrl;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date caseCreateTime;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date caseUpdateTime;
    private Integer caseCollectCount;
    private Integer caseLikesCount;
    private Integer caseCommentCount;
    private String caseStatus;
    private Integer circleId;
    private String circleImageUrl;
    private String circleName;
    private String caseTimestamp;

    public Case(JSONObject jsonObject) {
        this.caseTitle = jsonObject.getString("caseTitle");
        this.caseTypeId = Integer.parseInt(jsonObject.getString("caseTypeId"));
        this.caseTypeName = jsonObject.getString("caseTypeName");
        this.caseOutline = jsonObject.getString("caseOutline");
        this.caseStatus = jsonObject.getString("caseStatus");
        this.caseTimestamp = jsonObject.getString("caseTimestamp");
        this.circleId = jsonObject.getInteger("circleId");
        this.circleName = jsonObject.getString("circleName");
        this.circleImageUrl = jsonObject.getString("circleImageUrl");
    }
}
