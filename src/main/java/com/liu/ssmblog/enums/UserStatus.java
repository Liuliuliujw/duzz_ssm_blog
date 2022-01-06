package com.liu.ssmblog.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author: llliujw
 * @Description: 用户状态
 */
@Getter
@AllArgsConstructor
public enum UserStatus {

    NORMAL(1, "正常"),
    FORBIDDEN(2, "禁用"),
    CANCEL(3, "注销");

    private Integer value;

    private String message;

}
