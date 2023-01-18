package com.meeleet.cloud.sys.rpc;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.meeleet.cloud.sys.pojo.dto.SysUserRoleDTO;

import java.util.Collection;
import java.util.List;

public interface ISysUserRoleRpcService {
    /**
     * 插入一条记录（选择字段，策略插入）
     *
     * @param sysUserRoleDTO 业务传输对象
     */
    boolean save(SysUserRoleDTO sysUserRoleDTO);

    /**
     * 插入（批量）
     *
     * @param entityList 业务传输对象集合
     */
    boolean saveBatch(Collection<SysUserRoleDTO> sysUserRoleDTOList);

    /**
     * 插入（批量）
     *
     * @param sysUserRoleDTOList 业务传输对象集合
     * @param batchSize  插入批次数量
     */
    boolean saveBatch(Collection<SysUserRoleDTO> sysUserRoleDTOList, int batchSize);

    /**
     * 批量修改插入
     *
     * @param sysUserRoleDTOList 业务传输对象集合
     */
    boolean saveOrUpdateBatch(Collection<SysUserRoleDTO> sysUserRoleDTOList);

    /**
     * 批量修改插入
     *
     * @param sysUserRoleDTOList 业务传输对象集合
     * @param batchSize  每次的数量
     */
    boolean saveOrUpdateBatch(Collection<SysUserRoleDTO> entityList, int batchSize);

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
    boolean updateById(SysUserRoleDTO sysUserRoleDTO);


    /**
     * 根据ID 批量更新
     *
     * @param sysUserRoleDTOList 业务传输对象集合
     */
    boolean updateBatchById(Collection<SysUserRoleDTO> sysUserRoleDTOList);

    /**
     * 根据ID 批量更新
     *
     * @param sysUserRoleDTOList 业务传输对象集合
     * @param batchSize  更新批次数量
     */
    boolean updateBatchById(Collection<SysUserRoleDTO> sysUserRoleDTOList, int batchSize);

    /**
     * TableId 注解存在更新记录，否插入一条记录
     *
     * @param sysUserRoleDTO 业务传输对象
     */
    boolean saveOrUpdate(SysUserRoleDTO sysUserRoleDTO);

    /**
     * 根据 ID 查询
     *
     * @param id 主键ID
     */
    SysUserRoleDTO findById(Long id);

    /**
     * 查询（根据ID 批量查询）
     *
     * @param idList 主键ID列表
     */
    List<SysUserRoleDTO> listByIds(Collection<Long> idList);

    /**
     * 查询总记录数
     *
     */
    long count();

    /**
     * 查询所有
     *
     */
    List<SysUserRoleDTO> list();

    /**
     * 无条件翻页查询
     *
     * @param current 页码
     * @param size 每页大小
     */
    IPage<SysUserRoleDTO> page(int current, int size);


    /**
     * 根据userId查角色Code列表
     *
     * @param userId 用户ID
     * @return
     */
    List<String> listRoleCodesByUserId(Long userId);
}
