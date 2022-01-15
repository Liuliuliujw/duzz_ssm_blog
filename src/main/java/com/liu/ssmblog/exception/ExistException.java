package com.liu.ssmblog.exception;

/**
 * @author: llliujw
 * @Description: 要插入的值已存在，抛出异常
 */
public class ExistException extends Exception {

    public ExistException(String message) {
        super(message);
    }
}
