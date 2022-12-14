package com.meeleet.cloud.sys.rpc;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.meeleet.cloud.sys.pojo.dto.AuthUserDTO;
import com.meeleet.cloud.sys.pojo.dto.SysUserDTO;
import com.meeleet.cloud.sys.pojo.dto.UserDTO;
import com.meeleet.cloud.sys.pojo.query.UserPageQuery;
import com.meeleet.cloud.sys.pojo.vo.UserDetailVO;
import com.meeleet.cloud.sys.pojo.vo.UserExportVO;
import com.meeleet.cloud.sys.pojo.vo.UserPageVO;

import java.util.Collection;
import java.util.List;

/**
 * 用户业务接口
 *
 * @author jaychang
 */
public interface ISysUserRpcService {

    /**
     * 插入一条记录（选择字段，策略插入）
     *
     * @param sysUserDTO 业务传输对象
     */
    boolean save(SysUserDTO sysUserDTO);

    /**
     * 插入（批量）
     *
     * @param entityList 业务传输对象集合
     */
    boolean saveBatch(Collection<SysUserDTO> sysUserDTOList);

    /**
     * 插入（批量）
     *
     * @param sysUserDTOList 业务传输对象集合
     * @param batchSize      插入批次数量
     */
    boolean saveBatch(Collection<SysUserDTO> sysUserDTOList, int batchSize);

    /**
     * 批量修改插入
     *
     * @param sysUserDTOList 业务传输对象集合
     */
    boolean saveOrUpdateBatch(Collection<SysUserDTO> sysUserDTOList);

    /**
     * 批量修改插入
     *
     * @param sysUserDTOList 业务传输对象集合
     * @param batchSize      每次的数量
     */
    boolean saveOrUpdateBatch(Collection<SysUserDTO> entityList, int batchSize);

    /**
     * 根据 ID 删除
     *
     * @param id 主键ID
     */
    boolean removeById(Long id);

    /**
     * 删除（根据ID 批量删除）
     *
     * @param idList 主键ID列表
     */
    boolean removeByIds(Collection<Long> idList);

    /**
     * 根据 ID 选择修改
     *
     * @param entity 实体对象
     */
    boolean updateById(SysUserDTO sysUserDTO);


    /**
     * 根据ID 批量更新
     *
     * @param sysUserDTOList 业务传输对象集合
     */
    boolean updateBatchById(Collection<SysUserDTO> sysUserDTOList);

    /**
     * 根据ID 批量更新
     *
     * @param sysUserDTOList 业务传输对象集合
     * @param batchSize      更新批次数量
     */
    boolean updateBatchById(Collection<SysUserDTO> sysUserDTOList, int batchSize);

    /**
     * TableId 注解存在更新记录，否插入一条记录
     *
     * @param sysUserDTO 业务传输对象
     */
    boolean saveOrUpdate(SysUserDTO sysUserDTO);

    /**
     * 根据 ID 查询
     *
     * @param id 主键ID
     */
    SysUserDTO findById(Long id);

    /**
     * 查询（根据ID 批量查询）
     *
     * @param idList 主键ID列表
     */
    List<SysUserDTO> listByIds(Collection<Long> idList);

    /**
     * 查询总记录数
     */
    long count();

    /**
     * 查询所有
     */
    List<SysUserDTO> list();

    /**
     * 无条件翻页查询
     *
     * @param current 页码
     * @param size    每页大小
     */
    IPage<SysUserDTO> page(int current, int size);

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
     * @param userId   用户ID
     * @param userForm 用户表单对象
     * @return
     */
    boolean updateUser(Long userId, UserDTO userDTO);

    /**
     * 根据用户名获取认证信息
     *
     * @param username
     * @return
     */
    AuthUserDTO findAuthInfoByUsername(String username);

    /**
     * 根据用户名获取认证信息
     *
     * @param username
     * @return
     */
    AuthUserDTO findAuthInfoByMobile(String mobile);

    /**
     * 根据用户ID获取用户详情
     *
     * @param userId
     * @return
     */
    UserDetailVO findUserDetail(Long userId);

    /**
     * 获取导出用户列表
     *
     * @param queryParams
     * @return
     */
    List<UserExportVO> listExportUsers(UserPageQuery queryParams);
}
