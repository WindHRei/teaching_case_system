package com.wwf.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.util.Date;

/**
 * @author WangWeifeng
 * @date 2020-3-7 下午 5:40
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher implements Serializable {
    /**
     * @param id 主键
     * @param username 用户名
     * @param password 密码
     * @param age 年龄
     * @param sex
     * @param nickName 昵称
     * @param phone 电话
     * @param email 邮箱
     * @param fansCount 粉丝数
     * @param releaseTopicCount 发布话题数
     * @param releaseCaseCount 发布案例数
     * @param createTime 创建时间
     * @param credit 积分数
     * @param updateTime 更新时间
     * @param status 状态码
     */
    private int id;
    private String userNo;
    private String username;
    private String password;
    private int age;
    private String sex;
    private String nickName;
    private String imageUrl;
    private String phone;
    private String email;
    private int fansCount;
    private int releaseTopicCount;
    private int releaseCaseCount;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;
    private int credit;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updateTime;
    private String status;

    /**
     *   用户偏好
     */
    private String like;

    /**
     * @param collectCount 收藏数
     * @param subscribeCount 订阅数
     */
    private Integer collectCount;

    private Integer subscribeCount;
    /**
     * 接收前端图片数据
     */
    /*private MultipartFile file;*/



}
