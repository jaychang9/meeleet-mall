package com.meeleet.cloud.sys.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.meeleet.cloud.sys.pojo.entity.SysPermission;
import com.meeleet.cloud.sys.pojo.query.PermissionPageQuery;
import com.meeleet.cloud.sys.pojo.vo.PermissionPageVO;

import java.util.List;

/**
 * 权限业务接口
 *
 * @author jaychang
 */
public interface ISysPermissionService extends IService<SysPermission> {

    List<SysPermission> listPermRoles();

    /**
     * 根据角色编码集合获取按钮权限标识
     *
     * @param roles 角色权限编码集合
     * @return
     */
    List<String> listBtnPermByRoles(List<String> roles);

    /**
     * 刷新Redis缓存中角色菜单的权限规则，角色和菜单信息变更调用
     */
    boolean refreshPermRolesRules();

    /**
     * 获取权限分页列表
     *
     * @param permissionPageQuery
     * @return
     */
    IPage<PermissionPageVO> listPermissionsWithPage(PermissionPageQuery permissionPageQuery);
}
