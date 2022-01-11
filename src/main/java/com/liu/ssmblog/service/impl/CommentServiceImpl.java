package com.liu.ssmblog.service.impl;

import com.liu.ssmblog.entity.Comment;
import com.liu.ssmblog.mapper.CommentMapper;
import com.liu.ssmblog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: llliujw
 * @Description: 分类数据访问服务接口实现类
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentMapper commentMapper;

    @Override
    public boolean insertComment(Comment comment) {
        return commentMapper.insertComment(comment) == 1;
    }

    @Override
    public Comment findCommentById(Integer commentId) {
        return commentMapper.findCommentById(commentId);
    }

    @Override
    public boolean updateComment(Comment comment) {
        return commentMapper.updateComment(comment) == 1;
    }

    @Override
    public void deleteCommentById(Integer commentId) {
        commentMapper.deleteCommentById(commentId);
    }
}
