package com.liu.ssmblog.service;

import com.github.pagehelper.PageInfo;
import com.liu.ssmblog.entity.Article;

import java.util.List;

/**
 * @author: llliujw
 * @Description: 文章相关的数据访问服务接口
 */
public interface ArticleService {

    /**
     * 添加文章
     *
     * @param article 文章
     * @return 是否成功
     */
    boolean insertArticle(Article article);

    /**
     * 按访问量排序获得文章
     *
     * @param pageIndex 页码
     * @param pageSize  页大小
     * @return 文章页信息
     */
    PageInfo<Article> listArticleByViewCount(int pageIndex, int pageSize);

    /**
     * 按评论量排序获得文章
     *
     * @param pageIndex 页码
     * @param pageSize  页大小
     * @return 文章页信息
     */
    PageInfo<Article> listArticleByCommentCount(int pageIndex, int pageSize);

    /**
     * 按创建时间排序获得文章
     *
     * @param pageIndex 页码
     * @param pageSize  页大小
     * @return 文章页信息
     */
    PageInfo<Article> listArticleByCreateTime(int pageIndex, int pageSize);

    /**
     * 根据分类ID
     *
     * @param categoryId 分类ID
     * @param pageIndex  页码
     * @param pageSize   页大小
     * @return 文章页信息
     */
    PageInfo<Article> listArticleByCategoryId(int pageIndex, int pageSize, int categoryId);

    /**
     * 根据分类ID
     *
     * @param categoryIds 分类ID集合
     * @param pageIndex   页码
     * @param pageSize    页大小
     * @return 文章页信息
     */
    PageInfo<Article> listArticleByCategoryIds(int pageIndex, int pageSize, List<Integer> categoryIds);

    /**
     * 获得一个用户的文章集合
     *
     * @param userId    用户ID
     * @param pageIndex 页码
     * @param pageSize  页大小
     * @return 文章页信息
     */
    PageInfo<Article> listArticleByUserId(int pageIndex, int pageSize, int userId);

    /**
     * 获取文章总数
     *
     * @param status 状态
     * @return 数量
     */
    Integer countArticle(Integer status);

    /**
     * 用户的文章数
     *
     * @param id 用户ID
     * @return 数量
     */
    Integer countArticleByUser(Integer id);

    /**
     * 更新文章
     *
     * @param article 文章
     * @return 是否成功
     */
    boolean updateArticle(Article article);

    /**
     * 更新文章的详细信息
     *
     * @param article 文章
     * @return 是否成功
     */
    boolean updateArticleDetail(Article article);

    /**
     * 根据文章ID删除
     *
     * @param articleId 文章ID
     */
    void deleteArticleById(Integer articleId);

    /**
     * 根据用户ID删除
     *
     * @param userId 用户ID
     */
    void deleteArticleByUserId(Integer userId);

    /**
     * 根据文章ID集合批量删除文章
     *
     * @param ids 文章Id列表
     */
    void deleteArticleBatchByIds(List<Integer> ids);
}
