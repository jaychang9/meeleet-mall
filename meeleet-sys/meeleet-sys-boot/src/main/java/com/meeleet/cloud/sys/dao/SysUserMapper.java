package com.meeleet.cloud.sys.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.meeleet.cloud.sys.pojo.dto.AuthUserDTO;
import com.meeleet.cloud.sys.pojo.entity.SysUser;
import com.meeleet.cloud.sys.pojo.query.UserPageQuery;
import com.meeleet.cloud.sys.pojo.vo.UserDetailVO;
import com.meeleet.cloud.sys.pojo.vo.UserExportVO;
import com.meeleet.cloud.sys.pojo.vo.UserPageVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 用户持久层
 *
 * @author jaychang
 */
@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {

    /**
     * 获取用户分页列表
     *
     * @param page
     * @param queryParams 查询参数
     * @return
     */
    // TODO 再看下这个数据权限
    // @DataPermission(deptAlias = "d")
    List<UserPageVO> listUsersPage(Page<UserPageVO> page, UserPageQuery query);

    /**
     * 获取用户表单详情
     *
     * @param userId 用户ID
     * @return
     */
    UserDetailVO getUserDetail(Long userId);

    /**
     * 根据用户名获取认证信息
     *
     * @param username
     * @return
     */
    AuthUserDTO getAuthInfoByUsername(String username);

    /**
     * 根据手机号获取认证信息
     *
     * @param username
     * @return
     */
    AuthUserDTO getAuthInfoByMobile(String mobile);

    /**
     * 获取导出用户列表
     *
     * @param queryParams
     * @return
     */
    // TODO 再看下这个数据权限
    //@DataPermission(deptAlias = "d")
    List<UserExportVO> listExportUsers(UserPageQuery queryParams);
}
