package com.meeleet.cloud.sys.rpc;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.meeleet.cloud.sys.pojo.dto.SysRoleDTO;

import java.util.Collection;
import java.util.List;

public interface ISysRoleRpcService {

    /**
     * 插入一条记录（选择字段，策略插入）
     *
     * @param sysRoleDTO 业务传输对象
     */
    boolean save(SysRoleDTO sysRoleDTO);

    /**
     * 插入（批量）
     *
     * @param sysRoleDTOList 业务传输对象集合
     */
    boolean saveBatch(Collection<SysRoleDTO> sysRoleDTOList);

    /**
     * 插入（批量）
     *
     * @param sysRoleDTOList 业务传输对象集合
     * @param batchSize      插入批次数量
     */
    boolean saveBatch(Collection<SysRoleDTO> sysRoleDTOList, int batchSize);

    /**
     * 批量修改插入
     *
     * @param sysRoleDTOList 业务传输对象集合
     */
    boolean saveOrUpdateBatch(Collection<SysRoleDTO> sysRoleDTOList);

    /**
     * 批量修改插入
     *
     * @param sysRoleDTOList 业务传输对象集合
     * @param batchSize      每次的数量
     */
    boolean saveOrUpdateBatch(Collection<SysRoleDTO> entityList, int batchSize);

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
    boolean updateById(SysRoleDTO sysRoleDTO);


    /**
     * 根据ID 批量更新
     *
     * @param sysRoleDTOList 业务传输对象集合
     */
    boolean updateBatchById(Collection<SysRoleDTO> sysRoleDTOList);

    /**
     * 根据ID 批量更新
     *
     * @param sysRoleDTOList 业务传输对象集合
     * @param batchSize      更新批次数量
     */
    boolean updateBatchById(Collection<SysRoleDTO> sysRoleDTOList, int batchSize);

    /**
     * TableId 注解存在更新记录，否插入一条记录
     *
     * @param sysRoleDTO 业务传输对象
     */
    boolean saveOrUpdate(SysRoleDTO sysRoleDTO);

    /**
     * 根据 ID 查询
     *
     * @param id 主键ID
     */
    SysRoleDTO findById(Long id);

    /**
     * 查询（根据ID 批量查询）
     *
     * @param idList 主键ID列表
     */
    List<SysRoleDTO> listByIds(Collection<Long> idList);

    /**
     * 查询总记录数
     */
    int count();

    /**
     * 查询所有
     */
    List<SysRoleDTO> list();

    /**
     * 无条件翻页查询
     *
     * @param current 页码
     * @param size    每页大小
     */
    IPage<SysRoleDTO> page(int current, int size);


    boolean delete(List<Long> ids);
}
