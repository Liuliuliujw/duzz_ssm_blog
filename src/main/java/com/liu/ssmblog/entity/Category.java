package com.liu.ssmblog.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: llliujw
 * @Description: 数据表category对应实体类 ：分类
 */
@Data
public class Category implements Serializable {
    /**
     * 序列化字段，使类对象在序列化时具有一定的向下兼容的能力
     */
    private static final long serialVersionUID = 7556479140156384962L;

    /**
     * 分类ID
     */
    private Integer categoryId;

    /**
     * 分类名
     */
    private String categoryName;

    /**
     * 分类描述
     */
    private String categoryDescription;

}
