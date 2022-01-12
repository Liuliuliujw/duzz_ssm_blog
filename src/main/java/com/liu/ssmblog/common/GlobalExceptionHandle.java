package com.liu.ssmblog.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 *  @author: llliujw
 *  @Description:全局异常处理类
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandle {

    /**
     * 500
     *
     * @param e 抛出的异常
     * @return 500页面
     */
    @ExceptionHandler(Exception.class)
    public String exceptionHandler(Exception e){
        log.error("发生异常:{}", e);
        return "common/500";
    }
}
