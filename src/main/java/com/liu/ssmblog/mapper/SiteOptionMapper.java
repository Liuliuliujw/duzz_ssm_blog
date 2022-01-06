package com.liu.ssmblog.mapper;

import com.liu.ssmblog.entity.SiteOption;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author: llliujw
 * @Description: site_option数据表Mapper
 */
@Mapper
public interface SiteOptionMapper {

    /**
     * 获取网站配置信息
     * @return 网站配置信息
     */
    SiteOption getSiteOption();

    /**
     * 更新网站标题
     * @param siteTitle 网站标题
     * @return 影响行数
     */
    int updateSiteTitle(String siteTitle);

    /**
     * 更新网站描述
     * @param description 网站描述
     * @return 影响行数
     */
    int updateDescription(String description);

    /**
     * 更新网站关键词
     * @param keywords 网站关键词
     * @return 影响行数
     */
    int updateKeywords(String keywords);

    /**
     * 更新网站首页URL
     * @param indexUrl 网站首页URL
     * @return 影响行数
     */
    int updateIndexUrl(String indexUrl);

    /**
     * 更新网站ICP备案号
     * @param icpNum 网站ICP备案号
     * @return 影响行数
     */
    int updateICPNum(String icpNum);
}
