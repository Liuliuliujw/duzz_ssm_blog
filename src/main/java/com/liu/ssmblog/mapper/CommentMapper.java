package com.liu.ssmblog.mapper;

import com.liu.ssmblog.entity.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

/**
 *  @author: llliujw
 *  @Description: comment数据表Mapper
 */
@Mapper
public interface CommentMapper {

    /**
     * 根据ID删除
     *
     * @param commentId 评论ID
     * @return 影响行数
     */
    int deleteById(Integer commentId);

    /**
     * 添加
     *
     * @param comment 评论
     * @return 影响行数
     */
    int insert(Comment comment);

    /**
     * 根据ID查询
     *
     * @param commentId 评论ID
     * @return 评论
     */
    Comment getCommentById(Integer commentId);

    /**
     * 更新
     *
     * @param comment 评论
     * @return 影响行数
     */
    int update(Comment comment);

    /**
     * 根据文章id获取评论列表
     *
     * @param id ID
     * @return 列表
     */
    List<Comment> listCommentByArticleId(Integer id);

    /**
     * 获得评论列表
     *
     * @return 列表
     */
    List<Comment> listComment(HashMap<String, Object> criteria);

    /**
     * 统计评论数
     *
     * @return 数量
     */
    Integer countComment();

    /**
     * 获得评论的子评论
     *
     * @param id 评论ID
     * @return 列表
     */
    List<Comment> listChildComment(@Param(value = "id") Integer id);

    /**
     * 根据用户ID删除
     *
     * @param userId 用户ID
     * @return 影响行数
     */
    Integer deleteByUserId(Integer userId);

    /**
     * 根据文章ID删除
     *
     * @param articleId 文章ID
     * @return 影响行数
     */
    Integer deleteByArticleId(Integer articleId);
}