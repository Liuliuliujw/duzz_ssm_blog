package com.liu.ssmblog.controller;

import com.liu.ssmblog.entity.Link;
import com.liu.ssmblog.enums.AvailableStatus;
import com.liu.ssmblog.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author: llliujw
 * @Description: 处理友链相关请求
 */
@Controller
public class LinkController {

    @Autowired
    LinkService linkService;

    @GetMapping("/link")
    public String link(HttpServletRequest request){
        List<Link> links = linkService.listLink(AvailableStatus.ENABLE.getValue());
        request.setAttribute("links", links);
        return "link";
    }

}
