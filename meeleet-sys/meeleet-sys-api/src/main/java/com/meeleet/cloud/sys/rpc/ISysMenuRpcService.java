package com.meeleet.cloud.sys.rpc;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.meeleet.cloud.common.pojo.vo.OptionVO;
import com.meeleet.cloud.sys.pojo.dto.SysMenuDTO;
import com.meeleet.cloud.sys.pojo.vo.MenuTableVO;
import com.meeleet.cloud.sys.pojo.vo.NextRouteVO;

import java.util.Collection;
import java.util.List;

/**
 * @author jaychang
 */
public interface ISysMenuRpcService {

    /**
     * 插入一条记录（选择字段，策略插入）
     *
     * @param sysMenuDTO 业务传输对象
     */
    boolean save(SysMenuDTO sysMenuDTO);

    /**
     * 插入（批量）
     *
     * @param entityList 业务传输对象集合
     */
    boolean saveBatch(Collection<SysMenuDTO> sysMenuDTOList);

    /**
     * 插入（批量）
     *
     * @param sysMenuDTOList 业务传输对象集合
     * @param batchSize  插入批次数量
     */
    boolean saveBatch(Collection<SysMenuDTO> sysMenuDTOList, int batchSize);

    /**
     * 批量修改插入
     *
     * @param sysMenuDTOList 业务传输对象集合
     */
    boolean saveOrUpdateBatch(Collection<SysMenuDTO> sysMenuDTOList);

    /**
     * 批量修改插入
     *
     * @param sysMenuDTOList 业务传输对象集合
     * @param batchSize  每次的数量
     */
    boolean saveOrUpdateBatch(Collection<SysMenuDTO> entityList, int batchSize);

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
    boolean updateById(SysMenuDTO sysMenuDTO);


    /**
     * 根据ID 批量更新
     *
     * @param sysMenuDTOList 业务传输对象集合
     */
    boolean updateBatchById(Collection<SysMenuDTO> sysMenuDTOList);

    /**
     * 根据ID 批量更新
     *
     * @param sysMenuDTOList 业务传输对象集合
     * @param batchSize  更新批次数量
     */
    boolean updateBatchById(Collection<SysMenuDTO> sysMenuDTOList, int batchSize);

    /**
     * TableId 注解存在更新记录，否插入一条记录
     *
     * @param sysMenuDTO 业务传输对象
     */
    boolean saveOrUpdate(SysMenuDTO sysMenuDTO);

    /**
     * 根据 ID 查询
     *
     * @param id 主键ID
     */
    SysMenuDTO findById(Long id);

    /**
     * 查询（根据ID 批量查询）
     *
     * @param idList 主键ID列表
     */
    List<SysMenuDTO> listByIds(Collection<Long> idList);

    /**
     * 查询总记录数
     *
     */
    int count();

    /**
     * 查询所有
     *
     */
    List<SysMenuDTO> list();

    /**
     * 无条件翻页查询
     *
     * @param current 页码
     * @param size 每页大小
     */
    IPage<SysMenuDTO> page(int current,int size);


    /**
     * 菜单表格(Table)层级列表
     *
     * @param name 菜单名称
     * @return
     */
    List<MenuTableVO> listTableMenus(String name);


    /**
     * 菜单下拉(Select)层级列表
     *
     * @return
     */
    List<OptionVO> listSelectMenus();

    /**
     * 新增菜单
     *
     * @param menu
     * @return
     */
    boolean saveMenu(SysMenuDTO menu);


    /**
     * 修改菜单
     *
     * @param menu
     * @return
     */
    boolean updateMenu(SysMenuDTO menu);

    /**
     * 清理路由缓存
     */
    void cleanCache();

    /**
     * 获取路由列表(适配Vue3的vue-next-router)
     *
     * @return
     */
    List<NextRouteVO> listNextRoutes();
}
