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
 * @date 2020-3-7 下午 5:49
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Topic implements Serializable {
    /**
     * @param id 主键
     * @param typeId 类型id
     * @param typeName 类型名称
     * @param topicWriterId 话题作者id
     * @param topicWriterName 话题作者名称
     * @param topicOutline 话题标题
     * @param createTime 创建时间
     * @param topicLikesCount 话题点赞数
     * @param topicCollectCount 话题收藏数
     * @param topicStatus 话题状态，是否发布 0--未发布 1--已发布，未结题  2--已发布，已结题
     * @param topicContent 话题内容
     *
     */
    private int id;
    private int typeId;
    private String typeName;
    private int topicWriterId;
    private String topicWriterName;
    private String writerImageUrl;
    private String topicTitle;
    private String topicOutline;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updateTime;
    private int topicLikesCount;
    private int topicCollectCount;
    private int topicCommentCount;
    private String topicStatus;
    private String topicTimeStamp;
    private Integer acceptCommentId;

    private int topicCredit;

    public Topic(JSONObject jsonObject) {
        String typeId = jsonObject.getString("typeId");
        this.typeId = Integer.parseInt(typeId);
        this.typeName = jsonObject.getString("topicTypeName");
        this.topicTimeStamp = jsonObject.getString("topicTimeStamp");
        this.topicStatus = jsonObject.getString("topicStatus");
        this.topicTitle = jsonObject.getString("topicTitle");
        this.topicCredit = Integer.parseInt(jsonObject.getString("topicCredit"));
        this.topicOutline = jsonObject.getString("topicOutline");
    }
}
