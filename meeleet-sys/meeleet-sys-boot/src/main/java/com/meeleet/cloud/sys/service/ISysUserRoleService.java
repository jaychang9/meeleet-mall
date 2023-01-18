package com.meeleet.cloud.sys.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.meeleet.cloud.sys.pojo.entity.SysUserRole;

import java.util.List;

public interface ISysUserRoleService extends IService<SysUserRole> {
    List<String> listRoleCodesByUserId(Long userId);
}
