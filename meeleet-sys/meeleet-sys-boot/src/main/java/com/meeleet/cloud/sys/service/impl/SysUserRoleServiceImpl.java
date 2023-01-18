package com.meeleet.cloud.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.meeleet.cloud.sys.dao.SysUserRoleMapper;
import com.meeleet.cloud.sys.pojo.entity.SysUserRole;
import com.meeleet.cloud.sys.service.ISysUserRoleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleMapper, SysUserRole> implements ISysUserRoleService {

    @Override
    public List<String> listRoleCodesByUserId(Long userId) {
        return baseMapper.selectRoleCodesByUserId(userId);
    }
}
