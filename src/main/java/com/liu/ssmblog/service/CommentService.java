package com.liu.ssmblog.service;

import com.liu.ssmblog.entity.Comment;

/**
 * @author: llliujw
 * @Description: 评论数据访问接口
 */
public interface CommentService {

    /**
     * 添加
     *
     * @param comment 评论
     * @return 是否成功
     */
    boolean insertComment(Comment comment);

    /**
     * 根据ID查询
     *
     * @param commentId 评论ID
     * @return 评论
     */
    Comment findCommentById(Integer commentId);

    /**
     * 更新
     *
     * @param comment 评论
     * @return 是否成功
     */
    boolean updateComment(Comment comment);

    /**
     * 根据ID删除
     *
     * @param commentId 评论ID
     */
    void deleteCommentById(Integer commentId);
}
