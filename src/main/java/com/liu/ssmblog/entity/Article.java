package com.liu.ssmblog.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: llliujw
 * @Description: 数据表article对应实体类 ：文章
 */
@Data
public class Article implements Serializable {
    /**
     * 序列化字段，使类对象在序列化时具有一定的向下兼容的能力
     */
    private static final long serialVersionUID = -2272692992599858115L;

    /**
     * 文章ID
     */
    private Integer articleId;

    /**
     * 文章作者ID
     */
    private Integer articleUserId;

    /**
     * 文章标题
     */
    private String articleTitle;

    /**
     * 文章摘要
     */
    private String articleSummary;

    /**
     * 文章缩略图
     */
    private String articleThumbnail;

    /**
     * 文章内容
     */
    private String articleContent;

    /**
     * 文章访问量
     */
    private Integer articleViewCount;

    /**
     * 文章评论数
     */
    private Integer articleCommentCount;

    /**
     * 文章点赞数
     */
    private Integer articleLikeCount;

    /**
     * 文章状态 ：VisibleStatus
     */
    private Integer articleStatus;

    /**
     * 文章创建时间
     */
    private Date articleCreateTime;

    /**
     * 文章更新时间
     */
    private Date articleUpdateTime;

}