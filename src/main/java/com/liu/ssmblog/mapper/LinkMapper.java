package com.liu.ssmblog.mapper;

import com.liu.ssmblog.entity.Link;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: llliujw
 * @Description: link数据表Mapper
 */
@Mapper
public interface LinkMapper {

    /**
     * 添加
     *
     * @param link 链接
     * @return 影响行数
     */
    Integer insertLink(Link link);

    /**
     * 根据ID查询
     *
     * @param linkId 链接ID
     * @return 影响行数
     */
    Link findLinkById(@Param("linkId") Integer linkId);

    /**
     * 获得链接列表
     *
     * @param status 状态
     * @return 列表
     */
    List<Link> listLink(@Param("status") Integer status);

    /**
     * 获得链接总数
     *
     * @param status 状态
     * @return 数量
     */
    Integer countLink(@Param("status") Integer status);

    /**
     * 更新
     *
     * @param link 链接ID
     * @return 影响行数
     */
    Integer updateLink(Link link);

    /**
     * 删除
     *
     * @param linkId 链接ID
     * @return 影响行数
     */
    Integer deleteLinkById(@Param("linkId") Integer linkId);
}