package com.liu.ssmblog.service;

import com.liu.ssmblog.entity.Menu;

import java.util.List;

/**
 * @author: llliujw
 * @Description: 菜单相关的数据访问服务接口
 */
public interface MenuService {

    /**
     * 插入菜单
     * @param menu 菜单
     * @return 是否成功
     */
    boolean insertMenu(Menu menu);

    /**
     * 获取菜单树
     * @return 菜单树
     */
    List<Menu> findMenuTree();

    /**
     * 更新菜单
     * @param menu 菜单
     * @return 是否成功
     */
    boolean updateMenu(Menu menu);

    /**
     * 根据菜单ID删除菜单
     * @param id 菜单ID
     * @return 是否成功
     */
    boolean deleteMenuById(Integer id);
}
