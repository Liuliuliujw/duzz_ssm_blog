package com.liu.ssmblog.controller;

import com.github.pagehelper.PageInfo;
import com.liu.ssmblog.entity.Article;
import com.liu.ssmblog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: llliujw
 * @Description: 处理主页相关请求
 */
@Controller
public class indexController {

    @Autowired
    ArticleService articleService;

    private static final Integer DEFAULT_PAGE_SIZE = 10;

    /**
     * 首页
     *
     * @return
     */
    @GetMapping(value = {"/", "/index"})
    public String index(HttpServletRequest request, @RequestParam(value = "pageIndex", defaultValue = "1") Integer pageIndex,
                        @RequestParam(value = "sortBy", defaultValue = "createTime")String sortBy) {
        PageInfo<Article> articlePage = null;
        switch (sortBy.trim()){
            case "ViewCount" :
                articlePage = articleService.listArticleByViewCount(pageIndex, DEFAULT_PAGE_SIZE);
                break;
            case "CommentCount":
                articlePage = articleService.listArticleByCommentCount(pageIndex, DEFAULT_PAGE_SIZE);
                break;
            case "CreateTime" :
            default :
                articlePage = articleService.listArticleByCreateTime(pageIndex, DEFAULT_PAGE_SIZE);
                break;
        }
        request.setAttribute("articlePage", articlePage);
        return "index";
    }

}
