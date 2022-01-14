package com.liu.ssmblog.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liu.ssmblog.entity.User;
import com.liu.ssmblog.mapper.CommentMapper;
import com.liu.ssmblog.mapper.UserMapper;
import com.liu.ssmblog.service.ArticleService;
import com.liu.ssmblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author: llliujw
 * @Description: 用户数据访问服务接口实现类
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    CommentMapper commentMapper;

    @Autowired
    ArticleService articleService;

    @Override
    public boolean insertUser(User user) {
        return userMapper.insertUser(user) == 1;
    }

    @Override
    public User findUserById(Integer userId) {
        return userMapper.findUserById(userId);
    }

    @Override
    public User findUserByName(String name) {
        return userMapper.findUserByName(name);
    }

    @Override
    public User findUserByEmail(String email) {
        return userMapper.findUserByEmail(email);
    }

    @Override
    public PageInfo<User> listUser(int pageIndex, int pageSize) {
        PageHelper.startPage(pageIndex, pageSize);
        return new PageInfo<>(userMapper.listUser());
    }

    @Override
    public boolean updateUser(User user) {
        return userMapper.updateUser(user) == 1;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteUserById(Integer userId) {
        //删除评论
        commentMapper.deleteCommentByUserId(userId);
        //删除文章
        articleService.deleteArticleByUserId(userId);
        //删除用户
        userMapper.deleteUserById(userId);
    }
}
