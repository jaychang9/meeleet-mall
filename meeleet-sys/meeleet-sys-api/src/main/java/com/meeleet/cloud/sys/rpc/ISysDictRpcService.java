package com.meeleet.cloud.sys.rpc;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.meeleet.cloud.sys.pojo.dto.SysDictDTO;

import java.util.Collection;
import java.util.List;

/**
 * 字典业务接口
 */
public interface ISysDictRpcService {

    /**
     * 插入一条记录（选择字段，策略插入）
     *
     * @param sysDictDTO 业务传输对象
     */
    boolean save(SysDictDTO sysDictDTO);

    /**
     * 插入（批量）
     *
     * @param entityList 业务传输对象集合
     */
    boolean saveBatch(Collection<SysDictDTO> sysDictDTOList);

    /**
     * 插入（批量）
     *
     * @param sysDictDTOList 业务传输对象集合
     * @param batchSize      插入批次数量
     */
    boolean saveBatch(Collection<SysDictDTO> sysDictDTOList, int batchSize);

    /**
     * 批量修改插入
     *
     * @param sysDictDTOList 业务传输对象集合
     */
    boolean saveOrUpdateBatch(Collection<SysDictDTO> sysDictDTOList);

    /**
     * 批量修改插入
     *
     * @param sysDictDTOList 业务传输对象集合
     * @param batchSize      每次的数量
     */
    boolean saveOrUpdateBatch(Collection<SysDictDTO> entityList, int batchSize);

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
    boolean updateById(SysDictDTO sysDictDTO);


    /**
     * 根据ID 批量更新
     *
     * @param sysDictDTOList 业务传输对象集合
     */
    boolean updateBatchById(Collection<SysDictDTO> sysDictDTOList);

    /**
     * 根据ID 批量更新
     *
     * @param sysDictDTOList 业务传输对象集合
     * @param batchSize      更新批次数量
     */
    boolean updateBatchById(Collection<SysDictDTO> sysDictDTOList, int batchSize);

    /**
     * TableId 注解存在更新记录，否插入一条记录
     *
     * @param sysDictDTO 业务传输对象
     */
    boolean saveOrUpdate(SysDictDTO sysDictDTO);

    /**
     * 根据 ID 查询
     *
     * @param id 主键ID
     */
    SysDictDTO findById(Long id);

    /**
     * 查询（根据ID 批量查询）
     *
     * @param idList 主键ID列表
     */
    List<SysDictDTO> listByIds(Collection<Long> idList);

    /**
     * 查询总记录数
     */
    long count();

    /**
     * 查询所有
     */
    List<SysDictDTO> list();

    /**
     * 无条件翻页查询
     *
     * @param current 页码
     * @param size    每页大小
     */
    IPage<SysDictDTO> page(int current, int size);

    /**
     * 修改字典
     *
     * @param dict
     * @return
     */
    boolean updateDictById(Long id, SysDictDTO dict);

    /**
     * @param ids
     * @return
     */
    boolean deleteDictByIds(String ids);
}
