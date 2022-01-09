package com.liu.ssmblog.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liu.ssmblog.entity.*;
import com.liu.ssmblog.mapper.*;
import com.liu.ssmblog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author: llliujw
 * @Description: 文章相关的数据访问服务接口实现类
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    @Autowired
    private ArticleCategoryRefMapper articleCategoryRefMapper;

    @Autowired
    private ArticleTagRefMapper articleTagRefMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private CommentMapper commentMapper;

    @Override
    public boolean insertArticle(Article article) {
        Date now = new Date();
        article.setArticleCreateTime(now);
        article.setArticleUpdateTime(now);
        article.setArticleViewCount(0);
        article.setArticleLikeCount(0);
        article.setArticleCommentCount(0);
        if(articleMapper.insertArticle(article) != 1)return false;
        //添加分类和文章关联
        Optional.ofNullable(article.getCategoryList()).ifPresent( categoryList -> categoryList.forEach( category -> {
            ArticleCategoryRef articleCategoryRef = new ArticleCategoryRef();
            articleCategoryRef.setArticleId(article.getArticleId());
            articleCategoryRef.setCategoryId(category.getCategoryId());
            articleCategoryRefMapper.insertArticleCategoryRef(articleCategoryRef);
        }));
        //添加标签和文章关联
        Optional.ofNullable(article.getTagList()).ifPresent(tags -> tags.forEach(tag -> {
            ArticleTagRef articleTagRef = new ArticleTagRef();
            articleTagRef.setArticleId(article.getArticleId());
            articleTagRef.setTagId(tag.getTagId());
            articleTagRefMapper.insertArticleTagRefMapper(articleTagRef);
        }));

        return true;
    }

    @Override
    public PageInfo<Article> listArticleByViewCount(int pageIndex, int pageSize) {
        return listArticleByPage(pageIndex, pageSize, articleMapper::listArticleByViewCount);
    }

    @Override
    public PageInfo<Article> listArticleByCommentCount(int pageIndex, int pageSize) {
        return listArticleByPage(pageIndex, pageSize, articleMapper::listArticleByCommentCount);
    }

    @Override
    public PageInfo<Article> listArticleByCreateTime(int pageIndex, int pageSize) {
        return listArticleByPage(pageIndex, pageSize, articleMapper::listArticleByCreateTime);
    }

    @Override
    public PageInfo<Article> listArticleByCategoryId(int pageIndex, int pageSize, int categoryId) {
        return listArticleByPage(pageIndex, pageSize, articleMapper::listArticleByCategoryId, categoryId);
    }

    @Override
    public PageInfo<Article> listArticleByCategoryIds(int pageIndex, int pageSize, List<Integer> categoryIds) {
        return listArticleByPage(pageIndex, pageSize, articleMapper::listArticleByCategoryIds, categoryIds);
    }

    @Override
    public PageInfo<Article> listArticleByUserId(int pageIndex, int pageSize, int userId) {
        return listArticleByPage(pageIndex, pageSize, articleMapper::listArticleByUserId, userId);
    }

    @Override
    public Integer countArticle(Integer status) {
        return articleMapper.countArticle(status);
    }

    @Override
    public Integer countArticleByUser(Integer id) {
        return articleMapper.countArticleByUser(id);
    }

    @Override
    public boolean updateArticle(Article article) {
        article.setArticleUpdateTime(new Date());
        return articleMapper.updateArticle(article) == 1;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateArticleDetail(Article article) {
        article.setArticleUpdateTime(new Date());
        if (article.getTagList() != null) {
            //删除标签和文章关联
            articleTagRefMapper.deleteArticleTagRefByArticleId(article.getArticleId());
            //添加标签和文章关联
            for (Tag tag : article.getTagList()) {
                ArticleTagRef articleTagRef = new ArticleTagRef();
                articleTagRef.setTagId(tag.getTagId());
                articleTagRef.setArticleId(article.getArticleId());
                articleTagRefMapper.insertArticleTagRefMapper(articleTagRef);
            }
        }
        if (article.getCategoryList() != null) {
            //删除分类和文章关联
            articleCategoryRefMapper.deleteArticleCategoryRefByArticleId(article.getArticleId());
            //添加分类和文章关联
            for (Category category : article.getCategoryList()) {
                ArticleCategoryRef articleCategoryRef = new ArticleCategoryRef();
                articleCategoryRef.setCategoryId(category.getCategoryId());
                articleCategoryRef.setArticleId(article.getArticleId());
                articleCategoryRefMapper.insertArticleCategoryRef(articleCategoryRef);
            }
        }
        return articleMapper.updateArticle(article) == 1;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteArticleById(Integer articleId) {
        articleMapper.deleteArticleById(articleId);
        articleCategoryRefMapper.deleteArticleCategoryRefByArticleId(articleId);
        articleTagRefMapper.deleteArticleTagRefByArticleId(articleId);
        commentMapper.deleteCommentByArticleId(articleId);
    }

    @Override
    public void deleteArticleByUserId(Integer userId) {
        articleMapper.deleteArticleByUserId(userId);
        //Optional 防止空指针异常 等价于 if(articleMapper.listArticleIdsByUserId(userId)) != null)
        Optional.ofNullable(articleMapper.listArticleIdsByUserId(userId)).ifPresent( articleIds -> articleIds.forEach(articleId -> {
            articleCategoryRefMapper.deleteArticleCategoryRefByArticleId(articleId);
            articleTagRefMapper.deleteArticleTagRefByArticleId(articleId);
            commentMapper.deleteCommentByArticleId(articleId);
        }));

    }

    @Override
    public void deleteArticleBatchByIds(List<Integer> ids) {
        articleMapper.deleteArticleBatchByIds(ids);
        ids.forEach( id -> {
            articleCategoryRefMapper.deleteArticleCategoryRefByArticleId(id);
            articleTagRefMapper.deleteArticleTagRefByArticleId(id);
            commentMapper.deleteCommentByArticleId(id);
        });
    }

    /**
     * 无参方法执行分页
     *
     * @param pageIndex 页码
     * @param pageSize 页大小
     * @param selector 要执行的方法
     * @return 分页信息
     */
    private PageInfo<Article> listArticleByPage(int pageIndex, int pageSize, Supplier<List<Article>> selector){
        PageHelper.startPage(pageIndex, pageSize);
        List<Article> articles = selector.get();
        appendArticleInfo(articles);
        return new PageInfo<>(articles);
    }

    /**
     * 单参方法执行分页
     * @param pageIndex 页码
     * @param pageSize 页大小
     * @param selector 要执行的方法
     * @return 分页信息
     */
    private <T> PageInfo<Article> listArticleByPage(int pageIndex, int pageSize, Function<T, List<Article>> selector, T param){
        PageHelper.startPage(pageIndex, pageSize);
        List<Article> articles = selector.apply(param);
        appendArticleInfo(articles);
        return new PageInfo<>(articles);
    }

    /**
     * 向article中追加非数据库属性
     *
     * @param articles 文章实体类的集合
     */
    private void appendArticleInfo(List<Article> articles){
        for (Article article : articles) {
            //封装文章的作者信息
            article.setOwner(userMapper.findUserById(article.getArticleUserId()));
            //封装CategoryList
            List<Category> categoryList = articleCategoryRefMapper.listCategoryByArticleId(article.getArticleId());
            article.setCategoryList(categoryList);
            //封装TagList
            List<Tag> tagList = articleTagRefMapper.listTagByArticleId(article.getArticleId());
            article.setTagList(tagList);
        }
    }
}
