package com.liu.ssmblog.mapper;

import com.liu.ssmblog.entity.CustomPage;
import com.liu.ssmblog.entity.Link;
import com.liu.ssmblog.entity.Menu;
import com.liu.ssmblog.entity.SiteOption;
import com.liu.ssmblog.enums.AvailableStatus;
import com.liu.ssmblog.enums.MenuTypes;
import com.liu.ssmblog.enums.VisibleStatus;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.engine.IterationStatusVar;

import java.util.Date;
import java.util.Optional;

/**
 * @author: llliujw
 * @Description: 测试数据访问层的部分方法
 */
@RunWith(SpringRunner.class)
@ContextConfiguration("/spring-mybatis.xml")
public class MapperTest2 {

    @Autowired
    CustomPageMapper customPageMapper;

    @Autowired
    LinkMapper linkMapper;

    @Autowired
    MenuMapper menuMapper;

    @Autowired
    SiteOptionMapper siteOptionMapper;

    Long now = new Date().getTime();

    @Test
    public void testAllInsert(){
        testInsertCustomPage();
        testInsertLink();
        testInsertMenu();
    }

    @Test
    public void testDeleteByAllInsert(){
        //删除插入的友链测试数据
        linkMapper.listLink(AvailableStatus.ENABLE.getValue()).stream()
                .filter(link -> link.getLinkDescription().equals("友链测试"))
                .forEach(link -> linkMapper.deleteLinkById(link.getLinkId()));

        //获取插入的自定义页面测试数据和菜单测试数据
        customPageMapper.listCustomPage().stream()
                .filter( customPage -> customPage.getPageKey().equals("/test456/key/1"))
                .forEach(customPage -> {
                    customPageMapper.deleteCustomPageById(customPage.getPageId());
                    menuMapper.listMenu().stream().filter(menu -> menu.getMenuUrl().equals(customPage.getPageKey()))
                            .forEach(menu -> menuMapper.deleteMenuById(menu.getMenuId()));
                });
    }

    @Test
    public void testReadAndUpdateSiteOption(){
        SiteOption siteOption = siteOptionMapper.findSiteOption();
        System.out.println(siteOption);
        siteOptionMapper.updateKeywords("暂时测试一下");
        siteOptionMapper.updateKeywords(siteOption.getSiteKeywords());
    }

    void testInsertCustomPage(){
        CustomPage customPage = new CustomPage();
        customPage.setPageKey("/test456/key/1");
        customPage.setPageTitle("测试页面");
        customPage.setPageContent("<h2>测试页面测试测试</h2>");
        customPage.setPageUpdateTime(new Date(now));
        customPage.setPageCreateTime(new Date(now));
        customPage.setPageStatus(VisibleStatus.NORMAL.getValue());

        customPageMapper.insertCustomPage(customPage);
    }

    void testInsertLink(){
        Link link = new Link();
        link.setLinkUrl("https://www.baidu.com");
        link.setLinkName("百度");
        link.setLinkDescription("友链测试");
        link.setLinkOwnerNickname("nic");
        link.setLinkOwnerContact("111001");
        link.setLinkCreateTime(new Date(now));
        link.setLinkUpdateTime(new Date(now));
        link.setLinkStatus(AvailableStatus.ENABLE.getValue());

        linkMapper.insertLink(link);
    }

    void testInsertMenu(){
        String testPageKey = "/test456/key/1";

        Menu menu = new Menu();
        menu.setMenuName("ceSi--menu");
        menu.setMenuType(MenuTypes.CUSTOM_PAGE.getValue());
        menu.setMenuUrl(testPageKey);

        menuMapper.insertMenu(menu);
    }



}
