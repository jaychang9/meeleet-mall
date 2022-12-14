package com.meeleet.cloud.sys.rpc;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.meeleet.cloud.common.pojo.vo.OptionVO;
import com.meeleet.cloud.sys.pojo.dto.SysDeptDTO;
import com.meeleet.cloud.sys.pojo.vo.DeptVO;

import java.util.Collection;
import java.util.List;

/**
 * 菜单路由业务接口
 *
 * @author jaychang
 */
public interface ISysDeptRpcService {


    /**
     * 插入一条记录（选择字段，策略插入）
     *
     * @param sysDeptDTO 业务传输对象
     */
    boolean save(SysDeptDTO sysDeptDTO);

    /**
     * 插入（批量）
     *
     * @param entityList 业务传输对象集合
     */
    boolean saveBatch(Collection<SysDeptDTO> sysDeptDTOList);

    /**
     * 插入（批量）
     *
     * @param sysDeptDTOList 业务传输对象集合
     * @param batchSize      插入批次数量
     */
    boolean saveBatch(Collection<SysDeptDTO> sysDeptDTOList, int batchSize);

    /**
     * 批量修改插入
     *
     * @param sysDeptDTOList 业务传输对象集合
     */
    boolean saveOrUpdateBatch(Collection<SysDeptDTO> sysDeptDTOList);

    /**
     * 批量修改插入
     *
     * @param sysDeptDTOList 业务传输对象集合
     * @param batchSize      每次的数量
     */
    boolean saveOrUpdateBatch(Collection<SysDeptDTO> sysDeptDTOList, int batchSize);

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
    boolean updateById(SysDeptDTO sysDeptDTO);


    /**
     * 根据ID 批量更新
     *
     * @param sysDeptDTOList 业务传输对象集合
     */
    boolean updateBatchById(Collection<SysDeptDTO> sysDeptDTOList);

    /**
     * 根据ID 批量更新
     *
     * @param sysDeptDTOList 业务传输对象集合
     * @param batchSize      更新批次数量
     */
    boolean updateBatchById(Collection<SysDeptDTO> sysDeptDTOList, int batchSize);

    /**
     * TableId 注解存在更新记录，否插入一条记录
     *
     * @param sysDeptDTO 业务传输对象
     */
    boolean saveOrUpdate(SysDeptDTO sysDeptDTO);

    /**
     * 根据 ID 查询
     *
     * @param id 主键ID
     */
    SysDeptDTO findById(Long id);

    /**
     * 查询（根据ID 批量查询）
     *
     * @param idList 主键ID列表
     */
    List<SysDeptDTO> listByIds(Collection<Long> idList);

    /**
     * 查询总记录数
     */
    long count();

    /**
     * 查询所有
     */
    List<SysDeptDTO> list();

    /**
     * 无条件翻页查询
     *
     * @param current 页码
     * @param size    每页大小
     */
    IPage<SysDeptDTO> page(int current, int size);

    /**
     * 部门表格（Table）层级列表
     *
     * @param status 部门状态： 1-开启 0-禁用
     * @param name
     * @return
     */
    List<DeptVO> listTableDepartments(Integer status, String name);

    /**
     * 部门树形下拉（TreeSelect）层级列表
     *
     * @return
     */
    List<OptionVO> listTreeSelectDepartments();

    /**
     * 新增/修改部门
     *
     * @param dept
     * @return
     */
    Long saveDept(SysDeptDTO sysDeptDTO);

    /**
     * 删除部门
     *
     * @param ids 部门ID，多个以英文逗号,拼接字符串
     * @return
     */
    boolean deleteByIds(String ids);
}
