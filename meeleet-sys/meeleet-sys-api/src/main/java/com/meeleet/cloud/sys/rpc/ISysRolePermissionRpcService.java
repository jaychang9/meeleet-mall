package com.meeleet.cloud.sys.rpc;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.meeleet.cloud.sys.pojo.dto.RolePermsDTO;
import com.meeleet.cloud.sys.pojo.dto.SysRolePermissionDTO;

import java.util.Collection;
import java.util.List;

/**
 * 角色权限接口
 */
public interface ISysRolePermissionRpcService {


    /**
     * 插入一条记录（选择字段，策略插入）
     *
     * @param sysRolePermissionDTO 业务传输对象
     */
    boolean save(SysRolePermissionDTO sysRolePermissionDTO);

    /**
     * 插入（批量）
     *
     * @param entityList 业务传输对象集合
     */
    boolean saveBatch(Collection<SysRolePermissionDTO> sysRolePermissionDTOList);

    /**
     * 插入（批量）
     *
     * @param sysRolePermissionDTOList 业务传输对象集合
     * @param batchSize        插入批次数量
     */
    boolean saveBatch(Collection<SysRolePermissionDTO> sysRolePermissionDTOList, int batchSize);

    /**
     * 批量修改插入
     *
     * @param sysRolePermissionDTOList 业务传输对象集合
     */
    boolean saveOrUpdateBatch(Collection<SysRolePermissionDTO> sysRolePermissionDTOList);

    /**
     * 批量修改插入
     *
     * @param sysRolePermissionDTOList 业务传输对象集合
     * @param batchSize        每次的数量
     */
    boolean saveOrUpdateBatch(Collection<SysRolePermissionDTO> entityList, int batchSize);

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
    boolean updateById(SysRolePermissionDTO sysRolePermissionDTO);


    /**
     * 根据ID 批量更新
     *
     * @param sysRolePermissionDTOList 业务传输对象集合
     */
    boolean updateBatchById(Collection<SysRolePermissionDTO> sysRolePermissionDTOList);

    /**
     * 根据ID 批量更新
     *
     * @param sysRolePermissionDTOList 业务传输对象集合
     * @param batchSize        更新批次数量
     */
    boolean updateBatchById(Collection<SysRolePermissionDTO> sysRolePermissionDTOList, int batchSize);

    /**
     * TableId 注解存在更新记录，否插入一条记录
     *
     * @param sysRolePermissionDTO 业务传输对象
     */
    boolean saveOrUpdate(SysRolePermissionDTO sysRolePermissionDTO);

    /**
     * 根据 ID 查询
     *
     * @param id 主键ID
     */
    SysRolePermissionDTO findById(Long id);

    /**
     * 查询（根据ID 批量查询）
     *
     * @param idList 主键ID列表
     */
    List<SysRolePermissionDTO> listByIds(Collection<Long> idList);

    /**
     * 查询总记录数
     */
    int count();

    /**
     * 查询所有
     */
    List<SysRolePermissionDTO> list();

    /**
     * 无条件翻页查询
     *
     * @param current 页码
     * @param size 每页大小
     *
     */
    IPage<SysRolePermissionDTO> page(int current , int size);

    /**
     * 根据菜单ID和角色ID获取权限ID集合
     *
     * @param menuId
     * @param roleId
     * @return
     */
    List<Long> listPermIds(Long menuId, Long roleId);


    /**
     * 保存角色的权限
     *
     * @return
     */
    boolean saveRolePerms(RolePermsDTO rolePermsDTO);
}
