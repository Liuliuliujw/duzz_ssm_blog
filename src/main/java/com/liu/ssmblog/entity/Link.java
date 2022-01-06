package com.liu.ssmblog.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 *  @author: llliujw
 *  @Description: 数据表link对应实体类 ：友链
 */
@Data
public class Link  implements Serializable{
    /**
     * 序列化字段，使类对象在序列化时具有一定的向下兼容的能力
     */
    private static final long serialVersionUID = 50968412509849307L;

    /**
     * 友链ID
     */
    private Integer linkId;

    /**
     * 友链URL
     */
    private String linkUrl;

    /**
     * 友链名
     */
    private String linkName;

    /**
     * 友链描述
     */
    private String linkDescription;

    /**
     * 友链拥有者昵称
     */
    private String linkOwnerNickname;

    /**
     * 友链拥有者的联系方式
     */
    private String linkOwnerContact;

    /**
     * 友链更新时间
     */
    private Date linkUpdateTime;

    /**
     * 友链创建时间
     */
    private Date linkCreateTime;

    /**
     * 友链状态：AvailableStatus
     */
    private Integer linkStatus;

}