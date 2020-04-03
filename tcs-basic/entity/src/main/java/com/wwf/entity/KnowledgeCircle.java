package com.wwf.entity;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author WangWeifeng
 * @date 2020-3-7 下午 6:09
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class KnowledgeCircle implements Serializable {
    /**
     * @param id 主键
     * @param typeId 知识圈类型id
     * @param typeName 类型名
     * @param creatorId 创建者id
     * @param creatorName 创建者名称
     * @param circleName 知识圈名称
     * @param circleNo 知识圈号
     * @param circleMemberCount 知识圈成员数
     * @param circleCaseCount 知识圈案例数
     * @param circleCreateTime 知识圈创建时间
     * @param isExposed 是否暴露，是否只能通过知识圈号搜索加入
     */
    private int id;
    private int creatorId;
    private String creatorName;
    private String circleName;
    private String circleNo;
    private int circleMemberCount;
    private int circleMemberLimit;
    private int circleCaseCount;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date circleCreateTime;
    private String circleImageUrl;
    private String isExposed;
    private String status;
    private String circleTimeStamp;
    private List<Category> categories;
    private Teacher creator;
    private List<Teacher> members;

    public KnowledgeCircle(JSONObject jsonObject) {
        this.circleName = jsonObject.getString("circleName");
        this.circleMemberLimit = Integer.parseInt(jsonObject.getString("circleMemberLimit"));
        this.isExposed = jsonObject.getString("isExposed");
        this.circleImageUrl = jsonObject.getString("imageUrl");
        this.circleTimeStamp = jsonObject.getString("circleTimeStamp");
    }
}
