package com.wwf.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author WangWeifeng
 * @date 2020-3-7 下午 7:25
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TopicDesc implements Serializable {
    private int id;
    private int topicId;
    private String topicContent;
}
