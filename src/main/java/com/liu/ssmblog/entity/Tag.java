package com.liu.ssmblog.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: llliujw
 * @Description: 数据表tag对应实体类
 */
@Data
public class Tag implements Serializable {
    /**
     * 序列化字段，使类对象在序列化时具有一定的向下兼容的能力
     */
    private static final long serialVersionUID = 2981667640184951398L;

    /**
     * 标签ID
     */
    private Integer tagId;

    /**
     * 标签名
     */
    private String tagName;

    /**
     * 标签描述
     */
    private String tagDescription;

}