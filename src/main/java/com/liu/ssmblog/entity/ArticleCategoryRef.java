package com.liu.ssmblog.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: llliujw
 * @Description: 数据表article_category_ref对应实体类
 */
@Data
public class ArticleCategoryRef implements Serializable {
    /**
     * 序列化字段，使类对象在序列化时具有一定的向下兼容的能力
     */
    private static final long serialVersionUID = -852898316761044037L;

    /**
     * 文章ID
     */
    private Integer articleId;

    /**
     * 分类ID
     */
    private Integer categoryId;
}