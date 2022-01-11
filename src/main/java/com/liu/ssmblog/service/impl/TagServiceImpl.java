package com.liu.ssmblog.service.impl;

import com.liu.ssmblog.entity.Tag;
import com.liu.ssmblog.mapper.TagMapper;
import com.liu.ssmblog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: llliujw
 * @Description: 标签数据访问服务接口
 */
@Service
public class TagServiceImpl implements TagService {

    @Autowired
    TagMapper tagMapper;

    @Override
    public boolean insertTag(Tag tag) {
        return tagMapper.insertTag(tag) == 1;
    }

    @Override
    public Tag findTagById(Integer tagId) {
        return tagMapper.findTagById(tagId);
    }

    @Override
    public Tag findTagByName(String name) {
        return tagMapper.findTagByName(name);
    }

    @Override
    public List<Tag> listTag() {
        return tagMapper.listTag();
    }

    @Override
    public Integer countTag() {
        return tagMapper.countTag();
    }

    @Override
    public boolean updateTag(Tag tag) {
        return tagMapper.updateTag(tag) == 1;
    }

    @Override
    public void deleteTagById(Integer tagId) {
        tagMapper.deleteTagById(tagId);
    }
}
