package com.meeleet.cloud.sys.rpc;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.meeleet.cloud.sys.pojo.dto.SysDictItemDTO;
import com.meeleet.cloud.sys.pojo.query.SysDictItemPageQuery;

import java.util.Collection;
import java.util.List;

public interface ISysDictItemRpcService {

    /**
     * 插入一条记录（选择字段，策略插入）
     *
     * @param sysDictItemDTO 业务传输对象
     */
    boolean save(SysDictItemDTO sysDictItemDTO);

    /**
     * 插入（批量）
     *
     * @param sysDictItemDTOList 业务传输对象集合
     */
    boolean saveBatch(Collection<SysDictItemDTO> sysDictItemDTOList);

    /**
     * 批量修改插入
     *
     * @param sysDictItemDTOList 业务传输对象集合
     * @param batchSize      每次的数量
     */
    boolean saveBatch(Collection<SysDictItemDTO> sysDictItemDTOList, int batchSize);

    /**
     * 批量修改插入
     *
     * @param sysDictItemDTOList 业务传输对象集合
     */
    boolean saveOrUpdateBatch(Collection<SysDictItemDTO> sysDictItemDTOList);

    /**
     * 批量修改插入
     *
     * @param sysDictItemDTOList 业务传输对象集合
     * @param batchSize 每批次大小
     */
    boolean saveOrUpdateBatch(Collection<SysDictItemDTO> sysDictItemDTOList, int batchSize);

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
    boolean updateById(SysDictItemDTO sysDictItemDTO);


    /**
     * 根据ID 批量更新
     *
     * @param sysDictItemDTOList 业务传输对象集合
     */
    boolean updateBatchById(Collection<SysDictItemDTO> sysDictItemDTOList);

    /**
     * 根据ID 批量更新
     *
     * @param sysDictItemDTOList 业务传输对象集合
     * @param batchSize  更新批次数量
     */
    boolean updateBatchById(Collection<SysDictItemDTO> sysDictItemDTOList, int batchSize);

    /**
     * TableId 注解存在更新记录，否插入一条记录
     *
     * @param sysDictItemDTO 业务传输对象
     */
    boolean saveOrUpdate(SysDictItemDTO sysDictItemDTO);

    /**
     * 根据 ID 查询
     *
     * @param id 主键ID
     */
    SysDictItemDTO findById(Long id);

    /**
     * 查询（根据ID 批量查询）
     *
     * @param idList 主键ID列表
     */
    List<SysDictItemDTO> listByIds(Collection<Long> idList);

    /**
     * 查询总记录数
     *
     */
    long count();

    /**
     * 查询所有
     *
     */
    List<SysDictItemDTO> list();

    /**
     * 无条件翻页查询
     *
     * @param current 页码
     * @param size 每页大小
     */
    IPage<SysDictItemDTO> page(int current, int size);

    /**
     * 有条件分页查询
     *
     * @param pageQuery
     * @return
     */
    IPage<SysDictItemDTO> page(SysDictItemPageQuery pageQuery);

}
