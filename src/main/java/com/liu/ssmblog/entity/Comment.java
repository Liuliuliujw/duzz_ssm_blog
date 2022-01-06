package com.liu.ssmblog.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 *  @author: llliujw
 *  @Description: 数据表comment对应实体类 ：评论
 */
@Data
public class Comment implements Serializable {
    /**
     * 序列化字段，使类对象在序列化时具有一定的向下兼容的能力
     */
    private static final long serialVersionUID = 2468516613945749130L;

    /**
     * 评论ID
     */
    private Integer commentId;

    /**
     * 上级评论ID
     */
    private Integer commentPid;

    /**
     * 评论所属文章ID
     */
    private Integer commentArticleId;

    /**
     * 评论用户ID
     */
    private String commentUserId;

    /**
     * 评论内容
     */
    private String commentContent;

    /**
     * 评论创建时间
     */
    private Date commentCreateTime;

}