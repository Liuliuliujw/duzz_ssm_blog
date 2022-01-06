package com.liu.ssmblog.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: llliujw
 * @Description: 数据表site_option对应实体类
 */
@Data
public class SiteOption implements Serializable {
    /**
     * 序列化字段，使类对象在序列化时具有一定的向下兼容的能力
     */
    private static final long serialVersionUID = 6450858315044584923L;

    /**
     * 网站标题
     */
    private Integer optionId;

    /**
     * 网站标题
     */
    private String siteTitle;

    /**
     * 网站描述
     */
    private String siteDescription;

    /**
     * 网站关键词
     */
    private String siteKeywords;

    /**
     * 网站首页地址
     */
    private String siteIndexUrl;

    /**
     * 网站备案号
     */
    private String siteIcpNum;

}
