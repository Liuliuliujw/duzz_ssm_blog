package com.liu.ssmblog.service;

import com.liu.ssmblog.entity.CustomPage;

import java.util.List;

/**
 * @author: llliujw
 * @Description: 自定义页数据访问服务接口
 */
public interface CustomPageService {

    /**
     * 添加
     *
     * @param customPage 页面
     * @return 是否成功
     */
    boolean insertCustomPage(CustomPage customPage);

    /**
     * 根据页面id获得页面信息
     *
     * @param id ID
     * @return 页面
     */
    CustomPage findCustomPageById(Integer id);

    /**
     * 根据页面url后缀获取页面
     *
     * @param pageKey 页面url后缀
     * @return 页面
     */
    CustomPage findCustomPageByPageKey(String pageKey);

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
     * @return 是否成功
     */
    boolean updateCustomPage(CustomPage customPage);

    /**
     * 删除页面
     *
     * @param id ID
     */
    void deleteCustomPageById(Integer id);
}
