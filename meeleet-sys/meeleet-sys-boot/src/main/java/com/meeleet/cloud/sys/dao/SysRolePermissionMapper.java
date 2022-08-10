package com.meeleet.cloud.sys.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.meeleet.cloud.sys.pojo.entity.SysRolePermission;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysRolePermissionMapper extends BaseMapper<SysRolePermission> {


    /**
     * 根据菜单ID和角色ID获取权限ID集合
     *
     * @param menuId
     * @param roleId
     * @return
     */
    List<Long> listPermIds(Long menuId, Long roleId);
}
