package com.liu.ssmblog.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: llliujw
 * @Description: 数据表article_tag_ref对应实体类
 */
@Data
public class ArticleTagRef implements Serializable {
    /**
     * 序列化字段，使类对象在序列化时具有一定的向下兼容的能力
     */
    private static final long serialVersionUID = 7268963418052559072L;

    /**
     * 文章ID
     */
    private Integer articleId;

    /**
     * 标签ID
     */
    private Integer tagId;

}
