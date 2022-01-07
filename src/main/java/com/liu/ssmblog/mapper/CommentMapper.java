package com.liu.ssmblog.mapper;

import com.liu.ssmblog.entity.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

/**
 * @author: llliujw
 * @Description: comment数据表Mapper
 */
@Mapper
public interface CommentMapper {

    /**
     * 添加
     *
     * @param comment 评论
     * @return 影响行数
     */
    int insertComment(Comment comment);

    /**
     * 根据ID查询
     *
     * @param commentId 评论ID
     * @return 评论
     */
    Comment findCommentById(@Param(value = "commentId") Integer commentId);

    /**
     * 根据文章id获取评论列表
     *
     * @param articleId ID
     * @return 列表
     */
    List<Comment> listCommentByArticleId(@Param(value = "articleId") Integer articleId);

    /**
     * 更新
     *
     * @param comment 评论
     * @return 影响行数
     */
    int updateComment(Comment comment);

    /**
     * 根据ID删除
     *
     * @param commentId 评论ID
     * @return 影响行数
     */
    int deleteCommentById(@Param(value = "commentId") Integer commentId);

    /**
     * 根据用户ID删除
     *
     * @param userId 用户ID
     * @return 影响行数
     */
    Integer deleteCommentByUserId(@Param(value = "userId") Integer userId);

    /**
     * 根据文章ID删除
     *
     * @param articleId 文章ID
     * @return 影响行数
     */
    Integer deleteCommentByArticleId(@Param(value = "articleId") Integer articleId);
}