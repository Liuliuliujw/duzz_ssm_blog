package com.liu.ssmblog.common;

import com.liu.ssmblog.exception.ExistException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *  @author: llliujw
 *  @Description:全局异常处理类
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandle {

    @ExceptionHandler(ExistException.class)
    public void existExceptionHandler(HttpServletRequest request, HttpServletResponse response, ExistException e){
        request.setAttribute("exceptionInfo", e.getMessage());
    }

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
