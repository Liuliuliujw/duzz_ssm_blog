package com.liu.ssmblog.mapper;

import com.liu.ssmblog.entity.Tag;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: llliujw
 * @Description: tag数据表Mapper
 */
@Mapper
public interface TagMapper {

    /**
     * 添加
     *
     * @param tag 标签
     * @return 影响行数
     */
    Integer insertTag(Tag tag);

    /**
     * 根据ID查询
     *
     * @param tagId 标签ID
     * @return 标签
     */
    Tag findTagById(@Param("tagId") Integer tagId);

    /**
     * 根据标签名获取标签
     *
     * @param name 名称
     * @return 标签
     */
    Tag findTagByName(@Param("name") String name);

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
     * @return 影响行数
     */
    Integer updateTag(Tag tag);

    /**
     * 根据ID删除
     *
     * @param tagId 标签ID
     * @return 影响行数
     */
    Integer deleteTagById(@Param("tagId") Integer tagId);

}