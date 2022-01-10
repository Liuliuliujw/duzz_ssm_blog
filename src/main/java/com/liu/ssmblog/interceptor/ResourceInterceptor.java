package com.liu.ssmblog.interceptor;

import com.liu.ssmblog.entity.Menu;
import com.liu.ssmblog.entity.SiteOption;
import com.liu.ssmblog.service.MenuService;
import com.liu.ssmblog.service.SiteOptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author: llliujw
 * @Description: 资源拦截器，向每个请求中添加资源信息
 */
@Component
public class ResourceInterceptor implements HandlerInterceptor {

    @Autowired
    private SiteOptionService siteOptionService;

    @Autowired
    private MenuService menuService;

    private static List<Menu> menus;

    private static SiteOption siteOption;

    /**
     * 在Controller方法执行之后执行
     *
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        request.setAttribute("menus", getMenus());
        request.setAttribute("options", getSiteOption());
        System.out.println("request:"+request);
    }

    public List<Menu> getMenus() {
        if (menus == null) {
            menus = menuService.findMenuTree();
        }
        return menus;
    }

    private SiteOption getSiteOption() {
        if (siteOption == null) {
            siteOption = siteOptionService.findSiteOption();
        }
        return siteOption;
    }

    /**
     * 在信息修改后清除缓存数据
     */
    public static void clearSiteOptionCache() {
        siteOption = null;
    }

    /**
     * 在信息修改后清除缓存数据
     */
    public static void clearMenuCache() {
        menus = null;
    }

}
