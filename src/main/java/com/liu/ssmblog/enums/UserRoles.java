package com.liu.ssmblog.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author: llliujw
 * @Description:
 */
@Getter
@AllArgsConstructor
public enum UserRoles {

    ADMIN(1, "管理员"),
    USER(2, "用户");

    private Integer value;

    private String message;

}
