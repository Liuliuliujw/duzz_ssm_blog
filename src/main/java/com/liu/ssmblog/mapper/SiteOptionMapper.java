package com.liu.ssmblog.mapper;

import com.liu.ssmblog.entity.SiteOption;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author: llliujw
 * @Description: site_option数据表Mapper
 */
@Mapper
public interface SiteOptionMapper {

    /**
     * 获取网站配置信息
     *
     * @return 网站配置信息
     */
    SiteOption findSiteOption();

    /**
     * 更新网站信息
     *
     * @param siteOption 网站信息
     * @return 影响行数
     */
    Integer updateSiteOption(SiteOption siteOption);

}
