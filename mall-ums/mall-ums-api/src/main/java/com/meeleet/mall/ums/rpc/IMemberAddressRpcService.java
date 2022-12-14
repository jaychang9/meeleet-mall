package com.meeleet.mall.ums.rpc;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.meeleet.mall.ums.pojo.dto.MemberAddressDTO;

import java.util.Collection;
import java.util.List;

public interface IMemberAddressRpcService {
    /**
     * 插入一条记录（选择字段，策略插入）
     *
     * @param umsMemberAddressDTO 业务传输对象
     */
    boolean save(MemberAddressDTO memberAddressDTO);

    /**
     * 插入（批量）
     *
     * @param entityList 业务传输对象集合
     */
    boolean saveBatch(Collection<MemberAddressDTO> memberAddressList);

    /**
     * 插入（批量）
     *
     * @param umsMemberAddressDTOList 业务传输对象集合
     * @param batchSize               插入批次数量
     */
    boolean saveBatch(Collection<MemberAddressDTO> umsMemberAddressDTOList, int batchSize);

    /**
     * 批量修改插入
     *
     * @param umsMemberAddressDTOList 业务传输对象集合
     */
    boolean saveOrUpdateBatch(Collection<MemberAddressDTO> umsMemberAddressDTOList);

    /**
     * 批量修改插入
     *
     * @param umsMemberAddressDTOList 业务传输对象集合
     * @param batchSize               每次的数量
     */
    boolean saveOrUpdateBatch(Collection<MemberAddressDTO> umsMemberAddressDTOList, int batchSize);

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
    boolean updateById(MemberAddressDTO umsMemberAddressDTO);


    /**
     * 根据ID 批量更新
     *
     * @param umsMemberAddressDTOList 业务传输对象集合
     */
    boolean updateBatchById(Collection<MemberAddressDTO> umsMemberAddressDTOList);

    /**
     * 根据ID 批量更新
     *
     * @param umsMemberAddressDTOList 业务传输对象集合
     * @param batchSize               更新批次数量
     */
    boolean updateBatchById(Collection<MemberAddressDTO> umsMemberAddressDTOList, int batchSize);

    /**
     * TableId 注解存在更新记录，否插入一条记录
     *
     * @param umsMemberAddressDTO 业务传输对象
     */
    boolean saveOrUpdate(MemberAddressDTO umsMemberAddressDTO);

    /**
     * 根据 ID 查询
     *
     * @param id 主键ID
     */
    MemberAddressDTO findById(Long id);

    /**
     * 查询（根据ID 批量查询）
     *
     * @param idList 主键ID列表
     */
    List<MemberAddressDTO> listByIds(Collection<Long> idList);

    /**
     * 查询总记录数
     */
    long count();

    /**
     * 查询所有
     */
    List<MemberAddressDTO> list();

    /**
     * 无条件翻页查询
     *
     * @param current 页码
     * @param size    每页大小
     */
    IPage<MemberAddressDTO> page(int current, int size);

    /**
     * 获取当前会员地址列表
     *
     * @param memberId 会员ID
     * @return
     */
    List<MemberAddressDTO> listCurrMemberAddresses(Long memberId);
}
