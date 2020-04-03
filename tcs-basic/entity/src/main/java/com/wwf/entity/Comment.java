package com.wwf.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author WangWeifeng
 * @date 2020-3-7 下午 6:03
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment implements Serializable {
    /**
     * @param id 主键
     * @param commentFromId 发表话题人Id
     * @param commentFromName 发布话题人名称
     * @param commentCreateTime 话题发布时间
     * @param commentStatus 话题状态 是否删除 针对话题的评论是否被题主采纳
     * @param commentContent 话题内容
     * @param userImageUrl 话题人的头像地址
     */
    private int id;
    private int commentFromId;
    private String commentFromName;
    private Date commentCreateTime;
    private String commentStatus;
    private String commentContent;
    private String userImageUrl;
}
