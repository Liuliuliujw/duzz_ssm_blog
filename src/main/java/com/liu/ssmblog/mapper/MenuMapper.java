package com.liu.ssmblog.mapper;

import com.liu.ssmblog.entity.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: llliujw
 * @Description: menu数据表Mapper
 */
@Mapper
public interface MenuMapper {

    /**
     * 添加
     *
     * @param menu 菜单
     * @return 影响行数
     */
    Integer insertMenu(Menu menu);

    /**
     * 根据ID查询
     *
     * @param menuId 菜单ID
     * @return 菜单
     */
    Menu findMenuById(@Param("menuId") Integer menuId);

    /**
     * 获得菜单列表
     *
     * @return 列表
     */
    List<Menu> listMenu();

    /**
     * 更新
     *
     * @param menu 菜单
     * @return 影响行数
     */
    Integer updateMenu(Menu menu);

    /**
     * 删除
     *
     * @param menuId 菜单ID
     * @return 影响行数
     */
    Integer deleteMenuById(@Param("menuId") Integer menuId);
}