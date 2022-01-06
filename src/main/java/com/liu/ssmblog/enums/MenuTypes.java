package com.liu.ssmblog.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author: llliujw
 * @Description: 菜单类型
 */
@Getter
@AllArgsConstructor
public enum MenuTypes {

    SYSTEM_PAGE(1, "系统页面"),
    CUSTOM_PAGE(2, "自定义页"),
    HYPERLINKS(3, "超链接");

    private Integer value;

    private String message;

}
