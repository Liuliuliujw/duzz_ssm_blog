package com.liu.ssmblog.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author: llliujw
 * @Description: 可视状态
 */
@Getter
@AllArgsConstructor
public enum VisibleStatus {

    NORMAL(1, "显示"),
    HIDDEN(0, "隐藏");

    private Integer value;

    private String message;

}
