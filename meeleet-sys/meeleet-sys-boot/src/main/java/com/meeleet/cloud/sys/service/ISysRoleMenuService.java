package com.meeleet.cloud.sys.service;



import com.baomidou.mybatisplus.extension.service.IService;
import com.meeleet.cloud.sys.pojo.entity.SysRoleMenu;

import java.util.List;

public interface ISysRoleMenuService extends IService<SysRoleMenu> {

    List<Long> listMenuIds(Long roleId);

    /**
     * 修改角色菜单
     * @param roleId
     * @param menuIds
     * @return
     */
    boolean update(Long roleId, List<Long> menuIds);
}
