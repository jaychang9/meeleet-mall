package com.meeleet.cloud.sys.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.meeleet.cloud.sys.pojo.dto.AuthUserDTO;
import com.meeleet.cloud.sys.pojo.dto.UserDTO;
import com.meeleet.cloud.sys.pojo.entity.SysUser;
import com.meeleet.cloud.sys.pojo.query.UserPageQuery;
import com.meeleet.cloud.sys.pojo.vo.UserDetailVO;
import com.meeleet.cloud.sys.pojo.vo.UserExportVO;
import com.meeleet.cloud.sys.pojo.vo.UserPageVO;

import java.util.List;

/**
 * 用户业务接口
 *
 * @author jaychang
 */
public interface ISysUserService extends IService<SysUser> {

    /**
     * 用户分页列表
     *
     * @return
     */
    IPage<UserPageVO> listUsersPage(UserPageQuery queryParams);

    /**
     * 新增用户
     *
     * @param userDTO 用户表单对象
     * @return
     */
    boolean saveUser(UserDTO userDTO);

    /**
     * 修改用户
     *
     * @param userId 用户ID
     * @param userForm 用户表单对象
     * @return
     */
    boolean updateUser(Long userId,UserDTO userDTO);

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
     * @param mobile
     * @return
     */
    AuthUserDTO getAuthInfoByMobile(String mobile);

    /**
     * 根据用户ID获取用户详情
     *
     * @param userId
     * @return
     */
    UserDetailVO getUserDetail(Long userId);

    /**
     * 获取导出用户列表
     *
     * @param queryParams
     * @return
     */
    List<UserExportVO> listExportUsers(UserPageQuery queryParams);
}
