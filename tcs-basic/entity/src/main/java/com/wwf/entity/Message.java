package com.wwf.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author WangWeifeng
 * @date 2020-3-7 下午 6:26
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message implements Serializable {
    private int id;
    private int fromUserId;
    private int toUserId;
    private String content;
    private Date createTime;
    private String status;
    private Date sendTime;
    private int messageType;
    private String fromUserName;
    private String toUserName;
}
