package com.meeleet.cloud.sys.rpc;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.meeleet.cloud.sys.pojo.dto.SysRoleMenuDTO;

import java.util.Collection;
import java.util.List;

public interface ISysRoleMenuRpcService {

    /**
     * 插入一条记录（选择字段，策略插入）
     *
     * @param sysRoleMenuDTO 业务传输对象
     */
    boolean save(SysRoleMenuDTO sysRoleMenuDTO);

    /**
     * 插入（批量）
     *
     * @param entityList 业务传输对象集合
     */
    boolean saveBatch(Collection<SysRoleMenuDTO> sysRoleMenuDTOList);

    /**
     * 插入（批量）
     *
     * @param sysRoleMenuDTOList 业务传输对象集合
     * @param batchSize          插入批次数量
     */
    boolean saveBatch(Collection<SysRoleMenuDTO> sysRoleMenuDTOList, int batchSize);

    /**
     * 批量修改插入
     *
     * @param sysRoleMenuDTOList 业务传输对象集合
     */
    boolean saveOrUpdateBatch(Collection<SysRoleMenuDTO> sysRoleMenuDTOList);

    /**
     * 批量修改插入
     *
     * @param sysRoleMenuDTOList 业务传输对象集合
     * @param batchSize          每次的数量
     */
    boolean saveOrUpdateBatch(Collection<SysRoleMenuDTO> entityList, int batchSize);

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
    boolean updateById(SysRoleMenuDTO sysRoleMenuDTO);


    /**
     * 根据ID 批量更新
     *
     * @param sysRoleMenuDTOList 业务传输对象集合
     */
    boolean updateBatchById(Collection<SysRoleMenuDTO> sysRoleMenuDTOList);

    /**
     * 根据ID 批量更新
     *
     * @param sysRoleMenuDTOList 业务传输对象集合
     * @param batchSize          更新批次数量
     */
    boolean updateBatchById(Collection<SysRoleMenuDTO> sysRoleMenuDTOList, int batchSize);

    /**
     * TableId 注解存在更新记录，否插入一条记录
     *
     * @param sysRoleMenuDTO 业务传输对象
     */
    boolean saveOrUpdate(SysRoleMenuDTO sysRoleMenuDTO);

    /**
     * 根据 ID 查询
     *
     * @param id 主键ID
     */
    SysRoleMenuDTO findById(Long id);

    /**
     * 查询（根据ID 批量查询）
     *
     * @param idList 主键ID列表
     */
    List<SysRoleMenuDTO> listByIds(Collection<Long> idList);

    /**
     * 查询总记录数
     */
    int count();

    /**
     * 查询所有
     */
    List<SysRoleMenuDTO> list();

    /**
     * 无条件翻页查询
     * @param current 页码
     * @param size 每页大小
     */
    IPage<SysRoleMenuDTO> page(int current, int size);


    List<Long> listMenuIds(Long roleId);

    /**
     * 修改角色菜单
     *
     * @param roleId
     * @param menuIds
     * @return
     */
    boolean update(Long roleId, List<Long> menuIds);
}
