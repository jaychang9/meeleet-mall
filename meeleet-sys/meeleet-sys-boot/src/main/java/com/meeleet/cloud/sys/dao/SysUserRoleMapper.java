package com.meeleet.cloud.sys.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.meeleet.cloud.sys.pojo.entity.SysUserRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户角色持久层
 *
 * @author jaychang
 */
@Mapper
public interface SysUserRoleMapper extends BaseMapper<SysUserRole> {

    /**
     * 根据userId查角色Code列表
     *
     * @param userId
     * @return
     */
    List<String> selectRoleCodesByUserId(@Param("userId") Long userId);
}
