package com.liu.ssmblog.service.impl;

import com.liu.ssmblog.entity.SiteOption;
import com.liu.ssmblog.interceptor.ResourceInterceptor;
import com.liu.ssmblog.mapper.SiteOptionMapper;
import com.liu.ssmblog.service.SiteOptionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: llliujw
 * @Description: 网站页面信息相关的数据访问服务接口实现类
 */
@Service
@Slf4j
public class SiteOptionServiceImpl implements SiteOptionService {

    @Autowired
    SiteOptionMapper siteOptionMapper;

    @Override
    public SiteOption findSiteOption() {
        SiteOption siteOption = siteOptionMapper.findSiteOption();
        if(siteOption == null){
            log.error("网站信息无法正常获取");
        }
        return siteOption;
    }

    @Override
    public boolean updateSiteOption(SiteOption siteOption) {
        int integer = siteOptionMapper.updateSiteOption(siteOption);
        if (integer == 0){
            log.error("更新网站信息失败 value:{}",siteOption);
            return false;
        }
        ResourceInterceptor.clearSiteOptionCache();
        return true;
    }

}
