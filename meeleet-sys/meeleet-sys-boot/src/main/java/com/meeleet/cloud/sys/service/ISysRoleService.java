package com.meeleet.cloud.sys.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.meeleet.cloud.sys.pojo.entity.SysRole;

import java.util.List;

public interface ISysRoleService extends IService<SysRole> {

    boolean delete(List<Long> ids);
}
