package com.liu.ssmblog.service.impl;

import com.liu.ssmblog.entity.Menu;
import com.liu.ssmblog.interceptor.ResourceInterceptor;
import com.liu.ssmblog.mapper.MenuMapper;
import com.liu.ssmblog.service.MenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author: llliujw
 * @Description: 菜单相关的数据访问服务接口实现类
 */
@Service
@Slf4j
public class MenuServiceImpl implements MenuService {

    @Autowired
    MenuMapper menuMapper;

    @Override
    public boolean insertMenu(Menu menu) {
        int integer = menuMapper.insertMenu(menu);
        if (integer == 0){
            return false;
        }
        ResourceInterceptor.clearMenuCache();
        return true;
    }

    @Override
    public List<Menu> findMenuTree() {
        List<Menu> list = menuMapper.listMenu();
        Map<Integer, Menu> nodeMap = list.stream().collect(Collectors.toMap(Menu::getMenuId, node -> node));
        List<Menu> listTree = list.stream().filter(node -> {
            //父节点id为空时，根节点
            if (node.getMenuPid() == 0) {
                return true;
            }
            Menu parentNode = nodeMap.get(node.getMenuPid());
            if (parentNode != null) {
                List<Menu> childNodes = parentNode.getChildrenMenus();
                if (Objects.isNull(childNodes)) {
                    childNodes = new ArrayList<>();
                    parentNode.setChildrenMenus(childNodes);
                }
                childNodes.add(node);
                return false;
            }
            return true;
        }).collect(Collectors.toList());
        return listTree;
    }

    @Override
    public boolean updateMenu(Menu menu) {
        int integer = menuMapper.updateMenu(menu);
        if (integer == 0){
            return false;
        }
        ResourceInterceptor.clearMenuCache();
        return true;
    }

    @Override
    public boolean deleteMenuById(Integer id) {
        int integer = menuMapper.deleteMenuById(id);
        if (integer == 0){
            return false;
        }
        ResourceInterceptor.clearMenuCache();
        return true;
    }
}
