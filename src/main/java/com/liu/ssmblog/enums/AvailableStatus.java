package com.liu.ssmblog.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author: llliujw
 * @Description: 可用状态
 */
@Getter
@AllArgsConstructor
public enum AvailableStatus {

    ENABLE(1, "启用"),
    DISABLE(0, "禁用");

    private Integer value;

    private String message;

}