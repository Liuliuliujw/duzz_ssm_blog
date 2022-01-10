package com.liu.ssmblog.service;

import com.github.pagehelper.PageInfo;
import com.liu.ssmblog.entity.Article;
import com.liu.ssmblog.entity.Category;
import com.liu.ssmblog.entity.Tag;
import com.liu.ssmblog.enums.VisibleStatus;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: llliujw
 * @Description: 测试MenuService
 */
@RunWith(SpringRunner.class)
@ContextConfiguration({"/spring-mvc.xml","/spring-mybatis.xml"})
public class ServiceTest {

    @Autowired
    MenuService menuService;

    @Autowired
    ArticleService articleService;

    @Test
    public void testFindMenuTree(){
        menuService.findMenuTree().forEach(System.out::println);
    }

    @Test
    public void testInsertArticle(){
        Article article = new Article();
        article.setArticleUserId(1011); //测试用户ID
        article.setArticleTitle("测试文章3");
        article.setArticleSummary("测试文章3的摘要");
        article.setArticleThumbnail("/static/img/article/test-test-3.jpg");
        article.setArticleContent("<h1>测试文章 333</h1>");
        article.setArticleStatus(VisibleStatus.NORMAL.getValue());

        List<Category> categoryList = new ArrayList<>();
        Category category = new Category();
        category.setCategoryId(100000025);
        categoryList.add(category);

        article.setCategoryList(categoryList);

        List<Tag> tagList = new ArrayList<>();
        Tag tag = new Tag();
        tag.setTagId(64);
        Tag tag1 = new Tag();
        tag1.setTagId(66);
        tagList.add(tag);
        tagList.add(tag1);

        article.setTagList(tagList);

        articleService.insertArticle(article);
    }

    @Test
    public void testPageArticle(){
        PageInfo<Article> pageInfo = articleService.listArticleByCreateTime(1, 5);
        pageInfo.getList().forEach(System.out::println);
    }

}