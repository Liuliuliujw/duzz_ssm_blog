package com.liu.ssmblog.mapper;

import com.liu.ssmblog.entity.Category;
import com.liu.ssmblog.entity.CustomPage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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
    Integer insertCustomPage(CustomPage customPage);

    /**
     * 根据页面id获得页面信息
     *
     * @param id ID
     * @return 页面
     */
    CustomPage findCustomPageById(@Param(value = "id") Integer id);

    /**
     * 根据页面url后缀获取页面
     *
     * @param pageKey 页面url后缀
     * @return 页面
     */
    CustomPage findCustomPageByPageKey(@Param(value = "pageKey") String pageKey);

    /**
     * 获取页面列表
     *
     * @return
     */
    List<CustomPage> listCustomPage();

    /**
     * 更新
     *
     * @param customPage 页面
     * @return 影响行数
     */
    Integer updateCustomPage(CustomPage customPage);

    /**
     * 删除页面
     *
     * @param id ID
     */
    Integer deleteCustomPageById(@Param(value = "id") Integer id);
}
