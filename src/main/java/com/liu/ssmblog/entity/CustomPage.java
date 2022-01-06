package com.liu.ssmblog.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: llliujw
 * @Description: 数据表custom_page对应实体类 ：自定义页面
 */
@Data
public class CustomPage implements Serializable {
    /**
     * 序列化字段，使类对象在序列化时具有一定的向下兼容的能力
     */
    private static final long serialVersionUID = 5724430666734626033L;

    /**
     * 页面ID
     */
    private Integer pageId;

    /**
     * 页面的访问Url后缀
     */
    private String pageKey;

    /**
     * 页面标题
     */
    private String pageTitle;

    /**
     * 页面内容
     */
    private String pageContent;

    /**
     * 页面创建时间
     */
    private Date pageCreateTime;

    /**
     * 页面更新时间
     */
    private Date pageUpdateTime;

    /**
     * 页面状态：AvailableStatus
     */
    private Integer pageStatus;

}
