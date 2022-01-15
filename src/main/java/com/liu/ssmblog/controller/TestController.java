package com.liu.ssmblog.controller;

import com.liu.ssmblog.exception.ExistException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: llliujw
 * @Description:
 */
@Controller
public class TestController {

    @GetMapping("/test")
    @ResponseBody
    public String test(HttpServletRequest request, HttpServletResponse response) throws IOException, ExistException {
        System.out.println(request.getContextPath());
        System.out.println(request.getRequestURL());
        System.out.println(request.getServletPath());
        if (request.getServletPath() != null)throw new ExistException("ookk");
        return "HelloWorld";
    }
}
