package com.meeleet.cloud.sys.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.lang.Assert;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.meeleet.cloud.sys.dao.SysRolePermissionMapper;
import com.meeleet.cloud.sys.pojo.dto.RolePermsDTO;
import com.meeleet.cloud.sys.pojo.entity.SysRolePermission;
import com.meeleet.cloud.sys.service.ISysRolePermissionService;
import org.apache.commons.collections4.ListUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 角色权限实现类
 */
@Service
public class SysRolePermissionServiceImpl extends ServiceImpl<SysRolePermissionMapper, SysRolePermission> implements ISysRolePermissionService {


    /**
     * 根据菜单ID和角色ID获取权限ID集合
     *
     * @param menuId
     * @param roleId
     * @return
     */
    @Override
    public List<Long> listPermIds(Long menuId, Long roleId) {
        return this.baseMapper.listPermIds(menuId, roleId);
    }

    /**
     * 保存角色权限
     *
     * @return
     */
    @Override
    public boolean saveRolePerms(RolePermsDTO rolePermsDTO) {

        Long menuId = rolePermsDTO.getMenuId();
        Long roleId = rolePermsDTO.getRoleId();
        List<Long> permIds = rolePermsDTO.getPermIds();

        List<Long> oldPermIds = this.listPermIds(menuId, roleId);

        // 验证权限数据是否改变
        List<Long> sortedPermIds = permIds.stream().sorted().collect(Collectors.toList());
        List<Long> sortedOldPermIds = oldPermIds.stream().sorted().collect(Collectors.toList());

        boolean permDataChangeFlag = !ListUtils.isEqualList(sortedPermIds, sortedOldPermIds);
        Assert.isTrue(permDataChangeFlag, "提交失败，权限数据无改动！");

        // 删除此次保存移除的权限
        boolean updateFlag = false;
        if (CollectionUtil.isNotEmpty(oldPermIds)) {
            List<Long> removePermIds = oldPermIds.stream().filter(id -> !permIds.contains(id)).collect(Collectors.toList());
            if (CollectionUtil.isNotEmpty(removePermIds)) {
                updateFlag = this.remove(new LambdaQueryWrapper<SysRolePermission>()
                        .eq(SysRolePermission::getRoleId, roleId)
                        .in(SysRolePermission::getPermissionId, removePermIds));
            }
        }

        // 新增数据库不存在的权限
        if (CollectionUtil.isNotEmpty(permIds)) {
            List<Long> newPermIds = permIds.stream().filter(id -> !oldPermIds.contains(id)).collect(Collectors.toList());
            if (CollectionUtil.isNotEmpty(newPermIds)) {
                List<SysRolePermission> rolePerms = new ArrayList<>();
                for (Long permId : newPermIds) {
                    SysRolePermission rolePerm = new SysRolePermission(roleId, permId);
                    rolePerms.add(rolePerm);
                }
                updateFlag = this.saveBatch(rolePerms);
            }
        }
        return updateFlag;
    }


}
