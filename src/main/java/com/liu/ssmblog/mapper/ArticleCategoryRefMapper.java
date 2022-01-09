package com.liu.ssmblog.mapper;


import com.liu.ssmblog.entity.ArticleCategoryRef;
import com.liu.ssmblog.entity.Category;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: llliujw
 * @Description: article_category_ref数据表Mapper
 */
@Mapper
public interface ArticleCategoryRefMapper {

    /**
     * 添加文章和分类关联记录
     *
     * @param articleCategoryRef 关联对象
     * @return 影响行数
     */
    Integer insertArticleCategoryRef(ArticleCategoryRef articleCategoryRef);

    /**
     * 根据文章ID查询分类ID
     *
     * @param articleId 文章ID
     * @return 分类ID列表
     */
    List<Integer> listCategoryIdByArticleId(@Param(value = "articleId") Integer articleId);

    /**
     * 根据分类ID查询文章ID
     *
     * @param categoryId 分类ID
     * @return 文章ID列表
     */
    List<Integer> listArticleIdByCategoryId(@Param(value = "categoryId") Integer categoryId);

    /**
     * 根据文章ID获得分类列表
     *
     * @param articleId 文章ID
     * @return 分类列表
     */
    List<Category> listCategoryByArticleId(@Param(value = "articleId") Integer articleId);

    /**
     * 根据分类ID统计文章数
     *
     * @param categoryId 分类ID
     * @return 文章数量
     */
    Integer countArticleByCategoryId(@Param(value = "categoryId") Integer categoryId);

    /**
     * 根据分类ID删除记录
     *
     * @param categoryId 分类ID
     * @return 影响行数
     */
    Integer deleteArticleCategoryRefByCategoryId(@Param(value = "categoryId") Integer categoryId);

    /**
     * 根据文章ID删除记录
     *
     * @param articleId 文章ID
     * @return 影响行数
     */
    Integer deleteArticleCategoryRefByArticleId(@Param(value = "articleId") Integer articleId);
}