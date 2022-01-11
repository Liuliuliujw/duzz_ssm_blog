package com.liu.ssmblog.service;

import com.liu.ssmblog.entity.Category;

import java.util.List;

/**
 * @author: llliujw
 * @Description: 分类数据访问接口
 */
public interface CategoryService {

    /**
     * 添加
     *
     * @param category 分类
     * @return 是否成功
     */
    boolean insertCategory(Category category);

    /**
     * 根据分类id获得分类信息
     *
     * @param id ID
     * @return 分类
     */
    Category findCategoryById(Integer id);

    /**
     * 根据分类标签名获取分类标签
     *
     * @param name 名称
     * @return 分类
     */
    Category findCategoryByName(String name);

    /**
     * 获得分类列表
     *
     * @return 列表
     */
    List<Category> listCategory();

    /**
     * 查询分类总数
     *
     * @return 数量
     */
    Integer countCategory();

    /**
     * 更新
     *
     * @param category 分类
     * @return 是否成功
     */
    boolean updateCategory(Category category);

    /**
     * 根据分类id删除分类
     *
     * @param id 文章ID
     */
    void deleteCategoryById(Integer id);
}
