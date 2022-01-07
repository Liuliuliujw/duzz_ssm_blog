package com.liu.ssmblog.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: llliujw
 * @Description: 数据表user对应实体类
 */
@Data
public class User implements Serializable {
    /**
     * 序列化字段，使类对象在序列化时具有一定的向下兼容的能力
     */
    private static final long serialVersionUID = 3290379008376713404L;

    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 用户密码
     */
    private String userPass;

    /**
     * 用户昵称
     */
    private String userNickname;

    /**
     * 用户邮箱
     */
    private String userEmail;

    /**
     * 用户头像
     */
    private String userAvatar;

    /**
     * 用户注册时间
     */
    private Date userRegisterTime;

    /**
     * 用户最后登录时间
     */
    private Date userLastLoginTime;

    /**
     * 用户状态：UserStatus
     */
    private Integer userStatus;

    /**
     * 用户角色：UserRoles
     */
    private Integer userRole;

}