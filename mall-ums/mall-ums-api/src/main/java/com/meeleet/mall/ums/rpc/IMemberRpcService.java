package com.meeleet.mall.ums.rpc;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.meeleet.mall.ums.pojo.dto.MemberAuthInfoDTO;
import com.meeleet.mall.ums.pojo.dto.MemberDTO;

import java.util.Collection;
import java.util.List;

/**
 * 会员Dubbo服务
 */
public interface IMemberRpcService {
    /**
     * 插入一条记录（选择字段，策略插入）
     *
     * @param memberDTO 业务传输对象
     */
    boolean save(MemberDTO memberDTO);

    /**
     * 插入（批量）
     *
     * @param memberList 业务传输对象集合
     */
    boolean saveBatch(Collection<MemberDTO> memberDTOList);

    /**
     * 插入（批量）
     *
     * @param memberList 业务传输对象集合
     * @param batchSize        插入批次数量
     */
    boolean saveBatch(Collection<MemberDTO> memberDTOList, int batchSize);

    /**
     * 批量修改插入
     *
     * @param memberList 业务传输对象集合
     */
    boolean saveOrUpdateBatch(Collection<MemberDTO> memberDTOList);

    /**
     * 批量修改插入
     *
     * @param memberList 业务传输对象集合
     * @param batchSize        每次的数量
     */
    boolean saveOrUpdateBatch(Collection<MemberDTO> memberDTOList, int batchSize);

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
    boolean updateById(MemberDTO memberDTO);


    /**
     * 根据ID 批量更新
     *
     * @param memberDTOList 业务传输对象集合
     */
    boolean updateBatchById(Collection<MemberDTO> memberDTOList);

    /**
     * 根据ID 批量更新
     *
     * @param memberDTOList 业务传输对象集合
     * @param batchSize        更新批次数量
     */
    boolean updateBatchById(Collection<MemberDTO> memberDTOList, int batchSize);

    /**
     * TableId 注解存在更新记录，否插入一条记录
     *
     * @param memberDTO 业务传输对象
     */
    boolean saveOrUpdate(MemberDTO memberDTO);

    /**
     * 根据 ID 查询
     *
     * @param id 主键ID
     */
    MemberDTO findById(Long id);

    /**
     * 查询（根据ID 批量查询）
     *
     * @param idList 主键ID列表
     */
    List<MemberDTO> listByIds(Collection<Long> idList);

    /**
     * 查询总记录数
     */
    int count();

    /**
     * 查询所有
     */
    List<MemberDTO> list();

    /**
     * 无条件翻页查询
     *
     * @param current 页码
     * @param size    每页大小
     */
    IPage<MemberDTO> page(int current, int size);

    /**
     * 新增会员
     *
     * @param member
     * @return
     */
    Long addMember(MemberDTO memberDTO);

    /**
     * 获取会员的 openid
     *
     * @return
     */
    String findMemberOpenId(Long memberId);

    /**
     * 根据openId获取会员认证信息
     *
     * @param openid
     * @return
     */
    MemberAuthInfoDTO loadUserByOpenid(String openid);

    /**
     * 根据手机号获取会员认证信息
     *
     * @param mobile
     * @return
     */
    MemberAuthInfoDTO loadUserByMobile(String mobile);

    /**
     * 根据用户名获取会员认证信息
     *
     * @param username
     * @return
     */
    MemberAuthInfoDTO loadUserByUsername(String username);
}
