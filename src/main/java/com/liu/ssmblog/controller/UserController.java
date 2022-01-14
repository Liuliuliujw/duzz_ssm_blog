package com.liu.ssmblog.controller;

import com.liu.ssmblog.entity.User;
import com.liu.ssmblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: llliujw
 * @Description: 处理主页相关请求
 */
@Controller
public class UserController {

    @Autowired
    UserService userService;

    /**
     * 登录
     *
     * @return 登录页面
     */
    @GetMapping("/login")
    public String login(){
        return "login";
    }

    /**
     * 登录验证
     *
     * @return 主页/登录页
     */
    @PostMapping ("/user/verify")
    public String loginVerify(HttpServletRequest request,  @RequestParam("email") String email, @RequestParam("password") String password){
        User user = userService.findUserByEmail(email);
        if(user == null || !user.getUserPass().equals(password)){
            request.setAttribute("info", "邮箱或密码错误");
            return "login";
        }
        request.getSession().setAttribute("user", user);
        return "redirect:/index";
    }

    public String logout(){
        return null;
    }
}
