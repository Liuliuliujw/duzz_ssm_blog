package com.liu.ssmblog.mapper;

import com.liu.ssmblog.entity.Article;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

/**
 * @author: llliujw
 * @Description: article数据表Mapper
 */
@Mapper
public interface ArticleMapper {

    /**
     * 添加文章
     *
     * @param article 文章
     * @return 文章
     */
    Integer insertArticle(Article article);

    /**
     * 根据状态和ID获取文章
     *
     * @param status 状态
     * @param id     文章ID
     * @return 文章
     */
    Article findArticleByStatusAndId(@Param(value = "status") Integer status,
                                     @Param(value = "id") Integer id);

    /**
     * 获得指定条件的所有的文章
     *
     * @param criteria 查询条件
     * @return 文章列表
     */
    List<Article> listArticleByCriteria(HashMap<String, Object> criteria);

    /**
     * 按访问量排序获得文章
     *
     * @return 文章列表
     */
    List<Article> listArticleByViewCount();

    /**
     * 按评论量排序获得文章
     *
     * @return 文章列表
     */
    List<Article> listArticleByCommentCount();

    /**
     * 按创建时间排序获得文章
     *
     * @return 列表
     */
    List<Article> listArticleByCreateTime();

    /**
     * 根据分类ID
     *
     * @param categoryId 分类ID
     * @return 文章列表
     */
    List<Article> listArticleByCategoryId(@Param(value = "categoryId") Integer categoryId);

    /**
     * 根据分类ID
     *
     * @param categoryIds 分类ID集合
     * @return 文章列表
     */
    List<Article> listArticleByCategoryIds(@Param(value = "categoryIds") List<Integer> categoryIds);

    /**
     * 获得一个用户的文章集合
     *
     * @param userId 用户ID
     * @return 文章集合
     */
    List<Article> listArticleByUserId(@Param(value = "userId") Integer userId);

    /**
     * 获得一个用户的文章id集合
     *
     * @param userId 用户ID
     * @return 文章id集合
     */
    List<Integer> listArticleIdsByUserId(@Param(value = "userId") Integer userId);

    /**
     * 获取文章总数
     *
     * @param status 状态
     * @return 数量
     */
    Integer countArticle(@Param(value = "status") Integer status);

    /**
     * 用户的文章数
     *
     * @param id 用户ID
     * @return 数量
     */
    Integer countArticleByUser(@Param(value = "id") Integer id);

    /**
     * 更新文章
     *
     * @param article 文章
     * @return 影响行数
     */
    Integer updateArticle(Article article);

    /**
     * 更新文章的评论数
     *
     * @param articleId 文章ID
     */
    Integer updateCommentCount(@Param(value = "articleId") Integer articleId);

    /**
     * 根据ID删除
     *
     * @param articleId 文章ID
     * @return 影响行数
     */
    Integer deleteArticleById(@Param(value = "articleId") Integer articleId);

    /**
     * 根据用户ID删除
     *
     * @param userId 用户ID
     * @return 影响行数
     */
    Integer deleteArticleByUserId(@Param(value = "userId") Integer userId);

    /**
     * 批量删除文章
     *
     * @param ids 文章Id列表
     * @return 影响行数
     */
    Integer deleteArticleBatchByIds(@Param(value = "ids") List<Integer> ids);
}