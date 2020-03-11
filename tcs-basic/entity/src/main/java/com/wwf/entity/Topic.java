package com.wwf.entity;

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
     * @param topicStatus 话题状态，是否发布
     * @param topicContent 话题内容
     *
     */
    private int id;
    private int typeId;
    private String typeName;
    private int topicWriterId;
    private String topicWriterName;
    private String topicOutline;
    private Date createTime;
    private int topicLikesCount;
    private int topicCollectCount;
    private String topicStatus;
    private String topicContent;
}
