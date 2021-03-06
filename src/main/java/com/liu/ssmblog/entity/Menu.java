package com.liu.ssmblog.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author: llliujw
 * @Description: 数据表menu对应实体类 ：菜单
 */
@Data
public class Menu implements Serializable {
    /**
     * 序列化字段，使类对象在序列化时具有一定的向下兼容的能力
     */
    private static final long serialVersionUID = 3083299261847262945L;

    /**
     * 菜单ID
     */
    private Integer menuId;

    /**
     * 菜单父节点ID
     */
    private Integer menuPid;

    /**
     * 菜单类型 ：MenuTypes
     */
    private Integer menuType;

    /**
     * 菜单名
     */
    private String menuName;

    /**
     * 菜单的URL
     */
    private String menuUrl;

    /**
     * 子菜单（非数据库字段）
     */
    private List<Menu> childrenMenus;

}
