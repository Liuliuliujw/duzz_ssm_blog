package com.liu.ssmblog.service.impl;

import com.liu.ssmblog.entity.Link;
import com.liu.ssmblog.mapper.LinkMapper;
import com.liu.ssmblog.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: llliujw
 * @Description: 友链相关数据访问接口实现类
 */
@Service
public class LinkServiceImpl implements LinkService {

    @Autowired
    LinkMapper linkMapper;

    @Override
    public boolean insertLink(Link link) {
        return linkMapper.insertLink(link) == 1;
    }

    @Override
    public Link findLinkById(Integer linkId) {
        return linkMapper.findLinkById(linkId);
    }

    @Override
    public List<Link> listLink(Integer status) {
        return linkMapper.listLink(status);
    }

    @Override
    public Integer countLink(Integer status) {
        return linkMapper.countLink(status);
    }

    @Override
    public boolean updateLink(Link link) {
        return linkMapper.updateLink(link) == 1;
    }

    @Override
    public void deleteLinkById(Integer linkId) {
        linkMapper.deleteLinkById(linkId);
    }
}
