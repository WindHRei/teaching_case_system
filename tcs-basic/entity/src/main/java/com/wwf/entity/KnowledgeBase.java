package com.wwf.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author WangWeifeng
 * @date 2020-3-7 下午 6:19
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class KnowledgeBase implements Serializable {
    /**
     * @param id 主键
     * @param typeName 类型名
     * @param typeId 类型id
     * @param title 标题
     * @param writer 作者
     * @param content 内容
     * @param createTime 创建时间
     * @param updateTime
     * @param status
     */
    private int id;
    private int typeId;
    private String typeName;
    private String title;
    private String writer;
    private String content;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updateTime;
    private String status;
    private String baseNo;
}
