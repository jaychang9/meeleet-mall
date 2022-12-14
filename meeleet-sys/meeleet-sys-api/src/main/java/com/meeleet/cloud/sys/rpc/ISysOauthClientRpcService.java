package com.meeleet.cloud.sys.rpc;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.meeleet.cloud.sys.pojo.dto.ClientAuthDTO;
import com.meeleet.cloud.sys.pojo.dto.SysOauthClientDTO;
import java.util.Collection;
import java.util.List;

public interface ISysOauthClientRpcService {
    /**
     * 插入一条记录（选择字段，策略插入）
     *
     * @param sysOauthClientDTO 业务传输对象
     */
    boolean save(SysOauthClientDTO sysOauthClientDTO);

    /**
     * 插入（批量）
     *
     * @param entityList 业务传输对象集合
     */
    boolean saveBatch(Collection<SysOauthClientDTO> sysOauthClientDTOList);

    /**
     * 插入（批量）
     *
     * @param sysOauthClientDTOList 业务传输对象集合
     * @param batchSize  插入批次数量
     */
    boolean saveBatch(Collection<SysOauthClientDTO> sysOauthClientDTOList, int batchSize);

    /**
     * 批量修改插入
     *
     * @param sysOauthClientDTOList 业务传输对象集合
     */
    boolean saveOrUpdateBatch(Collection<SysOauthClientDTO> sysOauthClientDTOList);

    /**
     * 批量修改插入
     *
     * @param sysOauthClientDTOList 业务传输对象集合
     * @param batchSize  每次的数量
     */
    boolean saveOrUpdateBatch(Collection<SysOauthClientDTO> entityList, int batchSize);

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
    boolean updateById(SysOauthClientDTO sysOauthClientDTO);


    /**
     * 根据ID 批量更新
     *
     * @param sysOauthClientDTOList 业务传输对象集合
     */
    boolean updateBatchById(Collection<SysOauthClientDTO> sysOauthClientDTOList);

    /**
     * 根据ID 批量更新
     *
     * @param sysOauthClientDTOList 业务传输对象集合
     * @param batchSize  更新批次数量
     */
    boolean updateBatchById(Collection<SysOauthClientDTO> sysOauthClientDTOList, int batchSize);

    /**
     * TableId 注解存在更新记录，否插入一条记录
     *
     * @param sysOauthClientDTO 业务传输对象
     */
    boolean saveOrUpdate(SysOauthClientDTO sysOauthClientDTO);

    /**
     * 根据 ID 查询
     *
     * @param id 主键ID
     */
    SysOauthClientDTO findById(Long id);

    /**
     * 查询（根据ID 批量查询）
     *
     * @param idList 主键ID列表
     */
    List<SysOauthClientDTO> listByIds(Collection<Long> idList);

    /**
     * 查询总记录数
     *
     */
    long count();

    /**
     * 查询所有
     *
     */
    List<SysOauthClientDTO> list();

    /**
     * 无条件翻页查询
     *
     * @param current 页码
     * @param size 每页大小
     */
    IPage<SysOauthClientDTO> page(int current, int size);


    /**
     * 根据客户端ID查SysOauthClientDTO
     *
     * @param clientId 客户端ID
     * @return
     */
    ClientAuthDTO findOAuth2ClientById(String clientId);

    void cleanCache();
}
