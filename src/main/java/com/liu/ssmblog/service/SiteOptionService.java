package com.liu.ssmblog.service;

import com.liu.ssmblog.entity.SiteOption;

/**
 * @author: llliujw
 * @Description: 网站页面信息相关的数据访问服务接口
 */
public interface SiteOptionService {

    /**
     * 获取网站信息
     *
     * @return 网站信息
     */
    SiteOption findSiteOption();

    /**
     * 更新网站标题
     *
     * @param siteOption 标题
     * @return 是否更新成功
     */
    boolean updateSiteOption(SiteOption siteOption);
}
