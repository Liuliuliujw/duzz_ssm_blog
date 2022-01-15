package com.liu.ssmblog.service;

import com.github.pagehelper.PageInfo;
import com.liu.ssmblog.entity.User;
import com.liu.ssmblog.exception.ExistException;

/**
 * @author: llliujw
 * @Description: 用户数据访问服务接口
 */
public interface UserService {

    /**
     * 添加
     *
     * @param user 用户
     * @return 是否成功
     */
    boolean insertUser(User user) throws ExistException;

    /**
     * 根据ID查询
     *
     * @param userId 用户ID
     * @return 用户
     */
    User findUserById(Integer userId);

    /**
     * 根据用户名查用户
     *
     * @param name 用户名
     * @return 用户
     */
    User findUserByName(String name);

    /**
     * 根据Email查询用户
     *
     * @param email 邮箱
     * @return 用户
     */
    User findUserByEmail(String email);

    /**
     * 获得用户列表
     *
     * @param pageIndex 页码
     * @param pageSize 页大小
     * @return 用户数据页
     */
    PageInfo<User> listUser(int pageIndex, int pageSize);

    /**
     * 更新
     *
     * @param user 用户
     * @return 是否成功
     */
    boolean updateUser(User user);

    /**
     * 根据ID删除
     *
     * @param userId 用户ID
     */
    void deleteUserById(Integer userId);
}
