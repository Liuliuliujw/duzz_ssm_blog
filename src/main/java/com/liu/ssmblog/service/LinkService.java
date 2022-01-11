package com.liu.ssmblog.service;

import com.liu.ssmblog.entity.Link;

import java.util.List;

/**
 * @author: llliujw
 * @Description: 友链相关数据访问接口
 */
public interface LinkService {

    /**
     * 添加
     *
     * @param link 链接
     * @return 是否成功
     */
    boolean insertLink(Link link);

    /**
     * 根据ID查询
     *
     * @param linkId 链接ID
     * @return 友链
     */
    Link findLinkById(Integer linkId);

    /**
     * 获得链接列表
     *
     * @param status 状态
     * @return 友链列表
     */
    List<Link> listLink(Integer status);

    /**
     * 获得链接总数
     *
     * @param status 状态
     * @return 数量
     */
    Integer countLink(Integer status);

    /**
     * 更新
     *
     * @param link 链接ID
     * @return 是否成功
     */
    boolean updateLink(Link link);

    /**
     * 删除
     *
     * @param linkId 链接ID
     */
    void deleteLinkById(Integer linkId);
}
