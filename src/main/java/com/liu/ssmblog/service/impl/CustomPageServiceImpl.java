package com.liu.ssmblog.service.impl;

import com.liu.ssmblog.entity.CustomPage;
import com.liu.ssmblog.mapper.CustomPageMapper;
import com.liu.ssmblog.service.CustomPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: llliujw
 * @Description: 自定义页数据访问服务接口实现类
 */
@Service
public class CustomPageServiceImpl implements CustomPageService {

    @Autowired
    CustomPageMapper customPageMapper;

    @Override
    public boolean insertCustomPage(CustomPage customPage) {
        return customPageMapper.insertCustomPage(customPage) == 1;
    }

    @Override
    public CustomPage findCustomPageById(Integer id) {
        return customPageMapper.findCustomPageById(id);
    }

    @Override
    public CustomPage findCustomPageByPageKey(String pageKey) {
        return customPageMapper.findCustomPageByPageKey(pageKey);
    }

    @Override
    public List<CustomPage> listCustomPage() {
        return customPageMapper.listCustomPage();
    }

    @Override
    public boolean updateCustomPage(CustomPage customPage) {
        return customPageMapper.updateCustomPage(customPage) == 1;
    }

    @Override
    public void deleteCustomPageById(Integer id) {
        customPageMapper.deleteCustomPageById(id);
    }
}
