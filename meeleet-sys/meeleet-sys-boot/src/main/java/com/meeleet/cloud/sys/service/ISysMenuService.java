package com.meeleet.cloud.sys.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.meeleet.cloud.common.pojo.vo.OptionVO;
import com.meeleet.cloud.sys.pojo.entity.SysMenu;
import com.meeleet.cloud.sys.pojo.vo.MenuTableVO;
import com.meeleet.cloud.sys.pojo.vo.RouteVO;

import java.util.List;

/**
 * @author jaychang
 */
public interface ISysMenuService extends IService<SysMenu> {


    /**
     * 菜单表格(Table)层级列表
     *
     * @param name 菜单名称
     * @return
     */
    List<MenuTableVO> listTableMenus(String name);


    /**
     * 菜单下拉(Select)层级列表
     *
     * @return
     */
    List<OptionVO> listSelectMenus();

    /**
     * 新增菜单
     *
     * @param menu
     * @return
     */
    boolean saveMenu(SysMenu menu);


    /**
     * 修改菜单
     *
     * @param menu
     * @return
     */
    boolean updateMenu(SysMenu menu);

    /**
     * 获取路由列表(适配Vue3的vue-next-router)
     *
     * @return
     */
    List<RouteVO> listRoutes();
}
