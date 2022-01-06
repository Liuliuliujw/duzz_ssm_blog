package com.liu.ssmblog.mapper;

import com.liu.ssmblog.entity.Category;
import com.liu.ssmblog.entity.CustomPage;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author: llliujw
 * @Description: custom_page数据表Mapper
 */
@Mapper
public interface CustomPageMapper {

    /**
     * 添加
     *
     * @param customPage 页面
     * @return 影响行数
     */
    int insert(CustomPage customPage);

    /**
     * 更新
     *
     * @param customPage 页面
     * @return 影响行数
     */
    int update(CustomPage customPage);

    /**
     * 根据页面id获得页面信息
     *
     * @param id ID
     * @return 页面
     */
    CustomPage getCustomPageById(Integer id);

    /**
     * 删除页面
     *
     * @param id ID
     */
    int deleteCustomPage(Integer id);

    /**
     * 根据页面url后缀获取页面
     *
     * @param pageKey 页面url后缀
     * @return 页面
     */
    CustomPage getCustomPageByPageKey(String pageKey);
}
