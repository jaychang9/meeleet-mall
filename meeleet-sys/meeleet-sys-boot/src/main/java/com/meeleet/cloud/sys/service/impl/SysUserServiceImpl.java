package com.meeleet.cloud.sys.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.lang.Assert;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.meeleet.cloud.sys.constant.SystemConstants;
import com.meeleet.cloud.sys.dao.SysUserMapper;
import com.meeleet.cloud.sys.pojo.dto.AuthUserDTO;
import com.meeleet.cloud.sys.pojo.dto.UserDTO;
import com.meeleet.cloud.sys.pojo.entity.SysUser;
import com.meeleet.cloud.sys.pojo.entity.SysUserRole;
import com.meeleet.cloud.sys.pojo.query.UserPageQuery;
import com.meeleet.cloud.sys.pojo.vo.UserDetailVO;
import com.meeleet.cloud.sys.pojo.vo.UserExportVO;
import com.meeleet.cloud.sys.pojo.vo.UserPageVO;
import com.meeleet.cloud.sys.service.ISysUserRoleService;
import com.meeleet.cloud.sys.service.ISysUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 用户业务实现类
 *
 * @author jaychang
 */
@Service
@RequiredArgsConstructor
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(11);
    private final ISysUserRoleService iSysUserRoleService;

    /**
     * 获取用户分页列表
     *
     * @param queryParams
     * @return
     */
    @Override
    public IPage<UserPageVO> listUsersPage(UserPageQuery queryParams) {
        Page<UserPageVO> page = new Page<>(queryParams.getCurrent(), queryParams.getSize());
        List<UserPageVO> list = this.baseMapper.listUsersPage(page, queryParams);
        page.setRecords(list);
        return page;
    }

    /**
     * 新增用户
     *
     * @param userForm 用户表单对象
     * @return
     */
    @Override
    public boolean saveUser(UserDTO userForm) {

        SysUser user = new SysUser();
        BeanUtil.copyProperties(userForm, user);

        user.setPassword(passwordEncoder.encode(SystemConstants.DEFAULT_USER_PASSWORD)); // 初始化默认密码
        boolean result = this.save(user);
        if (result) {
            Long userId = user.getId();
            List<Long> roleIds = user.getRoleIds();
            List<SysUserRole> sysUserRoles = Optional.ofNullable(roleIds).orElse(new ArrayList<>())
                    .stream().map(roleId -> new SysUserRole(userId, roleId))
                    .collect(Collectors.toList());
            if (CollectionUtil.isNotEmpty(sysUserRoles)) {
                iSysUserRoleService.saveBatch(sysUserRoles);
            }
        }
        return result;
    }

    /**
     * 更新用户
     *
     * @param userId   用户ID
     * @param userForm 用户表单对象
     * @return
     */
    @Override
    @Transactional
    public boolean updateUser(Long userId, UserDTO userForm) {
        SysUser user = this.getById(userId);
        Assert.isTrue(user != null, "用户不存在或已被删除");

        // 用户旧角色ID集合
        List<Long> oldRoleIds = iSysUserRoleService.list(new LambdaQueryWrapper<SysUserRole>()
                .eq(SysUserRole::getUserId, userId))
                .stream()
                .map(item -> item.getRoleId())
                .collect(Collectors.toList());

        // 用户新角色ID集合
        List<Long> newRoleIds = userForm.getRoleIds();

        // 新增的用户角色
        List<Long> addRoleIds = newRoleIds.stream().filter(roleId -> !oldRoleIds.contains(roleId)).collect(Collectors.toList());
        List<SysUserRole> addUserRoles = Optional.ofNullable(addRoleIds).orElse(new ArrayList<>())
                .stream().map(roleId -> new SysUserRole(userId, roleId))
                .collect(Collectors.toList());
        iSysUserRoleService.saveBatch(addUserRoles);

        // 删除的用户角色
        List<Long> removeRoleIds = oldRoleIds.stream().filter(roleId -> !newRoleIds.contains(roleId)).collect(Collectors.toList());
        if (CollectionUtil.isNotEmpty(removeRoleIds)) {
            iSysUserRoleService.remove(new LambdaQueryWrapper<SysUserRole>()
                    .eq(SysUserRole::getUserId, userId)
                    .in(SysUserRole::getRoleId, removeRoleIds)
            );
        }

        BeanUtil.copyProperties(userForm, user);

        boolean updateRes = this.updateById(user);
        return updateRes;
    }

    /**
     * 根据用户名获取认证信息
     *
     * @param username
     * @return
     */
    @Override
    public AuthUserDTO getAuthInfoByUsername(String username) {
        AuthUserDTO userAuthInfo = this.baseMapper.getAuthInfoByUsername(username);
        return userAuthInfo;
    }

    @Override
    public AuthUserDTO getAuthInfoByMobile(String mobile) {
        AuthUserDTO userAuthInfo = this.baseMapper.getAuthInfoByMobile(mobile);
        return userAuthInfo;
    }

    /**
     * 获取用户表单详情
     *
     * @param userId
     * @return
     */
    @Override
    public UserDetailVO getUserDetail(Long userId) {
        UserDetailVO userDetail = this.baseMapper.getUserDetail(userId);
        return userDetail;
    }

    /**
     * 获取导出用户列表
     *
     * @param queryParams
     * @return
     */
    @Override
    public List<UserExportVO> listExportUsers(UserPageQuery queryParams) {
        List<UserExportVO> list = this.baseMapper.listExportUsers(queryParams);
        return list;
    }

}
