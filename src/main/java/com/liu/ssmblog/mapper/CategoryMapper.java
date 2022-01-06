package com.liu.ssmblog.mapper;

import com.liu.ssmblog.entity.Category;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


import java.util.List;

/**
 *  @author: llliujw
 *  @Description: category数据表Mapper
 */
@Mapper
public interface CategoryMapper {

    /**
     * 添加
     *
     * @param category 分类
     * @return 影响行数
     */
    int insert(Category category);

    /**
     * 更新
     *
     * @param category 分类
     * @return 影响行数
     */
    int update(Category category);

    /**
     * 根据分类id获得分类信息
     *
     * @param id ID
     * @return 分类
     */
    Category getCategoryById(Integer id);

    /**
     * 删除分类
     *
     * @param id 文章ID
     */
    int deleteCategory(Integer id);

    /**
     * 查询分类总数
     *
     * @return 数量
     */
    Integer countCategory();

    /**
     * 获得分类列表
     *
     * @return 列表
     */
    List<Category> listCategory();

    /**
     * 根据分类标签名获取分类标签
     *
     * @param name 名称
     * @return 分类
     */
    Category getCategoryByName(String name);
}