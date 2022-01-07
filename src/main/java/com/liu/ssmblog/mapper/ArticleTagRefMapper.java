package com.liu.ssmblog.mapper;


import com.liu.ssmblog.entity.ArticleTagRef;
import com.liu.ssmblog.entity.Tag;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: llliujw
 * @Description: article_tag_ref数据表Mapper
 */
@Mapper
public interface ArticleTagRefMapper {

    /**
     * 添加文章和标签关联记录
     *
     * @param articleTagRef 关联对象
     * @return 影响行数
     */
    Integer insertArticleTagRefMapper(ArticleTagRef articleTagRef);

    /**
     * 根据文章获得标签列表
     *
     * @param articleId 文章ID
     * @return 标签列表
     */
    List<Tag> listTagByArticleId(@Param(value = "articleId") Integer articleId);

    /**
     * 根据标签ID统计文章数
     *
     * @param tagId 标签ID
     * @return 文章数量
     */
    Integer countArticleByTagId(@Param(value = "tagId") Integer tagId);

    /**
     * 根据标签ID删除记录
     *
     * @param tagId 标签ID
     * @return 影响行数
     */
    Integer deleteArticleTagRefByTagId(@Param(value = "tagId") Integer tagId);

    /**
     * 根据文章ID删除记录
     *
     * @param articleId 文章ID
     * @return 影响行数
     */
    Integer deleteArticleTagRefByArticleId(@Param(value = "articleId") Integer articleId);
}