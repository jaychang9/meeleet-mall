package com.meeleet.cloud.sys.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.meeleet.cloud.sys.pojo.entity.SysPermission;
import com.meeleet.cloud.sys.pojo.query.PermissionPageQuery;
import com.meeleet.cloud.sys.pojo.vo.PermissionPageVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysPermissionMapper extends BaseMapper<SysPermission> {

    /**
     * 获取权限分页列表
     *
     * @param page
     * @param queryParams
     * @return
     */
    List<PermissionPageVO> listPermissionsWithPage(Page<PermissionPageVO> page, PermissionPageQuery queryParams);

    /**
     * 获取权限和拥有权限的角色映射
     *
     * @return
     */
    List<SysPermission> listPermRoles();

    /**
     * 根据角色编码集合获取按钮权限
     *
     * @param roles
     * @return
     */
    List<String> listBtnPermByRoles(List<String> roles);


}
