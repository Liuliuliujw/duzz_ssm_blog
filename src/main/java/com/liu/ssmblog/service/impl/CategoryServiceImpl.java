package com.liu.ssmblog.service.impl;

import com.liu.ssmblog.entity.Category;
import com.liu.ssmblog.mapper.CategoryMapper;
import com.liu.ssmblog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: llliujw
 * @Description: 分类数据访问接口实现类
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public boolean insertCategory(Category category) {
        return categoryMapper.insertCategory(category) == 1;
    }

    @Override
    public Category findCategoryById(Integer id) {
        return categoryMapper.findCategoryById(id);
    }

    @Override
    public Category findCategoryByName(String name) {
        return categoryMapper.findCategoryByName(name);
    }

    @Override
    public List<Category> listCategory() {
        return categoryMapper.listCategory();
    }

    @Override
    public Integer countCategory() {
        return categoryMapper.countCategory();
    }

    @Override
    public boolean updateCategory(Category category) {
        return categoryMapper.updateCategory(category) == 1;
    }

    @Override
    public void deleteCategoryById(Integer id) {
        categoryMapper.deleteCategoryById(id);
    }
}
