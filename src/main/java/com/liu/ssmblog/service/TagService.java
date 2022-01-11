package com.liu.ssmblog.service;

import com.liu.ssmblog.entity.Tag;

import java.util.List;

/**
 * @author: llliujw
 * @Description: 标签数据访问服务接口
 */
public interface TagService {

    /**
     * 添加
     *
     * @param tag 标签
     * @return 是否成功
     */
    boolean insertTag(Tag tag);

    /**
     * 根据ID查询
     *
     * @param tagId 标签ID
     * @return 标签
     */
    Tag findTagById(Integer tagId);

    /**
     * 根据标签名获取标签
     *
     * @param name 名称
     * @return 标签
     */
    Tag findTagByName(String name);

    /**
     * 获得标签列表
     *
     * @return 列表
     */
    List<Tag> listTag();

    /**
     * 获得标签总数
     *
     * @return 数量
     */
    Integer countTag();

    /**
     * 更新
     *
     * @param tag 标签
     * @return 是否成功
     */
    boolean updateTag(Tag tag);

    /**
     * 根据ID删除
     *
     * @param tagId 标签ID
     */
    void deleteTagById(Integer tagId);
}
